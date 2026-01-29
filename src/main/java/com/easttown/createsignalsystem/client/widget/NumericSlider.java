package com.easttown.createsignalsystem.client.widget;

import com.simibubi.create.foundation.gui.AllGuiTextures;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.gui.UIRenderHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 统一滑动条组件 合并 AdaptiveSlider 和 CreateStyleIconSlider 的功能 使用 Create 模组的纹理和工具类，完全还原 Create 滑动条的外观和交互
 * 支持任意格子数量（maxValue 决定），图标模式，里程碑间隔
 */
@OnlyIn(Dist.CLIENT)
public class NumericSlider {
    private static final Logger LOGGER = LogManager.getLogger();

    // 位置和尺寸
    private int x;
    private int y;
    private int width;
    private int height;

    // 常量
    private static final int TRACK_HEIGHT = 8; // 轨道高度，匹配Create的VALUE_SETTINGS_BAR纹理高度

    // 边框相关常量
    private static final int BORDER_THICKNESS = 3;
    private static final int TOTAL_BORDER_WIDTH = BORDER_THICKNESS * 2;

    // 内边距常量
    private static final int PADDING_LEFT = 4;
    private static final int PADDING_RIGHT = 4;
    private static final int PADDING_TOP = 3;

    // 里程碑尺寸常量
    private static final int MILESTONE_WIDTH_NORMAL = 7;
    private static final int MILESTONE_WIDTH_WIDE = 13;
    private static final int MILESTONE_HEIGHT = 8;

    // 最小高度常量
    private static final int MIN_HEIGHT = TOTAL_BORDER_WIDTH + TRACK_HEIGHT; // 14

    // 数据配置
    private int minValue = 0;
    private int maxValue; // 最大值，决定格子数量（格子数 = maxValue + 1）
    private int currentValue;
    private int milestoneInterval = 1; // 里程碑间隔
    private boolean iconMode = false; // 是否图标模式
    private int scale = 1; // 缩放因子，根据maxValue计算，用于坐标计算
    private int step = 1; // 滑动步长（滚轮和键盘操作时的增量）
    private float dragSensitivity = 1.0f; // 拖动灵敏度（1.0为默认）
    private int numericModeCursorWidth = 56; // 非图标模式下光标中间部分宽度（可调整）

    // 图标系统（支持 AllIcons 和 ResourceLocation）
    private final List<Object> icons; // 图标列表，可以是 AllIcons 或 ResourceLocation

    // 显示配置
    private boolean showBorder = true;
    private boolean showLabel = true;
    private Component labelText = null;
    private Component tooltipText = null;


    // 图标颜色模式：true为深色（Create原版风格），false为浅色
    private boolean darkIconMode = true;

    // 交互状态
    private boolean isHovered = false;
    private boolean dragging = false;
    private int dragStartX;
    private int dragStartValue;
    private int soundCoolDown = 0; // 声音冷却计时器

    // 声音配置
    private SoundEvent scrollSound = SoundEvents.UI_BUTTON_CLICK.get();

    // 回调
    private Consumer<Integer> onValueChanged = null;

    // Minecraft 资源
    private final Minecraft minecraft;
    private final Font font;

    // 计算缓存
    private int[] cachedPositions = null;
    private boolean positionsDirty = true;

    // ==================== 构造函数 ====================

    /** 构造函数 - 指定格子数量（maxValue） */
    public NumericSlider(int x, int y, int width, int height, int maxValue) {
        this(x, y, width, height, maxValue, new ArrayList<>());
    }

    /** 构造函数 - 指定格子数量和 AllIcons 图标列表 */
    public NumericSlider(int x, int y, int width, int height, int maxValue, List<AllIcons> icons) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxValue = Math.max(0, maxValue);
        this.currentValue = 0;
        this.scale = maxValue > 128 ? 1 : 2; // 根据Create逻辑计算缩放因子

        // 初始化图标列表
        this.icons = new ArrayList<>();
        if (icons != null) {
            int iconCount = Math.min(maxValue + 1, icons.size());
            for (int i = 0; i < iconCount; i++) {
                this.icons.add(icons.get(i));
            }
        }
        // 如果图标数量不足，用 null 填充
        while (this.icons.size() < maxValue + 1) {
            this.icons.add(null);
        }

        // 如果提供了图标，自动启用图标模式
        if (!icons.isEmpty()) {
            this.iconMode = true;
        }

        this.minecraft = Minecraft.getInstance();
        this.font = minecraft.font;

        // 验证参数
        validateParameters();

        // 标记位置缓存需要更新
        positionsDirty = true;
    }

    /** 构造函数 - 指定格子数量和 ResourceLocation 图标列表 */
    public NumericSlider(int x, int y, int width, int height, int maxValue, List<
                    ResourceLocation> icons, boolean isResourceLocation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxValue = Math.max(0, maxValue);
        this.currentValue = 0;
        this.scale = maxValue > 128 ? 1 : 2; // 根据Create逻辑计算缩放因子

        // 初始化图标列表
        this.icons = new ArrayList<>();
        if (icons != null) {
            int iconCount = Math.min(maxValue + 1, icons.size());
            for (int i = 0; i < iconCount; i++) {
                this.icons.add(icons.get(i));
            }
        }
        // 如果图标数量不足，用 null 填充
        while (this.icons.size() < maxValue + 1) {
            this.icons.add(null);
        }

        // 如果提供了图标，自动启用图标模式
        if (!icons.isEmpty()) {
            this.iconMode = true;
        }

        this.minecraft = Minecraft.getInstance();
        this.font = minecraft.font;

        // 验证参数
        validateParameters();

        // 标记位置缓存需要更新
        positionsDirty = true;
    }

    // ==================== 辅助方法 ====================

    /** 验证滑动条尺寸是否符合要求 */
    private void validateDimensions() {
        // 验证高度
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("高度必须至少" + MIN_HEIGHT + "像素");
        }

        // 验证宽度
        int milestoneWidth = iconMode ? MILESTONE_WIDTH_WIDE : MILESTONE_WIDTH_NORMAL;
        int minWidth = TOTAL_BORDER_WIDTH + milestoneWidth * (maxValue + 1);

        if (width < minWidth) {
            throw new IllegalArgumentException("宽度必须至少" + minWidth + "像素");
        }
    }

    /** 验证所有参数，防止精度问题和其他异常 */
    private void validateParameters() {
        // 1. 基础参数检查
        if (maxValue < 0) {
            throw new IllegalArgumentException("maxValue不能为负数: " + maxValue);
        }

        if (maxValue == 0 && (width - 6) < 0) {
            throw new IllegalArgumentException("maxValue为0时，宽度必须至少6像素（仅边框）");
        }

        // 2. 浮点精度问题检查
        if (maxValue > 0) {
            // 检查是否会导致浮点除法精度问题
            // 例如：maxValue过大或width与maxValue比例不协调
            int trackWidth = width - TOTAL_BORDER_WIDTH; // 左右内边距各3像素（总共6像素）
            if (trackWidth / (maxValue + 1) < 1) {
                // 每个格子宽度小于1像素，会导致严重的精度问题
                throw new IllegalArgumentException(
                    "每个格子的宽度小于1像素，会导致渲染精度问题。" +
                    "请增加宽度或减少maxValue。当前宽度：" + width +
                    "，maxValue：" + maxValue +
                    "，每个格子宽度：" + (float)trackWidth/(maxValue+1) + "像素"
                );
            }
        }

        // 3. 尺寸验证
        validateDimensions();
    }

    /** 更新位置缓存（如果标记为脏） */
    private void updateCachedPositionsIfNeeded() {
        if (!positionsDirty) return;

        int count = maxValue + 1;
        cachedPositions = new int[count];

        // 轨道可用宽度（左右各3像素边框内边距）
        int trackWidth = width - BORDER_THICKNESS * 2;
        int textureWidth = iconMode ? MILESTONE_WIDTH_WIDE : MILESTONE_WIDTH_NORMAL;

        if (count == 1) {
            // 只有一个值：在轨道中心
            int renderX = x + BORDER_THICKNESS + (trackWidth - textureWidth) / 2;
            // 中心坐标 = 渲染位置 + 纹理宽度/2（四舍五入处理奇数纹理宽度）
            cachedPositions[0] = renderX + (int) Math.round(textureWidth / 2.0f);
        } else {
            // 第一个里程碑：左上角在 x + 3
            int firstRenderX = x + BORDER_THICKNESS;
            // 中心坐标 = 左上角 + 纹理宽度/2（四舍五入处理奇数纹理宽度）
            cachedPositions[0] = firstRenderX + (int) Math.round(textureWidth / 2.0f);

            // 最后一个里程碑：左上角在 x + width - 3 - textureWidth
            int lastRenderX = x + width - BORDER_THICKNESS - textureWidth;
            cachedPositions[maxValue] = lastRenderX + (int) Math.round(textureWidth / 2.0f);

            // 中间里程碑：在第一个和最后一个渲染位置之间均匀分布
            if (count > 2) {
                double spacing = (double)(lastRenderX - firstRenderX) / maxValue;
                for (int i = 1; i < maxValue; i++) {
                    int renderX = firstRenderX + (int) Math.round(i * spacing);
                    cachedPositions[i] = renderX + (int) Math.round(textureWidth / 2.0f); // 中心坐标
                }
            }
        }

        positionsDirty = false;
    }

    /** 根据值获取对应的 X 坐标 */
    private float getCoordinateOfValue(int value) {
        updateCachedPositionsIfNeeded();
        int index = Math.max(0, Math.min(maxValue, value));
        return cachedPositions[index];
    }

    /** 获取离鼠标最近的格子索引 */
    private int getClosestColumn(int mouseX) {
        updateCachedPositionsIfNeeded();
        int bestIndex = 0;
        double bestDiff = Double.MAX_VALUE;

        for (int i = 0; i < cachedPositions.length; i++) {
            double diff = Math.abs(cachedPositions[i] - mouseX);
            if (diff < bestDiff) {
                bestDiff = diff;
                bestIndex = i;
            }
        }
        return Math.max(minValue, Math.min(maxValue, bestIndex));
    }

    // ==================== 获取和设置方法 ====================

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        positionsDirty = true;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        validateParameters();
        positionsDirty = true;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        validateParameters();
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
        if (currentValue < minValue) {
            setCurrentValue(minValue);
        }
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = Math.max(minValue, maxValue);
        this.scale = maxValue > 128 ? 1 : 2; // 更新缩放因子
        validateParameters();
        if (currentValue > maxValue) {
            setCurrentValue(maxValue);
        }
        positionsDirty = true;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int value) {
        int clamped = Math.max(minValue, Math.min(maxValue, value));
        if (clamped != currentValue) {
            int oldValue = currentValue;
            currentValue = clamped;

            // 记录值变化
            LOGGER.info("滑动条值变化: {} -> {} (范围: {} - {})", oldValue, currentValue, minValue, maxValue);

            // 播放声音效果
            if (soundCoolDown == 0 && maxValue > 0) {
                float pitch = (currentValue) / (float) (maxValue);
                pitch = Mth.lerp(pitch, 1.15f, 1.5f);
                minecraft.getSoundManager()
                        .play(SimpleSoundInstance.forUI(scrollSound, pitch, 0.25F));
                soundCoolDown = 1;
            }

            if (onValueChanged != null) {
                onValueChanged.accept(currentValue);
            }
        }
    }

    public int getMilestoneInterval() {
        return milestoneInterval;
    }

    public void setMilestoneInterval(int interval) {
        this.milestoneInterval = Math.max(1, interval);
    }

    public boolean isIconMode() {
        return iconMode;
    }

    public void setIconMode(boolean iconMode) {
        this.iconMode = iconMode;
        validateParameters();
        positionsDirty = true;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = Math.max(1, step);
    }

    public float getDragSensitivity() {
        return dragSensitivity;
    }

    public void setDragSensitivity(float dragSensitivity) {
        this.dragSensitivity = Math.max(0.1f, Math.min(10.0f, dragSensitivity));
    }

    public Object getCurrentIcon() {
        if (currentValue >= 0 && currentValue < icons.size()) {
            return icons.get(currentValue);
        }
        return null;
    }

    public List<Object> getIcons() {
        return new ArrayList<>(icons);
    }

    public void setIcon(int index, AllIcons icon) {
        if (index >= 0 && index <= maxValue) {
            while (icons.size() <= index) {
                icons.add(null);
            }
            icons.set(index, icon);
        }
    }

    public void setIcon(int index, ResourceLocation icon) {
        if (index >= 0 && index <= maxValue) {
            while (icons.size() <= index) {
                icons.add(null);
            }
            icons.set(index, icon);
        }
    }







    public boolean isDarkIconMode() {
        return darkIconMode;
    }

    public void setDarkIconMode(boolean darkIconMode) {
        this.darkIconMode = darkIconMode;
    }

    public int getNumericModeCursorWidth() {
        return numericModeCursorWidth;
    }

    public void setNumericModeCursorWidth(int numericModeCursorWidth) {
        this.numericModeCursorWidth = Math.max(0, numericModeCursorWidth);
    }

    // 显示选项
    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }

    public boolean isShowLabel() {
        return showLabel;
    }

    public void setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
    }

    public Component getLabelText() {
        return labelText;
    }

    public void setLabelText(Component labelText) {
        this.labelText = labelText;
    }

    public Component getTooltipText() {
        return tooltipText;
    }

    public void setTooltipText(Component tooltipText) {
        this.tooltipText = tooltipText;
    }

    public void setTooltipText(String text) {
        this.tooltipText = Component.literal(text);
    }

    // 声音配置
    public SoundEvent getScrollSound() {
        return scrollSound;
    }

    public void setScrollSound(SoundEvent scrollSound) {
        this.scrollSound = scrollSound;
    }

    // 回调
    public Consumer<Integer> getOnValueChanged() {
        return onValueChanged;
    }

    public void setOnValueChanged(Consumer<Integer> onValueChanged) {
        this.onValueChanged = onValueChanged;
    }

    // ==================== 渲染方法 ====================

    /** 渲染滑动条 */
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // 更新悬停状态
        isHovered = isMouseOver(mouseX, mouseY);
        renderWithCreateTextures(graphics, mouseX, mouseY, partialTicks);

        // 如果设置了tooltip文本且鼠标悬停在滑块上，渲染tooltip
        if (tooltipText != null && isMouseOverCursor(mouseX, mouseY)) {
            renderTooltip(graphics, mouseX, mouseY);
        }
    }

    /** 渲染tooltip提示框 */
    private void renderTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        if (tooltipText == null) return;

        // 将文本按换行符分割成多行
        String fullText = tooltipText.getString();
        String[] lines = fullText.split("\n");
        if (lines.length == 0) return;

        // 计算最大行宽
        int maxLineWidth = 0;
        for (String line : lines) {
            int lineWidth = font.width(line);
            if (lineWidth > maxLineWidth) {
                maxLineWidth = lineWidth;
            }
        }

        // 内边距
        int padding = 4;
        int lineHeight = font.lineHeight;
        int totalHeight = lines.length * lineHeight + padding * 2;

        // 计算tooltip位置（在鼠标右下方，避免超出屏幕）
        int tooltipX = mouseX + 12;
        int tooltipY = mouseY - 12;

        // 检查是否超出屏幕右边界
        int screenWidth = minecraft.getWindow().getGuiScaledWidth();
        if (tooltipX + maxLineWidth + padding * 2 > screenWidth) {
            tooltipX = mouseX - maxLineWidth - padding * 2 - 12;
        }

        // 检查是否超出屏幕下边界
        int screenHeight = minecraft.getWindow().getGuiScaledHeight();
        if (tooltipY + totalHeight > screenHeight) {
            tooltipY = screenHeight - totalHeight;
        }

        // 检查是否超出屏幕上边界
        if (tooltipY < 0) {
            tooltipY = 0;
        }

        // 绘制灰色背景（半透明）
        int backgroundColor = 0x80101010; // 更透明的深灰色
        int borderColorLight = 0x80505050;
        int borderColorDark = 0x80282828;

        // 背景填充
        graphics.fill(tooltipX, tooltipY, tooltipX + maxLineWidth + padding * 2, tooltipY + totalHeight, backgroundColor);

        // 边框
        graphics.fill(tooltipX, tooltipY, tooltipX + maxLineWidth + padding * 2, tooltipY + 1, borderColorLight); // 上边框
        graphics.fill(tooltipX, tooltipY + totalHeight - 1, tooltipX + maxLineWidth + padding * 2, tooltipY + totalHeight, borderColorDark); // 下边框
        graphics.fill(tooltipX, tooltipY, tooltipX + 1, tooltipY + totalHeight, borderColorLight); // 左边框
        graphics.fill(tooltipX + maxLineWidth + padding * 2 - 1, tooltipY, tooltipX + maxLineWidth + padding * 2, tooltipY + totalHeight, borderColorDark); // 右边框

        // 绘制文本
        for (int i = 0; i < lines.length; i++) {
            graphics.drawString(font, lines[i], tooltipX + padding, tooltipY + padding + i * lineHeight, 0xFFFFFF, false);
        }
    }

    /** 使用 Create 模组纹理渲染 */
    private void renderWithCreateTextures(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // 计算轨道背景位置（参考Create布局：轨道从边框顶部内边距开始）
        int barHeight = Math.min(TRACK_HEIGHT, height - 6);
        int paddingTop = 3;
        int barY = y + paddingTop; // 轨道从边框顶部内边距开始，而不是居中

        // 绘制轨道背景
        renderTrackBackgroundWithTextures(graphics, x, y, width, height);

        // 绘制里程碑标记
        renderMilestoneMarkersWithTextures(graphics, x, y, width, height);

        // 绘制黄铜边框（在轨道和里程碑之后，光标和图标之前）
        if (showBorder) {
            // 图标模式下，边框宽度向内缩2像素（X方向收缩）
            if (iconMode) {
                renderBrassFrameWithTextures(graphics, x, y, width - 2, height);
            } else {
                renderBrassFrameWithTextures(graphics, x, y, width, height);
            }
        }

        // 绘制光标（非图标模式时绘制，图标模式下由图标背景代替）
        if (!iconMode) {
            renderCursorWithTextures(graphics, x, y, width, height);
        }

        // 绘制当前图标（如果是图标模式且有图标）
        if (iconMode) {
            Object currentIcon = getCurrentIcon();
            if (currentIcon != null) {
                renderCurrentIconWithTextures(graphics, x, y, width, height);
            }
        }

        // 绘制标签（如果启用）
        if (showLabel) {
            renderLabelWithTextures(graphics, x, y, width, height);
        }
    }

    /** 使用 Create 纹理绘制黄铜边框 */
    private void renderBrassFrameWithTextures(GuiGraphics graphics, int x, int y, int w, int h) {
        // 绘制四个角
        AllGuiTextures.BRASS_FRAME_TL.render(graphics, x, y);
        AllGuiTextures.BRASS_FRAME_TR.render(graphics, x + w - 4, y);
        AllGuiTextures.BRASS_FRAME_BL.render(graphics, x, y + h - 4);
        AllGuiTextures.BRASS_FRAME_BR.render(graphics, x + w - 4, y + h - 4);

        int zLevel = 0;

        // 绘制左右边
        if (h > 8) {
            UIRenderHelper.drawStretched(graphics, x, y + 4, 3, h - 8, zLevel, AllGuiTextures.BRASS_FRAME_LEFT);
            UIRenderHelper.drawStretched(graphics, x + w - 3, y + 4, 3, h - 8, zLevel, AllGuiTextures.BRASS_FRAME_RIGHT);
        }

        // 绘制上下边
        if (w > 8) {
            UIRenderHelper.drawCropped(graphics, x + 4, y, w - 8, 3, zLevel, AllGuiTextures.BRASS_FRAME_TOP);
            UIRenderHelper.drawCropped(graphics, x + 4, y + h - 3, w - 8, 3, zLevel, AllGuiTextures.BRASS_FRAME_BOTTOM);
        }
    }

    /** 使用 Create 纹理绘制轨道背景 */
    private void renderTrackBackgroundWithTextures(GuiGraphics graphics, int x, int y, int w, int h) {
        int barHeight = Math.min(TRACK_HEIGHT, h - 6); // 轨道高度（考虑边框上下边各3像素）
        // 边框内边距：上下各3像素，左右各3像素（与里程碑保持一致）
        int paddingLeft = BORDER_THICKNESS;
        int paddingRight = BORDER_THICKNESS;
        int paddingTop = 3;
        int barY = y + paddingTop; // 轨道从边框顶部内边距开始，与Create一致
        int trackWidth = w - paddingLeft - paddingRight;

        // 使用 VALUE_SETTINGS_BAR 纹理平铺
        int barTextureWidth = AllGuiTextures.VALUE_SETTINGS_BAR.width - 1;
        for (int wx = 0; wx < trackWidth; wx += barTextureWidth) {
            int segmentWidth = Math.min(barTextureWidth, trackWidth - wx);
            UIRenderHelper.drawCropped(graphics, x + paddingLeft + wx, barY, segmentWidth, barHeight,
                    0, AllGuiTextures.VALUE_SETTINGS_BAR);
        }
    }

    /** 使用 Create 纹理绘制里程碑标记 */
    private void renderMilestoneMarkersWithTextures(GuiGraphics graphics, int x, int y, int w, int h) {
        int barHeight = Math.min(TRACK_HEIGHT, h - 6); // 轨道高度（考虑边框上下边各3像素）
        // 边框内边距：上下各3像素
        int paddingTop = 3;
        int barY = y + paddingTop; // 轨道从边框顶部内边距开始，里程碑与轨道对齐

        // 图标模式下，里程碑垂直居中于轨道（与图标背景中心对齐）
        if (iconMode) {
            barY = barY + barHeight / 2 - MILESTONE_HEIGHT / 2;
        }

        // 计算轨道可用宽度（左右各3像素边框内边距）
        int trackWidth = w - BORDER_THICKNESS * 2;
        int totalValues = maxValue + 1; // 总格子数

        // 渲染所有里程碑位置（每milestoneInterval一个）
        for (int column = 0; column <= maxValue; column += milestoneInterval) {
            // 里程碑纹理宽度
            int textureWidth = iconMode ? MILESTONE_WIDTH_WIDE : MILESTONE_WIDTH_NORMAL;

            int renderX;

            if (totalValues == 1) {
                // 只有一个值：在轨道中心
                renderX = x + BORDER_THICKNESS + (trackWidth - textureWidth) / 2;
            } else if (column == 0) {
                // 第一个里程碑：左上角在 x + 3（边框内边距）
                renderX = x + BORDER_THICKNESS;
            } else if (column == maxValue) {
                // 最后一个里程碑：左上角在 x + width - 3 - textureWidth
                renderX = x + w - BORDER_THICKNESS - textureWidth;
            } else {
                // 中间里程碑：在第一个和最后一个渲染位置之间均匀分布
                int firstRenderX = x + BORDER_THICKNESS;
                int lastRenderX = x + w - BORDER_THICKNESS - textureWidth;
                double spacing = (double)(lastRenderX - firstRenderX) / maxValue;
                renderX = firstRenderX + (int) Math.round(column * spacing);
            }

            if (iconMode) {
                AllGuiTextures.VALUE_SETTINGS_WIDE_MILESTONE.render(graphics, renderX, barY);
            } else {
                AllGuiTextures.VALUE_SETTINGS_MILESTONE.render(graphics, renderX, barY);
            }
        }
    }

    /** 使用 Create 纹理绘制光标 */
    private void renderCursorWithTextures(GuiGraphics graphics, int x, int y, int w, int h) {
        // 光标尺寸
        int cursorMiddleWidth = numericModeCursorWidth; // VALUE_SETTINGS_CURSOR纹理宽度（可配置）
        int cursorLeftWidth = 3; // 左部分宽度
        int cursorRightWidth = 3; // 右部分宽度

        // 计算轨道位置（用于光标垂直定位）
        int barHeight = Math.min(TRACK_HEIGHT, h - 6);
        int paddingTop = 3;
        int barY = y + paddingTop; // 轨道从边框顶部内边距开始

        // 计算光标位置：基于当前值
        float cursorCenterX = getCoordinateOfValue(currentValue);
        int cursorX = (int) (cursorCenterX - cursorMiddleWidth / 2);
        // 光标固定在轨道上方，与原版ValueSettingsScreen保持一致
        // 轨道顶部在 barY，轨道中心在 barY + barHeight/2
        // 光标中心在轨道中心上方7像素
        int cursorY = barY + barHeight / 2 - 7;

        // 光标中心对准里程碑中心，允许光标部分超出边框（被边框遮挡）
        // 不限制光标边界，确保光标中心准确对准里程碑中心

        // 绘制光标（三部分）
        AllGuiTextures.VALUE_SETTINGS_CURSOR_LEFT.render(graphics, cursorX - cursorLeftWidth, cursorY);
        UIRenderHelper.drawCropped(graphics, cursorX, cursorY, cursorMiddleWidth, 14,
                0, AllGuiTextures.VALUE_SETTINGS_CURSOR);
        AllGuiTextures.VALUE_SETTINGS_CURSOR_RIGHT.render(graphics, cursorX + cursorMiddleWidth, cursorY);
    }

    /** 使用 Create 纹理绘制当前图标 */
    private void renderCurrentIconWithTextures(GuiGraphics graphics, int x, int y, int w, int h) {
        Object currentIcon = getCurrentIcon();
        if (currentIcon != null) {
            // 计算轨道位置（用于垂直定位参考）
            int barHeight = Math.min(TRACK_HEIGHT, h - 6);
            int paddingTop = 3;
            int barY = y + paddingTop; // 轨道从边框顶部内边距开始

            // 根据用户需求，图标模式下：
            // 1. 图标背景（VALUE_SETTINGS_CURSOR_ICON）尺寸：22x20像素
            // 2. 图标背景中心在轨道中心（垂直居中于轨道）
            // 3. 图标（AllIcons或ResourceLocation）尺寸：16x16像素，在背景内居中

            // 计算图标背景中心位置（基于当前值的坐标）
            float iconCenterX = getCoordinateOfValue(currentValue);
            int iconBgWidth = 22;
            int iconBgHeight = 20;

            // 图标背景中心在轨道中心（垂直居中于轨道）
            int iconBgCenterY = barY + barHeight / 2;

            // 基于中心坐标计算图标背景位置，确保与里程碑中心对齐
            // 允许图标背景部分超出边框（被边框遮挡），优先保证中心对齐
            // 使用Math.round()避免整数截断导致的左偏
            int iconBgX = (int) Math.round(iconCenterX - iconBgWidth / 2.0f);
            int iconBgY = iconBgCenterY - iconBgHeight / 2;

            // 绘制图标背景（VALUE_SETTINGS_CURSOR_ICON，22x20像素）
            AllGuiTextures.VALUE_SETTINGS_CURSOR_ICON.render(graphics, iconBgX, iconBgY);

            // 根据图标类型绘制
            if (currentIcon instanceof AllIcons) {
                // 绘制 AllIcons 图标（16x16像素，在背景内居中）
                int iconSize = 16;
                int iconX = iconBgX + (iconBgWidth - iconSize) / 2;
                int iconY = iconBgY + (iconBgHeight - iconSize) / 2;

                // 根据图标颜色模式设置着色
                if (darkIconMode) {
                    // 深色模式：Create原版深黄铜色 (0x442000 -> 0.265625f, 0.125f, 0)
                    RenderSystem.setShaderColor(0.265625f, 0.125f, 0, 1);
                } else {
                    // 浅色模式：白色 (1, 1, 1, 1)
                    RenderSystem.setShaderColor(1, 1, 1, 1);
                }
                ((AllIcons) currentIcon).render(graphics, iconX, iconY);
                RenderSystem.setShaderColor(1, 1, 1, 1); // 恢复默认颜色
            } else if (currentIcon instanceof ResourceLocation) {
                // 绘制 ResourceLocation 纹理（16x16像素，在背景内居中）
                int iconSize = 16;
                int iconX = iconBgX + (iconBgWidth - iconSize) / 2;
                int iconY = iconBgY + (iconBgHeight - iconSize) / 2;

                // 根据图标颜色模式设置着色
                if (darkIconMode) {
                    // 深色模式：Create原版深黄铜色 (0x442000 -> 0.265625f, 0.125f, 0)
                    RenderSystem.setShaderColor(0.265625f, 0.125f, 0, 1);
                } else {
                    // 浅色模式：白色 (1, 1, 1, 1)
                    RenderSystem.setShaderColor(1, 1, 1, 1);
                }
                graphics.blit((ResourceLocation) currentIcon, iconX, iconY, 0, 0, iconSize, iconSize, iconSize, iconSize);
                RenderSystem.setShaderColor(1, 1, 1, 1); // 恢复默认颜色
            }
        }
    }

    /** 使用 Create 纹理绘制标签 */
    private void renderLabelWithTextures(GuiGraphics graphics, int x, int y, int w, int h) {
        Component text;
        if (labelText != null) {
            text = labelText;
        } else {
            // 默认标签：显示当前值和范围
            text = Component.literal("值: " + currentValue + " / " + maxValue)
                    .withStyle(ChatFormatting.YELLOW);
        }

        int textWidth = font.width(text);
        int textHeight = font.lineHeight;

        // 标签放在滑动条左侧（模仿Create样式）
        int labelBgX = x - textWidth - 10;
        int labelBgY = y + (h - textHeight) / 2;

        // 绘制标签背景（使用Create的标签背景纹理）
        UIRenderHelper.drawCropped(graphics, labelBgX, labelBgY, textWidth + 8, textHeight + 2,
                0, AllGuiTextures.VALUE_SETTINGS_LABEL_BG);

        // 绘制文字（深褐色，模仿Create样式）
        graphics.drawString(font, text, labelBgX + 4, labelBgY + 1, 0x442000, false);
    }

    // ==================== 鼠标交互 ====================

    /** 处理鼠标点击 */
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return false; // 只处理左键

        // 检查是否点击在滑动条区域内
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            // 获取最近的格子
            int newValue = getClosestColumn((int) mouseX);
            setCurrentValue(newValue);

            // 开始拖动
            dragging = true;
            dragStartX = (int) mouseX;
            dragStartValue = currentValue;

            return true;
        }

        return false;
    }

    /** 处理鼠标释放 */
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button != 0) return false;

        if (dragging) {
            dragging = false;
            return true;
        }

        return false;
    }

    /** 处理鼠标拖动 */
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (!dragging || button != 0) return false;

        // 根据鼠标移动距离计算新值
        int mouseDelta = (int) mouseX - dragStartX;
        if (Math.abs(mouseDelta) > 0) {
            // 计算每个像素对应的值变化，考虑拖动灵敏度
            float pixelsPerValue = (float) width / (maxValue + 1);
            int valueDelta = Math.round(mouseDelta / (pixelsPerValue * dragSensitivity));
            int newValue = Math.max(minValue, Math.min(maxValue, dragStartValue + valueDelta));

            setCurrentValue(newValue);
            return true;
        }

        return false;
    }

    /** 处理鼠标滚轮 */
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollDelta) {
        // 检查鼠标是否在滑动条区域内
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            int direction = scrollDelta > 0 ? step : -step;
            int newValue = Math.max(minValue, Math.min(maxValue, currentValue + direction));
            setCurrentValue(newValue);
            return true;
        }
        return false;
    }

    /** 每帧更新（用于声音冷却计时器） */
    public void tick() {
        if (soundCoolDown > 0) {
            soundCoolDown--;
        }
    }

    /** 检查鼠标是否悬停在滑块（光标或图标背景）上 */
    public boolean isMouseOverCursor(double mouseX, double mouseY) {
        if (iconMode) {
            // 图标模式：检查图标背景区域 (22x20像素)
            float iconCenterX = getCoordinateOfValue(currentValue);
            int iconBgWidth = 22;
            int iconBgHeight = 20;

            // 计算轨道位置用于垂直定位
            int barHeight = Math.min(TRACK_HEIGHT, height - 6);
            int paddingTop = 3;
            int barY = y + paddingTop;
            int iconBgCenterY = barY + barHeight / 2;

            int iconBgX = (int) Math.round(iconCenterX - iconBgWidth / 2.0f);
            int iconBgY = iconBgCenterY - iconBgHeight / 2;

            return mouseX >= iconBgX && mouseX <= iconBgX + iconBgWidth &&
                   mouseY >= iconBgY && mouseY <= iconBgY + iconBgHeight;
        } else {
            // 非图标模式：检查光标区域
            float cursorCenterX = getCoordinateOfValue(currentValue);
            int cursorMiddleWidth = numericModeCursorWidth;
            int cursorLeftWidth = 3;
            int cursorRightWidth = 3;
            int totalCursorWidth = cursorMiddleWidth + cursorLeftWidth + cursorRightWidth;

            // 计算轨道位置用于垂直定位
            int barHeight = Math.min(TRACK_HEIGHT, height - 6);
            int paddingTop = 3;
            int barY = y + paddingTop;
            int cursorY = barY + barHeight / 2 - 7;
            int cursorHeight = 14; // 光标纹理高度

            int cursorX = (int) (cursorCenterX - cursorMiddleWidth / 2) - cursorLeftWidth;

            return mouseX >= cursorX && mouseX <= cursorX + totalCursorWidth &&
                   mouseY >= cursorY && mouseY <= cursorY + cursorHeight;
        }
    }

    /** 检查鼠标是否悬停在滑动条上 */
    public boolean isMouseOver(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
}