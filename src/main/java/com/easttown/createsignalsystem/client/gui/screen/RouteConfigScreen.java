package com.easttown.createsignalsystem.client.gui.screen;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.config.RouteConfiguration;
import com.easttown.createsignalsystem.network.ConfigureRoutePacket;
import com.easttown.createsignalsystem.network.NetworkHandler;
import com.simibubi.create.foundation.gui.AbstractSimiScreen;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.gui.UIRenderHelper;
import com.simibubi.create.foundation.gui.widget.AbstractSimiWidget;
import com.simibubi.create.foundation.gui.widget.IconButton;
import com.simibubi.create.foundation.gui.widget.Label;
import com.simibubi.create.foundation.gui.widget.SelectionScrollInput;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.HashMap;
import java.util.Map;
import com.easttown.createsignalsystem.client.widget.NumericSlider;
import com.easttown.createsignalsystem.config.TurnAction;
import com.simibubi.create.content.trains.entity.TravellingPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteConfigScreen extends AbstractSimiScreen {

    private final SignalStateDisplayBlockEntity blockEntity;
    private final BlockPos blockPos;
    private final Map<Integer, RouteConfiguration> routeConfigs;
    private final Map<Integer, Integer> signalMappings;
    private final Minecraft minecraft;

    private IconButton saveButton;
    private IconButton cancelButton;
    private IconButton defaultButton;
    private TabButton[] tabButtons;
    private int currentTab = 0;

    // 进路配置标签页的UI组件存储
    private Map<Integer, EditBox> displayNumberBoxes = new HashMap<>();
    private Map<Integer, EditBox> displayNameBoxes = new HashMap<>();
    private Map<Integer, NumericSlider[]> turnSliders = new HashMap<>();
    private long lastSaveTime = 0;
    private static final long SAVE_DEBOUNCE_MS = 1000; // 1秒防抖

    // 所有滑条列表，用于渲染和事件处理
    private List<NumericSlider> allSliders = new ArrayList<>();

    // 防止递归保存的标志
    private boolean isSaving = false;

    // 当前标签页内选中的进路（用于进路配置标签页）
    private int selectedRouteInTab = 1;

    // 标签页定义
    private static final int TAB_DETAILS = 0; // 详情标签页
    private static final int TAB_ROUTE_1_3 = 1; // 进路1-3配置
    private static final int TAB_ROUTE_4_6 = 2; // 进路4-6配置
    private static final int TAB_ROUTE_7 = 3; // 进路7配置

    // TAB_MAPPING 已移除，信号映射集成到进路配置中

    public RouteConfigScreen(SignalStateDisplayBlockEntity blockEntity) {
        super(Components.literal("四显示信号机进路配置"));
        this.blockEntity = blockEntity;
        this.blockPos = blockEntity.getBlockPos();
        this.minecraft = Minecraft.getInstance();
        this.routeConfigs = new HashMap<>(blockEntity.getAllRouteConfigs());
        this.signalMappings = new HashMap<>(blockEntity.getAllSignalMappings());
    }

    @Override
    protected void init() {
        super.init();

        // 初始化标签页按钮数组（但不创建按钮实例）
        tabButtons = new TabButton[5];

        // 初始化当前标签页的内容（会创建所有按钮）
        initTabContent();
    }

    @Override
    protected void renderWindow(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int guiLeft = (width - 256) / 2;
        int guiTop = (height - 166) / 2;

        // 绘制背景
        AllGuiTextures.PLAYER_INVENTORY.render(graphics, guiLeft, guiTop);

        // 绘制标题
        graphics.drawString(font, title, guiLeft + 15, guiTop + 15, 0x442000, false);

        // 绘制当前标签页内容
        renderTabContent(graphics, mouseX, mouseY, partialTicks);

        // 绘制状态信息
        String statusText = "位置: " + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ();
        graphics.drawString(font, statusText, guiLeft + 15, guiTop + 30, 0x666666, false);
    }

    private void initTabContent() {
        // 计算GUI位置
        int guiLeft = (width - 256) / 2;
        int guiTop = (height - 166) / 2;

        // 清除所有之前的UI组件（包括按钮）
        clearWidgets();

        // 重新创建标签页按钮（4个：详情、进路1-3、进路4-6、进路7）
        String[] tabLabels = {"详情", "进路1-3", "进路4-6", "进路7"};
        Component[] tabTooltips = {
                Components.literal("显示信号机基本信息和状态"),
                Components.literal("配置进路1-3的转向规则"),
                Components.literal("配置进路4-6的转向规则"),
                Components.literal("配置进路7的转向规则")
        };

        for (int i = 0; i < 4; i++) {
            tabButtons[i] = new TabButton(guiLeft + 10 + i * 45, guiTop - 20, tabLabels[i]);
            final int tabIndex = i;
            tabButtons[i].withCallback(() -> switchTab(tabIndex));
            tabButtons[i].setToolTip(tabTooltips[i]);
            addRenderableWidget(tabButtons[i]);
        }
        tabButtons[currentTab].active = false;

        // 重新创建操作按钮
        saveButton = new IconButton(guiLeft + 180, guiTop + 140, AllIcons.I_CONFIRM);
        saveButton.withCallback(this::saveAndClose);
        saveButton.setToolTip(Components.literal("保存配置并关闭"));
        addRenderableWidget(saveButton);

        cancelButton = new IconButton(guiLeft + 210, guiTop + 140, AllIcons.I_DISABLE);
        cancelButton.withCallback(this.minecraft.player::closeContainer);
        cancelButton.setToolTip(Components.literal("取消更改并关闭"));
        addRenderableWidget(cancelButton);

        defaultButton = new IconButton(guiLeft + 150, guiTop + 140, AllIcons.I_REFRESH);
        defaultButton.withCallback(this::restoreDefaults);
        defaultButton.setToolTip(Components.literal("恢复默认配置"));
        addRenderableWidget(defaultButton);

        // 清除标签页内容相关的引用
        allSliders.clear();
        displayNumberBoxes.clear();
        displayNameBoxes.clear();
        turnSliders.clear();

        // 根据当前标签页初始化内容
        switch (currentTab) {
            case TAB_DETAILS:
                initDetailsTab();
                break;
            case TAB_ROUTE_1_3:
                initRouteTab(1, 3);
                break;
            case TAB_ROUTE_4_6:
                initRouteTab(4, 6);
                break;
            case TAB_ROUTE_7:
                initRoute7Tab();
                break;
        }
    }

    private void renderTabContent(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int guiLeft = (width - 256) / 2;
        int guiTop = (height - 166) / 2;

        switch (currentTab) {
            case TAB_DETAILS:
                renderDetailsTab(graphics, guiLeft, guiTop);
                break;
            case TAB_ROUTE_1_3:
            case TAB_ROUTE_4_6:
            case TAB_ROUTE_7:
                // 进路配置标签页 - 手动渲染所有滑条
                for (NumericSlider slider : allSliders) {
                    slider.render(graphics, mouseX, mouseY, partialTicks);
                }
                // 其他UI组件（输入框等）会自动渲染
                break;
            default:
                // 其他标签页暂不实现
                graphics.drawString(font, "进路配置功能开发中...", guiLeft + 50, guiTop + 50, 0x442000, false);
                break;
        }
    }

    private void initDetailsTab() {
        int guiLeft = (width - 256) / 2;
        int guiTop = (height - 166) / 2;

        // 显示信号机基本信息
        // 这里可以添加标签显示当前状态等
    }

    private void initRouteTab(int startRoute, int endRoute) {
        int guiLeft = (width - 256) / 2;
        int guiTop = (height - 166) / 2;

        // 清除之前的组件映射
        displayNumberBoxes.clear();
        displayNameBoxes.clear();
        turnSliders.clear();
        allSliders.clear();

        // 如果只有一个进路，直接显示
        if (startRoute == endRoute) {
            selectedRouteInTab = startRoute;
            initSingleRoute(guiLeft, guiTop, startRoute);
            return;
        }

        // 多个进路：显示导航和当前选中进路
        // 确保选中进路在范围内
        if (selectedRouteInTab < startRoute || selectedRouteInTab > endRoute) {
            selectedRouteInTab = startRoute;
        }

        // 进路导航标签
        String navText = "进路 " + selectedRouteInTab + " / " + startRoute + "-" + endRoute;
        Label navLabel = new Label(guiLeft + 20, guiTop + 20, Component.literal(navText));
        navLabel.text = Component.literal(navText); // 重新设置文本
        addRenderableWidget(navLabel);
        // 上一个按钮
        IconButton prevButton = new IconButton(guiLeft + 120, guiTop + 18, AllIcons.I_MTD_LEFT);
        prevButton.withCallback(() -> {
            if (selectedRouteInTab > startRoute) {
                selectedRouteInTab--;
                // 重新初始化当前标签页
                initTabContent();
            }
        });
        prevButton.setToolTip(Components.literal("上一个进路"));
        addRenderableWidget(prevButton);

        // 下一个按钮
        IconButton nextButton = new IconButton(guiLeft + 140, guiTop + 18, AllIcons.I_MTD_RIGHT);
        nextButton.withCallback(() -> {
            if (selectedRouteInTab < endRoute) {
                selectedRouteInTab++;
                // 重新初始化当前标签页
                initTabContent();
            }
        });
        nextButton.setToolTip(Components.literal("下一个进路"));
        addRenderableWidget(nextButton);

        // 显示当前选中进路的配置
        initSingleRoute(guiLeft, guiTop + 64, selectedRouteInTab);
    }

    private void initSingleRoute(int guiLeft, int y, int routeId) {
        // 获取或创建进路配置
        RouteConfiguration config = routeConfigs.get(routeId);
        if (config == null) {
            config = RouteConfiguration.createDefaultRoute(routeId);
            routeConfigs.put(routeId, config);
        }
        final RouteConfiguration finalConfig = config;

        // 进路标题
        String routeTitle = "进路 " + routeId;
        Label titleLabel = new Label(guiLeft + 20, y, Component.literal(routeTitle));
        titleLabel.text = Component.literal(routeTitle);
        addRenderableWidget(titleLabel);

        // 显示编号输入框
        EditBox numberBox = new EditBox(font, guiLeft + 80, y, 40, 16, Components.literal("编号"));
        numberBox.setValue(config.getDisplayNumber());
        numberBox.setMaxLength(20);
        numberBox.setResponder(text -> {
            finalConfig.setDisplayNumber(text);
            scheduleSave();
        });
        displayNumberBoxes.put(routeId, numberBox);
        addRenderableWidget(numberBox);

        // 显示名称输入框
        EditBox nameBox = new EditBox(font, guiLeft + 130, y, 100, 16, Components.literal("名称"));
        nameBox.setValue(config.getDisplayName());
        nameBox.setMaxLength(20);
        nameBox.setResponder(text -> {
            finalConfig.setDisplayName(text);
            scheduleSave();
        });
        displayNameBoxes.put(routeId, nameBox);
        addRenderableWidget(nameBox);

        // 4个道岔转向滑条
        NumericSlider[] sliders = new NumericSlider[4];
        TurnAction[] turnActions = config.getTurnActions();

        for (int i = 0; i < 4; i++) {
            int sliderY = y + 20 + i * 22;
            int junctionIndex = i + 1;

            // 滑条标签（简化）
            Label sliderLabel = new Label(guiLeft + 20, sliderY, Component.literal(junctionIndex + ":"));
            sliderLabel.text = Component.literal(routeTitle);
            addRenderableWidget(sliderLabel);

            // 创建滑条（带图标）
            List<AllIcons> directionIcons = Arrays.asList(
                    AllIcons.I_ROTATE_PLACE, // 左转
                    AllIcons.I_REFRESH, // 直行
                    AllIcons.I_CART_ROTATE // 右转
            );
            NumericSlider slider = new NumericSlider(guiLeft + 80, sliderY, 45, 14, 2, directionIcons); // 3个位置：左转/直行/右转
            slider.setIconMode(true);
            slider.setDarkIconMode(true);
            slider.setShowLabel(false); // 隐藏滑条内部的标签文本

            // 设置当前值
            TurnAction action = turnActions[i];
            if (action != null) {
                slider.setCurrentValue(getDirectionValue(action.getDirection()));
            } else {
                slider.setCurrentValue(1); // 默认直行
            }

            final int routeIdFinal = routeId;
            final int actionIndex = i;
            slider.setOnValueChanged((newValue) -> {
                TurnAction currentAction = turnActions[actionIndex];
                if (currentAction == null) {
                    currentAction = new TurnAction(junctionIndex, getDirectionFromValue(newValue));
                    turnActions[actionIndex] = currentAction;
                } else {
                    currentAction.setDirection(getDirectionFromValue(newValue));
                }
                scheduleSave();
            });
            allSliders.add(slider);

            sliders[i] = slider;
        }

        turnSliders.put(routeId, sliders);
    }

    private void initRoute7Tab() {
        // 初始化进路7标签页 - 复用initRouteTab方法
        initRouteTab(7, 7);
    }

    private void initMappingTab() {
        // 初始化信号映射标签页
        int guiLeft = (width - 256) / 2;
        int guiTop = (height - 166) / 2;

        // 可以添加标签说明
        Label mappingLabel = new Label(guiLeft + 20, guiTop + 50, Component.literal("红石信号映射配置"));
        mappingLabel.text = Component.literal("红石信号映射配置");
        addRenderableWidget(mappingLabel);
    }

    private void renderDetailsTab(GuiGraphics graphics, int guiLeft, int guiTop) {
        // 绘制详情标签页内容
        graphics.drawString(font, "四显示信号机详情", guiLeft + 20, guiTop + 50, 0x442000, false);

        // 显示当前状态
        String currentRoute = "当前进路: " + blockEntity.getCurrentRoute();
        String forceRed = blockEntity.isForceRed() ? "强制红灯: 是" : "强制红灯: 否";
        String signalState = "信号状态: " + blockEntity.getFourAspectState().getDisplayName();

        graphics.drawString(font, currentRoute, guiLeft + 25, guiTop + 70, 0x666666, false);
        graphics.drawString(font, forceRed, guiLeft + 25, guiTop + 85, 0x666666, false);
        graphics.drawString(font, signalState, guiLeft + 25, guiTop + 100, 0x666666, false);

        // 显示信号组占用状态
        graphics.drawString(font, "区间占用状态:", guiLeft + 25, guiTop + 120, 0x442000, false);
        boolean[] occupancyStates = blockEntity.getOccupancyStates();
        for (int i = 0; i < occupancyStates.length; i++) {
            String status = "区间 " + i + ": " + (occupancyStates[i] ? "占用" : "空闲");
            int color = occupancyStates[i] ? 0xFF5555 : 0x55AA55;
            graphics.drawString(font, status, guiLeft + 40, guiTop + 135 + i * 15, color, false);
        }
    }

    private void renderMappingTab(GuiGraphics graphics, int guiLeft, int guiTop) {
        // 绘制信号映射标签页内容
        graphics.drawString(font, "红石信号到进路映射", guiLeft + 20, guiTop + 50, 0x442000, false);
        graphics.drawString(font, "红石信号强度1-15映射到进路0-7", guiLeft + 25, guiTop + 70, 0x666666, false);
        graphics.drawString(font, "0:强制红灯, 1-7:进路槽位", guiLeft + 25, guiTop + 85, 0x666666, false);

        // 显示当前映射关系
        graphics.drawString(font, "当前映射关系:", guiLeft + 25, guiTop + 110, 0x442000, false);

        for (int signal = 1; signal <= 15; signal++) {
            int target = signalMappings.getOrDefault(signal, signal <= 6 ? signal : 0);
            String mapping = "信号" + signal + " → " + (target == 0 ? "强制红灯" : "进路" + target);
            graphics.drawString(font, mapping, guiLeft + 40, guiTop + 125 + (signal - 1) * 12, 0x666666, false);
        }
    }

    private void switchTab(int newTab) {
        // 切换标签页时自动保存当前标签页的配置
        saveCurrentTabConfig();

        // 更新标签页按钮状态
        tabButtons[currentTab].active = true;
        currentTab = newTab;
        tabButtons[currentTab].active = false;

        // 清除旧的UI组件
        // clearWidgets(); // AbstractSimiScreen可能会自动处理

        // 重新初始化UI
        init();
    }

    // 方向值转换工具方法
    private int getDirectionValue(TravellingPoint.SteerDirection direction) {
        switch (direction) {
            case LEFT:
                return 0;
            case NONE:
                return 1;
            case RIGHT:
                return 2;
            default:
                return 1;
        }
    }

    private TravellingPoint.SteerDirection getDirectionFromValue(int value) {
        switch (value) {
            case 0:
                return TravellingPoint.SteerDirection.LEFT;
            case 1:
                return TravellingPoint.SteerDirection.NONE;
            case 2:
                return TravellingPoint.SteerDirection.RIGHT;
            default:
                return TravellingPoint.SteerDirection.NONE;
        }
    }

    private void scheduleSave() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSaveTime > SAVE_DEBOUNCE_MS) {
            saveCurrentTabConfig();
            lastSaveTime = currentTime;
        }
    }

    private void saveCurrentTabConfig() {
        // 保存当前标签页的配置
        // 配置已经在UI组件的回调中实时更新，这里确保同步
        if (currentTab == TAB_ROUTE_1_3) {
            // 进路1-3配置标签页
            for (int routeId = 1; routeId <= 3; routeId++) {
                // 确保显示编号和名称已更新
                EditBox numberBox = displayNumberBoxes.get(routeId);
                EditBox nameBox = displayNameBoxes.get(routeId);
                if (numberBox != null && nameBox != null) {
                    RouteConfiguration config = routeConfigs.get(routeId);
                    if (config != null) {
                        config.setDisplayNumber(numberBox.getValue());
                        config.setDisplayName(nameBox.getValue());
                    }
                }
                // 滑条方向值已经在回调中更新，无需额外处理
            }
        } else if (currentTab == TAB_ROUTE_4_6) {
            // 进路4-6配置标签页
            for (int routeId = 4; routeId <= 6; routeId++) {
                EditBox numberBox = displayNumberBoxes.get(routeId);
                EditBox nameBox = displayNameBoxes.get(routeId);
                if (numberBox != null && nameBox != null) {
                    RouteConfiguration config = routeConfigs.get(routeId);
                    if (config != null) {
                        config.setDisplayNumber(numberBox.getValue());
                        config.setDisplayName(nameBox.getValue());
                    }
                }
            }
        } else if (currentTab == TAB_ROUTE_7) {
            // 进路7配置标签页
            int routeId = 7;
            EditBox numberBox = displayNumberBoxes.get(routeId);
            EditBox nameBox = displayNameBoxes.get(routeId);
            if (numberBox != null && nameBox != null) {
                RouteConfiguration config = routeConfigs.get(routeId);
                if (config != null) {
                    config.setDisplayNumber(numberBox.getValue());
                    config.setDisplayName(nameBox.getValue());
                }
            }
        }
    }

    private void saveAndClose() {
        // 防止递归调用
        if (isSaving) {
            return;
        }
        isSaving = true;

        try {
            // 保存所有配置到服务器
            ConfigureRoutePacket packet = new ConfigureRoutePacket(blockPos, routeConfigs, signalMappings);
            NetworkHandler.CHANNEL.sendToServer(packet);

            minecraft.player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal("§a配置已保存到服务器"),
                    false
            );

            // 关闭屏幕
            minecraft.player.closeContainer();
        } finally {
            isSaving = false;
        }
    }

    private void restoreDefaults() {
        // 恢复默认配置
        routeConfigs.clear();
        signalMappings.clear();

        // 重新加载默认配置
        for (int routeId = 1; routeId <= 7; routeId++) {
            routeConfigs.put(routeId, RouteConfiguration.createDefaultRoute(routeId));
        }

        for (int signal = 1; signal <= 15; signal++) {
            signalMappings.put(signal, signal <= 6 ? signal : 0);
        }

        // 重新初始化UI
        // clearWidgets(); // AbstractSimiScreen可能会自动处理
        init();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void removed() {
        super.removed();
        // 屏幕关闭时自动保存
        saveCurrentTabConfig();
        saveAndClose();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean handled = super.mouseClicked(mouseX, mouseY, button);
        // 只处理左键点击（button == 0），确保右键操作优先级更高
        if (button == 0) {
            for (NumericSlider slider : allSliders) {
                if (slider.mouseClicked(mouseX, mouseY, button)) {
                    handled = true;
                }
            }
        }
        return handled;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        boolean handled = super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        for (NumericSlider slider : allSliders) {
            if (slider.mouseDragged(mouseX, mouseY, button, deltaX, deltaY)) {
                handled = true;
            }
        }
        return handled;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        boolean handled = super.mouseReleased(mouseX, mouseY, button);
        for (NumericSlider slider : allSliders) {
            if (slider.mouseReleased(mouseX, mouseY, button)) {
                handled = true;
            }
        }
        return handled;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        boolean handled = super.mouseScrolled(mouseX, mouseY, delta);
        for (NumericSlider slider : allSliders) {
            if (slider.mouseScrolled(mouseX, mouseY, delta)) {
                handled = true;
            }
        }
        return handled;
    }

    @Override
    public void tick() {
        super.tick();
        for (NumericSlider slider : allSliders) {
            slider.tick();
        }
    }

    // 自定义标签页按钮类
    private static class TabButton extends IconButton {
        private final String label;

        public TabButton(int x, int y, String label) {
            super(x, y, AllIcons.I_PRIORITY_VERY_HIGH);
            this.label = label;
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
            super.render(graphics, mouseX, mouseY, partialTicks);
            // 绘制标签文本
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
            int textColor = active ? 0xFFFFFF : 0xAAAAAA;
            int textX = getX() + (getWidth() - mc.font.width(label)) / 2;
            int textY = getY() + getHeight() - 10;
            graphics.drawString(mc.font, label, textX, textY, textColor, false);
        }
    }



}