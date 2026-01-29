//文件AllPonderTags.java
package com.simibubi.create.infrastructure.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.compat.Mods;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class AllPonderTags {

	public static final PonderTag

	KINETIC_RELAYS = create("kinetic_relays").item(AllBlocks.COGWHEEL.get())
		.defaultLang("Kinetic Blocks", "Components which help relaying Rotational Force elsewhere")
		.addToIndex(),

		KINETIC_SOURCES = create("kinetic_sources").item(AllBlocks.WATER_WHEEL.get())
			.defaultLang("Kinetic Sources", "Components which generate Rotational Force")
			.addToIndex(),

		KINETIC_APPLIANCES = create("kinetic_appliances").item(AllBlocks.MECHANICAL_PRESS.get())
			.defaultLang("Kinetic Appliances", "Components which make use of Rotational Force")
			.addToIndex(),

		FLUIDS = create("fluids").item(AllBlocks.FLUID_PIPE.get())
			.defaultLang("Fluid Manipulators", "Components which help relaying and making use of Fluids")
			.addToIndex(),

		LOGISTICS = create("logistics").item(Blocks.CHEST)
			.defaultLang("Item Transportation", "Components which help moving items around")
			.addToIndex(),

		REDSTONE = create("redstone").item(Items.REDSTONE)
			.defaultLang("Logic Components", "Components which help with redstone engineering")
			.addToIndex(),

		DECORATION = create("decoration").item(Items.ROSE_BUSH)
			.defaultLang("Aesthetics", "Components used mostly for decorative purposes"),

		CREATIVE = create("creative").item(AllBlocks.CREATIVE_CRATE.get())
			.defaultLang("Creative Mode", "Components not usually available for Survival Mode")
			.addToIndex(),

		MOVEMENT_ANCHOR = create("movement_anchor").item(AllBlocks.MECHANICAL_PISTON.get())
			.defaultLang("Movement Anchors",
				"Components which allow the creation of moving contraptions, animating an attached structure in a variety of ways")
			.addToIndex(),

		CONTRAPTION_ACTOR = create("contraption_actor").item(AllBlocks.MECHANICAL_HARVESTER.get())
			.defaultLang("Contraption Actors",
				"Components which expose special behaviour when attached to a moving contraption")
			.addToIndex(),

		CONTRAPTION_ASSEMBLY = create("contraption_assembly").item(AllItems.SUPER_GLUE.get())
			.defaultLang("Block Attachment Utility",
				"Tools and Components used to assemble structures moved as an animated Contraption")
			.addToIndex(),

		SAILS = create("windmill_sails").item(AllBlocks.WINDMILL_BEARING.get(), true, true)
			.defaultLang("Sails for Windmill Bearings",
				"Blocks that count towards the strength of a Windmill Contraption when assembled. Each of these have equal efficiency in doing so."),

		ARM_TARGETS = create("arm_targets").item(AllBlocks.MECHANICAL_ARM.get(), true, true)
			.defaultLang("Targets for Mechanical Arms",
				"Components which can be selected as inputs or outputs to the Mechanical Arm"),

		TRAIN_RELATED = create("train_related").item(AllBlocks.TRACK.get())
			.defaultLang("Railway Equipment", "Components used in the construction or management of Train Contraptions")
			.addToIndex(),

		RECENTLY_UPDATED = create("recently_updated").item(AllBlocks.CLIPBOARD.get())
			.defaultLang("Recent Changes",
				"Components that have been added or changed significantly in the latest versions of Create")
			.addToIndex(),

		DISPLAY_SOURCES = create("display_sources").item(AllBlocks.DISPLAY_LINK.get(), true, true)
			.defaultLang("Sources for Display Links",
				"Components or Blocks which offer some data that can be read with a Display Link"),

		DISPLAY_TARGETS = create("display_targets").item(AllBlocks.DISPLAY_LINK.get(), true, true)
			.defaultLang("Targets for Display Links",
				"Components or Blocks which can process and display the data received from a Display Link");

	private static PonderTag create(String id) {
		return new PonderTag(Create.asResource(id));
	}

	public static void register() {
		// Add items to tags here

		PonderRegistry.TAGS.forTag(RECENTLY_UPDATED)
			.add(AllBlocks.WATER_WHEEL)
			.add(AllBlocks.LARGE_WATER_WHEEL)
			.add(AllBlocks.COPPER_VALVE_HANDLE)
			.add(AllBlocks.ELEVATOR_PULLEY)
			.add(AllBlocks.CONTRAPTION_CONTROLS)
			.add(AllBlocks.MECHANICAL_ROLLER)
			.add(AllBlocks.MECHANICAL_PUMP)
			.add(AllBlocks.SMART_OBSERVER)
			.add(AllBlocks.THRESHOLD_SWITCH)
			.add(AllItems.NETHERITE_BACKTANK)
			.add(AllBlocks.COPYCAT_PANEL)
			.add(AllBlocks.COPYCAT_STEP);

		PonderRegistry.TAGS.forTag(KINETIC_RELAYS)
			.add(AllBlocks.SHAFT)
			.add(AllBlocks.COGWHEEL)
			.add(AllBlocks.LARGE_COGWHEEL)
			.add(AllItems.BELT_CONNECTOR)
			.add(AllBlocks.GEARBOX)
			.add(AllBlocks.CLUTCH)
			.add(AllBlocks.GEARSHIFT)
			.add(AllBlocks.ENCASED_CHAIN_DRIVE)
			.add(AllBlocks.ADJUSTABLE_CHAIN_GEARSHIFT)
			.add(AllBlocks.SEQUENCED_GEARSHIFT)
			.add(AllBlocks.ROTATION_SPEED_CONTROLLER);

		PonderRegistry.TAGS.forTag(KINETIC_SOURCES)
			.add(AllBlocks.HAND_CRANK)
			.add(AllBlocks.COPPER_VALVE_HANDLE)
			.add(AllBlocks.WATER_WHEEL)
			.add(AllBlocks.LARGE_WATER_WHEEL)
			.add(AllBlocks.WINDMILL_BEARING)
			.add(AllBlocks.STEAM_ENGINE)
			.add(AllBlocks.CREATIVE_MOTOR);

		PonderRegistry.TAGS.forTag(TRAIN_RELATED)
			.add(AllBlocks.TRACK)
			.add(AllBlocks.TRACK_STATION)
			.add(AllBlocks.TRACK_SIGNAL)
			.add(AllBlocks.TRACK_OBSERVER)
			.add(AllBlocks.TRAIN_CONTROLS)
			.add(AllItems.SCHEDULE)
			.add(AllBlocks.TRAIN_DOOR)
			.add(AllBlocks.TRAIN_TRAPDOOR)
			.add(AllBlocks.RAILWAY_CASING);

		PonderRegistry.TAGS.forTag(KINETIC_APPLIANCES)
			.add(AllBlocks.MILLSTONE)
			.add(AllBlocks.TURNTABLE)
			.add(AllBlocks.ENCASED_FAN)
			.add(AllBlocks.CUCKOO_CLOCK)
			.add(AllBlocks.MECHANICAL_PRESS)
			.add(AllBlocks.MECHANICAL_MIXER)
			.add(AllBlocks.MECHANICAL_CRAFTER)
			.add(AllBlocks.MECHANICAL_DRILL)
			.add(AllBlocks.MECHANICAL_SAW)
			.add(AllBlocks.DEPLOYER)
			.add(AllBlocks.MECHANICAL_PUMP)
			.add(AllBlocks.MECHANICAL_ARM)
			.add(AllBlocks.MECHANICAL_PISTON)
			.add(AllBlocks.ROPE_PULLEY)
			.add(AllBlocks.ELEVATOR_PULLEY)
			.add(AllBlocks.MECHANICAL_BEARING)
			.add(AllBlocks.GANTRY_SHAFT)
			.add(AllBlocks.GANTRY_CARRIAGE)
			.add(AllBlocks.CLOCKWORK_BEARING)
			.add(AllBlocks.DISPLAY_BOARD)
			.add(AllBlocks.CRUSHING_WHEEL);

		PonderRegistry.TAGS.forTag(FLUIDS)
			.add(AllBlocks.FLUID_PIPE)
			.add(AllBlocks.MECHANICAL_PUMP)
			.add(AllBlocks.FLUID_VALVE)
			.add(AllBlocks.SMART_FLUID_PIPE)
			.add(AllBlocks.HOSE_PULLEY)
			.add(AllBlocks.ITEM_DRAIN)
			.add(AllBlocks.SPOUT)
			.add(AllBlocks.PORTABLE_FLUID_INTERFACE)
			.add(AllBlocks.FLUID_TANK)
			.add(AllBlocks.CREATIVE_FLUID_TANK);

		PonderRegistry.TAGS.forTag(ARM_TARGETS)
			.add(AllBlocks.MECHANICAL_ARM)
			.add(AllItems.BELT_CONNECTOR)
			.add(AllBlocks.CHUTE)
			.add(AllBlocks.DEPOT)
			.add(AllBlocks.WEIGHTED_EJECTOR)
			.add(AllBlocks.BASIN)
			.add(AllBlocks.ANDESITE_FUNNEL)
			.add(AllBlocks.BRASS_FUNNEL)
			.add(AllBlocks.MECHANICAL_CRAFTER)
			.add(AllBlocks.MILLSTONE)
			.add(AllBlocks.DEPLOYER)
			.add(AllBlocks.MECHANICAL_SAW)
			.add(AllBlocks.BLAZE_BURNER)
			.add(AllBlocks.CRUSHING_WHEEL)
			.add(AllBlocks.TRACK_STATION)
			.add(Blocks.COMPOSTER)
			.add(Blocks.JUKEBOX)
			.add(Blocks.CAMPFIRE)
			.add(Blocks.SOUL_CAMPFIRE)
			.add(Blocks.RESPAWN_ANCHOR);

		PonderRegistry.TAGS.forTag(LOGISTICS)
			.add(AllItems.BELT_CONNECTOR)
			.add(AllItems.FILTER)
			.add(AllItems.ATTRIBUTE_FILTER)
			.add(AllBlocks.CHUTE)
			.add(AllBlocks.SMART_CHUTE)
			.add(AllBlocks.ITEM_VAULT)
			.add(AllBlocks.DEPOT)
			.add(AllBlocks.WEIGHTED_EJECTOR)
			.add(AllBlocks.MECHANICAL_ARM)
			.add(AllBlocks.ANDESITE_FUNNEL)
			.add(AllBlocks.BRASS_FUNNEL)
			.add(AllBlocks.ANDESITE_TUNNEL)
			.add(AllBlocks.BRASS_TUNNEL)
			.add(AllBlocks.SMART_OBSERVER)
			.add(AllBlocks.THRESHOLD_SWITCH)
			.add(AllBlocks.CREATIVE_CRATE)
			.add(AllBlocks.PORTABLE_STORAGE_INTERFACE);

		PonderRegistry.TAGS.forTag(DECORATION)
			.add(AllBlocks.ORANGE_NIXIE_TUBE)
			.add(AllBlocks.DISPLAY_BOARD)
			.add(AllBlocks.CUCKOO_CLOCK)
			.add(AllBlocks.WOODEN_BRACKET)
			.add(AllBlocks.METAL_BRACKET)
			.add(AllBlocks.METAL_GIRDER)
			.add(AllBlocks.ANDESITE_CASING)
			.add(AllBlocks.BRASS_CASING)
			.add(AllBlocks.COPPER_CASING)
			.add(AllBlocks.RAILWAY_CASING);

		PonderRegistry.TAGS.forTag(CREATIVE)
			.add(AllBlocks.CREATIVE_CRATE)
			.add(AllBlocks.CREATIVE_FLUID_TANK)
			.add(AllBlocks.CREATIVE_MOTOR);

		PonderRegistry.TAGS.forTag(SAILS)
			.add(AllBlocks.SAIL)
			.add(AllBlocks.SAIL_FRAME)
			.add(Blocks.WHITE_WOOL);

		PonderRegistry.TAGS.forTag(REDSTONE)
			.add(AllBlocks.SMART_OBSERVER)
			.add(AllBlocks.THRESHOLD_SWITCH)
			.add(AllBlocks.ORANGE_NIXIE_TUBE)
			.add(AllBlocks.REDSTONE_CONTACT)
			.add(AllBlocks.ANALOG_LEVER)
			.add(AllBlocks.REDSTONE_LINK)
			.add(AllBlocks.PULSE_EXTENDER)
			.add(AllBlocks.PULSE_REPEATER)
			.add(AllBlocks.POWERED_LATCH)
			.add(AllBlocks.POWERED_TOGGLE_LATCH)
			.add(AllBlocks.ROSE_QUARTZ_LAMP);

		PonderRegistry.TAGS.forTag(MOVEMENT_ANCHOR)
			.add(AllBlocks.MECHANICAL_PISTON)
			.add(AllBlocks.WINDMILL_BEARING)
			.add(AllBlocks.MECHANICAL_BEARING)
			.add(AllBlocks.CLOCKWORK_BEARING)
			.add(AllBlocks.ROPE_PULLEY)
			.add(AllBlocks.ELEVATOR_PULLEY)
			.add(AllBlocks.GANTRY_CARRIAGE)
			.add(AllBlocks.CART_ASSEMBLER)
			.add(AllBlocks.TRACK_STATION);

		PonderRegistry.TAGS.forTag(CONTRAPTION_ASSEMBLY)
			.add(AllBlocks.LINEAR_CHASSIS)
			.add(AllBlocks.SECONDARY_LINEAR_CHASSIS)
			.add(AllBlocks.RADIAL_CHASSIS)
			.add(AllItems.SUPER_GLUE)
			.add(AllBlocks.STICKER)
			.add(Blocks.SLIME_BLOCK)
			.add(Blocks.HONEY_BLOCK);

		PonderRegistry.TAGS.forTag(CONTRAPTION_ACTOR)
			.add(AllBlocks.MECHANICAL_HARVESTER)
			.add(AllBlocks.MECHANICAL_PLOUGH)
			.add(AllBlocks.MECHANICAL_DRILL)
			.add(AllBlocks.MECHANICAL_SAW)
			.add(AllBlocks.DEPLOYER)
			.add(AllBlocks.PORTABLE_STORAGE_INTERFACE)
			.add(AllBlocks.PORTABLE_FLUID_INTERFACE)
			.add(AllBlocks.MECHANICAL_BEARING)
			.add(AllBlocks.ANDESITE_FUNNEL)
			.add(AllBlocks.BRASS_FUNNEL)
			.add(AllBlocks.SEATS.get(DyeColor.WHITE))
			.add(AllBlocks.TRAIN_CONTROLS)
			.add(AllBlocks.CONTRAPTION_CONTROLS)
			.add(AllBlocks.REDSTONE_CONTACT)
			.add(Blocks.BELL)
			.add(Blocks.DISPENSER)
			.add(Blocks.DROPPER);

		PonderRegistry.TAGS.forTag(DISPLAY_SOURCES)
			.add(AllBlocks.SEATS.get(DyeColor.WHITE))
			.add(AllBlocks.ORANGE_NIXIE_TUBE)
			.add(AllBlocks.THRESHOLD_SWITCH)
			.add(AllBlocks.SMART_OBSERVER)
			.add(AllBlocks.ANDESITE_TUNNEL)
			.add(AllBlocks.TRACK_OBSERVER)
			.add(AllBlocks.TRACK_STATION)
			.add(AllBlocks.DISPLAY_LINK)
			.add(AllBlocks.BRASS_TUNNEL)
			.add(AllBlocks.CUCKOO_CLOCK)
			.add(AllBlocks.STRESSOMETER)
			.add(AllBlocks.SPEEDOMETER)
			.add(AllBlocks.FLUID_TANK)
			.add(AllItems.BELT_CONNECTOR)
			.add(Blocks.ENCHANTING_TABLE)
			.add(Blocks.RESPAWN_ANCHOR)
			.add(Blocks.COMMAND_BLOCK)
			.add(Blocks.TARGET);

		Mods.COMPUTERCRAFT.executeIfInstalled(() -> () -> {
			Block computer = ForgeRegistries.BLOCKS.getValue(Mods.COMPUTERCRAFT.rl("computer_advanced"));
			if (computer != null)
				PonderRegistry.TAGS.forTag(DISPLAY_SOURCES).add(computer);
		});

		PonderRegistry.TAGS.forTag(DISPLAY_TARGETS)
			.add(AllBlocks.ORANGE_NIXIE_TUBE)
			.add(AllBlocks.DISPLAY_BOARD)
			.add(AllBlocks.DISPLAY_LINK)
			.add(Blocks.OAK_SIGN)
			.add(Blocks.LECTERN);
	}

}
//文件DebugScenes.java
package com.simibubi.create.infrastructure.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.base.IRotate.SpeedLevel;
import com.simibubi.create.content.kinetics.base.RotationIndicatorParticleData;
import com.simibubi.create.foundation.item.ItemHelper;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.PonderStoryBoardEntry.PonderStoryBoard;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.DancePose;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.Pointing;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DebugScenes {

	private static int index;

	public static void registerAll() {
		index = 1;
		add(DebugScenes::coordinateScene);
		add(DebugScenes::blocksScene);
		add(DebugScenes::fluidsScene);
		add(DebugScenes::offScreenScene);
		add(DebugScenes::particleScene);
		add(DebugScenes::controlsScene);
		add(DebugScenes::birbScene);
		add(DebugScenes::sectionsScene);
		add(DebugScenes::itemScene);
		add(DebugScenes::pipeScene);
	}

	private static void add(PonderStoryBoard sb) {
		ItemEntry<Item> item = AllItems.BRASS_HAND;
		String schematicPath = "debug/scene_" + index;
		PonderIndex.HELPER.addStoryBoard(item, schematicPath, sb)
			.highlightAllTags()
			.chapter(PonderIndex.HELPER.getOrCreateChapter("debug"));
		index++;
	}

	public static void empty(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_empty", "Missing Content");
		scene.showBasePlate();
		scene.idle(5);
	}

	public static void coordinateScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_coords", "Coordinate Space");
		scene.showBasePlate();
		scene.idle(10);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);

		Selection xAxis = util.select.fromTo(2, 1, 1, 4, 1, 1);
		Selection yAxis = util.select.fromTo(1, 2, 1, 1, 4, 1);
		Selection zAxis = util.select.fromTo(1, 1, 2, 1, 1, 4);

		scene.idle(10);
		scene.overlay.showSelectionWithText(xAxis, 20)
			.colored(PonderPalette.RED)
			.text("Das X axis");
		scene.idle(20);
		scene.overlay.showSelectionWithText(yAxis, 20)
			.colored(PonderPalette.GREEN)
			.text("Das Y axis");
		scene.idle(20);
		scene.overlay.showSelectionWithText(zAxis, 20)
			.colored(PonderPalette.BLUE)
			.text("Das Z axis");
	}

	public static void blocksScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_blocks", "Changing Blocks");
		scene.showBasePlate();
		scene.idle(10);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
		scene.idle(10);
		scene.overlay.showText(1000)
			.independent(10)
			.text("Blocks can be modified");
		scene.idle(20);
		scene.world.replaceBlocks(util.select.fromTo(1, 1, 3, 2, 2, 4),
			AllBlocks.REFINED_RADIANCE_CASING.getDefaultState(), true);
		scene.idle(10);
		scene.world.replaceBlocks(util.select.position(3, 1, 1), Blocks.GOLD_BLOCK.defaultBlockState(), true);
		scene.rotateCameraY(180);
		scene.markAsFinished();
	}

	public static void fluidsScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_fluids", "Showing Fluids");
		scene.showBasePlate();
		scene.idle(10);
		Vec3 parrotPos = util.vector.topOf(1, 0, 1);
		scene.special.createBirb(parrotPos, FacePointOfInterestPose::new);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
		scene.overlay.showText(1000)
			.text("Fluid rendering test.")
			.pointAt(new Vec3(1, 2.5, 4.5));
		scene.markAsFinished();

		Object outlineSlot = new Object();

		Vec3 vec1 = util.vector.topOf(1, 0, 0);
		Vec3 vec2 = util.vector.topOf(0, 0, 1);
		AABB boundingBox1 = new AABB(vec1, vec1).expandTowards(0, 2.5, 0)
			.inflate(.15, 0, .15);
		AABB boundingBox2 = new AABB(vec2, vec2).expandTowards(0, .125, 0)
			.inflate(.45, 0, .45);
		Vec3 poi1 = boundingBox1.getCenter();
		Vec3 poi2 = boundingBox2.getCenter();

		for (int i = 0; i < 10; i++) {
			scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, outlineSlot,
				i % 2 == 0 ? boundingBox1 : boundingBox2, 15);
			scene.idle(3);
			scene.special.movePointOfInterest(i % 2 == 0 ? poi1 : poi2);
			scene.idle(12);
		}

		scene.idle(12);
		scene.special.movePointOfInterest(util.grid.at(-4, 5, 4));
		scene.overlay.showText(40)
			.colored(PonderPalette.RED)
			.text("wut?")
			.pointAt(parrotPos.add(-.25f, 0.25f, .25f));

	}

	public static void offScreenScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_baseplate", "Out of bounds / configureBasePlate");
		scene.configureBasePlate(1, 0, 6);
		scene.showBasePlate();

		Selection out1 = util.select.fromTo(7, 0, 0, 8, 0, 5);
		Selection out2 = util.select.fromTo(0, 0, 0, 0, 0, 5);
		Selection blocksExceptBasePlate = util.select.layersFrom(1)
			.add(out1)
			.add(out2);

		scene.idle(10);
		scene.world.showSection(blocksExceptBasePlate, Direction.DOWN);
		scene.idle(10);

		scene.overlay.showSelectionWithText(out1, 100)
			.colored(PonderPalette.BLACK)
			.text("Blocks outside of the base plate do not affect scaling");
		scene.overlay.showSelectionWithText(out2, 100)
			.colored(PonderPalette.BLACK)
			.text("configureBasePlate() makes sure of that.");
		scene.markAsFinished();
	}

	public static void particleScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_particles", "Emitting particles");
		scene.showBasePlate();
		scene.idle(10);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
		scene.idle(10);

		Vec3 emitterPos = util.vector.of(2.5, 2.25, 2.5);
		Emitter emitter = Emitter.simple(ParticleTypes.LAVA, util.vector.of(0, .1, 0));
		Emitter rotation =
			Emitter.simple(new RotationIndicatorParticleData(SpeedLevel.MEDIUM.getColor(), 12, 1, 1, 20, 'Y'),
				util.vector.of(0, .1, 0));

		scene.overlay.showText(20)
			.text("Incoming...")
			.pointAt(emitterPos);
		scene.idle(30);
		scene.effects.emitParticles(emitterPos, emitter, 1, 60);
		scene.effects.emitParticles(emitterPos, rotation, 20, 1);
		scene.idle(30);
		scene.rotateCameraY(180);
	}

	public static void controlsScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_controls", "Basic player interaction");
		scene.showBasePlate();
		scene.idle(10);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(4);
		scene.world.showSection(util.select.layer(2), Direction.DOWN);
		scene.idle(4);
		scene.world.showSection(util.select.layer(3), Direction.DOWN);
		scene.idle(10);

		BlockPos shaftPos = util.grid.at(3, 1, 1);
		Selection shaftSelection = util.select.position(shaftPos);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(shaftPos), Pointing.DOWN).rightClick()
			.whileSneaking()
			.withWrench(), 40);
		scene.idle(20);
		scene.world.replaceBlocks(shaftSelection, AllBlocks.SHAFT.getDefaultState(), true);

		scene.idle(20);
		scene.world.hideSection(shaftSelection, Direction.UP);

		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.of(1, 4.5, 3.5), Pointing.LEFT).rightClick()
			.withItem(new ItemStack(Blocks.POLISHED_ANDESITE)), 20);
		scene.world.showSection(util.select.layer(4), Direction.DOWN);

		scene.idle(40);

		BlockPos chassis = util.grid.at(1, 1, 3);
		Vec3 chassisSurface = util.vector.blockSurface(chassis, Direction.NORTH);

		Object chassisValueBoxHighlight = new Object();
		Object chassisEffectHighlight = new Object();

		AABB point = new AABB(chassisSurface, chassisSurface);
		AABB expanded = point.inflate(1 / 4f, 1 / 4f, 1 / 16f);

		Selection singleBlock = util.select.position(1, 2, 3);
		Selection twoBlocks = util.select.fromTo(1, 2, 3, 1, 3, 3);
		Selection threeBlocks = util.select.fromTo(1, 2, 3, 1, 4, 3);

		Selection singleRow = util.select.fromTo(1, 2, 3, 3, 2, 3);
		Selection twoRows = util.select.fromTo(1, 2, 3, 3, 3, 3);
		Selection threeRows = twoRows.copy()
			.add(threeBlocks);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, chassisValueBoxHighlight, point, 1);
		scene.idle(1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, chassisValueBoxHighlight, expanded, 120);
		scene.overlay.showControls(new InputWindowElement(chassisSurface, Pointing.UP).scroll()
			.withWrench(), 40);

		PonderPalette white = PonderPalette.WHITE;
		scene.overlay.showOutline(white, chassisEffectHighlight, singleBlock, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, twoBlocks, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, threeBlocks, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, twoBlocks, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, singleBlock, 10);
		scene.idle(10);

		scene.idle(30);
		scene.overlay.showControls(new InputWindowElement(chassisSurface, Pointing.UP).whileCTRL()
			.scroll()
			.withWrench(), 40);

		scene.overlay.showOutline(white, chassisEffectHighlight, singleRow, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, twoRows, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, threeRows, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, twoRows, 10);
		scene.idle(10);
		scene.overlay.showOutline(white, chassisEffectHighlight, singleRow, 10);
		scene.idle(10);

		scene.markAsFinished();
	}

	public static void birbScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_birbs", "Birbs");
		scene.showBasePlate();
		scene.idle(10);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
		scene.idle(10);

		BlockPos pos = new BlockPos(1, 2, 3);
		scene.special.birbOnSpinnyShaft(pos);
		scene.overlay.showText(100)
			.colored(PonderPalette.GREEN)
			.text("More birbs = More interesting")
			.pointAt(util.vector.topOf(pos));

		scene.idle(10);
		scene.special.createBirb(util.vector.topOf(0, 1, 2), DancePose::new);
		scene.idle(10);

		scene.special.createBirb(util.vector.centerOf(3, 1, 3)
			.add(0, 0.25f, 0), FacePointOfInterestPose::new);
		scene.idle(20);

		BlockPos poi1 = util.grid.at(4, 1, 0);
		BlockPos poi2 = util.grid.at(0, 1, 4);

		scene.world.setBlock(poi1, Blocks.GOLD_BLOCK.defaultBlockState(), true);
		scene.special.movePointOfInterest(poi1);
		scene.idle(20);

		scene.world.setBlock(poi2, Blocks.GOLD_BLOCK.defaultBlockState(), true);
		scene.special.movePointOfInterest(poi2);
		scene.overlay.showText(20)
			.text("Point of Interest")
			.pointAt(util.vector.centerOf(poi2));
		scene.idle(20);

		scene.world.destroyBlock(poi1);
		scene.special.movePointOfInterest(poi1);
		scene.idle(20);

		scene.world.destroyBlock(poi2);
		scene.special.movePointOfInterest(poi2);
	}

	public static void sectionsScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_sections", "Sections");
		scene.showBasePlate();
		scene.idle(10);
		scene.rotateCameraY(95);

		BlockPos mergePos = util.grid.at(1, 1, 1);
		BlockPos independentPos = util.grid.at(3, 1, 1);
		Selection toMerge = util.select.position(mergePos);
		Selection independent = util.select.position(independentPos);
		Selection start = util.select.layersFrom(1)
			.substract(toMerge)
			.substract(independent);

		scene.world.showSection(start, Direction.DOWN);
		scene.idle(20);

		scene.world.showSection(toMerge, Direction.DOWN);
		ElementLink<WorldSectionElement> link = scene.world.showIndependentSection(independent, Direction.DOWN);

		scene.idle(20);

		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.text("This Section got merged to base.")
			.pointAt(util.vector.topOf(mergePos));
		scene.idle(10);
		scene.overlay.showText(40)
			.colored(PonderPalette.RED)
			.text("This Section renders independently.")
			.pointAt(util.vector.topOf(independentPos));

		scene.idle(40);

		scene.world.hideIndependentSection(link, Direction.DOWN);
		scene.world.hideSection(util.select.fromTo(mergePos, util.grid.at(1, 1, 4)), Direction.DOWN);

		scene.idle(20);

		Selection hiddenReplaceArea = util.select.fromTo(2, 1, 2, 4, 1, 4)
			.substract(util.select.position(4, 1, 3))
			.substract(util.select.position(2, 1, 3));

		scene.world.hideSection(hiddenReplaceArea, Direction.UP);
		scene.idle(20);
		scene.world.setBlocks(hiddenReplaceArea, AllBlocks.REFINED_RADIANCE_CASING.getDefaultState(), false);
		scene.world.showSection(hiddenReplaceArea, Direction.DOWN);
		scene.idle(20);
		scene.overlay.showSelectionWithText(hiddenReplaceArea, 30)
			.colored(PonderPalette.BLUE)
			.text("Seamless substitution of blocks");

		scene.idle(40);

		ElementLink<WorldSectionElement> helicopter = scene.world.makeSectionIndependent(hiddenReplaceArea);
		scene.world.rotateSection(helicopter, 50, 5 * 360, 0, 60);
		scene.world.moveSection(helicopter, util.vector.of(0, 4, 5), 50);
		scene.overlay.showText(30)
			.colored(PonderPalette.BLUE)
			.text("Up, up and away.")
			.independent(30);

		scene.idle(40);
		scene.world.hideIndependentSection(helicopter, Direction.UP);

	}

	public static void itemScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_items", "Manipulating Items");
		scene.configureBasePlate(0, 0, 6);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);

		ItemStack brassItem = AllItems.BRASS_INGOT.asStack();
		ItemStack copperItem = new ItemStack(Items.COPPER_INGOT);

		for (int z = 4; z >= 2; z--) {
			scene.world.createItemEntity(util.vector.centerOf(0, 4, z), Vec3.ZERO, brassItem.copy());
			scene.idle(10);
		}

		BlockPos beltPos = util.grid.at(2, 1, 3);
		ElementLink<BeltItemElement> itemOnBelt =
			scene.world.createItemOnBelt(beltPos, Direction.EAST, copperItem.copy());

		scene.idle(10);
		scene.world.stallBeltItem(itemOnBelt, true);
		scene.idle(5);
		scene.overlay.showText(40)
			.colored(PonderPalette.FAST)
			.text("Belt Items can only be force-stalled on the belt they were created on.")
			.pointAt(util.vector.topOf(2, 1, 2));
		scene.idle(45);
		scene.world.stallBeltItem(itemOnBelt, false);
		scene.idle(20);

		scene.world.modifyEntities(ItemEntity.class, entity -> {
			if (ItemHelper.sameItem(copperItem, entity.getItem()))
				entity.setNoGravity(true);
		});

		scene.idle(20);

		scene.world.modifyEntities(ItemEntity.class, entity -> {
			if (ItemHelper.sameItem(brassItem, entity.getItem()))
				entity.setDeltaMovement(util.vector.of(-.15f, .5f, 0));
		});

		scene.idle(27);

		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
	}
	
	public static void pipeScene(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("debug_pipes", "Manipulating Items");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
	
		
		
		
	}

}
//文件GeneralText.java
package com.simibubi.create.infrastructure.ponder;

import java.util.function.BiConsumer;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.ponder.PonderTooltipHandler;
import com.simibubi.create.foundation.ponder.ui.PonderTagIndexScreen;
import com.simibubi.create.foundation.ponder.ui.PonderTagScreen;
import com.simibubi.create.foundation.ponder.ui.PonderUI;

public class GeneralText {
	public static void provideLang(BiConsumer<String, String> consumer) {
		consume(consumer, PonderTooltipHandler.HOLD_TO_PONDER, "Hold [%1$s] to Ponder");
		consume(consumer, PonderTooltipHandler.SUBJECT, "Subject of this scene");
		consume(consumer, PonderUI.PONDERING, "Pondering about...");
		consume(consumer, PonderUI.IDENTIFY_MODE, "Identify mode active.\nUnpause with [%1$s]");
		consume(consumer, PonderTagScreen.ASSOCIATED, "Associated Entries");

		consume(consumer, PonderUI.CLOSE, "Close");
		consume(consumer, PonderUI.IDENTIFY, "Identify");
		consume(consumer, PonderUI.NEXT, "Next Scene");
		consume(consumer, PonderUI.NEXT_UP, "Up Next:");
		consume(consumer, PonderUI.PREVIOUS, "Previous Scene");
		consume(consumer, PonderUI.REPLAY, "Replay");
		consume(consumer, PonderUI.THINK_BACK, "Think Back");
		consume(consumer, PonderUI.SLOW_TEXT, "Comfy Reading");

		consume(consumer, PonderTagIndexScreen.EXIT, "Exit");
		consume(consumer, PonderTagIndexScreen.WELCOME, "Welcome to Ponder");
		consume(consumer, PonderTagIndexScreen.CATEGORIES, "Available Categories in Create");
		consume(consumer, PonderTagIndexScreen.DESCRIPTION,
			"Click one of the icons to learn about its associated Items and Blocks");
		consume(consumer, PonderTagIndexScreen.TITLE, "Ponder Index");
	}

	private static void consume(BiConsumer<String, String> consumer, String key, String enUS) {
		consumer.accept(Create.ID + "." + key, enUS);
	}
}
//文件PonderIndex.java
package com.simibubi.create.infrastructure.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.simibubi.create.infrastructure.ponder.scenes.ArmScenes;
import com.simibubi.create.infrastructure.ponder.scenes.BearingScenes;
import com.simibubi.create.infrastructure.ponder.scenes.BeltScenes;
import com.simibubi.create.infrastructure.ponder.scenes.CartAssemblerScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ChainDriveScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ChassisScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ChuteScenes;
import com.simibubi.create.infrastructure.ponder.scenes.CrafterScenes;
import com.simibubi.create.infrastructure.ponder.scenes.DeployerScenes;
import com.simibubi.create.infrastructure.ponder.scenes.DetectorScenes;
import com.simibubi.create.infrastructure.ponder.scenes.DisplayScenes;
import com.simibubi.create.infrastructure.ponder.scenes.EjectorScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ElevatorScenes;
import com.simibubi.create.infrastructure.ponder.scenes.FanScenes;
import com.simibubi.create.infrastructure.ponder.scenes.FunnelScenes;
import com.simibubi.create.infrastructure.ponder.scenes.GantryScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ItemVaultScenes;
import com.simibubi.create.infrastructure.ponder.scenes.KineticsScenes;
import com.simibubi.create.infrastructure.ponder.scenes.MechanicalDrillScenes;
import com.simibubi.create.infrastructure.ponder.scenes.MechanicalSawScenes;
import com.simibubi.create.infrastructure.ponder.scenes.MovementActorScenes;
import com.simibubi.create.infrastructure.ponder.scenes.PistonScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ProcessingScenes;
import com.simibubi.create.infrastructure.ponder.scenes.PulleyScenes;
import com.simibubi.create.infrastructure.ponder.scenes.RedstoneScenes;
import com.simibubi.create.infrastructure.ponder.scenes.RedstoneScenes2;
import com.simibubi.create.infrastructure.ponder.scenes.RollerScenes;
import com.simibubi.create.infrastructure.ponder.scenes.SteamScenes;
import com.simibubi.create.infrastructure.ponder.scenes.TunnelScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.DrainScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.FluidMovementActorScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.FluidTankScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.HosePulleyScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.PipeScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.PumpScenes;
import com.simibubi.create.infrastructure.ponder.scenes.fluid.SpoutScenes;
import com.simibubi.create.infrastructure.ponder.scenes.trains.TrackObserverScenes;
import com.simibubi.create.infrastructure.ponder.scenes.trains.TrackScenes;
import com.simibubi.create.infrastructure.ponder.scenes.trains.TrainScenes;
import com.simibubi.create.infrastructure.ponder.scenes.trains.TrainSignalScenes;
import com.simibubi.create.infrastructure.ponder.scenes.trains.TrainStationScenes;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PonderIndex {

	static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(Create.ID);

	public static final boolean REGISTER_DEBUG_SCENES = false;

	public static void register() {
		// Register storyboards here
		// (!) Added entries require re-launch
		// (!) Modifications inside storyboard methods only require re-opening the ui

		HELPER.forComponents(AllBlocks.SHAFT)
			.addStoryBoard("shaft/relay", KineticsScenes::shaftAsRelay, AllPonderTags.KINETIC_RELAYS);
		HELPER.forComponents(AllBlocks.SHAFT, AllBlocks.ANDESITE_ENCASED_SHAFT, AllBlocks.BRASS_ENCASED_SHAFT)
			.addStoryBoard("shaft/encasing", KineticsScenes::shaftsCanBeEncased);

		HELPER.forComponents(AllBlocks.COGWHEEL)
			.addStoryBoard("cog/small", KineticsScenes::cogAsRelay, AllPonderTags.KINETIC_RELAYS)
			.addStoryBoard("cog/speedup", KineticsScenes::cogsSpeedUp)
			.addStoryBoard("cog/encasing", KineticsScenes::cogwheelsCanBeEncased);

		HELPER.forComponents(AllBlocks.LARGE_COGWHEEL)
			.addStoryBoard("cog/speedup", KineticsScenes::cogsSpeedUp)
			.addStoryBoard("cog/large", KineticsScenes::largeCogAsRelay, AllPonderTags.KINETIC_RELAYS)
			.addStoryBoard("cog/encasing", KineticsScenes::cogwheelsCanBeEncased);

		HELPER.forComponents(AllItems.BELT_CONNECTOR)
			.addStoryBoard("belt/connect", BeltScenes::beltConnector, AllPonderTags.KINETIC_RELAYS)
			.addStoryBoard("belt/directions", BeltScenes::directions)
			.addStoryBoard("belt/transport", BeltScenes::transport, AllPonderTags.LOGISTICS)
			.addStoryBoard("belt/encasing", BeltScenes::beltsCanBeEncased);

		HELPER.forComponents(AllBlocks.ANDESITE_CASING, AllBlocks.BRASS_CASING)
			.addStoryBoard("shaft/encasing", KineticsScenes::shaftsCanBeEncased)
			.addStoryBoard("belt/encasing", BeltScenes::beltsCanBeEncased);

		HELPER.forComponents(AllBlocks.GEARBOX, AllItems.VERTICAL_GEARBOX)
			.addStoryBoard("gearbox", KineticsScenes::gearbox, AllPonderTags.KINETIC_RELAYS);

		HELPER.addStoryBoard(AllBlocks.CLUTCH, "clutch", KineticsScenes::clutch, AllPonderTags.KINETIC_RELAYS);
		HELPER.addStoryBoard(AllBlocks.GEARSHIFT, "gearshift", KineticsScenes::gearshift, AllPonderTags.KINETIC_RELAYS);

		HELPER.forComponents(AllBlocks.SEQUENCED_GEARSHIFT)
			.addStoryBoard("sequenced_gearshift", KineticsScenes::sequencedGearshift);

		HELPER.forComponents(AllBlocks.ENCASED_FAN)
			.addStoryBoard("fan/direction", FanScenes::direction, AllPonderTags.KINETIC_APPLIANCES)
			.addStoryBoard("fan/processing", FanScenes::processing);

		HELPER.forComponents(AllBlocks.CREATIVE_MOTOR)
			.addStoryBoard("creative_motor", KineticsScenes::creativeMotor, AllPonderTags.KINETIC_SOURCES)
			.addStoryBoard("creative_motor_mojang", KineticsScenes::creativeMotorMojang);
		HELPER.addStoryBoard(AllBlocks.WATER_WHEEL, "water_wheel", KineticsScenes::waterWheel,
			AllPonderTags.KINETIC_SOURCES);
		HELPER.addStoryBoard(AllBlocks.LARGE_WATER_WHEEL, "large_water_wheel", KineticsScenes::largeWaterWheel,
			AllPonderTags.KINETIC_SOURCES);
		
		HELPER.addStoryBoard(AllBlocks.HAND_CRANK, "hand_crank", KineticsScenes::handCrank, AllPonderTags.KINETIC_SOURCES);

		HELPER.addStoryBoard(AllBlocks.COPPER_VALVE_HANDLE, "valve_handle", KineticsScenes::valveHandle,
			AllPonderTags.KINETIC_SOURCES);
		HELPER.forComponents(AllBlocks.DYED_VALVE_HANDLES.toArray())
			.addStoryBoard("valve_handle", KineticsScenes::valveHandle);

		HELPER.addStoryBoard(AllBlocks.ENCASED_CHAIN_DRIVE, "chain_drive/relay", ChainDriveScenes::chainDriveAsRelay,
			AllPonderTags.KINETIC_RELAYS);
		HELPER.forComponents(AllBlocks.ENCASED_CHAIN_DRIVE, AllBlocks.ADJUSTABLE_CHAIN_GEARSHIFT)
			.addStoryBoard("chain_drive/gearshift", ChainDriveScenes::adjustableChainGearshift);

		HELPER.forComponents(AllBlocks.ROTATION_SPEED_CONTROLLER)
			.addStoryBoard("speed_controller", KineticsScenes::speedController);

		// Gauges
		HELPER.addStoryBoard(AllBlocks.SPEEDOMETER, "gauges", KineticsScenes::speedometer);
		HELPER.addStoryBoard(AllBlocks.STRESSOMETER, "gauges", KineticsScenes::stressometer);

		// Item Processing
		HELPER.addStoryBoard(AllBlocks.MILLSTONE, "millstone", ProcessingScenes::millstone);
		HELPER.addStoryBoard(AllBlocks.CRUSHING_WHEEL, "crushing_wheel", ProcessingScenes::crushingWheels);
		HELPER.addStoryBoard(AllBlocks.MECHANICAL_MIXER, "mechanical_mixer/mixing", ProcessingScenes::mixing);
		HELPER.forComponents(AllBlocks.MECHANICAL_PRESS)
			.addStoryBoard("mechanical_press/pressing", ProcessingScenes::pressing)
			.addStoryBoard("mechanical_press/compacting", ProcessingScenes::compacting);
		HELPER.forComponents(AllBlocks.BASIN)
			.addStoryBoard("basin", ProcessingScenes::basin)
			.addStoryBoard("mechanical_mixer/mixing", ProcessingScenes::mixing)
			.addStoryBoard("mechanical_press/compacting", ProcessingScenes::compacting);
		HELPER.addStoryBoard(AllItems.EMPTY_BLAZE_BURNER, "empty_blaze_burner", ProcessingScenes::emptyBlazeBurner);
		HELPER.addStoryBoard(AllBlocks.BLAZE_BURNER, "blaze_burner", ProcessingScenes::blazeBurner);
		HELPER.addStoryBoard(AllBlocks.DEPOT, "depot", BeltScenes::depot);
		HELPER.forComponents(AllBlocks.WEIGHTED_EJECTOR)
			.addStoryBoard("weighted_ejector/eject", EjectorScenes::ejector)
			.addStoryBoard("weighted_ejector/split", EjectorScenes::splitY)
			.addStoryBoard("weighted_ejector/redstone", EjectorScenes::redstone);

		// Crafters
		HELPER.forComponents(AllBlocks.MECHANICAL_CRAFTER)
			.addStoryBoard("mechanical_crafter/setup", CrafterScenes::setup)
			.addStoryBoard("mechanical_crafter/connect", CrafterScenes::connect);
		HELPER.forComponents(AllBlocks.MECHANICAL_CRAFTER, AllItems.CRAFTER_SLOT_COVER)
			.addStoryBoard("mechanical_crafter/covers", CrafterScenes::covers);

		// Vaults
		HELPER.forComponents(AllBlocks.ITEM_VAULT)
			.addStoryBoard("item_vault/storage", ItemVaultScenes::storage, AllPonderTags.LOGISTICS)
			.addStoryBoard("item_vault/sizes", ItemVaultScenes::sizes);

		// Chutes
		HELPER.forComponents(AllBlocks.CHUTE)
			.addStoryBoard("chute/downward", ChuteScenes::downward, AllPonderTags.LOGISTICS)
			.addStoryBoard("chute/upward", ChuteScenes::upward);
		HELPER.forComponents(AllBlocks.CHUTE, AllBlocks.SMART_CHUTE)
			.addStoryBoard("chute/smart", ChuteScenes::smart);

		// Funnels
		HELPER.addStoryBoard(AllBlocks.BRASS_FUNNEL, "funnels/brass", FunnelScenes::brass);
		HELPER.forComponents(AllBlocks.ANDESITE_FUNNEL, AllBlocks.BRASS_FUNNEL)
			.addStoryBoard("funnels/intro", FunnelScenes::intro, AllPonderTags.LOGISTICS)
			.addStoryBoard("funnels/direction", FunnelScenes::directionality)
			.addStoryBoard("funnels/compat", FunnelScenes::compat)
			.addStoryBoard("funnels/redstone", FunnelScenes::redstone)
			.addStoryBoard("funnels/transposer", FunnelScenes::transposer);
		HELPER.addStoryBoard(AllBlocks.ANDESITE_FUNNEL, "funnels/brass", FunnelScenes::brass);

		// Tunnels
		HELPER.addStoryBoard(AllBlocks.ANDESITE_TUNNEL, "tunnels/andesite", TunnelScenes::andesite);
		HELPER.forComponents(AllBlocks.BRASS_TUNNEL)
			.addStoryBoard("tunnels/brass", TunnelScenes::brass)
			.addStoryBoard("tunnels/brass_modes", TunnelScenes::brassModes);

		// Chassis & Super Glue
		HELPER.forComponents(AllBlocks.LINEAR_CHASSIS, AllBlocks.SECONDARY_LINEAR_CHASSIS)
			.addStoryBoard("chassis/linear_group", ChassisScenes::linearGroup, AllPonderTags.CONTRAPTION_ASSEMBLY)
			.addStoryBoard("chassis/linear_attachment", ChassisScenes::linearAttachement);
		HELPER.forComponents(AllBlocks.RADIAL_CHASSIS)
			.addStoryBoard("chassis/radial", ChassisScenes::radial, AllPonderTags.CONTRAPTION_ASSEMBLY);
		HELPER.forComponents(AllItems.SUPER_GLUE)
			.addStoryBoard("super_glue", ChassisScenes::superGlue, AllPonderTags.CONTRAPTION_ASSEMBLY);
		HELPER.forComponents(AllBlocks.STICKER)
			.addStoryBoard("sticker", RedstoneScenes::sticker, AllPonderTags.CONTRAPTION_ASSEMBLY);

		// Mechanical Arm
		HELPER.forComponents(AllBlocks.MECHANICAL_ARM)
			.addStoryBoard("mechanical_arm/setup", ArmScenes::setup, AllPonderTags.ARM_TARGETS)
			.addStoryBoard("mechanical_arm/filter", ArmScenes::filtering)
			.addStoryBoard("mechanical_arm/modes", ArmScenes::modes)
			.addStoryBoard("mechanical_arm/redstone", ArmScenes::redstone);

		// Mechanical Piston
		HELPER.forComponents(AllBlocks.MECHANICAL_PISTON, AllBlocks.STICKY_MECHANICAL_PISTON)
			.addStoryBoard("mechanical_piston/anchor", PistonScenes::movement, AllPonderTags.KINETIC_APPLIANCES,
				AllPonderTags.MOVEMENT_ANCHOR);
		HELPER
			.forComponents(AllBlocks.MECHANICAL_PISTON, AllBlocks.STICKY_MECHANICAL_PISTON,
				AllBlocks.PISTON_EXTENSION_POLE)
			.addStoryBoard("mechanical_piston/piston_pole", PistonScenes::poles);
		HELPER.forComponents(AllBlocks.MECHANICAL_PISTON, AllBlocks.STICKY_MECHANICAL_PISTON)
			.addStoryBoard("mechanical_piston/modes", PistonScenes::movementModes);

		// Pulleys
		HELPER.forComponents(AllBlocks.ROPE_PULLEY)
			.addStoryBoard("rope_pulley/anchor", PulleyScenes::movement, AllPonderTags.KINETIC_APPLIANCES,
				AllPonderTags.MOVEMENT_ANCHOR)
			.addStoryBoard("rope_pulley/modes", PulleyScenes::movementModes)
			.addStoryBoard("rope_pulley/multi_rope", PulleyScenes::multiRope)
			.addStoryBoard("rope_pulley/attachment", PulleyScenes::attachment);
		HELPER.forComponents(AllBlocks.ELEVATOR_PULLEY)
			.addStoryBoard("elevator_pulley/elevator", ElevatorScenes::elevator)
			.addStoryBoard("elevator_pulley/multi_rope", ElevatorScenes::multiRope);

		// Windmill Bearing
		HELPER.forComponents(AllBlocks.WINDMILL_BEARING)
			.addStoryBoard("windmill_bearing/source", BearingScenes::windmillsAsSource, AllPonderTags.KINETIC_SOURCES)
			.addStoryBoard("windmill_bearing/structure", BearingScenes::windmillsAnyStructure,
				AllPonderTags.MOVEMENT_ANCHOR);
		HELPER.forComponents(AllBlocks.SAIL)
			.addStoryBoard("sail", BearingScenes::sail);
		HELPER.forComponents(AllBlocks.SAIL_FRAME)
			.addStoryBoard("sail", BearingScenes::sailFrame);

		// Mechanical Bearing
		HELPER.forComponents(AllBlocks.MECHANICAL_BEARING)
			.addStoryBoard("mechanical_bearing/anchor", BearingScenes::mechanicalBearing, AllPonderTags.KINETIC_APPLIANCES,
				AllPonderTags.MOVEMENT_ANCHOR)
			.addStoryBoard("mechanical_bearing/modes", BearingScenes::bearingModes)
			.addStoryBoard("mechanical_bearing/stabilized", BearingScenes::stabilizedBearings,
				AllPonderTags.CONTRAPTION_ACTOR);

		// Clockwork Bearing
		HELPER.addStoryBoard(AllBlocks.CLOCKWORK_BEARING, "clockwork_bearing", BearingScenes::clockwork,
			AllPonderTags.KINETIC_APPLIANCES, AllPonderTags.MOVEMENT_ANCHOR);

		// Gantries
		HELPER.addStoryBoard(AllBlocks.GANTRY_SHAFT, "gantry/intro", GantryScenes::introForShaft,
			AllPonderTags.KINETIC_APPLIANCES, AllPonderTags.MOVEMENT_ANCHOR);
		HELPER.addStoryBoard(AllBlocks.GANTRY_CARRIAGE, "gantry/intro", GantryScenes::introForPinion,
			AllPonderTags.KINETIC_APPLIANCES, AllPonderTags.MOVEMENT_ANCHOR);
		HELPER.forComponents(AllBlocks.GANTRY_SHAFT, AllBlocks.GANTRY_CARRIAGE)
			.addStoryBoard("gantry/redstone", GantryScenes::redstone)
			.addStoryBoard("gantry/direction", GantryScenes::direction)
			.addStoryBoard("gantry/subgantry", GantryScenes::subgantry);

		// Cart Assembler
		HELPER.forComponents(AllBlocks.CART_ASSEMBLER)
			.addStoryBoard("cart_assembler/anchor", CartAssemblerScenes::anchor, AllPonderTags.MOVEMENT_ANCHOR)
			.addStoryBoard("cart_assembler/modes", CartAssemblerScenes::modes)
			.addStoryBoard("cart_assembler/dual", CartAssemblerScenes::dual)
			.addStoryBoard("cart_assembler/rails", CartAssemblerScenes::rails);

		// Movement Actors
		HELPER.forComponents(AllBlocks.PORTABLE_STORAGE_INTERFACE)
			.addStoryBoard("portable_interface/transfer", MovementActorScenes::psiTransfer, AllPonderTags.CONTRAPTION_ACTOR)
			.addStoryBoard("portable_interface/redstone", MovementActorScenes::psiRedstone);
		HELPER.forComponents(AllBlocks.REDSTONE_CONTACT)
			.addStoryBoard("redstone_contact", RedstoneScenes::contact);
		HELPER.forComponents(AllBlocks.MECHANICAL_SAW)
			.addStoryBoard("mechanical_saw/processing", MechanicalSawScenes::processing, AllPonderTags.KINETIC_APPLIANCES)
			.addStoryBoard("mechanical_saw/breaker", MechanicalSawScenes::treeCutting)
			.addStoryBoard("mechanical_saw/contraption", MechanicalSawScenes::contraption, AllPonderTags.CONTRAPTION_ACTOR);
		HELPER.forComponents(AllBlocks.MECHANICAL_DRILL)
			.addStoryBoard("mechanical_drill/breaker", MechanicalDrillScenes::breaker, AllPonderTags.KINETIC_APPLIANCES)
			.addStoryBoard("mechanical_drill/contraption", MechanicalDrillScenes::contraption,
				AllPonderTags.CONTRAPTION_ACTOR);
		HELPER.forComponents(AllBlocks.DEPLOYER)
			.addStoryBoard("deployer/filter", DeployerScenes::filter, AllPonderTags.KINETIC_APPLIANCES)
			.addStoryBoard("deployer/modes", DeployerScenes::modes)
			.addStoryBoard("deployer/processing", DeployerScenes::processing)
			.addStoryBoard("deployer/redstone", DeployerScenes::redstone)
			.addStoryBoard("deployer/contraption", DeployerScenes::contraption, AllPonderTags.CONTRAPTION_ACTOR);
		HELPER.forComponents(AllBlocks.MECHANICAL_HARVESTER)
			.addStoryBoard("harvester", MovementActorScenes::harvester);
		HELPER.forComponents(AllBlocks.MECHANICAL_PLOUGH)
			.addStoryBoard("plough", MovementActorScenes::plough);
		HELPER.forComponents(AllBlocks.CONTRAPTION_CONTROLS)
			.addStoryBoard("contraption_controls", MovementActorScenes::contraptionControls);
		HELPER.forComponents(AllBlocks.MECHANICAL_ROLLER)
			.addStoryBoard("mechanical_roller/clear_and_pave", RollerScenes::clearAndPave)
			.addStoryBoard("mechanical_roller/fill", RollerScenes::fill);

		// Fluids
		HELPER.forComponents(AllBlocks.FLUID_PIPE)
			.addStoryBoard("fluid_pipe/flow", PipeScenes::flow, AllPonderTags.FLUIDS)
			.addStoryBoard("fluid_pipe/interaction", PipeScenes::interaction)
			.addStoryBoard("fluid_pipe/encasing", PipeScenes::encasing);
		HELPER.forComponents(AllBlocks.COPPER_CASING)
			.addStoryBoard("fluid_pipe/encasing", PipeScenes::encasing);
		HELPER.forComponents(AllBlocks.MECHANICAL_PUMP)
			.addStoryBoard("mechanical_pump/flow", PumpScenes::flow, AllPonderTags.FLUIDS, AllPonderTags.KINETIC_APPLIANCES)
			.addStoryBoard("mechanical_pump/speed", PumpScenes::speed);
		HELPER.forComponents(AllBlocks.FLUID_VALVE)
			.addStoryBoard("fluid_valve", PipeScenes::valve, AllPonderTags.FLUIDS, AllPonderTags.KINETIC_APPLIANCES);
		HELPER.forComponents(AllBlocks.SMART_FLUID_PIPE)
			.addStoryBoard("smart_pipe", PipeScenes::smart, AllPonderTags.FLUIDS);
		HELPER.forComponents(AllBlocks.FLUID_TANK)
			.addStoryBoard("fluid_tank/storage", FluidTankScenes::storage, AllPonderTags.FLUIDS)
			.addStoryBoard("fluid_tank/sizes", FluidTankScenes::sizes);
		HELPER.forComponents(AllBlocks.CREATIVE_FLUID_TANK)
			.addStoryBoard("fluid_tank/storage_creative", FluidTankScenes::creative, AllPonderTags.FLUIDS,
				AllPonderTags.CREATIVE)
			.addStoryBoard("fluid_tank/sizes_creative", FluidTankScenes::sizes);
		HELPER.forComponents(AllBlocks.HOSE_PULLEY)
			.addStoryBoard("hose_pulley/intro", HosePulleyScenes::intro, AllPonderTags.FLUIDS, AllPonderTags.KINETIC_APPLIANCES)
			.addStoryBoard("hose_pulley/level", HosePulleyScenes::level)
			.addStoryBoard("hose_pulley/infinite", HosePulleyScenes::infinite);
		HELPER.forComponents(AllBlocks.SPOUT)
			.addStoryBoard("spout", SpoutScenes::filling, AllPonderTags.FLUIDS);
		HELPER.forComponents(AllBlocks.ITEM_DRAIN)
			.addStoryBoard("item_drain", DrainScenes::emptying, AllPonderTags.FLUIDS);
		HELPER.forComponents(AllBlocks.PORTABLE_FLUID_INTERFACE)
			.addStoryBoard("portable_interface/transfer_fluid", FluidMovementActorScenes::transfer, AllPonderTags.FLUIDS,
				AllPonderTags.CONTRAPTION_ACTOR)
			.addStoryBoard("portable_interface/redstone_fluid", MovementActorScenes::psiRedstone);

		// Redstone
		HELPER.forComponents(AllBlocks.PULSE_EXTENDER)
			.addStoryBoard("pulse_extender", RedstoneScenes::pulseExtender);
		HELPER.forComponents(AllBlocks.PULSE_REPEATER)
			.addStoryBoard("pulse_repeater", RedstoneScenes::pulseRepeater);
		HELPER.forComponents(AllBlocks.POWERED_LATCH)
			.addStoryBoard("powered_latch", RedstoneScenes::poweredLatch);
		HELPER.forComponents(AllBlocks.POWERED_TOGGLE_LATCH)
			.addStoryBoard("powered_toggle_latch", RedstoneScenes::poweredToggleLatch);
		HELPER.forComponents(AllBlocks.ANALOG_LEVER)
			.addStoryBoard("analog_lever", RedstoneScenes::analogLever);
		HELPER.forComponents(AllBlocks.ORANGE_NIXIE_TUBE)
			.addStoryBoard("nixie_tube", RedstoneScenes::nixieTube);
		HELPER.forComponents(AllBlocks.REDSTONE_LINK)
			.addStoryBoard("redstone_link", RedstoneScenes::redstoneLink);
		HELPER.forComponents(AllBlocks.ROSE_QUARTZ_LAMP)
			.addStoryBoard("rose_quartz_lamp", RedstoneScenes2::roseQuartzLamp);

		HELPER.forComponents(AllBlocks.SMART_OBSERVER)
			.addStoryBoard("smart_observer", DetectorScenes::smartObserver);
		HELPER.forComponents(AllBlocks.THRESHOLD_SWITCH)
			.addStoryBoard("threshold_switch", DetectorScenes::thresholdSwitch);

		// Trains
		HELPER.forComponents(TrackMaterial.allBlocks()
			.stream()
			.map((trackSupplier) -> new BlockEntry<TrackBlock>(
				// note: these blocks probably WON'T be in the Create Registrate, but a simple
				// code trace reveals the Entry's registrate isn't used
				Create.REGISTRATE,
				RegistryObject.create(ForgeRegistries.BLOCKS.getKey(trackSupplier.get()), ForgeRegistries.BLOCKS)))
			.toList())
			.addStoryBoard("train_track/placement", TrackScenes::placement)
			.addStoryBoard("train_track/portal", TrackScenes::portal)
			.addStoryBoard("train_track/chunks", TrackScenes::chunks);

		HELPER.forComponents(AllBlocks.TRACK_STATION)
			.addStoryBoard("train_station/assembly", TrainStationScenes::assembly)
			.addStoryBoard("train_station/schedule", TrainStationScenes::autoSchedule);

		HELPER.forComponents(AllBlocks.TRACK_SIGNAL)
			.addStoryBoard("train_signal/placement", TrainSignalScenes::placement)
			.addStoryBoard("train_signal/signaling", TrainSignalScenes::signaling)
			.addStoryBoard("train_signal/redstone", TrainSignalScenes::redstone);

		HELPER.forComponents(AllItems.SCHEDULE)
			.addStoryBoard("train_schedule", TrainScenes::schedule);

		HELPER.forComponents(AllBlocks.TRAIN_CONTROLS)
			.addStoryBoard("train_controls", TrainScenes::controls);

		HELPER.forComponents(AllBlocks.TRACK_OBSERVER)
			.addStoryBoard("train_observer", TrackObserverScenes::observe);

		// Display Link
		HELPER.forComponents(AllBlocks.DISPLAY_LINK)
			.addStoryBoard("display_link", DisplayScenes::link)
			.addStoryBoard("display_link_redstone", DisplayScenes::redstone);
		HELPER.forComponents(AllBlocks.DISPLAY_BOARD)
			.addStoryBoard("display_board", DisplayScenes::board);

		// Steam
		HELPER.forComponents(AllBlocks.STEAM_WHISTLE)
			.addStoryBoard("steam_whistle", SteamScenes::whistle);
		HELPER.forComponents(AllBlocks.STEAM_ENGINE)
			.addStoryBoard("steam_engine", SteamScenes::engine);

		// Debug scenes, can be found in game via the Brass Hand
		if (REGISTER_DEBUG_SCENES)
			DebugScenes.registerAll();
	}

	public static boolean editingModeActive() {
		return AllConfigs.client().editingMode.get();
	}

}
//文件scenes/ArmScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlockEntity;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmBlockEntity.Phase;
import com.simibubi.create.content.logistics.funnel.FunnelBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ArmScenes {

	public static void setup(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_arm", "Setting up Mechanical Arms");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		ItemStack armItem = AllBlocks.MECHANICAL_ARM.asStack();
		BlockPos armPos = util.grid.at(2, 1, 2);
		Selection armSel = util.select.position(armPos);
		BlockPos inputDepot = util.grid.at(4, 2, 1);
		Vec3 depotSurface = util.vector.blockSurface(inputDepot, Direction.NORTH);
		Vec3 armSurface = util.vector.blockSurface(armPos, Direction.WEST);

		scene.idle(20);

		scene.world.setKineticSpeed(armSel, 0);
		scene.world.showSection(armSel, Direction.DOWN);
		scene.idle(10);
		scene.effects.indicateRedstone(armPos);
		scene.overlay.showSelectionWithText(armSel, 70)
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.text("Mechanical Arms have to be assigned their in- and outputs before they are placed")
			.pointAt(armSurface)
			.placeNearTarget();
		scene.idle(80);
		scene.world.showSection(util.select.fromTo(4, 1, 1, 4, 2, 1), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(0, 1, 1, 0, 2, 1), Direction.DOWN);
		scene.world.hideSection(armSel, Direction.UP);
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(depotSurface, Pointing.RIGHT).rightClick()
			.withItem(armItem), 50);
		scene.idle(7);
		AABB depotBounds = AllShapes.CASING_13PX.get(Direction.UP)
			.bounds();
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, new Object(), depotBounds.move(4, 2, 1), 400);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.colored(PonderPalette.INPUT)
			.text("Right-Click inventories while holding the Arm to assign them as Targets")
			.pointAt(util.vector.blockSurface(inputDepot, Direction.WEST))
			.placeNearTarget();
		scene.idle(80);

		BlockPos outputDepot = util.grid.at(0, 2, 1);
		InputWindowElement input =
			new InputWindowElement(util.vector.blockSurface(outputDepot, Direction.NORTH), Pointing.RIGHT).rightClick()
				.withItem(armItem);
		scene.overlay.showControls(input, 20);
		scene.idle(7);
		Object second = new Object();
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, second, depotBounds.move(0, 2, 1), 100);
		scene.idle(25);
		scene.overlay.showControls(input, 30);
		scene.idle(7);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, second, depotBounds.move(0, 2, 1), 280);
		scene.overlay.showText(70)
			.colored(PonderPalette.OUTPUT)
			.text("Right-Click again to toggle between Input (Blue) and Output (Yellow)")
			.pointAt(util.vector.blockSurface(outputDepot, Direction.WEST))
			.placeNearTarget();

		scene.idle(80);
		scene.world.showSection(util.select.position(1, 1, 0), Direction.DOWN);
		scene.idle(15);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, new Object(), depotBounds.move(1, 1, 0), 43);

		scene.overlay.showText(50)
			.colored(PonderPalette.WHITE)
			.text("Left-Click components to remove their Selection")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 0), Direction.WEST))
			.placeNearTarget();

		scene.idle(35);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(1, 1, 0)), Pointing.DOWN).leftClick()
				.withItem(armItem), 30);
		scene.idle(50);

		scene.world.showSection(armSel, Direction.DOWN);
		scene.idle(10);
		Vec3 armTop = armSurface.add(0.5, 1.5, 0);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("Once placed, the Mechanical Arm will target the blocks selected previously")
			.pointAt(armTop)
			.placeNearTarget();
		scene.idle(80);

		scene.effects.indicateSuccess(armPos);
		scene.world.showSection(util.select.fromTo(2, 1, 5, 2, 1, 3)
			.add(util.select.position(2, 0, 5)), Direction.DOWN);
		ItemStack copper = new ItemStack(Items.COPPER_INGOT);
		scene.world.createItemOnBeltLike(inputDepot, Direction.SOUTH, copper);
		scene.idle(10);

		scene.world.setKineticSpeed(armSel, -48);
		scene.idle(20);
		scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 1);
		scene.idle(24);
		scene.world.removeItemsFromBelt(inputDepot);
		scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, copper, -1);
		scene.idle(20);
		scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, copper, 1);
		scene.idle(24);
		scene.world.createItemOnBeltLike(outputDepot, Direction.UP, copper);
		scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, ItemStack.EMPTY, -1);
		scene.idle(44);

		scene.world.showSection(util.select.fromTo(1, 1, 4, 1, 3, 4), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(4, 1, 2), Direction.DOWN);
		scene.idle(5);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, new Object(), depotBounds.move(0, 2, 1), 60);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, new Object(), depotBounds.move(4, 2, 1), 60);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, new Object(), depotBounds.move(1, 1, 0), 60);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, new Object(), depotBounds.move(1, 3, 4), 60);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, new Object(), depotBounds.move(4, 1, 2), 60);
		scene.idle(5);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("They can have any amount of in- and outputs within their range")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 3, 4), Direction.WEST))
			.placeNearTarget();

		inputDepot = util.grid.at(1, 3, 4);
		outputDepot = util.grid.at(1, 1, 0);
		copper = new ItemStack(Items.COPPER_BLOCK);
		scene.world.createItemOnBeltLike(inputDepot, Direction.SOUTH, copper);
		scene.idle(20);
		scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 2);
		scene.idle(24);
		scene.world.removeItemsFromBelt(inputDepot);
		scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, copper, -1);
		scene.idle(20);
		scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, copper, 0);
		scene.idle(24);
		scene.world.createItemOnBeltLike(outputDepot, Direction.UP, copper);
		scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, ItemStack.EMPTY, -1);

		scene.world.hideSection(util.select.fromTo(4, 2, 1, 4, 1, 1), Direction.UP);
		scene.idle(2);
		scene.world.hideSection(util.select.fromTo(1, 1, 4, 1, 3, 4), Direction.UP);
		scene.idle(5);
		scene.world.hideSection(util.select.fromTo(0, 1, 1, 0, 2, 1), Direction.UP);
		scene.idle(2);
		scene.world.hideSection(util.select.position(1, 1, 0), Direction.UP);
		scene.idle(5);
		scene.world.hideSection(util.select.position(4, 1, 2), Direction.UP);
		scene.idle(15);

		scene.world.showSection(util.select.fromTo(4, 1, 3, 4, 2, 3), Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(0, 1, 3, 0, 2, 3), Direction.NORTH);
		scene.idle(15);

		Object in = new Object();
		Object out = new Object();
		AABB chestBounds = new AABB(1 / 16f, 0, 1 / 16f, 15 / 16f, 14 / 16f, 15 / 16f);
		AABB funnelBounds = new AABB(0, 0, 8 / 16f, 16 / 16f, 16 / 16f, 16 / 16f);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, in, chestBounds.move(4, 2, 3), 120);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, out, chestBounds.move(0, 2, 3), 120);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("However, not every type of Inventory can be interacted with directly")
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(0, 2, 3), Direction.WEST));
		scene.idle(90);

		scene.world.showSection(util.select.fromTo(4, 1, 2, 4, 2, 2), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.position(0, 2, 2), Direction.SOUTH);
		scene.idle(10);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, in, depotBounds.move(4, 1, 2), 80);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, out, funnelBounds.move(0, 2, 2), 80);
		scene.idle(5);

		scene.overlay.showText(60)
			.text("Funnels and Depots can help to Bridge that gap")
			.colored(PonderPalette.OUTPUT)
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(0, 2, 2))
				.add(0, 0, 0.25));
		scene.idle(70);
		ItemStack sword = new ItemStack(Items.GOLDEN_SWORD);
		inputDepot = util.grid.at(4, 1, 2);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(inputDepot), Pointing.RIGHT).withItem(sword), 30);
		scene.world.createItemOnBeltLike(inputDepot, Direction.SOUTH, sword);

		scene.idle(20);
		scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 0);
		scene.idle(24);
		scene.world.removeItemsFromBelt(inputDepot);
		scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, sword, -1);
		scene.idle(20);
		scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, sword, 2);
		scene.idle(24);
		scene.world.flapFunnel(util.grid.at(0, 2, 2), false);
		scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, ItemStack.EMPTY, -1);
		scene.idle(5);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(0, 2, 3), Direction.WEST), Pointing.LEFT)
				.withItem(sword),
			30);

	}

	public static void filtering(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_arm_filtering", "Filtering Outputs of the Mechanical Arm");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.9f);
		scene.world.setKineticSpeed(util.select.fromTo(4, 1, 4, 6, 0, 5), 0);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(4, 1, 4, 5, 1, 5), Direction.DOWN);
		scene.idle(10);

		for (int x = 0; x < 2; x++) {
			scene.idle(3);
			scene.world.showSection(util.select.position(x + 1, 1, 4), Direction.DOWN);
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				scene.world.showSection(util.select.position(y == 1 ? x + 3 : 5 - x, y + 1, 1), Direction.DOWN);
				scene.idle(2);
			}
		}
		
		scene.world.showSection(util.select.position(6, 1, 1), Direction.WEST);
		scene.world.showSection(util.select.position(2, 1, 1), Direction.EAST);

		ItemStack sand = new ItemStack(Items.SAND, 64);
		ItemStack sulphur = new ItemStack(Items.GUNPOWDER, 64);
		scene.world.createItemOnBeltLike(util.grid.at(2, 1, 4), Direction.SOUTH, sand);
		scene.world.createItemOnBeltLike(util.grid.at(1, 1, 4), Direction.SOUTH, sulphur);

		scene.overlay.showSelectionWithText(util.select.fromTo(2, 1, 4, 1, 1, 4), 60)
			.text("Inputs")
			.placeNearTarget()
			.colored(PonderPalette.INPUT);
		scene.idle(50);
		scene.overlay.showSelectionWithText(util.select.fromTo(5, 3, 1, 3, 1, 1), 40)
			.text("Outputs")
			.placeNearTarget()
			.colored(PonderPalette.OUTPUT);
		scene.idle(50);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Sometimes it is desirable to restrict targets of the Arm by matching a filter")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 3, 1), Direction.WEST));

		scene.idle(90);
		scene.rotateCameraY(-90 - 30);
		scene.idle(20);

		scene.overlay.showSelectionWithText(util.select.position(4, 1, 4), 80)
			.colored(PonderPalette.RED)
			.text("Mechanical Arms by themselves do not provide any options for filtering")
			.placeNearTarget();
		scene.idle(90);

		for (int y = 0; y < 3; y++) {
			scene.world.showSection(util.select.fromTo(5, y + 1, 2, 3, y + 1, 2), Direction.NORTH);
			scene.idle(2);
		}

		Vec3 filterSlot = util.vector.of(3.5, 3.75, 2.6);
		scene.overlay.showFilterSlotInput(filterSlot, Direction.NORTH, 80);
		scene.idle(10);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.pointAt(filterSlot)
			.text("Brass Funnels as Targets do however communicate their own filter to the Arm")
			.placeNearTarget();
		scene.idle(90);

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				ItemStack item = (x + y) % 2 == 0 ? sulphur : sand;
				scene.overlay
					.showControls(new InputWindowElement(filterSlot.add(2 - x, -y, 0), Pointing.LEFT).rightClick()
						.withItem(item), 5);
				scene.idle(7);
				scene.world.setFilterData(util.select.position(5 - x, 3 - y, 2), FunnelBlockEntity.class, item);
				scene.idle(4);
			}
		}

		scene.world.setKineticSpeed(util.select.fromTo(4, 1, 4, 6, 0, 5), 24);
		scene.world.multiplyKineticSpeed(util.select.position(5, 1, 5), -1);
		scene.world.multiplyKineticSpeed(util.select.position(4, 1, 4), 2);
		scene.idle(10);

		BlockPos armPos = util.grid.at(4, 1, 4);
		scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 1);
		scene.idle(24);
		scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, sand, -1);
		scene.idle(20);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(2, 1, 4))
			.text("The Arm is smart enough not to pick up items it couldn't distribute")
			.placeNearTarget();
		scene.idle(90);

		for (int i = 0; i < 4; i++) {
			int index = i * 2 + 1;
			scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, sand, index);
			scene.idle(24);
			BlockPos funnelPos = util.grid.at(5 - index % 3, 1 + index / 3, 2);
			scene.world.flapFunnel(funnelPos, false);
			scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, i == 3 ? ItemStack.EMPTY : sand, -1);
			scene.world.modifyBlockEntity(funnelPos.north(), MechanicalCrafterBlockEntity.class, mct -> mct.getInventory()
				.insertItem(0, sand.copy(), false));
			scene.idle(10);
		}

		scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 0);
		scene.idle(24);
		scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, sulphur, -1);
		scene.idle(20);

		scene.rotateCameraY(120);
		scene.world.setCraftingResult(util.grid.at(3, 1, 1), new ItemStack(Blocks.TNT));

		for (int i = 0; i < 5; i++) {
			int index = i * 2;
			scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, sulphur, index);
			scene.idle(24);
			BlockPos funnelPos = util.grid.at(3 + index % 3, 1 + index / 3, 2);
			scene.world.flapFunnel(funnelPos, false);
			scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, i == 4 ? ItemStack.EMPTY : sulphur, -1);
			scene.world.modifyBlockEntity(funnelPos.north(), MechanicalCrafterBlockEntity.class, mct -> mct.getInventory()
				.insertItem(0, sulphur.copy(), false));
			scene.idle(10);
		}

		scene.idle(120);
	}

	public static void modes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_arm_modes", "Distribution modes of the Mechanical Arm");
		scene.configureBasePlate(0, 1, 5);
		scene.world.setBlock(util.grid.at(3, 1, 0), Blocks.BARRIER.defaultBlockState(), false);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 4, 4, 1, 5), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 4, 1, 2, 5), Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 1, 5, 1, 2), Direction.SOUTH);
		scene.idle(10);

		AABB depotBox = AllShapes.CASING_13PX.get(Direction.UP)
			.bounds();
		AABB beltBox = depotBox.contract(0, -3 / 16f, 0)
			.inflate(1, 0, 0);
		BlockPos depotPos = util.grid.at(1, 1, 4);
		BlockPos armPos = util.grid.at(3, 1, 4);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, depotBox, depotBox.move(1, 1, 4), 60);
		scene.overlay.showText(30)
			.text("Input")
			.pointAt(util.vector.blockSurface(depotPos, Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.INPUT);
		scene.idle(40);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, depotBox, beltBox.move(2, 1, 2), 40);
		scene.overlay.showText(40)
			.text("Outputs")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.OUTPUT);
		scene.idle(50);

		ItemStack item = new ItemStack(Items.SNOWBALL);

		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Whenever an Arm has to choose between multiple valid outputs...")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 2), Direction.UP))
			.placeNearTarget()
			.colored(PonderPalette.OUTPUT);
		scene.idle(70);

		Vec3 scrollSlot = util.vector.of(3.5, 1 + 3 / 16f, 4);
		scene.overlay.showFilterSlotInput(scrollSlot, Direction.NORTH, 120);
		scene.overlay.showText(50)
			.text("...it will act according to its setting")
			.pointAt(scrollSlot)
			.placeNearTarget();
		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(scrollSlot, Pointing.RIGHT).rightClick(), 40);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("The value panel will allow you to configure it")
			.pointAt(scrollSlot)
			.placeNearTarget();
		scene.idle(60);

		ElementLink<WorldSectionElement> blockage =
			scene.world.showIndependentSection(util.select.position(4, 1, 0), Direction.UP);
		scene.world.moveSection(blockage, util.vector.of(-1, 0, 0), 0);

		for (int i = 0; i < 20; i++) {

			if (i == 2) {
				scene.overlay.showText(60)
					.attachKeyFrame()
					.text("Round Robin mode simply cycles through all outputs that are available")
					.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.OUTPUT);
			}
			if (i == 6)
				continue;
			if (i == 7) {
				scene.overlay.showText(60)
					.attachKeyFrame()
					.text("If an output is unable to take more items, it will be skipped")
					.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.GREEN);
			}

			if (i == 12) {
				scene.world.moveSection(blockage, util.vector.of(-1, 0, 0), 10);
				scene.world.setBlock(util.grid.at(3, 1, 0), Blocks.BARRIER.defaultBlockState(), false);
			}

			int index = i % 3;

			if (i == 13) {
				scene.world.setBlock(util.grid.at(2, 1, 0), Blocks.BARRIER.defaultBlockState(), false);
				ElementLink<WorldSectionElement> blockage2 =
					scene.world.showIndependentSection(util.select.position(4, 1, 0), Direction.UP);
				scene.world.moveSection(blockage2, util.vector.of(-2, 0, 0), 0);
				scene.overlay.showText(60)
					.attachKeyFrame()
					.text("Prefer First prioritizes the outputs selected earliest when configuring this Arm")
					.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.GREEN);
				index = 0;
			}

			if (i == 14)
				index = 1;
			if (i == 15)
				index = 1;
			if (i >= 16)
				index = 2;

			scene.idle(5);
			scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 0);
			scene.idle(12);
			scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, item, -1);
			scene.world.removeItemsFromBelt(depotPos);
			scene.idle(5);

			if (i == 9) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.text("Forced Round Robin mode will never skip outputs, and instead wait until they are free")
					.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.RED);
				scene.idle(40);
				scene.world.moveSection(blockage, util.vector.of(1, 0, 0), 10);
				scene.world.setBlock(util.grid.at(3, 1, 0), Blocks.AIR.defaultBlockState(), false);
				scene.idle(50);
				scene.world.multiplyKineticSpeed(util.select.fromTo(1, 1, 1, 5, 0, 3), 2);
			}

			scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, item, index);
			scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
			scene.idle(12);
			scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, ItemStack.EMPTY, -1);
			scene.world.createItemOnBelt(util.grid.at(3 - index, 1, 2), Direction.UP, item);
		}

	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_arm_redstone", "Controlling Mechanical Arms with Redstone");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 3, 2, 1, 4), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 5, 4, 1, 3), Direction.WEST);
		scene.idle(5);
		scene.world.showSection(util.select.position(4, 1, 2), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(2, 1, 1, 4, 1, 1), Direction.EAST);
		scene.idle(10);
		Selection redstone = util.select.fromTo(1, 1, 0, 1, 1, 2);
		scene.world.showSection(redstone, Direction.SOUTH);

		BlockPos armPos = util.grid.at(1, 1, 3);
		BlockPos leverPos = util.grid.at(1, 1, 0);
		ItemStack item = new ItemStack(Items.REDSTONE_ORE);

		scene.world.createItemOnBeltLike(util.grid.at(4, 1, 1), Direction.SOUTH, item);

		for (int i = 0; i < 3; i++) {
			scene.idle(12);

			if (i == 1) {
				scene.world.toggleRedstonePower(redstone);
				scene.effects.indicateRedstone(leverPos);
				scene.idle(10);

				scene.overlay.showText(60)
					.colored(PonderPalette.RED)
					.attachKeyFrame()
					.pointAt(util.vector.topOf(armPos))
					.placeNearTarget()
					.text("When powered by Redstone, Mechanical Arms will not activate");
				scene.idle(70);
				scene.world.toggleRedstonePower(redstone);
			}

			if (i == 2) {
				scene.idle(60);
				scene.world.toggleRedstonePower(redstone);
				scene.idle(3);
				scene.world.toggleRedstonePower(redstone);
				scene.effects.indicateRedstone(leverPos);
			}

			scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 0);
			scene.idle(18);
			scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, item, -1);
			scene.world.removeItemsFromBelt(util.grid.at(3, 1, 1));
			scene.idle(5);

			if (i == 1) {
				scene.world.toggleRedstonePower(redstone);
				scene.effects.indicateRedstone(leverPos);
				scene.overlay.showText(60)
					.pointAt(util.vector.topOf(armPos))
					.placeNearTarget()
					.text("Before stopping, it will finish any started cycles");
			}

			scene.idle(10);

			if (i == 2) {
				scene.overlay.showText(100)
					.colored(PonderPalette.GREEN)
					.attachKeyFrame()
					.pointAt(util.vector.topOf(armPos))
					.placeNearTarget()
					.text("Thus, a negative pulse can be used to trigger exactly one activation cycle");
			}

			scene.world.instructArm(armPos, Phase.MOVE_TO_OUTPUT, item, 0);
			scene.world.createItemOnBeltLike(util.grid.at(4, 1, 1), Direction.SOUTH, item);
			scene.idle(18);
			scene.world.instructArm(armPos, Phase.SEARCH_INPUTS, ItemStack.EMPTY, -1);
			scene.world.createItemOnBelt(util.grid.at(3, 1, 3), Direction.UP, item);
		}

		scene.idle(5);
	}

}
//文件scenes/BearingScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.contraptions.actors.harvester.HarvesterBlockEntity;
import com.simibubi.create.content.contraptions.bearing.SailBlock;
import com.simibubi.create.content.contraptions.glue.SuperGlueEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BearingScenes {

	public static void windmillsAsSource(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("windmill_source", "Generating Rotational Force using Windmill Bearings");
		scene.configureBasePlate(1, 1, 5);
		scene.setSceneOffsetY(-1);
		scene.scaleSceneView(.9f);

		scene.world.showSection(util.select.fromTo(1, 0, 1, 5, 0, 5), Direction.UP);
		scene.world.setBlock(util.grid.at(2, -1, 0), AllBlocks.SAIL.getDefaultState()
			.setValue(SailBlock.FACING, Direction.NORTH), false);
		scene.idle(5);
		Selection kinetics = util.select.fromTo(3, 1, 1, 4, 1, 4);
		Selection largeCog = util.select.position(3, 2, 2);
		BlockPos windmill = util.grid.at(3, 2, 1);
		scene.world.showSection(kinetics.add(largeCog), Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(util.select.position(windmill), Direction.DOWN);
		scene.idle(10);

		BlockPos anchorPos = windmill.north();
		scene.overlay.showSelectionWithText(util.select.position(anchorPos), 60)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(windmill, Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Windmill Bearings attach to the block in front of them");
		scene.idle(50);

		ElementLink<WorldSectionElement> structure =
			scene.world.showIndependentSection(util.select.position(anchorPos), Direction.SOUTH);
		scene.idle(10);
		for (Direction d : Iterate.directions)
			if (d.getAxis() != Axis.Z)
				scene.world.showSectionAndMerge(util.select.fromTo(anchorPos.relative(d, 1), anchorPos.relative(d, 2)),
					d.getOpposite(), structure);
		scene.idle(10);

		scene.world.showSectionAndMerge(util.select.fromTo(anchorPos.above()
			.east(),
			anchorPos.above(3)
				.east()),
			Direction.WEST, structure);
		scene.world.showSectionAndMerge(util.select.fromTo(anchorPos.below()
			.west(),
			anchorPos.below(3)
				.west()),
			Direction.EAST, structure);
		scene.world.showSectionAndMerge(util.select.fromTo(anchorPos.east()
			.below(),
			anchorPos.east(3)
				.below()),
			Direction.UP, structure);
		scene.world.showSectionAndMerge(util.select.fromTo(anchorPos.west()
			.above(),
			anchorPos.west(3)
				.above()),
			Direction.DOWN, structure);

		scene.idle(5);
		for (Direction d : Iterate.directions)
			if (d.getAxis() != Axis.Z)
				scene.effects.superGlue(anchorPos.relative(d, 1), d.getOpposite(), false);
		scene.idle(10);

		AABB bb1 = new AABB(util.grid.at(5, 2, 0));
		AABB bb2 = new AABB(util.grid.at(3, 4, 0));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb1, bb1, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb1, bb1.expandTowards(-4, 0, 0), 75);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb2, bb2, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb2, bb2.expandTowards(0, -4, 0), 80);
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(5, 2, 0)), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);

		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 0), Direction.NORTH))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Create a movable structure with the help of Super Glue");
		scene.idle(70);

		scene.overlay.showText(80)
			.pointAt(util.vector.centerOf(1, 3, 0))
			.attachKeyFrame()
			.placeNearTarget()
			.text("If enough Sail-like blocks are included, this can act as a Windmill");
		scene.idle(70);

		scene.rotateCameraY(-90);
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(windmill)
			.subtract(.5, 0, 0), Pointing.DOWN).rightClick(), 60);
		scene.idle(7);
		scene.world.rotateBearing(windmill, 360, 200);
		scene.world.rotateSection(structure, 0, 0, 360, 200);
		scene.world.setKineticSpeed(largeCog, 4);
		scene.world.setKineticSpeed(kinetics, -8);
		scene.effects.rotationDirectionIndicator(windmill.south());
		BlockPos gaugePos = util.grid.at(4, 1, 4);
		scene.effects.indicateSuccess(gaugePos);
		scene.idle(10);

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(windmill)
				.subtract(.5, 0, 0))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Activated with Right-Click, the Windmill Bearing will start providing Rotational Force");
		scene.idle(70);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(gaugePos, Direction.WEST))
			.colored(PonderPalette.SLOW)
			.placeNearTarget()
			.text("The Amount of Sail Blocks determine its Rotation Speed");
		scene.idle(90);

		Vec3 surface = util.vector.blockSurface(windmill, Direction.WEST)
			.add(0, 0, 2 / 16f);
		scene.overlay.showControls(new InputWindowElement(surface, Pointing.DOWN).rightClick(), 60);
		scene.overlay.showFilterSlotInput(surface, Direction.WEST, 50);
		scene.overlay.showText(60)
			.pointAt(surface)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Use the value panel to configure its rotation direction");
		scene.idle(36);

		scene.world.rotateBearing(windmill, -90 - 45, 75);
		scene.world.rotateSection(structure, 0, 0, -90 - 45, 75);
		scene.world.modifyKineticSpeed(largeCog, f -> -f);
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(windmill.south());
		scene.idle(69);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(windmill)
			.subtract(.5, 0, 0), Pointing.DOWN).rightClick(), 60);
		scene.idle(7);
		scene.world.rotateBearing(windmill, -45, 0);
		scene.world.rotateSection(structure, 0, 0, -45, 0);
		scene.world.setKineticSpeed(largeCog, 0);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(10);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(windmill)
				.subtract(.5, 0, 0))
			.placeNearTarget()
			.text("Right-click the Bearing anytime to stop and edit the Structure again");
		scene.idle(30);

	}

	public static void windmillsAnyStructure(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("windmill_structure", "Windmill Contraptions");
		scene.configureBasePlate(1, 1, 5);
		scene.setSceneOffsetY(-1);
		scene.world.modifyEntities(SuperGlueEntity.class, Entity::discard);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos bearingPos = util.grid.at(3, 1, 3);
		scene.world.showSection(util.select.position(bearingPos), Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.position(bearingPos.above()), Direction.DOWN);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 2, 2, 3, 3, 1), Direction.SOUTH, contraption);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 2, 4, 3, 3, 5), Direction.NORTH, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(3, 1, 5), Direction.NORTH, contraption);
		scene.world.showSectionAndMerge(util.select.position(3, 4, 2), Direction.DOWN, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(2, 1, 5), Direction.EAST, contraption);
		scene.world.showSectionAndMerge(util.select.position(3, 3, 3), Direction.DOWN, contraption);
		scene.idle(5);
		scene.effects.superGlue(bearingPos.above(), Direction.SOUTH, true);
		scene.effects.superGlue(bearingPos.above(), Direction.NORTH, true);
		scene.idle(5);
		scene.effects.superGlue(util.grid.at(3, 1, 5), Direction.UP, true);
		scene.idle(5);
		scene.effects.superGlue(util.grid.at(3, 3, 3), Direction.DOWN, true);
		scene.idle(10);

		scene.overlay.showOutline(PonderPalette.BLUE, bearingPos, util.select.fromTo(3, 2, 1, 3, 3, 2), 80);
		scene.overlay.showSelectionWithText(util.select.fromTo(3, 2, 4, 3, 3, 5), 80)
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.text("Any Structure can count as a valid Windmill, as long as it contains at least 8 sail-like Blocks.");

		scene.idle(90);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(bearingPos, Direction.WEST), Pointing.LEFT).rightClick(),
			40);
		scene.idle(7);
		scene.markAsFinished();
		scene.world.rotateBearing(bearingPos, -720, 400);
		scene.world.rotateSection(contraption, 0, -720, 0, 400);
		scene.world.modifyBlockEntity(util.grid.at(2, 1, 5), HarvesterBlockEntity.class,
			hte -> hte.setAnimatedSpeed(-150));
		scene.idle(400);
		scene.world.modifyBlockEntity(util.grid.at(2, 1, 5), HarvesterBlockEntity.class,
			hte -> hte.setAnimatedSpeed(0));
	}

	public static void mechanicalBearing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_bearing", "Moving Structures using the Mechanical Bearing");
		scene.configureBasePlate(1, 1, 5);
		scene.setSceneOffsetY(-1);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.layer(2), Direction.DOWN);
		scene.idle(10);

		Selection cog1 = util.select.position(6, 0, 4);
		Selection cog2 = util.select.position(5, 1, 4);
		Selection cog3 = util.select.position(4, 1, 3);
		Selection cog4 = util.select.position(3, 1, 3);
		Selection all = cog1.copy()
			.add(cog2)
			.add(cog3)
			.add(cog4);

		BlockPos bearingPos = util.grid.at(3, 2, 3);
		scene.overlay.showSelectionWithText(util.select.position(bearingPos.above()), 60)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(bearingPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Mechanical Bearings attach to the block in front of them");
		scene.idle(50);

		ElementLink<WorldSectionElement> plank =
			scene.world.showIndependentSection(util.select.position(bearingPos.above()
				.east()
				.north()), Direction.DOWN);
		scene.world.moveSection(plank, util.vector.of(-1, 0, 1), 0);
		scene.idle(20);

		scene.world.setKineticSpeed(cog1, -8);
		scene.world.setKineticSpeed(cog2, 8);
		scene.world.setKineticSpeed(cog3, -16);
		scene.world.setKineticSpeed(cog4, 16);
		scene.effects.rotationSpeedIndicator(bearingPos.below());
		scene.world.rotateBearing(bearingPos, 360, 37 * 2);
		scene.world.rotateSection(plank, 0, 360, 0, 37 * 2);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(bearingPos.above()))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Upon receiving Rotational Force, it will assemble it into a Rotating Contraption");
		scene.idle(37 * 2);
		scene.world.setKineticSpeed(all, 0);
		scene.idle(20);

		scene.world.hideIndependentSection(plank, Direction.UP);
		scene.idle(15);
		Selection plank2 = util.select.position(4, 3, 2);
		ElementLink<WorldSectionElement> contraption = scene.world.showIndependentSection(util.select.layersFrom(3)
			.substract(plank2), Direction.DOWN);
		scene.world.replaceBlocks(util.select.fromTo(2, 4, 3, 4, 3, 3), Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.idle(10);

		scene.overlay.showOutline(PonderPalette.GREEN, "glue", util.select.position(2, 4, 3)
			.add(util.select.fromTo(4, 3, 3, 2, 3, 3))
			.add(util.select.position(4, 3, 2)), 40);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(4, 3, 3)), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);

		scene.idle(10);
		scene.world.showSectionAndMerge(plank2, Direction.SOUTH, contraption);
		scene.idle(15);
		scene.effects.superGlue(util.grid.at(4, 3, 2), Direction.SOUTH, true);
		scene.overlay.showText(120)
			.pointAt(util.vector.topOf(bearingPos.above()))
			.placeNearTarget()
			.attachKeyFrame()
			.sharedText("movement_anchors");
		scene.idle(25);

		scene.world.configureCenterOfRotation(contraption, util.vector.topOf(bearingPos));
		scene.world.setKineticSpeed(cog1, -8);
		scene.world.setKineticSpeed(cog2, 8);
		scene.world.setKineticSpeed(cog3, -16);
		scene.world.setKineticSpeed(cog4, 16);
		scene.effects.rotationSpeedIndicator(bearingPos.below());
		scene.world.rotateBearing(bearingPos, 360 * 2, 37 * 4);
		scene.world.rotateSection(contraption, 0, 360 * 2, 0, 37 * 4);

		scene.idle(37 * 4);
		scene.world.setKineticSpeed(all, 0);
	}

	public static void bearingModes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("bearing_modes", "Movement Modes of the Mechanical Bearing");
		scene.configureBasePlate(1, 1, 6);
		scene.setSceneOffsetY(-1);

		Selection sideCog = util.select.position(util.grid.at(7, 0, 3));
		Selection cogColumn = util.select.fromTo(6, 1, 3, 6, 4, 3);
		Selection cogAndClutch = util.select.fromTo(5, 3, 1, 5, 4, 2);
		BlockPos leverPos = util.grid.at(5, 3, 1);

		scene.world.setKineticSpeed(sideCog, 4);
		scene.world.setKineticSpeed(cogColumn, -4);
		scene.world.setKineticSpeed(cogAndClutch, 8);
		scene.world.toggleRedstonePower(cogAndClutch);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(cogColumn, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(cogAndClutch, Direction.DOWN);
		scene.idle(10);

		BlockPos bearingPos = util.grid.at(5, 2, 2);
		scene.world.showSection(util.select.position(bearingPos), Direction.UP);
		scene.idle(10);

		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(5, 1, 2, 2, 1, 2), Direction.EAST);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearingPos));
		scene.idle(20);

		scene.world.toggleRedstonePower(cogAndClutch);
		scene.effects.indicateRedstone(leverPos);
		scene.world.rotateSection(contraption, 0, 55, 0, 23);
		scene.world.rotateBearing(bearingPos, 55, 23);
		scene.idle(24);

		scene.world.toggleRedstonePower(cogAndClutch);
		scene.effects.indicateRedstone(leverPos);
		scene.world.rotateSection(contraption, 0, 35, 0, 0);
		scene.world.rotateBearing(bearingPos, 35, 0);

		Vec3 target = util.vector.topOf(bearingPos.below());
		scene.overlay.showLine(PonderPalette.RED, target.add(-2.5, 0, 3.5), target, 50);
		scene.overlay.showLine(PonderPalette.GREEN, target.add(0, 0, 4.5), target, 50);

		scene.idle(50);

		scene.overlay.showText(100)
			.pointAt(util.vector.topOf(util.grid.at(5, 0, 4)))
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.text("When Stopped, the Bearing will place the structure at the nearest grid-aligned Angle");
		scene.idle(110);

		Vec3 blockSurface = util.vector.blockSurface(bearingPos, Direction.NORTH)
			.add(0, 2 / 16f, 0);
		scene.overlay.showFilterSlotInput(blockSurface, Direction.NORTH, 60);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.DOWN).scroll()
			.withWrench(), 60);
		scene.idle(10);
		scene.overlay.showText(60)
			.pointAt(blockSurface)
			.placeNearTarget()
			.attachKeyFrame()
			.sharedText("behaviour_modify_value_panel");
		scene.idle(70);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.toggleRedstonePower(cogAndClutch);
		scene.effects.indicateRedstone(leverPos);
		scene.world.rotateSection(contraption, 0, -55, 0, 23);
		scene.world.rotateBearing(bearingPos, -55, 23);
		scene.idle(24);

		scene.world.toggleRedstonePower(cogAndClutch);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(40);

		scene.overlay.showText(120)
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.UP))
			.text("It can be configured never to revert to solid blocks, or only near the angle it started at");
		scene.idle(90);

	}

	public static void stabilizedBearings(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("stabilized_bearings", "Stabilized Contraptions");
		scene.configureBasePlate(1, 1, 5);
		scene.setSceneOffsetY(-1);

		Selection beltAndBearing = util.select.fromTo(3, 3, 4, 3, 1, 6);
		Selection largeCog = util.select.position(2, 0, 6);
		BlockPos parentBearingPos = util.grid.at(3, 3, 4);
		BlockPos bearingPos = util.grid.at(3, 4, 2);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(beltAndBearing, Direction.DOWN);
		scene.idle(10);

		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(3, 3, 3, 3, 4, 3), Direction.SOUTH);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(parentBearingPos));
		scene.idle(20);
		scene.world.glueBlockOnto(bearingPos, Direction.SOUTH, contraption);

		scene.idle(15);

		scene.overlay.showSelectionWithText(util.select.position(bearingPos), 60)
			.text("Whenever Mechanical Bearings are themselves part of a moving Structure..")
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(70);

		scene.world.setKineticSpeed(largeCog, -8);
		scene.world.setKineticSpeed(beltAndBearing, 16);
		scene.world.rotateBearing(parentBearingPos, 360, 74);
		scene.world.rotateSection(contraption, 0, 0, 360, 74);
		scene.world.rotateBearing(bearingPos, -360, 74);
		scene.idle(74);

		scene.world.setKineticSpeed(largeCog, 0);
		scene.world.setKineticSpeed(beltAndBearing, 0);
		scene.overlay.showText(60)
			.text("..they will attempt to keep themselves upright")
			.pointAt(util.vector.blockSurface(bearingPos, Direction.NORTH))
			.placeNearTarget();
		scene.idle(70);

		scene.overlay.showSelectionWithText(util.select.position(bearingPos.north()), 60)
			.colored(PonderPalette.GREEN)
			.text("Once again, the bearing will attach to the block in front of it")
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(70);

		ElementLink<WorldSectionElement> subContraption =
			scene.world.showIndependentSection(util.select.fromTo(4, 4, 1, 2, 4, 1), Direction.SOUTH);
		scene.world.configureCenterOfRotation(subContraption, util.vector.centerOf(parentBearingPos));
		scene.world.configureStabilization(subContraption, util.vector.centerOf(bearingPos));
		scene.idle(20);

		scene.overlay.showText(80)
			.text("As a result, the entire sub-Contraption will stay upright");

		scene.world.setKineticSpeed(largeCog, -8);
		scene.world.setKineticSpeed(beltAndBearing, 16);
		scene.world.rotateBearing(parentBearingPos, 360 * 2, 74 * 2);
		scene.world.rotateSection(contraption, 0, 0, 360 * 2, 74 * 2);
		scene.world.rotateBearing(bearingPos, -360 * 2, 74 * 2);
		scene.world.rotateSection(subContraption, 0, 0, 360 * 2, 74 * 2);

		scene.markAsFinished();
		scene.idle(74 * 2);
		scene.world.setKineticSpeed(largeCog, 0);
		scene.world.setKineticSpeed(beltAndBearing, 0);
	}

	public static void clockwork(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("clockwork_bearing", "Animating Structures using Clockwork Bearings");
		scene.configureBasePlate(1, 1, 5);
		scene.setSceneOffsetY(-1);

		Selection kinetics = util.select.fromTo(3, 3, 4, 3, 1, 6);
		Selection largeCog = util.select.position(2, 0, 6);
		BlockPos bearingPos = util.grid.at(3, 3, 3);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(kinetics, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(bearingPos), Direction.DOWN);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.position(bearingPos.north()), 60)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(bearingPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Clockwork Bearings attach to blocks in front of them");
		scene.idle(50);

		ElementLink<WorldSectionElement> plank =
			scene.world.showIndependentSection(util.select.position(2, 3, 2), Direction.SOUTH);
		scene.world.moveSection(plank, util.vector.of(1, 0, 0), 0);
		scene.idle(20);

		scene.world.rotateSection(plank, 0, 0, 60, 25);
		scene.world.rotateBearing(bearingPos, 60, 25);
		scene.world.setKineticSpeed(kinetics, 8);
		scene.world.setKineticSpeed(largeCog, -4);

		scene.idle(25);
		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(bearingPos.north(), Direction.NORTH))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Upon receiving Rotational Force, the structure will be rotated according to the hour of the day");
		scene.idle(90);

		scene.overlay.showText(30)
			.pointAt(util.vector.blockSurface(bearingPos.north(), Direction.NORTH))
			.placeNearTarget()
			.text("3:00");
		scene.world.rotateSection(plank, 0, 0, 30, 12);
		scene.world.rotateBearing(bearingPos, 30, 12);
		scene.idle(42);
		scene.overlay.showText(30)
			.pointAt(util.vector.blockSurface(bearingPos.north(), Direction.NORTH))
			.placeNearTarget()
			.text("4:00");
		scene.world.rotateSection(plank, 0, 0, 30, 12);
		scene.world.rotateBearing(bearingPos, 30, 12);
		scene.idle(42);

		InputWindowElement clickTheBearing = new InputWindowElement(util.vector.topOf(bearingPos), Pointing.DOWN);
		InputWindowElement clickTheBearingSide =
			new InputWindowElement(util.vector.blockSurface(bearingPos, Direction.WEST), Pointing.LEFT);

		scene.overlay.showControls(clickTheBearing.rightClick(), 60);
		scene.idle(7);
		scene.world.rotateSection(plank, 0, 0, -120, 0);
		scene.world.rotateBearing(bearingPos, -120, 0);
		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(bearingPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Right-Click the bearing to start or stop animating the structure");
		scene.idle(70);

		scene.world.hideIndependentSection(plank, Direction.NORTH);
		scene.idle(15);

		scene.world.replaceBlocks(util.select.fromTo(3, 3, 1, 3, 4, 2), Blocks.OAK_PLANKS.defaultBlockState(), false);
		ElementLink<WorldSectionElement> hourHand =
			scene.world.showIndependentSection(util.select.fromTo(3, 3, 1, 3, 5, 2), Direction.SOUTH);
		scene.world.configureCenterOfRotation(hourHand, util.vector.centerOf(bearingPos));
		scene.idle(15);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(3, 4, 1)), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);
		scene.overlay.showSelectionWithText(util.select.fromTo(3, 3, 1, 3, 4, 2), 80)
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.sharedText("movement_anchors");
		scene.idle(90);

		scene.overlay.showControls(clickTheBearingSide.rightClick(), 20);
		scene.idle(7);
		scene.world.rotateSection(hourHand, 0, 0, 120, 50);
		scene.world.rotateBearing(bearingPos, 120, 50);
		scene.idle(60);

		scene.overlay.showSelectionWithText(util.select.position(bearingPos.north(3)), 80)
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.text("In front of the Hour Hand, a second structure can be added");
		scene.idle(90);
		scene.overlay.showControls(clickTheBearingSide.rightClick(), 20);
		scene.idle(7);
		scene.world.rotateSection(hourHand, 0, 0, -120, 0);
		scene.world.rotateBearing(bearingPos, -120, 0);
		scene.idle(10);

		scene.world.setBlock(util.grid.at(3, 3, 0), Blocks.STONE_BRICK_WALL.defaultBlockState()
			.setValue(WallBlock.SOUTH_WALL, WallSide.TALL), false);
		ElementLink<WorldSectionElement> minuteHand =
			scene.world.showIndependentSection(util.select.fromTo(3, 3, 0, 3, 6, 0), Direction.SOUTH);
		scene.world.configureCenterOfRotation(minuteHand, util.vector.centerOf(bearingPos));
		scene.idle(30);

		scene.overlay.showOutline(PonderPalette.BLUE, minuteHand, util.select.fromTo(3, 3, 0, 3, 6, 0), 85);
		scene.overlay.showSelectionWithText(util.select.fromTo(3, 3, 1, 3, 4, 2), 80)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("Ensure that the two Structures are not glued to each other");
		scene.idle(90);

		scene.overlay.showControls(clickTheBearingSide.rightClick(), 20);
		scene.idle(7);

		scene.world.rotateSection(hourHand, 0, 0, 120, 50);
		scene.world.rotateSection(minuteHand, 0, 0, 180, 75);
		scene.world.rotateBearing(bearingPos, 120, 50);
		scene.idle(90);
		scene.world.rotateSection(minuteHand, 0, 0, 6, 3);

		scene.overlay.showText(80)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(bearingPos.north(3), Direction.NORTH))
			.colored(PonderPalette.GREEN)
			.text("The Second Structure will now rotate as the Minute Hand");
		scene.markAsFinished();

		for (int i = 0; i < 40; i++) {
			scene.idle(23);
			scene.world.rotateSection(minuteHand, 0, 0, 6, 3);
			if (i == 29)
				scene.world.rotateSection(hourHand, 0, 0, 30, 20);
		}
	}

	public static void sail(SceneBuilder scene, SceneBuildingUtil util) {
		sails(scene, util, false);
	}

	public static void sailFrame(SceneBuilder scene, SceneBuildingUtil util) {
		sails(scene, util, true);
	}

	private static void sails(SceneBuilder scene, SceneBuildingUtil util, boolean frame) {
		String plural = frame ? "Sail Frames" : "Sails";
		scene.title(frame ? "sail_frame" : "sail", "Assembling Windmills using " + plural);
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(0.9f);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos bearingPos = util.grid.at(2, 1, 2);
		scene.world.showSection(util.select.position(bearingPos), Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> plank =
			scene.world.showIndependentSection(util.select.position(bearingPos.above()), Direction.DOWN);
		scene.idle(10);

		for (int i = 0; i < 3; i++) {
			for (Direction d : Iterate.horizontalDirections) {
				BlockPos location = bearingPos.above(i + 1)
					.relative(d);
				if (frame)
					scene.world.modifyBlock(location, s -> AllBlocks.SAIL_FRAME.getDefaultState()
						.setValue(SailBlock.FACING, s.getValue(SailBlock.FACING)), false);
				scene.world.showSectionAndMerge(util.select.position(location), d.getOpposite(), plank);
				scene.idle(2);
			}
		}

		scene.overlay.showText(70)
			.text(plural + " are handy blocks to create Windmills with")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 3, 2), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame();
		scene.idle(80);

		scene.overlay.showSelectionWithText(util.select.position(bearingPos.above()), 80)
			.colored(PonderPalette.GREEN)
			.text("They will attach to blocks and each other without the need of Super Glue or Chassis Blocks")
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(40);
		scene.world.configureCenterOfRotation(plank, util.vector.centerOf(bearingPos));

		if (!frame) {
			scene.world.rotateBearing(bearingPos, 180, 75);
			scene.world.rotateSection(plank, 0, 180, 0, 75);
			scene.idle(76);
			scene.world.rotateBearing(bearingPos, 180, 0);
			scene.world.rotateSection(plank, 0, 180, 0, 0);
			scene.rotateCameraY(-30);
			scene.idle(10);
			InputWindowElement input =
				new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.NORTH), Pointing.RIGHT)
					.withItem(new ItemStack(Items.BLUE_DYE));
			scene.overlay.showControls(input, 30);
			scene.idle(7);
			scene.world.setBlock(util.grid.at(2, 3, 1), AllBlocks.DYED_SAILS.get(DyeColor.BLUE)
				.getDefaultState()
				.setValue(SailBlock.FACING, Direction.WEST), false);
			scene.idle(10);
			scene.overlay.showText(40)
				.colored(PonderPalette.BLUE)
				.text("Right-Click with Dye to paint them")
				.attachKeyFrame()
				.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.WEST))
				.placeNearTarget();
			scene.idle(20);
			scene.overlay.showControls(input, 30);
			scene.idle(7);
			scene.world.replaceBlocks(util.select.fromTo(2, 2, 1, 2, 4, 1), AllBlocks.DYED_SAILS.get(DyeColor.BLUE)
				.getDefaultState()
				.setValue(SailBlock.FACING, Direction.WEST), false);

			scene.idle(20);
			scene.world.rotateBearing(bearingPos, 90, 33);
			scene.world.rotateSection(plank, 0, 90, 0, 33);
			scene.idle(40);

			input =
				new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.NORTH), Pointing.RIGHT)
					.withItem(new ItemStack(Items.SHEARS));

			scene.overlay.showControls(input, 30);
			scene.idle(7);
			scene.world.setBlock(util.grid.at(3, 3, 2), AllBlocks.SAIL_FRAME.getDefaultState()
				.setValue(SailBlock.FACING, Direction.NORTH), false);
			scene.idle(10);
			scene.overlay.showText(40)
				.text("Right-Click with Shears to turn them back into frames")
				.attachKeyFrame()
				.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.WEST))
				.placeNearTarget();
			scene.idle(20);
			scene.overlay.showControls(input, 30);
			scene.idle(7);
			scene.world.replaceBlocks(util.select.fromTo(3, 2, 2, 3, 4, 2), AllBlocks.SAIL_FRAME.getDefaultState()
				.setValue(SailBlock.FACING, Direction.NORTH), false);
			scene.idle(20);
		}

		scene.world.rotateBearing(bearingPos, 720, 300);
		scene.world.rotateSection(plank, 0, 720, 0, 300);

	}

}
//文件scenes/BeltScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.content.kinetics.belt.BeltBlock;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.BeltPart;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmBlockEntity.Phase;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.Mode;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FaceCursorPose;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.NBTHelper;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BeltScenes {

	public static void beltConnector(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("belt_connector", "Using Mechanical Belts");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.world.showSection(util.select.position(3, 0, 5), Direction.UP);
		scene.idle(5);

		scene.world.showSection(util.select.fromTo(4, 1, 3, 4, 1, 5), Direction.DOWN);
		ElementLink<WorldSectionElement> shafts =
			scene.world.showIndependentSection(util.select.fromTo(0, 1, 3, 4, 1, 3), Direction.DOWN);
		scene.world.moveSection(shafts, util.vector.of(0, 0, -1), 0);
		scene.world.setKineticSpeed(util.select.position(0, 1, 3), 0);
		scene.idle(20);

		BlockPos backEnd = util.grid.at(4, 1, 2);
		BlockPos frontEnd = util.grid.at(0, 1, 2);
		ItemStack beltItem = AllItems.BELT_CONNECTOR.asStack();
		Vec3 backEndCenter = util.vector.centerOf(backEnd);
		AABB connectBB = new AABB(backEndCenter, backEndCenter);
		AABB shaftBB = AllBlocks.SHAFT.getDefaultState()
			.setValue(ShaftBlock.AXIS, Axis.Z)
			.getShape(null, null)
			.bounds();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(backEnd), Pointing.DOWN).rightClick()
			.withItem(beltItem), 57);
		scene.idle(7);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, backEnd, shaftBB.move(backEnd), 42);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.BLACK, backEndCenter, connectBB, 50);
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(frontEnd), Pointing.DOWN).rightClick()
			.withItem(beltItem), 37);
		scene.idle(7);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, frontEnd, shaftBB.move(frontEnd), 17);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.BLACK, backEndCenter, connectBB.expandTowards(-4, 0, 0),
			20);
		scene.idle(20);

		scene.world.moveSection(shafts, util.vector.of(0, -2, 0), 0);
		scene.world.showSection(util.select.fromTo(0, 1, 2, 4, 1, 2), Direction.SOUTH);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Right-Clicking two shafts with a belt item will connect them together")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 1, 2));
		scene.idle(90);

		Vec3 falseSelection = util.vector.topOf(backEnd.south(1));
		scene.overlay.showControls(new InputWindowElement(falseSelection, Pointing.DOWN).rightClick()
			.withItem(beltItem), 37);
		scene.idle(7);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, backEnd, shaftBB.move(backEnd.south(1)), 50);

		scene.overlay.showText(80)
			.colored(PonderPalette.RED)
			.text("Accidental selections can be canceled with Right-Click while Sneaking")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.centerOf(backEnd.south(1)));
		scene.idle(43);

		scene.overlay.showControls(new InputWindowElement(falseSelection, Pointing.DOWN).rightClick()
			.withItem(beltItem)
			.whileSneaking(), 20);
		scene.idle(60);

		BlockPos shaftLocation = frontEnd.east();
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(shaftLocation), Pointing.DOWN).rightClick()
			.withItem(AllBlocks.SHAFT.asStack()), 50);
		scene.idle(7);
		scene.world.modifyBlock(shaftLocation, s -> s.setValue(BeltBlock.PART, BeltPart.PULLEY), true);
		scene.idle(10);

		scene.overlay.showText(43)
			.text("Additional Shafts can be added throughout the Belt")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(shaftLocation, Direction.NORTH));
		scene.idle(50);

		Selection attachedShafts = util.select.fromTo(0, 1, 1, 1, 1, 1);
		scene.world.showSection(attachedShafts, Direction.SOUTH);
		scene.world.setKineticSpeed(attachedShafts, 32);
		scene.idle(10);
		scene.effects.rotationDirectionIndicator(util.grid.at(0, 1, 1));
		scene.effects.rotationDirectionIndicator(util.grid.at(1, 1, 1));
		scene.idle(20);

		scene.overlay.showText(50)
			.text("Shafts connected via Belts will rotate with Identical Speed and Direction")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 1), Direction.NORTH));
		scene.idle(60);

		scene.world.hideSection(attachedShafts, Direction.NORTH);
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(shaftLocation), Pointing.DOWN).rightClick()
			.withWrench(), 50);
		scene.idle(7);
		scene.world.modifyBlock(shaftLocation, s -> s.setValue(BeltBlock.PART, BeltPart.MIDDLE), true);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("Added shafts can be removed using the wrench")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(shaftLocation, Direction.NORTH));
		scene.idle(70);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(shaftLocation.east()), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(Items.BLUE_DYE)), 50);
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(util.select.fromTo(0, 1, 2, 4, 1, 2), BeltBlockEntity.class,
			nbt -> NBTHelper.writeEnum(nbt, "Dye", DyeColor.BLUE));
		scene.idle(20);
		scene.overlay.showText(80)
			.colored(PonderPalette.BLUE)
			.text("Mechanical Belts can be dyed for aesthetic purposes")
			.placeNearTarget()
			.pointAt(util.vector.topOf(shaftLocation.east()));
		scene.idle(50);
	}

	public static void directions(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("belt_directions", "Valid Orientations for Mechanical Belts");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();
		scene.idle(5);

		ElementLink<WorldSectionElement> leftShaft =
			scene.world.showIndependentSection(util.select.position(4, 1, 0), Direction.DOWN);
		ElementLink<WorldSectionElement> rightShaft =
			scene.world.showIndependentSection(util.select.position(0, 1, 0), Direction.DOWN);

		scene.world.moveSection(leftShaft, util.vector.of(0, 0, 2), 0);
		scene.world.moveSection(rightShaft, util.vector.of(0, 0, 2), 0);
		scene.idle(1);
		scene.world.moveSection(leftShaft, util.vector.of(-1, 0, 0), 10);
		scene.world.moveSection(rightShaft, util.vector.of(1, 1, 0), 10);

		scene.idle(20);

		Vec3 from = util.vector.centerOf(3, 1, 2);
		Vec3 to = util.vector.centerOf(1, 2, 2);

		scene.overlay.showLine(PonderPalette.RED, from, to, 70);
		scene.idle(10);
		scene.overlay.showLine(PonderPalette.GREEN, to.add(-1, -1, 0), from, 60);
		scene.overlay.showLine(PonderPalette.GREEN, from.add(0, 3, 0), from, 60);

		scene.idle(20);
		scene.overlay.showText(60)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.pointAt(to)
			.text("Belts cannot connect in arbitrary directions");
		scene.idle(70);

		from = util.vector.centerOf(4, 1, 2);
		to = util.vector.centerOf(0, 1, 2);

		scene.world.moveSection(leftShaft, util.vector.of(1, 0, 0), 10);
		scene.world.moveSection(rightShaft, util.vector.of(-1, -1, 0), 10);
		scene.idle(10);
		scene.overlay.showLine(PonderPalette.GREEN, from, to, 40);
		scene.idle(10);
		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(to)
			.attachKeyFrame()
			.text("1. They can connect horizontally");

		scene.idle(20);
		Selection firstBelt = util.select.fromTo(4, 1, 1, 0, 1, 1);
		ElementLink<WorldSectionElement> belt = scene.world.showIndependentSection(firstBelt, Direction.SOUTH);
		scene.world.moveSection(belt, util.vector.of(0, 0, 1), 0);
		scene.idle(20);
		scene.world.hideIndependentSection(belt, Direction.SOUTH);
		scene.idle(15);

		from = util.vector.centerOf(3, 3, 2);
		to = util.vector.centerOf(1, 1, 2);

		scene.world.moveSection(leftShaft, util.vector.of(-1, 2, 0), 10);
		scene.world.moveSection(rightShaft, util.vector.of(1, 0, 0), 10);
		scene.idle(10);
		scene.world.rotateSection(leftShaft, 0, 0, 25, 5);
		scene.world.rotateSection(rightShaft, 0, 0, 25, 5);
		scene.overlay.showLine(PonderPalette.GREEN, from, to, 40);
		scene.idle(10);
		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(to)
			.attachKeyFrame()
			.text("2. They can connect diagonally");

		scene.idle(20);
		Selection secondBelt = util.select.fromTo(3, 3, 2, 1, 1, 2);
		belt = scene.world.showIndependentSection(secondBelt, Direction.SOUTH);
		scene.idle(20);
		scene.world.hideIndependentSection(belt, Direction.SOUTH);
		scene.idle(15);

		from = util.vector.centerOf(2, 4, 2);
		to = util.vector.centerOf(2, 1, 2);

		scene.world.moveSection(leftShaft, util.vector.of(-1, 1, 0), 10);
		scene.world.moveSection(rightShaft, util.vector.of(1, 0, 0), 10);
		scene.idle(10);
		scene.world.rotateSection(rightShaft, 0, 0, -25, 5);
		scene.overlay.showLine(PonderPalette.GREEN, from, to, 40);
		scene.idle(10);
		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(to)
			.attachKeyFrame()
			.text("3. They can connect vertically");

		scene.idle(20);
		Selection thirdBelt = util.select.fromTo(2, 1, 3, 2, 4, 3);
		belt = scene.world.showIndependentSection(thirdBelt, Direction.SOUTH);
		scene.world.moveSection(belt, util.vector.of(0, 0, -1), 0);
		scene.idle(20);
		scene.world.hideIndependentSection(belt, Direction.SOUTH);
		scene.idle(15);

		from = util.vector.centerOf(4, 1, 2);
		to = util.vector.centerOf(0, 1, 2);

		scene.world.moveSection(leftShaft, util.vector.of(2, -3, 0), 10);
		scene.world.moveSection(rightShaft, util.vector.of(-2, 0, 0), 10);
		scene.idle(10);
		scene.world.rotateSection(rightShaft, 90, 0, -25, 5);
		scene.world.rotateSection(leftShaft, 90, 0, -50, 5);
		scene.overlay.showLine(PonderPalette.GREEN, from, to, 60);
		scene.idle(10);
		scene.overlay.showText(60)
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(to)
			.attachKeyFrame()
			.text("4. And they can connect vertical shafts horizontally");

		scene.idle(20);
		Selection fourthBelt = util.select.fromTo(4, 1, 4, 0, 1, 4);
		belt = scene.world.showIndependentSection(fourthBelt, Direction.DOWN);
		scene.world.moveSection(belt, util.vector.of(0, 1 / 512f, -2), 0);
		scene.idle(40);
		scene.world.hideIndependentSection(belt, Direction.UP);
		scene.idle(15);
		scene.world.hideIndependentSection(leftShaft, Direction.UP);
		scene.world.hideIndependentSection(rightShaft, Direction.UP);
		scene.idle(15);

		scene.world.showSection(firstBelt, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(secondBelt, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(thirdBelt, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(fourthBelt, Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(160)
			.text("These are all possible directions. Belts can span any Length between 2 and 20 blocks");
		scene.markAsFinished();
	}

	public static void transport(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("belt_transport", "Using Mechanical Belts for Logistics");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -.6f * f);
		scene.showBasePlate();
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 3, 2, 1, 5), Direction.DOWN);
		scene.idle(20);
		scene.world.showSection(util.select.fromTo(2, 1, 2, 4, 3, 2), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 2, 0, 1, 2), Direction.SOUTH);
		scene.idle(10);
		scene.special.movePointOfInterest(util.grid.at(2, 2, 0));

		ItemStack stack = new ItemStack(Items.COPPER_BLOCK);
		ElementLink<EntityElement> item =
			scene.world.createItemEntity(util.vector.centerOf(0, 4, 2), util.vector.of(0, 0, 0), stack);
		scene.idle(13);
		scene.world.modifyEntity(item, Entity::discard);
		BlockPos beltEnd = util.grid.at(0, 1, 2);
		scene.world.createItemOnBelt(beltEnd, Direction.DOWN, stack);

		scene.idle(20);

		ElementLink<ParrotElement> parrot = scene.special.createBirb(util.vector.topOf(0, 1, 2)
			.add(0, -3 / 16f, 0), FacePointOfInterestPose::new);
		scene.special.moveParrot(parrot, util.vector.of(1.78, 0, 0), 40);
		scene.special.movePointOfInterest(util.grid.at(1, 1, 3));

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.topOf(beltEnd))
			.text("Moving belts will transport Items and other Entities");

		scene.idle(20);
		item = scene.world.createItemEntity(util.vector.centerOf(0, 4, 2), util.vector.of(0, 0, 0), stack);
		scene.special.movePointOfInterest(util.grid.at(0, 3, 2));
		scene.idle(10);
		scene.special.movePointOfInterest(beltEnd);
		scene.idle(3);
		scene.world.modifyEntity(item, Entity::discard);
		scene.world.createItemOnBelt(beltEnd, Direction.DOWN, stack);
		scene.idle(8);

		scene.special.movePointOfInterest(util.grid.at(3, 2, 1));
		scene.special.moveParrot(parrot, util.vector.of(2.1, 2.1, 0), 60);
		scene.idle(20);
		scene.special.movePointOfInterest(util.grid.at(5, 5, 2));
		scene.idle(30);
		scene.special.movePointOfInterest(util.grid.at(2, 1, 5));
		scene.idle(10);
		scene.special.moveParrot(parrot, util.vector.of(.23, 0, 0), 5);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.everywhere(), 0f);
		scene.idle(10);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.special.movePointOfInterest(util.grid.at(2, 5, 4));

		Vec3 topOf = util.vector.topOf(util.grid.at(3, 2, 2))
			.add(-0.1, 0.3, 0);
		scene.overlay.showControls(new InputWindowElement(topOf, Pointing.DOWN).rightClick(), 60);
		scene.idle(10);
		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(topOf.subtract(0, 0.1, 0))
			.attachKeyFrame()
			.text("Right-Click with an empty hand to take items off a belt");
		scene.idle(20);
		scene.world.removeItemsFromBelt(util.grid.at(3, 2, 2));
		scene.effects.indicateSuccess(util.grid.at(3, 2, 2));
		scene.idle(20);

		scene.special.changeBirbPose(parrot, FaceCursorPose::new);
	}

	public static void beltsCanBeEncased(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("belt_casing", "Encasing Belts");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();
		scene.idle(5);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
		scene.idle(20);

		ItemStack brassCasingItem = AllBlocks.BRASS_CASING.asStack();
		ItemStack andesiteCasingItem = AllBlocks.ANDESITE_CASING.asStack();

		BlockPos beltPos = util.grid.at(3, 1, 0);
		BlockPos beltPos2 = util.grid.at(0, 2, 3);
		BlockPos beltPos3 = util.grid.at(1, 4, 4);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(beltPos), Pointing.DOWN).rightClick()
			.withItem(brassCasingItem), 20);
		scene.idle(7);
		scene.world.modifyBlock(beltPos, s -> s.setValue(BeltBlock.CASING, true), true);
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(beltPos2), Pointing.DOWN).rightClick()
			.withItem(andesiteCasingItem), 20);
		scene.idle(7);
		scene.world.modifyBlock(beltPos2, s -> s.setValue(BeltBlock.CASING, true), true);
		scene.world.modifyBlockEntityNBT(util.select.position(beltPos2), BeltBlockEntity.class, nbt -> {
			NBTHelper.writeEnum(nbt, "Casing", BeltBlockEntity.CasingType.ANDESITE);
		});
		scene.idle(20);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(beltPos3, Direction.EAST), Pointing.RIGHT).rightClick()
				.withItem(brassCasingItem),
			20);
		scene.idle(7);
		scene.world.modifyBlock(beltPos3, s -> s.setValue(BeltBlock.CASING, true), true);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Brass or Andesite Casing can be used to decorate Mechanical Belts")
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(beltPos2));

		scene.idle(40);

		List<BlockPos> brassBelts = new ArrayList<>();
		List<BlockPos> andesiteBelts = new ArrayList<>();

		for (int z = 1; z <= 3; z++)
			brassBelts.add(beltPos.south(z));
		for (int x = 1; x <= 3; x++)
			brassBelts.add(beltPos3.east(x)
				.below(x));
		for (int x = 1; x <= 3; x++)
			andesiteBelts.add(beltPos2.east(x));

		Collections.shuffle(andesiteBelts);
		Collections.shuffle(brassBelts);

		for (BlockPos pos : andesiteBelts) {
			scene.idle(4);
			scene.world.modifyBlock(pos, s -> s.setValue(BeltBlock.CASING, true), true);
			scene.world.modifyBlockEntityNBT(util.select.position(pos), BeltBlockEntity.class, nbt -> {
				NBTHelper.writeEnum(nbt, "Casing", BeltBlockEntity.CasingType.ANDESITE);
			});
		}
		for (BlockPos pos : brassBelts) {
			scene.idle(4);
			scene.world.modifyBlock(pos, s -> s.setValue(BeltBlock.CASING, true), true);
		}
		scene.idle(30);
		scene.addKeyframe();

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(beltPos.south()), Pointing.DOWN).rightClick()
				.withWrench(), 40);
		scene.idle(7);
		scene.world.modifyBlock(beltPos.south(), s -> s.setValue(BeltBlock.CASING, false), true);
		scene.overlay.showText(80)
			.text("A wrench can be used to remove the casing")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(beltPos.south(), Direction.WEST));
	}

	public static void depot(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("depot", "Using Depots");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);
		scene.world.setBlock(util.grid.at(3, 2, 2), Blocks.WATER.defaultBlockState(), false);

		BlockPos depotPos = util.grid.at(2, 1, 2);
		scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);
		Vec3 topOf = util.vector.topOf(depotPos);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Depots can serve as 'stationary' belt elements")
			.placeNearTarget()
			.pointAt(topOf);
		scene.idle(70);

		scene.overlay.showControls(new InputWindowElement(topOf, Pointing.DOWN).rightClick()
			.withItem(new ItemStack(Items.COPPER_BLOCK)), 20);
		scene.idle(7);
		scene.world.createItemOnBeltLike(depotPos, Direction.NORTH, new ItemStack(Items.COPPER_BLOCK));
		scene.idle(10);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Right-Click to manually place or remove Items from it")
			.placeNearTarget()
			.pointAt(topOf);
		scene.idle(80);

		scene.overlay.showControls(new InputWindowElement(topOf, Pointing.DOWN).rightClick(), 20);
		scene.idle(7);
		scene.world.removeItemsFromBelt(depotPos);
		scene.effects.indicateSuccess(depotPos);
		scene.idle(20);

		scene.world.showSection(util.select.position(depotPos.above(2)), Direction.SOUTH);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Just like Mechanical Belts, it can provide items to processing")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(depotPos.above(2), Direction.WEST));
		ItemStack bottle = new ItemStack(Items.BUCKET);
		scene.world.createItemOnBeltLike(depotPos, Direction.NORTH, bottle);
		scene.idle(20);
		scene.world.modifyBlockEntityNBT(util.select.position(depotPos.above(2)), SpoutBlockEntity.class,
			nbt -> nbt.putInt("ProcessingTicks", 20));
		scene.idle(20);
		scene.world.removeItemsFromBelt(depotPos);
		scene.world.createItemOnBeltLike(depotPos, Direction.UP, new ItemStack(Items.WATER_BUCKET));
		scene.world.modifyBlockEntityNBT(util.select.position(depotPos.above(2)), SpoutBlockEntity.class,
			nbt -> nbt.putBoolean("Splash", true));
		scene.idle(30);
		scene.world.removeItemsFromBelt(depotPos);
		scene.world.hideSection(util.select.position(depotPos.above(2)), Direction.SOUTH);
		scene.idle(20);
		ElementLink<WorldSectionElement> spout =
			scene.world.showIndependentSection(util.select.position(depotPos.above(2)
				.west()), Direction.SOUTH);
		scene.world.moveSection(spout, util.vector.of(1, 0, 0), 0);

		BlockPos pressPos = depotPos.above(2)
			.west();
		ItemStack copper = new ItemStack(Items.COPPER_INGOT);
		scene.world.createItemOnBeltLike(depotPos, Direction.NORTH, copper);
		Vec3 depotCenter = util.vector.centerOf(depotPos);
		scene.idle(10);

		Class<MechanicalPressBlockEntity> type = MechanicalPressBlockEntity.class;
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BELT));
		scene.idle(15);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), copper));
		scene.world.removeItemsFromBelt(depotPos);
		ItemStack sheet = AllItems.COPPER_SHEET.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.UP, sheet);

		scene.idle(20);
		scene.world.hideIndependentSection(spout, Direction.SOUTH);
		scene.idle(10);

		Selection fanSelect = util.select.fromTo(4, 1, 3, 5, 2, 2)
			.add(util.select.position(3, 1, 2))
			.add(util.select.position(5, 0, 2));
		scene.world.showSection(fanSelect, Direction.SOUTH);
		ElementLink<WorldSectionElement> water =
			scene.world.showIndependentSection(util.select.position(3, 1, 0), Direction.SOUTH);
		scene.world.moveSection(water, util.vector.of(0, 1, 2), 0);
		scene.idle(30);

		scene.world.hideSection(fanSelect, Direction.SOUTH);
		scene.world.hideIndependentSection(water, Direction.SOUTH);
		scene.idle(30);

		scene.world.showSection(util.select.fromTo(2, 1, 4, 2, 1, 5)
			.add(util.select.position(2, 0, 5)), Direction.DOWN);
		BlockPos armPos = util.grid.at(2, 1, 4);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("...as well as provide Items to Mechanical Arms")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(armPos, Direction.WEST));
		scene.idle(20);

		scene.world.instructArm(armPos, Phase.MOVE_TO_INPUT, ItemStack.EMPTY, 0);
		scene.idle(37);
		scene.world.removeItemsFromBelt(depotPos);
		scene.world.instructArm(armPos, Phase.SEARCH_OUTPUTS, sheet, -1);
	}

}
//文件scenes/CartAssemblerScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.contraptions.mounted.CartAssembleRailType;
import com.simibubi.create.content.contraptions.mounted.CartAssemblerBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.MinecartElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.entity.vehicle.MinecartFurnace;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.Vec3;

public class CartAssemblerScenes {

	public static void anchor(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cart_assembler", "Moving Structures using Cart Assemblers");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(.9f);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos assemblerPos = util.grid.at(2, 1, 2);
		scene.world.setBlock(assemblerPos, Blocks.RAIL.defaultBlockState(), false);
		for (int z = 0; z < 5; z++) {
			scene.world.showSection(util.select.position(2, 1, z), Direction.DOWN);
			scene.idle(2);
		}

		BlockPos leverPos = util.grid.at(0, 1, 2);
		Selection toggle = util.select.fromTo(assemblerPos, leverPos);

		scene.idle(10);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.centerOf(assemblerPos), Pointing.DOWN).rightClick()
				.withItem(AllBlocks.CART_ASSEMBLER.asStack()), 30);
		scene.idle(7);
		scene.world.setBlock(assemblerPos, AllBlocks.CART_ASSEMBLER.getDefaultState()
			.setValue(CartAssemblerBlock.RAIL_SHAPE, RailShape.NORTH_SOUTH)
			.setValue(CartAssemblerBlock.RAIL_TYPE, CartAssembleRailType.REGULAR), true);
		scene.idle(20);
		scene.world.showSection(util.select.fromTo(0, 1, 2, 1, 1, 2), Direction.EAST);
		scene.idle(20);
		scene.world.toggleRedstonePower(toggle);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(10);

		scene.overlay.showText(70)
			.text("Powered Cart Assemblers mount attached structures to passing Minecarts")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(assemblerPos))
			.placeNearTarget();
		scene.idle(80);

		ElementLink<MinecartElement> cart = scene.special.createCart(util.vector.topOf(2, 0, 4), 90, Minecart::new);
		scene.world.showSection(util.select.position(assemblerPos.above()), Direction.DOWN);
		scene.idle(10);
		scene.special.moveCart(cart, util.vector.of(0, 0, -2), 20);
		scene.idle(20);
		ElementLink<WorldSectionElement> plank =
			scene.world.makeSectionIndependent(util.select.position(assemblerPos.above()));
		ElementLink<WorldSectionElement> anchor =
			scene.world.showIndependentSectionImmediately(util.select.position(assemblerPos.east()));
		scene.world.moveSection(anchor, util.vector.of(-1, 0, 0), 0);
		scene.effects.indicateSuccess(assemblerPos);
		scene.idle(1);
		scene.world.moveSection(anchor, util.vector.of(0, 0, -2), 20);
		scene.world.moveSection(plank, util.vector.of(0, 0, -2), 20);
		scene.special.moveCart(cart, util.vector.of(0, 0, -2), 20);
		scene.idle(20);

		scene.world.toggleRedstonePower(toggle);
		scene.idle(10);

		scene.overlay.showText(70)
			.text("Without a redstone signal, it disassembles passing cart contraptions back into blocks")
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(assemblerPos))
			.placeNearTarget();
		scene.idle(80);

		scene.world.rotateSection(anchor, 0, 180, 0, 6);
		scene.world.rotateSection(plank, 0, 180, 0, 6);
		scene.idle(3);

		scene.world.moveSection(anchor, util.vector.of(0, 0, 2), 20);
		scene.world.moveSection(plank, util.vector.of(0, 0, 2), 20);
		scene.special.moveCart(cart, util.vector.of(0, 0, 2), 20);
		scene.idle(21);
		scene.world.moveSection(anchor, util.vector.of(0, -2, 0), 0);
		scene.special.moveCart(cart, util.vector.of(0, 0, 2), 20);
		scene.idle(30);

		scene.world.destroyBlock(assemblerPos.above());
		scene.idle(5);
		scene.world.replaceBlocks(util.select.fromTo(3, 3, 2, 1, 4, 2), Blocks.OAK_PLANKS.defaultBlockState(), false);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(1, 4, 2, 3, 3, 2), Direction.DOWN);
		scene.world.moveSection(contraption, util.vector.of(0, -1, 0), 0);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.position(3, 3, 1), Direction.SOUTH, contraption);

		scene.idle(15);
		scene.overlay.showOutline(PonderPalette.GREEN, "glue", util.select.position(1, 3, 2)
			.add(util.select.fromTo(3, 2, 2, 1, 2, 2))
			.add(util.select.position(3, 2, 1)), 40);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(3, 2, 2)), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);

		scene.effects.superGlue(util.grid.at(3, 2, 1), Direction.SOUTH, true);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.sharedText("movement_anchors")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 3, 2), Direction.NORTH))
			.placeNearTarget();
		scene.idle(80);
		scene.world.toggleRedstonePower(toggle);
		scene.effects.indicateRedstone(leverPos);

		scene.special.moveCart(cart, util.vector.of(0, 0, -2), 20);
		scene.idle(20);
		scene.world.moveSection(anchor, util.vector.of(0, 2, 0), 0);
		scene.idle(1);
		scene.world.moveSection(anchor, util.vector.of(0, 0, -2), 20);
		scene.world.moveSection(contraption, util.vector.of(0, 0, -2), 20);
		scene.special.moveCart(cart, util.vector.of(0, 0, -2), 20);
		scene.idle(25);

		Vec3 cartCenter = util.vector.centerOf(assemblerPos.north(2));
		scene.overlay.showControls(new InputWindowElement(cartCenter, Pointing.LEFT).rightClick()
			.withWrench(), 40);
		scene.idle(7);
		scene.special.moveCart(cart, util.vector.of(0, -100, 4), 0);
		scene.world.moveSection(anchor, util.vector.of(0, -100, 4), 0);
		scene.world.moveSection(contraption, util.vector.of(0, -100, 4), 0);
		ItemStack asStack = AllItems.MINECART_CONTRAPTION.asStack();
		ElementLink<EntityElement> itemEntity =
			scene.world.createItemEntity(cartCenter, util.vector.of(0, .1, 0), asStack);
		scene.idle(40);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Using a Wrench on the Minecart will let you carry the Contraption elsewhere")
			.pointAt(cartCenter)
			.placeNearTarget();
		scene.idle(80);
		scene.world.modifyEntity(itemEntity, Entity::discard);

		scene.overlay.showControls(new InputWindowElement(cartCenter.add(0, 0, 4), Pointing.DOWN).rightClick()
			.withItem(asStack), 20);
		scene.idle(20);
		scene.special.moveCart(cart, util.vector.of(0, 100.5, 0), 0);
		scene.world.moveSection(anchor, util.vector.of(0, 100.5, 0), 0);
		scene.world.moveSection(contraption, util.vector.of(0, 100.5, 0), 0);
		scene.idle(1);
		scene.special.moveCart(cart, util.vector.of(0, -.5, 0), 5);
		scene.world.moveSection(anchor, util.vector.of(0, -.5, 0), 5);
		scene.world.moveSection(contraption, util.vector.of(0, -.5, 0), 5);
	}

	public static void modes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cart_assembler_modes", "Orientation Settings for Minecart Contraptions");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		for (int z = 0; z < 4; z++) {
			scene.world.showSection(util.select.position(1, 1, z), Direction.DOWN);
			scene.idle(2);
		}
		for (int x = 2; x < 5; x++) {
			scene.world.showSection(util.select.position(x, 1, 3), Direction.DOWN);
			scene.idle(2);
		}

		BlockPos assemblerPos = util.grid.at(3, 1, 3);
		scene.idle(5);
		scene.world.setBlock(assemblerPos, AllBlocks.CART_ASSEMBLER.getDefaultState()
			.setValue(CartAssemblerBlock.RAIL_SHAPE, RailShape.EAST_WEST)
			.setValue(CartAssemblerBlock.RAIL_TYPE, CartAssembleRailType.REGULAR), true);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 1, 3, 1, 2), Direction.SOUTH);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.position(3, 2, 3), Direction.DOWN);
		scene.idle(10);
		scene.world.glueBlockOnto(util.grid.at(2, 2, 3), Direction.EAST, contraption);
		scene.world.toggleRedstonePower(util.select.fromTo(3, 1, 1, 3, 1, 3));
		scene.effects.indicateRedstone(util.grid.at(3, 1, 1));
		scene.idle(10);

		ElementLink<MinecartElement> cart =
			scene.special.createCart(util.vector.topOf(util.grid.at(4, 0, 3)), 0, Minecart::new);
		scene.idle(20);
		scene.special.moveCart(cart, util.vector.of(-1, 0, 0), 10);
		scene.idle(10);
		ElementLink<WorldSectionElement> anchor =
			scene.world.showIndependentSectionImmediately(util.select.position(assemblerPos.south()));
		scene.world.moveSection(anchor, util.vector.of(0, 0, -1), 0);
		scene.idle(1);

		scene.world.setKineticSpeed(util.select.position(2, 2, 3), 32);
		scene.special.moveCart(cart, util.vector.of(-1.5, 0, 0), 15);
		scene.world.moveSection(anchor, util.vector.of(-1.5, 0, 0), 15);
		scene.world.moveSection(contraption, util.vector.of(-1.5, 0, 0), 15);
		scene.idle(16);
		scene.special.rotateCart(cart, -45, 2);
		scene.special.moveCart(cart, util.vector.of(-.5, 0, -.5), 8);
		scene.world.moveSection(anchor, util.vector.of(-.5, 0, -.5), 8);
		scene.world.moveSection(contraption, util.vector.of(-.5, 0, -.5), 8);
		scene.world.rotateSection(anchor, 0, -90, 0, 12);
		scene.world.rotateSection(contraption, 0, -90, 0, 12);
		scene.idle(9);
		scene.special.rotateCart(cart, -45, 2);
		scene.special.moveCart(cart, util.vector.of(0, 0, -1.5), 15);
		scene.world.moveSection(anchor, util.vector.of(0, 0, -1.5), 15);
		scene.world.moveSection(contraption, util.vector.of(0, 0, -1.5), 15);
		scene.idle(15);
		scene.world.setKineticSpeed(util.select.position(2, 2, 3), 0);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Cart Contraptions will rotate to face towards their carts' motion")
			.pointAt(util.vector.of(1.5, 2.5, 0))
			.placeNearTarget();
		scene.idle(90);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("This Arrow indicates which side of the Structure will be considered the front")
			.pointAt(util.vector.topOf(assemblerPos))
			.placeNearTarget();
		scene.idle(90);

		scene.world.hideIndependentSection(contraption, Direction.UP);
		scene.world.hideIndependentSection(anchor, Direction.UP);
		scene.special.hideElement(cart, Direction.UP);
		scene.idle(25);

		Vec3 blockSurface = util.vector.blockSurface(assemblerPos, Direction.NORTH)
			.add(0, -1 / 16f, -2 / 16f);
		scene.overlay.showFilterSlotInput(blockSurface, Direction.NORTH, 60);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.DOWN).rightClick(), 60);
		scene.idle(10);
		scene.overlay.showText(60)
			.pointAt(util.vector.of(3, 1.5, 3))
			.placeNearTarget()
			.sharedText("behaviour_modify_value_panel");
		scene.idle(70);

		contraption = scene.world.showIndependentSection(util.select.fromTo(3, 2, 3, 2, 2, 3), Direction.DOWN);
		cart = scene.special.createCart(util.vector.topOf(util.grid.at(4, 0, 3)), 0, Minecart::new);
		scene.idle(10);
		scene.special.moveCart(cart, util.vector.of(-1, 0, 0), 10);
		scene.idle(10);
		anchor = scene.world.showIndependentSectionImmediately(util.select.position(assemblerPos.south()));
		scene.world.moveSection(anchor, util.vector.of(0, 0, -1), 0);
		scene.idle(1);

		scene.world.setKineticSpeed(util.select.position(2, 2, 3), 32);
		scene.special.moveCart(cart, util.vector.of(-1.5, 0, 0), 15);
		scene.world.moveSection(anchor, util.vector.of(-1.5, 0, 0), 15);
		scene.world.moveSection(contraption, util.vector.of(-1.5, 0, 0), 15);
		scene.idle(16);
		scene.special.rotateCart(cart, -45, 2);
		scene.special.moveCart(cart, util.vector.of(-.5, 0, -.5), 8);
		scene.world.moveSection(anchor, util.vector.of(-.5, 0, -.5), 8);
		scene.world.moveSection(contraption, util.vector.of(-.5, 0, -.5), 8);
		scene.idle(9);
		scene.special.rotateCart(cart, -45, 2);
		scene.special.moveCart(cart, util.vector.of(0, 0, -1.5), 15);
		scene.world.moveSection(anchor, util.vector.of(0, 0, -1.5), 15);
		scene.world.moveSection(contraption, util.vector.of(0, 0, -1.5), 15);
		scene.idle(15);
		scene.world.setKineticSpeed(util.select.position(2, 2, 3), 0);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("If the Assembler is set to Lock Rotation, the contraptions' orientation will never change")
			.pointAt(util.vector.of(0, 2.5, 1.5))
			.placeNearTarget();
		scene.idle(90);
	}

	public static void dual(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cart_assembler_dual", "Assembling Carriage Contraptions");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(.9f);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		for (int z = 0; z < 5; z++) {
			scene.world.showSection(util.select.position(1, 1, z), Direction.DOWN);
			scene.idle(2);
		}
		for (int x = 2; x < 6; x++) {
			scene.world.showSection(util.select.position(x, 1, 4), Direction.DOWN);
			scene.idle(2);
		}

		BlockPos assembler1 = util.grid.at(2, 1, 4);
		BlockPos assembler2 = util.grid.at(5, 1, 4);
		Selection chassis = util.select.fromTo(5, 2, 4, 2, 2, 4);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(2, 1, 3, 2, 1, 2), Direction.SOUTH);
		scene.idle(5);
		ElementLink<MinecartElement> cart =
			scene.special.createCart(util.vector.topOf(assembler1.below()), 0, Minecart::new);
		ElementLink<MinecartElement> cart2 =
			scene.special.createCart(util.vector.topOf(assembler2.below()), 0, MinecartChest::new);
		scene.idle(15);
		scene.world.setBlock(assembler1, AllBlocks.CART_ASSEMBLER.getDefaultState()
			.setValue(CartAssemblerBlock.RAIL_SHAPE, RailShape.EAST_WEST)
			.setValue(CartAssemblerBlock.RAIL_TYPE, CartAssembleRailType.CONTROLLER_RAIL), true);
		scene.idle(5);
		scene.world.setBlock(assembler2, AllBlocks.CART_ASSEMBLER.getDefaultState()
			.setValue(CartAssemblerBlock.RAIL_SHAPE, RailShape.EAST_WEST)
			.setValue(CartAssemblerBlock.RAIL_TYPE, CartAssembleRailType.REGULAR), true);
		scene.idle(5);

		ElementLink<WorldSectionElement> contraption = scene.world.showIndependentSection(chassis, Direction.DOWN);
		scene.idle(15);
		scene.overlay.showOutline(PonderPalette.GREEN, new Object(), util.select.position(assembler2), 60);
		scene.overlay.showSelectionWithText(util.select.position(assembler1), 60)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 4), Direction.NORTH))
			.placeNearTarget()
			.text("Whenever two Cart Assembers share an attached structure...")
			.attachKeyFrame();
		scene.idle(70);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 4), Direction.NORTH))
			.placeNearTarget()
			.text("Powering either of them will create a Carriage Contraption");
		scene.idle(70);

		scene.effects.indicateRedstone(util.grid.at(2, 1, 2));
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 2, 2, 1, 4));
		ElementLink<WorldSectionElement> anchors =
			scene.world.showIndependentSectionImmediately(util.select.fromTo(assembler1.south(), assembler2.south()));
		scene.world.moveSection(anchors, util.vector.of(0, 0, -1), 0);
		scene.world.configureCenterOfRotation(anchors, util.vector.centerOf(util.grid.at(2, 2, 5)));
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(util.grid.at(2, 2, 4)));
		scene.idle(5);

		Vec3 m = util.vector.of(-0.5, 0, 0);
		scene.special.moveCart(cart, m, 5);
		scene.special.moveCart(cart2, m, 5);
		scene.world.moveSection(contraption, m, 5);
		scene.world.moveSection(anchors, m, 5);
		scene.idle(5);
		scene.special.rotateCart(cart, -45, 2);
		scene.special.moveCart(cart2, util.vector.of(-.3, 0, 0), 8);
		m = util.vector.of(-.5, 0, -.5);
		scene.special.moveCart(cart, m, 8);
		scene.world.moveSection(anchors, m, 8);
		scene.world.moveSection(contraption, m, 8);
		scene.world.rotateSection(anchors, 0, -10, 0, 8);
		scene.world.rotateSection(contraption, 0, -10, 0, 8);
		scene.idle(8);
		scene.special.rotateCart(cart, -45, 2);
		scene.special.moveCart(cart2, util.vector.of(-.4, 0, 0), 5);
		m = util.vector.of(0, 0, -3.5);
		scene.special.moveCart(cart, m, 25);
		scene.world.moveSection(anchors, m, 25);
		scene.world.moveSection(contraption, m, 25);
		scene.world.rotateSection(anchors, 0, -33, 0, 10);
		scene.world.rotateSection(contraption, 0, -33, 0, 10);
		scene.idle(5);
		scene.special.moveCart(cart2, util.vector.of(-0.8, 0, 0), 5);
		scene.idle(5);
		scene.special.moveCart(cart2, util.vector.of(-1.5, 0, 0), 9);
		scene.world.rotateSection(anchors, 0, -42, 0, 9);
		scene.world.rotateSection(contraption, 0, -42, 0, 9);
		scene.idle(9);
		m = util.vector.of(-.5, 0, -.5);
		scene.special.moveCart(cart2, m, 2);
		scene.special.rotateCart(cart2, -45, 2);
		scene.world.rotateSection(anchors, 0, -5, 0, 5);
		scene.world.rotateSection(contraption, 0, -5, 0, 5);
		scene.idle(2);
		scene.special.moveCart(cart2, util.vector.of(0, 0, -.5), 5);
		scene.special.rotateCart(cart2, -45, 2);
		scene.idle(10);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 3), Direction.WEST))
			.placeNearTarget()
			.text("The carts will behave like those connected via Minecart Coupling");
		scene.idle(80);

	}

	public static void rails(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cart_assembler_rails", "Other types of Minecarts and Rails");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(.9f);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		for (int x = 0; x < 6; x++) {
			scene.world.showSection(util.select.position(x, 1, 3), Direction.DOWN);
			scene.idle(2);
		}

		BlockPos assembler = util.grid.at(3, 1, 3);

		Selection chassis = util.select.fromTo(4, 2, 3, 2, 2, 3);

		scene.idle(5);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(assembler, Direction.DOWN))
			.placeNearTarget()
			.text("Cart Assemblers on Regular Tracks will not affect the passing carts' motion");
		scene.idle(10);
		scene.world.setBlock(assembler, AllBlocks.CART_ASSEMBLER.getDefaultState()
			.setValue(CartAssemblerBlock.RAIL_SHAPE, RailShape.EAST_WEST)
			.setValue(CartAssemblerBlock.RAIL_TYPE, CartAssembleRailType.REGULAR), true);
		scene.idle(70);

		ElementLink<MinecartElement> cart = scene.special.createCart(util.vector.topOf(assembler.east(2)
			.below()), 0, Minecart::new);
		ElementLink<WorldSectionElement> anchor =
			scene.world.showIndependentSection(util.select.position(assembler.south()), Direction.DOWN);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.position(assembler.south()
				.above()), Direction.DOWN);
		scene.world.moveSection(contraption, util.vector.of(2, 0, -1), 0);
		scene.world.moveSection(anchor, util.vector.of(2, 0, -1), 0);
		scene.idle(10);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 10);
		scene.world.moveSection(anchor, util.vector.of(-2, 0, 0), 10);
		scene.special.moveCart(cart, util.vector.of(-5, 0, 0), 25);
		scene.idle(30);
		scene.special.hideElement(cart, Direction.UP);
		scene.world.hideIndependentSection(contraption, Direction.UP);
		scene.world.moveSection(anchor, util.vector.of(0, -3, 0), 0);
		scene.idle(30);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(assembler), Pointing.DOWN)
			.withItem(new ItemStack(Items.POWERED_RAIL)), 50);
		scene.idle(7);
		scene.world.setBlock(assembler, AllBlocks.CART_ASSEMBLER.getDefaultState()
			.setValue(CartAssemblerBlock.RAIL_SHAPE, RailShape.EAST_WEST)
			.setValue(CartAssemblerBlock.RAIL_TYPE, CartAssembleRailType.POWERED_RAIL), true);
		scene.overlay.showText(100)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(assembler))
			.placeNearTarget()
			.text("When on Powered or Controller Rail, the carts will be held in place until it's Powered");
		scene.idle(110);

		scene.world.hideIndependentSection(anchor, Direction.DOWN);
		cart = scene.special.createCart(util.vector.topOf(assembler.east(2)
			.below()), 0, Minecart::new);
		anchor = scene.world.showIndependentSection(util.select.position(assembler.south()), Direction.DOWN);
		contraption = scene.world.showIndependentSection(util.select.position(assembler.south()
			.above()), Direction.DOWN);
		scene.world.moveSection(contraption, util.vector.of(2, 0, -1), 0);
		scene.world.moveSection(anchor, util.vector.of(2, 0, -1), 0);
		scene.idle(10);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 10);
		scene.world.moveSection(anchor, util.vector.of(-2, 0, 0), 10);
		scene.special.moveCart(cart, util.vector.of(-2, 0, 0), 10);
		scene.world.showSection(util.select.fromTo(3, 1, 1, 3, 1, 2), Direction.SOUTH);
		scene.idle(30);

		scene.world.toggleRedstonePower(util.select.fromTo(3, 1, 1, 3, 1, 3));
		scene.effects.indicateRedstone(util.grid.at(3, 1, 1));
		scene.idle(5);

		scene.world.moveSection(contraption, util.vector.of(-3, 0, 0), 15);
		scene.world.moveSection(anchor, util.vector.of(-3, 0, 0), 15);
		scene.special.moveCart(cart, util.vector.of(-3, 0, 0), 15);

		scene.idle(30);
		scene.special.hideElement(cart, Direction.UP);
		scene.world.hideIndependentSection(anchor, Direction.UP);
		scene.world.hideIndependentSection(contraption, Direction.UP);
		scene.idle(20);

		cart = scene.special.createCart(util.vector.topOf(assembler.east(2)
			.below()), 0, MinecartFurnace::new);
		scene.idle(10);
		scene.overlay.showText(50)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(assembler.east(2)))
			.placeNearTarget()
			.text("Other types of Minecarts can be used as the anchor");
		scene.idle(50);
		contraption = scene.world.showIndependentSection(chassis, Direction.DOWN);
		scene.idle(5);
		scene.world.glueBlockOnto(assembler.above(2), Direction.DOWN, contraption);
		scene.idle(15);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(assembler.above()), Pointing.UP)
			.withItem(new ItemStack(Items.CHARCOAL)), 40);
		scene.idle(7);
		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(assembler.above(2), Direction.WEST))
			.placeNearTarget()
			.text("Furnace Carts will keep themselves powered, pulling fuel from any attached inventories");
		scene.idle(85);

		Emitter smoke = Emitter.simple(ParticleTypes.LARGE_SMOKE, util.vector.of(0, 0, 0));

		scene.special.moveCart(cart, util.vector.of(-5, 0, 0), 50);
		scene.idle(20);
		anchor = scene.world.showIndependentSectionImmediately(util.select.position(assembler.south()));
		scene.world.moveSection(anchor, util.vector.of(0, 0, -1), 0);
		scene.idle(1);
		scene.world.setKineticSpeed(util.select.position(2, 2, 3), 32);
		scene.world.moveSection(contraption, util.vector.of(-3, 0, 0), 30);
		scene.world.moveSection(anchor, util.vector.of(-3, 0, 0), 30);

		Vec3 vec = util.vector.centerOf(assembler)
			.add(.25, .25, -0.5);
		for (int i = 0; i < 7; i++) {
			scene.effects.emitParticles(vec = vec.add(-.5, 0, 0), smoke, 2, 1);
			scene.idle(5);
		}

		scene.world.setKineticSpeed(util.select.position(2, 2, 3), 0);
	}

}
//文件scenes/ChainDriveScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.content.kinetics.chainDrive.ChainDriveBlock;
import com.simibubi.create.content.redstone.analogLever.AnalogLeverBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.TextWindowElement.Builder;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.phys.AABB;

public class ChainDriveScenes {

	public static void chainDriveAsRelay(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("chain_drive", "Relaying rotational force with Chain Drives");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		BlockPos gaugePos = util.grid.at(0, 1, 3);
		Selection gauge = util.select.position(gaugePos);
		scene.world.showSection(gauge, Direction.UP);
		scene.world.setKineticSpeed(gauge, 0);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(5, 1, 2, 4, 1, 2), Direction.DOWN);
		scene.idle(10);

		for (int i = 0; i < 3; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.position(3, 1, 2 - i), Direction.DOWN);
			if (i != 0)
				scene.world.showSection(util.select.position(3, 1, 2 + i), Direction.DOWN);
		}

		scene.idle(10);
		scene.world.showSection(util.select.position(gaugePos.east(2)), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(gaugePos.east()), Direction.DOWN);
		scene.idle(5);

		scene.world.setKineticSpeed(gauge, 64);
		scene.effects.indicateSuccess(gaugePos);
		scene.idle(20);
		scene.overlay.showText(60)
			.text("Chain Drives relay rotation to each other in a row")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 4), Direction.WEST));
		scene.idle(60);

		Selection shafts = util.select.fromTo(2, 1, 0, 2, 1, 1);
		BlockPos rotatedECD = util.grid.at(3, 1, 0);
		Selection verticalShaft = util.select.fromTo(rotatedECD.above(), rotatedECD.above(2));

		scene.world.showSection(shafts, Direction.EAST);
		scene.idle(10);
		scene.effects.rotationDirectionIndicator(util.grid.at(2, 1, 0));
		scene.effects.rotationDirectionIndicator(util.grid.at(2, 1, 1));
		scene.idle(20);
		scene.overlay.showText(60)
			.text("All shafts connected like this will rotate in the same direction")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 1), Direction.WEST));
		scene.idle(50);
		scene.world.hideSection(shafts, Direction.WEST);
		scene.idle(25);

		scene.addKeyframe();
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(rotatedECD), Pointing.DOWN).rightClick()
			.withWrench(), 30);
		scene.idle(7);
		scene.world.modifyBlock(rotatedECD, s -> s.setValue(ChainDriveBlock.AXIS, Axis.Y), true);
		scene.idle(40);

		scene.world.showSection(verticalShaft, Direction.DOWN);
		scene.idle(10);

		scene.effects.rotationDirectionIndicator(util.grid.at(3, 3, 0));
		scene.idle(10);
		scene.overlay.showText(60)
			.text("Any part of the row can be rotated by 90 degrees")
			.placeNearTarget()
			.pointAt(util.vector.centerOf(3, 2, 0));

		scene.markAsFinished();
	}

	public static void adjustableChainGearshift(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("chain_gearshift", "Controlling rotational speed with Chain Gearshifts");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos leverPos = util.grid.at(3, 1, 0);
		BlockPos eastDrive = util.grid.at(3, 1, 2);

		BlockPos eastGauge = eastDrive.above(3);
		BlockPos middleGauge = eastGauge.west()
			.below();
		BlockPos westGauge = eastGauge.west(2)
			.below(2);

		ElementLink<WorldSectionElement> lever =
			scene.world.showIndependentSection(util.select.fromTo(leverPos, leverPos.south()), Direction.UP);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 3, 4, 2, 3), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(eastDrive, eastDrive.west(2))
			.add(util.select.position(eastDrive.above())), Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(60)
			.text("Unpowered Chain Gearshifts behave exactly like Chain Drives")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(eastDrive, Direction.NORTH));
		scene.idle(60);

		scene.world.showSection(util.select.fromTo(eastGauge, eastGauge.below()), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(middleGauge, middleGauge.below()), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(westGauge), Direction.DOWN);
		scene.idle(5);

		for (BlockPos gauge : new BlockPos[] { eastGauge, middleGauge, westGauge }) {
			scene.idle(5);
			scene.overlay.showText(50)
				.sharedText(gauge == eastGauge ? "rpm16_source" : "rpm16")
				.colored(PonderPalette.MEDIUM)
				.placeNearTarget()
				.pointAt(util.vector.blockSurface(gauge, Direction.NORTH));
		}

		scene.idle(60);

		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(util.select.fromTo(westGauge.below(), middleGauge), f -> 2 * f);

		scene.idle(10);

		AABB bb = new AABB(eastDrive);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, eastDrive, bb, 160);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.FAST, eastDrive.west(), bb.move(-2, 0, 0)
			.expandTowards(15 / 16f, 0, 0), 160);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("When Powered, the speed transmitted to other Chain Drives in the row is doubled")
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.FAST)
			.pointAt(util.vector.blockSurface(eastDrive.west(2), Direction.WEST));
		scene.idle(80);

		for (BlockPos gauge : new BlockPos[] { eastGauge, middleGauge, westGauge }) {
			scene.idle(5);
			scene.overlay.showText(70)
				.sharedText(gauge == eastGauge ? "rpm16_source" : "rpm32")
				.colored(gauge == eastGauge ? PonderPalette.MEDIUM : PonderPalette.FAST)
				.placeNearTarget()
				.pointAt(util.vector.blockSurface(gauge, Direction.NORTH));
		}

		scene.idle(80);

		scene.world.hideSection(util.select.fromTo(eastDrive, eastDrive.west(2)), Direction.SOUTH);
		scene.idle(15);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
		Selection newDriveSelect = util.select.fromTo(eastDrive.south(2), eastDrive.south(2)
			.west(2));
		ElementLink<WorldSectionElement> drives = scene.world.showIndependentSection(newDriveSelect, Direction.NORTH);
		scene.world.modifyKineticSpeed(util.select.fromTo(westGauge.below(), middleGauge), f -> .5f * f);
		scene.world.setKineticSpeed(newDriveSelect, -32);
		scene.world.moveSection(drives, util.vector.of(0, 0, -2), 0);
		scene.world.moveSection(lever, util.vector.of(-2, 0, 0), 10);

		scene.idle(40);

		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(1)));
		scene.world.toggleRedstonePower(util.select.position(1, 1, 4));
		BlockPos analogPos = leverPos.west(2);
		scene.effects.indicateRedstone(analogPos);
		scene.world.modifyKineticSpeed(util.select.position(westGauge), f -> .5f * f);

		scene.idle(10);

		bb = new AABB(eastDrive);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, eastDrive, bb.expandTowards(-15 / 16f, 0, 0), 160);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.SLOW, eastDrive.west(), bb.move(-2, 0, 0), 160);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Whenever the Powered Gearshift is not at the source, its speed will be halved instead")
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.SLOW)
			.pointAt(util.vector.blockSurface(eastDrive.west(2), Direction.WEST));
		scene.idle(80);

		for (BlockPos gauge : new BlockPos[] { eastGauge, middleGauge, westGauge }) {
			scene.idle(5);
			scene.overlay.showText(180)
				.sharedText(gauge == westGauge ? "rpm8" : gauge == eastGauge ? "rpm16_source" : "rpm16")
				.colored(gauge == westGauge ? PonderPalette.SLOW : PonderPalette.MEDIUM)
				.placeNearTarget()
				.pointAt(util.vector.blockSurface(gauge, Direction.NORTH));
		}

		scene.idle(80);

		scene.overlay.showText(100)
			.text("In both cases, Chain Drives in the row always run at 2x the speed of the Powered Gearshift")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(eastDrive.west(2), Direction.WEST));
		scene.idle(100);

		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
		scene.world.toggleRedstonePower(util.select.position(1, 1, 4));
		scene.world.modifyKineticSpeed(util.select.position(westGauge), f -> 2f * f);
		scene.world.hideIndependentSection(lever, Direction.UP);
		scene.idle(15);

		scene.world.showSection(util.select.fromTo(analogPos, analogPos.south()), Direction.DOWN);

		scene.idle(15);
		scene.world.modifyBlockEntityNBT(util.select.position(analogPos), AnalogLeverBlockEntity.class, nbt -> {
			nbt.putInt("State", 8);
		});
		scene.world.modifyBlock(analogPos.south(), s -> s.setValue(RedStoneWireBlock.POWER, 8), false);
		scene.world.toggleRedstonePower(util.select.position(1, 1, 4));
		scene.world.modifyKineticSpeed(util.select.position(westGauge), f -> .75f * f);
		scene.effects.indicateRedstone(analogPos);

		scene.idle(20);

		scene.overlay.showText(100)
			.text("Using analog signals, the ratio can be adjusted more precisely between 1 and 2")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(eastDrive.west(2), Direction.WEST));
		scene.idle(40);

		for (BlockPos gauge : new BlockPos[] { eastGauge, middleGauge, westGauge }) {
			scene.idle(5);
			Builder builder = scene.overlay.showText(180)
				.colored(gauge == westGauge ? PonderPalette.SLOW : PonderPalette.MEDIUM)
				.placeNearTarget()
				.pointAt(util.vector.blockSurface(gauge, Direction.NORTH));
			if (gauge == westGauge)
				builder.text("12 RPM");
			else
				builder.sharedText(gauge == eastGauge ? "rpm16_source" : "rpm16");
		}
	}

}
//文件scenes/ChassisScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import org.apache.commons.lang3.mutable.MutableObject;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.contraptions.chassis.LinearChassisBlock;
import com.simibubi.create.content.contraptions.chassis.RadialChassisBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChassisScenes {

	public static void linearGroup(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("linear_chassis_group", "Moving Linear Chassis in groups");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(10);

		BlockPos centralChassis = util.grid.at(2, 2, 2);
		ElementLink<WorldSectionElement> chassis =
			scene.world.showIndependentSection(util.select.position(centralChassis), Direction.DOWN);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.position(centralChassis.west()), Direction.EAST, chassis);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(centralChassis.east()), Direction.WEST, chassis);
		scene.idle(4);
		scene.world.showSectionAndMerge(util.select.position(centralChassis.east()
			.north()), Direction.SOUTH, chassis);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.position(centralChassis.above()), Direction.DOWN, chassis);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.position(centralChassis.above()
			.east()), Direction.DOWN, chassis);
		scene.idle(10);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Linear Chassis connect to identical Chassis blocks next to them")
			.pointAt(util.vector.topOf(util.grid.at(2, 3, 2)));
		scene.idle(90);

		BlockPos bearingPos = util.grid.at(2, 1, 2);
		scene.world.moveSection(chassis, util.vector.of(0, -1 / 1024f, 0), 0);
		scene.world.configureCenterOfRotation(chassis, util.vector.centerOf(bearingPos));
		scene.world.rotateBearing(bearingPos, 360, 80);
		scene.world.rotateSection(chassis, 0, 360, 0, 80);

		scene.idle(20);
		scene.overlay.showText(80)
			.placeNearTarget()
			.text("When one is moved by a Contraption, the others are dragged with it")
			.pointAt(util.vector.topOf(util.grid.at(2, 3, 2)));
		scene.idle(90);

		Selection wrong1 = util.select.position(2, 4, 2);
		Selection wrong2 = util.select.position(0, 2, 2);

		scene.addKeyframe();
		scene.world.showSection(wrong2, Direction.EAST);
		scene.idle(10);
		scene.world.showSection(wrong1, Direction.DOWN);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.RED, wrong2, wrong2, 80);
		scene.overlay.showSelectionWithText(wrong1, 80)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.text("Chassis of a different type or facing another direction will not attach");
		scene.idle(40);

		scene.world.rotateBearing(bearingPos, 360, 80);
		scene.world.rotateSection(chassis, 0, 360, 0, 80);
		scene.idle(50);
	}

	public static void linearAttachement(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("linear_chassis_attachment", "Attaching blocks using Linear Chassis");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos chassisPos = util.grid.at(2, 2, 2);
		Selection chassis = util.select.position(chassisPos);

		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.world.showSection(chassis, Direction.DOWN);
		scene.idle(10);

		InputWindowElement input =
			new InputWindowElement(util.vector.blockSurface(chassisPos, Direction.WEST), Pointing.LEFT).rightClick()
				.withItem(new ItemStack(Items.SLIME_BALL));
		scene.overlay.showControls(input, 30);
		scene.idle(7);
		scene.world.modifyBlock(chassisPos, s -> s.setValue(LinearChassisBlock.STICKY_BOTTOM, true), false);
		scene.effects.superGlue(chassisPos, Direction.WEST, false);
		scene.idle(30);

		scene.overlay.showText(60)
			.text("The open faces of a Linear Chassis can be made Sticky")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(chassisPos, Direction.WEST));
		scene.idle(70);

		scene.overlay.showControls(input, 15);
		scene.idle(7);
		scene.world.modifyBlock(chassisPos, s -> s.setValue(LinearChassisBlock.STICKY_TOP, true), false);
		scene.effects.superGlue(chassisPos, Direction.EAST, false);
		scene.idle(15);

		scene.overlay.showText(60)
			.text("Click again to make the opposite side sticky")
			.placeNearTarget()
			.pointAt(util.vector.topOf(chassisPos));
		scene.idle(10);
		scene.rotateCameraY(60);
		scene.idle(35);
		scene.rotateCameraY(-60);
		scene.idle(25);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(chassisPos, Direction.WEST), Pointing.LEFT).rightClick()
				.whileSneaking(),
			30);
		scene.idle(7);
		scene.world.modifyBlock(chassisPos, s -> s.setValue(LinearChassisBlock.STICKY_BOTTOM, false), false);
		scene.effects.superGlue(chassisPos, Direction.WEST, false);
		scene.idle(30);

		scene.overlay.showText(60)
			.text("Sneak and Right-Click with an empty hand to remove the slime")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(chassisPos, Direction.WEST));
		scene.idle(70);

		scene.world.hideSection(chassis, Direction.UP);

		scene.idle(20);
		ElementLink<WorldSectionElement> glassSection =
			scene.world.showIndependentSection(util.select.position(chassisPos.above()), Direction.DOWN);
		scene.world.moveSection(glassSection, util.vector.of(0, -1, 0), 0);
		scene.idle(25);
		scene.addKeyframe();
		scene.world.showSectionAndMerge(util.select.fromTo(2, 4, 2, 2, 5, 2), Direction.DOWN, glassSection);
		ElementLink<WorldSectionElement> topGlassSection =
			scene.world.showIndependentSection(util.select.position(2, 6, 2), Direction.DOWN);
		scene.world.moveSection(topGlassSection, util.vector.of(0, -1, 0), 0);
		scene.idle(30);

		Selection column1 = util.select.fromTo(2, 3, 2, 2, 3, 2);
		Selection column2 = util.select.fromTo(2, 3, 2, 2, 4, 2);
		Selection column3 = util.select.fromTo(2, 3, 2, 2, 5, 2);

		scene.overlay.showSelectionWithText(column3, 80)
			.colored(PonderPalette.GREEN)
			.text("Stickied faces of the Linear Chassis will attach a line of blocks in front of it")
			.placeNearTarget();
		scene.idle(90);

		BlockPos bearingPos = util.grid.at(2, 1, 2);
		scene.world.configureCenterOfRotation(glassSection, util.vector.centerOf(bearingPos));
		scene.world.rotateBearing(bearingPos, 180, 40);
		scene.world.rotateSection(glassSection, 0, 180, 0, 40);
		scene.world.rotateSection(topGlassSection, 0, 180, 0, 40);
		scene.idle(50);

		Vec3 blockSurface = util.vector.blockSurface(chassisPos, Direction.NORTH);
		scene.overlay.showCenteredScrollInput(chassisPos, Direction.NORTH, 50);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.UP).rightClick()
			.withWrench(), 50);

		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column3, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column2, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column1, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column2, 15);
		scene.idle(10);

		scene.overlay.showText(60)
			.pointAt(blockSurface)
			.text("Using a Wrench, a precise Range can be specified for this chassis")
			.placeNearTarget();
		scene.idle(70);

		scene.world.rotateBearing(bearingPos, 180, 40);
		scene.world.rotateSection(glassSection, 0, 180, 0, 40);
		scene.idle(50);

		scene.world.rotateSection(topGlassSection, 0, 180, 0, 0);
		scene.world.showSectionAndMerge(util.select.position(1, 3, 2), Direction.UP, glassSection);
		scene.world.showSectionAndMerge(util.select.position(3, 3, 2), Direction.UP, glassSection);
		scene.world.showSectionAndMerge(util.select.fromTo(1, 4, 2, 1, 6, 2), Direction.DOWN, glassSection);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 4, 2, 3, 6, 2), Direction.DOWN, glassSection);
		scene.addKeyframe();
		scene.idle(20);

		scene.overlay.showCenteredScrollInput(chassisPos, Direction.NORTH, 50);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.UP).whileCTRL()
			.rightClick()
			.withWrench(), 50);

		column1 = util.select.fromTo(1, 3, 2, 3, 3, 2);
		column2 = util.select.fromTo(1, 3, 2, 3, 4, 2);
		column3 = util.select.fromTo(1, 3, 2, 3, 5, 2);

		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column2, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column1, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column2, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, column3, 15);
		scene.idle(10);

		scene.overlay.showText(80)
			.pointAt(blockSurface)
			.text("Holding CTRL adjusts the range of all connected Chassis Blocks")
			.placeNearTarget();
		scene.idle(90);

		scene.world.rotateBearing(bearingPos, 180, 40);
		scene.world.rotateSection(glassSection, 0, 180, 0, 40);
		scene.world.rotateSection(topGlassSection, 0, 180, 0, 40);
		scene.idle(50);

		Vec3 glueSurface = util.vector.blockSurface(chassisPos.west(), Direction.NORTH);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.pointAt(glueSurface)
			.text("Attaching blocks to any other side requires the use of Super Glue")
			.placeNearTarget();
		scene.idle(90);
		scene.overlay.showControls(new InputWindowElement(glueSurface, Pointing.DOWN).rightClick()
			.withItem(AllItems.SUPER_GLUE.asStack()), 30);
		scene.idle(7);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glueSurface,
			new AABB(util.grid.at(1, 2, 2)).expandTowards(0, 0, -1), 40);
		scene.idle(20);
		ElementLink<WorldSectionElement> gluedPlank =
			scene.world.showIndependentSection(util.select.position(3, 3, 1), Direction.SOUTH);
		scene.world.moveSection(gluedPlank, util.vector.of(-2, -1, 0), 0);
		scene.idle(15);
		scene.effects.superGlue(chassisPos.west(), Direction.NORTH, true);
		scene.idle(20);

		scene.world.hideIndependentSection(glassSection, Direction.UP);
		scene.world.hideIndependentSection(gluedPlank, Direction.UP);
		scene.world.hideIndependentSection(topGlassSection, Direction.UP);
		scene.idle(15);

		scene.addKeyframe();
		ElementLink<WorldSectionElement> chain =
			scene.world.showIndependentSection(util.select.position(2, 7, 2), Direction.DOWN);
		scene.world.configureCenterOfRotation(chain, util.vector.centerOf(bearingPos));
		scene.world.moveSection(chain, util.vector.of(0, -5, 0), 0);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 8, 2, 3, 9, 2), Direction.DOWN, chain);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 9, 1, 3, 9, 0), Direction.SOUTH, chain);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 9, 0, 1, 9, 0), Direction.EAST, chain);
		scene.idle(20);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(chassisPos.above(2)))
			.text("Using these mechanics, structures of any shape can move as a Contraption")
			.placeNearTarget();
		scene.idle(30);

		scene.world.rotateBearing(bearingPos, 720, 160);
		scene.world.rotateSection(chain, 0, 720, 0, 160);
	}

	public static void radial(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("radial_chassis", "Attaching blocks using Radial Chassis");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		util.select.position(2, 4, 2);

		BlockPos chassisPos = util.grid.at(2, 2, 2);
		Selection chassis = util.select.position(chassisPos);

		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> contraption = scene.world.showIndependentSection(chassis, Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> top =
			scene.world.showIndependentSection(util.select.position(chassisPos.above()), Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(50)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Radial Chassis connect to identical Chassis blocks in a row")
			.pointAt(util.vector.topOf(chassisPos.above()));
		scene.idle(60);

		BlockPos bearingPos = util.grid.at(2, 1, 2);
		scene.world.moveSection(contraption, util.vector.of(0, -1 / 1024f, 0), 0);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearingPos));
		scene.world.rotateBearing(bearingPos, 360, 80);
		scene.world.rotateSection(contraption, 0, 360, 0, 80);
		scene.world.rotateSection(top, 0, 360, 0, 80);

		scene.idle(20);
		scene.overlay.showText(70)
			.placeNearTarget()
			.text("When one is moved by a Contraption, the others are dragged with it")
			.pointAt(util.vector.topOf(util.grid.at(2, 3, 2)));
		scene.idle(80);

		scene.world.hideIndependentSection(top, Direction.UP);
		scene.idle(15);

		scene.addKeyframe();
		InputWindowElement input =
			new InputWindowElement(util.vector.blockSurface(chassisPos, Direction.WEST), Pointing.LEFT).rightClick()
				.withItem(new ItemStack(Items.SLIME_BALL));
		scene.overlay.showControls(input, 30);
		scene.idle(7);
		scene.world.modifyBlock(chassisPos, s -> s.setValue(RadialChassisBlock.STICKY_WEST, true), false);
		scene.effects.superGlue(chassisPos, Direction.WEST, false);
		scene.idle(30);

		scene.overlay.showText(60)
			.text("The side faces of a Radial Chassis can be made Sticky")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(chassisPos, Direction.WEST));
		scene.idle(70);

		scene.overlay.showControls(input, 15);
		scene.idle(7);
		scene.world.modifyBlock(chassisPos, s -> s.setValue(RadialChassisBlock.STICKY_EAST, true)
			.setValue(RadialChassisBlock.STICKY_NORTH, true)
			.setValue(RadialChassisBlock.STICKY_SOUTH, true), false);
		scene.effects.superGlue(chassisPos, Direction.EAST, false);
		scene.effects.superGlue(chassisPos, Direction.SOUTH, false);
		scene.effects.superGlue(chassisPos, Direction.NORTH, false);
		scene.idle(15);

		scene.overlay.showText(60)
			.text("Click again to make all other sides sticky")
			.placeNearTarget()
			.pointAt(util.vector.topOf(chassisPos));
		scene.idle(10);
		scene.rotateCameraY(60);
		scene.idle(35);
		scene.rotateCameraY(-60);
		scene.idle(25);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(chassisPos, Direction.WEST), Pointing.LEFT).rightClick()
				.whileSneaking(),
			30);
		scene.idle(7);
		scene.world.modifyBlock(chassisPos, s -> s.setValue(RadialChassisBlock.STICKY_WEST, false), false);
		scene.effects.superGlue(chassisPos, Direction.WEST, false);
		scene.idle(30);

		scene.overlay.showText(60)
			.text("Sneak and Right-Click with an empty hand to remove the slime")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(chassisPos, Direction.WEST));
		scene.idle(70);

		Selection s = util.select.position(chassisPos.north());
		Selection growing = s.copy();
		Selection r1 = util.select.fromTo(1, 2, 1, 3, 2, 3)
			.substract(chassis);
		Selection r2 = r1.copy()
			.add(util.select.fromTo(0, 2, 1, 0, 2, 3))
			.add(util.select.fromTo(1, 2, 0, 3, 2, 0))
			.add(util.select.fromTo(1, 2, 4, 3, 2, 4))
			.add(util.select.fromTo(4, 2, 1, 4, 2, 3));
		Selection r3 = util.select.layer(2)
			.add(util.select.fromTo(-1, 2, 1, 5, 2, 3))
			.add(util.select.fromTo(1, 2, -1, 3, 2, 5))
			.substract(chassis);

		scene.addKeyframe();
		scene.world.showSectionAndMerge(r1, Direction.DOWN, contraption);
		ElementLink<WorldSectionElement> outer = scene.world.showIndependentSection(util.select.layer(2)
			.substract(chassis)
			.substract(r1), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(0, 3, 3, 1, 3, 4), Direction.DOWN);
		scene.idle(10);
		Vec3 blockSurface = util.vector.blockSurface(chassisPos, Direction.NORTH);
		AABB bb = new AABB(blockSurface, blockSurface).inflate(.501, .501, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb, 60);
		scene.overlay.showOutline(PonderPalette.WHITE, s, s, 80);
		scene.overlay.showText(40)
			.text("Whenever a Block is next to a sticky face...")
			.placeNearTarget()
			.pointAt(blockSurface.add(0, .5, 0));
		scene.idle(60);

		MutableObject<Selection> obj = new MutableObject<>(growing);
		r2.forEach(pos -> {
			scene.idle(1);
			Selection add = obj.getValue()
				.copy()
				.add(util.select.position(pos));
			scene.overlay.showOutline(PonderPalette.WHITE, s, add, 3);
			obj.setValue(add);
		});

		scene.overlay.showSelectionWithText(obj.getValue(), 60)
			.colored(PonderPalette.GREEN)
			.text("...it will attach all reachable blocks within a radius on that layer");
		scene.idle(70);

		scene.world.configureCenterOfRotation(outer, util.vector.centerOf(bearingPos));
		scene.world.rotateBearing(bearingPos, 360, 80);
		scene.world.rotateSection(contraption, 0, 360, 0, 80);
		scene.world.rotateSection(outer, 0, 360, 0, 80);
		scene.idle(90);

		scene.addKeyframe();
		blockSurface = util.vector.topOf(chassisPos);
		scene.overlay.showCenteredScrollInput(chassisPos, Direction.UP, 50);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.DOWN).rightClick()
			.withWrench(), 50);

		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, r2, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, r3, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, r2, 20);
		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.WHITE, chassis, r1, 15);
		scene.idle(10);

		scene.overlay.showText(60)
			.pointAt(blockSurface)
			.text("Using a Wrench, a precise Radius can be specified for this chassis")
			.placeNearTarget();
		scene.idle(70);

		scene.world.rotateBearing(bearingPos, 360, 80);
		scene.world.rotateSection(contraption, 0, 360, 0, 80);
		scene.idle(90);

		scene.world.destroyBlock(util.grid.at(1, 2, 0));
		scene.idle(1);
		scene.world.destroyBlock(util.grid.at(1, 2, 1));
		scene.idle(1);
		scene.world.destroyBlock(util.grid.at(1, 2, 3));
		scene.idle(1);
		scene.world.destroyBlock(util.grid.at(1, 2, 4));
		scene.idle(10);

		Selection ignored = util.select.fromTo(0, 2, 1, 0, 2, 3)
			.add(util.select.position(1, 2, 2));
		scene.overlay.showOutline(PonderPalette.GREEN, r2, r2.copy()
			.substract(util.select.fromTo(0, 2, 0, 1, 2, 4)), 80);
		scene.markAsFinished();
		scene.overlay.showSelectionWithText(ignored, 80)
			.colored(PonderPalette.RED)
			.text("Blocks not reachable by any sticky face will not attach");
	}

	public static void superGlue(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("super_glue", "Attaching blocks using Super Glue");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.setSceneOffsetY(-1);
		scene.idle(15);

		Selection slab = util.select.fromTo(0, 2, 2, 1, 2, 2);
		Selection pulley = util.select.fromTo(2, 2, 2, 2, 4, 2);
		BlockPos pulleyPos = util.grid.at(2, 4, 2);
		Selection kinetics = util.select.fromTo(1, 4, 2, 2, 4, 2);
		BlockPos crankPos = util.grid.at(1, 4, 2);
		Selection torch = util.select.position(1, 2, 3);
		Selection harvester = util.select.position(3, 2, 3);
		Selection lever = util.select.position(1, 1, 1);

		scene.world.setBlocks(util.select.fromTo(2, 2, 2, 2, 3, 2), Blocks.AIR.defaultBlockState(), false);

		scene.world.showSection(util.select.fromTo(1, 1, 2, 2, 1, 2), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(2, 2, 3, 2, 1, 3), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 3, 1, 2), Direction.WEST);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Super Glue groups blocks together into moving contraptions")
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.topOf(util.grid.at(2, 1, 2)));
		scene.idle(70);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(2, 2, 3), Pointing.DOWN).withItem(AllItems.SUPER_GLUE.asStack())
				.rightClick(),
			40);
		scene.idle(6);
		scene.effects.indicateSuccess(util.grid.at(2, 2, 3));

		scene.idle(45);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.DOWN), Pointing.UP)
				.withItem(AllItems.SUPER_GLUE.asStack())
				.rightClick(),
			40);
		scene.idle(6);

		AABB bb = new AABB(util.grid.at(2, 2, 3));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, lever, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, lever, bb.expandTowards(-1, -1, -1), 285);
		scene.idle(25);

		scene.overlay.showText(70)
			.text("Clicking two endpoints creates a new 'glued' area")
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.WEST));
		scene.idle(80);

		bb = new AABB(util.grid.at(3, 1, 3));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, crankPos, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, crankPos, bb.expandTowards(0, 0, -2), 66);
		scene.idle(20);

		scene.overlay.showText(70)
			.text("To remove a box, punch it with the glue item in hand")
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 1), Direction.WEST));
		scene.idle(40);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 1, 1), Direction.UP), Pointing.DOWN)
				.withItem(AllItems.SUPER_GLUE.asStack())
				.leftClick(),
			40);
		scene.idle(50);

		Selection toMove = util.select.fromTo(1, 1, 2, 2, 1, 2)
			.add(util.select.fromTo(2, 2, 3, 2, 1, 3));
		scene.overlay.showSelectionWithText(toMove, 70)
			.text("Adjacent blocks sharing an area will pull each other along")
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.WEST));
		scene.idle(50);

		scene.world.showSection(pulley, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(crankPos), Direction.EAST);
		scene.idle(20);

		scene.world.movePulley(pulleyPos, -1, 20);
		scene.world.setKineticSpeed(kinetics, -24);
		ElementLink<WorldSectionElement> contraption = scene.world.makeSectionIndependent(toMove);
		scene.world.moveSection(contraption, util.vector.of(0, 1, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(10);

		scene.world.movePulley(pulleyPos, 1, 20);
		scene.world.setKineticSpeed(kinetics, 24);
		scene.world.moveSection(contraption, util.vector.of(0, -1, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(10);

		bb = new AABB(util.grid.at(2, 2, 3));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, "0", bb.expandTowards(-1, -1, -1), 70);
		scene.idle(15);
		scene.world.showSection(slab, Direction.DOWN);
		bb = new AABB(util.grid.at(2, 1, 2));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, "1", bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, "1", bb.expandTowards(2, 0, 0), 55);
		scene.idle(15);
		bb = new AABB(util.grid.at(1, 2, 2));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, "2", bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, "2", bb.expandTowards(-1, 0, 0), 40);

		scene.overlay.showText(70)
			.text("Overlapping glue volumes will move together")
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(0, 2, 2), Direction.WEST));
		scene.idle(40);

		ElementLink<WorldSectionElement> cogs = scene.world.makeSectionIndependent(util.select.fromTo(4, 1, 2, 3, 1, 2)
			.add(util.select.fromTo(1, 2, 2, 0, 2, 2)));

		scene.world.movePulley(pulleyPos, -1, 20);
		scene.world.setKineticSpeed(kinetics, -24);
		scene.world.moveSection(contraption, util.vector.of(0, 1, 0), 20);
		scene.world.moveSection(cogs, util.vector.of(0, 1, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(10);

		scene.overlay.showOutline(PonderPalette.GREEN, cogs, util.select.fromTo(4, 2, 2, 1, 2, 2)
			.add(util.select.fromTo(2, 3, 3, 2, 2, 3))
			.add(util.select.fromTo(1, 3, 2, 0, 3, 2)), 70);
		ElementLink<WorldSectionElement> brittles = scene.world.showIndependentSection(lever, Direction.SOUTH);
		scene.world.moveSection(brittles, util.vector.of(0, 1, 0), 0);
		scene.idle(5);
		scene.world.showSectionAndMerge(harvester, Direction.WEST, brittles);
		scene.idle(5);
		scene.world.showSectionAndMerge(torch, Direction.EAST, brittles);
		scene.idle(25);

		scene.overlay.showText(80)
			.text("Blocks hanging on others usually do not require glue")
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.NORTH));
		scene.idle(80);

		scene.world.movePulley(pulleyPos, 1, 20);
		scene.world.setKineticSpeed(kinetics, 24);
		scene.world.moveSection(cogs, util.vector.of(0, -1, 0), 20);
		scene.world.moveSection(brittles, util.vector.of(0, -1, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(0, -1, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(10);

	}

}
//文件scenes/ChuteScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import static com.simibubi.create.content.logistics.chute.ChuteBlock.SHAPE;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.logistics.chute.ChuteBlock;
import com.simibubi.create.content.logistics.chute.ChuteBlock.Shape;
import com.simibubi.create.content.logistics.chute.SmartChuteBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class ChuteScenes {

	public static void downward(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("chute", "Transporting Items downward via Chutes");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(.9f);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		ElementLink<WorldSectionElement> top =
			scene.world.showIndependentSection(util.select.fromTo(3, 3, 3, 3, 4, 3), Direction.DOWN);
		ElementLink<WorldSectionElement> bottom =
			scene.world.showIndependentSection(util.select.fromTo(3, 2, 3, 3, 1, 3), Direction.DOWN);
		scene.world.moveSection(bottom, util.vector.of(-2, 0, -1), 0);
		scene.world.moveSection(top, util.vector.of(0, 0, -1), 0);
		scene.idle(20);

		ItemStack stack = new ItemStack(Items.COPPER_BLOCK);
		scene.world.createItemEntity(util.vector.centerOf(util.grid.at(3, 3, 2)), util.vector.of(0, -0.1, 0), stack);
		scene.idle(20);
		ElementLink<EntityElement> remove =
			scene.world.createItemEntity(util.vector.centerOf(util.grid.at(1, 5, 2)), util.vector.of(0, 0.1, 0), stack);
		scene.idle(15);
		scene.world.modifyEntity(remove, Entity::discard);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(util.grid.at(1, 2, 2)))
			.placeNearTarget()
			.text("Chutes can transport items vertically from and to inventories");
		scene.idle(70);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.moveSection(bottom, util.vector.of(1, 0, 0), 10);
		scene.world.moveSection(top, util.vector.of(-1, 0, 0), 10);
		scene.idle(20);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick()
				.withWrench(),
			40);
		scene.idle(7);
		scene.world.modifyBlock(util.grid.at(3, 3, 3), s -> s.setValue(ChuteBlock.SHAPE, ChuteBlock.Shape.WINDOW),
			false);
		scene.overlay.showText(50)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.WEST))
			.placeNearTarget()
			.text("Using the Wrench, a window can be created");

		scene.idle(60);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick()
				.withItem(AllBlocks.INDUSTRIAL_IRON_BLOCK.asStack()),
			40);
		scene.idle(7);
		scene.world.modifyBlock(util.grid.at(3, 2, 3), s -> s.setValue(ChuteBlock.SHAPE, ChuteBlock.Shape.ENCASED),
			false);
		scene.overlay.showText(50)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.WEST))
			.placeNearTarget()
			.text("Using Industrial Iron Blocks, chutes can be encased");

		scene.idle(10);

		for (int i = 0; i < 8; i++) {
			scene.idle(10);
			scene.world.createItemOnBeltLike(util.grid.at(3, 3, 3), Direction.UP, stack);
		}
		scene.idle(20);
		scene.world.hideIndependentSection(bottom, Direction.EAST);
		scene.world.hideIndependentSection(top, Direction.EAST);
		scene.idle(15);
		scene.addKeyframe();

		scene.rotateCameraY(-90);
		scene.world.modifyBlock(util.grid.at(2, 2, 1), s -> s.setValue(SHAPE, Shape.NORMAL), false);
		scene.world.modifyBlock(util.grid.at(2, 3, 2), s -> s.setValue(SHAPE, Shape.INTERSECTION), false);
		scene.world.showSection(util.select.fromTo(2, 1, 1, 2, 2, 1), Direction.DOWN);
		scene.idle(30);
		ItemStack chuteItem = AllBlocks.CHUTE.asStack();
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 2, 1), Direction.SOUTH), Pointing.LEFT)
				.rightClick()
				.withItem(chuteItem),
			30);
		scene.idle(7);
		scene.world.showSection(util.select.position(2, 3, 2), Direction.NORTH);
		scene.world.restoreBlocks(util.select.position(2, 2, 1));
		scene.idle(15);
		scene.idle(20);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.SOUTH), Pointing.LEFT)
				.rightClick()
				.withItem(chuteItem),
			30);
		scene.idle(7);
		scene.world.showSection(util.select.position(2, 4, 3), Direction.NORTH);
		scene.idle(10);
		scene.world.restoreBlocks(util.select.position(2, 3, 2));
		scene.idle(25);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 4, 3), Direction.WEST))
			.placeNearTarget()
			.text("Placing chutes targeting the side faces of another will make it diagonal");
		scene.idle(15);
		scene.rotateCameraY(90);

		scene.idle(35);

		Direction offset = Direction.NORTH;
		for (int i = 0; i < 3; i++) {
			remove = scene.world.createItemEntity(util.vector.centerOf(util.grid.at(2, 6, 3)
				.relative(offset)), util.vector.of(0, 0.1, 0)
					.add(Vec3.atLowerCornerOf(offset.getNormal())
						.scale(-.1)),
				stack);
			scene.idle(12);
			scene.world.createItemOnBeltLike(util.grid.at(2, 4, 3), Direction.UP, stack);
			scene.world.modifyEntity(remove, Entity::discard);
			scene.idle(3);
			offset = offset.getClockWise();
		}

		scene.idle(10);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 1, 1), Direction.NORTH), Pointing.RIGHT)
				.withItem(stack),
			50);
		scene.markAsFinished();
	}

	public static void upward(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("chute_upward", "Transporting Items upward via Chutes");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(.9f);
		scene.showBasePlate();
		Selection chute = util.select.fromTo(1, 2, 2, 1, 4, 2);
		scene.world.setBlocks(chute, Blocks.AIR.defaultBlockState(), false);
		scene.world.showSection(util.select.position(1, 1, 2), Direction.UP);
		scene.idle(20);

		scene.world.restoreBlocks(chute);
		scene.world.showSection(chute, Direction.DOWN);
		scene.idle(20);
		scene.world.setKineticSpeed(util.select.position(1, 1, 2), 0);
		Vec3 surface = util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.WEST);
		scene.overlay.showText(70)
			.text("Using Encased Fans at the top or bottom, a Chute can move items upward")
			.attachKeyFrame()
			.pointAt(surface)
			.placeNearTarget();
		scene.idle(80);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.NORTH), Pointing.RIGHT)
				.withItem(AllItems.GOGGLES.asStack()),
			50);
		scene.overlay.showText(70)
			.text("Inspecting chutes with Engineers' Goggles reveals information about the movement direction")
			.attachKeyFrame()
			.pointAt(surface)
			.placeNearTarget();
		scene.idle(80);

		scene.world.showSection(util.select.fromTo(2, 2, 2, 4, 1, 5)
			.add(util.select.position(3, 0, 5)), Direction.DOWN);
		ItemStack stack = new ItemStack(Items.COPPER_BLOCK);
		scene.world.createItemOnBelt(util.grid.at(4, 1, 2), Direction.EAST, stack);
		scene.idle(10);
		scene.rotateCameraY(60);
		scene.overlay.showText(70)
			.text("On the 'blocked' end, items will have to be inserted/taken from the sides")
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(util.grid.at(3, 1, 2))
				.add(0, 3 / 16f, 0))
			.placeNearTarget();
		scene.idle(32);
		scene.world.flapFunnel(util.grid.at(2, 2, 2), false);
		scene.world.removeItemsFromBelt(util.grid.at(2, 1, 2));
		scene.world.createItemOnBeltLike(util.grid.at(1, 2, 2), Direction.EAST, stack);
	}

	public static void smart(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("smart_chute", "Filtering Items using Smart Chutes");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(.9f);

		Selection lever = util.select.fromTo(0, 1, 2, 1, 3, 2);
		BlockPos smarty = util.grid.at(2, 3, 2);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(2, 1, 2, 2, 2, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(2, 3, 2), Direction.DOWN);

		scene.overlay.showText(60)
			.text("Smart Chutes are vertical chutes with additional control")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(smarty, Direction.WEST))
			.placeNearTarget();
		scene.idle(70);

		Vec3 filter = util.vector.blockSurface(smarty, Direction.NORTH)
			.add(0, 3 / 16f, 0);
		scene.overlay.showFilterSlotInput(filter, Direction.NORTH, 70);
		scene.idle(10);
		scene.rotateCameraY(20);
		scene.overlay.showText(60)
			.text("Items in the filter slot specify what to extract or transfer")
			.attachKeyFrame()
			.pointAt(filter.add(0, 0, 0.125))
			.placeNearTarget();
		scene.idle(60);
		
		scene.world.showSection(util.select.position(2, 4, 2), Direction.DOWN);
		scene.idle(15);

		ItemStack copper = new ItemStack(Items.IRON_INGOT);
		scene.overlay.showControls(new InputWindowElement(filter.add(0, 0.125, 0), Pointing.DOWN).rightClick()
			.withItem(copper), 40);
		scene.idle(7);
		scene.world.setFilterData(util.select.position(smarty), SmartChuteBlockEntity.class, copper);

		for (int i = 0; i < 18; i++) {
			scene.idle(10);
			scene.world.createItemOnBeltLike(util.grid.at(2, 2, 2), Direction.UP, copper);
			if (i == 8) {
				scene.rotateCameraY(-20);
				scene.overlay.showControls(new InputWindowElement(filter.add(0, 0.125, 0), Pointing.DOWN).rightClick(),
					40);
				scene.overlay.showText(50)
					.text("Use the value panel to specify the extracted stack size")
					.attachKeyFrame()
					.pointAt(filter.add(0, 0, 0.125))
					.placeNearTarget();
			}
			if (i == 13)
				scene.world.showSection(lever, Direction.NORTH);
		}

		scene.world.toggleRedstonePower(lever.add(util.select.position(smarty)));
		scene.effects.indicateRedstone(util.grid.at(0, 3, 2));
		scene.overlay.showText(50)
			.text("Redstone power will prevent Smart Chutes from acting.")
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.pointAt(util.vector.blockSurface(util.grid.at(0, 2, 2), Direction.UP))
			.placeNearTarget();
		scene.idle(70);

		scene.world.toggleRedstonePower(lever.add(util.select.position(smarty)));
		scene.markAsFinished();
		for (int i = 0; i < 8; i++) {
			scene.idle(10);
			scene.world.createItemOnBeltLike(util.grid.at(2, 2, 2), Direction.UP, copper);
		}

	}

}
//文件scenes/CrafterScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import java.util.Collection;

import com.google.common.collect.ImmutableList;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlock;
import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.utility.Couple;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

public class CrafterScenes {

	public static void setup(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_crafter", "Setting up Mechanical Crafters");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> 1.5f * f);

		Selection redstone = util.select.fromTo(3, 1, 0, 3, 1, 1);
		Selection kinetics = util.select.fromTo(4, 1, 2, 4, 1, 5);
		BlockPos depotPos = util.grid.at(0, 1, 2);
		Selection crafters = util.select.fromTo(1, 1, 2, 3, 3, 2);

		scene.world.modifyBlocks(crafters, s -> s.setValue(MechanicalCrafterBlock.POINTING, Pointing.DOWN), false);
		scene.world.setKineticSpeed(crafters, 0);

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				scene.world.showSection(util.select.position(y == 1 ? x + 1 : 3 - x, y + 1, 2), Direction.DOWN);
				scene.idle(2);
			}
		}

		scene.overlay.showText(70)
			.text("An array of Mechanical Crafters can be used to automate any Crafting Recipe")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(80);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick()
				.withWrench(),
			40);
		scene.idle(7);
		scene.world.cycleBlockProperty(util.grid.at(2, 3, 2), MechanicalCrafterBlock.POINTING);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("Using a Wrench, the Crafters' paths can be arranged")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		BlockPos[] positions = new BlockPos[] { util.grid.at(3, 1, 2), util.grid.at(2, 1, 2), util.grid.at(1, 1, 2) };

		for (BlockPos pos : positions) {
			scene.overlay.showControls(
				new InputWindowElement(util.vector.blockSurface(pos, Direction.NORTH), Pointing.RIGHT).rightClick()
					.withWrench(),
				10);
			scene.idle(7);
			scene.world.cycleBlockProperty(pos, MechanicalCrafterBlock.POINTING);
			scene.idle(15);
		}

		scene.overlay.showText(100)
			.text("For a valid setup, all paths have to converge into one exit at any side")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.WEST)
				.add(0, 0, -.5f))
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		Collection<Couple<BlockPos>> couples =
			ImmutableList.of(Couple.create(util.grid.at(3, 3, 2), util.grid.at(3, 2, 2)),
				Couple.create(util.grid.at(3, 2, 2), util.grid.at(3, 1, 2)),
				Couple.create(util.grid.at(2, 3, 2), util.grid.at(1, 3, 2)),
				Couple.create(util.grid.at(3, 1, 2), util.grid.at(2, 1, 2)),
				Couple.create(util.grid.at(1, 3, 2), util.grid.at(1, 2, 2)),
				Couple.create(util.grid.at(2, 2, 2), util.grid.at(2, 1, 2)),
				Couple.create(util.grid.at(1, 2, 2), util.grid.at(1, 1, 2)),
				Couple.create(util.grid.at(2, 1, 2), util.grid.at(1, 1, 2)),
				Couple.create(util.grid.at(1, 1, 2), util.grid.at(0, 1, 2)));

		for (Couple<BlockPos> c : couples) {
			scene.idle(5);
			Vec3 p1 = util.vector.blockSurface(c.getFirst(), Direction.NORTH)
				.add(0, 0, -0.125);
			Vec3 p2 = util.vector.blockSurface(c.getSecond(), Direction.NORTH)
				.add(0, 0, -0.125);
			AABB point = new AABB(p1, p1);
			AABB line = new AABB(p1, p2);
			scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, p1, point, 2);
			scene.idle(1);
			scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, p1, line, 30);
		}

		scene.world.showSection(util.select.position(depotPos), Direction.EAST);
		scene.idle(20);
		scene.overlay.showText(60)
			.text("The outputs will be placed into the inventory at the exit")
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 2), Direction.NORTH))
			.placeNearTarget();
		scene.idle(70);

		scene.rotateCameraY(60);
		scene.idle(20);
		scene.world.showSection(kinetics, Direction.NORTH);
		scene.overlay.showText(60)
			.text("Mechanical Crafters require Rotational Force to operate")
			.pointAt(util.vector.blockSurface(util.grid.at(4, 1, 2), Direction.NORTH))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(8);
		scene.world.setKineticSpeed(crafters, -48);
		scene.world.multiplyKineticSpeed(util.select.position(3, 2, 2)
			.add(util.select.position(2, 3, 2))
			.add(util.select.position(1, 2, 2))
			.add(util.select.position(2, 1, 2)), -1);
		scene.idle(55);
		scene.rotateCameraY(-60);

		scene.idle(40);
		ItemStack planks = new ItemStack(Items.OAK_PLANKS);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(1, 3, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick()
				.withItem(planks),
			40);
		scene.idle(7);
		Class<MechanicalCrafterBlockEntity> type = MechanicalCrafterBlockEntity.class;
		scene.world.modifyBlockEntity(util.grid.at(1, 3, 2), type, mct -> mct.getInventory()
			.insertItem(0, planks.copy(), false));

		scene.idle(10);
		scene.overlay.showText(50)
			.text("Right-Click the front to insert Items manually")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 3, 2), Direction.NORTH))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		ItemStack redstoneDust = new ItemStack(Items.REDSTONE);
		ItemStack iron = new ItemStack(Items.IRON_INGOT);
		ItemStack cobble = new ItemStack(Items.COBBLESTONE);

		scene.world.setCraftingResult(util.grid.at(1, 1, 2), new ItemStack(Items.PISTON));

		scene.world.modifyBlockEntity(util.grid.at(2, 3, 2), type, mct -> mct.getInventory()
			.insertItem(0, planks.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(3, 3, 2), type, mct -> mct.getInventory()
			.insertItem(0, planks.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(3, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, cobble.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(2, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(1, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, cobble.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(1, 1, 2), type, mct -> mct.getInventory()
			.insertItem(0, cobble.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(2, 1, 2), type, mct -> mct.getInventory()
			.insertItem(0, redstoneDust.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(3, 1, 2), type, mct -> mct.getInventory()
			.insertItem(0, cobble.copy(), false));

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Once every slot of a path contains an Item, the crafting process will begin")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 3, 2), Direction.WEST))
			.placeNearTarget();
		scene.idle(180);

		scene.world.removeItemsFromBelt(depotPos);

		ItemStack stick = new ItemStack(Items.STICK);

		scene.world.setCraftingResult(util.grid.at(1, 1, 2), new ItemStack(Items.IRON_PICKAXE));

		scene.world.modifyBlockEntity(util.grid.at(1, 3, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(2);
		scene.world.modifyBlockEntity(util.grid.at(2, 3, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(2);
		scene.world.modifyBlockEntity(util.grid.at(3, 3, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(2);
		scene.world.modifyBlockEntity(util.grid.at(2, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, stick.copy(), false));
		scene.idle(2);
		scene.world.modifyBlockEntity(util.grid.at(2, 1, 2), type, mct -> mct.getInventory()
			.insertItem(0, stick.copy(), false));
		scene.world.showSection(redstone, Direction.SOUTH);
		scene.idle(10);

		scene.overlay.showText(90)
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.text("For recipes not fully occupying the crafter setup, the start can be forced using a Redstone Pulse")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.NORTH))
			.placeNearTarget();
		scene.idle(100);
		scene.effects.indicateRedstone(util.grid.at(3, 1, 0));
		scene.world.toggleRedstonePower(redstone);
		scene.idle(20);
		scene.world.toggleRedstonePower(redstone);
	}

	public static void connect(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_crafter_connect", "Connecting Inventories of Crafters");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 2; x++) {
				scene.world.showSection(util.select.position(y == 1 ? x + 1 : 2 - x, y + 1, 2), Direction.DOWN);
				scene.idle(2);
			}
		}

		Class<MechanicalCrafterBlockEntity> type = MechanicalCrafterBlockEntity.class;
		BlockPos depotPos = util.grid.at(0, 1, 2);
		Selection funnel = util.select.fromTo(4, 1, 5, 4, 1, 2)
			.add(util.select.fromTo(3, 2, 2, 3, 1, 2));
		Selection kinetics = util.select.position(3, 3, 2)
			.add(util.select.fromTo(3, 3, 3, 3, 1, 3));
		scene.idle(5);

		scene.world.showSection(kinetics, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(util.select.position(depotPos), Direction.EAST);
		scene.idle(10);
		scene.world.showSection(funnel, Direction.WEST);
		scene.rotateCameraY(60);
		ItemStack planks = new ItemStack(Items.OAK_PLANKS);
		scene.world.createItemOnBelt(util.grid.at(4, 1, 2), Direction.EAST, planks.copy());
		scene.idle(22);

		scene.world.modifyBlockEntity(util.grid.at(2, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, planks.copy(), false));
		scene.world.removeItemsFromBelt(util.grid.at(3, 1, 2));
		scene.world.flapFunnel(util.grid.at(3, 2, 2), false);

		scene.overlay.showSelectionWithText(util.select.position(2, 2, 2), 70)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH))
			.text("Items can be inserted to Crafters automatically");
		scene.idle(80);

		scene.rotateCameraY(-60 - 90 - 30);
		scene.idle(40);

		Vec3 v = util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.WEST);
		AABB bb = new AABB(v, v).inflate(.125f, .5, .5);
		v = v.add(0, 0, .5);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, new Object(), bb, 45);
		scene.overlay.showControls(new InputWindowElement(v, Pointing.LEFT).rightClick()
			.withWrench(), 40);
		scene.idle(7);
		scene.world.connectCrafterInvs(util.grid.at(2, 2, 2), util.grid.at(1, 2, 2));
		scene.idle(40);
		scene.overlay.showSelectionWithText(util.select.fromTo(2, 2, 2, 1, 2, 2), 70)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(v)
			.text("Using the Wrench at their backs, Mechanical Crafter inputs can be combined");
		scene.idle(80);
		scene.overlay.showControls(new InputWindowElement(v.add(0, 1, 0), Pointing.LEFT).rightClick()
			.withWrench(), 20);
		scene.idle(7);
		scene.world.connectCrafterInvs(util.grid.at(2, 3, 2), util.grid.at(1, 3, 2));
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(v.add(0, -1, 0), Pointing.LEFT).rightClick()
			.withWrench(), 20);
		scene.idle(7);
		scene.world.connectCrafterInvs(util.grid.at(2, 1, 2), util.grid.at(1, 1, 2));
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(v.add(.5, -.5, 0), Pointing.LEFT).rightClick()
			.withWrench(), 20);
		scene.idle(7);
		scene.world.connectCrafterInvs(util.grid.at(2, 1, 2), util.grid.at(2, 2, 2));
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(v.add(.5, .5, 0), Pointing.LEFT).rightClick()
			.withWrench(), 20);
		scene.idle(7);
		scene.world.connectCrafterInvs(util.grid.at(2, 2, 2), util.grid.at(2, 3, 2));
		scene.idle(20);

		scene.rotateCameraY(90 + 30);
		scene.idle(40);
		scene.overlay.showSelectionWithText(util.select.fromTo(1, 1, 2, 2, 3, 2), 70)
			.attachKeyFrame()
			.placeNearTarget()
			.text("All connected Crafters can now be accessed by the same input location");
		scene.idle(60);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.centerOf(util.grid.at(4, 2, 2)), Pointing.DOWN).withItem(planks), 40);
		scene.idle(7);
		scene.world.createItemOnBelt(util.grid.at(4, 1, 2), Direction.EAST,
			ItemHandlerHelper.copyStackWithSize(planks, 16));
		scene.idle(22);

		scene.world.removeItemsFromBelt(util.grid.at(3, 1, 2));
		BlockPos[] positions = new BlockPos[] { util.grid.at(2, 3, 2), util.grid.at(1, 3, 2), util.grid.at(1, 2, 2),
			util.grid.at(2, 1, 2), util.grid.at(1, 1, 2) };

		scene.world.setCraftingResult(util.grid.at(1, 1, 2), new ItemStack(Items.OAK_DOOR, 3));
		for (BlockPos pos : positions) {
			scene.world.modifyBlockEntity(pos, type, mct -> mct.getInventory()
				.insertItem(0, planks.copy(), false));
			scene.idle(1);
		}

	}

	public static void covers(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_crafter_covers", "Covering slots of Mechanical Crafters");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		scene.world.setBlock(util.grid.at(2, 2, 2), Blocks.AIR.defaultBlockState(), false);

		Selection kinetics = util.select.fromTo(3, 1, 2, 3, 1, 5);
		scene.world.setKineticSpeed(util.select.fromTo(1, 2, 2, 3, 1, 2), 0);

		scene.world.showSection(util.select.position(3, 2, 2), Direction.EAST);
		scene.idle(5);
		scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 2, 2), Direction.WEST);
		scene.idle(5);

		ItemStack iron = new ItemStack(Items.IRON_INGOT);

		Class<MechanicalCrafterBlockEntity> type = MechanicalCrafterBlockEntity.class;
		scene.world.modifyBlockEntity(util.grid.at(3, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(2, 1, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(5);
		scene.world.modifyBlockEntity(util.grid.at(1, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		scene.idle(5);

		Selection emptyCrafter = util.select.position(2, 2, 2);
		scene.overlay.showSelectionWithText(emptyCrafter, 90)
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.text("Some recipes will require additional Crafters to bridge gaps in the path")
			.placeNearTarget();
		scene.idle(70);
		scene.world.restoreBlocks(emptyCrafter);
		scene.world.setCraftingResult(util.grid.at(2, 2, 2), new ItemStack(Items.BUCKET));
		scene.world.showSection(emptyCrafter, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(2, 3, 2), Direction.DOWN);
		scene.world.showSection(kinetics, Direction.NORTH);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.fromTo(3, 1, 2, 1, 2, 2), -32);
		scene.world.setKineticSpeed(util.select.position(3, 1, 2)
			.add(emptyCrafter), 32);

		scene.idle(20);

		scene.overlay.showText(90)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH))
			.text("Using Slot Covers, Crafters can be set to act as an Empty Slot in the arrangement")
			.placeNearTarget();
		scene.idle(100);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH)
				.add(0.5, 0, 0), Pointing.RIGHT).withItem(AllItems.CRAFTER_SLOT_COVER.asStack())
					.rightClick(),
				50);
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(emptyCrafter, type, compound -> compound.putBoolean("Cover", true));
		scene.idle(130);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.WEST), Pointing.LEFT)
				.withItem(new ItemStack(Items.BUCKET)),
			40);
		scene.idle(50);
		scene.world.showSection(util.select.position(4, 2, 2), Direction.DOWN);

		scene.world.connectCrafterInvs(util.grid.at(3, 2, 2), util.grid.at(2, 2, 2));
		scene.idle(5);
		scene.world.connectCrafterInvs(util.grid.at(2, 1, 2), util.grid.at(2, 2, 2));
		scene.idle(5);
		scene.world.connectCrafterInvs(util.grid.at(1, 2, 2), util.grid.at(2, 2, 2));
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.fromTo(3, 2, 2, 1, 2, 2)
			.add(util.select.position(2, 1, 2)), 80)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH))
			.text("Shared Inputs created with the Wrench at the back can also reach across covered Crafters")
			.placeNearTarget();
		scene.idle(60);

		ElementLink<EntityElement> ingot =
			scene.world.createItemEntity(util.vector.centerOf(4, 4, 2), util.vector.of(0, 0.2, 0), iron);
		scene.idle(17);
		scene.world.modifyEntity(ingot, Entity::discard);
		scene.world.modifyBlockEntity(util.grid.at(3, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		ingot = scene.world.createItemEntity(util.vector.centerOf(4, 4, 2), util.vector.of(0, 0.2, 0), iron);
		scene.idle(17);
		scene.world.modifyEntity(ingot, Entity::discard);
		scene.world.modifyBlockEntity(util.grid.at(2, 1, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));
		ingot = scene.world.createItemEntity(util.vector.centerOf(4, 4, 2), util.vector.of(0, 0.2, 0), iron);
		scene.idle(17);
		scene.world.modifyEntity(ingot, Entity::discard);
		scene.world.modifyBlockEntity(util.grid.at(1, 2, 2), type, mct -> mct.getInventory()
			.insertItem(0, iron.copy(), false));

	}

}
//文件scenes/DeployerScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.equipment.sandPaper.SandPaperItem;
import com.simibubi.create.content.kinetics.deployer.DeployerBlock;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class DeployerScenes {

	public static void filter(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("deployer", "Using the Deployer");
		scene.configureBasePlate(0, 0, 5);

		BlockPos potPosition = util.grid.at(1, 1, 2);
		BlockPos deployerPos = util.grid.at(3, 1, 2);
		Selection deployerSelection = util.select.position(deployerPos);

		scene.world.setBlock(potPosition, Blocks.AIR.defaultBlockState(), false);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.position(1, 1, 2)), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 1, 5), Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(deployerSelection, Direction.SOUTH);
		scene.idle(10);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.topOf(deployerPos))
			.text("Given Rotational Force, a Deployer can imitate player interactions");
		scene.world.moveDeployer(deployerPos, 1, 25);
		scene.idle(26);
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.idle(44);

		scene.overlay.showSelectionWithText(util.select.position(deployerPos.west(2)), 60)
			.text("It will always interact with the position 2 blocks in front of itself")
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.attachKeyFrame();
		scene.world.moveDeployer(deployerPos, 1, 25);
		scene.idle(26);
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.idle(20);
		scene.world.showSection(util.select.fromTo(2, 1, 3, 2, 1, 1), Direction.DOWN);
		scene.idle(24);

		scene.overlay.showText(50)
			.pointAt(util.vector.topOf(deployerPos.west()))
			.text("Blocks directly in front will not obstruct it")
			.placeNearTarget();
		scene.world.moveDeployer(deployerPos, 1, 25);
		scene.idle(26);
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.idle(34);
		scene.world.hideSection(util.select.fromTo(2, 1, 3, 2, 1, 1), Direction.UP);
		scene.idle(20);

		String[] actions =
			new String[] { "Place Blocks,", "Use Items,", "Activate Blocks,", "Harvest blocks", "and Attack Mobs" };

		scene.overlay.showText(80)
			.attachKeyFrame()
			.independent(40)
			.placeNearTarget()
			.text("Deployers can:");

		int y = 60;
		for (String s : actions) {
			scene.idle(15);
			scene.overlay.showText(50)
				.colored(PonderPalette.MEDIUM)
				.placeNearTarget()
				.independent(y)
				.text(s);
			y += 16;
		}
		scene.idle(50);

		ItemStack pot = new ItemStack(Items.FLOWER_POT);
		Vec3 frontVec = util.vector.blockSurface(deployerPos, Direction.WEST)
			.add(-.125, 0, 0);

		scene.overlay.showControls(new InputWindowElement(frontVec, Pointing.DOWN).rightClick()
			.withItem(pot), 40);
		scene.idle(7);
		Class<DeployerBlockEntity> teType = DeployerBlockEntity.class;
		scene.world.modifyBlockEntityNBT(deployerSelection, teType, nbt -> nbt.put("HeldItem", pot.serializeNBT()));
		scene.idle(10);

		scene.overlay.showText(40)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(frontVec)
			.text("Right-click the front to give it an Item to use");
		scene.idle(40);
		scene.world.moveDeployer(deployerPos, 1, 25);
		scene.idle(26);
		scene.world.restoreBlocks(util.select.position(potPosition));
		scene.world.modifyBlockEntityNBT(deployerSelection, teType,
			nbt -> nbt.put("HeldItem", ItemStack.EMPTY.serializeNBT()));
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.idle(20);

		scene.world.showSection(util.select.position(deployerPos.above()), Direction.DOWN);

		ItemStack tulip = new ItemStack(Items.RED_TULIP);
		Vec3 entitySpawn = util.vector.topOf(deployerPos.above(3));

		ElementLink<EntityElement> entity1 =
			scene.world.createItemEntity(entitySpawn, util.vector.of(0, 0.2, 0), tulip);
		scene.idle(17);
		scene.world.modifyEntity(entity1, Entity::discard);
		scene.world.modifyBlockEntityNBT(deployerSelection, teType, nbt -> nbt.put("HeldItem", tulip.serializeNBT()));
		scene.idle(10);
		scene.overlay.showText(40)
			.placeNearTarget()
			.pointAt(util.vector.of(3, 2.5, 3))
			.text("Items can also be inserted automatically");
		scene.idle(30);
		scene.world.moveDeployer(deployerPos, 1, 25);
		scene.idle(26);
		scene.world.setBlock(potPosition, Blocks.POTTED_RED_TULIP.defaultBlockState(), false);
		scene.world.modifyBlockEntityNBT(deployerSelection, teType,
			nbt -> nbt.put("HeldItem", ItemStack.EMPTY.serializeNBT()));
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.idle(25);
		scene.world.hideSection(util.select.position(potPosition), Direction.UP);
		scene.world.hideSection(util.select.position(deployerPos.above()), Direction.EAST);
		scene.idle(20);

		Vec3 filterSlot = util.vector.topOf(deployerPos)
			.add(2 / 16f, 0, 0);
		scene.overlay.showFilterSlotInput(filterSlot, Direction.UP, 80);
		scene.overlay.showText(40)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(filterSlot)
			.text("Deployers carry a filter slot");
		scene.idle(50);

		ItemStack shears = new ItemStack(Items.SHEARS);

		scene.overlay.showControls(new InputWindowElement(filterSlot, Pointing.DOWN).rightClick()
			.withItem(shears), 40);
		scene.idle(7);
		scene.world.setFilterData(deployerSelection, teType, shears);
		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(filterSlot)
			.text("When a filter is set, it activates only while holding a matching item");
		scene.idle(70);

		ElementLink<EntityElement> sheep = scene.world.createEntity(w -> {
			Sheep entity = EntityType.SHEEP.create(w);
			entity.setColor(DyeColor.PINK);
			Vec3 p = util.vector.topOf(util.grid.at(1, 0, 2));
			entity.setPos(p.x, p.y, p.z);
			entity.xo = p.x;
			entity.yo = p.y;
			entity.zo = p.z;
			WalkAnimationState animation = entity.walkAnimation;
			animation.update(-animation.position(), 1);
			animation.setSpeed(1);
			entity.yRotO = 210;
			entity.setYRot(210);
			entity.yHeadRotO = 210;
			entity.yHeadRot = 210;
			return entity;
		});
		scene.idle(20);
		scene.world.showSection(util.select.position(deployerPos.above()), Direction.WEST);
		entity1 = scene.world.createItemEntity(entitySpawn, util.vector.of(0, 0.2, 0), shears);
		scene.idle(17);
		scene.world.modifyEntity(entity1, Entity::discard);
		scene.world.modifyBlockEntityNBT(deployerSelection, teType, nbt -> nbt.put("HeldItem", shears.serializeNBT()));
		scene.idle(10);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.of(3, 2.5, 3))
			.text("Only items matching the filter can now be inserted...");

		scene.idle(70);
		scene.world.moveDeployer(deployerPos, 1, 25);
		scene.idle(26);
		scene.world.modifyEntity(sheep, e -> ((Sheep) e).setSheared(true));
		scene.effects.emitParticles(util.vector.topOf(deployerPos.west(2))
			.add(0, -.25, 0),
			Emitter.withinBlockSpace(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.PINK_WOOL.defaultBlockState()),
				util.vector.of(0, 0, 0)),
			25, 1);
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.world.showSection(util.select.position(deployerPos.north()), Direction.SOUTH);
		scene.idle(25);

		scene.overlay.showText(80)
			.placeNearTarget()
			.pointAt(util.vector.of(3.5, 1.25, 1.25))
			.text("...and only non-matching items will be extracted");
		scene.world.flapFunnel(deployerPos.north(), true);
		scene.world.createItemEntity(util.vector.centerOf(deployerPos.north())
			.subtract(0, .45, 0), util.vector.of(0, 0, -0.1), new ItemStack(Items.PINK_WOOL));

		scene.markAsFinished();
		for (int i = 0; i < 10; i++) {
			scene.idle(26);
			scene.world.moveDeployer(deployerPos, 1, 25);
			scene.idle(26);
			scene.world.moveDeployer(deployerPos, -1, 25);
			scene.idle(26);
		}
	}

	public static void modes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("deployer_modes", "Modes of the Deployer");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 1, 5), Direction.DOWN);
		scene.idle(10);

		BlockPos deployerPos = util.grid.at(3, 1, 2);
		Vec3 frontVec = util.vector.blockSurface(deployerPos, Direction.WEST)
			.add(-.125, 0, 0);
		Selection grassBlock = util.select.position(1, 1, 2);

		Selection deployerSelection = util.select.position(deployerPos);
		scene.world.showSection(deployerSelection, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(grassBlock, Direction.DOWN);
		scene.idle(10);

		ItemStack tool = new ItemStack(Items.GOLDEN_HOE);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(deployerPos), Pointing.DOWN).withItem(tool),
			30);
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(deployerSelection, DeployerBlockEntity.class,
			nbt -> nbt.put("HeldItem", tool.serializeNBT()));
		scene.idle(45);

		scene.world.setKineticSpeed(util.select.position(2, 0, 5), 16);
		scene.world.setKineticSpeed(util.select.layer(1), -32);
		scene.world.moveDeployer(deployerPos, 1, 25);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(1, 1, 2))
			.text("By default, a Deployer imitates a Right-click interaction");

		scene.idle(26);
		scene.world.replaceBlocks(grassBlock, Blocks.FARMLAND.defaultBlockState(), false);
		scene.world.moveDeployer(deployerPos, -1, 25);
		scene.idle(46);

		scene.overlay.showControls(new InputWindowElement(frontVec, Pointing.LEFT).rightClick()
			.withWrench(), 40);
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(deployerSelection, DeployerBlockEntity.class,
			nbt -> nbt.putString("Mode", "PUNCH"));
		scene.idle(45);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(1, 1, 2))
			.text("Using a Wrench, it can be set to imitate a Left-click instead");

		BlockPos breakingPos = deployerPos.west(2);
		for (int i = 0; i < 4; i++) {
			scene.idle(26);
			scene.world.moveDeployer(deployerPos, 1, 25);
			scene.idle(26);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			scene.world.moveDeployer(deployerPos, -1, 25);
			if (i == 3)
				scene.world.createItemEntity(util.vector.centerOf(breakingPos), util.vector.of(0, 0, 0),
					new ItemStack(Blocks.DIRT));
			scene.idle(26);

			if (i == 0)
				scene.markAsFinished();
		}
	}

	public static void processing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("deployer_processing", "Processing Items using Deployers");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		ElementLink<WorldSectionElement> depot =
			scene.world.showIndependentSection(util.select.position(2, 1, 1), Direction.DOWN);
		scene.world.moveSection(depot, util.vector.of(0, 0, 1), 0);
		scene.idle(10);

		Selection pressS = util.select.position(2, 3, 2);
		BlockPos pressPos = util.grid.at(2, 3, 2);
		BlockPos depotPos = util.grid.at(2, 1, 1);
		scene.world.setKineticSpeed(pressS, 0);
		scene.world.showSection(pressS, Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(util.select.fromTo(2, 1, 3, 2, 1, 5), Direction.NORTH);
		scene.idle(3);
		scene.world.showSection(util.select.position(2, 2, 3), Direction.SOUTH);
		scene.idle(3);
		scene.world.showSection(util.select.position(2, 3, 3), Direction.NORTH);
		scene.world.setKineticSpeed(pressS, -32);
		scene.effects.indicateSuccess(pressPos);
		scene.idle(10);

		ItemStack tool = AllItems.SAND_PAPER.asStack();
		scene.overlay.showControls(new InputWindowElement(util.vector.blockSurface(pressPos.below(), Direction.EAST)
			.add(0, 0.15, 0), Pointing.RIGHT).withItem(tool), 30);
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(pressS, DeployerBlockEntity.class,
			nbt -> nbt.put("HeldItem", tool.serializeNBT()));
		scene.idle(25);

		Vec3 pressSide = util.vector.blockSurface(pressPos, Direction.WEST);
		scene.overlay.showText(60)
			.pointAt(pressSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("With a fitting held item, Deployers can process items provided beneath them");
		scene.idle(80);

		scene.overlay.showText(60)
			.pointAt(pressSide.subtract(0, 2, 0))
			.placeNearTarget()
			.text("The Input items can be dropped or placed on a Depot under the Deployer");
		scene.idle(50);
		ItemStack quartz = AllItems.ROSE_QUARTZ.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.NORTH, quartz);
		Vec3 depotCenter = util.vector.centerOf(depotPos.south());
		scene.overlay.showControls(new InputWindowElement(depotCenter, Pointing.UP).withItem(quartz), 30);
		scene.idle(10);

		Vec3 targetV = util.vector.centerOf(pressPos)
			.subtract(0, 1.65, 0);

		scene.world.moveDeployer(pressPos, 1, 30);
		scene.idle(30);
		scene.world.moveDeployer(pressPos, -1, 30);
		scene.debug.enqueueCallback(s -> SandPaperItem.spawnParticles(targetV, quartz, s.getWorld()));
		// particle
		scene.world.removeItemsFromBelt(depotPos);
		ItemStack polished = AllItems.POLISHED_ROSE_QUARTZ.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.UP, polished);
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(depotCenter, Pointing.UP).withItem(polished), 50);
		scene.idle(60);

		scene.world.hideIndependentSection(depot, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(0, 1, 3, 0, 2, 3), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 0, 2, 2), Direction.SOUTH);
		scene.idle(20);
		BlockPos beltPos = util.grid.at(0, 1, 2);
		scene.overlay.showText(40)
			.pointAt(util.vector.blockSurface(beltPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("When items are provided on a belt...");
		scene.idle(30);

		ElementLink<BeltItemElement> ingot = scene.world.createItemOnBelt(beltPos, Direction.SOUTH, quartz);
		scene.idle(15);
		ElementLink<BeltItemElement> ingot2 = scene.world.createItemOnBelt(beltPos, Direction.SOUTH, quartz);
		scene.idle(15);
		scene.world.stallBeltItem(ingot, true);
		scene.world.moveDeployer(pressPos, 1, 30);

		scene.overlay.showText(50)
			.pointAt(pressSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Deployer will hold and process them automatically");

		scene.idle(30);
		scene.world.moveDeployer(pressPos, -1, 30);
		scene.debug.enqueueCallback(s -> SandPaperItem.spawnParticles(targetV, quartz, s.getWorld()));
		scene.world.removeItemsFromBelt(pressPos.below(2));
		ingot = scene.world.createItemOnBelt(pressPos.below(2), Direction.UP, polished);
		scene.world.stallBeltItem(ingot, true);
		scene.idle(15);
		scene.world.stallBeltItem(ingot, false);
		scene.idle(15);
		scene.world.stallBeltItem(ingot2, true);
		scene.world.moveDeployer(pressPos, 1, 30);
		scene.idle(30);
		scene.world.moveDeployer(pressPos, -1, 30);
		scene.debug.enqueueCallback(s -> SandPaperItem.spawnParticles(targetV, quartz, s.getWorld()));
		scene.world.removeItemsFromBelt(pressPos.below(2));
		ingot2 = scene.world.createItemOnBelt(pressPos.below(2), Direction.UP, polished);
		scene.world.stallBeltItem(ingot2, true);
		scene.idle(15);
		scene.world.stallBeltItem(ingot2, false);
	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("deployer_redstone", "Controlling Deployers with Redstone");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 5, 3, 1, 3), Direction.DOWN);

		BlockPos deployerPos = util.grid.at(3, 1, 3);
		Selection redstone = util.select.fromTo(3, 1, 1, 3, 1, 2);
		BlockPos leverPos = util.grid.at(3, 1, 1);

		scene.world.toggleRedstonePower(redstone);

		scene.idle(26);
		scene.world.moveDeployer(deployerPos, 1, 30);
		scene.idle(31);
		scene.world.moveDeployer(deployerPos, -1, 30);
		scene.world.showSection(redstone, Direction.SOUTH);
		scene.idle(31);

		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(10);

		scene.overlay.showText(60)
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(deployerPos))
			.placeNearTarget()
			.text("When powered by Redstone, Deployers will not activate");
		scene.idle(70);

		scene.world.toggleRedstonePower(redstone);
		scene.idle(10);
		scene.world.moveDeployer(deployerPos, 1f, 30);
		scene.idle(10);

		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(21);

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(deployerPos))
			.placeNearTarget()
			.text("Before stopping, the Deployer will finish any started cycles");

		scene.world.moveDeployer(deployerPos, -1f, 30);
		scene.idle(70);

		scene.world.toggleRedstonePower(redstone);
		scene.idle(3);
		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(leverPos);
		scene.world.moveDeployer(deployerPos, 1, 30);
		scene.overlay.showText(100)
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(deployerPos))
			.placeNearTarget()
			.text("Thus, a negative pulse can be used to trigger exactly one activation cycle");
		scene.idle(31);
		scene.world.moveDeployer(deployerPos, -1, 30);
		scene.idle(40);

	}

	public static void contraption(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("deployer_contraption", "Using Deployers on Contraptions");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(.9f);
		Selection flowers = util.select.fromTo(4, 1, 1, 1, 1, 1);
		scene.world.replaceBlocks(flowers, Blocks.AIR.defaultBlockState(), false);

		Selection kinetics = util.select.fromTo(5, 1, 6, 5, 1, 3);
		BlockPos deployerPos = util.grid.at(4, 1, 3);
		Selection deployerSelection = util.select.position(deployerPos);

		scene.world.cycleBlockProperty(deployerPos, DeployerBlock.AXIS_ALONG_FIRST_COORDINATE);

		scene.world.showSection(util.select.layer(0)
			.add(flowers), Direction.UP);
		scene.idle(5);

		ElementLink<WorldSectionElement> pistonHead =
			scene.world.showIndependentSection(util.select.fromTo(5, 1, 2, 8, 1, 2), Direction.DOWN);
		scene.world.moveSection(pistonHead, util.vector.of(0, 0, 1), 0);
		scene.world.showSection(kinetics, Direction.DOWN);
		scene.idle(5);

		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(deployerSelection, Direction.DOWN);
		scene.idle(5);
		scene.world.glueBlockOnto(util.grid.at(4, 2, 3), Direction.DOWN, contraption);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(deployerPos, Direction.WEST))
			.text("Whenever Deployers are moved as part of an animated Contraption...");
		scene.idle(70);

		scene.world.setKineticSpeed(util.select.position(4, 0, 6), -8);
		scene.world.setKineticSpeed(kinetics, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-3, 0, 0), 100);
		scene.world.moveSection(contraption, util.vector.of(-3, 0, 0), 100);

		for (int x = 0; x < 4; x++) {
			scene.world.moveDeployer(deployerPos, 1, 9);
			scene.idle(10);
			scene.world.moveDeployer(deployerPos, -1, 9);
			scene.world.restoreBlocks(util.select.position(4 - x, 1, 1));
			scene.idle(18);
		}

		scene.overlay.showSelectionWithText(flowers, 90)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("They activate at each visited location, using items from inventories anywhere on the contraption");
		scene.idle(100);

		scene.world.hideSection(flowers, Direction.UP);
		scene.idle(15);
		scene.world.replaceBlocks(flowers, Blocks.AIR.defaultBlockState(), false);
		scene.world.showSection(flowers, Direction.UP);

		Vec3 filterSlot = util.vector.blockSurface(deployerPos.west(3), Direction.WEST)
			.add(0, 0, 2 / 16f);
		scene.overlay.showFilterSlotInput(filterSlot, Direction.WEST, 80);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(filterSlot)
			.text("The Filter slot can be used to specify which items to pull");
		scene.idle(70);

		ItemStack poppy = new ItemStack(Items.POPPY);
		scene.overlay.showControls(new InputWindowElement(filterSlot, Pointing.DOWN).withItem(poppy), 30);
		scene.idle(7);
		scene.world.setFilterData(deployerSelection, DeployerBlockEntity.class, poppy);
		scene.idle(25);

		scene.world.setKineticSpeed(util.select.position(4, 0, 6), 8);
		scene.world.setKineticSpeed(kinetics, -16);
		scene.world.moveSection(pistonHead, util.vector.of(3, 0, 0), 100);
		scene.world.moveSection(contraption, util.vector.of(3, 0, 0), 100);

		for (int x = 0; x < 4; x++) {
			scene.world.moveDeployer(deployerPos, 1, 9);
			scene.idle(10);
			scene.world.moveDeployer(deployerPos, -1, 9);
			scene.world.setBlock(util.grid.at(1 + x, 1, 1), Blocks.POPPY.defaultBlockState(), false);
			scene.idle(18);
		}

	}

}
//文件scenes/DetectorScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.content.redstone.smartObserver.SmartObserverBlockEntity;
import com.simibubi.create.content.redstone.thresholdSwitch.ThresholdSwitchBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class DetectorScenes {

	public static void smartObserver(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("smart_observer", "Advanced detection with Smart Observers");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		Selection chuteObserver = util.select.fromTo(0, 1, 4, 0, 2, 4);
		Selection chute = util.select.fromTo(1, 1, 4, 1, 3, 4);
		Selection pipe = util.select.fromTo(3, 1, 4, 3, 3, 4);
		Selection pipeObserver = util.select.fromTo(4, 1, 4, 4, 2, 4);
		Selection redstoneDust = util.select.fromTo(1, 1, 2, 0, 1, 2);
		Selection belt = util.select.fromTo(1, 1, 1, 3, 1, 1);
		Selection chest = util.select.position(2, 1, 0);
		Selection amethyst = util.select.position(3, 1, 0);
		Selection largeCog = util.select.position(5, 0, 2);
		Selection smallCogs = util.select.fromTo(3, 1, 2, 4, 1, 2);
		BlockPos observerPos = util.grid.at(2, 1, 2);
		BlockPos funnelPos = util.grid.at(3, 2, 1);
		Selection funnelChest = util.select.fromTo(4, 1, 1, 4, 2, 1);

		scene.world.showSection(util.select.position(observerPos), Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(60)
			.text("Smart Observers can be used to detect a variety of events")
			.pointAt(util.vector.blockSurface(observerPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(50);

		scene.world.showSection(redstoneDust, Direction.EAST);
		scene.idle(5);
		ElementLink<WorldSectionElement> chestLink = scene.world.showIndependentSection(chest, Direction.SOUTH);
		scene.world.moveSection(chestLink, util.vector.of(0, 0, 1), 0);
		scene.idle(15);

		ItemStack copperIngot = new ItemStack(Items.COPPER_INGOT);
		ItemStack amethystItem = new ItemStack(Blocks.AMETHYST_BLOCK);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(observerPos.north(), Direction.NORTH), Pointing.RIGHT)
				.withItem(copperIngot),
			40);
		scene.idle(7);
		scene.world.toggleRedstonePower(util.select.position(observerPos));
		scene.world.toggleRedstonePower(redstoneDust);
		scene.effects.indicateRedstone(observerPos);
		scene.idle(15);

		scene.overlay.showText(60)
			.text("It can detect items or fluids inside of generic containers")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(observerPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(65);

		scene.overlay.showCenteredScrollInput(observerPos, Direction.UP, 10);
		scene.idle(5);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(observerPos, Direction.UP), Pointing.DOWN).rightClick()
				.withItem(amethystItem),
			60);
		scene.idle(7);
		scene.world.setFilterData(util.select.position(observerPos), SmartObserverBlockEntity.class, amethystItem);
		scene.world.toggleRedstonePower(util.select.position(observerPos));
		scene.world.toggleRedstonePower(redstoneDust);
		scene.idle(25);

		scene.overlay.showText(60)
			.text("The filter slot can be used to look for specific contents only")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(observerPos, Direction.UP))
			.placeNearTarget();
		scene.idle(50);

		scene.world.hideIndependentSection(chestLink, Direction.EAST);
		scene.idle(10);
		ElementLink<WorldSectionElement> amethystLink = scene.world.showIndependentSection(amethyst, Direction.EAST);
		scene.world.moveSection(amethystLink, util.vector.of(-1, 0, 1), 0);
		scene.idle(15);
		scene.world.toggleRedstonePower(util.select.position(observerPos));
		scene.world.toggleRedstonePower(redstoneDust);
		scene.effects.indicateRedstone(observerPos);
		scene.idle(15);

		scene.overlay.showText(50)
			.text("It also activates when the block itself matches the filter")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(observerPos.north(), Direction.WEST))
			.placeNearTarget();

		scene.idle(45);
		scene.world.hideIndependentSection(amethystLink, Direction.EAST);
		scene.world.toggleRedstonePower(util.select.position(observerPos));
		scene.world.toggleRedstonePower(redstoneDust);
		scene.idle(15);
		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(5);
		scene.world.showSection(smallCogs, Direction.DOWN);
		scene.world.showSection(belt, Direction.SOUTH);
		scene.idle(15);
		scene.world.setFilterData(util.select.position(0, 2, 4), SmartObserverBlockEntity.class, copperIngot);
		scene.world.showSection(chuteObserver, Direction.DOWN);
		scene.idle(2);
		scene.world.setFilterData(util.select.position(4, 2, 4), SmartObserverBlockEntity.class,
			new ItemStack(Items.LAVA_BUCKET));
		scene.world.showSection(pipeObserver, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(chute, Direction.WEST);
		scene.idle(2);
		scene.world.showSection(pipe, Direction.EAST);
		scene.idle(10);

		scene.overlay.showText(60)
			.text("Additionally, smart observers can monitor belts, chutes and pipes")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(observerPos, Direction.UP))
			.placeNearTarget();
		scene.idle(60);

		scene.world.createItemOnBelt(util.grid.at(3, 1, 1), Direction.EAST, amethystItem);
		scene.idle(15);

		scene.world.toggleRedstonePower(util.select.position(observerPos));
		scene.world.toggleRedstonePower(redstoneDust);
		scene.effects.indicateRedstone(observerPos);
		scene.idle(13);

		scene.world.toggleRedstonePower(util.select.position(observerPos));
		scene.world.toggleRedstonePower(redstoneDust);
		scene.idle(25);

		scene.world.showSection(funnelChest, Direction.WEST);
		scene.idle(5);
		scene.world.showSection(util.select.position(funnelPos), Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> observerLink =
			scene.world.makeSectionIndependent(util.select.position(observerPos));
		scene.world.moveSection(observerLink, util.vector.of(1, 1, 0), 10);
		scene.world.hideSection(redstoneDust, Direction.EAST);
		scene.idle(20);

		scene.overlay.showText(60)
			.text("...and will emit a pulse, if an item enters or exits a funnel")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(observerPos.above()
				.east(), Direction.WEST))
			.placeNearTarget();
		scene.idle(60);

		for (int i = 0; i < 3; i++) {
			scene.world.createItemOnBelt(util.grid.at(3, 1, 1), Direction.EAST, amethystItem);

			scene.world.toggleRedstonePower(util.select.position(observerPos));
			scene.effects.indicateRedstone(observerPos.above()
				.east());
			scene.idle(5);

			scene.world.toggleRedstonePower(util.select.position(observerPos));
			scene.idle(25);
		}

	}

	public static void thresholdSwitch(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("threshold_switch", "Monitoring with the Threshold Switch");
		scene.configureBasePlate(0, 1, 5);

		Selection fluidTank = util.select.fromTo(1, 1, 5, 1, 3, 5);
		Selection pulley = util.select.fromTo(3, 2, 3, 2, 2, 3);
		BlockPos pulleyPos = util.grid.at(2, 2, 3);
		BlockPos switchPos = util.grid.at(1, 1, 3);
		Selection redstone = util.select.fromTo(1, 1, 2, 1, 1, 1);
		Selection chest = util.select.fromTo(3, 1, 3, 2, 1, 3);
		Selection belt = util.select.fromTo(3, 0, 0, 3, 0, 6);
		Selection cogs = util.select.fromTo(4, 0, 6, 5, 0, 6)
			.add(util.select.position(5, 0, 5));
		Selection inFunnel = util.select.position(3, 1, 2);
		Selection outFunnel = util.select.position(3, 1, 4);
		Selection baseStrip = util.select.fromTo(1, 0, 1, 1, 0, 5);
		Selection basePlate = util.select.fromTo(0, 0, 1, 2, 0, 5)
			.add(util.select.fromTo(4, 0, 5, 4, 0, 1));

		scene.world.showSection(basePlate, Direction.UP);
		ElementLink<WorldSectionElement> stripLink = scene.world.showIndependentSection(baseStrip, Direction.UP);
		scene.world.moveSection(stripLink, util.vector.of(2, 0, 0), 0);
		scene.idle(5);

		scene.world.showSection(util.select.position(switchPos), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(chest, Direction.WEST);
		scene.idle(10);
		scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
		scene.idle(5);

		scene.overlay.showText(60)
			.text("Threshold Switches monitor the fill level of containers")
			.pointAt(util.vector.blockSurface(switchPos, Direction.NORTH))
			.placeNearTarget();
		scene.idle(60);

		scene.world.hideIndependentSection(stripLink, Direction.DOWN);
		scene.idle(15);
		scene.world.showSection(cogs, Direction.WEST);
		scene.world.showSection(belt, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(inFunnel, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(redstone, Direction.SOUTH);
		ItemStack ironIngot = new ItemStack(Items.IRON_INGOT, 32);

		for (int i = 0; i < 5; i++) {
			scene.world.createItemOnBelt(util.grid.at(3, 0, 0), Direction.NORTH, ironIngot);
			scene.idle(10);
			scene.world.removeItemsFromBelt(util.grid.at(3, 0, 2));
			scene.world.flapFunnel(util.grid.at(3, 1, 2), false);

			if (i % 2 == 1)
				scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
		}

		scene.addLazyKeyframe();
		scene.world.createItemOnBelt(util.grid.at(3, 0, 0), Direction.NORTH, ironIngot);
		scene.world.removeItemsFromBelt(util.grid.at(3, 0, 2));
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 1 / 8f);
		scene.idle(10);

		Vec3 upper = util.vector.blockSurface(switchPos, Direction.NORTH)
			.add(0, 3 / 16f, 0);
		scene.overlay.showLine(PonderPalette.RED, upper.add(2 / 16f, 0, 0), upper.subtract(2 / 16f, 0, 0), 60);
		scene.overlay.showText(70)
			.text("When the inventory content exceeds the upper threshold...")
			.colored(PonderPalette.RED)
			.pointAt(upper.subtract(2 / 16f, 0, 0))
			.placeNearTarget();

		scene.idle(60);
		scene.world.removeItemsFromBelt(util.grid.at(3, 0, 2));
		scene.world.flapFunnel(util.grid.at(3, 1, 2), false);
		scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
		scene.effects.indicateRedstone(switchPos);
		scene.world.toggleRedstonePower(redstone);
		scene.idle(20);

		scene.overlay.showText(50)
			.text("...the switch will change its redstone output")
			.pointAt(util.vector.blockSurface(switchPos.north(), Direction.DOWN))
			.placeNearTarget();
		scene.idle(50);

		scene.world.showSection(outFunnel, Direction.DOWN);
		scene.world.toggleRedstonePower(outFunnel);
		scene.idle(15);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), 8f);
		for (int i = 0; i < 5; i++) {
			scene.idle(10);
			scene.world.createItemOnBelt(util.grid.at(3, 0, 4), Direction.NORTH, ironIngot);
			if (i % 3 == 1)
				scene.world.modifyBlock(switchPos,
					s -> s.setValue(ThresholdSwitchBlock.LEVEL, s.getValue(ThresholdSwitchBlock.LEVEL) - 1), false);
		}
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 1 / 8f);

		Vec3 lower = util.vector.blockSurface(switchPos, Direction.NORTH)
			.add(0, -3 / 16f, 0);
		scene.overlay.showLine(PonderPalette.GREEN, lower.add(2 / 16f, 0, 0), lower.subtract(2 / 16f, 0, 0), 60);
		scene.overlay.showText(70)
			.text("The signal stays until the lower threshold is reached")
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.pointAt(lower.subtract(2 / 16f, 0, 0))
			.placeNearTarget();
		scene.idle(30);

		for (int i = 0; i < 3; i++) {
			scene.idle(10);
			scene.world.createItemOnBelt(util.grid.at(3, 0, 4), Direction.NORTH, ironIngot);
			if (i % 3 == 2)
				scene.world.modifyBlock(switchPos,
					s -> s.setValue(ThresholdSwitchBlock.LEVEL, s.getValue(ThresholdSwitchBlock.LEVEL) - 1), false);
		}

		scene.world.toggleRedstonePower(redstone);
		scene.idle(40);

		scene.overlay.showText(90)
			.text("The redstone output can now be used to control item supply, keeping the buffer filled")
			.pointAt(util.vector.blockSurface(switchPos.north(), Direction.DOWN))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(100);

		scene.addKeyframe();
		scene.overlay.showLine(PonderPalette.GREEN, lower.add(2 / 16f, 0, 0), lower.subtract(2 / 16f, 0, 0), 105);
		scene.idle(5);
		scene.overlay.showLine(PonderPalette.RED, upper.add(2 / 16f, 0, 0), upper.subtract(2 / 16f, 0, 0), 100);
		scene.idle(15);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(switchPos, Direction.UP), Pointing.DOWN).rightClick(), 60);
		scene.idle(7);
		scene.overlay.showText(70)
			.text("The specific thresholds can be changed in the UI")
			.pointAt(upper.subtract(2 / 16f, 0, 0))
			.placeNearTarget();
		scene.idle(80);

		scene.overlay.showCenteredScrollInput(switchPos, Direction.UP, 70);
		scene.overlay.showText(70)
			.text("A filter can help to only count specific contents toward the total")
			.pointAt(util.vector.blockSurface(switchPos, Direction.UP))
			.attachKeyFrame()
			.placeNearTarget();

		scene.idle(80);
		scene.world.hideSection(belt, Direction.SOUTH);
		scene.world.hideSection(cogs, Direction.EAST);
		scene.idle(2);
		scene.world.hideSection(inFunnel, Direction.EAST);
		scene.idle(2);
		scene.world.hideSection(chest, Direction.EAST);
		scene.idle(2);
		scene.world.hideSection(outFunnel, Direction.EAST);
		scene.idle(9);
		stripLink = scene.world.showIndependentSection(baseStrip, Direction.UP);
		scene.world.moveSection(stripLink, util.vector.of(2, 0, 0), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> tankLink = scene.world.showIndependentSection(fluidTank, Direction.DOWN);
		scene.world.moveSection(tankLink, util.vector.of(1, 0, -2), 0);
		scene.idle(10);

		scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
		scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
		scene.idle(15);

		scene.overlay.showText(70)
			.text("Fluid buffers can be monitored in a similar fashion")
			.pointAt(util.vector.blockSurface(switchPos, Direction.NORTH))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(80);

		scene.world.hideIndependentSection(tankLink, Direction.SOUTH);
		scene.world.hideSection(redstone, Direction.NORTH);
		ElementLink<WorldSectionElement> switchLink =
			scene.world.makeSectionIndependent(util.select.position(switchPos));
		scene.idle(10);
		scene.world.moveSection(switchLink, util.vector.of(0, 1, 0), 15);
		scene.world.modifyBlock(switchPos, s -> s.setValue(ThresholdSwitchBlock.LEVEL, 0), false);
		scene.idle(5);
		scene.world.showSection(pulley, Direction.DOWN);
		scene.idle(15);
		ElementLink<WorldSectionElement> hole = scene.world.makeSectionIndependent(util.select.position(2, 0, 3));
		scene.world.hideIndependentSection(hole, Direction.DOWN);

		scene.overlay.showText(70)
			.text("...as well as, curiously, the length of an extended rope pulley")
			.pointAt(util.vector.blockSurface(switchPos.above(), Direction.NORTH))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(10);

		scene.world.setKineticSpeed(pulley, 32);
		scene.world.movePulley(pulleyPos, 15, 205);
		
		for (int i = 0; i < 4; i++) {
			scene.idle(5);
			scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
			scene.idle(45);
			if (i == 1)
				scene.markAsFinished();
		}
		
		scene.idle(5);
		scene.world.cycleBlockProperty(switchPos, ThresholdSwitchBlock.LEVEL);
		scene.world.setKineticSpeed(pulley, 0);

	}

}
//文件scenes/DisplayScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.equipment.clipboard.ClipboardOverrides;
import com.simibubi.create.content.equipment.clipboard.ClipboardOverrides.ClipboardType;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DisplayScenes {

	public static void link(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("display_link", "Setting up Display Links");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		BlockPos depotPos = util.grid.at(3, 1, 1);
		Selection depot = util.select.position(3, 1, 1);
		BlockPos linkPos = util.grid.at(2, 1, 1);
		Selection link = util.select.position(linkPos);
		BlockPos board = util.grid.at(3, 2, 3);
		Selection fullBoard = util.select.fromTo(3, 2, 3, 1, 1, 3);
		Selection largeCog = util.select.position(3, 0, 5);
		Selection smallCog = util.select.fromTo(4, 1, 5, 4, 1, 3);

		Selection cuckoo = util.select.position(3, 2, 1);
		Selection stresso = util.select.position(3, 3, 1);
		Selection content = util.select.fromTo(4, 4, 1, 3, 4, 1);
		Selection dirt = util.select.position(3, 5, 1);

		Selection lectern = util.select.position(2, 2, 4);
		Selection sign = util.select.position(2, 1, 4);
		Selection nixies = util.select.fromTo(3, 3, 4, 1, 3, 4);

		scene.idle(15);

		scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);

		scene.idle(10);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Display Links can be used to visualise dynamic information")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 2), Direction.WEST))
			.placeNearTarget();
		scene.idle(60);

		scene.world.hideSection(util.select.position(2, 1, 2), Direction.UP);
		scene.idle(5);
		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(smallCog, Direction.WEST);
		scene.idle(5);
		scene.world.showSection(fullBoard, Direction.NORTH);
		scene.idle(25);

		Vec3 target = util.vector.of(3.5, 2.75, 3.25);
		scene.overlay
			.showControls(new InputWindowElement(target, Pointing.RIGHT).withItem(AllBlocks.DISPLAY_LINK.asStack())
				.rightClick(), 60);
		scene.idle(6);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, link, new AABB(board).expandTowards(-2, -1, 0)
			.deflate(0, 0, 3 / 16f), 60);
		scene.idle(35);
		scene.overlay.showText(70)
			.text("First, right-click the target display...")
			.pointAt(target.add(-1, 0, 0))
			.colored(PonderPalette.OUTPUT)
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		scene.world.showSection(depot, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(link, Direction.EAST);
		scene.idle(20);
		scene.overlay.showSelectionWithText(depot, 70)
			.text("...then attach it to the block to read from")
			.pointAt(util.vector.centerOf(linkPos))
			.colored(PonderPalette.INPUT)
			.placeNearTarget();
		scene.idle(60);

		ItemStack item = AllItems.PROPELLER.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(linkPos), Pointing.DOWN).rightClick(), 60);
		scene.idle(20);
		scene.overlay.showText(80)
			.text("Open the Interface to select and configure what is sent")
			.pointAt(util.vector.centerOf(linkPos))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(80);
		scene.effects.indicateSuccess(linkPos);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(50);

		scene.world.removeItemsFromBelt(depotPos);
		item = AllItems.BLAZE_CAKE.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("The display will now receive information from the link")
			.pointAt(target.add(-2.45f, -.5f, 0))
			.attachKeyFrame()
			.placeNearTarget();

		scene.idle(30);
		scene.world.removeItemsFromBelt(depotPos);
		item = AllBlocks.DISPLAY_BOARD.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(50);

		scene.world.hideSection(depot, Direction.SOUTH);
		scene.idle(5);
		scene.world.setDisplayBoardText(board, 1, Components.immutableEmpty());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(5);
		ElementLink<WorldSectionElement> dirtElement = scene.world.showIndependentSection(dirt, Direction.SOUTH);
		scene.world.moveSection(dirtElement, util.vector.of(0, -4, 0), 0);

		scene.idle(25);
		scene.overlay.showSelectionWithText(depot, 50)
			.text("Not every block can act as a source")
			.pointAt(util.vector.topOf(depotPos))
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.placeNearTarget();
		scene.idle(60);
		scene.world.hideIndependentSection(dirtElement, Direction.SOUTH);
		scene.idle(10);

		ElementLink<WorldSectionElement> stressElement = scene.world.showIndependentSection(stresso, Direction.SOUTH);
		scene.world.moveSection(stressElement, util.vector.of(0, -2, 0), 0);
		scene.idle(10);
		scene.world.setDisplayBoardText(board, 1,
			Components.literal(1024 + " ").append(Lang.translateDirect("generic.unit.stress")));
		scene.world.flashDisplayLink(linkPos);
		scene.idle(40);
		scene.world.hideIndependentSection(stressElement, Direction.SOUTH);
		scene.idle(10);

		ElementLink<WorldSectionElement> chestElement = scene.world.showIndependentSection(content, Direction.SOUTH);
		scene.world.moveSection(chestElement, util.vector.of(0, -3, 0), 0);
		scene.idle(10);
		scene.world.setDisplayBoardText(board, 1,
			Components.literal(418 + " ").append(new ItemStack(Items.DEEPSLATE).getHoverName()));
		scene.world.setDisplayBoardText(board, 2, Components.literal(14 + " ").append(AllBlocks.COGWHEEL.asStack()
			.getHoverName()));
		scene.world.flashDisplayLink(linkPos);
		scene.idle(40);
		scene.world.hideIndependentSection(chestElement, Direction.SOUTH);
		scene.idle(10);

		scene.overlay.showText(90)
			.text("Each compatible block provides unique information")
			.pointAt(util.vector.topOf(depotPos))
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.placeNearTarget();

		ElementLink<WorldSectionElement> cuckooElement = scene.world.showIndependentSection(cuckoo, Direction.SOUTH);
		scene.world.moveSection(cuckooElement, util.vector.of(0, -1, 0), 0);
		scene.idle(10);
		scene.world.setDisplayBoardText(board, 1,
			Components.literal("6:00 ").append(Lang.translateDirect("generic.daytime.pm")));
		scene.world.setDisplayBoardText(board, 2, Components.immutableEmpty());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(90);

		scene.world.hideSection(fullBoard, Direction.SOUTH);
		scene.world.hideSection(largeCog, Direction.DOWN);
		scene.world.hideSection(smallCog, Direction.EAST);
		scene.idle(10);

		ElementLink<WorldSectionElement> signElement = scene.world.showIndependentSection(sign, Direction.SOUTH);
		scene.world.moveSection(signElement, util.vector.of(0, 0, -1), 0);
		scene.idle(10);
		scene.world.flashDisplayLink(linkPos);
		scene.idle(5);
		scene.world.hideIndependentSection(signElement, Direction.SOUTH);
		scene.idle(10);

		ElementLink<WorldSectionElement> lecternElement = scene.world.showIndependentSection(lectern, Direction.SOUTH);
		scene.world.moveSection(lecternElement, util.vector.of(0, -1, -1), 0);
		scene.idle(10);
		scene.world.flashDisplayLink(linkPos);
		scene.idle(5);
		scene.world.hideIndependentSection(lecternElement, Direction.SOUTH);
		scene.idle(10);

		scene.overlay.showText(90)
			.text("The Display Link can work with several different displays")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 3), Direction.WEST))
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.placeNearTarget();

		ElementLink<WorldSectionElement> nixieElement = scene.world.showIndependentSection(nixies, Direction.SOUTH);
		scene.world.moveSection(nixieElement, util.vector.of(0, -2, -1), 0);
		scene.idle(10);
		scene.world.flashDisplayLink(linkPos);
		scene.idle(60);
	}

	public static void board(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("display_board", "Using Display Boards");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		Selection largeCog = util.select.position(5, 0, 1);
		Selection cogs = util.select.fromTo(4, 1, 1, 4, 1, 3);
		BlockPos depotPos = util.grid.at(3, 1, 1);
		Selection depot = util.select.position(3, 1, 1);
		BlockPos linkPos = util.grid.at(2, 1, 1);
		Selection link = util.select.position(linkPos);
		BlockPos board = util.grid.at(3, 2, 3);
		Selection fullBoard = util.select.fromTo(3, 2, 3, 1, 1, 3);

		scene.world.setKineticSpeed(fullBoard, 0);
		scene.idle(15);

		for (int y = 1; y <= 2; y++) {
			for (int x = 3; x >= 1; x--) {
				scene.world.showSection(util.select.position(x, y, 3), Direction.DOWN);
				scene.idle(2);
			}
			scene.idle(2);
		}

		scene.idle(10);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Display Boards are a scalable alternative to the sign")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 3), Direction.WEST))
			.placeNearTarget();
		scene.idle(80);

		scene.rotateCameraY(60);
		scene.idle(20);
		scene.world.showSection(cogs, Direction.DOWN);
		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(10);
		scene.world.setKineticSpeed(fullBoard, 32);
		scene.world.multiplyKineticSpeed(util.select.position(3, 1, 3), -1);
		scene.world.multiplyKineticSpeed(util.select.position(2, 2, 3), -1);
		scene.world.multiplyKineticSpeed(util.select.position(1, 1, 3), -1);

		scene.overlay.showText(50)
			.text("They require Rotational Force to operate")
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.EAST))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(40);
		scene.rotateCameraY(-60);
		scene.idle(20);

		Vec3 target = util.vector.of(3.95, 2.75, 3.25);
		ItemStack clipboard = AllBlocks.CLIPBOARD.asStack();
		ClipboardOverrides.switchTo(ClipboardType.WRITTEN, clipboard);
		scene.overlay.showControls(new InputWindowElement(target, Pointing.RIGHT).withItem(clipboard)
			.rightClick(), 40);
		scene.idle(6);
		scene.world.setDisplayBoardText(board, 0, Components.literal("Create"));
		scene.idle(25);

		scene.overlay.showText(50)
			.text("Static text can be applied using written Clipboards")
			.pointAt(target.add(-2, 0, 0))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(80);
		
		scene.world.showSection(depot, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(link, Direction.EAST);
		scene.idle(15);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, depot, new AABB(linkPos).contract(-.5f, 0, 0), 60);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, link, new AABB(board).expandTowards(-2, -1, 0)
			.deflate(0, 0, 3 / 16f), 60);
		scene.idle(20);

		scene.overlay.showText(70)
			.text("And dynamic text through the use of Display Links")
			.pointAt(target.add(-2, 0, 0))
			.attachKeyFrame()
			.colored(PonderPalette.OUTPUT)
			.placeNearTarget();
		scene.idle(50);

		ItemStack item = AllItems.PROPELLER.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(50);

		scene.world.removeItemsFromBelt(depotPos);
		item = AllItems.BLAZE_CAKE.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(50);

		scene.world.removeItemsFromBelt(depotPos);
		item = AllBlocks.DISPLAY_BOARD.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());
		scene.world.flashDisplayLink(linkPos);
		scene.idle(50);

		scene.overlay
			.showControls(new InputWindowElement(target, Pointing.RIGHT).withItem(new ItemStack(Items.PINK_DYE))
				.rightClick(), 40);
		scene.idle(6);
		scene.world.dyeDisplayBoard(board, 0, DyeColor.PINK);
		scene.idle(25);

		scene.overlay.showText(70)
			.text("Dyes can be applied to individual lines of the board")
			.pointAt(target.add(-2, 0, 0))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(25);

		scene.overlay.showControls(
			new InputWindowElement(target.add(0, -.5f, 0), Pointing.RIGHT).withItem(new ItemStack(Items.LIME_DYE))
				.rightClick(),
			40);
		scene.idle(6);
		scene.world.dyeDisplayBoard(board, 1, DyeColor.LIME);
		scene.idle(55);

		scene.overlay.showControls(new InputWindowElement(target, Pointing.RIGHT).rightClick(), 40);
		scene.idle(6);
		scene.world.setDisplayBoardText(board, 0, Components.immutableEmpty());
		scene.idle(25);

		scene.overlay.showText(70)
			.text("Lines can be reset by clicking them with an empty hand")
			.pointAt(target.add(-2, 0, 0))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(40);

	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("display_link_redstone", "Redstone Control");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		BlockPos depotPos = util.grid.at(3, 1, 1);
		Selection depot = util.select.position(3, 1, 1);
		BlockPos linkPos = util.grid.at(2, 1, 1);
		Selection link = util.select.position(linkPos);
		BlockPos board = util.grid.at(3, 2, 3);
		Selection fullBoard = util.select.fromTo(3, 2, 3, 1, 1, 3);
		Selection largeCog = util.select.position(3, 0, 5);
		Selection smallCog = util.select.fromTo(4, 1, 5, 4, 1, 3);
		Selection redstone = util.select.fromTo(1, 1, 1, 0, 1, 1);
		BlockPos leverPos = util.grid.at(0, 1, 1);

		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(smallCog, Direction.WEST);
		scene.idle(5);
		scene.world.showSection(fullBoard, Direction.NORTH);
		scene.idle(25);

		Vec3 target = util.vector.of(3.5, 2.75, 3.25);
		scene.world.showSection(depot, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(link, Direction.EAST);
		scene.idle(10);
		scene.world.flashDisplayLink(linkPos);
		scene.world.setDisplayBoardText(board, 1, new ItemStack(Items.CALCITE).getHoverName());
		scene.idle(10);
		scene.world.showSection(redstone, Direction.EAST);
		scene.idle(20);
		scene.world.toggleRedstonePower(redstone);
		scene.world.toggleRedstonePower(link);
		scene.effects.indicateRedstone(leverPos);

		scene.idle(20);
		scene.overlay.showText(80)
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(linkPos))
			.placeNearTarget()
			.text("When powered by Redstone, Display Links stop sending updates");

		scene.idle(50);
		scene.world.removeItemsFromBelt(depotPos);
		ItemStack item = new ItemStack(Items.AMETHYST_BLOCK);
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.idle(20);

		scene.idle(30);
		scene.world.removeItemsFromBelt(depotPos);
		item = new ItemStack(Items.GOLD_BLOCK);
		scene.world.createItemOnBeltLike(depotPos, Direction.SOUTH, item);
		scene.idle(50);

		scene.world.toggleRedstonePower(redstone);
		scene.world.toggleRedstonePower(link);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(1);
		scene.world.flashDisplayLink(linkPos);
		scene.world.setDisplayBoardText(board, 1, item.getHoverName());

		scene.idle(15);
		scene.overlay.showText(100)
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.pointAt(target.add(-2.45, -0.5, 0))
			.placeNearTarget()
			.text("Once unpowered, the Timer is reset and new info is sent immediately");
		scene.idle(100);

		scene.world.hideSection(depot, Direction.SOUTH);
		scene.world.setBlock(util.grid.at(4, 1, 0), Blocks.REDSTONE_BLOCK.defaultBlockState(), false);
		scene.idle(10);
		ElementLink<WorldSectionElement> redstoneBlock =
			scene.world.showIndependentSection(util.select.position(4, 1, 0), Direction.SOUTH);
		scene.world.moveSection(redstoneBlock, util.vector.of(-1, 0, 1), 0);
		scene.idle(10);
		scene.world.flashDisplayLink(linkPos);
		scene.world.setDisplayBoardText(board, 1, Components.immutableEmpty());
		scene.idle(25);

		scene.overlay.showSelectionWithText(depot, 80)
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(linkPos))
			.placeNearTarget()
			.text("Signals emitted from the source do not affect the Link");
		scene.idle(70);

	}

}
//文件scenes/EjectorScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.logistics.depot.EjectorBlockEntity;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.NBTHelper;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

public class EjectorScenes {

	public static void ejector(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("weighted_ejector", "Using Weighted Ejectors");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		BlockPos ejectorPos = util.grid.at(4, 1, 2);
		Selection ejectorS = util.select.position(ejectorPos);
		BlockPos targetPos = util.grid.at(0, 1, 2);
		Selection targetS = util.select.position(targetPos);

		scene.world.setBlock(targetPos, AllBlocks.ANDESITE_CASING.getDefaultState(), false);
		scene.idle(5);
		scene.world.showSection(targetS, Direction.DOWN);

		scene.idle(10);
		ItemStack asStack = AllBlocks.WEIGHTED_EJECTOR.asStack();
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(targetPos), Pointing.DOWN).rightClick()
			.whileSneaking()
			.withItem(asStack), 50);
		scene.idle(7);
		Object slot = new Object();
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, slot, new AABB(targetPos), 160);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.colored(PonderPalette.OUTPUT)
			.text("Sneak and Right-Click holding an Ejector to select its target location")
			.pointAt(util.vector.blockSurface(targetPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(80);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(ejectorPos), Pointing.DOWN).rightClick()
			.withItem(asStack), 50);
		scene.idle(7);
		scene.world.setKineticSpeed(ejectorS, 0);
		scene.world.modifyBlockEntityNBT(ejectorS, EjectorBlockEntity.class, nbt -> {
			NBTHelper.writeEnum(nbt, "State", EjectorBlockEntity.State.RETRACTING);
			nbt.putFloat("ForceAngle", 1);
		});
		scene.world.showSection(ejectorS, Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(60)
			.colored(PonderPalette.OUTPUT)
			.text("The placed ejector will now launch objects to the marked location")
			.pointAt(util.vector.blockSurface(ejectorPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(70);

		slot = new Object();
		AABB bb = new AABB(ejectorPos.west());
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, slot, bb, 20);
		scene.idle(10);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, slot, bb.expandTowards(-15, 15, 0), 100);
		scene.idle(10);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("A valid target can be at any height or distance within range")
			.pointAt(util.vector.blockSurface(targetPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(70);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, new Object(), bb.move(-2, 0, -1), 60);
		scene.idle(10);
		scene.overlay.showText(50)
			.colored(PonderPalette.RED)
			.text("They cannot however be off to a side")
			.pointAt(util.vector.blockSurface(targetPos.north()
				.east(), Direction.WEST))
			.placeNearTarget();
		scene.idle(70);
		scene.overlay.showSelectionWithText(util.select.position(ejectorPos.west()), 70)
			.colored(PonderPalette.OUTPUT)
			.text("If no valid Target was selected, it will simply target the block directly in front")
			.placeNearTarget();
		scene.idle(80);

		scene.world.showSection(util.select.position(3, 0, 5), Direction.UP);
		scene.world.showSection(util.select.fromTo(4, 1, 5, 4, 1, 3), Direction.DOWN);
		scene.idle(12);
		scene.world.setKineticSpeed(ejectorS, 32);
		scene.idle(10);
		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("Supply Rotational Force in order to charge it up")
			.pointAt(util.vector.topOf(4, 1, 3))
			.placeNearTarget();
		scene.idle(60);

		ItemStack copperBlock = new ItemStack(Items.COPPER_BLOCK);
		ItemStack copperIngot = new ItemStack(Items.COPPER_INGOT);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(ejectorPos)
			.add(0.5, 0, 0), Pointing.RIGHT).withItem(copperBlock), 30);
		scene.idle(7);
		scene.world.createItemOnBeltLike(ejectorPos, Direction.NORTH, copperBlock);
		scene.idle(20);
		scene.overlay.showText(50)
			.text("Items placed on the ejector cause it to trigger")
			.pointAt(util.vector.topOf(ejectorPos))
			.placeNearTarget();
		scene.idle(60);

		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.hideSection(targetS, Direction.SOUTH);
		scene.idle(15);
		scene.world.restoreBlocks(targetS);
		scene.world.showSection(targetS, Direction.SOUTH);
		scene.idle(10);
		scene.world.createItemOnBeltLike(targetPos, Direction.SOUTH, copperIngot);
		scene.idle(20);
		scene.world.createItemOnBeltLike(ejectorPos, Direction.SOUTH, copperBlock);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("If Inventories are targeted, the ejector will wait until there is space")
			.pointAt(util.vector.topOf(targetPos))
			.placeNearTarget();
		scene.idle(70);
		scene.effects.indicateSuccess(targetPos);
		scene.world.removeItemsFromBelt(targetPos);
		scene.idle(40);
		scene.world.hideSection(targetS, Direction.NORTH);
		scene.idle(15);
		scene.world.setBlock(targetPos, AllBlocks.ANDESITE_CASING.getDefaultState(), false);
		scene.world.showSection(targetS, Direction.NORTH);

		Vec3 input = util.vector.blockSurface(ejectorPos, Direction.WEST)
			.add(0, -2 / 16f, 0);
		Vec3 topOfSlot = input.add(0, 2 / 16f, 0);
		scene.overlay.showControls(new InputWindowElement(topOfSlot, Pointing.DOWN).rightClick(), 60);
		scene.overlay.showFilterSlotInput(input, Direction.WEST, 80);
		scene.idle(10);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Using the value panel, a required Stack Size can be configured")
			.pointAt(input.add(0, 0, 0.125))
			.placeNearTarget();
		scene.world.modifyBlockEntityNBT(ejectorS, EjectorBlockEntity.class, nbt -> {
			nbt.putInt("ScrollValue", 10);
		});
		scene.idle(90);

		scene.world.showSection(util.select.fromTo(5, 1, 0, 4, 1, 1), Direction.DOWN);
		scene.world.showSection(util.select.position(5, 0, 1), Direction.UP);
		scene.idle(15);

		BlockPos beltPos = util.grid.at(4, 1, 0);
		scene.world.createItemOnBeltLike(beltPos, Direction.UP, copperBlock);
		scene.overlay.showText(100)
			.text("It is now limited to this stack size, and only activates when its held stack reaches this amount")
			.pointAt(util.vector.topOf(ejectorPos))
			.placeNearTarget();
		for (int i = 0; i < 4; i++) {
			scene.idle(20);
			scene.world.createItemOnBeltLike(beltPos, Direction.UP, copperBlock);
		}
		scene.idle(20);
		scene.world.createItemOnBeltLike(beltPos, Direction.UP, ItemHandlerHelper.copyStackWithSize(copperBlock, 15));
		scene.idle(80);

		scene.world.hideSection(util.select.fromTo(5, 1, 0, 4, 1, 1), Direction.UP);
		scene.world.hideSection(util.select.position(5, 0, 1), Direction.DOWN);
		scene.idle(30);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);

		scene.addKeyframe();
		ElementLink<ParrotElement> birb = scene.special.createBirb(util.vector.topOf(ejectorPos)
			.add(0, -3 / 16f, 0), ParrotElement.FlappyPose::new);
		scene.idle(15);
		scene.world.modifyBlockEntity(ejectorPos, EjectorBlockEntity.class, ejector -> ejector.activateDeferred());
		scene.special.moveParrot(birb, util.vector.of(-2, 3, 0), 5);
		scene.special.rotateParrot(birb, 0, 360 * 2, 0, 21);
		scene.idle(5);
		scene.special.moveParrot(birb, util.vector.of(-1, 0, 0), 3);
		scene.idle(3);
		scene.special.moveParrot(birb, util.vector.of(-0.75, -1, 0), 6);
		scene.idle(6);
		scene.special.moveParrot(birb, util.vector.of(-0.25, -2 + 3 / 16f, 0), 12);
		scene.idle(15);
		scene.special.changeBirbPose(birb, ParrotElement.FaceCursorPose::new);
		scene.overlay.showText(80)
			.text("Mobs and Players will always trigger an Ejector when stepping on it")
			.pointAt(util.vector.topOf(targetPos))
			.placeNearTarget();
		scene.idle(50);

	}

	public static void splitY(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("weighted_ejector_tunnel", "Splitting item stacks using Weighted Ejectors");
		Selection coverbelt = util.select.fromTo(3, 1, 1, 2, 1, 0);
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 5, 0, 1, 3), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(2, 2, 3), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(2, 1, 2), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 3, 1, 2), Direction.SOUTH);
		scene.idle(10);

		BlockPos ejectorPos = util.grid.at(2, 1, 2);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Combined with Brass Tunnels, Ejectors can split item stacks by specific amounts")
			.pointAt(util.vector.topOf(ejectorPos))
			.placeNearTarget();
		scene.idle(90);

		BlockPos tunnel = util.grid.at(2, 2, 3);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(tunnel), Pointing.DOWN).showing(AllIcons.I_TUNNEL_PREFER_NEAREST),
			80);
		scene.idle(10);
		scene.overlay.showCenteredScrollInput(tunnel, Direction.UP, 100);
		scene.idle(10);
		scene.overlay.showText(100)
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("First, configure the Brass Tunnel to 'Prefer Nearest', in order to prioritize its side output")
			.pointAt(util.vector.topOf(tunnel))
			.placeNearTarget();
		scene.idle(110);

		Vec3 input = util.vector.blockSurface(ejectorPos, Direction.NORTH)
			.subtract(0, 2 / 16f, 0);
		Vec3 topOfSlot = input.add(0, 2 / 16f, 0);
		scene.overlay.showFilterSlotInput(input, Direction.NORTH, 80);
		scene.idle(10);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("The Stack Size set on the Ejector now determines the amount to be split off")
			.pointAt(topOfSlot)
			.placeNearTarget();
		scene.world.modifyBlockEntityNBT(util.select.position(2, 1, 2), EjectorBlockEntity.class, nbt -> {
			nbt.putInt("ScrollValue", 10);
		});
		scene.idle(90);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(4, 1, 3)), Pointing.DOWN)
			.withItem(new ItemStack(Items.COPPER_INGOT)), 20);
		scene.world.showSection(coverbelt, Direction.SOUTH);
		
		scene.idle(7);
		scene.world.createItemOnBelt(util.grid.at(4, 1, 3), Direction.UP, new ItemStack(Items.COPPER_INGOT, 64));
		scene.idle(40);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 1 / 16f);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("While a new stack of the configured size exits the side output...")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 1), Direction.WEST))
			.placeNearTarget();
		scene.idle(90);
		scene.overlay.showText(80)
			.text("...the remainder will continue on its path")
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 3), Direction.UP))
			.placeNearTarget();
		scene.idle(90);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 16f);
	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("weighted_ejector_redstone", "Controlling Weighted Ejectors with Redstone");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 3, 4, 1, 5), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(0, 1, 2, 0, 2, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(4, 1, 2), Direction.SOUTH);
		scene.idle(5);
		Selection redstone = util.select.fromTo(3, 1, 2, 2, 1, 2);
		scene.world.showSection(redstone, Direction.EAST);

		BlockPos ejectorPos = util.grid.at(4, 1, 2);
		Vec3 topOf = util.vector.topOf(ejectorPos.above(2));
		ItemStack copper = new ItemStack(Items.COPPER_INGOT);

		for (int i = 0; i < 3; i++) {
			scene.world.createItemEntity(topOf, util.vector.of(0, 0.1, 0), copper);
			scene.idle(12);
			scene.world.modifyEntities(ItemEntity.class, Entity::discard);
			scene.world.createItemOnBeltLike(ejectorPos, Direction.UP, copper);
			scene.idle(20);
			if (i == 1) {
				scene.world.toggleRedstonePower(redstone);
				scene.effects.indicateRedstone(util.grid.at(2, 1, 2));
				scene.world.modifyBlockEntityNBT(util.select.position(4, 1, 2), EjectorBlockEntity.class,
					nbt -> nbt.putBoolean("Powered", true));
			}
		}

		scene.idle(10);
		scene.overlay.showText(60)
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(ejectorPos))
			.placeNearTarget()
			.text("When powered by Redstone, Ejectors will not activate");
		scene.idle(70);

		scene.world.toggleRedstonePower(redstone);
		scene.idle(2);
		scene.world.modifyBlockEntityNBT(util.select.position(4, 1, 2), EjectorBlockEntity.class,
			nbt -> nbt.putBoolean("Powered", false));
		scene.idle(5);
		scene.world.hideSection(redstone, Direction.WEST);
		scene.idle(30);
		ElementLink<WorldSectionElement> observer =
			scene.world.showIndependentSection(util.select.position(4, 1, 1), Direction.SOUTH);
		scene.world.moveSection(observer, util.vector.of(0.5, 1.5, -0.5), 0);
		scene.world.rotateSection(observer, 0, 30 - 180, 0, 0);
		scene.idle(20);
		scene.world.moveSection(observer, util.vector.of(-0.5, -1.5, 0.5), 10);
		scene.world.rotateSection(observer, 0, -30 + 180, 0, 10);
		scene.world.showSection(util.select.position(4, 1, 0), Direction.SOUTH);

		Selection observerRedstone = util.select.fromTo(4, 1, 1, 4, 1, 0);
		for (int i = 0; i < 6; i++) {
			scene.world.createItemEntity(topOf, util.vector.of(0, 0.1, 0), copper);
			scene.idle(12);
			scene.world.modifyEntities(ItemEntity.class, Entity::discard);
			scene.world.createItemOnBeltLike(ejectorPos, Direction.UP, copper);
			scene.idle(1);
			scene.world.toggleRedstonePower(observerRedstone);
			scene.effects.indicateRedstone(util.grid.at(4, 1, 1));
			scene.idle(3);
			scene.world.toggleRedstonePower(observerRedstone);
			scene.idle(16);
			if (i == 3)
				scene.markAsFinished();
			if (i == 1) {
				scene.overlay.showText(60)
					.attachKeyFrame()
					.pointAt(util.vector.blockSurface(util.grid.at(4, 1, 1), Direction.NORTH))
					.placeNearTarget()
					.text("Observers can detect when Ejectors activate");
			}
		}

	}

}
//文件scenes/ElevatorScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.contraptions.elevator.ElevatorContactBlock;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlock;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

public class ElevatorScenes {

	public static void elevator(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("elevator_pulley", "Using the Elevator Pulley");
		scene.configureBasePlate(1, 0, 5);
		scene.scaleSceneView(.85f);
		scene.removeShadow();
		scene.setSceneOffsetY(-1.5f);

		Selection topFloor = util.select.fromTo(5, 12, 0, 1, 12, 4);
		Selection midFloor = util.select.fromTo(5, 6, 0, 1, 6, 4);
		Selection botFloor = util.select.fromTo(5, 0, 0, 1, 0, 4);
		Selection topCutout = util.select.fromTo(4, 12, 3, 2, 12, 1);
		Selection midCutout = util.select.fromTo(4, 6, 3, 2, 6, 1);
		Selection botCutout = util.select.fromTo(4, 0, 3, 2, 0, 1);
		BlockPos topContact = util.grid.at(1, 13, 2);
		BlockPos midContact = util.grid.at(1, 7, 2);
		BlockPos botContact = util.grid.at(1, 1, 2);
		Selection outputRedstone = util.select.fromTo(0, 0, 2, 0, 1, 2);
		Selection topInput = util.select.fromTo(1, 13, 0, 1, 13, 1);
		Selection midInput = util.select.fromTo(1, 7, 0, 1, 7, 1);
		Selection botInput = util.select.fromTo(1, 1, 0, 1, 1, 1);
		Selection pole = util.select.fromTo(6, 0, 3, 6, 17, 3)
			.add(util.select.position(5, 17, 3));
		Selection cog = util.select.fromTo(5, 18, 2, 4, 18, 2);
		BlockPos nixiePos = util.grid.at(4, 13, 0);
		BlockPos linkPos = util.grid.at(1, 14, 2);
		BlockPos doorPos = util.grid.at(3, 14, 1);
		Selection controls = util.select.position(4, 14, 2);
		BlockPos pulleyPos = util.grid.at(3, 18, 2);

		ElementLink<WorldSectionElement> camLink = scene.world.showIndependentSection(topFloor, Direction.UP);
		scene.world.moveSection(camLink, util.vector.of(0, -12, 0), 0);
		scene.world.setKineticSpeed(util.select.position(pulleyPos), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> pulleyLink =
			scene.world.showIndependentSection(util.select.position(pulleyPos), Direction.DOWN);
		scene.world.moveSection(pulleyLink, util.vector.of(0, -16, 0), 0);
		scene.idle(15);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 2), Direction.WEST))
			.text("Elevator Pulleys can move structures vertically between marked locations");
		scene.idle(60);
		scene.world.moveSection(pulleyLink, util.vector.of(0, 4, 0), 20);
		scene.world.setBlocks(topCutout, Blocks.AIR.defaultBlockState(), false);
		scene.idle(5);

		ElementLink<WorldSectionElement> elevatorLink =
			scene.world.showIndependentSection(util.select.fromTo(4, 13, 3, 2, 13, 1), Direction.DOWN);
		scene.world.moveSection(elevatorLink, util.vector.of(0, -13, 0), 0);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(4, 14, 1, 4, 16, 1), Direction.DOWN, elevatorLink);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 14, 1, 2, 16, 1), Direction.DOWN, elevatorLink);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.fromTo(4, 14, 3, 4, 16, 3), Direction.DOWN, elevatorLink);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 14, 3, 2, 16, 3), Direction.DOWN, elevatorLink);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(4, 17, 1, 2, 17, 3), Direction.DOWN, elevatorLink);

		scene.overlay.showText(40)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 1), Direction.UP))
			.text("Start by constructing a cabin");
		scene.idle(30);

		scene.world.showSectionAndMerge(util.select.position(2, 14, 2), Direction.WEST, elevatorLink);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.position(1, 13, 2), Direction.EAST, camLink);
		scene.idle(15);
		scene.world.toggleRedstonePower(util.select.fromTo(2, 14, 2, 1, 13, 2));
		scene.idle(15);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 1), Direction.UP))
			.text("Place a pair of Redstone Contacts facing each other...");
		scene.idle(55);

		AABB glue1 = new AABB(util.grid.at(3, 4, 2));
		AABB glue2 = glue1.inflate(1, 0, 1)
			.expandTowards(0, -4, 0);

		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(4, 3, 1), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 60);
		scene.idle(7);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glue1, glue1, 5);
		scene.idle(1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glue1, glue2, 90);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.position(2, 1, 2), 80)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 1), Direction.UP))
			.text("...and glue one of them to your moving structure");
		scene.idle(70);

		scene.world.showSectionAndMerge(controls, Direction.DOWN, elevatorLink);
		scene.idle(15);
		scene.effects.superGlue(util.grid.at(4, 1, 2), Direction.DOWN, true);

		scene.overlay.showText(80)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(4, 1, 2), Direction.UP))
			.text("Contraption Controls can be attached to make floor selection easier");
		scene.idle(70);

		scene.world.showSectionAndMerge(cog, Direction.DOWN, camLink);
		scene.world.showSectionAndMerge(pole, Direction.UP, camLink);
		scene.idle(10);
		scene.world.setKineticSpeed(util.select.position(pulleyPos), 64);
		scene.idle(5);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 6, 2), Direction.WEST))
			.text("Ensure that the pulley is supplied with Rotational Power");
		scene.idle(75);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 6, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick(),
			60);
		scene.idle(7);
		scene.effects.indicateSuccess(util.grid.at(3, 6, 2));
		scene.world.toggleRedstonePower(util.select.position(1, 13, 2));
		scene.world.setBlock(topContact, AllBlocks.ELEVATOR_CONTACT.getDefaultState()
			.setValue(ElevatorContactBlock.FACING, Direction.EAST)
			.setValue(ElevatorContactBlock.POWERING, true), false);
		scene.world.movePulley(pulleyPos, 1, 0);

		scene.overlay.showText(50)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 6, 2), Direction.WEST))
			.text("Right-Clicking the pulley assembles the elevator");
		scene.idle(60);

		scene.overlay.showText(70)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
			.text("The stationary contact now turns into an Elevator Contact");
		scene.idle(80);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP), Pointing.DOWN)
				.rightClick(),
			60);
		scene.idle(7);
		scene.overlay.showSelectionWithText(util.select.position(1, 1, 2), 60)
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
			.text("Elevator Contacts represent a 'floor' and can be configured");
		scene.idle(75);

		scene.world.moveSection(elevatorLink, util.vector.of(0, 7, 0), 15);
		scene.world.moveSection(camLink, util.vector.of(0, 7, 0), 15);
		scene.world.moveSection(pulleyLink, util.vector.of(0, 7, 0), 15);
		scene.addLazyKeyframe();
		scene.world.setBlocks(midCutout, Blocks.AIR.defaultBlockState(), false);
		scene.idle(15);
		scene.world.showSectionAndMerge(midFloor, Direction.EAST, camLink);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(midContact), Direction.DOWN, camLink);
		scene.idle(10);
		scene.effects.indicateSuccess(util.grid.at(1, 2, 2));
		scene.world.setBlock(midContact, AllBlocks.ELEVATOR_CONTACT.getDefaultState()
			.setValue(ElevatorContactBlock.FACING, Direction.EAST), false);
		scene.idle(15);

		AABB bb = new AABB(util.grid.at(1, 8, 2));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, bb, bb, 5);
		scene.idle(1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, bb, bb.expandTowards(0, -6, 0), 90);
		scene.idle(10);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.UP))
			.text("Any redstone contact sharing this column will be converted");
		scene.idle(50);
		scene.world.showSectionAndMerge(midInput, Direction.SOUTH, camLink);
		scene.idle(15);

		scene.world.toggleRedstonePower(midInput);
		scene.effects.indicateRedstone(util.grid.at(1, 2, 0));
		scene.world.cycleBlockProperty(midContact, ElevatorContactBlock.CALLING);
		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.POWERING);
		scene.world.moveSection(elevatorLink, util.vector.of(0, -6, 0), 60);
		scene.world.movePulley(pulleyPos, 6, 60);
		scene.idle(20);
		scene.world.toggleRedstonePower(midInput);
		scene.idle(10);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 0), Direction.UP))
			.text("Supply a redstone pulse to call the elevator to the contact");

		scene.idle(30);
		scene.world.cycleBlockProperty(midContact, ElevatorContactBlock.CALLING);
		scene.world.cycleBlockProperty(midContact, ElevatorContactBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 7, 1));
		scene.idle(40);

		scene.overlay.showText(70)
			.placeNearTarget()
			.pointAt(util.vector.centerOf(util.grid.at(2, 3, 3)))
			.text("The movement speed depends on the rotation input on the pulley");
		scene.idle(80);
		scene.addLazyKeyframe();
		scene.idle(10);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(4, 2, 2), Direction.UP), Pointing.DOWN)
				.scroll(),
			60);
		scene.idle(15);
		scene.overlay.showText(90)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(4, 2, 2), Direction.UP))
			.text("Scroll and click on the controls block to choose a floor while on-board");
		scene.idle(85);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(4, 2, 2), Direction.UP), Pointing.DOWN)
				.rightClick(),
			10);
		scene.idle(7);
		scene.world.cycleBlockProperty(midContact, ElevatorContactBlock.POWERING);
		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.CALLING);
		scene.world.toggleRedstonePower(util.select.position(1, 7, 1));
		scene.world.moveSection(camLink, util.vector.of(0, -7, 0), 60);
		scene.world.moveSection(pulleyLink, util.vector.of(0, -7, 0), 60);
		scene.world.moveSection(elevatorLink, util.vector.of(0, -1, 0), 60);
		scene.world.movePulley(pulleyPos, -6, 60);
		scene.idle(60);

		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.POWERING);
		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.CALLING);
		scene.idle(15);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 6, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick(),
			60);
		scene.idle(7);
		scene.effects.indicateSuccess(util.grid.at(3, 6, 2));
		scene.world.movePulley(pulleyPos, -1, 0);

		scene.overlay.showText(80)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 6, 2), Direction.WEST))
			.text("Right-Clicking the assembled pulley will turn the cabin back into blocks");
		scene.idle(90);

		scene.world.showSectionAndMerge(util.select.fromTo(doorPos, doorPos.above()), Direction.DOWN, elevatorLink);
		scene.idle(20);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 6, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick(),
			60);
		scene.idle(7);
		scene.effects.indicateSuccess(util.grid.at(3, 6, 2));
		scene.world.movePulley(pulleyPos, 1, 0);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.OPEN);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.VISIBLE);
		scene.world.cycleBlockProperty(doorPos.above(), SlidingDoorBlock.VISIBLE);

		scene.overlay.showText(80)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 1), Direction.NORTH))
			.text("Sliding doors attached to the cabin will open and close automatically");
		scene.idle(90);

		scene.world.moveSection(elevatorLink, util.vector.of(0, 13, 0), 15);
		scene.world.moveSection(camLink, util.vector.of(0, 13, 0), 15);
		scene.world.moveSection(pulleyLink, util.vector.of(0, 13, 0), 15);
		scene.world.setBlocks(botCutout, Blocks.AIR.defaultBlockState(), false);
		scene.idle(15);
		scene.world.showSectionAndMerge(botFloor, Direction.EAST, camLink);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(botContact), Direction.DOWN, camLink);
		scene.idle(10);
		scene.effects.indicateSuccess(util.grid.at(1, 2, 2));
		scene.world.setBlock(botContact, AllBlocks.ELEVATOR_CONTACT.getDefaultState()
			.setValue(ElevatorContactBlock.FACING, Direction.EAST), false);
		scene.idle(5);
		scene.world.showSectionAndMerge(botInput, Direction.SOUTH, camLink);
		scene.idle(15);

		scene.world.toggleRedstonePower(botInput);
		scene.effects.indicateRedstone(util.grid.at(1, 2, 0));
		scene.world.cycleBlockProperty(botContact, ElevatorContactBlock.CALLING);
		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.POWERING);
		scene.world.moveSection(elevatorLink, util.vector.of(0, -12, 0), 50);
		scene.world.movePulley(pulleyPos, 12, 50);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.OPEN);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.VISIBLE);
		scene.world.cycleBlockProperty(doorPos.above(), SlidingDoorBlock.VISIBLE);
		scene.idle(20);

		scene.world.toggleRedstonePower(botInput);
		scene.world.showSectionAndMerge(outputRedstone, Direction.EAST, camLink);
		scene.idle(30);

		scene.world.cycleBlockProperty(botContact, ElevatorContactBlock.CALLING);
		scene.world.cycleBlockProperty(botContact, ElevatorContactBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 1, 1));
		scene.world.toggleRedstonePower(outputRedstone);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.OPEN);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.VISIBLE);
		scene.world.cycleBlockProperty(doorPos.above(), SlidingDoorBlock.VISIBLE);
		scene.idle(15);

		scene.overlay.showText(80)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.topOf(0, 1, 2))
			.text("Elevator Contacts emit a signal while the cabin is on their floor");
		scene.idle(90);

		scene.overlay.showText(80)
			.placeNearTarget()
			.pointAt(util.vector.topOf(0, 1, 2))
			.text("This can be useful to trigger doors or special effects upon arrival");
		scene.idle(90);

		scene.world.setBlock(nixiePos, AllBlocks.NIXIE_TUBES.get(DyeColor.GREEN)
			.getDefaultState()
			.setValue(NixieTubeBlock.FACING, Direction.WEST), false);

		scene.world.moveSection(camLink, util.vector.of(0, -13, 0), 20);
		scene.world.moveSection(pulleyLink, util.vector.of(0, -13, 0), 20);
		scene.world.moveSection(elevatorLink, util.vector.of(0, -13, 0), 20);
		scene.idle(30);
		scene.world.showSectionAndMerge(util.select.position(nixiePos), Direction.DOWN, camLink);
		scene.idle(15);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(4, 1, 0), Direction.UP), Pointing.DOWN)
				.rightClick()
				.withItem(AllBlocks.DISPLAY_LINK.asStack()),
			15);
		scene.world.toggleRedstonePower(util.select.position(1, 14, 2));
		scene.idle(15);
		scene.world.showSectionAndMerge(util.select.position(linkPos), Direction.DOWN, camLink);
		scene.world.flashDisplayLink(linkPos);
		scene.world.modifyBlockEntityNBT(util.select.position(nixiePos), NixieTubeBlockEntity.class, nbt -> {
			Component component = Components.literal("0F");
			nbt.putString("RawCustomText", component.getString());
			nbt.putString("CustomText", Component.Serializer.toJson(component));
		});

		scene.overlay.showText(90)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(1, 2, 2))
			.text("Display Links on any of the contacts can show the current floor of the elevator");
		scene.idle(90);

		scene.world.showSectionAndMerge(topInput, Direction.SOUTH, camLink);
		scene.idle(15);

		scene.world.toggleRedstonePower(topInput);
		scene.effects.indicateRedstone(util.grid.at(1, 2, 0));
		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.CALLING);
		scene.world.cycleBlockProperty(botContact, ElevatorContactBlock.POWERING);
		scene.world.moveSection(elevatorLink, util.vector.of(0, 12, 0), 70);
		scene.world.movePulley(pulleyPos, -12, 70);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.OPEN);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.VISIBLE);
		scene.world.cycleBlockProperty(doorPos.above(), SlidingDoorBlock.VISIBLE);
		scene.idle(20);

		scene.world.toggleRedstonePower(topInput);
		scene.idle(10);

		scene.world.flashDisplayLink(linkPos);
		scene.world.modifyBlockEntityNBT(util.select.position(nixiePos), NixieTubeBlockEntity.class, nbt -> {
			Component component = Components.literal("1F");
			nbt.putString("RawCustomText", component.getString());
			nbt.putString("CustomText", Component.Serializer.toJson(component));
		});

		scene.idle(40);

		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.CALLING);
		scene.world.cycleBlockProperty(topContact, ElevatorContactBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 13, 1));
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.OPEN);
		scene.world.cycleBlockProperty(doorPos, SlidingDoorBlock.VISIBLE);
		scene.world.cycleBlockProperty(doorPos.above(), SlidingDoorBlock.VISIBLE);

		scene.world.flashDisplayLink(linkPos);
		scene.world.modifyBlockEntityNBT(util.select.position(nixiePos), NixieTubeBlockEntity.class, nbt -> {
			Component component = Components.literal("2F");
			nbt.putString("RawCustomText", component.getString());
			nbt.putString("CustomText", Component.Serializer.toJson(component));
		});
	}

	public static void multiRope(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("elevator_pulley_multi_rope", "Synchronised Pulley Movement");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.scaleSceneView(.95f);
		scene.showBasePlate();
		scene.idle(5);

		Selection mainPulley = util.select.fromTo(5, 0, 1, 5, 4, 1)
			.add(util.select.fromTo(4, 4, 1, 3, 4, 1));
		BlockPos pulley1 = util.grid.at(3, 4, 1);
		BlockPos pulley2 = util.grid.at(3, 4, 3);
		BlockPos pulley3 = util.grid.at(1, 4, 3);
		Selection contraption = util.select.fromTo(3, 1, 3, 1, 1, 1);

		ElementLink<WorldSectionElement> planksLink = scene.world.showIndependentSection(contraption, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(mainPulley, Direction.WEST);
		scene.idle(4);
		scene.world.showSection(util.select.position(pulley2), Direction.DOWN);
		scene.idle(4);
		scene.world.showSection(util.select.position(pulley3), Direction.DOWN);
		scene.idle(15);

		scene.world.movePulley(pulley1, 2, 20);
		scene.idle(20);

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(util.grid.at(3, 1, 1)))
			.placeNearTarget()
			.text("Whenever a pulley assembles a contraption...");
		scene.idle(70);

		scene.world.movePulley(pulley2, 2, 0);
		scene.world.movePulley(pulley3, 2, 0);
		scene.idle(1);
		scene.world.movePulley(pulley1, -2, 20);
		scene.world.movePulley(pulley2, -2, 20);
		scene.world.movePulley(pulley3, -2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, 2, 0), 20);
		scene.idle(20);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 4, 3), Direction.WEST))
			.placeNearTarget()
			.text("...other pulleys on the same layer will connect to the structure");
		scene.idle(60);

		scene.world.movePulley(pulley1, 2, 20);
		scene.world.movePulley(pulley2, 2, 20);
		scene.world.movePulley(pulley3, 2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, -2, 0), 20);
		scene.idle(20);

		scene.idle(20);
		scene.world.movePulley(pulley1, -2, 20);
		scene.world.movePulley(pulley2, -2, 20);
		scene.world.movePulley(pulley3, -2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, 2, 0), 20);
		scene.idle(20);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 4, 3), Direction.WEST))
			.placeNearTarget()
			.text("They do not require to be powered, the effect is purely cosmetic");
		scene.idle(60);

		scene.world.movePulley(pulley1, 2, 20);
		scene.world.movePulley(pulley2, 2, 20);
		scene.world.movePulley(pulley3, 2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, -2, 0), 20);
		scene.idle(20);

	}

}
//文件scenes/FanScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.logistics.depot.DepotBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FlappyPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FanScenes {

	public static void direction(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("fan_direction", "Air flow of Encased Fans");
		scene.configureBasePlate(0, 1, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 0, 3, 1, 5)
			.add(util.select.position(3, 2, 4)), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(2, 1, 5, 1, 1, 5), Direction.DOWN);
		scene.idle(10);

		BlockPos fanPos = util.grid.at(1, 1, 4);
		scene.world.showSection(util.select.position(fanPos), Direction.SOUTH);

		scene.idle(40);
		scene.effects.rotationDirectionIndicator(fanPos.south());

		ElementLink<ParrotElement> flappyBirb = scene.special.createBirb(util.vector.topOf(1, 0, 3), FlappyPose::new);
		scene.idle(2);
		scene.special.rotateParrot(flappyBirb, 0, 235, 0, 30);
		scene.special.moveParrot(flappyBirb, util.vector.of(0, 0, -2.5), 30);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Encased Fans use Rotational Force to create an Air Current")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(fanPos));
		scene.idle(90);

		BlockPos leverPos = util.grid.at(3, 2, 4);
		Selection reverse = util.select.fromTo(3, 1, 5, 1, 1, 4);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.effects.indicateRedstone(leverPos);
		scene.addKeyframe();
		scene.world.modifyKineticSpeed(reverse, f -> -f);
		scene.effects.rotationDirectionIndicator(fanPos.south());
		scene.special.rotateParrot(flappyBirb, 0, 215 * 2, 0, 30);
		scene.special.moveParrot(flappyBirb, util.vector.of(0, 0, 2.5), 30);
		scene.idle(31);

		scene.overlay.showText(60)
			.text("Strength and Direction of Flow depends on the Rotational Input")
			.placeNearTarget()
			.pointAt(util.vector.topOf(fanPos));
		scene.markAsFinished();
		scene.idle(70);

		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reverse, f -> -f);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> 4 * f);
		scene.effects.rotationSpeedIndicator(fanPos.south());
		scene.special.rotateParrot(flappyBirb, 0, 245 * 4, 0, 30);
		scene.special.moveParrot(flappyBirb, util.vector.of(0, 0, -20), 30);

	}

	public static void processing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("fan_processing", "Processing Items using Encased Fans");
		scene.configureBasePlate(1, 0, 5);
		scene.world.showSection(util.select.layer(0)
			.substract(util.select.position(0, 0, 4)), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(6, 1, 2, 5, 1, 2)
			.add(util.select.position(1, 1, 2)), Direction.DOWN);
		scene.idle(25);

		BlockPos blockPos = util.grid.at(4, 1, 2);

		// blasting start

		ElementLink<WorldSectionElement> blockInFront =
			scene.world.showIndependentSection(util.select.position(3, 1, 0), Direction.SOUTH);
		scene.world.moveSection(blockInFront, util.vector.of(1, 0, 2), 0);
		scene.world.setBlock(blockPos, Blocks.LAVA.defaultBlockState(), false);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.fromTo(blockPos, blockPos.west(2)), 80)
			.colored(PonderPalette.RED)
			.text("When passing through lava, the Air Flow becomes Heated");
		scene.idle(80);

		ItemStack stack = new ItemStack(Items.GOLD_ORE);
		ItemStack smelted = new ItemStack(Items.GOLD_INGOT);

		ElementLink<EntityElement> entityLink = scene.world.createItemEntity(util.vector.centerOf(blockPos.west(2)
			.above(2)), util.vector.of(0, 0.1, 0), stack);
		scene.idle(15);
		scene.world.modifyEntity(entityLink, e -> e.setDeltaMovement(-0.2f, 0, 0));
		Vec3 itemVec = util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.EAST)
			.add(0.1, 0, 0);
		scene.overlay.showControls(new InputWindowElement(itemVec, Pointing.DOWN).withItem(stack), 20);
		scene.idle(20);
		scene.effects.emitParticles(itemVec.add(0, 0.2f, 0), Emitter.simple(ParticleTypes.LARGE_SMOKE, Vec3.ZERO), 1,
			60);

		scene.overlay.showText(80)
			.colored(PonderPalette.WHITE)
			.pointAt(itemVec)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Items caught in the area will be smelted");

		scene.idle(60);
		scene.world.modifyEntities(ItemEntity.class, ie -> ie.setItem(smelted));
		scene.idle(40);
		scene.overlay.showControls(new InputWindowElement(itemVec, Pointing.DOWN).withItem(smelted), 20);
		scene.idle(20);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(20);

		scene.overlay.showText(80)
			.colored(PonderPalette.RED)
			.pointAt(itemVec)
			.placeNearTarget()
			.text("Food items thrown here would be incinerated");
		scene.idle(40);

		// smoking start

		BlockState campfire = Blocks.FIRE.defaultBlockState();
		scene.world.hideIndependentSection(blockInFront, Direction.NORTH);
		scene.idle(15);
		scene.world.setBlock(util.grid.at(3, 1, 0), campfire, false);
		scene.world.setBlock(blockPos, campfire, true);
		blockInFront = scene.world.showIndependentSection(util.select.position(3, 1, 0), Direction.NORTH);
		scene.world.moveSection(blockInFront, util.vector.of(1, 0, 2), 0);
		scene.idle(50);

		scene.overlay.showSelectionWithText(util.select.fromTo(blockPos, blockPos.west(2)), 60)
			.colored(PonderPalette.BLACK)
			.attachKeyFrame()
			.text("Instead, a setup for Smoking using Fire should be used for them");
		scene.idle(80);

		// washing start

		BlockState water = Blocks.WATER.defaultBlockState();
		scene.world.hideIndependentSection(blockInFront, Direction.NORTH);
		scene.idle(15);
		scene.world.setBlock(util.grid.at(3, 1, 0), water, false);
		scene.world.setBlock(blockPos, water, true);
		blockInFront = scene.world.showIndependentSection(util.select.position(3, 1, 0), Direction.NORTH);
		scene.world.moveSection(blockInFront, util.vector.of(1, 0, 2), 0);
		scene.idle(20);

		scene.overlay.showSelectionWithText(util.select.fromTo(blockPos, blockPos.west(2)), 60)
			.colored(PonderPalette.MEDIUM)
			.attachKeyFrame()
			.text("Air Flows passing through water create a Washing Setup");
		scene.idle(70);

		stack = new ItemStack(Items.RED_SAND, 16);
		ItemStack washed = new ItemStack(Items.GOLD_NUGGET, 16);

		entityLink = scene.world.createItemEntity(util.vector.centerOf(blockPos.west(2)
			.above(2)), util.vector.of(0, 0.1, 0), stack);
		scene.idle(15);
		scene.world.modifyEntity(entityLink, e -> e.setDeltaMovement(-0.2f, 0, 0));
		scene.overlay.showControls(new InputWindowElement(itemVec, Pointing.DOWN).withItem(stack), 20);
		scene.idle(20);
		scene.effects.emitParticles(itemVec.add(0, 0.2f, 0), Emitter.simple(ParticleTypes.SPIT, Vec3.ZERO), 1, 60);

		scene.overlay.showText(50)
			.colored(PonderPalette.WHITE)
			.pointAt(itemVec)
			.placeNearTarget()
			.text("Some interesting new processing can be done with it");

		scene.idle(60);
		scene.world.modifyEntities(ItemEntity.class, ie -> ie.setItem(washed));
		scene.overlay.showControls(new InputWindowElement(itemVec, Pointing.DOWN).withItem(washed), 20);
		scene.idle(20);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(20);

		scene.overlay.showText(100)
			.colored(PonderPalette.RED)
			.pointAt(util.vector.topOf(blockPos.east()))
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Speed of the Fan does NOT affect the processing speed, only its range");
		scene.world.destroyBlock(util.grid.at(1, 1, 2));
		scene.idle(110);

		ElementLink<WorldSectionElement> cogs = scene.world.makeSectionIndependent(util.select.fromTo(6, 1, 2, 6, 0, 3)
			.add(util.select.fromTo(4, 0, 2, 5, 0, 2)));
		scene.world.modifyKineticSpeed(util.select.position(5, 2, 2), f -> f / 3f);
		scene.world.moveSection(cogs, util.vector.of(0, 1, 0), 15);
		scene.world.moveSection(blockInFront, util.vector.of(0, 1, 0), 15);
		scene.world.destroyBlock(blockPos.east());
		scene.world.showSection(util.select.position(blockPos.east()
			.above()), Direction.DOWN);
		scene.world.setBlock(blockPos.above(), Blocks.WATER.defaultBlockState(), false);

		ItemStack sand = new ItemStack(Items.SAND);
		ItemStack clay = new ItemStack(Items.CLAY_BALL);

		scene.idle(20);
		BlockPos depos = util.grid.at(3, 4, 2);
		ElementLink<WorldSectionElement> depot =
			scene.world.showIndependentSection(util.select.position(depos), Direction.DOWN);
		scene.world.moveSection(depot, util.vector.of(-1, -3, 0), 0);
		scene.world.createItemOnBeltLike(depos, Direction.NORTH, sand);
		scene.idle(10);
		Vec3 depotTop = util.vector.topOf(2, 1, 2)
			.add(0, 0.25, 0);
		scene.effects.emitParticles(depotTop, Emitter.simple(ParticleTypes.SPIT, Vec3.ZERO), .5f, 30);
		scene.idle(30);
		scene.world.modifyBlockEntityNBT(util.select.position(depos), DepotBlockEntity.class,
			nbt -> nbt.put("HeldItem", new TransportedItemStack(clay).serializeNBT()));
		scene.effects.emitParticles(depotTop, Emitter.simple(ParticleTypes.SPIT, Vec3.ZERO), .5f, 30);
		scene.overlay.showText(90)
			.pointAt(depotTop)
			.attachKeyFrame()
			.text("Fan Processing can also be applied to Items on Depots and Belts");

		scene.idle(100);
		scene.world.moveSection(depot, util.vector.of(-1, 0, 0), 15);
		scene.idle(15);
		ElementLink<WorldSectionElement> largeCog =
			scene.world.showIndependentSection(util.select.position(1, 2, 4), Direction.UP);
		ElementLink<WorldSectionElement> belt =
			scene.world.showIndependentSection(util.select.fromTo(3, 3, 1, 1, 3, 3), Direction.DOWN);
		scene.world.moveSection(largeCog, util.vector.of(-1, -2, 0), 0);
		scene.world.moveSection(belt, util.vector.of(-1, -2, 0), 0);
		ElementLink<BeltItemElement> transported =
			scene.world.createItemOnBelt(util.grid.at(3, 3, 3), Direction.SOUTH, sand);
		scene.idle(60);
		scene.effects.emitParticles(depotTop, Emitter.simple(ParticleTypes.SPIT, Vec3.ZERO), .5f, 25);
		scene.idle(25);
		scene.world.changeBeltItemTo(transported, new ItemStack(Items.CLAY_BALL));
		scene.effects.emitParticles(depotTop, Emitter.simple(ParticleTypes.SPIT, Vec3.ZERO), .5f, 25);
		scene.idle(60);

		scene.world.setKineticSpeed(util.select.position(1, 2, 4)
			.add(util.select.fromTo(3, 3, 1, 1, 3, 3)), 0);

	}

}
//文件scenes/fluid/DrainScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import com.simibubi.create.content.fluids.drain.ItemDrainBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class DrainScenes {

	public static void emptying(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("item_drain", "Emptying Fluid Containers using Item Drains");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		Selection drain = util.select.position(3, 1, 2);
		BlockPos drainPos = util.grid.at(3, 1, 2);
		Selection pipes = util.select.fromTo(3, 1, 3, 3, 1, 4)
			.add(util.select.fromTo(3, 2, 4, 2, 2, 4));
		Selection tank = util.select.fromTo(1, 1, 4, 1, 3, 4);
		Selection largeCog = util.select.position(1, 0, 5);
		Selection kinetics = util.select.fromTo(2, 1, 3, 2, 1, 5);
		Selection belt = util.select.fromTo(2, 1, 2, 1, 1, 2);
		BlockPos beltPos = util.grid.at(1, 1, 2);

		ElementLink<WorldSectionElement> drainLink = scene.world.showIndependentSection(drain, Direction.DOWN);
		scene.world.moveSection(drainLink, util.vector.of(-1, 0, 0), 0);
		scene.idle(10);

		scene.overlay.showText(40)
			.text("Item Drains can extract fluids from items")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(drainPos.west(), Direction.UP));
		scene.idle(50);

		ItemStack lavaBucket = new ItemStack(Items.LAVA_BUCKET);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(drainPos.west(), Direction.UP), Pointing.DOWN).rightClick()
				.withItem(lavaBucket),
			40);
		scene.idle(7);
		scene.world.modifyBlockEntity(drainPos, ItemDrainBlockEntity.class, be -> {
			be.getBehaviour(SmartFluidTankBehaviour.TYPE)
				.allowInsertion();
			be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(fh -> fh.fill(new FluidStack(Fluids.LAVA, 1000), FluidAction.EXECUTE));
		});
		scene.idle(10);

		scene.overlay.showText(50)
			.text("Right-click it to pour fluids from your held item into it")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(drainPos.west(), Direction.WEST));
		scene.idle(60);

		scene.world.modifyBlockEntity(drainPos, ItemDrainBlockEntity.class,
			be -> be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(fh -> fh.drain(500, FluidAction.EXECUTE)));

		scene.world.moveSection(drainLink, util.vector.of(1, 0, 0), 7);
		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(3);
		scene.world.showSection(kinetics, Direction.NORTH);
		scene.idle(4);
		scene.world.showSection(belt, Direction.SOUTH);
		scene.idle(10);

		scene.overlay.showText(40)
			.text("When items are inserted from the side...")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(2, 1, 2)));
		scene.idle(40);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(beltPos), Pointing.DOWN).withItem(lavaBucket), 20);
		scene.idle(7);
		scene.world.createItemOnBelt(beltPos, Direction.NORTH, lavaBucket);
		scene.idle(30);

		scene.overlay.showText(60)
			.text("...they roll across, emptying out their contained fluid")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(drainPos));
		scene.idle(40);

		scene.world.showSection(tank, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(pipes, Direction.NORTH);
		scene.idle(20);

		scene.overlay.showText(90)
			.text("Pipe Networks can now pull the fluid from the drains' internal buffer")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(3, 1, 3)));
		scene.idle(50);
		scene.markAsFinished();
		scene.idle(50);

		for (int i = 0; i < 5; i++) {
			scene.world.createItemOnBelt(beltPos, Direction.NORTH, lavaBucket);
			scene.idle(30);
		}

	}

}
//文件scenes/fluid/FluidMovementActorScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.contraptions.actors.psi.PortableFluidInterfaceBlockEntity;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class FluidMovementActorScenes {

	public static void transfer(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("portable_fluid_interface", "Contraption Fluid Exchange");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.95f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();
		scene.idle(5);

		Selection pipes = util.select.fromTo(2, 1, 3, 0, 1, 3)
			.add(util.select.position(0, 1, 4));
		BlockPos pumpPos = util.grid.at(0, 1, 4);
		Selection kinetics = util.select.fromTo(1, 1, 7, 1, 1, 4);
		Selection tank = util.select.fromTo(0, 1, 5, 0, 3, 5);
		Selection largeCog = util.select.position(2, 0, 7);
		FluidStack chocolate = new FluidStack(FluidHelper.convertToStill(AllFluids.CHOCOLATE.get()), 1000);
		BlockPos ct1 = util.grid.at(5, 3, 2);
		BlockPos ct2 = util.grid.at(6, 3, 2);
		BlockPos st = util.grid.at(0, 1, 5);
		Capability<IFluidHandler> fhc = ForgeCapabilities.FLUID_HANDLER;
		Class<FluidTankBlockEntity> type = FluidTankBlockEntity.class;
		ItemStack bucket = AllFluids.CHOCOLATE.get()
			.getFluidType()
			.getBucket(chocolate);
		
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.NORTH), false);

		scene.world.modifyBlockEntity(st, type, be -> be.getCapability(fhc)
			.ifPresent(ifh -> ifh.fill(FluidHelper.copyStackWithAmount(chocolate, 10000), FluidAction.EXECUTE)));

		BlockPos bearing = util.grid.at(5, 1, 2);
		scene.world.showSection(util.select.position(bearing), Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(5, 2, 2, 6, 4, 2), Direction.DOWN);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearing));
		scene.idle(10);
		scene.world.rotateBearing(bearing, 360, 70);
		scene.world.rotateSection(contraption, 0, 360, 0, 70);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(bearing.above(2)))
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Fluid Tanks on moving contraptions cannot be accessed by any pipes");

		scene.idle(70);
		BlockPos psi = util.grid.at(4, 2, 2);
		scene.world.showSectionAndMerge(util.select.position(psi), Direction.EAST, contraption);
		scene.idle(13);
		scene.effects.superGlue(psi, Direction.EAST, true);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(psi))
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.attachKeyFrame()
			.text("This component can interact with fluid tanks without the need to stop the contraption");
		scene.idle(90);

		BlockPos psi2 = psi.west(2);
		scene.world.showSection(util.select.position(psi2), Direction.DOWN);
		scene.overlay.showSelectionWithText(util.select.position(psi.west()), 50)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Place a second one with a gap of 1 or 2 blocks inbetween");
		scene.idle(55);

		scene.world.rotateBearing(bearing, 360, 60);
		scene.world.rotateSection(contraption, 0, 360, 0, 60);
		scene.idle(20);

		scene.overlay.showText(40)
			.placeNearTarget()
			.pointAt(util.vector.of(3, 3, 2.5))
			.text("Whenever they pass by each other, they will engage in a connection");
		scene.idle(38);

		Selection both = util.select.fromTo(2, 2, 2, 4, 2, 2);
		Class<PortableFluidInterfaceBlockEntity> psiClass = PortableFluidInterfaceBlockEntity.class;

		scene.world.modifyBlockEntityNBT(both, psiClass, nbt -> {
			nbt.putFloat("Distance", 1);
			nbt.putFloat("Timer", 14);
		});

		scene.idle(17);
		scene.overlay.showOutline(PonderPalette.GREEN, psi, util.select.fromTo(5, 3, 2, 6, 4, 2), 80);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.position(psi2), 70)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.text("While engaged, the stationary interface will represent ALL Tanks on the contraption");
		scene.idle(80);

		ElementLink<WorldSectionElement> p = scene.world.showIndependentSection(tank, Direction.DOWN);
		scene.world.moveSection(p, util.vector.of(0, 0, -1), 0);
		scene.idle(5);
		scene.world.showSectionAndMerge(pipes, Direction.EAST, p);
		scene.idle(5);
		scene.world.showSectionAndMerge(largeCog, Direction.UP, p);
		scene.world.showSectionAndMerge(kinetics, Direction.NORTH, p);
		scene.idle(10);

		scene.overlay.showText(70)
			.placeNearTarget()
			.pointAt(util.vector.topOf(pumpPos))
			.attachKeyFrame()
			.text("Fluid can now be inserted...");
		scene.idle(30);

		for (int i = 0; i < 16; i++) {
			if (i == 8)
				scene.overlay
					.showControls(new InputWindowElement(util.vector.blockSurface(util.grid.at(5, 3, 2), Direction.WEST)
						.add(0, 0.5, 0), Pointing.LEFT).withItem(bucket), 30);
			scene.world.modifyBlockEntity(st, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.drain(1000, FluidAction.EXECUTE)));
			scene.world.modifyBlockEntity(ct1, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.fill(chocolate, FluidAction.EXECUTE)));
			scene.idle(2);
		}
		for (int i = 0; i < 8; i++) {
			scene.world.modifyBlockEntity(st, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.drain(1000, FluidAction.EXECUTE)));
			scene.world.modifyBlockEntity(ct2, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.fill(chocolate, FluidAction.EXECUTE)));
			scene.idle(2);
		}

		scene.idle(50);

		scene.overlay.showText(40)
			.placeNearTarget()
			.pointAt(util.vector.topOf(pumpPos))
			.text("...or extracted from the contraption");
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.SOUTH), true);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(30);

		for (int i = 0; i < 8; i++) {
			scene.world.modifyBlockEntity(ct2, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.drain(1000, FluidAction.EXECUTE)));
			scene.world.modifyBlockEntity(st, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.fill(chocolate, FluidAction.EXECUTE)));
			scene.idle(2);
		}
		for (int i = 0; i < 16; i++) {
			scene.world.modifyBlockEntity(ct1, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.drain(1000, FluidAction.EXECUTE)));
			scene.world.modifyBlockEntity(st, type, be -> be.getCapability(fhc)
				.ifPresent(ifh -> ifh.fill(chocolate, FluidAction.EXECUTE)));
			scene.idle(2);
		}

		scene.world.modifyBlockEntity(util.grid.at(2, 2, 3), type, be -> be.getCapability(fhc)
			.ifPresent(ifh -> ifh.drain(8000, FluidAction.EXECUTE)));
		scene.idle(50);

		scene.overlay.showText(120)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.topOf(psi2))
			.text("After no contents have been exchanged for a while, the contraption will continue on its way");
		scene.world.modifyBlockEntityNBT(both, psiClass, nbt -> nbt.putFloat("Timer", 2));

		scene.idle(15);
		scene.world.rotateBearing(bearing, 270, 120);
		scene.world.rotateSection(contraption, 0, 270, 0, 120);
		
		scene.idle(100);
		scene.markAsFinished();
	}

}
//文件scenes/fluid/FluidTankScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllFluids;
import com.simibubi.create.content.fluids.FluidFX;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.content.fluids.tank.CreativeFluidTankBlockEntity;
import com.simibubi.create.content.fluids.tank.CreativeFluidTankBlockEntity.CreativeSmartFluidTank;
import com.simibubi.create.content.fluids.tank.FluidTankBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlockEntity;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.Pointing;
import com.simibubi.create.foundation.utility.VecHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class FluidTankScenes {

	public static void storage(SceneBuilder scene, SceneBuildingUtil util) {
		RandomSource random = RandomSource.create();

		scene.title("fluid_tank_storage", "Storing Fluids in Fluid Tanks");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		BlockPos tankPos = util.grid.at(3, 1, 2);
		Selection chocolate = util.select.fromTo(1, 5, 0, 0, 8, 1);
		Selection tank = util.select.fromTo(3, 1, 2, 3, 2, 2);
		Selection largeCog1 = util.select.position(3, 0, 5);
		Selection kinetics1 = util.select.fromTo(2, 1, 5, 2, 1, 3)
			.add(util.select.position(2, 2, 4));
		Selection largeCog2 = util.select.position(6, 0, 1);
		Selection comparatorStuff = util.select.fromTo(2, 1, 1, 2, 1, 0);
		Selection pump = util.select.position(1, 1, 3);
		BlockPos pumpPos = util.grid.at(1, 1, 3);
		Selection spoutstuff = util.select.fromTo(3, 1, 0, 5, 3, 2)
			.substract(tank);
		Selection pipe = util.select.fromTo(1, 1, 2, 1, 1, 5)
			.add(util.select.position(1, 0, 5))
			.add(util.select.position(2, 1, 2));

		ElementLink<WorldSectionElement> tankLink = scene.world.showIndependentSection(tank, Direction.NORTH);
		scene.world.moveSection(tankLink, util.vector.of(0, 0, -1), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> chocLink = scene.world.showIndependentSection(chocolate, Direction.NORTH);
		scene.world.moveSection(chocLink, util.vector.of(2, -4, 3), 0);
		scene.idle(10);

		scene.overlay.showOutline(PonderPalette.GREEN, chocLink, util.select.fromTo(3, 1, 3, 2, 4, 4), 40);
		scene.idle(10);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(3, 1, 2), util.vector.of(2, 1, 3), 30);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(3, 3, 2), util.vector.of(2, 5, 3), 30);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(4, 3, 2), util.vector.of(4, 5, 3), 30);
		scene.overlay.showOutline(PonderPalette.GREEN, tankLink, util.select.fromTo(3, 1, 1, 3, 2, 1), 40);
		scene.idle(10);

		scene.overlay.showText(40)
			.text("Fluid Tanks can be used to store large amounts of fluid")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 1), Direction.WEST));
		scene.idle(50);

		scene.world.hideIndependentSection(chocLink, Direction.DOWN);
		scene.idle(5);
		FluidStack content = new FluidStack(AllFluids.CHOCOLATE.get()
			.getSource(), 16000);
		scene.world.modifyBlockEntity(tankPos, FluidTankBlockEntity.class, be -> be.getTankInventory()
			.fill(content, FluidAction.EXECUTE));
		scene.idle(25);

		scene.world.moveSection(tankLink, util.vector.of(0, 0, 1), 10);
		scene.idle(5);
		scene.world.setKineticSpeed(pump, 0);
		scene.world.showSection(pipe, Direction.EAST);
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.SOUTH), false);
		scene.idle(10);
		scene.world.showSection(largeCog1, Direction.UP);
		scene.world.showSection(kinetics1, Direction.WEST);
		scene.idle(10);
		scene.world.setBlock(util.grid.at(1, -1, 5), AllBlocks.FLUID_TANK.getDefaultState(), false);
		scene.world.setKineticSpeed(pump, -32);

		scene.idle(5);
		scene.world.propagatePipeChange(pumpPos);
		scene.world.modifyBlockEntity(util.grid.at(2, 0, 5), FluidTankBlockEntity.class, be -> be.getTankInventory()
			.fill(content, FluidAction.EXECUTE));
		scene.idle(20);

		for (int i = 0; i < 4; i++) {
			scene.world.modifyBlockEntity(tankPos, FluidTankBlockEntity.class, be -> be.getTankInventory()
				.drain(2000, FluidAction.EXECUTE));
			scene.idle(5);
		}

		scene.overlay.showText(60)
			.text("Pipe networks can push and pull fluids from any side")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.centerOf(1, 1, 2));
		scene.idle(40);

		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.NORTH), true);
		scene.world.propagatePipeChange(pumpPos);
		for (int i = 0; i < 4; i++) {
			scene.world.modifyBlockEntity(tankPos, FluidTankBlockEntity.class, be -> be.getTankInventory()
				.fill(FluidHelper.copyStackWithAmount(content, 2000), FluidAction.EXECUTE));
			scene.idle(5);
		}
		scene.idle(40);

		scene.world.hideSection(largeCog1, Direction.DOWN);
		scene.world.hideSection(kinetics1, Direction.SOUTH);
		scene.world.hideSection(pipe, Direction.WEST);
		scene.idle(10);
		scene.world.showSection(comparatorStuff, Direction.SOUTH);
		scene.idle(5);
		scene.world.moveSection(tankLink, util.vector.of(-1, 0, 0), 10);
		scene.idle(10);
		scene.world.toggleRedstonePower(comparatorStuff);
		scene.world.modifyBlockEntityNBT(util.select.position(2, 1, 0), NixieTubeBlockEntity.class,
			nbt -> nbt.putInt("RedstoneStrength", 15));

		scene.overlay.showText(50)
			.text("The contained fluid can be measured by a Comparator")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 1), Direction.DOWN)
				.add(0, 1 / 8f, 0));
		scene.idle(50);

		scene.world.hideSection(comparatorStuff, Direction.EAST);
		scene.idle(20);

		ItemStack bucket = new ItemStack(Items.BUCKET, 1);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH), Pointing.RIGHT)
				.showing(AllIcons.I_MTD_CLOSE)
				.withItem(bucket),
			40);
		scene.idle(7);
		scene.overlay.showSelectionWithText(util.select.fromTo(2, 1, 2, 2, 2, 2), 70)
			.text("However, in Survival Mode Fluids cannot be added or taken manually")
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.WEST));
		scene.idle(80);
		scene.world.modifyBlockEntity(util.grid.at(4, 3, 0), SpoutBlockEntity.class,
			be -> be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(ifh -> ifh.fill(content, FluidAction.EXECUTE)));

		scene.world.moveSection(tankLink, util.vector.of(0, 0, 1), 7);
		scene.world.multiplyKineticSpeed(spoutstuff, -1);
		scene.world.multiplyKineticSpeed(largeCog2, -1);
		scene.idle(7);
		ElementLink<WorldSectionElement> spoutLink = scene.world.showIndependentSection(spoutstuff, Direction.SOUTH);
		ElementLink<WorldSectionElement> largeCogLink = scene.world.showIndependentSection(largeCog2, Direction.UP);
		scene.world.moveSection(spoutLink, util.vector.of(-1, 0, 1), 0);
		scene.world.moveSection(largeCogLink, util.vector.of(-1, 0, 1), 0);
		scene.idle(20);
		scene.overlay.showOutline(PonderPalette.GREEN, new Object(), util.select.position(2, 1, 1), 50);
		scene.idle(5);
		scene.overlay.showOutline(PonderPalette.GREEN, new Object(), util.select.position(3, 3, 1), 50);
		scene.idle(5);

		scene.overlay.showText(80)
			.text("You can use Basins, Item Drains and Spouts to drain or fill fluid containing items")
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 1, 1));
		scene.idle(90);

		ItemStack chocBucket = AllFluids.CHOCOLATE.get()
			.getFluidType()
			.getBucket(new FluidStack(FluidHelper.convertToStill(AllFluids.CHOCOLATE.get()), 1000));
		scene.world.createItemOnBeltLike(util.grid.at(3, 1, 0), Direction.WEST, chocBucket);
		scene.idle(40);
		scene.world.modifyBlockEntityNBT(util.select.position(util.grid.at(4, 3, 0)), SpoutBlockEntity.class,
			nbt -> nbt.putInt("ProcessingTicks", 20));
		scene.idle(20);
		scene.world.removeItemsFromBelt(util.grid.at(4, 1, 0));
		scene.world.createItemOnBeltLike(util.grid.at(4, 1, 0), Direction.UP, chocBucket);
		for (int i = 0; i < 10; i++) {
			scene.effects.emitParticles(util.vector.topOf(3, 1, 1)
				.add(0, 1 / 16f, 0),
				Emitter.simple(FluidFX.getFluidParticle(content),
					VecHelper.offsetRandomly(Vec3.ZERO, random, .1f)),
				1, 1);
		}

	}

	public static void sizes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("fluid_tank_sizes", "Dimensions of a Fluid tank");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.9f);
		scene.showBasePlate();
		scene.idle(5);

		Selection single = util.select.position(0, 3, 0);
		Selection single2 = util.select.fromTo(1, 2, 1, 0, 2, 0);
		Selection single3 = util.select.fromTo(2, 1, 0, 0, 1, 2);

		ElementLink<WorldSectionElement> s1 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s1, util.vector.of(2, -2, 2), 0);
		scene.idle(10);

		scene.overlay.showText(60)
			.text("Fluid Tanks can be combined to increase the total capacity")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 1, 2));
		scene.idle(40);

		ElementLink<WorldSectionElement> s2 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s2, util.vector.of(2, -2, 3), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> s3 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s3, util.vector.of(3, -2, 3), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> s4 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s4, util.vector.of(3, -2, 2), 0);
		scene.idle(10);

		scene.world.moveSection(s1, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s2, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s3, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s4, util.vector.of(0, -100, 0), 0);

		ElementLink<WorldSectionElement> d = scene.world.showIndependentSectionImmediately(single2);
		scene.world.moveSection(d, util.vector.of(2, -1, 2), 0);
		scene.effects.indicateSuccess(util.grid.at(2, 1, 2));
		scene.effects.indicateSuccess(util.grid.at(3, 1, 2));
		scene.effects.indicateSuccess(util.grid.at(2, 1, 3));
		scene.effects.indicateSuccess(util.grid.at(3, 1, 3));
		scene.world.hideIndependentSection(s1, Direction.DOWN);
		scene.world.hideIndependentSection(s2, Direction.DOWN);
		scene.world.hideIndependentSection(s3, Direction.DOWN);
		scene.world.hideIndependentSection(s4, Direction.DOWN);
		scene.idle(25);

		scene.overlay.showText(60)
			.text("Their base square can be up to 3 blocks wide...")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 1, 2));
		scene.idle(40);

		s1 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s1, util.vector.of(2, -2, 4), 0);
		scene.idle(3);
		s2 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s2, util.vector.of(3, -2, 4), 0);
		scene.idle(3);
		s3 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s3, util.vector.of(4, -2, 4), 0);
		scene.idle(3);
		s4 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s4, util.vector.of(4, -2, 3), 0);
		scene.idle(3);
		ElementLink<WorldSectionElement> s5 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s5, util.vector.of(4, -2, 2), 0);
		scene.idle(10);

		scene.world.moveSection(d, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s1, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s2, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s3, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s4, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s5, util.vector.of(0, -100, 0), 0);

		ElementLink<WorldSectionElement> t = scene.world.showIndependentSectionImmediately(single3);
		scene.world.moveSection(t, util.vector.of(2, 0, 2), 0);

		for (int i = 2; i < 5; i++)
			for (int j = 2; j < 5; j++)
				scene.effects.indicateSuccess(util.grid.at(i, 1, j));

		scene.world.hideIndependentSection(d, Direction.DOWN);
		scene.world.hideIndependentSection(s1, Direction.DOWN);
		scene.world.hideIndependentSection(s2, Direction.DOWN);
		scene.world.hideIndependentSection(s3, Direction.DOWN);
		scene.world.hideIndependentSection(s4, Direction.DOWN);
		scene.world.hideIndependentSection(s5, Direction.DOWN);
		scene.idle(25);

		scene.world.hideIndependentSection(t, Direction.DOWN);
		scene.idle(10);

		Selection full1 = util.select.fromTo(5, 1, 0, 5, 6, 0);
		Selection full2 = util.select.fromTo(4, 1, 1, 3, 6, 2);
		Selection full3 = util.select.fromTo(0, 6, 5, 2, 1, 3);

		scene.world.showSection(full1, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(full2, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(full3, Direction.DOWN);
		scene.idle(10);

		Vec3 blockSurface = util.vector.blockSurface(util.grid.at(3, 3, 1), Direction.WEST);
		scene.overlay.showText(60)
			.text("...and grow in height by more than 30 additional layers")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(blockSurface);
		scene.idle(70);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 3, 1), Direction.NORTH), Pointing.RIGHT)
				.rightClick()
				.withWrench(),
			60);
		scene.idle(7);
		scene.world.modifyBlocks(full2, s -> s.setValue(FluidTankBlock.SHAPE, FluidTankBlock.Shape.PLAIN), false);
		scene.idle(30);

		scene.overlay.showText(60)
			.text("Using a Wrench, a tanks' window can be toggled")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(blockSurface);
		scene.idle(50);
	}

	public static void creative(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("creative_fluid_tank", "Creative Fluid Tanks");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		Selection largeCog = util.select.position(5, 0, 2);
		Selection cTank = util.select.fromTo(3, 1, 1, 3, 2, 1);
		Selection tank = util.select.fromTo(1, 1, 3, 1, 3, 3);
		Selection pipes = util.select.fromTo(3, 1, 2, 2, 1, 3);
		Selection cog = util.select.position(4, 1, 2);
		BlockPos cTankPos = util.grid.at(3, 1, 1);
		BlockPos pumpPos = util.grid.at(3, 1, 2);

		ElementLink<WorldSectionElement> cTankLink = scene.world.showIndependentSection(cTank, Direction.DOWN);
		scene.world.moveSection(cTankLink, util.vector.of(-1, 0, 1), 0);

		scene.overlay.showText(70)
			.text("Creative Fluid Tanks can be used to provide a bottomless supply of fluid")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.WEST));
		scene.idle(80);

		ItemStack bucket = new ItemStack(Items.LAVA_BUCKET);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH), Pointing.RIGHT)
				.rightClick()
				.withItem(bucket),
			40);
		scene.idle(7);
		scene.world.modifyBlockEntity(cTankPos, CreativeFluidTankBlockEntity.class,
			be -> ((CreativeSmartFluidTank) be.getTankInventory())
				.setContainedFluid(new FluidStack(Fluids.FLOWING_LAVA, 1000)));
		scene.idle(5);

		scene.overlay.showText(50)
			.text("Right-Click with a fluid containing item to configure it")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.WEST));
		scene.idle(60);
		scene.world.moveSection(cTankLink, util.vector.of(1, 0, -1), 6);
		scene.idle(7);
		scene.world.showSection(tank, Direction.DOWN);
		scene.idle(5);
		
		scene.rotateCameraY(-30);

		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(cog, Direction.NORTH);
		scene.world.showSection(pipes, Direction.NORTH);
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.SOUTH), false);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(40);

		scene.overlay.showText(70)
			.text("Pipe Networks can now endlessly draw the assigned fluid from the tank")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 2), Direction.WEST));
		scene.idle(120);

		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.NORTH), true);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(40);

		scene.overlay.showText(70)
			.text("Any Fluids pushed back into a Creative Fluid Tank will be voided")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 2), Direction.WEST));
		scene.idle(40);

	}

}
//文件scenes/fluid/HosePulleyScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.simibubi.create.content.fluids.hosePulley.HosePulleyBlockEntity;
import com.simibubi.create.content.fluids.hosePulley.HosePulleyFluidHandler;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class HosePulleyScenes {

	public static void intro(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("hose_pulley", "Source Filling and Draining using Hose Pulleys");
		scene.configureBasePlate(0, 0, 3);
		scene.setSceneOffsetY(-1);
		scene.scaleSceneView(.9f);
		scene.showBasePlate();
		scene.idle(5);

		Selection cogs = util.select.fromTo(3, 1, 2, 3, 2, 2);
		Selection pipes = util.select.fromTo(3, 1, 1, 3, 5, 1)
			.add(util.select.position(2, 5, 1));
		BlockPos hosePos = util.grid.at(1, 5, 1);
		Selection hose = util.select.position(1, 5, 1);
		Selection crank = util.select.position(0, 5, 1);

		ElementLink<WorldSectionElement> hoselink = scene.world.showIndependentSection(hose, Direction.UP);
		scene.world.moveSection(hoselink, util.vector.of(0, -1, 0), 0);
		scene.idle(10);

		Vec3 shaftInput = util.vector.blockSurface(hosePos.below(), Direction.WEST);
		scene.overlay.showText(70)
			.text("Hose Pulleys can be used to fill or drain large bodies of Fluid")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(hosePos.below()));
		scene.idle(80);

		scene.overlay.showText(80)
			.text("With the Kinetic Input, the height of the pulleys' hose can be controlled")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(shaftInput);
		scene.idle(40);

		scene.world.showSectionAndMerge(crank, Direction.EAST, hoselink);
		scene.idle(20);

		Selection kinetics = util.select.fromTo(1, 5, 1, 0, 5, 1);
		scene.world.setKineticSpeed(kinetics, 32);
		scene.idle(50);

		scene.world.setKineticSpeed(kinetics, 0);
		scene.overlay.showText(80)
			.text("The Pulley retracts while the input rotation is inverted")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.centerOf(hosePos.below(3)));
		scene.idle(30);

		scene.world.setKineticSpeed(kinetics, -32);
		scene.idle(16);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(10);
		scene.rotateCameraY(70);
		scene.idle(40);

		scene.overlay.showText(60)
			.text("On the opposite side, pipes can be connected")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(hosePos.below(), Direction.EAST));
		scene.idle(70);

		scene.rotateCameraY(-70);
		scene.idle(10);

		scene.world.showSectionAndMerge(cogs, Direction.NORTH, hoselink);
		scene.world.showSectionAndMerge(pipes, Direction.WEST, hoselink);
		scene.world.showSection(util.select.fromTo(0, 1, 0, 2, 2, 2), Direction.UP);
		scene.idle(10);

		scene.overlay.showText(70)
			.text("Attached pipe networks can either provide fluid to the hose...")
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(util.grid.at(3, 1, 1)));
		scene.idle(40);

		List<BlockPos> blocks = new LinkedList<>();
		for (int y = 1; y < 3; y++) {
			blocks.add(util.grid.at(1, y, 1));
			blocks.add(util.grid.at(0, y, 1));
			blocks.add(util.grid.at(1, y, 0));
			blocks.add(util.grid.at(2, y, 1));
			blocks.add(util.grid.at(1, y, 2));
			blocks.add(util.grid.at(0, y, 0));
			blocks.add(util.grid.at(2, y, 0));
			blocks.add(util.grid.at(2, y, 2));
			blocks.add(util.grid.at(0, y, 2));
		}

		for (BlockPos blockPos : blocks) {
			scene.world.setBlock(blockPos, Blocks.WATER.defaultBlockState(), false);
			scene.idle(3);
		}

		scene.world.modifyBlockEntity(util.grid.at(1, 5, 1), HosePulleyBlockEntity.class, be -> be
			.getCapability(ForgeCapabilities.FLUID_HANDLER)
			.ifPresent(
				ifh -> ((HosePulleyFluidHandler) ifh).fill(new FluidStack(Fluids.WATER, 100), FluidAction.EXECUTE)));

		scene.idle(20);
		scene.world.modifyBlock(util.grid.at(3, 2, 1), s -> s.setValue(PumpBlock.FACING, Direction.DOWN), true);
		scene.world.propagatePipeChange(util.grid.at(3, 2, 1));
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 32);
		scene.idle(16);
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(5);
		scene.overlay.showText(70)
			.text("...or pull from it, draining the pool instead")
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(util.grid.at(3, 1, 1)));
		scene.idle(40);

		Collections.reverse(blocks);
		for (BlockPos blockPos : blocks) {
			scene.world.destroyBlock(blockPos);
			scene.idle(3);
		}

		scene.idle(20);
		scene.overlay.showText(120)
			.text("Fill and Drain speed of the pulley depends entirely on the fluid networks' throughput")
			.placeNearTarget()
			.colored(PonderPalette.MEDIUM)
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(util.grid.at(3, 1, 1)));
		scene.idle(40);
		scene.markAsFinished();

	}

	public static void level(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("hose_pulley_level", "Fill and Drain level of Hose Pulleys");
		scene.configureBasePlate(0, 0, 3);
		scene.setSceneOffsetY(-1.5f);
		scene.scaleSceneView(.9f);
		scene.showBasePlate();

		List<BlockPos> blocks = new LinkedList<>();
		for (int y = 1; y < 4; y++) {
			blocks.add(util.grid.at(1, y, 1));
			blocks.add(util.grid.at(0, y, 1));
			blocks.add(util.grid.at(1, y, 0));
			blocks.add(util.grid.at(2, y, 1));
			blocks.add(util.grid.at(1, y, 2));
			blocks.add(util.grid.at(0, y, 0));
			blocks.add(util.grid.at(2, y, 0));
			blocks.add(util.grid.at(2, y, 2));
			blocks.add(util.grid.at(0, y, 2));
		}

		for (BlockPos blockPos : blocks)
			scene.world.setBlock(blockPos, Blocks.WATER.defaultBlockState(), false);
		scene.idle(5);

		Selection water = util.select.fromTo(2, 1, 0, 0, 4, 2);
		scene.world.showSection(water, Direction.UP);
		scene.idle(10);

		Selection cogs = util.select.fromTo(3, 1, 2, 3, 2, 2);
		Selection pipes = util.select.fromTo(3, 1, 1, 3, 6, 1)
			.add(util.select.position(2, 6, 1));
		BlockPos hosePos = util.grid.at(1, 6, 1);
		Selection hose = util.select.position(1, 6, 1);
		Selection crank = util.select.position(0, 6, 1);

		ElementLink<WorldSectionElement> hoselink = scene.world.showIndependentSection(hose, Direction.DOWN);
		scene.world.moveSection(hoselink, util.vector.of(0, -1, 0), 0);
		scene.idle(10);

		scene.world.showSectionAndMerge(crank, Direction.EAST, hoselink);
		scene.idle(20);

		scene.overlay.showSelectionWithText(util.select.position(hosePos.below()), 50)
			.text("While fully retracted, the Hose Pulley cannot operate")
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(hosePos.below(), Direction.UP));
		scene.idle(55);

		scene.world.modifyBlock(util.grid.at(3, 2, 1), s -> s.setValue(PumpBlock.FACING, Direction.DOWN), false);
		Selection kinetics = util.select.fromTo(1, 6, 1, 0, 6, 1);
		scene.world.setKineticSpeed(kinetics, 32);
		scene.idle(50);

		scene.world.setKineticSpeed(kinetics, 0);
		scene.overlay.showText(40)
			.text("Draining runs from top to bottom")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.centerOf(hosePos.below(3)));
		scene.idle(10);

		scene.world.showSectionAndMerge(cogs, Direction.NORTH, hoselink);
		scene.world.showSectionAndMerge(pipes, Direction.WEST, hoselink);
		scene.world.modifyBlockEntity(util.grid.at(1, 6, 1), HosePulleyBlockEntity.class,
			be -> be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(
					fh -> ((HosePulleyFluidHandler) fh).fill(new FluidStack(Fluids.WATER, 100), FluidAction.EXECUTE)));
		scene.world.propagatePipeChange(util.grid.at(3, 2, 1));

		Vec3 surface = util.vector.topOf(1, 3, 1)
			.subtract(0, 2 / 8f, 0);
		AABB bb = new AABB(surface, surface).inflate(1.5, 0, 1.5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, bb, bb, 3);
		scene.idle(3);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, bb, bb.expandTowards(0, -2, 0), 70);
		scene.idle(20);

		Collections.reverse(blocks);
		int i = 0;
		for (BlockPos blockPos : blocks) {
			if (i++ == 18)
				break;
			scene.world.destroyBlock(blockPos);
			scene.idle(3);
		}

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, bb, bb.move(0, -2, 0), 60);
		scene.overlay.showText(60)
			.text("The surface level will end up just below where the hose ends")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.of(0, 2 - 1 / 8f, 1.5f));
		scene.idle(30);

		scene.idle(30);
		scene.world.hideSection(water, Direction.SOUTH);
		scene.idle(15);
		for (BlockPos blockPos : blocks)
			scene.world.destroyBlock(blockPos);
		scene.world.showSection(water, Direction.UP);
		scene.idle(15);
		scene.world.setKineticSpeed(kinetics, -32);
		scene.world.modifyBlock(util.grid.at(3, 2, 1), s -> s.setValue(PumpBlock.FACING, Direction.UP), true);
		scene.world.propagatePipeChange(util.grid.at(3, 2, 1));
		scene.idle(16);
		scene.world.setKineticSpeed(kinetics, 0);

		scene.overlay.showText(40)
			.text("Filling runs from bottom to top")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.centerOf(hosePos.below(3)));
		scene.idle(10);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, bb, bb.move(0, -3 + 2 / 8f, 0), 3);
		scene.idle(3);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, bb, bb.expandTowards(0, -3 + 2 / 8f, 0), 120);
		scene.idle(20);

		scene.world.setBlock(util.grid.at(1, 3, 1), Blocks.WATER.defaultBlockState(), false);
		scene.idle(3);
		scene.world.setBlock(util.grid.at(1, 2, 1), Blocks.WATER.defaultBlockState(), false);
		scene.idle(3);

		Collections.reverse(blocks);
		for (BlockPos blockPos : blocks) {
			scene.world.setBlock(blockPos, Blocks.WATER.defaultBlockState(), false);
			scene.idle(3);
		}

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, bb, bb, 100);
		scene.overlay.showText(100)
			.text("The filled pool will not grow beyond the layer above the hose end")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.of(0, 4 - 1 / 8f, 1.5f));
		scene.idle(80);
	}

	public static void infinite(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("hose_pulley_infinite", "Passively Filling and Draining large bodies of Fluid");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-.5f);
		scene.scaleSceneView(.9f);
		scene.showBasePlate();
		scene.idle(5);

		Selection tank = util.select.fromTo(4, 1, 1, 4, 3, 1);
		Selection pipes = util.select.fromTo(3, 1, 1, 2, 3, 2);
		Selection kinetics = util.select.fromTo(5, 1, 2, 4, 2, 2)
			.add(util.select.position(5, 0, 2));
		Selection hose = util.select.fromTo(1, 3, 2, 0, 3, 2);
		BlockPos pumpPos = util.grid.at(3, 2, 2);

		scene.world.multiplyKineticSpeed(kinetics, 0.25f);
		scene.world.multiplyKineticSpeed(util.select.position(pumpPos), 0.25f);

		scene.world.showSection(hose, Direction.UP);
		scene.idle(5);
		scene.world.showSection(tank, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(pipes, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(kinetics, Direction.DOWN);
		scene.idle(10);

		scene.world.setKineticSpeed(hose, 32);
		scene.idle(10);

		Vec3 entryPoint = util.vector.topOf(1, 0, 2);
		scene.overlay.showText(60)
			.text("When deploying the Hose Pulley into a large enough ocean...")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(entryPoint);

		scene.idle(40);
		scene.world.modifyBlockEntity(util.grid.at(1, 3, 2), HosePulleyBlockEntity.class,
			be -> be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(
					fh -> ((HosePulleyFluidHandler) fh).fill(new FluidStack(Fluids.WATER, 1000), FluidAction.EXECUTE)));
		scene.world.setKineticSpeed(hose, 0);
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.DOWN), true);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(30);

		Selection pulleyPos = util.select.position(1, 3, 2);
		scene.overlay.showSelectionWithText(pulleyPos, 60)
			.text("It will provide/dispose fluids without affecting the source")
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(1, 3, 2)));

		scene.idle(60);

		scene.world.modifyBlockEntity(util.grid.at(4, 1, 1), FluidTankBlockEntity.class, be -> be.getTankInventory()
			.fill(new FluidStack(Fluids.WATER, 24000), FluidAction.EXECUTE));

		scene.idle(20);

		scene.overlay.showText(60)
			.text("Pipe networks can limitlessly take fluids from/to such pulleys")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 2), Direction.WEST));
		scene.idle(40);
	}

}
//文件scenes/fluid/PipeScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllFluids;
import com.simibubi.create.content.fluids.drain.ItemDrainBlockEntity;
import com.simibubi.create.content.fluids.pipes.AxisPipeBlock;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.GlassFluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.SmartFluidPipeBlockEntity;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveBlock;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveBlockEntity;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class PipeScenes {

	public static void flow(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("fluid_pipe_flow", "Moving Fluids using Copper Pipes");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		BlockState pipeState = AllBlocks.FLUID_PIPE.getDefaultState()
			.setValue(FluidPipeBlock.UP, false)
			.setValue(FluidPipeBlock.DOWN, false);

		scene.world.setBlock(util.grid.at(2, 1, 1), pipeState.setValue(FluidPipeBlock.NORTH, false)
			.setValue(FluidPipeBlock.SOUTH, false), false);
		scene.world.setBlock(util.grid.at(1, 1, 2), pipeState.setValue(FluidPipeBlock.WEST, false)
			.setValue(FluidPipeBlock.EAST, false), false);

		Selection largeCog = util.select.position(5, 0, 1);
		Selection kinetics = util.select.fromTo(5, 1, 0, 3, 1, 0);
		Selection tank = util.select.fromTo(4, 1, 2, 4, 2, 2);
		Selection tank2 = util.select.fromTo(0, 1, 3, 0, 2, 3);

		Selection strayPipes = util.select.fromTo(2, 1, 2, 2, 2, 2)
			.add(util.select.fromTo(1, 2, 2, 1, 3, 2));

		scene.world.showSection(tank, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(tank2, Direction.DOWN);
		FluidStack content = new FluidStack(Fluids.LAVA, 10000);
		scene.world.modifyBlockEntity(util.grid.at(4, 1, 2), FluidTankBlockEntity.class, be -> be.getTankInventory()
			.fill(content, FluidAction.EXECUTE));
		scene.idle(10);

		for (int i = 4; i >= 1; i--) {
			scene.world.showSection(util.select.position(i, 1, 1), i == 4 ? Direction.SOUTH : Direction.EAST);
			scene.idle(3);
		}

		scene.overlay.showText(60)
			.text("Fluid Pipes can connect two or more fluid sources and targets")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(1, 1, 1));

		for (int i = 2; i <= 3; i++) {
			scene.world.showSection(util.select.position(1, 1, i), Direction.NORTH);
			scene.idle(3);
		}

		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(2, 1, 1), Pointing.DOWN).rightClick()
			.withWrench(), 40);
		scene.idle(7);
		scene.world.restoreBlocks(util.select.position(2, 1, 1));
		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(2, 1, 1))
			.placeNearTarget()
			.text("Using a wrench, a straight pipe segment can be given a window");
		scene.idle(40);

		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(1, 1, 2), Pointing.DOWN).rightClick()
			.withWrench(), 10);
		scene.idle(7);
		scene.world.restoreBlocks(util.select.position(1, 1, 2));
		scene.idle(40);

		Vec3 center = util.vector.centerOf(2, 1, 2);
		AABB bb = new AABB(center, center).inflate(1 / 6f);
		AABB bb1 = bb.move(-0.5, 0, 0);
		AABB bb2 = bb.move(0, 0, -0.5);

		scene.world.showSection(strayPipes, Direction.DOWN);
		scene.idle(10);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb1, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb2, bb, 1);
		scene.idle(1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb1, bb1, 50);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb2, bb2, 50);
		scene.idle(10);
		scene.overlay.showText(55)
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(2, 1, 2))
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("Windowed pipes will not connect to any other adjacent pipe segments");
		scene.idle(60);
		scene.world.hideSection(strayPipes, Direction.UP);
		scene.idle(10);

		BlockPos pumpPos = util.grid.at(3, 1, 1);
		scene.world.setBlock(pumpPos, AllBlocks.MECHANICAL_PUMP.getDefaultState()
			.setValue(PumpBlock.FACING, Direction.WEST), true);
		scene.idle(10);
		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(kinetics, Direction.SOUTH);
		scene.idle(10);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 0.25f);
		scene.world.setKineticSpeed(util.select.position(pumpPos), 8);
		scene.world.propagatePipeChange(pumpPos);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(pumpPos))
			.placeNearTarget()
			.text("Powered by Mechanical Pumps, the Pipes can transport Fluids");
		scene.idle(85);
		scene.overlay.showSelectionWithText(tank, 40)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.text("No fluid is being extracted at first");
		scene.idle(70);

		scene.overlay.showOutline(PonderPalette.GREEN, new Object(), tank, 100);
		scene.idle(5);
		scene.overlay.showOutline(PonderPalette.GREEN, new Object(), tank2, 100);
		scene.idle(5);
		scene.overlay.showText(100)
			.attachKeyFrame()
			.independent()
			.text("Once the flow connects them, the endpoints gradually transfer their contents");
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.blockSurface(util.grid.at(4, 2, 2), Direction.WEST),
			util.vector.blockSurface(util.grid.at(0, 2, 3), Direction.EAST), 80);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), 2);
		scene.world.propagatePipeChange(pumpPos);
		scene.effects.rotationSpeedIndicator(pumpPos);

		scene.idle(120);

		scene.overlay.showText(60)
			.text("Thus, the Pipe blocks themselves never 'physically' contain any fluid")
			.placeNearTarget()
			.pointAt(util.vector.topOf(1, 1, 1));
		scene.idle(50);
	}

	public static void interaction(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("fluid_pipe_interaction", "Draining and Filling fluid containers");
		scene.configureBasePlate(0, 1, 5);
		scene.showBasePlate();
		scene.idle(5);

		BlockPos pumpPos = util.grid.at(2, 1, 4);
		Selection largeCog = util.select.position(5, 0, 4);
		Selection kinetics = util.select.fromTo(5, 1, 5, 2, 1, 5);
		Selection pipes = util.select.fromTo(1, 1, 4, 3, 1, 3)
			.add(util.select.position(3, 1, 2));
		Selection tank = util.select.fromTo(4, 1, 3, 4, 2, 3);
		Selection drain = util.select.position(1, 1, 2);
		Selection basin = util.select.position(3, 1, 1);

		Selection waterSourceS = util.select.position(1, 1, 1);
		Selection waterTargetS = util.select.position(4, 1, 1);
		Selection waterTarget2S = util.select.fromTo(4, 0, 0, 4, 1, 0);

		scene.world.setKineticSpeed(util.select.position(pumpPos), 0);

		scene.world.showSection(pipes, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(basin, Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(drain, Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(tank, Direction.WEST);

		scene.overlay.showText(60)
			.text("Endpoints of a pipe network can interact with a variety of blocks")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 3), Direction.NORTH));
		scene.idle(60);
		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(5);
		scene.world.showSection(kinetics, Direction.NORTH);
		scene.idle(10);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 0.5f);
		scene.world.setKineticSpeed(util.select.position(pumpPos), 32);
		BlockPos drainPos = util.grid.at(1, 1, 2);
		scene.world.modifyBlockEntity(drainPos, ItemDrainBlockEntity.class,
			be -> be.getBehaviour(SmartFluidTankBehaviour.TYPE)
				.allowInsertion()
				.getPrimaryHandler()
				.fill(new FluidStack(Fluids.WATER, 1500), FluidAction.EXECUTE));

		scene.idle(50);
		scene.overlay.showOutline(PonderPalette.MEDIUM, new Object(), drain, 40);
		scene.idle(5);
		scene.overlay.showOutline(PonderPalette.MEDIUM, new Object(), tank, 40);
		scene.idle(5);
		scene.overlay.showOutline(PonderPalette.MEDIUM, new Object(), basin, 40);
		scene.idle(5);

		scene.overlay.showText(60)
			.text("Any block with fluid storage capabilities can be filled or drained")
			.attachKeyFrame()
			.colored(PonderPalette.MEDIUM)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(drainPos, Direction.UP));
		scene.idle(100);

		scene.world.hideSection(drain, Direction.NORTH);
		scene.idle(5);
		scene.world.hideSection(tank, Direction.EAST);
		scene.idle(5);
		scene.world.setBlock(drainPos, Blocks.AIR.defaultBlockState(), false);
		scene.world.propagatePipeChange(pumpPos);
		scene.world.hideSection(basin, Direction.NORTH);
		scene.idle(5);
		scene.world.setBlock(util.grid.at(3, 1, 1), Blocks.AIR.defaultBlockState(), false);
		scene.idle(5);
		scene.world.setBlock(util.grid.at(3, 1, 3), AllBlocks.GLASS_FLUID_PIPE.getDefaultState()
			.setValue(AxisPipeBlock.AXIS, Axis.Z), false);
		scene.idle(10);
//		scene.world.multiplyKineticSpeed(util.select.everywhere(), 2);
		scene.world.propagatePipeChange(pumpPos);
		ElementLink<WorldSectionElement> water = scene.world.showIndependentSection(waterSourceS, Direction.DOWN);
		scene.world.moveSection(water, util.vector.of(0, 0, 1), 0);
		scene.idle(10);
		scene.world.setBlock(drainPos, Blocks.WATER.defaultBlockState(), false);
		scene.idle(20);

		scene.overlay.showText(60)
			.text("Source blocks right in front of an open end can be picked up...")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(drainPos, Direction.SOUTH));

		scene.idle(40);
		scene.world.setBlock(drainPos.north(), Blocks.AIR.defaultBlockState(), false);
		scene.idle(40);
		ElementLink<WorldSectionElement> target = scene.world.showIndependentSection(waterTargetS, Direction.UP);
		scene.world.moveSection(target, util.vector.of(-1, 0, 0), 0);
		scene.idle(5);
		scene.world.showSectionAndMerge(waterTarget2S, Direction.UP, target);

		scene.overlay.showText(60)
			.text("...while spilling into empty spaces can create fluid sources")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 2), Direction.NORTH));

		scene.idle(80);
		scene.world.hideIndependentSection(target, Direction.DOWN);
		scene.idle(5);
		scene.world.setBlock(drainPos, Blocks.BEE_NEST.defaultBlockState()
			.setValue(BeehiveBlock.HONEY_LEVEL, 5), false);
		scene.world.showSection(drain, Direction.DOWN);
		scene.world.setBlock(util.grid.at(3, 1, 2), AllBlocks.FLUID_TANK.getDefaultState(), false);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(15);

		scene.overlay.showText(60)
			.text("Pipes can also extract fluids from a handful of other blocks directly")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(drainPos));

		scene.idle(60);
		scene.world.setBlock(drainPos, Blocks.BEE_NEST.defaultBlockState()
			.setValue(BeehiveBlock.HONEY_LEVEL, 0), false);
	}

	public static void encasing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("encased_fluid_pipe", "Encasing Fluid Pipes");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);
		scene.world.showSection(util.select.position(2, 0, 5), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(15);

		BlockState copperEncased = AllBlocks.ENCASED_FLUID_PIPE.getDefaultState()
			.setValue(FluidPipeBlock.SOUTH, true)
			.setValue(FluidPipeBlock.WEST, true);
		ItemStack casingItem = AllBlocks.COPPER_CASING.asStack();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(3, 1, 1), Pointing.DOWN).rightClick()
			.withItem(casingItem), 60);
		scene.idle(7);
		scene.world.setBlock(util.grid.at(3, 1, 1), copperEncased, true);
		scene.idle(10);

		scene.overlay.showText(60)
			.placeNearTarget()
			.text("Copper Casing can be used to decorate Fluid Pipes")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(3, 1, 1));

		scene.idle(70);
		scene.world.destroyBlock(util.grid.at(2, 1, 1));
		scene.world.modifyBlock(util.grid.at(1, 1, 1), s -> s.setValue(FluidPipeBlock.EAST, false)
			.setValue(FluidPipeBlock.NORTH, true), false);
		scene.idle(5);

		scene.overlay.showLine(PonderPalette.RED, util.vector.of(1.5, 1.75, 1), util.vector.of(1.5, 1.75, 2), 80);
		scene.idle(5);
		scene.addKeyframe();
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(3.5, 2, 1.5), util.vector.of(3.5, 2, 2), 80);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(3, 2, 1.5), util.vector.of(3.5, 2, 1.5), 80);

		scene.idle(25);
		scene.overlay.showText(60)
			.placeNearTarget()
			.text("Aside from being concealed, Encased Pipes are locked into their connectivity state")
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 1), Direction.WEST));

		scene.idle(70);
		BlockState defaultState = AllBlocks.FLUID_PIPE.getDefaultState();
		for (BooleanProperty booleanProperty : FluidPipeBlock.PROPERTY_BY_DIRECTION.values())
			defaultState = defaultState.setValue(booleanProperty, false);

		scene.world.setBlock(util.grid.at(3, 2, 1), defaultState.setValue(FluidPipeBlock.EAST, true)
			.setValue(FluidPipeBlock.WEST, true), false);
		scene.world.setBlock(util.grid.at(1, 2, 1), defaultState.setValue(FluidPipeBlock.UP, true)
			.setValue(FluidPipeBlock.DOWN, true), false);
		scene.world.showSection(util.select.layer(2), Direction.DOWN);
		scene.idle(10);
		scene.world.modifyBlock(util.grid.at(1, 1, 1), s -> s.setValue(FluidPipeBlock.UP, true)
			.setValue(FluidPipeBlock.NORTH, false), false);
		scene.idle(20);

		scene.overlay.showText(60)
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("It will no longer react to any neighbouring blocks being added or removed")
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(3, 2, 1));
		scene.idle(20);
	}

	public static void valve(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("valve_pipe", "Controlling Fluid flow using Valves");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		Selection cogs = util.select.fromTo(5, 0, 2, 5, 1, 2);
		Selection tank1 = util.select.fromTo(3, 1, 3, 3, 2, 3);
		Selection tank2 = util.select.fromTo(1, 1, 3, 1, 2, 3);
		BlockPos valvePos = util.grid.at(2, 1, 1);
		BlockPos handlePos = util.grid.at(2, 2, 1);
		BlockPos pumpPos = util.grid.at(4, 1, 2);
		Selection pipes1 = util.select.fromTo(4, 1, 3, 4, 1, 1);
		Selection pipes2 = util.select.fromTo(3, 1, 1, 1, 1, 1);
		Selection pipes3 = util.select.fromTo(0, 1, 1, 0, 1, 3);

		scene.world.setKineticSpeed(pipes1, 0);
		scene.world.propagatePipeChange(pumpPos);
		scene.world.setBlock(valvePos, AllBlocks.FLUID_PIPE.get()
			.getAxisState(Axis.X), false);
		scene.world.setBlock(util.grid.at(3, 1, 1), Blocks.AIR.defaultBlockState(), false);
		scene.world.setBlock(util.grid.at(3, 1, 1), AllBlocks.GLASS_FLUID_PIPE.getDefaultState()
			.setValue(GlassFluidPipeBlock.AXIS, Axis.X), false);

		scene.idle(5);
		scene.world.showSection(tank1, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(tank2, Direction.NORTH);
		scene.idle(10);
		scene.world.showSection(pipes1, Direction.WEST);
		scene.idle(5);
		scene.world.showSection(pipes2, Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(pipes3, Direction.EAST);
		scene.idle(15);

		scene.world.destroyBlock(valvePos);
		scene.world.restoreBlocks(util.select.position(valvePos));

		scene.overlay.showText(60)
			.placeNearTarget()
			.text("Valve pipes help control fluids propagating through pipe networks")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(valvePos, Direction.WEST));
		scene.idle(75);

		scene.world.showSection(cogs, Direction.WEST);
		scene.idle(10);
		scene.world.setKineticSpeed(util.select.position(pumpPos), 64);
		scene.world.propagatePipeChange(pumpPos);

		scene.overlay.showText(60)
			.placeNearTarget()
			.text("Their shaft input controls whether fluid is currently allowed through")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(valvePos));
		scene.idle(60);
		ElementLink<WorldSectionElement> handleLink =
			scene.world.showIndependentSection(util.select.position(handlePos), Direction.DOWN);
		scene.idle(15);

		Selection valveKinetics = util.select.fromTo(2, 1, 1, 2, 2, 1);
		scene.world.setKineticSpeed(valveKinetics, 16);
		scene.world.rotateSection(handleLink, 0, 90, 0, 22);
		scene.effects.rotationSpeedIndicator(handlePos);
		scene.world.modifyBlockEntity(valvePos, FluidValveBlockEntity.class, be -> be.onSpeedChanged(0));
		scene.idle(22);
		scene.world.modifyBlock(valvePos, s -> s.setValue(FluidValveBlock.ENABLED, true), false);
		scene.effects.indicateSuccess(valvePos);
		scene.idle(5);
		scene.world.setKineticSpeed(valveKinetics, 0);

		scene.overlay.showText(60)
			.placeNearTarget()
			.text("Given Rotational Force in the opening direction, the valve will open up")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(valvePos, Direction.NORTH));
		scene.idle(90);

		scene.overlay.showText(50)
			.placeNearTarget()
			.text("It can be closed again by reversing the input rotation")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(valvePos, Direction.NORTH));
		scene.idle(40);

		scene.world.setKineticSpeed(valveKinetics, -16);
		scene.world.rotateSection(handleLink, 0, -90, 0, 22);
		scene.effects.rotationSpeedIndicator(handlePos);
		scene.world.modifyBlockEntity(valvePos, FluidValveBlockEntity.class, be -> be.onSpeedChanged(0));
		scene.idle(22);
		scene.world.modifyBlock(valvePos, s -> s.setValue(FluidValveBlock.ENABLED, false), false);
		scene.effects.indicateRedstone(valvePos);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(5);
		scene.world.setKineticSpeed(valveKinetics, 0);
	}

	public static void smart(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("smart_pipe", "Controlling Fluid flow using Smart Pipes");
		scene.configureBasePlate(1, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		Selection tank1 = util.select.fromTo(4, 1, 3, 4, 2, 3);
		Selection tank2 = util.select.fromTo(4, 1, 4, 4, 2, 4);
		Selection additionalPipes = util.select.fromTo(3, 1, 4, 1, 1, 4);
		Selection mainPipes = util.select.fromTo(3, 1, 3, 1, 1, 1);
		Selection kinetics1 = util.select.fromTo(0, 0, 2, 0, 0, 5);
		Selection kinetics2 = util.select.position(1, 0, 5);
		BlockPos basinPos = util.grid.at(4, 1, 1);
		BlockPos pumpPos = util.grid.at(1, 1, 2);
		Selection pump = util.select.position(1, 1, 2);
		Selection basin = util.select.position(basinPos);
		BlockPos smartPos = util.grid.at(3, 1, 1);
		
		scene.world.modifyBlockEntity(basinPos, BasinBlockEntity.class,
			be -> be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(fh -> fh.fill(new FluidStack(ForgeMod.MILK.get(), 1000), FluidAction.EXECUTE)));

		scene.world.setBlock(util.grid.at(3, 1, 3), AllBlocks.FLUID_PIPE.get()
			.getAxisState(Axis.X), false);
		scene.world.setBlock(smartPos, AllBlocks.FLUID_PIPE.get()
			.getAxisState(Axis.X), false);
		scene.world.setBlock(util.grid.at(2, 1, 3), AllBlocks.GLASS_FLUID_PIPE.getDefaultState()
			.setValue(GlassFluidPipeBlock.AXIS, Axis.X), false);
		scene.world.setBlock(util.grid.at(1, 1, 3), AllBlocks.FLUID_PIPE.get()
			.getAxisState(Axis.X)
			.setValue(FluidPipeBlock.NORTH, true)
			.setValue(FluidPipeBlock.WEST, false), false);

		scene.world.showSection(basin, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(tank1, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(mainPipes, Direction.EAST);
		scene.idle(15);

		scene.world.destroyBlock(smartPos);
		scene.world.restoreBlocks(util.select.position(smartPos));

		Vec3 filterVec = util.vector.topOf(smartPos)
			.subtract(0.25, 0, 0);
		scene.overlay.showText(50)
			.placeNearTarget()
			.text("Smart pipes can help control flows by fluid type")
			.pointAt(filterVec);
		scene.idle(60);

		scene.overlay.showSelectionWithText(util.select.position(basinPos), 80)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("When placed directly at the source, they can specify the type of fluid to extract")
			.attachKeyFrame()
			.pointAt(filterVec);
		scene.idle(90);

		FluidStack chocolate = new FluidStack(FluidHelper.convertToStill(AllFluids.CHOCOLATE.get()), 1000);
		ItemStack bucket = AllFluids.CHOCOLATE.get()
			.getFluidType()
			.getBucket(chocolate);
		ItemStack milkBucket = new ItemStack(Items.MILK_BUCKET);
		scene.overlay.showControls(new InputWindowElement(filterVec, Pointing.DOWN).rightClick()
			.withItem(bucket), 80);
		scene.idle(7);
		scene.world.setFilterData(util.select.position(3, 1, 1), SmartFluidPipeBlockEntity.class, bucket);
		scene.idle(10);
		scene.overlay.showText(60)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Simply Right-Click their filter slot with any item containing the desired fluid")
			.pointAt(filterVec);
		scene.idle(50);

		scene.world.showSection(kinetics2, Direction.WEST);
		scene.world.setKineticSpeed(kinetics2, 24);
		scene.idle(5);
		scene.world.showSection(kinetics1, Direction.EAST);
		scene.world.setKineticSpeed(kinetics1, -24);
		scene.idle(10);
		scene.world.setKineticSpeed(pump, 48);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(100);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(15);
		scene.world.showSection(tank2, Direction.DOWN);
		scene.world.showSection(additionalPipes, Direction.NORTH);
		scene.world.setBlock(util.grid.at(3, 1, 1), AllBlocks.FLUID_PIPE.get()
			.getAxisState(Axis.X), true);
		scene.idle(10);
		for (int i = 0; i < 3; i++) {
			BlockPos pos = util.grid.at(1 + i, 1, 3);
			scene.world.destroyBlock(pos);
			scene.world.restoreBlocks(util.select.position(pos));
			scene.idle(2);
		}
		scene.idle(15);
		scene.world.modifyBlockEntity(basinPos, BasinBlockEntity.class,
			be -> be.getCapability(ForgeCapabilities.FLUID_HANDLER)
				.ifPresent(fh -> fh.fill(chocolate, FluidAction.EXECUTE)));
		scene.idle(10);

		scene.overlay.showText(80)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("When placed further down a pipe network, smart pipes will only let matching fluids continue")
			.attachKeyFrame()
			.pointAt(filterVec.add(-1, 0, 2));
		scene.idle(90);

		scene.overlay.showControls(new InputWindowElement(filterVec.add(-1, 0, 3), Pointing.DOWN).rightClick()
			.withItem(milkBucket), 30);
		scene.idle(7);
		scene.world.setFilterData(util.select.position(2, 1, 4), SmartFluidPipeBlockEntity.class, milkBucket);
		scene.idle(30);

		scene.overlay.showControls(new InputWindowElement(filterVec.add(-1, 0, 2), Pointing.DOWN).rightClick()
			.withItem(bucket), 30);
		scene.idle(7);
		scene.world.setFilterData(util.select.position(2, 1, 3), SmartFluidPipeBlockEntity.class, bucket);
		scene.idle(30);

		scene.world.setKineticSpeed(kinetics2, 24);
		scene.world.setKineticSpeed(kinetics1, -24);
		scene.world.setKineticSpeed(pump, 48);
		scene.world.propagatePipeChange(pumpPos);
		scene.effects.rotationSpeedIndicator(pumpPos);
		scene.idle(40);
	}

}
//文件scenes/fluid/PumpScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.GlassFluidPipeBlock;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class PumpScenes {

	public static void flow(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_pump_flow", "Fluid Transportation using Mechanical Pumps");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.world.multiplyKineticSpeed(util.select.everywhere(), -1);
		scene.idle(5);

		BlockPos pumpPos = util.grid.at(2, 1, 1);
		Selection tank1 = util.select.fromTo(0, 2, 3, 0, 1, 3);
		Selection tank2 = util.select.fromTo(4, 2, 3, 4, 1, 3);
		Selection pipes = util.select.fromTo(3, 1, 3, 1, 1, 1);
		Selection largeCog = util.select.position(5, 0, 1);
		Selection kinetics = util.select.fromTo(5, 1, 0, 2, 1, 0);
		BlockPos leverPos = util.grid.at(4, 2, 0);
		Selection pump = util.select.position(pumpPos);

		scene.world.setBlock(pumpPos, AllBlocks.FLUID_PIPE.get()
			.getAxisState(Axis.X), false);

		scene.world.showSection(tank1, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(tank2, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(pipes, Direction.NORTH);
		scene.idle(15);

		scene.world.destroyBlock(pumpPos);
		scene.world.restoreBlocks(pump);
		scene.world.setKineticSpeed(pump, 0);

		scene.idle(15);

		scene.overlay.showText(60)
			.text("Mechanical Pumps govern the flow of their attached pipe networks")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(pumpPos));

		scene.idle(70);
		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(5);
		scene.world.showSection(kinetics, Direction.SOUTH);
		scene.world.showSection(util.select.position(leverPos), Direction.SOUTH);
		scene.idle(10);
		scene.world.setKineticSpeed(pump, 64);
		scene.world.propagatePipeChange(pumpPos);
		scene.effects.rotationDirectionIndicator(pumpPos.north());
		scene.idle(15);

		scene.overlay.showText(60)
			.text("Their arrow indicates the direction of flow")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(pumpPos)
				.subtract(0.5f, 0.125f, 0));

		AABB bb1 = new AABB(Vec3.ZERO, Vec3.ZERO).inflate(.25, .25, 0)
			.move(0, 0, .25);
		AABB bb2 = new AABB(Vec3.ZERO, Vec3.ZERO).inflate(.25, .25, 1.25);
		scene.idle(65);

		Object in = new Object();
		Object out = new Object();

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, in, bb1.move(util.vector.centerOf(3, 1, 3)), 3);
		scene.idle(2);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, in, bb2.move(util.vector.centerOf(3, 1, 2)), 50);
		scene.idle(10);

		scene.overlay.showText(50)
			.text("The network behind is now pulling fluids...")
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.INPUT)
			.pointAt(util.vector.centerOf(3, 1, 2));

		scene.idle(60);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, out, bb1.move(util.vector.centerOf(1, 1, 1)
			.add(0, 0, -.5)), 3);
		scene.idle(2);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, out, bb2.move(util.vector.centerOf(1, 1, 2)), 50);
		scene.idle(10);

		scene.overlay.showText(50)
			.text("...while the network in front is transferring it outward")
			.placeNearTarget()
			.colored(PonderPalette.OUTPUT)
			.pointAt(util.vector.centerOf(1, 1, 2));

		scene.idle(70);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 2, 0, 4, 1, 0));
		scene.effects.indicateRedstone(leverPos);
		scene.world.multiplyKineticSpeed(util.select.fromTo(3, 1, 0, 2, 1, 1), -1);
		scene.effects.rotationDirectionIndicator(pumpPos.north());
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(15);

		scene.overlay.showText(60)
			.text("The pumps direction is unaffected by the input rotation")
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.topOf(pumpPos)
				.subtract(0.5f, 0.125f, 0));

		scene.idle(25);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, in, new AABB(leverPos.below()), 30);
		scene.idle(45);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(pumpPos), Pointing.DOWN).rightClick()
			.withWrench(), 40);
		scene.idle(7);
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.EAST), true);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(2, 1, 1))
			.placeNearTarget()
			.text("Instead, a Wrench can be used to reverse the direction");
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(40);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, in, bb1.move(util.vector.centerOf(3, 1, 3)), 3);
		scene.idle(2);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.INPUT, in, bb2.move(util.vector.centerOf(3, 1, 2)), 30);
		scene.idle(15);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, out, bb1.move(util.vector.centerOf(1, 1, 1)
			.add(0, 0, -.5)), 3);
		scene.idle(2);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, out, bb2.move(util.vector.centerOf(1, 1, 2)), 30);
		scene.idle(25);

	}

	public static void speed(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_pump_speed", "Throughput of Mechanical Pumps");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);
//		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);

		Selection largeCog = util.select.position(5, 0, 3);
		Selection cogs = util.select.fromTo(5, 1, 4, 2, 1, 4)
			.add(util.select.position(2, 1, 3));
		BlockPos pumpPos = util.grid.at(2, 1, 2);
		Selection pump = util.select.position(pumpPos);
		Selection tank1 = util.select.fromTo(4, 1, 2, 4, 2, 2);
		Selection tank2 = util.select.fromTo(0, 1, 2, 0, 2, 2);
		Selection megapipe1 = util.select.fromTo(0, 3, 5, 1, 4, 2);
		Selection megapipe2 = util.select.fromTo(3, 3, 1, 5, 6, 2);
		
		scene.world.modifyBlock(pumpPos, s -> s.setValue(PumpBlock.FACING, Direction.WEST), false);
		scene.world.modifyBlockEntity(util.grid.at(0, 1, 2), FluidTankBlockEntity.class, be -> be.getTankInventory()
			.drain(3000, FluidAction.EXECUTE));
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 0.125f);

		BlockPos east = pumpPos.east();
		scene.world.setBlock(east, Blocks.AIR.defaultBlockState(), false);
		scene.world.setBlock(east, AllBlocks.GLASS_FLUID_PIPE.getDefaultState()
			.setValue(GlassFluidPipeBlock.AXIS, Axis.X), false);

		scene.world.setBlock(pumpPos.south(), AllBlocks.COGWHEEL.getDefaultState()
			.setValue(CogWheelBlock.AXIS, Axis.X), false);
		Selection southPump = util.select.position(pumpPos.south());
		scene.world.setKineticSpeed(southPump, 4);

		scene.world.setKineticSpeed(pump, 0);
		scene.world.showSection(pump, Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> mp1 = scene.world.showIndependentSection(megapipe1, Direction.EAST);
		scene.world.moveSection(mp1, util.vector.of(0, -3, 0), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> mp2 = scene.world.showIndependentSection(megapipe2, Direction.WEST);
		scene.world.moveSection(mp2, util.vector.of(0, -3, 0), 0);
		scene.idle(15);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(pumpPos))
			.placeNearTarget()
			.text("Regardless of speed, Mechanical Pumps affect pipes connected up to 16 blocks away");
		scene.idle(75);

		scene.world.hideIndependentSection(mp1, Direction.WEST);
		scene.idle(5);
		scene.world.hideIndependentSection(mp2, Direction.EAST);
		scene.idle(15);

		scene.world.showSection(tank1, Direction.DOWN);
		scene.idle(2);
		scene.world.showSection(util.select.position(east), Direction.DOWN);
		scene.idle(5);
		BlockPos west = pumpPos.west();
		scene.world.showSection(util.select.position(west), Direction.DOWN);
		scene.idle(2);
		scene.world.showSection(tank2, Direction.DOWN);
		scene.idle(5);

		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(cogs, Direction.SOUTH);
		scene.idle(10);
		scene.world.setKineticSpeed(util.select.position(pumpPos), -4);
		scene.effects.rotationSpeedIndicator(pumpPos);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(40);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), 8);
		scene.effects.rotationSpeedIndicator(pumpPos);
		scene.world.propagatePipeChange(pumpPos);
		scene.idle(20);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(pumpPos))
			.placeNearTarget()
			.text("Speeding up the input rotation changes the speed of flow propagation...");
		scene.idle(70);

		scene.overlay.showText(50)
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 2), Direction.WEST))
			.placeNearTarget()
			.text("...and the speed at which fluids are transferred");
		scene.idle(60);

		BlockState pipeState = AllBlocks.FLUID_PIPE.getDefaultState()
			.setValue(FluidPipeBlock.DOWN, false)
			.setValue(FluidPipeBlock.UP, false);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.idle(10);

		scene.world.setBlock(east, pipeState, true);
		scene.world.setBlock(west, pipeState, true);

		scene.world.setBlock(east.north(), pipeState.setValue(FluidPipeBlock.NORTH, false)
			.setValue(FluidPipeBlock.EAST, false), false);
		scene.world.setBlock(east.south(), pipeState.setValue(FluidPipeBlock.SOUTH, false)
			.setValue(FluidPipeBlock.EAST, false), false);
		scene.world.showSection(util.select.position(east.north()), Direction.DOWN);
		scene.world.showSection(util.select.position(east.south()), Direction.DOWN);
		Selection northPump = util.select.position(pumpPos.north());

		scene.world.setBlock(west.north(), pipeState.setValue(FluidPipeBlock.NORTH, false)
			.setValue(FluidPipeBlock.WEST, false), false);
		scene.world.setBlock(west.south(), pipeState.setValue(FluidPipeBlock.SOUTH, false)
			.setValue(FluidPipeBlock.WEST, false), false);
		scene.world.showSection(util.select.position(west.north()), Direction.DOWN);
		scene.world.showSection(util.select.position(west.south()), Direction.DOWN);

		scene.world.restoreBlocks(southPump);
		scene.world.modifyBlock(pumpPos.south(), s -> s.setValue(PumpBlock.FACING, Direction.WEST), true);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.world.showSection(northPump, Direction.DOWN);
		scene.world.modifyBlock(pumpPos.north(), s -> s.setValue(PumpBlock.FACING, Direction.EAST), false);
		scene.idle(4);

		scene.world.setKineticSpeed(util.select.everywhere(), -16);
		scene.world.setKineticSpeed(northPump, 16);
		scene.world.setKineticSpeed(southPump, 16);
		scene.world.setKineticSpeed(largeCog, 8);
		scene.idle(20);

		scene.overlay.showSelectionWithText(util.select.fromTo(2, 1, 1, 2, 1, 3), 60)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.topOf(pumpPos))
			.placeNearTarget()
			.text("Pumps can combine their throughputs within shared pipe networks");
		scene.idle(70);

		scene.idle(30);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(pumpPos.north()), Pointing.DOWN).rightClick()
				.withWrench(), 30);
		scene.idle(7);
		scene.world.modifyBlock(pumpPos.north(), s -> s.setValue(PumpBlock.FACING, Direction.WEST), true);
		scene.idle(30);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(pumpPos.north())
				.subtract(0.5f, 0.125f, 0))
			.placeNearTarget()
			.text("Ensure that all of them are facing in the same direction");
		scene.idle(40);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), 4);
		scene.effects.rotationSpeedIndicator(pumpPos);
		scene.effects.rotationSpeedIndicator(pumpPos.north());
		scene.effects.rotationSpeedIndicator(pumpPos.south());
		scene.world.propagatePipeChange(pumpPos);
		scene.world.propagatePipeChange(pumpPos.north());
		scene.world.propagatePipeChange(pumpPos.south());
		scene.idle(100);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), -1);
		scene.effects.rotationSpeedIndicator(pumpPos);
		scene.effects.rotationSpeedIndicator(pumpPos.north());
		scene.effects.rotationSpeedIndicator(pumpPos.south());
		scene.world.propagatePipeChange(pumpPos);
		scene.world.propagatePipeChange(pumpPos.north());
		scene.world.propagatePipeChange(pumpPos.south());
	}

}
//文件scenes/fluid/SpoutScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.fluid;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.fluids.FluidFX;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.Pointing;
import com.simibubi.create.foundation.utility.VecHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidStack;

public class SpoutScenes {

	public static void filling(SceneBuilder scene, SceneBuildingUtil util) {
		RandomSource random = RandomSource.create();

		scene.title("spout_filling", "Filling Items using a Spout");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		ElementLink<WorldSectionElement> depot =
			scene.world.showIndependentSection(util.select.position(2, 1, 1), Direction.DOWN);
		scene.world.moveSection(depot, util.vector.of(0, 0, 1), 0);
		scene.idle(10);
		
		scene.world.modifyBlock(util.grid.at(2, 3, 3), s -> s.setValue(PumpBlock.FACING, Direction.NORTH), false);

		Selection largeCog = util.select.position(3, 0, 5);
		Selection kinetics = util.select.fromTo(2, 1, 5, 2, 2, 3);
		Selection tank = util.select.fromTo(1, 1, 4, 1, 2, 4);
		Selection pipes = util.select.fromTo(1, 3, 4, 2, 3, 3);

		Selection spoutS = util.select.position(2, 3, 2);
		BlockPos spoutPos = util.grid.at(2, 3, 2);
		BlockPos depotPos = util.grid.at(2, 1, 1);
		scene.world.showSection(spoutS, Direction.DOWN);
		scene.idle(10);

		Vec3 spoutSide = util.vector.blockSurface(spoutPos, Direction.WEST);
		scene.overlay.showText(60)
			.pointAt(spoutSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Spout can fill fluid holding items provided beneath it");

		scene.idle(50);

		scene.world.showSection(tank, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(kinetics, Direction.NORTH);
		scene.world.showSection(pipes, Direction.NORTH);

		scene.idle(20);
		FluidStack honey = new FluidStack(FluidHelper.convertToStill(AllFluids.HONEY.get()), 1000);
		ItemStack bucket = AllFluids.HONEY.get()
			.getFluidType()
			.getBucket(honey);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH), Pointing.RIGHT)
				.showing(AllIcons.I_MTD_CLOSE)
				.withItem(bucket),
			40);
		scene.idle(7);
		scene.overlay.showSelectionWithText(util.select.position(2, 3, 2), 50)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.WEST))
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.text("The content of a Spout cannot be accessed manually");
		scene.idle(60);
		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 3), Direction.WEST))
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.text("Instead, Pipes can be used to supply it with fluids");

		scene.idle(90);
		scene.overlay.showText(60)
			.pointAt(spoutSide.subtract(0, 2, 0))
			.attachKeyFrame()
			.placeNearTarget()
			.text("The Input items can be placed on a Depot under the Spout");
		scene.idle(50);
		ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
		scene.world.createItemOnBeltLike(depotPos, Direction.NORTH, bottle);
		Vec3 depotCenter = util.vector.centerOf(depotPos.south());
		scene.overlay.showControls(new InputWindowElement(depotCenter, Pointing.UP).withItem(bottle), 30);
		scene.idle(10);

		scene.idle(20);
		scene.world.modifyBlockEntityNBT(spoutS, SpoutBlockEntity.class, nbt -> nbt.putInt("ProcessingTicks", 20));
		scene.idle(20);
		scene.world.removeItemsFromBelt(depotPos);
		ItemStack potion = new ItemStack(Items.HONEY_BOTTLE);
		scene.world.createItemOnBeltLike(depotPos, Direction.UP, potion);
		ParticleOptions fluidParticle = FluidFX.getFluidParticle(new FluidStack(AllFluids.HONEY.get(), 1000));
		for (int i = 0; i < 10; i++) {
			scene.effects.emitParticles(util.vector.topOf(depotPos.south())
				.add(0, 1 / 16f, 0),
				Emitter.simple(fluidParticle, VecHelper.offsetRandomly(Vec3.ZERO, random, .1f)), 1, 1);
		}
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(depotCenter, Pointing.UP).withItem(potion), 50);
		scene.idle(60);

		scene.world.hideIndependentSection(depot, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(0, 1, 3, 0, 2, 3), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 0, 2, 2), Direction.SOUTH);
		scene.idle(20);
		BlockPos beltPos = util.grid.at(0, 1, 2);
		scene.overlay.showText(40)
			.pointAt(util.vector.blockSurface(beltPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("When items are provided on a belt...");
		scene.idle(30);

		ElementLink<BeltItemElement> ingot = scene.world.createItemOnBelt(beltPos, Direction.SOUTH, bottle);
		scene.idle(15);
		ElementLink<BeltItemElement> ingot2 = scene.world.createItemOnBelt(beltPos, Direction.SOUTH, bottle);
		scene.idle(15);
		scene.world.stallBeltItem(ingot, true);
		scene.world.modifyBlockEntityNBT(spoutS, SpoutBlockEntity.class, nbt -> nbt.putInt("ProcessingTicks", 20));

		scene.overlay.showText(50)
			.pointAt(spoutSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Spout will hold and process them automatically");

		scene.idle(20);
		for (int i = 0; i < 10; i++) {
			scene.effects.emitParticles(util.vector.topOf(depotPos.south())
				.add(0, 1 / 16f, 0),
				Emitter.simple(fluidParticle, VecHelper.offsetRandomly(Vec3.ZERO, random, .1f)), 1, 1);
		}
		scene.world.removeItemsFromBelt(spoutPos.below(2));
		ingot = scene.world.createItemOnBelt(spoutPos.below(2), Direction.UP, potion);
		scene.world.stallBeltItem(ingot, true);
		scene.idle(5);
		scene.world.stallBeltItem(ingot, false);
		scene.idle(15);
		scene.world.stallBeltItem(ingot2, true);
		scene.world.modifyBlockEntityNBT(spoutS, SpoutBlockEntity.class, nbt -> nbt.putInt("ProcessingTicks", 20));
		scene.idle(20);
		for (int i = 0; i < 10; i++) {
			scene.effects.emitParticles(util.vector.topOf(depotPos.south())
				.add(0, 1 / 16f, 0),
				Emitter.simple(fluidParticle, VecHelper.offsetRandomly(Vec3.ZERO, random, .1f)), 1, 1);
		}
		scene.world.removeItemsFromBelt(spoutPos.below(2));
		ingot2 = scene.world.createItemOnBelt(spoutPos.below(2), Direction.UP, potion);
		scene.world.stallBeltItem(ingot2, true);
		scene.idle(5);
		scene.world.stallBeltItem(ingot2, false);

	}

}
//文件scenes/FunnelScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.logistics.funnel.BeltFunnelBlock;
import com.simibubi.create.content.logistics.funnel.FunnelBlock;
import com.simibubi.create.content.logistics.funnel.FunnelBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

public class FunnelScenes {

	public static void intro(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("funnel_intro", "Using funnels");
		scene.configureBasePlate(0, 1, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> f / 2f);

		scene.idle(10);

		Selection verticalFunnel = util.select.fromTo(2, -1, 4, 2, 4, 4)
			.add(util.select.fromTo(1, 1, 4, 1, 4, 4));
		Selection beltFunnels = util.select.fromTo(1, 2, 2, 3, 2, 2);
		Selection beltFunnelEnv = util.select.fromTo(0, 1, 0, 5, 2, 2)
			.substract(beltFunnels);

		scene.world.showSection(beltFunnelEnv, Direction.DOWN);

		scene.idle(20);
		scene.world.showSection(beltFunnels, Direction.DOWN);

		BlockPos entryBeltPos = util.grid.at(3, 1, 2);
		BlockPos exitBeltPos = util.grid.at(1, 1, 2);
		ItemStack itemStack = AllBlocks.BRASS_BLOCK.asStack();

		for (int i = 0; i < 8; i++) {
			scene.idle(8);
			scene.world.removeItemsFromBelt(exitBeltPos);
			scene.world.flapFunnel(exitBeltPos.above(), false);
			if (i == 2)
				scene.rotateCameraY(70);
			if (i < 6)
				scene.world.createItemOnBelt(entryBeltPos, Direction.EAST, itemStack);
		}

		scene.rotateCameraY(-70);
		scene.idle(10);

		Selection outputFunnel = util.select.position(1, 2, 4);
		scene.world.setBlocks(outputFunnel, Blocks.AIR.defaultBlockState(), false);
		scene.world.setBlocks(util.select.fromTo(2, -1, 4, 2, 0, 4), AllBlocks.ANDESITE_CASING.getDefaultState(), true);
		ElementLink<WorldSectionElement> independentSection =
			scene.world.showIndependentSection(verticalFunnel, Direction.UP);

		Vec3 topItemSpawn = util.vector.centerOf(2, 6, 4);
		Vec3 sideItemSpawn = util.vector.centerOf(1, 3, 4)
			.add(0.15f, -0.45f, 0);
		ElementLink<EntityElement> lastItemEntity = null;

		for (int i = 0; i < 4; i++) {
			if (lastItemEntity != null)
				scene.world.modifyEntity(lastItemEntity, Entity::discard);
			if (i < 3)
				lastItemEntity = scene.world.createItemEntity(topItemSpawn, util.vector.of(0, -0.4, 0), itemStack);
			scene.idle(8);
		}

		scene.world.moveSection(independentSection, util.vector.of(0, 1, 0), 15);
		scene.idle(10);
		scene.world.setBlocks(outputFunnel, AllBlocks.ANDESITE_FUNNEL.getDefaultState()
			.setValue(FunnelBlock.FACING, Direction.WEST)
			.setValue(FunnelBlock.EXTRACTING, true), false);

		for (int i = 0; i < 3; i++) {
			scene.idle(8);
			scene.world.flapFunnel(util.grid.at(1, 2, 4), false);
			scene.world.createItemEntity(sideItemSpawn, util.vector.of(-.05, 0, 0), itemStack);
		}

		scene.idle(8);
		scene.overlay.showText(360)
			.text("Funnels are ideal for transferring items from and to inventories.")
			.independent();
		scene.markAsFinished();
	}

	public static void directionality(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("funnel_direction", "Direction of Transfer");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> f / 2f);
		scene.world.setBlocks(util.select.position(3, 1, 1), AllBlocks.ANDESITE_CASING.getDefaultState(), false);

		BlockPos topFunnel = util.grid.at(3, 3, 2);
		Selection topFunnelSelection = util.select.position(topFunnel);
		Selection firstShow = util.select.fromTo(3, 1, 2, 3, 2, 2);
		scene.idle(5);

		scene.world.showSection(firstShow, Direction.DOWN);
		scene.idle(15);

		ItemStack itemStack = AllBlocks.BRASS_BLOCK.asStack();
		Vec3 topCenter = util.vector.centerOf(topFunnel);
		Vec3 topSide = util.vector.blockSurface(topFunnel, Direction.EAST);

		InputWindowElement controlsSneak = new InputWindowElement(topCenter, Pointing.DOWN).rightClick()
			.whileSneaking();

		// Placing funnels without sneak
		scene.world.showSection(topFunnelSelection, Direction.DOWN);
		scene.overlay.showText(80)
			.text("Placed normally, it pulls items from the inventory.")
			.attachKeyFrame()
			.pointAt(topCenter)
			.placeNearTarget();
		scene.idle(45);

		ElementLink<EntityElement> itemLink =
			scene.world.createItemEntity(topCenter, util.vector.of(0, 4 / 16f, 0), itemStack);
		scene.idle(40);

		scene.world.modifyEntity(itemLink, Entity::discard);
		scene.world.hideSection(topFunnelSelection, Direction.UP);
		scene.idle(20);

		// Placing funnels with sneak
		scene.world.modifyBlock(topFunnel, s -> s.setValue(FunnelBlock.EXTRACTING, false), false);
		scene.idle(5);

		scene.world.showSection(topFunnelSelection, Direction.DOWN);
		scene.overlay.showControls(controlsSneak, 35);
		scene.overlay.showText(80)
			.text("Placed while sneaking, it puts items into the inventory.")
			.attachKeyFrame()
			.pointAt(topCenter)
			.placeNearTarget();
		scene.idle(45);

		itemLink = scene.world.createItemEntity(topCenter.add(0, 3, 0), util.vector.of(0, -0.2, 0), itemStack);
		scene.idle(10);

		scene.world.modifyEntity(itemLink, Entity::discard);
		scene.idle(45);

		// Wrench interaction
		InputWindowElement wrenchControls = new InputWindowElement(topSide, Pointing.RIGHT).rightClick()
			.withWrench();
		scene.overlay.showControls(wrenchControls, 40);
		scene.idle(10);
		scene.world.modifyBlock(topFunnel, s -> s.cycle(FunnelBlock.EXTRACTING), true);
		scene.idle(10);
		scene.overlay.showText(80)
			.text("Using a wrench, the funnel can be flipped after placement.")
			.attachKeyFrame()
			.pointAt(topCenter)
			.placeNearTarget();

		itemLink = scene.world.createItemEntity(topCenter, util.vector.of(0, 4 / 16f, 0), itemStack);
		scene.idle(30);

		scene.overlay.showControls(wrenchControls, 40);
		scene.idle(10);
		scene.world.modifyBlock(topFunnel, s -> s.cycle(FunnelBlock.EXTRACTING), true);
		scene.idle(10);
		scene.world.modifyEntity(itemLink, Entity::discard);

		scene.idle(20);

		// Side funnel
		BlockPos sideFunnel = util.grid.at(3, 2, 1);
		Selection sideFunnelSelection = util.select.fromTo(sideFunnel.below(), sideFunnel);
		Vec3 sideCenter = util.vector.centerOf(sideFunnel);

		scene.world.modifyBlock(sideFunnel, s -> s.cycle(FunnelBlock.EXTRACTING), false);
		scene.world.showSection(sideFunnelSelection, Direction.DOWN);
		scene.overlay.showText(70)
			.text("Same rules will apply for most orientations.")
			.pointAt(sideCenter)
			.placeNearTarget();

		scene.idle(20);

		scene.world.flapFunnel(sideFunnel, true);
		itemLink = scene.world.createItemEntity(sideCenter.subtract(0, .45, 0), util.vector.of(0, 0, -0.1), itemStack);
		scene.idle(60);
		scene.world.hideSection(sideFunnelSelection, Direction.UP);
		scene.world.hideSection(topFunnelSelection, Direction.UP);
		scene.world.modifyEntity(itemLink, Entity::discard);
		scene.idle(20);

		// Belt funnel
		Selection beltFunnelSetup = util.select.fromTo(0, 1, 0, 2, 2, 5);
		Selection gearshiftAndLever = util.select.fromTo(1, 1, 4, 1, 2, 4);
		Selection gearshiftedKinetics = util.select.fromTo(1, 1, 2, 2, 1, 4);
		Vec3 topOfBeltFunnel = util.vector.topOf(2, 2, 2);
		BlockPos beltPos = util.grid.at(2, 1, 2);
		BlockPos cogPos = util.grid.at(1, 1, 3);

		scene.world.showSection(beltFunnelSetup, Direction.DOWN);
		scene.overlay.showText(140)
			.text("Funnels on belts will extract/insert depending on its movement direction.")
			.attachKeyFrame()
			.pointAt(topOfBeltFunnel);

		scene.idle(15);

		for (int i = 0; i < 2; i++) {
			scene.world.createItemOnBelt(beltPos, Direction.EAST, itemStack);
			scene.effects.rotationDirectionIndicator(cogPos);
			scene.idle(50);

			scene.world.modifyBlocks(gearshiftAndLever, s -> s.cycle(BlockStateProperties.POWERED), false);
			scene.world.modifyKineticSpeed(gearshiftedKinetics, f -> -f);
			scene.effects.indicateRedstone(util.grid.at(1, 2, 4));
			scene.effects.rotationDirectionIndicator(cogPos);
			scene.idle(35);

			scene.world.removeItemsFromBelt(beltPos);
			scene.world.flapFunnel(util.grid.at(2, 2, 2), false);

			if (i == 0) {
				scene.idle(50);
				scene.world.modifyBlocks(gearshiftAndLever, s -> s.cycle(BlockStateProperties.POWERED), false);
				scene.world.modifyKineticSpeed(gearshiftedKinetics, f -> -f);
				scene.effects.indicateRedstone(util.grid.at(1, 2, 4));
			}
		}
	}

	public static void compat(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("funnel_compat", "Funnel compatibility");
		scene.configureBasePlate(0, 0, 5);

		BlockPos sawFunnel = util.grid.at(4, 2, 1);
		BlockPos depotFunnel = util.grid.at(2, 2, 2);
		BlockPos drainFunnel = util.grid.at(0, 2, 3);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		Selection firstShow = util.select.layer(1)
			.add(util.select.position(sawFunnel.south()))
			.add(util.select.position(depotFunnel.south()))
			.add(util.select.position(drainFunnel.south()));
		scene.idle(5);

		scene.world.showSection(firstShow, Direction.DOWN);

		scene.idle(8);
		scene.overlay.showText(360)
			.text("Funnels should also interact nicely with a handful of other components.")
			.attachKeyFrame()
			.independent(0);
		scene.idle(40);

		scene.world.showSection(util.select.position(sawFunnel), Direction.DOWN);
		scene.overlay.showText(40)
			.text("Vertical Saws")
			.colored(PonderPalette.BLUE)
			.placeNearTarget()
			.pointAt(util.vector.centerOf(sawFunnel.below()));
		scene.idle(8);
		scene.world.createItemOnBeltLike(sawFunnel.below(), Direction.SOUTH, new ItemStack(Blocks.OAK_LOG));
		scene.idle(40);

		scene.world.showSection(util.select.position(depotFunnel), Direction.DOWN);
		scene.overlay.showText(40)
			.text("Depots")
			.colored(PonderPalette.BLUE)
			.placeNearTarget()
			.pointAt(util.vector.centerOf(depotFunnel.below()));
		scene.idle(8);
		scene.world.createItemOnBeltLike(depotFunnel.below(), Direction.SOUTH, new ItemStack(Items.GOLDEN_PICKAXE));
		scene.idle(40);

		scene.world.showSection(util.select.position(drainFunnel), Direction.DOWN);
		scene.overlay.showText(40)
			.text("Item Drains")
			.colored(PonderPalette.BLUE)
			.placeNearTarget()
			.pointAt(util.vector.centerOf(drainFunnel.below()));
		scene.idle(8);
		scene.world.createItemOnBeltLike(drainFunnel.below(), Direction.SOUTH, new ItemStack(Items.WATER_BUCKET));
		scene.idle(40);

		scene.markAsFinished();
	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("funnel_redstone", "Redstone control");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);

		ItemStack itemStack = AllBlocks.BRASS_BLOCK.asStack();
		Vec3 topItemSpawn = util.vector.centerOf(3, 6, 2);
		ElementLink<EntityElement> lastItemEntity = null;

		BlockPos lever = util.grid.at(1, 2, 2);
		BlockPos redstone = util.grid.at(2, 2, 2);
		BlockPos funnel = util.grid.at(3, 2, 2);

		AABB redstoneBB = new AABB(funnel).inflate(-1 / 16f, -6 / 16f, -1 / 16f)
			.move(0, -5 / 16f, 0);

		for (int i = 0; i < 4; i++) {
			if (lastItemEntity != null)
				scene.world.modifyEntity(lastItemEntity, Entity::discard);
			lastItemEntity = scene.world.createItemEntity(topItemSpawn, util.vector.of(0, -0.2, 0), itemStack);
			scene.idle(8);

			if (i == 3) {
				scene.world.modifyBlock(lever, s -> s.cycle(LeverBlock.POWERED), false);
				scene.world.modifyBlock(redstone, s -> s.setValue(RedStoneWireBlock.POWER, 15), false);
				scene.world.modifyBlock(funnel, s -> s.cycle(FunnelBlock.POWERED), false);
				scene.effects.indicateRedstone(lever);
				scene.idle(4);
				scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, funnel, redstoneBB, 80);
				scene.overlay.showText(80)
					.colored(PonderPalette.RED)
					.text("Redstone power will prevent any funnel from acting")
					.pointAt(util.vector.blockSurface(funnel, Direction.DOWN));
			} else {
				scene.idle(4);
			}
		}

		scene.idle(60);
	}

	public static void brass(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("brass_funnel", "The Brass Funnel");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos firstDepot = util.grid.at(3, 1, 1);
		BlockPos secondDepot = util.grid.at(1, 1, 1);
		Selection depots = util.select.fromTo(firstDepot, secondDepot);
		Selection beltAndStuff = util.select.fromTo(0, 1, 2, 4, 1, 2)
			.add(util.select.fromTo(0, 1, 3, 0, 2, 5));
		Selection withoutBelt = util.select.layersFrom(1)
			.substract(beltAndStuff)
			.substract(depots);

		scene.world.showSection(withoutBelt, Direction.DOWN);
		ElementLink<WorldSectionElement> independentSection =
			scene.world.showIndependentSection(depots, Direction.DOWN);
		scene.world.moveSection(independentSection, util.vector.of(0, 0, 1), 0);

		BlockPos andesiteFunnel = util.grid.at(3, 2, 2);
		BlockPos brassFunnel = util.grid.at(1, 2, 2);
		ItemStack itemStack = AllItems.BRASS_INGOT.asStack();
		scene.idle(10);

		scene.overlay.showText(60)
			.text("Andesite Funnels can only ever extract single items.")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(andesiteFunnel))
			.placeNearTarget();
		scene.idle(10);
		scene.world.createItemOnBeltLike(andesiteFunnel.below()
			.north(), Direction.SOUTH, itemStack);
		scene.world.flapFunnel(andesiteFunnel, true);
		scene.idle(60);

		Vec3 filter = util.vector.topOf(brassFunnel);
		scene.overlay.showText(60)
			.text("Brass Funnels can extract up to a full stack.")
			.attachKeyFrame()
			.pointAt(filter)
			.placeNearTarget();
		scene.idle(10);
		scene.world.createItemOnBeltLike(brassFunnel.below()
			.north(), Direction.SOUTH, ItemHandlerHelper.copyStackWithSize(itemStack, 64));
		scene.world.flapFunnel(brassFunnel, true);
		scene.idle(60);

		filter = filter.add(0, -5 / 16f, -1.5 / 16f);
		scene.overlay.showFilterSlotInput(filter, Direction.NORTH, 80);
		scene.overlay.showControls(new InputWindowElement(filter, Pointing.DOWN).rightClick(), 60);
		scene.idle(10);
		scene.overlay.showText(80)
			.text("The value panel allows for precise control over the extracted stack size.")
			.attachKeyFrame()
			.pointAt(filter)
			.placeNearTarget();
		scene.idle(90);

		// belt
		scene.world.hideIndependentSection(independentSection, Direction.NORTH);
		scene.world.hideSection(util.select.position(brassFunnel), Direction.UP);
		scene.idle(20);

		scene.world.modifyBlock(brassFunnel, s -> s.cycle(BeltFunnelBlock.SHAPE), false);
		scene.world.showSection(util.select.position(brassFunnel), Direction.DOWN);
		scene.world.showSection(beltAndStuff, Direction.SOUTH);
		scene.idle(10);

		ItemStack dirt = new ItemStack(Items.DIRT);
		ItemStack gravel = new ItemStack(Items.GRAVEL);
		ItemStack emerald = new ItemStack(Items.EMERALD);

		for (int i = 0; i < 14; i++) {

			if (i < 12)
				scene.world.createItemOnBelt(andesiteFunnel.below(), Direction.SOUTH,
					i % 3 == 0 ? dirt : i % 3 == 1 ? gravel : emerald);
			scene.idle(10);

			if (i > 0 && (i < 3 || i % 3 == 0)) {
				scene.world.removeItemsFromBelt(brassFunnel.below());
				scene.world.flapFunnel(brassFunnel, false);
			}

			scene.world.modifyEntities(ItemEntity.class, e -> {
				if (e.getY() < 1)
					e.discard();
			});

			if (i == 2) {
				scene.overlay.showFilterSlotInput(filter, Direction.NORTH, 40);
				scene.overlay.showControls(new InputWindowElement(filter, Pointing.DOWN).rightClick()
					.withItem(emerald), 60);
				scene.idle(10);
				scene.overlay.showText(80)
					.text("Using items on the filter slot will restrict the funnel to only transfer matching stacks.")
					.attachKeyFrame()
					.pointAt(filter)
					.placeNearTarget();
				scene.world.setFilterData(util.select.position(brassFunnel), FunnelBlockEntity.class, emerald);
			} else
				scene.idle(10);

			if (i == 8)
				scene.markAsFinished();
		}
	}

	public static void transposer(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("funnel_transfer", "Direct transfer");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos funnelPos = util.grid.at(2, 2, 2);
		Selection funnelSelect = util.select.position(funnelPos);

		ElementLink<WorldSectionElement> rightChest =
			scene.world.showIndependentSection(util.select.position(0, 2, 2), Direction.DOWN);
		ElementLink<WorldSectionElement> leftChest =
			scene.world.showIndependentSection(util.select.position(4, 2, 2), Direction.DOWN);
		scene.world.moveSection(rightChest, util.vector.of(2, 1, 0), 0);
		scene.world.moveSection(leftChest, util.vector.of(-2, -1, 0), 0);
		scene.idle(5);

		scene.world.showSection(funnelSelect, Direction.DOWN);
		scene.idle(20);

		scene.overlay.showSelectionWithText(funnelSelect, 40)
			.colored(PonderPalette.RED)
			.text("Funnels cannot ever transfer between closed inventories directly.")
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(50);

		scene.world.hideSection(funnelSelect, Direction.SOUTH);
		scene.idle(20);

		scene.world.setBlocks(funnelSelect, AllBlocks.CHUTE.getDefaultState(), false);
		scene.world.showSection(funnelSelect, Direction.NORTH);
		scene.idle(10);

		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.text("Chutes or Smart chutes might be more suitable for such purposes.")
			.attachKeyFrame()
			.pointAt(util.vector.centerOf(funnelPos))
			.placeNearTarget();
		scene.idle(50);

		scene.world.hideSection(funnelSelect, Direction.UP);
		scene.world.hideIndependentSection(leftChest, Direction.UP);
		scene.world.hideIndependentSection(rightChest, Direction.UP);
		scene.idle(20);

		Selection belt = util.select.layer(1);
		scene.world.setBlocks(funnelSelect, Blocks.AIR.defaultBlockState(), false);
		scene.world.showSection(belt, Direction.DOWN);
		scene.world.showSection(util.select.fromTo(0, 2, 2, 4, 2, 2), Direction.DOWN);
		scene.overlay.showText(120)
			.colored(PonderPalette.GREEN)
			.text("Same applies for horizontal movement. A mechanical belt should help here.")
			.pointAt(util.vector.topOf(1, 2, 2))
			.placeNearTarget();

		scene.markAsFinished();
	}

}
//文件scenes/GantryScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class GantryScenes {

	public static void introForPinion(SceneBuilder scene, SceneBuildingUtil util) {
		intro(scene, util, true);
	}

	public static void introForShaft(SceneBuilder scene, SceneBuildingUtil util) {
		intro(scene, util, false);
	}

	private static void intro(SceneBuilder scene, SceneBuildingUtil util, boolean pinion) {
		String id = "gantry_" + (pinion ? "carriage" : "shaft");
		String title = "Using Gantry " + (pinion ? "Carriages" : "Shafts");
		scene.title(id, title);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -2 * f);
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> gantry =
			scene.world.showIndependentSection(util.select.layer(2), Direction.DOWN);
		scene.idle(10);

		BlockPos centralShaft = util.grid.at(2, 1, 2);

		scene.world.moveSection(gantry, util.vector.of(-4, 0, 0), 60);

		String text = pinion ? "Gantry Carriages can mount to and slide along a Gantry Shaft."
			: "Gantry Shafts form the basis of a gantry setup. Attached Carriages will move along them.";

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text(text)
			.pointAt(util.vector.centerOf(centralShaft));
		scene.idle(80);

		scene.world.hideIndependentSection(gantry, Direction.UP);
		scene.idle(10);
		gantry = scene.world.showIndependentSection(util.select.layer(2), Direction.DOWN);
		Vec3 gantryTop = util.vector.topOf(4, 2, 2);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> 0f);
		scene.overlay.showText(40)
			.attachKeyFrame()
			.text("Gantry setups can move attached Blocks.")
			.pointAt(gantryTop)
			.placeNearTarget();
		scene.idle(30);

		Selection planks = util.select.position(5, 3, 1);

		scene.world.showSectionAndMerge(util.select.layersFrom(3)
			.substract(planks), Direction.DOWN, gantry);
		scene.world.replaceBlocks(util.select.fromTo(5, 3, 2, 3, 4, 2), Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.idle(10);
		scene.world.showSectionAndMerge(planks, Direction.SOUTH, gantry);

		scene.idle(10);
		scene.overlay.showOutline(PonderPalette.GREEN, "glue", util.select.position(3, 4, 2)
			.add(util.select.fromTo(3, 3, 2, 5, 3, 2))
			.add(util.select.position(5, 3, 1)), 40);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(3, 3, 2)), Pointing.UP)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);
		scene.effects.superGlue(util.grid.at(5, 3, 1), Direction.SOUTH, true);
		scene.idle(20);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.sharedText("movement_anchors")
			.pointAt(util.vector.blockSurface(util.grid.at(3, 3, 2), Direction.WEST))
			.placeNearTarget();
		scene.idle(80);

		scene.world.modifyKineticSpeed(util.select.layer(0), f -> 32f);
		scene.world.modifyKineticSpeed(util.select.layer(1), f -> -64f);

		scene.world.moveSection(gantry, util.vector.of(-4, 0, 0), 60);
		scene.idle(20);
		scene.markAsFinished();
	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("gantry_redstone", "Gantry Power Propagation");
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);

		Selection leverRedstone = util.select.fromTo(3, 1, 0, 3, 1, 1);
		Selection shaft = util.select.fromTo(0, 1, 2, 4, 1, 2);
		Selection shaftAndCog = util.select.fromTo(0, 1, 2, 5, 1, 2);

		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0)
			.add(leverRedstone), Direction.UP);

		scene.idle(10);
		scene.world.showSection(shaftAndCog, Direction.DOWN);
		scene.idle(10);

		BlockPos gantryPos = util.grid.at(4, 2, 2);
		ElementLink<WorldSectionElement> gantry =
			scene.world.showIndependentSection(util.select.position(gantryPos), Direction.DOWN);
		scene.idle(15);
		scene.world.moveSection(gantry, util.vector.of(-3, 0, 0), 40);
		scene.idle(40);

		scene.world.toggleRedstonePower(shaft);
		scene.world.toggleRedstonePower(util.select.position(3, 1, 0));
		scene.world.toggleRedstonePower(util.select.position(3, 1, 1));
		scene.effects.indicateRedstone(util.grid.at(3, 1, 0));
		scene.world.modifyKineticSpeed(util.select.position(gantryPos), f -> 32f);
		scene.idle(40);

		BlockPos cogPos = util.grid.at(1, 2, 1);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.pointAt(util.vector.centerOf(cogPos.below()
				.south()))
			.text("Redstone-powered gantry shafts stop moving their carriages")
			.placeNearTarget();
		scene.idle(70);

		Selection cogSelection = util.select.position(cogPos);
		scene.world.showSection(cogSelection, Direction.SOUTH);
		scene.world.modifyKineticSpeed(cogSelection, f -> 32f);
		scene.overlay.showText(180)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(cogPos, Direction.NORTH))
			.text("Instead, its rotational force is relayed to the carriages' output shaft")
			.placeNearTarget();
		scene.idle(10);

		scene.effects.rotationSpeedIndicator(cogPos);
		scene.markAsFinished();
	}

	public static void direction(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("gantry_direction", "Gantry Movement Direction");
		scene.configureBasePlate(0, 0, 5);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(10);

		Selection shaftAndGearshiftAndLever = util.select.fromTo(0, 1, 2, 5, 2, 2);
		Selection shafts = util.select.fromTo(0, 1, 2, 3, 1, 2);

		scene.world.showSection(shaftAndGearshiftAndLever, Direction.DOWN);
		scene.overlay.showText(60)
			.text("Gantry Shafts can have opposite orientations")
			.pointAt(util.vector.of(2, 1.5, 2.5))
			.placeNearTarget();
		scene.idle(60);

		ElementLink<WorldSectionElement> gantry1 =
			scene.world.showIndependentSection(util.select.position(0, 1, 3), Direction.NORTH);
		ElementLink<WorldSectionElement> gantry2 =
			scene.world.showIndependentSection(util.select.position(3, 1, 3), Direction.NORTH);
		scene.idle(10);

		scene.world.moveSection(gantry1, util.vector.of(1, 0, 0), 20);
		scene.world.moveSection(gantry2, util.vector.of(-1, 0, 0), 20);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("The movement direction of carriages depend on their shafts' orientation")
			.pointAt(util.vector.topOf(1, 1, 3))
			.placeNearTarget();
		scene.idle(80);

		BlockPos lastShaft = util.grid.at(0, 1, 2);
		boolean flip = true;

		for (int i = 0; i < 3; i++) {
			scene.world.modifyBlocks(util.select.fromTo(4, 1, 2, 4, 2, 2), s -> s.cycle(BlockStateProperties.POWERED),
				false);
			scene.effects.indicateRedstone(util.grid.at(4, 2, 2));
			scene.world.moveSection(gantry1, util.vector.of(flip ? -1 : 1, 0, 0), 20);
			scene.world.moveSection(gantry2, util.vector.of(flip ? 1 : -1, 0, 0), 20);
			scene.world.modifyKineticSpeed(shafts, f -> -f);
			scene.effects.rotationDirectionIndicator(lastShaft.east(flip ? 1 : 0));
			scene.idle(20);

			if (i == 0) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.text("...as well as the rotation direction of the shaft")
					.pointAt(util.vector.blockSurface(lastShaft, Direction.WEST))
					.placeNearTarget();
			}

			scene.idle(30);
			flip = !flip;
		}

		Selection kinetics = util.select.fromTo(0, 2, 3, 3, 3, 3);
		Selection gears1 = util.select.fromTo(0, 1, 3, 0, 3, 3);
		Selection gears2 = util.select.fromTo(3, 1, 3, 3, 3, 3);

		scene.world.showSection(kinetics, Direction.DOWN);
		scene.world.showSection(util.select.fromTo(0, 1, 0, 4, 1, 1), Direction.SOUTH);
		scene.idle(20);

		BlockPos leverPos = util.grid.at(4, 1, 0);
		scene.world.modifyBlocks(util.select.fromTo(1, 1, 0, 3, 1, 1),
			s -> s.hasProperty(RedStoneWireBlock.POWER) ? s.setValue(RedStoneWireBlock.POWER, 15) : s, false);
		scene.world.toggleRedstonePower(util.select.position(leverPos));
		scene.world.toggleRedstonePower(shafts);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(gears1, f -> -32f);
		scene.world.modifyKineticSpeed(gears2, f -> 32f);

		scene.idle(20);
		scene.overlay.showText(120)
			.attachKeyFrame()
			.text("Same rules apply for the propagated rotation")
			.pointAt(util.vector.topOf(0, 3, 3))
			.placeNearTarget();
		scene.idle(20);

		for (boolean flip2 : Iterate.trueAndFalse) {
			scene.effects.rotationDirectionIndicator(util.grid.at(0, 3, 3));
			scene.effects.rotationDirectionIndicator(util.grid.at(3, 3, 3));

			scene.idle(60);
			scene.world.modifyBlocks(util.select.fromTo(4, 1, 2, 4, 2, 2), s -> s.cycle(BlockStateProperties.POWERED),
				false);
			scene.effects.indicateRedstone(util.grid.at(4, 2, 2));
			scene.world.modifyKineticSpeed(gears1, f -> -f);
			scene.world.modifyKineticSpeed(gears2, f -> -f);

			if (!flip2) {
				scene.effects.rotationDirectionIndicator(util.grid.at(0, 3, 3));
				scene.effects.rotationDirectionIndicator(util.grid.at(3, 3, 3));
				scene.markAsFinished();
			}
		}

	}

	public static void subgantry(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("gantry_cascaded", "Cascaded Gantries");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -2 * f);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.column(5, 3))
			.add(util.select.fromTo(2, 1, 3, 4, 1, 3)), Direction.UP);
		scene.idle(10);

		BlockPos gantryPos = util.grid.at(5, 1, 2);
		BlockPos gantryPos2 = util.grid.at(3, 2, 2);
		ElementLink<WorldSectionElement> gantry =
			scene.world.showIndependentSection(util.select.position(gantryPos), Direction.SOUTH);
		scene.idle(5);

		scene.world.showSectionAndMerge(util.select.fromTo(0, 1, 2, 4, 1, 2), Direction.EAST, gantry);
		scene.idle(15);

		scene.world.moveSection(gantry, util.vector.of(0, 2, 0), 40);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Gantry shafts attach to a carriage without the need of super glue")
			.independent(20);
		scene.idle(40);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(gantry, util.vector.of(0, -2, 0), 40);
		scene.idle(40);

		ElementLink<WorldSectionElement> secondGantry =
			scene.world.showIndependentSection(util.select.position(gantryPos2), Direction.DOWN);
		scene.idle(15);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Same applies for carriages on moved Gantry Shafts")
			.independent(20);
		scene.idle(15);

		scene.world.moveSection(gantry, util.vector.of(0, 2, 0), 40);
		scene.world.moveSection(secondGantry, util.vector.of(0, 2, 0), 40);

		scene.idle(40);
		BlockPos leverPos = util.grid.at(2, 1, 3);
		scene.world.toggleRedstonePower(util.select.position(leverPos));
		scene.world.toggleRedstonePower(util.select.fromTo(3, 1, 3, 4, 1, 3));
		scene.world.toggleRedstonePower(util.select.fromTo(5, 1, 3, 5, 4, 3));
		scene.world.modifyKineticSpeed(util.select.fromTo(0, 1, 2, 5, 1, 2), f -> -32f);
		scene.effects.indicateRedstone(leverPos);
		scene.world.moveSection(secondGantry, util.vector.of(-3, 0, 0), 60);

		scene.idle(20);
		scene.overlay.showText(120)
			.text("Thus, a gantry system can be cascaded to cover multiple axes of movement")
			.independent(20);
	}

}
//文件scenes/ItemVaultScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

public class ItemVaultScenes {

	public static void storage(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("item_vault_storage", "Storing Items in Vaults");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		Selection chests = util.select.fromTo(4, 3, 2, 3, 4, 3);
		Selection largeCog = util.select.position(3, 0, 5);
		Selection belt1 = util.select.fromTo(0, 2, 3, 2, 1, 5);
		Selection gearbox = util.select.position(2, 1, 2);
		Selection belt2 = util.select.fromTo(0, 1, 1, 2, 2, 1);
		Selection vault = util.select.fromTo(3, 2, 3, 4, 1, 1);

		scene.world.showSection(vault, Direction.NORTH);
		scene.idle(5);
		ElementLink<WorldSectionElement> chestLink = scene.world.showIndependentSection(chests, Direction.NORTH);
		scene.world.moveSection(chestLink, util.vector.of(-3, -2, 0), 0);
		scene.idle(10);

		scene.overlay.showOutline(PonderPalette.GREEN, "chestOutline", util.select.fromTo(1, 1, 2, 0, 2, 3), 40);
		scene.idle(10);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(2, 1, 2), util.vector.of(3, 1, 1), 30);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(2, 3, 2), util.vector.of(3, 3, 1), 30);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.of(2, 3, 4), util.vector.of(3, 3, 4), 30);
		scene.overlay.showOutline(PonderPalette.GREEN, "vaultOutline", vault, 40);
		scene.idle(10);

		BlockPos frontVault = util.grid.at(3, 2, 1);
		scene.overlay.showText(60)
			.text("Item Vaults can be used to store large amounts of items")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(frontVault, Direction.NORTH));
		scene.idle(70);

		scene.world.hideIndependentSection(chestLink, Direction.DOWN);
		scene.idle(15);

		ItemStack hand = AllItems.BRASS_HAND.asStack();
		scene.overlay
			.showControls(new InputWindowElement(util.vector.blockSurface(frontVault, Direction.NORTH), Pointing.RIGHT)
				.showing(AllIcons.I_MTD_CLOSE)
				.withItem(hand), 40);
		scene.idle(7);

		scene.overlay.showText(60)
			.text("However, contents cannot be added or taken manually")
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(frontVault, Direction.WEST));
		scene.idle(70);

		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(5);
		scene.world.showSection(belt1, Direction.EAST);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Any components for item transfer can both insert...")
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 2, 3));

		ItemStack[] junk =
			{ new ItemStack(Items.APPLE), new ItemStack(Items.GOLD_INGOT, 8), new ItemStack(Items.TUFF, 32) };
		for (int i = 0; i < junk.length + 2; i++) {
			scene.idle(4);

			if (i > 1) {
				scene.world.removeItemsFromBelt(util.grid.at(2, 1, 3));
				scene.world.flapFunnel(util.grid.at(2, 2, 3), false);
			}

			scene.idle(5);
			if (i < junk.length)
				scene.world.createItemOnBeltLike(util.grid.at(0, 1, 3), Direction.SOUTH, junk[i]);
			scene.idle(9);
		}

		scene.world.showSection(gearbox, Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(belt2, Direction.EAST);
		scene.idle(15);

		scene.overlay.showText(80)
			.text("...and take contents from this container")
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 1, 1));

		for (int i = 0; i < junk.length; i++) {
			scene.world.createItemOnBeltLike(util.grid.at(2, 1, 1), Direction.EAST, junk[i]);
			scene.idle(18);
		}

	}

	public static void sizes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("item_vault_sizes", "Dimensions of an Item Vault");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.9f);
		scene.showBasePlate();
		scene.idle(5);

		Selection single = util.select.position(2, 4, 2);
		Selection single2 = util.select.fromTo(2, 4, 3, 3, 5, 3);
		Selection single3 = util.select.fromTo(2, 4, 4, 4, 6, 4);

		ElementLink<WorldSectionElement> s1 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s1, util.vector.of(0, -3, 0), 0);
		scene.idle(10);

		scene.overlay.showText(60)
			.text("Item Vaults can be combined to increase the total capacity")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(2, 1, 2));
		scene.idle(40);

		ElementLink<WorldSectionElement> s2 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s2, util.vector.of(1, -3, 0), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> s3 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s3, util.vector.of(1, -2, 0), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> s4 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s4, util.vector.of(0, -2, 0), 0);
		scene.idle(10);

		scene.world.moveSection(s1, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s2, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s3, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s4, util.vector.of(0, -100, 0), 0);

		ElementLink<WorldSectionElement> d = scene.world.showIndependentSectionImmediately(single2);
		scene.world.moveSection(d, util.vector.of(0, -3, -1), 0);
		scene.effects.indicateSuccess(util.grid.at(2, 1, 2));
		scene.effects.indicateSuccess(util.grid.at(2, 2, 2));
		scene.effects.indicateSuccess(util.grid.at(3, 2, 2));
		scene.effects.indicateSuccess(util.grid.at(3, 1, 2));
		scene.world.hideIndependentSection(s1, Direction.DOWN);
		scene.world.hideIndependentSection(s2, Direction.DOWN);
		scene.world.hideIndependentSection(s3, Direction.DOWN);
		scene.world.hideIndependentSection(s4, Direction.DOWN);
		scene.idle(25);

		scene.overlay.showText(60)
			.text("Their base square can be up to 3 blocks wide...")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH));
		scene.idle(40);

		s1 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s1, util.vector.of(2, -3, 0), 0);
		scene.idle(3);
		s2 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s2, util.vector.of(2, -2, 0), 0);
		scene.idle(3);
		s3 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s3, util.vector.of(2, -1, 0), 0);
		scene.idle(3);
		s4 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s4, util.vector.of(1, -1, 0), 0);
		scene.idle(3);
		ElementLink<WorldSectionElement> s5 = scene.world.showIndependentSection(single, Direction.DOWN);
		scene.world.moveSection(s5, util.vector.of(0, -1, 0), 0);
		scene.idle(10);

		scene.world.moveSection(d, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s1, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s2, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s3, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s4, util.vector.of(0, -100, 0), 0);
		scene.world.moveSection(s5, util.vector.of(0, -100, 0), 0);

		ElementLink<WorldSectionElement> t = scene.world.showIndependentSectionImmediately(single3);
		scene.world.moveSection(t, util.vector.of(0, -3, -2), 0);

		for (int i = 1; i < 4; i++)
			for (int j = 2; j < 5; j++)
				scene.effects.indicateSuccess(util.grid.at(j, i, 2));

		scene.world.hideIndependentSection(d, Direction.DOWN);
		scene.world.hideIndependentSection(s1, Direction.DOWN);
		scene.world.hideIndependentSection(s2, Direction.DOWN);
		scene.world.hideIndependentSection(s3, Direction.DOWN);
		scene.world.hideIndependentSection(s4, Direction.DOWN);
		scene.world.hideIndependentSection(s5, Direction.DOWN);
		scene.idle(25);

		scene.world.hideIndependentSection(t, Direction.DOWN);
		scene.idle(15);

		Selection full1 = util.select.fromTo(2, 1, 0, 4, 1, 0);
		Selection full2 = util.select.fromTo(0, 1, 1, 3, 2, 2);
		Selection full3 = util.select.fromTo(1, 1, 5, 5, 3, 3);

		scene.world.showSection(full3, Direction.WEST);
		scene.idle(5);
		scene.world.showSection(full2, Direction.EAST);
		scene.idle(5);
		scene.world.showSection(full1, Direction.WEST);
		scene.idle(10);

		Vec3 blockSurface = util.vector.blockSurface(util.grid.at(1, 3, 3), Direction.NORTH);
		scene.overlay.showText(60)
			.text("...and grow in length up to 3x their diameter")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(blockSurface);
		scene.idle(40);
	}

}
//文件scenes/KineticsScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.crank.ValveHandleBlock;
import com.simibubi.create.content.kinetics.crusher.CrushingWheelBlock;
import com.simibubi.create.content.kinetics.gauge.GaugeBlock;
import com.simibubi.create.content.kinetics.gauge.StressGaugeBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.content.kinetics.transmission.sequencer.SequencedGearshiftBlock;
import com.simibubi.create.content.kinetics.waterwheel.WaterWheelBlockEntity;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlock;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Vec3i;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class KineticsScenes {

	public static void shaftAsRelay(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("shaft", "Relaying rotational force using Shafts");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos gaugePos = util.grid.at(0, 1, 2);
		Selection gauge = util.select.position(gaugePos);
		scene.world.showSection(gauge, Direction.UP);
		scene.world.setKineticSpeed(gauge, 0);

		scene.idle(5);
		scene.world.showSection(util.select.position(5, 1, 2), Direction.DOWN);
		scene.idle(10);

		for (int i = 4; i >= 1; i--) {
			if (i == 2)
				scene.rotateCameraY(70);
			scene.idle(5);
			scene.world.showSection(util.select.position(i, 1, 2), Direction.DOWN);
		}

		scene.world.setKineticSpeed(gauge, 64);
		scene.effects.indicateSuccess(gaugePos);
		scene.idle(10);
		scene.overlay.showText(1000)
			.placeNearTarget()
			.text("Shafts will relay rotation in a straight line.")
			.pointAt(util.vector.of(3, 1.5, 2.5));

		scene.idle(20);
		scene.markAsFinished();
	}

	public static void shaftsCanBeEncased(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("shaft_casing", "Encasing Shafts");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		Selection shaft = util.select.cuboid(new BlockPos(0, 1, 2), new Vec3i(5, 0, 2));
		Selection andesite = util.select.position(3, 1, 2);
		Selection brass = util.select.position(1, 1, 2);

		scene.world.showSection(shaft, Direction.DOWN);
		scene.idle(20);

		BlockEntry<EncasedShaftBlock> andesiteEncased = AllBlocks.ANDESITE_ENCASED_SHAFT;
		ItemStack andesiteCasingItem = AllBlocks.ANDESITE_CASING.asStack();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(3, 1, 2), Pointing.DOWN).rightClick()
			.withItem(andesiteCasingItem), 60);
		scene.idle(7);
		scene.world.setBlocks(andesite, andesiteEncased.getDefaultState()
			.setValue(EncasedShaftBlock.AXIS, Axis.X), true);
		scene.world.setKineticSpeed(shaft, 32);
		scene.idle(10);

		BlockEntry<EncasedShaftBlock> brassEncased = AllBlocks.BRASS_ENCASED_SHAFT;
		ItemStack brassCasingItem = AllBlocks.BRASS_CASING.asStack();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(1, 0, 2), Pointing.UP).rightClick()
			.withItem(brassCasingItem), 60);
		scene.idle(7);
		scene.world.setBlocks(brass, brassEncased.getDefaultState()
			.setValue(EncasedShaftBlock.AXIS, Axis.X), true);
		scene.world.setKineticSpeed(shaft, 32);

		scene.idle(10);
		scene.overlay.showText(100)
			.placeNearTarget()
			.text("Brass or Andesite Casing can be used to decorate Shafts")
			.pointAt(util.vector.topOf(1, 1, 2));
		scene.idle(70);
	}

	public static void cogAsRelay(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cogwheel", "Relaying rotational force using Cogwheels");
		scene.configureBasePlate(0, 0, 5);
		BlockPos gauge = util.grid.at(4, 1, 1);
		Selection gaugeSelect = util.select.position(gauge);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.showSection(gaugeSelect, Direction.UP);
		scene.world.setKineticSpeed(gaugeSelect, 0);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 3, 1, 1, 5), Direction.DOWN);
		scene.idle(10);

		for (int i = 1; i <= 4; i++) {
			scene.idle(5);
			if (i == 2)
				scene.world.showSection(util.select.position(0, 1, 2), Direction.DOWN);
			scene.world.showSection(util.select.position(i, 1, 2), Direction.DOWN);
		}

		scene.world.setKineticSpeed(gaugeSelect, 64);
		scene.effects.indicateSuccess(gauge);
		scene.idle(10);
		scene.overlay.showText(60)
			.text("Cogwheels will relay rotation to other adjacent cogwheels")
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 2), Direction.EAST));

		scene.idle(60);
		scene.world.showSection(util.select.fromTo(1, 1, 1, 2, 1, 1), Direction.SOUTH);
		scene.idle(10);
		scene.effects.rotationDirectionIndicator(util.grid.at(1, 1, 1));
		scene.effects.rotationDirectionIndicator(util.grid.at(2, 1, 1));
		scene.idle(20);
		scene.overlay.showText(100)
			.text("Neighbouring shafts connected like this will rotate in opposite directions")
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.NORTH));
		scene.idle(70);

	}

	public static void largeCogAsRelay(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("large_cogwheel", "Relaying rotational force using Large Cogwheels");
		scene.configureBasePlate(1, 1, 5);
		scene.world.setBlock(util.grid.at(4, 2, 3), AllBlocks.LARGE_COGWHEEL.getDefaultState()
			.setValue(CogWheelBlock.AXIS, Axis.X), false);

		scene.showBasePlate();
		scene.idle(5);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(3, 2, 4), Direction.NORTH);

		for (int i = 3; i >= 1; i--) {
			scene.idle(5);
			if (i == 3)
				scene.world.showSection(util.select.position(3, 2, 5), Direction.DOWN);
			scene.world.showSection(util.select.position(3, 2, i), Direction.DOWN);
		}

		scene.overlay.showText(70)
			.text("Large cogwheels can connect to each other at right angles")
			.placeNearTarget()
			.pointAt(util.vector.centerOf(3, 1, 4));
		scene.idle(70);
		scene.world.hideSection(util.select.fromTo(3, 2, 1, 3, 2, 5), Direction.SOUTH);

		scene.idle(15);
		scene.world.modifyBlock(util.grid.at(3, 2, 3), s -> s.setValue(ShaftBlock.AXIS, Axis.X), false);
		scene.world.setKineticSpeed(util.select.fromTo(1, 2, 3, 5, 2, 3), 16);
		scene.world.showSection(util.select.position(4, 2, 3), Direction.WEST);

		for (int i = 3; i >= 1; i--) {
			scene.idle(5);
			if (i == 3)
				scene.world.showSection(util.select.position(5, 2, 3), Direction.DOWN);
			scene.world.showSection(util.select.position(i, 2, 3), Direction.DOWN);
		}

		scene.idle(5);
		scene.overlay.showText(90)
			.text("It will help relaying conveyed speed to other axes of rotation")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 3), Direction.WEST));
		scene.effects.rotationSpeedIndicator(util.grid.at(3, 1, 3));
		scene.effects.rotationSpeedIndicator(util.grid.at(4, 2, 3));
		scene.idle(60);

	}

	public static void cogsSpeedUp(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cog_speedup", "Gearshifting with Cogs");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(5, 1, 2, 4, 1, 2), Direction.DOWN);
		scene.idle(10);

		BlockPos lowerCog = util.grid.at(3, 1, 2);
		BlockPos upperCog = util.grid.at(3, 2, 3);
		BlockState largeCogState = AllBlocks.LARGE_COGWHEEL.getDefaultState()
			.setValue(CogWheelBlock.AXIS, Axis.X);
		BlockState smallCogState = AllBlocks.COGWHEEL.getDefaultState()
			.setValue(CogWheelBlock.AXIS, Axis.X);

		scene.world.setBlock(lowerCog, largeCogState, false);
		scene.world.setBlock(upperCog, smallCogState, false);
		BlockPos upperShaftEnd = upperCog.west(3);
		BlockPos lowerShaftEnd = lowerCog.west(3);

		scene.world.setKineticSpeed(util.select.fromTo(upperCog, upperShaftEnd), -64);
		scene.world.showSection(util.select.fromTo(lowerCog, upperCog), Direction.EAST);
		scene.overlay.showText(60)
			.text("Large and Small cogs can be connected diagonally")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(upperCog, Direction.WEST));
		scene.idle(80);

		Selection gaugesSelect = util.select.fromTo(0, 1, 2, 2, 2, 3);
		scene.world.showSection(gaugesSelect, Direction.DOWN);
		scene.overlay.showText(80)
			.text("Shifting from large to small cogs, the conveyed speed will be doubled")
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 3), Direction.NORTH));
		scene.idle(30);
		scene.effects.rotationSpeedIndicator(upperCog);
		scene.idle(60);

		scene.overlay.showText(30)
			.sharedText("rpm32")
			.colored(PonderPalette.FAST)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(upperShaftEnd, Direction.WEST));
		scene.idle(5);
		scene.overlay.showText(30)
			.sharedText("rpm16")
			.colored(PonderPalette.MEDIUM)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(lowerShaftEnd, Direction.WEST));
		scene.idle(45);

		scene.world.setKineticSpeed(util.select.fromTo(lowerCog, upperShaftEnd), 0);
		ElementLink<WorldSectionElement> cogs =
			scene.world.makeSectionIndependent(util.select.fromTo(lowerCog, upperCog));
		scene.world.moveSection(cogs, util.vector.of(0, 1, 0), 5);
		scene.idle(5);
		scene.world.rotateSection(cogs, 180, 0, 0, 10);
		scene.idle(10);
		scene.world.setBlock(lowerCog, smallCogState, false);
		scene.world.setBlock(upperCog, largeCogState, false);
		scene.world.rotateSection(cogs, 180, 0, 0, 0);
		scene.world.moveSection(cogs, util.vector.of(0, -1, 0), 5);
		scene.idle(5);

		scene.world.setKineticSpeed(util.select.fromTo(lowerCog, lowerShaftEnd), 32);
		scene.world.setKineticSpeed(util.select.fromTo(upperCog, upperShaftEnd), -16);

		scene.overlay.showText(80)
			.text("Shifting the opposite way, the conveyed speed will be halved")
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 3), Direction.NORTH));
		scene.idle(10);
		scene.effects.rotationSpeedIndicator(upperCog);
		scene.idle(80);

		scene.overlay.showText(60)
			.sharedText("rpm8")
			.colored(PonderPalette.SLOW)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(upperShaftEnd, Direction.WEST));
		scene.idle(5);
		scene.overlay.showText(60)
			.sharedText("rpm16")
			.colored(PonderPalette.MEDIUM)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(lowerShaftEnd, Direction.WEST));
		scene.idle(40);
	}

	public static void cogwheelsCanBeEncased(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("cogwheel_casing", "Encasing Cogwheels");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		Selection large1 = util.select.position(4, 1, 3);
		Selection small1 = util.select.fromTo(3, 1, 2, 3, 2, 2);
		Selection small2 = util.select.position(2, 1, 2);
		Selection large2 = util.select.fromTo(1, 1, 3, 1, 1, 4);
		Selection shaft2 = util.select.position(2, 2, 2);

		scene.world.setKineticSpeed(shaft2, 0);
		scene.idle(10);

		scene.world.showSection(large1, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(small1, Direction.DOWN);
		scene.world.showSection(small2, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(large2, Direction.EAST);
		scene.idle(20);

		BlockEntry<EncasedCogwheelBlock> andesiteEncased = AllBlocks.ANDESITE_ENCASED_COGWHEEL;
		ItemStack andesiteCasingItem = AllBlocks.ANDESITE_CASING.asStack();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(3, 0, 2), Pointing.UP).rightClick()
			.withItem(andesiteCasingItem), 100);
		scene.idle(7);
		scene.world.setBlocks(util.select.position(3, 1, 2), andesiteEncased.getDefaultState()
			.setValue(EncasedCogwheelBlock.AXIS, Axis.Y)
			.setValue(EncasedCogwheelBlock.TOP_SHAFT, true), true);
		scene.world.setKineticSpeed(util.select.position(3, 1, 2), -32);
		scene.idle(15);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(2, 1, 2), Pointing.DOWN).rightClick()
			.withItem(andesiteCasingItem), 30);
		scene.idle(7);
		scene.world.setBlocks(small2, andesiteEncased.getDefaultState()
			.setValue(EncasedCogwheelBlock.AXIS, Axis.Y), true);
		scene.world.setKineticSpeed(small2, 32);
		scene.idle(15);

		BlockEntry<EncasedCogwheelBlock> brassEncased = AllBlocks.BRASS_ENCASED_LARGE_COGWHEEL;
		ItemStack brassCasingItem = AllBlocks.BRASS_CASING.asStack();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(1, 0, 3), Pointing.UP).rightClick()
			.withItem(brassCasingItem), 60);
		scene.idle(7);
		scene.world.setBlocks(util.select.position(1, 1, 3), brassEncased.getDefaultState()
			.setValue(EncasedCogwheelBlock.AXIS, Axis.Y), true);
		scene.world.setKineticSpeed(util.select.position(1, 1, 3), -16);

		scene.idle(10);
		scene.overlay.showText(70)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Brass or Andesite Casing can be used to decorate Cogwheels")
			.pointAt(util.vector.topOf(1, 1, 3));
		scene.idle(80);

		ElementLink<WorldSectionElement> shaftLink = scene.world.showIndependentSection(shaft2, Direction.DOWN);
		scene.idle(15);
		scene.overlay.showText(90)
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.text("Components added after encasing will not connect to the shaft outputs")
			.pointAt(util.vector.centerOf(2, 2, 2));
		scene.idle(90);

		scene.world.moveSection(shaftLink, new Vec3(0, .5f, 0), 10);
		scene.idle(10);

		scene.addKeyframe();
		Vec3 wrenchHere = util.vector.topOf(2, 1, 2)
			.add(.25, 0, -.25);
		scene.overlay.showControls(new InputWindowElement(wrenchHere, Pointing.RIGHT).rightClick()
			.withWrench(), 25);
		scene.idle(7);
		scene.world.cycleBlockProperty(util.grid.at(2, 1, 2), EncasedCogwheelBlock.TOP_SHAFT);
		scene.idle(15);
		scene.world.moveSection(shaftLink, new Vec3(0, -.5f, 0), 10);
		scene.idle(10);
		scene.world.setKineticSpeed(shaft2, 32);
		scene.effects.rotationDirectionIndicator(util.grid.at(2, 2, 2));
		scene.idle(20);

		scene.overlay.showText(90)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("The Wrench can be used to toggle connections")
			.pointAt(wrenchHere.add(-.5, 0, .5));
		scene.idle(40);

		scene.overlay.showControls(new InputWindowElement(wrenchHere, Pointing.RIGHT).rightClick()
			.withWrench(), 25);
		scene.idle(7);
		scene.world.cycleBlockProperty(util.grid.at(2, 1, 2), EncasedCogwheelBlock.TOP_SHAFT);
		scene.world.setKineticSpeed(shaft2, 0);
	}

	public static void gearbox(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("gearbox", "Relaying rotational force using Gearboxes");
		scene.configureBasePlate(1, 1, 5);
		scene.setSceneOffsetY(-1);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.showSection(util.select.fromTo(4, 1, 6, 3, 2, 5), Direction.UP);
		scene.idle(10);

		BlockPos largeCogBack = util.grid.at(3, 2, 4);
		BlockPos largeCogLeft = util.grid.at(4, 2, 3);
		BlockPos largeCogFront = util.grid.at(3, 2, 2);
		BlockPos largeCogRight = util.grid.at(2, 2, 3);

		scene.world.showSection(util.select.position(largeCogBack), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.position(largeCogLeft), Direction.WEST);
		scene.world.showSection(util.select.position(largeCogLeft.east()), Direction.WEST);
		scene.world.showSection(util.select.position(largeCogRight), Direction.EAST);
		scene.world.showSection(util.select.position(largeCogRight.west()), Direction.EAST);
		scene.idle(5);
		scene.world.showSection(util.select.position(largeCogFront), Direction.SOUTH);
		scene.world.showSection(util.select.position(largeCogFront.north()), Direction.SOUTH);

		scene.idle(10);

		scene.overlay.showText(80)
			.colored(PonderPalette.RED)
			.pointAt(util.vector.blockSurface(largeCogRight.west(), Direction.WEST))
			.placeNearTarget()
			.text("Jumping between axes of rotation can get bulky quickly");
		scene.idle(80);
		Selection gearbox = util.select.position(3, 2, 3);
		scene.world.hideSection(util.select.fromTo(4, 2, 2, 2, 2, 4)
			.substract(gearbox), Direction.UP);
		scene.idle(20);

		BlockState defaultState = AllBlocks.SHAFT.getDefaultState();
		BlockState cogState = AllBlocks.COGWHEEL.getDefaultState();
		scene.world.setBlock(largeCogBack, defaultState.setValue(CogWheelBlock.AXIS, Axis.Z), false);
		scene.world.setBlock(largeCogFront, defaultState.setValue(CogWheelBlock.AXIS, Axis.Z), false);
		scene.world.setBlock(largeCogRight, defaultState.setValue(CogWheelBlock.AXIS, Axis.X), false);
		scene.world.setBlock(largeCogLeft, defaultState.setValue(CogWheelBlock.AXIS, Axis.X), false);
		scene.world.showSection(util.select.fromTo(4, 2, 2, 2, 2, 4), Direction.DOWN);

		scene.idle(20);
		scene.overlay.showText(80)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.topOf(3, 2, 3))
			.placeNearTarget()
			.attachKeyFrame()
			.text("A gearbox is the more compact equivalent of this setup");

		scene.idle(90);
		scene.world.setBlock(largeCogFront.north(), cogState.setValue(CogWheelBlock.AXIS, Axis.Z), true);
		scene.world.setBlock(largeCogRight.west(), cogState.setValue(CogWheelBlock.AXIS, Axis.X), true);
		scene.idle(10);
		scene.effects.rotationDirectionIndicator(largeCogFront.north());
		scene.effects.rotationDirectionIndicator(largeCogRight.west());
		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.of(3, 2.5, 3))
			.placeNearTarget()
			.text("Shafts around corners rotate in mirrored directions");

		scene.idle(70);

		scene.world.hideSection(util.select.fromTo(1, 2, 3, 2, 2, 3), Direction.WEST);
		scene.world.hideSection(util.select.fromTo(4, 2, 3, 5, 2, 3), Direction.EAST);
		scene.world.setBlock(largeCogBack.south(), cogState.setValue(CogWheelBlock.AXIS, Axis.Z), true);
		scene.idle(10);

		scene.effects.rotationDirectionIndicator(largeCogFront.north());
		scene.effects.rotationDirectionIndicator(largeCogBack.south());
		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.centerOf(3, 2, 5))
			.placeNearTarget()
			.text("Straight connections will be reversed");

	}

	public static void clutch(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("clutch", "Controlling rotational force using a Clutch");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		BlockPos leverPos = util.grid.at(3, 1, 0);
		scene.world.showSection(util.select.fromTo(leverPos, leverPos.south()), Direction.UP);

		BlockPos gaugePos = util.grid.at(0, 1, 2);
		Selection gauge = util.select.position(gaugePos);
		scene.world.showSection(gauge, Direction.UP);
		scene.world.setKineticSpeed(gauge, 0);

		scene.idle(5);
		scene.world.showSection(util.select.position(5, 1, 2), Direction.DOWN);
		scene.idle(10);

		for (int i = 4; i >= 1; i--) {
			scene.idle(5);
			scene.world.showSection(util.select.position(i, 1, 2), Direction.DOWN);
		}

		BlockPos clutch = util.grid.at(3, 1, 2);

		scene.world.setKineticSpeed(gauge, 32);
		scene.effects.indicateSuccess(gaugePos);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("Clutches will relay rotation in a straight line")
			.placeNearTarget()
			.pointAt(util.vector.topOf(clutch));

		scene.idle(60);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
		scene.effects.indicateRedstone(leverPos);
		scene.world.setKineticSpeed(util.select.fromTo(0, 1, 2, 2, 1, 2), 0);
		scene.idle(10);

		scene.idle(10);
		scene.overlay.showText(50)
			.colored(PonderPalette.RED)
			.text("When powered by Redstone, it breaks the connection")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(clutch));

		scene.idle(70);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
		scene.effects.indicateRedstone(leverPos);
		scene.world.setKineticSpeed(util.select.fromTo(0, 1, 2, 2, 1, 2), 32);
		scene.effects.indicateSuccess(gaugePos);
	}

	public static void gearshift(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("gearshift", "Controlling rotational force using a Gearshift");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		BlockPos leverPos = util.grid.at(3, 1, 0);
		scene.world.showSection(util.select.fromTo(leverPos, leverPos.south()), Direction.UP);

		scene.idle(5);
		scene.world.showSection(util.select.position(5, 1, 2), Direction.DOWN);
		scene.idle(10);

		for (int i = 4; i >= 1; i--) {
			scene.idle(5);
			scene.world.showSection(util.select.position(i, 1, 2), Direction.DOWN);
		}

		BlockPos gearshift = util.grid.at(3, 1, 2);
		scene.idle(10);
		scene.overlay.showText(50)
			.placeNearTarget()
			.text("Gearshifts will relay rotation in a straight line")
			.pointAt(util.vector.topOf(gearshift));

		scene.idle(60);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(util.select.fromTo(0, 1, 2, 2, 2, 2), f -> -f);
		scene.effects.rotationDirectionIndicator(gearshift.east(2));
		scene.effects.rotationDirectionIndicator(gearshift.west(2));
		scene.idle(30);

		scene.overlay.showText(50)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.text("When powered by Redstone, it reverses the transmission")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(gearshift));

		for (int i = 0; i < 3; i++) {
			scene.idle(60);
			scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.south(2)));
			scene.effects.indicateRedstone(leverPos);
			scene.world.modifyKineticSpeed(util.select.fromTo(0, 1, 2, 2, 2, 2), f -> -f);
			scene.effects.rotationDirectionIndicator(gearshift.east(2));
			scene.effects.rotationDirectionIndicator(gearshift.west(2));
		}
	}

	public static void creativeMotor(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("creative_motor", "Generating Rotational Force using Creative Motors");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos motor = util.grid.at(3, 1, 2);

		for (int i = 0; i < 3; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.position(1 + i, 1, 2), Direction.DOWN);
		}

		scene.idle(10);
		scene.effects.rotationSpeedIndicator(motor);
		scene.overlay.showText(50)
			.text("Creative motors are a compact and configurable source of Rotational Force")
			.placeNearTarget()
			.pointAt(util.vector.topOf(motor));
		scene.idle(70);

		Vec3 blockSurface = util.vector.blockSurface(motor, Direction.NORTH)
			.add(1 / 16f, 0, 3 / 16f);
		scene.overlay.showFilterSlotInput(blockSurface, Direction.NORTH, 80);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.DOWN).rightClick(), 60);
		scene.idle(20);

		scene.overlay.showText(60)
			.text("The generated speed can be configured on its input panels")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(blockSurface);
		scene.idle(10);
		scene.idle(50);
		scene.world.modifyKineticSpeed(util.select.fromTo(1, 1, 2, 3, 1, 2), f -> 4 * f);
		scene.idle(10);

		scene.effects.rotationSpeedIndicator(motor);
	}

	public static void waterWheel(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("water_wheel", "Generating Rotational Force using Water Wheels");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 2, 3), Direction.DOWN);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);

		BlockPos gaugePos = util.grid.at(1, 2, 2);

		for (int i = 0; i < 4; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.fromTo(gaugePos.east(i)
				.below(), gaugePos.east(i)), Direction.DOWN);
		}

		scene.idle(10);

		for (int i = 0; i < 2; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.position(3, 3, 3 - i), Direction.DOWN);
		}
		scene.world.setKineticSpeed(util.select.everywhere(), -8);
		scene.effects.indicateSuccess(gaugePos);

		BlockPos wheel = util.grid.at(3, 2, 2);
		scene.effects.rotationSpeedIndicator(wheel);
		scene.overlay.showText(60)
			.text("Water Wheels draw force from adjacent Water Currents")
			.placeNearTarget()
			.pointAt(util.vector.topOf(wheel));
		scene.idle(10);

		AABB bb = new AABB(wheel).inflate(1 / 16f, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, 1, 0)
			.contract(0, .75, 0), 80);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, 0, -1)
			.contract(0, 0, -.75), 75);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, -1, 0)
			.contract(0, -.75, 0), 70);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, 0, 1)
			.contract(0, 0, .75), 65);
		scene.idle(75);

		scene.addKeyframe();
		scene.world.showSection(util.select.position(3, 3, 1), Direction.DOWN);
		for (int i = 0; i < 2; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.position(3, 2 - i, 1), Direction.DOWN);
		}

		scene.idle(10);
		scene.overlay.showText(50)
			.text("Covering additional sides will not improve its kinetic output further")
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(wheel, Direction.NORTH));

		scene.idle(80);

		scene.addKeyframe();

		ElementLink<WorldSectionElement> water = scene.world.makeSectionIndependent(util.select.fromTo(3, 1, 1, 3, 3, 1)
			.add(util.select.fromTo(3, 3, 2, 3, 3, 3)));
		scene.world.moveSection(water, util.vector.of(1, 0.5, -0.5), 15);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);

		scene.idle(5);
		ItemStack crimsonPlanks = new ItemStack(Items.CRIMSON_PLANKS);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(wheel), Pointing.DOWN).rightClick()
			.withItem(crimsonPlanks), 20);
		scene.idle(7);
		scene.world.modifyBlockEntity(wheel, WaterWheelBlockEntity.class, be -> be.applyMaterialIfValid(crimsonPlanks));
		scene.overlay.showText(50)
			.text("Use wood planks on the wheel to change its appearance")
			.colored(PonderPalette.BLUE)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(wheel, Direction.WEST));
		scene.idle(40);

		ItemStack birchPlanks = new ItemStack(Items.BIRCH_PLANKS);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(wheel), Pointing.DOWN).rightClick()
			.withItem(birchPlanks), 20);
		scene.idle(7);
		scene.world.modifyBlockEntity(wheel, WaterWheelBlockEntity.class, be -> be.applyMaterialIfValid(birchPlanks));
		scene.idle(40);

		ItemStack junglePlanks = new ItemStack(Items.JUNGLE_PLANKS);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(wheel), Pointing.DOWN).rightClick()
			.withItem(junglePlanks), 20);
		scene.idle(7);
		scene.world.modifyBlockEntity(wheel, WaterWheelBlockEntity.class, be -> be.applyMaterialIfValid(junglePlanks));
		scene.idle(20);

		scene.world.moveSection(water, util.vector.of(-1, -0.5, 0.5), 15);
		scene.idle(10);
		scene.world.setKineticSpeed(util.select.everywhere(), -8);
		scene.effects.indicateSuccess(gaugePos);
	}

	public static void largeWaterWheel(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("large_water_wheel", "Generating Rotational Force using Large Water Wheels");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0)
			.substract(util.select.position(3, 0, 0)), Direction.UP);
		ElementLink<WorldSectionElement> strip =
			scene.world.showIndependentSection(util.select.fromTo(1, 0, 0, 1, 0, 4), Direction.UP);
		scene.world.moveSection(strip, util.vector.of(2, 0, 0), 0);
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 2, 3), Direction.DOWN);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);

		BlockPos gaugePos = util.grid.at(1, 1, 2);

		for (int i = 0; i < 4; i++) {
			scene.idle(5);
			if (i == 0)
				scene.world.hideIndependentSection(strip, Direction.DOWN);
			scene.world.showSection(util.select.position(gaugePos.east(i)), Direction.DOWN);
		}

		scene.idle(10);

		for (int i = 0; i < 3; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.position(3, 3, 3 - i), Direction.DOWN);
		}
		scene.world.setKineticSpeed(util.select.everywhere(), -4);
		scene.effects.indicateSuccess(gaugePos);

		BlockPos wheel = util.grid.at(3, 1, 2);
		scene.effects.rotationSpeedIndicator(wheel);
		scene.overlay.showText(60)
			.text("Large Water Wheels draw force from adjacent Water Currents")
			.placeNearTarget()
			.pointAt(util.vector.topOf(wheel));
		scene.idle(10);

		AABB bb = new AABB(wheel).inflate(.125, 1, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, 3, 0)
			.contract(0, 2.75, 0), 80);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, 0, -3)
			.contract(0, 0, -2.75), 75);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, -3, 0)
			.contract(0, -2.75, 0), 70);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.MEDIUM, new Object(), bb.move(0, 0, 3)
			.contract(0, 0, 2.75), 65);
		scene.idle(75);

		scene.addKeyframe();
		scene.world.showSection(util.select.position(3, 3, 0), Direction.DOWN);
		for (int i = 0; i < 3; i++) {
			scene.idle(5);
			scene.world.showSection(util.select.position(3, 2 - i, 0), Direction.DOWN);
		}

		scene.idle(10);
		scene.overlay.showText(50)
			.text("Covering additional sides will not improve its kinetic output further")
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(wheel, Direction.NORTH));

		scene.idle(80);

		scene.idle(10);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("These rotate only at half the speed of regular water wheels...")
			.colored(PonderPalette.WHITE)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(gaugePos, Direction.NORTH));

		scene.idle(78);
		scene.overlay.showText(60)
			.text("...but provide a substantially higher stress capacity")
			.colored(PonderPalette.WHITE)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(gaugePos, Direction.WEST));

		scene.idle(80);

		scene.addKeyframe();

		ElementLink<WorldSectionElement> water = scene.world.makeSectionIndependent(util.select.fromTo(3, 0, 0, 3, 3, 0)
			.add(util.select.fromTo(3, 3, 1, 3, 3, 3)));
		scene.world.moveSection(water, util.vector.of(1, 0.5, -0.5), 15);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);

		BlockPos target = wheel.south()
			.above();

		scene.idle(5);
		ItemStack crimsonPlanks = new ItemStack(Items.CRIMSON_PLANKS);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(target), Pointing.DOWN).rightClick()
			.withItem(crimsonPlanks), 20);
		scene.idle(7);
		scene.world.modifyBlockEntity(wheel, WaterWheelBlockEntity.class, be -> be.applyMaterialIfValid(crimsonPlanks));
		scene.overlay.showText(50)
			.text("Use wood planks on the wheel to change its appearance")
			.colored(PonderPalette.BLUE)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(target, Direction.WEST));
		scene.idle(40);

		ItemStack birchPlanks = new ItemStack(Items.BIRCH_PLANKS);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(target), Pointing.DOWN).rightClick()
			.withItem(birchPlanks), 20);
		scene.idle(7);
		scene.world.modifyBlockEntity(wheel, WaterWheelBlockEntity.class, be -> be.applyMaterialIfValid(birchPlanks));
		scene.idle(40);

		ItemStack junglePlanks = new ItemStack(Items.JUNGLE_PLANKS);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(target), Pointing.DOWN).rightClick()
			.withItem(junglePlanks), 20);
		scene.idle(7);
		scene.world.modifyBlockEntity(wheel, WaterWheelBlockEntity.class, be -> be.applyMaterialIfValid(junglePlanks));
		scene.idle(20);

		scene.world.moveSection(water, util.vector.of(-1, -0.5, 0.5), 15);
		scene.idle(10);
		scene.world.setKineticSpeed(util.select.everywhere(), -4);
		scene.effects.indicateSuccess(gaugePos);
	}

	public static void handCrank(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("hand_crank", "Generating Rotational Force using Hand Cranks");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos gaugePos = util.grid.at(1, 3, 3);
		BlockPos handlePos = util.grid.at(2, 2, 2);
		Selection handleSelect = util.select.position(handlePos);

		scene.world.showSection(util.select.layersFrom(1)
			.substract(handleSelect), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(handleSelect, Direction.DOWN);
		scene.idle(20);

		Vec3 centerOf = util.vector.centerOf(handlePos);
		Vec3 sideOf = centerOf.add(-0.5, 0, 0);

		scene.overlay.showText(70)
			.text("Hand Cranks can be used by players to apply rotational force manually")
			.placeNearTarget()
			.pointAt(sideOf);
		scene.idle(80);

		scene.overlay.showControls(new InputWindowElement(centerOf, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.world.setKineticSpeed(util.select.everywhere(), 32);
		scene.world.modifyKineticSpeed(util.select.column(1, 3), f -> f * -2);
		scene.effects.rotationDirectionIndicator(handlePos);
		scene.effects.indicateSuccess(gaugePos);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("Hold Right-Click to rotate it Counter-Clockwise")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(sideOf);

		scene.idle(35);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.idle(15);

		scene.overlay.showControls(new InputWindowElement(centerOf, Pointing.DOWN).rightClick()
			.whileSneaking(), 40);
		scene.idle(7);
		scene.world.setKineticSpeed(util.select.everywhere(), -32);
		scene.world.modifyKineticSpeed(util.select.column(1, 3), f -> f * -2);
		scene.effects.rotationDirectionIndicator(handlePos);
		scene.effects.indicateSuccess(gaugePos);
		scene.idle(10);
		scene.overlay.showText(90)
			.text("Sneak and Hold Right-Click to rotate it Clockwise")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(sideOf);

		scene.idle(35);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.idle(45);
	}

	public static void valveHandle(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("valve_handle", "Precise rotation using Valve Handles");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		Selection armS = util.select.fromTo(3, 2, 3, 1, 2, 3);
		BlockPos bearing = util.grid.at(2, 2, 2);
		BlockPos valvePos = util.grid.at(2, 2, 1);
		Vec3 centerOf = util.vector.centerOf(valvePos);
		Vec3 sideOf = centerOf.add(-0.5, 0, 0);
		Vec3 topOf = centerOf.add(0, 0.5, 0);

		scene.world.showSection(util.select.fromTo(bearing, bearing.below()), Direction.DOWN);
		scene.idle(3);
		ElementLink<WorldSectionElement> contraption = scene.world.showIndependentSection(armS, Direction.NORTH);
		scene.idle(3);
		ElementLink<WorldSectionElement> valve =
			scene.world.showIndependentSection(util.select.position(valvePos), Direction.SOUTH);
		scene.world.rotateSection(valve, 0, 0, 45, 0);
		scene.idle(20);

		scene.overlay.showText(70)
			.text("Valve handles can be used to rotate components by a precise angle")
			.placeNearTarget()
			.pointAt(sideOf);

		scene.idle(20);
		scene.world.rotateSection(valve, 0, 0, 45, 15);
		scene.world.rotateSection(contraption, 0, 0, 45, 15);
		scene.world.rotateBearing(bearing, 45, 15);
		scene.world.setKineticSpeed(util.select.everywhere(), 16);
		scene.idle(15);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.idle(60);

		Vec3 blockSurface = util.vector.centerOf(valvePos)
			.add(0, 0, 4 / 16f);
		AABB point = new AABB(blockSurface, blockSurface);
		AABB expanded = point.inflate(1 / 8f, 1 / 8f, 1 / 16f);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, blockSurface, point, 1);
		scene.idle(1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, blockSurface, expanded, 80);
		scene.overlay.showControls(new InputWindowElement(blockSurface, Pointing.DOWN).rightClick(), 60);
		scene.idle(10);

		scene.overlay.showText(60)
			.text("The angle can be configured on the input panel")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(blockSurface);

		scene.idle(70);
		scene.overlay.showControls(new InputWindowElement(topOf, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.world.rotateSection(valve, 0, 0, 90, 30);
		scene.world.rotateSection(contraption, 0, 0, 90, 30);
		scene.world.rotateBearing(bearing, 90, 30);
		scene.world.setKineticSpeed(util.select.everywhere(), 16);

		scene.idle(10);
		scene.overlay.showText(40)
			.text("Right-Click to activate one rotation")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(sideOf);

		scene.idle(20);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);

		scene.idle(25);
		scene.overlay.showControls(new InputWindowElement(topOf, Pointing.DOWN).rightClick()
			.whileSneaking(), 40);
		scene.idle(7);
		scene.world.rotateSection(valve, 0, 0, -90, 30);
		scene.world.rotateSection(contraption, 0, 0, -90, 30);
		scene.world.rotateBearing(bearing, -90, 30);
		scene.world.setKineticSpeed(util.select.everywhere(), -16);

		scene.idle(10);
		scene.overlay.showText(50)
			.text("Sneak-Right-Click to activate it in the opposite direction")
			.placeNearTarget()
			.pointAt(sideOf);

		scene.idle(15);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.idle(40);

		blockSurface = util.vector.topOf(bearing)
			.add(0, 0, -1 / 8f);
		point = new AABB(blockSurface, blockSurface);
		expanded = point.inflate(1 / 8f, 0, 1 / 8f);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, blockSurface, point, 1);
		scene.idle(1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, blockSurface, expanded, 80);
		scene.idle(10);
		scene.overlay.showText(70)
			.text("Mind that Bearings have to be specifically told not to disassemble")
			.placeNearTarget()
			.pointAt(blockSurface);

		scene.idle(90);

		scene.addKeyframe();
		scene.overlay.showControls(new InputWindowElement(topOf, Pointing.DOWN).rightClick()
			.withItem(new ItemStack(Items.BLUE_DYE)), 40);
		scene.idle(7);
		scene.world.modifyBlock(valvePos, s -> AllBlocks.DYED_VALVE_HANDLES.get(DyeColor.BLUE)
			.getDefaultState()
			.setValue(ValveHandleBlock.FACING, Direction.NORTH), true);
		scene.idle(10);
		scene.overlay.showText(70)
			.text("Valve handles can be dyed for aesthetic purposes")
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.pointAt(sideOf);
		scene.idle(60);
	}

	public static void sequencedGearshift(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("sequenced_gearshift", "Controlling Rotational Speed using Sequenced Gearshifts");
		scene.configureBasePlate(1, 0, 5);
		scene.showBasePlate();

		Selection redstone = util.select.fromTo(3, 1, 0, 3, 1, 1);

		scene.world.showSection(util.select.position(6, 0, 3)
			.add(redstone), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(6, 1, 2, 4, 1, 2), Direction.DOWN);

		BlockPos gearshiftPos = util.grid.at(3, 1, 2);
		Selection gearshiftSelection = util.select.position(gearshiftPos);
		BlockPos bearingPos = util.grid.at(1, 1, 2);
		BlockPos buttonPos = util.grid.at(3, 1, 0);
		Selection outputKinetics = util.select.fromTo(3, 1, 2, 1, 1, 2);

		scene.world.setKineticSpeed(gearshiftSelection, 0);
		scene.idle(10);

		scene.world.showSection(gearshiftSelection, Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(util.select.fromTo(2, 1, 2, 1, 1, 2), Direction.EAST);
		scene.idle(10);

		Vec3 top = util.vector.topOf(gearshiftPos);
		scene.overlay.showText(60)
			.text("Seq. Gearshifts relay rotation by following a timed list of instructions")
			.attachKeyFrame()
			.pointAt(top)
			.placeNearTarget();
		scene.idle(80);

		scene.overlay.showControls(new InputWindowElement(top, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.overlay.showSelectionWithText(gearshiftSelection, 50)
			.colored(PonderPalette.BLUE)
			.text("Right-click it to open the Configuration UI")
			.pointAt(top)
			.placeNearTarget();
		scene.idle(60);

		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(0, 3, 2, 0, 0, 2), Direction.EAST);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearingPos));

		scene.idle(20);
		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(buttonPos);
		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 16);
		scene.world.rotateBearing(bearingPos, 90, 40);
		scene.world.rotateSection(contraption, 90, 0, 0, 40);
		scene.effects.rotationDirectionIndicator(gearshiftPos.west());
		scene.idle(20);
		scene.world.toggleRedstonePower(redstone);
		scene.idle(20);

		scene.overlay.showText(80)
			.text("Upon receiving a Redstone Signal, it will start running its configured sequence")
			.attachKeyFrame()
			.pointAt(top);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, -32);
		scene.world.rotateBearing(bearingPos, -180, 40);
		scene.world.rotateSection(contraption, -180, 0, 0, 40);
		scene.effects.rotationDirectionIndicator(gearshiftPos.west());
		scene.idle(40);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 0);
		scene.idle(20);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 16);
		scene.world.rotateBearing(bearingPos, 90, 40);
		scene.world.rotateSection(contraption, 90, 0, 0, 40);
		scene.effects.rotationDirectionIndicator(gearshiftPos.west());
		scene.idle(40);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 0);

		scene.idle(20);
		scene.overlay.showText(70)
			.text("Once finished, it waits for the next Redstone Signal and starts over")
			.pointAt(util.vector.topOf(util.grid.at(3, 0, 1)));
		scene.idle(80);

		scene.idle(20);
		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(buttonPos);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 16);
		scene.world.rotateBearing(bearingPos, 90, 40);
		scene.world.rotateSection(contraption, 90, 0, 0, 40);
		scene.effects.rotationDirectionIndicator(gearshiftPos.west());
		scene.idle(20);

		scene.overlay.showText(60)
			.text("A redstone comparator can be used to read the current progress")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(util.grid.at(3, 0, 1)));

		scene.world.hideSection(redstone, Direction.NORTH);
		scene.idle(15);

		BlockPos wire = util.grid.at(5, 1, 0);
		Selection nixie = util.select.position(4, 1, 0);
		scene.world.cycleBlockProperty(util.grid.at(4, 1, 0), NixieTubeBlock.FACING);
		scene.world.cycleBlockProperty(util.grid.at(4, 1, 0), NixieTubeBlock.FACING);

		ElementLink<WorldSectionElement> comparator =
			scene.world.showIndependentSection(util.select.fromTo(5, 1, 1, 4, 1, 0), Direction.SOUTH);
		scene.world.moveSection(comparator, util.vector.of(-2, 0, 0), 0);
		scene.world.toggleRedstonePower(util.select.position(5, 1, 1));
		scene.world.cycleBlockProperty(wire, RedStoneWireBlock.POWER);
		scene.world.modifyBlockEntityNBT(nixie, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 1));

		scene.idle(5);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, -32);
		scene.world.rotateBearing(bearingPos, -180, 40);
		scene.world.rotateSection(contraption, -180, 0, 0, 40);
		scene.effects.rotationDirectionIndicator(gearshiftPos.west());
		scene.world.cycleBlockProperty(wire, RedStoneWireBlock.POWER);
		scene.world.modifyBlockEntityNBT(nixie, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 2));
		scene.idle(40);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 0);
		scene.world.cycleBlockProperty(wire, RedStoneWireBlock.POWER);
		scene.world.modifyBlockEntityNBT(nixie, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 3));
		scene.idle(20);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.setKineticSpeed(outputKinetics, 16);
		scene.world.rotateBearing(bearingPos, 90, 40);
		scene.world.rotateSection(contraption, 90, 0, 0, 40);
		scene.effects.rotationDirectionIndicator(gearshiftPos.west());
		scene.world.cycleBlockProperty(wire, RedStoneWireBlock.POWER);
		scene.world.modifyBlockEntityNBT(nixie, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 4));
		scene.idle(40);

		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.cycleBlockProperty(gearshiftPos, SequencedGearshiftBlock.STATE);
		scene.world.modifyBlock(wire, s -> s.setValue(RedStoneWireBlock.POWER, 0), false);
		scene.world.toggleRedstonePower(util.select.position(5, 1, 1));
		scene.world.modifyBlockEntityNBT(nixie, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 0));
		scene.world.setKineticSpeed(outputKinetics, 0);
	}

	public static void speedController(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("rotation_speed_controller", "Using the Rotational Speed Controller");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos cogPos = util.grid.at(1, 2, 1);
		Selection gaugeSelect = util.select.position(1, 2, 3);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), 0.5f);
		scene.world.setKineticSpeed(gaugeSelect, 0);
		scene.world.showSection(util.select.fromTo(5, 1, 1, 2, 1, 1), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(1, 1, 3, 1, 2, 3), Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> rsc =
			scene.world.showIndependentSection(util.select.position(0, 1, 1), Direction.DOWN);
		scene.world.moveSection(rsc, util.vector.of(1, 0, 0), 0);
		ElementLink<WorldSectionElement> rsc2 =
			scene.world.showIndependentSection(util.select.position(1, 1, 1), Direction.DOWN);
		scene.world.moveSection(rsc2, util.vector.of(0, -100, 0), 0);
		scene.idle(10);
		scene.world.showSection(util.select.position(1, 2, 1), Direction.DOWN);
		scene.idle(15);
		scene.effects.indicateSuccess(cogPos);
		scene.world.moveSection(rsc2, util.vector.of(0, 100, 0), 0);
		scene.world.moveSection(rsc, util.vector.of(0, -100, 0), 0);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 2, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.setKineticSpeed(gaugeSelect, 8);
		scene.effects.indicateSuccess(util.grid.at(1, 2, 3));

		scene.overlay.showText(90)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(cogPos, Direction.NORTH))
			.text("Rot. Speed Controllers relay rotation from their axis to a Large Cogwheel above them");
		scene.idle(100);

		Vec3 inputVec = util.vector.of(1.5, 1.75 - 1 / 16f, 1);
		scene.overlay.showFilterSlotInput(inputVec, Direction.NORTH, 60);

		scene.overlay.showText(70)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(inputVec)
			.text("Using the value panel on its side, the conveyed speed can be configured");
		scene.idle(80);

		InputWindowElement input = new InputWindowElement(inputVec, Pointing.UP).rightClick();
		scene.overlay.showControls(input, 40);
		scene.idle(15);
		scene.world.multiplyKineticSpeed(util.select.fromTo(1, 2, 1, 1, 2, 3), 4);
		scene.effects.rotationSpeedIndicator(cogPos);
		scene.idle(55);
		scene.markAsFinished();

		scene.overlay.showControls(input, 30);
		scene.idle(15);
		scene.world.multiplyKineticSpeed(util.select.fromTo(1, 2, 1, 1, 2, 3), 4);
		scene.effects.rotationSpeedIndicator(cogPos);
		scene.idle(55);

		scene.overlay.showControls(input, 30);
		scene.idle(15);
		scene.world.multiplyKineticSpeed(util.select.fromTo(1, 2, 1, 1, 2, 3), -.05f);
		scene.effects.rotationSpeedIndicator(cogPos);
		scene.idle(35);
	}

	public static void speedometer(SceneBuilder scene, SceneBuildingUtil util) {
		gauge(scene, util, true);
	}

	public static void stressometer(SceneBuilder scene, SceneBuildingUtil util) {
		gauge(scene, util, false);
	}

	private static void gauge(SceneBuilder scene, SceneBuildingUtil util, boolean speed) {
		String component = speed ? "Speedometer" : "Stressometer";
		String title = "Monitoring Kinetic information using the " + component;
		scene.title(speed ? "speedometer" : "stressometer", title);
		scene.configureBasePlate(1, 0, 5);

		BlockPos gaugePos = util.grid.at(2, 1, 3);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		for (int x = 6; x >= 0; x--) {
			scene.idle(2);
			scene.world.showSection(util.select.position(x, 1, 3), Direction.DOWN);
		}
		scene.idle(10);

		scene.world.setBlock(gaugePos, (speed ? AllBlocks.SPEEDOMETER : AllBlocks.STRESSOMETER).getDefaultState()
			.setValue(GaugeBlock.FACING, Direction.UP), true);
		scene.world.setKineticSpeed(util.select.position(gaugePos), 32);
		scene.idle(10);

		scene.overlay.showText(80)
			.text("The " + component + " displays the current " + (speed ? "Speed" : "Stress Capacity")
				+ (speed ? " of attached components" : " of the attached kinetic network"))
			.attachKeyFrame()
			.pointAt(util.vector.topOf(gaugePos))
			.placeNearTarget();
		scene.idle(90);

		if (speed) {
			scene.world.multiplyKineticSpeed(util.select.everywhere(), 4);
			scene.effects.rotationSpeedIndicator(util.grid.at(6, 1, 3));
			scene.idle(5);
			scene.effects.indicateSuccess(gaugePos);

		} else {
			BlockState state = AllBlocks.CRUSHING_WHEEL.getDefaultState()
				.setValue(CrushingWheelBlock.AXIS, Axis.X);
			scene.world.setBlock(util.grid.at(5, 1, 3), state, true);
			scene.world.setKineticSpeed(util.select.position(5, 1, 3), 32);
			scene.world.modifyBlockEntityNBT(util.select.position(gaugePos), StressGaugeBlockEntity.class,
				nbt -> nbt.putFloat("Value", .5f));
			scene.effects.indicateRedstone(gaugePos);
			scene.idle(20);
			scene.world.setBlock(util.grid.at(4, 1, 3), state, true);
			scene.world.setKineticSpeed(util.select.position(4, 1, 3), 32);
			scene.world.modifyBlockEntityNBT(util.select.position(gaugePos), StressGaugeBlockEntity.class,
				nbt -> nbt.putFloat("Value", .9f));
			scene.effects.indicateRedstone(gaugePos);
			scene.idle(10);
		}

		scene.idle(30);

		Vec3 blockSurface = util.vector.blockSurface(gaugePos, Direction.NORTH);
		scene.overlay.showControls(
			new InputWindowElement(blockSurface, Pointing.RIGHT).withItem(AllItems.GOGGLES.asStack()), 80);
		scene.idle(7);
		scene.overlay.showText(80)
			.text("When wearing Engineers' Goggles, the player can get more detailed information from the Gauge")
			.attachKeyFrame()
			.colored(PonderPalette.MEDIUM)
			.pointAt(blockSurface)
			.placeNearTarget();
		scene.idle(100);

		Selection comparator = util.select.fromTo(2, 1, 1, 2, 1, 2);
		scene.world.showSection(comparator, Direction.SOUTH);
		scene.idle(10);
		scene.world.toggleRedstonePower(comparator);
		scene.effects.indicateRedstone(util.grid.at(2, 1, 2));
		scene.idle(20);

		scene.overlay.showText(120)
			.text("Comparators can emit analog Restone Signals relative to the " + component + "'s measurements")
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.pointAt(util.vector.centerOf(2, 1, 2)
				.add(0, -0.35, 0))
			.placeNearTarget();
		scene.idle(130);
		scene.markAsFinished();
	}

	public static void creativeMotorMojang(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("creative_motor_mojang", "Mojang's Enigma");
		scene.configureBasePlate(0, 0, 15);
		scene.scaleSceneView(.55f);
		scene.showBasePlate();
		scene.idle(15);
		scene.world.showSection(util.select.fromTo(12, 1, 7, 12, 1, 2), Direction.WEST);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(5, 1, 2, 7, 2, 1), Direction.EAST);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(7, 1, 3, 7, 1, 8), Direction.NORTH);
		scene.idle(3);
		scene.world.showSection(util.select.position(7, 2, 8), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.position(4, 1, 4), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.position(4, 1, 6), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.position(3, 1, 10), Direction.SOUTH);
		scene.idle(3);
		scene.world.showSection(util.select.position(1, 1, 11), Direction.EAST);
		scene.idle(3);
		scene.world.showSection(util.select.position(11, 1, 3), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(11, 2, 3, 11, 2, 7), Direction.NORTH);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(8, 1, 2, 10, 1, 2), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.position(11, 1, 2), Direction.SOUTH);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(6, 1, 8, 5, 1, 8), Direction.EAST);
		scene.rotateCameraY(-90);
		scene.idle(3);
		scene.world.showSection(util.select.position(12, 1, 10), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.position(11, 1, 12), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(8, 1, 8, 11, 1, 8), Direction.WEST);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(5, 2, 8, 5, 3, 8), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(8, 1, 5, 8, 2, 7), Direction.WEST);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(7, 3, 9, 8, 3, 8), Direction.UP);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(6, 3, 7, 9, 3, 7)
			.add(util.select.fromTo(6, 3, 8, 6, 3, 10))
			.add(util.select.fromTo(7, 3, 10, 9, 3, 10))
			.add(util.select.fromTo(9, 3, 7, 9, 3, 9)), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(10, 4, 7, 6, 4, 10), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(8, 1, 13, 8, 2, 11), Direction.NORTH);
		scene.idle(3);
		scene.idle(20);
	}

}
//文件scenes/MechanicalDrillScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class MechanicalDrillScenes {

	public static void breaker(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_drill", "Breaking Blocks with the Mechanical Drill");
		scene.configureBasePlate(0, 0, 5);

		scene.world.setKineticSpeed(util.select.layer(0), -8);
		scene.world.setKineticSpeed(util.select.layer(1), 16);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 5, 1, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(3, 1, 2), Direction.EAST);
		scene.idle(20);

		BlockPos breakingPos = util.grid.at(2, 1, 2);

		scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);
		scene.idle(5);
		for (int i = 0; i < 10; i++) {
			scene.idle(10);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			if (i == 1) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.placeNearTarget()
					.pointAt(util.vector.topOf(breakingPos))
					.text("When given Rotational Force, a Mechanical Drill will break blocks directly in front of it");
			}
		}

		scene.world.hideSection(util.select.position(breakingPos), Direction.UP);
		ElementLink<EntityElement> plankEntity = scene.world.createItemEntity(util.vector.centerOf(breakingPos),
			util.vector.of(0, .1f, 0), new ItemStack(Items.OAK_PLANKS));
		scene.idle(20);
		scene.idle(15);
		
		scene.world.modifyEntity(plankEntity, Entity::discard);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> 4 * f);
		scene.effects.rotationSpeedIndicator(breakingPos.east(3));
		scene.idle(5);
		scene.world.setBlock(breakingPos, Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.world.showSection(util.select.position(breakingPos), Direction.DOWN);

		scene.idle(5);
		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			if (i == 2) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.placeNearTarget()
					.pointAt(util.vector.topOf(breakingPos.east()))
					.text("Its mining speed depends on the Rotational Input");
			}
		}

		scene.world.createItemEntity(util.vector.centerOf(breakingPos), util.vector.of(0, .1f, 0),
			new ItemStack(Items.OAK_PLANKS));
		scene.idle(50);
	}

	public static void contraption(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_drill_contraption", "Using Mechanical Drills on Contraptions");
		scene.configureBasePlate(0, 0, 6);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		Selection kinetics = util.select.fromTo(5, 1, 2, 5, 1, 6);

		scene.idle(5);
		ElementLink<WorldSectionElement> pistonHead =
			scene.world.showIndependentSection(util.select.fromTo(5, 1, 1, 7, 1, 1), Direction.DOWN);
		scene.world.moveSection(pistonHead, util.vector.of(0, 0, 1), 0);
		scene.world.showSection(kinetics, Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(4, 2, 3, 4, 1, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(3, 1, 3), Direction.EAST, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(3, 1, 2), Direction.EAST, contraption);
		scene.world.showSectionAndMerge(util.select.position(3, 2, 3), Direction.EAST, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(3, 2, 2), Direction.EAST, contraption);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(3, 2, 3)))
			.text("Whenever Drills are moved as part of an animated Contraption...");
		scene.idle(70);

		Selection drills = util.select.fromTo(3, 1, 2, 3, 2, 3);

		Selection planks = util.select.fromTo(1, 1, 2, 1, 2, 3);
		scene.world.showSection(planks, Direction.DOWN);
		scene.world.setKineticSpeed(util.select.position(4, 0, 6), -8);
		scene.world.setKineticSpeed(kinetics, 16);
		scene.world.setKineticSpeed(drills, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(drills, 64);

		BlockPos p1 = util.grid.at(1, 1, 2);
		BlockPos p2 = util.grid.at(1, 1, 3);
		BlockPos p3 = util.grid.at(1, 2, 2);
		BlockPos p4 = util.grid.at(1, 2, 3);

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(p1);
			scene.world.incrementBlockBreakingProgress(p2);
			scene.world.incrementBlockBreakingProgress(p3);
			scene.world.incrementBlockBreakingProgress(p4);
			if (i == 2) {
				scene.overlay.showText(80)
					.placeNearTarget()
					.pointAt(util.vector.topOf(p3))
					.text("...they will break blocks the contraption runs them into");
			}
		}

		Vec3 m = util.vector.of(-.1, 0, 0);
		ItemStack item = new ItemStack(Items.OAK_PLANKS);
		scene.world.createItemEntity(util.vector.centerOf(p1), m, item);
		scene.world.createItemEntity(util.vector.centerOf(p2), m, item);
		scene.world.createItemEntity(util.vector.centerOf(p3), m, item);
		scene.world.createItemEntity(util.vector.centerOf(p4), m, item);

		scene.world.setKineticSpeed(drills, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(drills, 0);
		scene.idle(20);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(2, 0, 0), 40);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);
		scene.world.hideSection(planks, Direction.UP);
		scene.idle(40);

		scene.world.setBlocks(planks, Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.glueBlockOnto(util.grid.at(4, 3, 2), Direction.DOWN, contraption);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(4, 3, 2), Direction.WEST))
			.sharedText("storage_on_contraption");
		scene.idle(70);

		scene.world.showSection(planks, Direction.DOWN);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.setKineticSpeed(drills, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);

		scene.idle(20);
		scene.world.setKineticSpeed(drills, 64);

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(p1);
			scene.world.incrementBlockBreakingProgress(p2);
			scene.world.incrementBlockBreakingProgress(p3);
			scene.world.incrementBlockBreakingProgress(p4);
		}

		scene.world.setKineticSpeed(drills, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(drills, 0);
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(2, 3, 2), Pointing.DOWN)
			.withItem(new ItemStack(Blocks.OAK_PLANKS)), 60);
		scene.idle(20);
	}

}
//文件scenes/MechanicalSawScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.saw.SawBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class MechanicalSawScenes {

	public static void processing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_saw_processing", "Processing Items on the Mechanical Saw");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos shaftPos = util.grid.at(2, 1, 3);
		scene.world.setBlock(shaftPos, AllBlocks.SHAFT.getDefaultState()
			.setValue(ShaftBlock.AXIS, Axis.Z), false);

		BlockPos sawPos = util.grid.at(2, 1, 2);
		Selection sawSelect = util.select.position(sawPos);
		scene.world.modifyBlockEntityNBT(sawSelect, SawBlockEntity.class, nbt -> nbt.putInt("RecipeIndex", 0));

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(2, 1, 3, 2, 1, 5), Direction.DOWN);
		scene.idle(10);
		scene.effects.rotationDirectionIndicator(shaftPos);
		scene.world.showSection(sawSelect, Direction.DOWN);
		scene.idle(10);
		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("Upward facing Mechanical Saws can process a variety of items")
			.pointAt(util.vector.blockSurface(sawPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(45);

		ItemStack log = new ItemStack(Items.OAK_LOG);
		ItemStack strippedLog = new ItemStack(Items.STRIPPED_OAK_LOG);
		ItemStack planks = new ItemStack(Items.OAK_PLANKS);

		Vec3 itemSpawn = util.vector.centerOf(sawPos.above()
			.west());
		ElementLink<EntityElement> logItem = scene.world.createItemEntity(itemSpawn, util.vector.of(0, 0, 0), log);
		scene.idle(12);

		scene.overlay.showControls(new InputWindowElement(itemSpawn, Pointing.DOWN).withItem(log), 20);
		scene.idle(10);

		scene.world.modifyEntity(logItem, e -> e.setDeltaMovement(util.vector.of(0.05, 0.2, 0)));
		scene.idle(12);

		scene.world.modifyEntity(logItem, Entity::discard);
		scene.world.createItemOnBeltLike(sawPos, Direction.WEST, log);
		scene.idle(50);

		logItem = scene.world.createItemEntity(util.vector.topOf(sawPos)
			.add(0.5, -.1, 0), util.vector.of(0.05, 0.18, 0), strippedLog);
		scene.idle(12);
		scene.overlay.showControls(new InputWindowElement(itemSpawn.add(2, 0, 0), Pointing.DOWN).withItem(strippedLog),
			20);
		scene.idle(30);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("The processed item always moves against the rotational input to the saw")
			.pointAt(util.vector.blockSurface(sawPos, Direction.UP))
			.placeNearTarget();
		scene.idle(70);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -2 * f);
		scene.effects.rotationDirectionIndicator(shaftPos);
		scene.world.modifyEntity(logItem, e -> e.setDeltaMovement(util.vector.of(-0.05, 0.2, 0)));
		scene.idle(12);

		scene.world.modifyEntity(logItem, Entity::discard);
		scene.world.createItemOnBeltLike(sawPos, Direction.EAST, strippedLog);
		scene.idle(25);

		logItem = scene.world.createItemEntity(util.vector.topOf(sawPos)
			.add(-0.5, -.1, 0), util.vector.of(-0.05, 0.18, 0), planks);
		scene.idle(22);

		Selection otherBelt = util.select.fromTo(3, 1, 3, 4, 1, 2);
		Selection belt = util.select.fromTo(0, 1, 2, 1, 1, 3);

		scene.world.setKineticSpeed(otherBelt, 0);
		scene.world.setKineticSpeed(belt, 0);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.modifyEntity(logItem, Entity::discard);
		scene.world.setBlock(shaftPos, AllBlocks.COGWHEEL.getDefaultState()
			.setValue(ShaftBlock.AXIS, Axis.Z), true);
		scene.idle(3);
		scene.addKeyframe();

		scene.world.multiplyKineticSpeed(util.select.everywhere(), .5f);
		
		ElementLink<WorldSectionElement> beltSection = scene.world.showIndependentSection(belt, Direction.EAST);
		scene.world.moveSection(beltSection, util.vector.of(0, 100, 0), 0);
		scene.idle(1);
		scene.world.removeItemsFromBelt(util.grid.at(1, 1, 2));
		scene.idle(1);
		scene.world.setKineticSpeed(belt, -64);
		scene.idle(1);
		scene.world.moveSection(beltSection, util.vector.of(0, -100, 0), 0);
		scene.idle(3);

		ElementLink<WorldSectionElement> otherBeltSection =
			scene.world.showIndependentSection(otherBelt, Direction.WEST);
		scene.world.moveSection(otherBeltSection, util.vector.of(0, 100, 0), 0);
		scene.idle(1);
		scene.world.removeItemsFromBelt(util.grid.at(3, 1, 2));
		scene.idle(1);
		scene.world.setKineticSpeed(otherBelt, -64);
		scene.idle(1);
		scene.world.moveSection(otherBeltSection, util.vector.of(0, -100, 0), 0);
		scene.idle(3);

		ItemStack stone = new ItemStack(Blocks.STONE);
		BlockPos firstBelt = util.grid.at(0, 1, 2);
		scene.overlay.showText(60)
			.text("Saws can work in-line with Mechanical Belts")
			.pointAt(util.vector.blockSurface(firstBelt, Direction.WEST))
			.placeNearTarget();
		scene.idle(40);
		scene.world.createItemOnBelt(firstBelt, Direction.WEST, stone);

		scene.idle(40);
		Vec3 filter = util.vector.of(2.5, 1 + 13 / 16f, 2 + 5 / 16f);
		scene.overlay.showFilterSlotInput(filter, Direction.UP, 80);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("When an ingredient has multiple possible outcomes, the filter slot can specify it")
			.pointAt(filter)
			.placeNearTarget();
		scene.idle(90);

		ItemStack bricks = new ItemStack(Blocks.STONE_BRICKS);
		scene.overlay.showControls(new InputWindowElement(filter, Pointing.DOWN).withItem(bricks), 30);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(7);
		scene.world.setFilterData(util.select.position(sawPos), SawBlockEntity.class, bricks);
		scene.idle(10);
		scene.world.createItemOnBelt(firstBelt, Direction.WEST, stone);
		scene.idle(50);

		scene.markAsFinished();
		scene.overlay.showText(100)
			.text("Without filter, the Saw would cycle through all outcomes instead")
			.colored(PonderPalette.RED)
			.pointAt(filter)
			.placeNearTarget();
		scene.idle(65);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
	}

	public static void treeCutting(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_saw_breaker", "Cutting Trees with the Mechanical Saw");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(.9f);
		scene.world.setBlock(util.grid.at(2, 0, 2), Blocks.GRASS_BLOCK.defaultBlockState(), false);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.position(3, 1, 1))
			.add(util.select.position(1, 1, 2)), Direction.UP);

		scene.world.setKineticSpeed(util.select.position(5, 0, 1), -8);
		scene.world.setKineticSpeed(util.select.fromTo(3, 1, 2, 5, 1, 2), 16);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 5, 1, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(3, 1, 2), Direction.DOWN);

		scene.idle(20);
		scene.world.showSection(util.select.fromTo(2, 1, 2, 2, 3, 2), Direction.UP);
		scene.world.showSection(util.select.layersFrom(4), Direction.UP);

		BlockPos breakingPos = util.grid.at(2, 1, 2);
		scene.idle(5);
		for (int i = 0; i < 10; i++) {
			scene.idle(10);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			if (i == 1) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.placeNearTarget()
					.pointAt(util.vector.blockSurface(breakingPos, Direction.WEST))
					.text("When given Rotational Force, a Mechanical Saw will cut trees directly in front of it");
			}
		}

		scene.world.replaceBlocks(util.select.fromTo(2, 2, 2, 2, 6, 2), Blocks.AIR.defaultBlockState(), true);

		scene.world.destroyBlock(util.grid.at(3, 5, 0));
		scene.world.destroyBlock(util.grid.at(0, 4, 1));
		scene.world.destroyBlock(util.grid.at(2, 6, 1));
		scene.world.destroyBlock(util.grid.at(1, 4, 0));
		scene.world.destroyBlock(util.grid.at(1, 6, 2));
		scene.world.destroyBlock(util.grid.at(1, 5, 3));
		scene.world.destroyBlock(util.grid.at(0, 4, 3));

		scene.world.replaceBlocks(util.select.layersFrom(4), Blocks.AIR.defaultBlockState(), false);

		for (int i = 0; i < 5; i++) {
			Vec3 dropPos = util.vector.centerOf(breakingPos.above(i));
			float distance = (float) dropPos.distanceTo(util.vector.centerOf(breakingPos));
			scene.world.createItemEntity(dropPos, util.vector.of(-distance / 20, 0, 0), new ItemStack(Items.OAK_LOG));
		}

		scene.idle(35);
		scene.world.destroyBlock(util.grid.at(1, 1, 2));
		scene.world.hideSection(util.select.layersFrom(2)
			.add(util.select.fromTo(2, 1, 2, 1, 1, 3)), Direction.UP);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(15);
		scene.world.setBlocks(util.select.fromTo(2, 1, 2, 1, 20, 3), Blocks.JUNGLE_LOG.defaultBlockState(), false);
		scene.world.showSection(util.select.layersFrom(2)
			.add(util.select.fromTo(2, 1, 2, 1, 1, 3)), Direction.UP);
		scene.idle(15);

		scene.world.hideSection(util.select.fromTo(2, 1, 2, 1, 1, 3)
			.substract(util.select.position(breakingPos)), Direction.WEST);
		scene.idle(10);
		scene.overlay.showSelectionWithText(util.select.position(breakingPos), 90)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.text("In order to cut the tree fully, the Saw has to break the last block connecting it to the ground");

		scene.idle(25);
		for (int i = 0; i < 10; i++) {
			scene.idle(10);
			scene.world.incrementBlockBreakingProgress(breakingPos);
		}

		for (int i = 0; i < 30; i++) {
			scene.world.replaceBlocks(util.select.fromTo(2, i + 1, 2, 1, i + 1, 3), Blocks.AIR.defaultBlockState(),
				true);
			for (int x = 1; x <= 2; x++) {
				for (int z = 2; z <= 3; z++) {
					Vec3 dropPos = util.vector.centerOf(x, i + 1, z);
					float distance = (float) dropPos.distanceTo(util.vector.centerOf(breakingPos));
					scene.world.createItemEntity(dropPos, util.vector.of(-distance / 20, 0, 0),
						new ItemStack(Items.JUNGLE_LOG));
				}
			}
			scene.idle(1);
		}
	}

	public static void contraption(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_saw_contraption", "Using Mechanical Saws on Contraptions");
		scene.configureBasePlate(1, 0, 6);
		scene.scaleSceneView(.9f);
		scene.world.setBlock(util.grid.at(2, 0, 3), Blocks.GRASS_BLOCK.defaultBlockState(), false);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.position(3, 1, 1))
			.add(util.select.position(1, 1, 2))
			.add(util.select.position(2, 1, 4)), Direction.UP);

		Selection kinetics = util.select.fromTo(6, 1, 2, 6, 1, 6);

		scene.idle(5);
		ElementLink<WorldSectionElement> pistonHead =
			scene.world.showIndependentSection(util.select.fromTo(6, 1, 1, 8, 1, 1), Direction.DOWN);
		scene.world.moveSection(pistonHead, util.vector.of(0, 0, 1), 0);
		scene.world.showSection(kinetics, Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(5, 1, 3, 5, 1, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(4, 1, 3), Direction.EAST, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(4, 1, 2), Direction.EAST, contraption);
		scene.idle(5);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(4, 1, 3)))
			.text("Whenever Saws are moved as part of an animated Contraption...");
		scene.idle(70);

		Selection saws = util.select.fromTo(4, 1, 2, 4, 1, 3);

		Selection tree = util.select.fromTo(2, 1, 3, 2, 7, 3)
			.add(util.select.layersFrom(3));
		scene.world.showSection(tree, Direction.UP);
		scene.world.setKineticSpeed(util.select.position(5, 0, 6), -8);
		scene.world.setKineticSpeed(kinetics, 16);
		scene.world.setKineticSpeed(saws, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);

		BlockPos breakingPos = util.grid.at(2, 1, 3);

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(breakingPos);
			if (i == 2) {
				scene.overlay.showText(80)
					.placeNearTarget()
					.pointAt(util.vector.blockSurface(breakingPos, Direction.WEST))
					.text("...they will cut any trees the contraption runs them into");
			}
		}

		scene.world.replaceBlocks(util.select.fromTo(2, 2, 3, 2, 6, 3), Blocks.AIR.defaultBlockState(), true);
		scene.world.destroyBlock(util.grid.at(4, 5, 1));
		scene.world.destroyBlock(util.grid.at(1, 4, 2));
		scene.world.destroyBlock(util.grid.at(3, 6, 2));
		scene.world.destroyBlock(util.grid.at(2, 4, 1));
		scene.world.destroyBlock(util.grid.at(2, 6, 3));
		scene.world.destroyBlock(util.grid.at(2, 5, 2));
		scene.world.destroyBlock(util.grid.at(1, 4, 2));
		scene.world.replaceBlocks(util.select.layersFrom(4), Blocks.AIR.defaultBlockState(), false);

		for (int i = 0; i < 5; i++) {
			Vec3 dropPos = util.vector.centerOf(breakingPos.above(i));
			float distance = (float) dropPos.distanceTo(util.vector.centerOf(breakingPos));
			scene.world.createItemEntity(dropPos, util.vector.of(-distance / 20, 0, 0), new ItemStack(Items.OAK_LOG));
		}

		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(saws, 0);
		scene.idle(20);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(2, 0, 0), 40);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);
		scene.world.hideSection(tree, Direction.UP);
		scene.idle(40);

		scene.world.restoreBlocks(tree);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.glueBlockOnto(util.grid.at(5, 2, 2), Direction.DOWN, contraption);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(5, 2, 2), Direction.WEST))
			.sharedText("storage_on_contraption");
		scene.idle(70);

		scene.world.showSection(tree, Direction.DOWN);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.setKineticSpeed(saws, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(breakingPos);
		}

		scene.world.replaceBlocks(util.select.fromTo(2, 2, 3, 2, 6, 3), Blocks.AIR.defaultBlockState(), true);
		scene.world.destroyBlock(util.grid.at(4, 5, 1));
		scene.world.destroyBlock(util.grid.at(1, 4, 2));
		scene.world.destroyBlock(util.grid.at(3, 6, 2));
		scene.world.destroyBlock(util.grid.at(2, 4, 1));
		scene.world.destroyBlock(util.grid.at(2, 6, 3));
		scene.world.destroyBlock(util.grid.at(2, 5, 2));
		scene.world.destroyBlock(util.grid.at(1, 4, 2));
		scene.world.replaceBlocks(util.select.layersFrom(4), Blocks.AIR.defaultBlockState(), false);

		scene.world.moveSection(pistonHead, util.vector.of(-1, 0, 0), 20);
		scene.world.moveSection(contraption, util.vector.of(-1, 0, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(saws, 0);
		scene.idle(10);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(3, 2, 2), Pointing.DOWN).withItem(new ItemStack(Blocks.OAK_LOG)),
			60);
		scene.idle(20);
	}

}
//文件scenes/MovementActorScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.actors.contraptionControls.ContraptionControlsBlockEntity;
import com.simibubi.create.content.contraptions.actors.harvester.HarvesterBlockEntity;
import com.simibubi.create.content.contraptions.actors.psi.PortableItemInterfaceBlockEntity;
import com.simibubi.create.content.contraptions.actors.psi.PortableStorageInterfaceBlockEntity;
import com.simibubi.create.content.contraptions.chassis.LinearChassisBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FlappyPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class MovementActorScenes {

	public static void psiTransfer(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("portable_storage_interface", "Contraption Storage Exchange");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.95f);
		scene.setSceneOffsetY(-1);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos bearing = util.grid.at(5, 1, 2);
		scene.world.showSection(util.select.position(bearing), Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(5, 2, 2, 6, 3, 2), Direction.DOWN);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearing));
		scene.idle(10);
		scene.world.rotateBearing(bearing, 360, 70);
		scene.world.rotateSection(contraption, 0, 360, 0, 70);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(bearing.above(2)))
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Moving inventories can be tricky to access with automation.");

		scene.idle(70);
		BlockPos psi = util.grid.at(4, 2, 2);
		scene.world.showSectionAndMerge(util.select.position(psi), Direction.EAST, contraption);
		scene.idle(13);
		scene.effects.superGlue(psi, Direction.EAST, true);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(psi))
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.attachKeyFrame()
			.text("This component can interact with storage without the need to stop the contraption.");
		scene.idle(90);

		BlockPos psi2 = psi.west(2);
		scene.world.showSection(util.select.position(psi2), Direction.DOWN);
		scene.overlay.showSelectionWithText(util.select.position(psi.west()), 50)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Place a second one with a gap of 1 or 2 blocks inbetween");
		scene.idle(55);

		scene.world.rotateBearing(bearing, 360, 60);
		scene.world.rotateSection(contraption, 0, 360, 0, 60);
		scene.idle(20);

		scene.overlay.showText(40)
			.placeNearTarget()
			.pointAt(util.vector.of(3, 3, 2.5))
			.text("Whenever they pass by each other, they will engage in a connection");
		scene.idle(38);

		Selection both = util.select.fromTo(2, 2, 2, 4, 2, 2);
		Class<PortableItemInterfaceBlockEntity> psiClass = PortableItemInterfaceBlockEntity.class;

		scene.world.modifyBlockEntityNBT(both, psiClass, nbt -> {
			nbt.putFloat("Distance", 1);
			nbt.putFloat("Timer", 12);
		});

		scene.idle(17);
		scene.overlay.showOutline(PonderPalette.GREEN, psi, util.select.fromTo(5, 3, 2, 6, 3, 2), 80);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.position(psi2), 70)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.text("While engaged, the stationary interface will represent ALL inventories on the contraption");

		scene.idle(80);

		BlockPos hopper = util.grid.at(2, 3, 2);
		scene.world.showSection(util.select.position(hopper), Direction.DOWN);
		scene.overlay.showText(70)
			.placeNearTarget()
			.pointAt(util.vector.topOf(hopper))
			.attachKeyFrame()
			.text("Items can now be inserted...");

		ItemStack itemStack = new ItemStack(Items.COPPER_INGOT);
		Vec3 entitySpawn = util.vector.topOf(hopper.above(3));

		ElementLink<EntityElement> entity1 =
			scene.world.createItemEntity(entitySpawn, util.vector.of(0, 0.2, 0), itemStack);
		scene.idle(10);
		ElementLink<EntityElement> entity2 =
			scene.world.createItemEntity(entitySpawn, util.vector.of(0, 0.2, 0), itemStack);
		scene.idle(10);
		scene.world.modifyEntity(entity1, Entity::discard);
		scene.idle(10);
		scene.world.modifyEntity(entity2, Entity::discard);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(5, 3, 2), Pointing.DOWN).withItem(itemStack), 40);

		scene.idle(30);
		scene.world.hideSection(util.select.position(hopper), Direction.UP);
		scene.idle(15);

		BlockPos beltPos = util.grid.at(1, 1, 2);
		scene.world.showSection(util.select.fromTo(0, 1, 0, 1, 2, 6), Direction.DOWN);
		scene.idle(10);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, itemStack.copy());
		scene.overlay.showText(40)
			.placeNearTarget()
			.pointAt(util.vector.topOf(beltPos.above()))
			.text("...or extracted from the contraption");
		scene.idle(15);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, itemStack);

		scene.idle(20);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(15);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);

		scene.overlay.showText(120)
			.placeNearTarget()
			.pointAt(util.vector.topOf(psi2))
			.text("After no items have been exchanged for a while, the contraption will continue on its way");
		scene.world.modifyBlockEntityNBT(both, psiClass, nbt -> nbt.putFloat("Timer", 2));

		scene.idle(15);
		scene.markAsFinished();
		scene.world.rotateBearing(bearing, 270, 120);
		scene.world.rotateSection(contraption, 0, 270, 0, 120);
	}

	public static void psiRedstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("portable_storage_interface_redstone", "Redstone Control");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);

		Class<PortableStorageInterfaceBlockEntity> psiClass = PortableStorageInterfaceBlockEntity.class;
		Selection psis = util.select.fromTo(1, 1, 3, 1, 3, 3);
		scene.world.modifyBlockEntityNBT(psis, psiClass, nbt -> {
			nbt.putFloat("Distance", 1);
			nbt.putFloat("Timer", 12);
		});

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.layer(1), Direction.DOWN);
		scene.idle(5);

		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.layersFrom(2), Direction.DOWN);
		BlockPos bearing = util.grid.at(3, 1, 3);
		scene.world.configureCenterOfRotation(contraption, util.vector.topOf(bearing));
		scene.idle(20);
		scene.world.modifyBlockEntityNBT(psis, psiClass, nbt -> nbt.putFloat("Timer", 2));
		scene.world.rotateBearing(bearing, 360 * 3 + 270, 240 + 60);
		scene.world.rotateSection(contraption, 0, 360 * 3 + 270, 0, 240 + 60);
		scene.idle(20);

		scene.world.toggleRedstonePower(util.select.fromTo(1, 1, 1, 1, 1, 2));
		scene.effects.indicateRedstone(util.grid.at(1, 1, 1));

		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.position(1, 1, 3), 120)
			.colored(PonderPalette.RED)
			.text("Redstone power will prevent the stationary interface from engaging");

		scene.idle(20);
		scene.markAsFinished();
	}

	public static void harvester(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_harvester", "Using Mechanical Harvesters on Contraptions");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.9f);

		Selection crops = util.select.fromTo(4, 1, 2, 3, 1, 2)
			.add(util.select.fromTo(3, 1, 1, 2, 1, 1)
				.add(util.select.position(2, 1, 3))
				.add(util.select.position(1, 1, 2)));

		scene.world.setBlocks(crops, Blocks.WHEAT.defaultBlockState()
			.setValue(CropBlock.AGE, 7), false);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos bearingPos = util.grid.at(4, 1, 4);

		scene.idle(5);
		scene.world.showSection(crops, Direction.UP);
		scene.world.showSection(util.select.position(bearingPos), Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(4, 2, 4, 2, 2, 5)
				.add(util.select.fromTo(2, 1, 5, 0, 1, 5)), Direction.DOWN);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearingPos));
		scene.idle(10);

		for (int i = 0; i < 3; i++) {
			scene.world.showSectionAndMerge(util.select.position(i, 1, 4), Direction.SOUTH, contraption);
			scene.idle(5);
		}

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 4), Direction.SOUTH))
			.text("Whenever Harvesters are moved as part of an animated Contraption...");
		scene.idle(70);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(i, 1, 4), HarvesterBlockEntity.class,
				hte -> hte.setAnimatedSpeed(-150));
		scene.world.rotateBearing(bearingPos, -360, 140);
		scene.world.rotateSection(contraption, 0, -360, 0, 140);

		BlockState harvested = Blocks.WHEAT.defaultBlockState();
		ItemStack wheatItem = new ItemStack(Items.WHEAT);

		scene.idle(5);
		BlockPos current = util.grid.at(2, 1, 3);
		scene.world.setBlock(current, harvested, true);
		scene.world.createItemEntity(util.vector.centerOf(current), util.vector.of(0, 0.3, -.2), wheatItem);
		scene.idle(5);
		current = util.grid.at(1, 1, 2);
		scene.world.setBlock(current, harvested, true);
		scene.world.createItemEntity(util.vector.centerOf(current), util.vector.of(0, 0.3, -.2), wheatItem);
		scene.idle(5);
		current = util.grid.at(3, 1, 2);
		scene.world.setBlock(current, harvested, true);
		scene.world.createItemEntity(util.vector.centerOf(current), util.vector.of(.1, 0.3, -.1), wheatItem);
		current = util.grid.at(2, 1, 1);
		scene.world.setBlock(current, harvested, true);
		scene.world.createItemEntity(util.vector.centerOf(current), util.vector.of(.1, 0.3, -.1), wheatItem);
		scene.idle(5);
		current = util.grid.at(3, 1, 1);
		scene.world.setBlock(current, harvested, true);
		scene.world.createItemEntity(util.vector.centerOf(current), util.vector.of(.1, 0.3, -.1), wheatItem);
		scene.idle(5);
		current = util.grid.at(4, 1, 2);
		scene.world.setBlock(current, harvested, true);
		scene.world.createItemEntity(util.vector.centerOf(current), util.vector.of(.2, 0.3, 0), wheatItem);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(1, 0, 2))
			.text("They will harvest and reset any mature crops on their way")
			.placeNearTarget();

		scene.idle(101);
		scene.world.hideSection(crops, Direction.DOWN);
		scene.idle(15);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.setBlocks(crops, Blocks.WHEAT.defaultBlockState()
			.setValue(CropBlock.AGE, 7), false);
		scene.world.showSection(crops, Direction.UP);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(i, 1, 4), HarvesterBlockEntity.class,
				hte -> hte.setAnimatedSpeed(0));
		scene.idle(10);

		scene.world.cycleBlockProperty(util.grid.at(1, 1, 5), LinearChassisBlock.STICKY_TOP);
		scene.world.glueBlockOnto(util.grid.at(1, 2, 5), Direction.DOWN, contraption);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 5), Direction.WEST))
			.sharedText("storage_on_contraption");
		scene.idle(70);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(i, 1, 4), HarvesterBlockEntity.class,
				hte -> hte.setAnimatedSpeed(-150));
		scene.world.rotateBearing(bearingPos, -360, 140);
		scene.world.rotateSection(contraption, 0, -360, 0, 140);

		scene.idle(5);
		current = util.grid.at(2, 1, 3);
		scene.world.setBlock(current, harvested, true);
		scene.idle(5);
		current = util.grid.at(1, 1, 2);
		scene.world.setBlock(current, harvested, true);
		scene.idle(5);
		current = util.grid.at(3, 1, 2);
		scene.world.setBlock(current, harvested, true);
		current = util.grid.at(2, 1, 1);
		scene.world.setBlock(current, harvested, true);
		scene.idle(5);
		current = util.grid.at(3, 1, 1);
		scene.world.setBlock(current, harvested, true);
		scene.idle(5);
		current = util.grid.at(4, 1, 2);
		scene.world.setBlock(current, harvested, true);

		scene.idle(116);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(1, 2, 5), Pointing.DOWN).withItem(wheatItem), 50);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(i, 1, 4), HarvesterBlockEntity.class,
				hte -> hte.setAnimatedSpeed(0));
	}

	public static void plough(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_plough", "Using Mechanical Ploughs on Contraptions");
		scene.configureBasePlate(0, 0, 6);
		scene.scaleSceneView(0.9f);

		Selection garbage = util.select.fromTo(2, 1, 3, 1, 1, 2);
		Selection kinetics = util.select.fromTo(5, 1, 6, 5, 1, 2);
		Selection dynamic = util.select.fromTo(4, 0, 6, 5, 1, 6);

		scene.showBasePlate();
		ElementLink<WorldSectionElement> cogs =
			scene.world.showIndependentSection(util.select.fromTo(4, 0, 6, 5, 1, 6), Direction.UP);
		scene.idle(5);
		scene.world.showSection(kinetics.substract(dynamic), Direction.DOWN);
		ElementLink<WorldSectionElement> pistonHead =
			scene.world.showIndependentSection(util.select.fromTo(5, 1, 1, 7, 1, 1), Direction.DOWN);
		scene.world.moveSection(pistonHead, util.vector.of(0, 0, 1), 0);
		scene.idle(5);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.fromTo(4, 1, 3, 4, 1, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.position(3, 1, 3), Direction.EAST, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(3, 1, 2), Direction.EAST, contraption);
		scene.idle(20);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.EAST))
			.text("Whenever Ploughs are moved as part of an animated Contraption...");
		scene.idle(50);
		scene.world.showSection(garbage, Direction.EAST);
		scene.idle(20);

		scene.world.setKineticSpeed(util.select.position(4, 0, 6), -8);
		scene.world.setKineticSpeed(kinetics, 16);
		scene.world.moveSection(pistonHead, util.vector.of(-2, 0, 0), 60);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 60);
		scene.idle(15);

		Vec3 m = util.vector.of(-0.1, .2, 0);
		scene.world.destroyBlock(util.grid.at(2, 1, 3));
		scene.world.createItemEntity(util.vector.centerOf(2, 1, 3), m, new ItemStack(Items.LEVER));
		scene.world.destroyBlock(util.grid.at(2, 1, 2));
		scene.world.createItemEntity(util.vector.centerOf(2, 1, 2), m, new ItemStack(Items.TORCH));

		scene.idle(30);

		scene.world.destroyBlock(util.grid.at(1, 1, 3));
		scene.world.createItemEntity(util.vector.centerOf(1, 1, 3), m, new ItemStack(Items.RAIL));
		scene.world.destroyBlock(util.grid.at(1, 1, 2));
		scene.world.createItemEntity(util.vector.centerOf(1, 1, 2), m, new ItemStack(Items.REDSTONE));

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 3), Direction.EAST))
			.text("...they will break blocks without a solid collision hitbox");
		scene.idle(50);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(2, 0, 0), 40);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);
		scene.world.hideSection(garbage, Direction.UP);
		scene.idle(40);
		scene.world.setBlocks(garbage, Blocks.SNOW.defaultBlockState(), false);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		ElementLink<WorldSectionElement> chest =
			scene.world.showIndependentSection(util.select.position(4, 2, 2), Direction.DOWN);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(4, 2, 2), Direction.WEST))
			.sharedText("storage_on_contraption");
		scene.idle(15);
		scene.effects.superGlue(util.grid.at(4, 2, 2), Direction.DOWN, true);
		scene.idle(45);
		scene.world.showSection(garbage, Direction.EAST);
		scene.idle(20);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(-2, 0, 0), 60);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 60);
		scene.world.moveSection(chest, util.vector.of(-2, 0, 0), 60);
		scene.idle(15);
		scene.world.destroyBlock(util.grid.at(2, 1, 3));
		scene.world.destroyBlock(util.grid.at(2, 1, 2));
		scene.idle(30);
		scene.world.destroyBlock(util.grid.at(1, 1, 3));
		scene.world.destroyBlock(util.grid.at(1, 1, 2));
		scene.idle(15);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(2, 2, 2), Pointing.DOWN).withItem(new ItemStack(Items.SNOWBALL)),
			40);
		scene.idle(40);
		scene.world.hideIndependentSection(chest, Direction.UP);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(2, 0, 0), 40);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);
		scene.idle(40);

		Selection dirt = util.select.fromTo(2, 0, 3, 1, 0, 2);
		scene.world.hideSection(dirt, Direction.DOWN);
		scene.idle(15);
		scene.world.setBlocks(dirt, Blocks.GRASS_BLOCK.defaultBlockState(), false);
		scene.world.showSection(dirt, Direction.UP);
		scene.overlay.showText(60)
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.EAST))
			.text("Additionally, ploughs can create farmland");
		scene.idle(30);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(-2, 0, 0), 60);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 60);
		scene.world.moveSection(chest, util.vector.of(-2, 0, 0), 60);
		scene.idle(15);
		scene.world.setBlocks(util.select.fromTo(2, 0, 2, 2, 0, 3), Blocks.FARMLAND.defaultBlockState(), true);
		scene.idle(30);
		scene.world.setBlocks(util.select.fromTo(1, 0, 2, 1, 0, 3), Blocks.FARMLAND.defaultBlockState(), true);
		scene.idle(20);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);
		scene.world.moveSection(pistonHead, util.vector.of(2, 0, 0), 40);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);

		scene.idle(50);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.world.hideSection(kinetics.substract(dynamic), Direction.EAST);
		scene.world.hideSection(dirt, Direction.DOWN);
		scene.world.hideIndependentSection(pistonHead, Direction.EAST);
		scene.world.moveSection(cogs, util.vector.of(-1, 0, 0), 15);
		scene.idle(15);
		scene.world.restoreBlocks(dirt);
		scene.world.showSection(dirt, Direction.UP);
		scene.world.showSection(util.select.fromTo(4, 1, 6, 4, 3, 4), Direction.NORTH);
		scene.idle(15);
		scene.world.showSectionAndMerge(util.select.fromTo(4, 3, 3, 4, 2, 3), Direction.DOWN, contraption);
		scene.idle(15);

		BlockPos bearingPos = util.grid.at(4, 3, 4);
		scene.addKeyframe();

		scene.world.setKineticSpeed(util.select.position(4, 0, 6), 8);
		scene.world.setKineticSpeed(util.select.position(5, 1, 6), -16);
		scene.world.setKineticSpeed(util.select.position(4, 3, 5), -16);
		scene.world.setKineticSpeed(util.select.position(4, 1, 5), -16);
		scene.world.setKineticSpeed(util.select.position(4, 2, 5), 16);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -2 * f);
		scene.world.configureCenterOfRotation(contraption, util.vector.centerOf(bearingPos));
		scene.world.rotateSection(contraption, 0, 0, 90, 20);
		scene.world.rotateBearing(bearingPos, 90, 20);

		scene.idle(10);
		ElementLink<ParrotElement> birb = scene.special.createBirb(util.vector.topOf(3, 0, 2)
			.add(0, 0, 0.5), FlappyPose::new);
		scene.idle(11);

		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -2 * f);
		scene.world.rotateSection(contraption, 0, 0, -135, 10);
		scene.world.rotateBearing(bearingPos, -135, 10);
		scene.idle(7);
		scene.special.moveParrot(birb, util.vector.of(-20, 15, 0), 20);
		scene.special.rotateParrot(birb, 0, 360, 0, 20);
		scene.idle(3);
		scene.world.setKineticSpeed(util.select.everywhere(), 0);
		scene.idle(20);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.centerOf(util.grid.at(1, 3, 2)))
			.text("...they can also launch entities without hurting them");
		scene.idle(30);
	}

	public static void contraptionControls(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("contraption_controls", "Using Contraption Controls");
		scene.configureBasePlate(1, 0, 6);
		scene.scaleSceneView(0.9f);
		scene.showBasePlate();

		BlockPos cobblePos = util.grid.at(3, 1, 2);
		BlockPos wheatPos = util.grid.at(2, 1, 1);
		BlockPos bearingPos = util.grid.at(5, 1, 4);
		Selection contraption = util.select.fromTo(5, 2, 4, 3, 2, 5)
			.add(util.select.fromTo(3, 1, 5, 1, 1, 4));
		BlockPos controlsPos1 = util.grid.at(1, 2, 5);
		BlockPos controlsPos2 = util.grid.at(2, 2, 5);
		BlockPos drillPos = util.grid.at(2, 1, 4);
		BlockPos harvesterPos = util.grid.at(1, 1, 4);
		Selection leverCol = util.select.fromTo(0, 0, 5, 0, 2, 5);
		BlockPos leverPos = util.grid.at(0, 2, 5);
		scene.idle(5);

		scene.world.showSection(util.select.position(wheatPos), Direction.UP);
		scene.world.showSection(util.select.position(cobblePos), Direction.UP);
		scene.idle(10);

		scene.world.showSection(util.select.position(bearingPos), Direction.DOWN);
		scene.idle(5);

		ElementLink<WorldSectionElement> contraptionLink =
			scene.world.showIndependentSection(contraption, Direction.DOWN);
		scene.world.configureCenterOfRotation(contraptionLink, util.vector.centerOf(bearingPos));
		scene.idle(10);

		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(-280));
		scene.world.setKineticSpeed(util.select.position(drillPos), 64);
		scene.world.rotateBearing(bearingPos, -30, 20);
		scene.world.rotateSection(contraptionLink, 0, -30, 0, 20);

		BlockState harvested = Blocks.WHEAT.defaultBlockState();

		scene.idle(20);
		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.topOf(cobblePos))
			.text("Actors on moving contraptions are always active by default");

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(cobblePos);
		}

		Vec3 m = util.vector.of(.1, 0, -.1);
		ItemStack cobbleItem = new ItemStack(Items.COBBLESTONE);
		ItemStack wheatItem = new ItemStack(Items.WHEAT);
		ElementLink<EntityElement> item1 = scene.world.createItemEntity(util.vector.centerOf(cobblePos), m, cobbleItem);

		scene.idle(5);

		scene.world.rotateBearing(bearingPos, -60, 40);
		scene.world.rotateSection(contraptionLink, 0, -60, 0, 40);
		scene.idle(5);

		scene.world.setBlock(wheatPos, harvested, true);
		ElementLink<EntityElement> item2 = scene.world.createItemEntity(util.vector.centerOf(wheatPos), m, wheatItem);
		scene.idle(35);

		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(0));
		scene.world.setKineticSpeed(util.select.position(drillPos), 0);
		scene.idle(5);

		scene.world.modifyEntity(item1, Entity::discard);
		scene.world.modifyEntity(item2, Entity::discard);
		scene.world.hideIndependentSection(contraptionLink, Direction.UP);
		scene.idle(15);
		contraptionLink = scene.world.showIndependentSection(contraption, Direction.DOWN);
		scene.world.configureCenterOfRotation(contraptionLink, util.vector.centerOf(bearingPos));
		scene.world.moveSection(contraptionLink, util.vector.of(0, 1 / 512f, 0), 0);

		scene.world.restoreBlocks(util.select.position(wheatPos));
		scene.world.restoreBlocks(util.select.position(cobblePos));
		scene.idle(10);

		scene.world.showSectionAndMerge(util.select.position(controlsPos1), Direction.DOWN, contraptionLink);
		scene.idle(15);
		scene.effects.superGlue(controlsPos1, Direction.DOWN, true);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.topOf(controlsPos1)
				.add(0, -4 / 16f, 0))
			.attachKeyFrame()
			.text("Contraption Controls can be used to toggle them on the fly");
		scene.idle(55);

		scene.world.rotateBearing(bearingPos, -15, 10);
		scene.world.rotateSection(contraptionLink, 0, -15, 0, 10);
		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(-280));
		scene.world.setKineticSpeed(util.select.position(drillPos), 64);
		scene.idle(10);
		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(0));
		scene.world.setKineticSpeed(util.select.position(drillPos), 0);
		scene.overlay.showControls(new InputWindowElement(util.vector.of(1.5, 2.75, 4.5), Pointing.DOWN).rightClick(),
			15);
		scene.idle(7);
		scene.world.modifyBlockEntity(controlsPos1, ContraptionControlsBlockEntity.class, ccte -> ccte.disabled = true);
		scene.effects.indicateRedstone(util.grid.at(1, 2, 4));
		scene.idle(10);
		scene.world.rotateBearing(bearingPos, -60, 40);
		scene.world.rotateSection(contraptionLink, 0, -60, 0, 40);
		scene.idle(40);

		scene.overlay.showControls(new InputWindowElement(util.vector.of(3.5, 2.75, 1), Pointing.DOWN).rightClick(),
			15);
		scene.idle(7);
		scene.world.modifyBlockEntity(controlsPos1, ContraptionControlsBlockEntity.class,
			ccte -> ccte.disabled = false);
		scene.effects.indicateRedstone(util.grid.at(3, 2, 0));
		scene.idle(10);
		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(-280));
		scene.world.setKineticSpeed(util.select.position(drillPos), 64);
		scene.world.rotateBearing(bearingPos, -15, 10);
		scene.world.rotateSection(contraptionLink, 0, -15, 0, 10);
		scene.idle(10);
		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(0));
		scene.world.setKineticSpeed(util.select.position(drillPos), 0);
		scene.idle(5);

		scene.world.hideIndependentSection(contraptionLink, Direction.UP);
		scene.idle(15);
		contraptionLink = scene.world.showIndependentSection(contraption, Direction.DOWN);
		scene.world.showSectionAndMerge(util.select.position(controlsPos1), Direction.DOWN, contraptionLink);
		scene.world.configureCenterOfRotation(contraptionLink, util.vector.centerOf(bearingPos));
		scene.world.moveSection(contraptionLink, util.vector.of(0, 1 / 512f, 0), 0);

		scene.idle(15);
		scene.world.showSectionAndMerge(util.select.position(controlsPos2), Direction.DOWN, contraptionLink);
		scene.idle(15);
		scene.effects.superGlue(controlsPos2, Direction.DOWN, true);

		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.topOf(controlsPos2)
				.add(0, -4 / 16f, 0))
			.attachKeyFrame()
			.text("They can be attached anywhere on the contraption");
		scene.idle(75);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(controlsPos2), Pointing.DOWN).rightClick()
			.withItem(AllBlocks.MECHANICAL_DRILL.asStack()), 30);
		scene.idle(5);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(controlsPos1), Pointing.UP).rightClick()
			.withItem(AllBlocks.MECHANICAL_HARVESTER.asStack()), 25);
		scene.idle(2);
		scene.world.setFilterData(util.select.position(controlsPos2), ContraptionControlsBlockEntity.class,
			AllBlocks.MECHANICAL_DRILL.asStack());
		scene.idle(5);
		scene.world.setFilterData(util.select.position(controlsPos1), ContraptionControlsBlockEntity.class,
			AllBlocks.MECHANICAL_HARVESTER.asStack());
		scene.idle(30);

		scene.overlay.showText(90)
			.placeNearTarget()
			.independent(80)
			.attachKeyFrame()
			.text("While disassembled, the filter can be changed to target specific types of actors");
		scene.idle(90);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(controlsPos2), Pointing.RIGHT).rightClick(),
			15);
		scene.idle(7);
		scene.world.modifyBlockEntity(controlsPos2, ContraptionControlsBlockEntity.class, ccte -> ccte.disabled = true);
		scene.effects.indicateRedstone(controlsPos2);
		scene.idle(10);

		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(-280));
		scene.world.rotateBearing(bearingPos, -90, 60);
		scene.world.rotateSection(contraptionLink, 0, -90, 0, 60);
		scene.idle(25);
		scene.world.setBlock(wheatPos, harvested, true);
		ElementLink<EntityElement> item3 = scene.world.createItemEntity(util.vector.centerOf(wheatPos), m, wheatItem);
		scene.idle(35);
		scene.world.modifyBlockEntity(harvesterPos, HarvesterBlockEntity.class, hte -> hte.setAnimatedSpeed(0));
		scene.idle(5);

		scene.world.modifyEntity(item3, Entity::discard);
		scene.world.hideIndependentSection(contraptionLink, Direction.UP);
		scene.idle(15);
		scene.world.modifyBlockEntity(controlsPos2, ContraptionControlsBlockEntity.class,
			ccte -> ccte.disabled = false);
		contraptionLink = scene.world.showIndependentSection(contraption, Direction.DOWN);
		scene.world.showSectionAndMerge(util.select.position(controlsPos1), Direction.DOWN, contraptionLink);
		scene.world.showSectionAndMerge(util.select.position(controlsPos2), Direction.DOWN, contraptionLink);
		scene.world.configureCenterOfRotation(contraptionLink, util.vector.centerOf(bearingPos));
		scene.world.moveSection(contraptionLink, util.vector.of(0, 1 / 512f, 0), 0);

		scene.world.restoreBlocks(util.select.position(wheatPos));
		scene.idle(30);

		scene.world.showSection(leverCol, Direction.EAST);

		scene.overlay.showText(50)
			.placeNearTarget()
			.independent(100)
			.attachKeyFrame()
			.text("If it is redstone-activated during assembly...");
		scene.idle(30);

		scene.world.toggleRedstonePower(leverCol);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyBlockEntity(controlsPos1, ContraptionControlsBlockEntity.class, ccte -> ccte.disabled = true);
		scene.idle(35);

		scene.world.setKineticSpeed(util.select.position(drillPos), 64);
		scene.world.rotateBearing(bearingPos, -30, 20);
		scene.world.rotateSection(contraptionLink, 0, -30, 0, 20);

		scene.idle(20);
		scene.overlay.showText(60)
			.placeNearTarget()
			.pointAt(util.vector.centerOf(wheatPos))
			.text("...targeted actors will be turned off from the start");

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(cobblePos);
		}

		ElementLink<EntityElement> item4 = scene.world.createItemEntity(util.vector.centerOf(cobblePos), m, cobbleItem);

		scene.idle(5);
		scene.world.rotateBearing(bearingPos, -60, 40);
		scene.world.rotateSection(contraptionLink, 0, -60, 0, 40);
		scene.idle(40);
		scene.world.setKineticSpeed(util.select.position(drillPos), 0);
		scene.idle(5);
		scene.world.modifyEntity(item4, Entity::discard);
	}

}
//文件scenes/PistonScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.contraptions.piston.MechanicalPistonHeadBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FaceCursorPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.PistonType;
import net.minecraft.world.phys.Vec3;

public class PistonScenes {

	public static void movement(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_piston", "Moving Structures using Mechanical Pistons");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.position(0, 1, 2)), Direction.UP);

		Selection kinetics = util.select.fromTo(3, 1, 3, 3, 1, 2);
		BlockPos piston = util.grid.at(3, 1, 2);
		BlockPos leverPos = util.grid.at(3, 2, 4);
		BlockPos shaft = util.grid.at(3, 1, 3);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 2, 5), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(piston), Direction.DOWN);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.position(3, 1, 1), Direction.DOWN);
		scene.world.moveSection(contraption, util.vector.of(0, 0, 1), 0);
		scene.idle(20);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.east()), Direction.DOWN, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.east(2)), Direction.DOWN, contraption);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.west()), Direction.DOWN, contraption);
		scene.idle(15);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 40);
		scene.overlay.showText(55)
			.pointAt(util.vector.topOf(piston))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Mechanical Pistons can move blocks in front of them");
		scene.idle(65);

		scene.overlay.showText(45)
			.pointAt(util.vector.blockSurface(shaft, Direction.SOUTH))
			.placeNearTarget()
			.text("Speed and direction of movement depend on the Rotational Input");
		scene.world.setBlock(util.grid.at(2, 1, 1), Blocks.AIR.defaultBlockState(), false);
		scene.world.setBlock(util.grid.at(0, 1, 2), Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);
		scene.idle(60);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(piston, Direction.WEST), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(Items.SLIME_BALL)),
			30);
		scene.idle(7);
		scene.world.modifyBlock(piston.north(), s -> s.setValue(MechanicalPistonHeadBlock.TYPE, PistonType.STICKY),
			false);
		scene.effects.superGlue(piston, Direction.WEST, true);

		scene.idle(33);
		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 40);

		scene.idle(25);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(piston))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Sticky Mechanical Pistons can pull the attached blocks back");
		scene.idle(20);
		scene.world.setBlock(util.grid.at(2, 1, 1), Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.world.setBlock(util.grid.at(0, 1, 2), Blocks.AIR.defaultBlockState(), false);
		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);

		scene.idle(50);
		scene.world.setBlock(util.grid.at(2, 1, 1), Blocks.AIR.defaultBlockState(), false);

		scene.world.replaceBlocks(util.select.fromTo(2, 3, 2, 2, 2, 0), Blocks.OAK_PLANKS.defaultBlockState(), false);
		scene.overlay.showOutline(PonderPalette.GREEN, "glue", util.select.fromTo(2, 2, 3, 2, 1, 3)
			.add(util.select.fromTo(2, 1, 3, 2, 1, 1))
			.add(util.select.position(1, 1, 1)), 40);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(2, 2, 0)), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);

		ElementLink<WorldSectionElement> chassis =
			scene.world.showIndependentSection(util.select.fromTo(2, 2, 0, 2, 3, 2), Direction.DOWN);
		scene.world.moveSection(chassis, util.vector.of(0, -1, 1), 0);
		scene.addKeyframe();
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(1, 2, 0), Direction.EAST, chassis);
		scene.idle(15);
		scene.effects.superGlue(piston.west()
			.north(), Direction.WEST, true);
		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(piston.west()))
			.placeNearTarget()
			.sharedText("movement_anchors");

		scene.idle(90);
		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 40);
		scene.world.moveSection(chassis, util.vector.of(-2, 0, 0), 40);
	}

	public static void poles(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("piston_pole", "Piston Extension Poles");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.modifyKineticSpeed(util.select.everywhere(), f -> -f);

		Selection kinetics = util.select.fromTo(3, 1, 3, 3, 1, 2);
		BlockPos piston = util.grid.at(3, 1, 2);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 2, 5), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(piston), Direction.DOWN);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.position(3, 1, 1), Direction.DOWN);
		scene.world.moveSection(contraption, util.vector.of(0, 0, 1), 0);
		scene.idle(20);

		BlockPos leverPos = util.grid.at(3, 2, 4);
		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.setKineticSpeed(kinetics, 16);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.position(piston), 50)
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Without attached Poles, a Mechanical Piston cannot move");
		scene.idle(60);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.setKineticSpeed(kinetics, 0);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.east()), Direction.DOWN, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.east(2)), Direction.DOWN, contraption);
		scene.idle(10);

		scene.overlay.showOutline(PonderPalette.RED, new Object(), util.select.fromTo(piston.east(), piston.east(2)),
			100);
		scene.overlay.showSelectionWithText(util.select.fromTo(piston.west(), piston.west(2)), 100)
			.text("The Length of pole added at its back determines the Extension Range")
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.GREEN);
		scene.idle(110);

		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.west()), Direction.EAST, contraption);
		scene.idle(10);
		ElementLink<ParrotElement> birb =
			scene.special.createBirb(util.vector.topOf(piston.west()), FaceCursorPose::new);
		scene.idle(15);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.setKineticSpeed(kinetics, 16);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 40);
		scene.special.moveParrot(birb, util.vector.of(-2, 0, 0), 40);

	}

	public static void movementModes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_piston_modes", "Movement Modes of the Mechanical Piston");
		scene.configureBasePlate(0, 0, 5);
		Selection rose = util.select.fromTo(0, 2, 2, 0, 1, 2);
		scene.world.showSection(util.select.layer(0)
			.add(rose), Direction.UP);

		Selection kinetics = util.select.fromTo(3, 1, 3, 3, 1, 2);
		BlockPos piston = util.grid.at(3, 1, 2);
		BlockPos leverPos = util.grid.at(3, 2, 4);
		BlockPos shaft = util.grid.at(3, 1, 3);

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 3, 3, 2, 5), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(piston), Direction.DOWN);
		ElementLink<WorldSectionElement> contraption =
			scene.world.showIndependentSection(util.select.position(3, 1, 1), Direction.DOWN);
		scene.world.moveSection(contraption, util.vector.of(0, 0, 1), 0);
		scene.idle(20);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.east()), Direction.DOWN, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.east(2)), Direction.DOWN, contraption);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.west()), Direction.DOWN, contraption);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(piston.north()
			.west()
			.above()), Direction.DOWN, contraption);
		scene.idle(15);
		scene.effects.superGlue(piston.west(), Direction.UP, true);
		scene.idle(10);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 40);
		scene.idle(40);

		scene.world.destroyBlock(util.grid.at(0, 1, 2));
		scene.world.destroyBlock(util.grid.at(0, 2, 2));
		scene.idle(10);
		scene.overlay.showSelectionWithText(rose, 70)
			.text("Whenever Pistons stop moving, the moved structure reverts to blocks")
			.attachKeyFrame()
			.colored(PonderPalette.RED);
		scene.idle(80);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(2, 0, 0), 40);
		scene.world.hideSection(rose, Direction.UP);
		scene.idle(50);

		scene.world.setBlock(util.grid.at(0, 1, 2), Blocks.ROSE_BUSH.defaultBlockState(), false);
		scene.world.setBlock(util.grid.at(0, 2, 2), Blocks.ROSE_BUSH.defaultBlockState()
			.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), false);
		scene.world.showIndependentSection(rose, Direction.DOWN);
		Vec3 filter = util.vector.topOf(piston)
			.add(.125, 0, 0);
		scene.overlay.showFilterSlotInput(filter, Direction.UP, 60);
		scene.overlay.showControls(new InputWindowElement(filter.add(0, .125, 0), Pointing.DOWN).rightClick(), 60);
		scene.overlay.showText(70)
			.pointAt(filter.add(-.125, 0, 0))
			.placeNearTarget()
			.attachKeyFrame()
			.sharedText("behaviour_modify_value_panel");
		scene.idle(80);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(leverPos, leverPos.below()));
		scene.world.modifyKineticSpeed(kinetics, f -> -f);
		scene.effects.rotationDirectionIndicator(shaft);
		scene.world.moveSection(contraption, util.vector.of(-2, 0, 0), 40);
		scene.idle(50);
		scene.overlay.showText(120)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 2), Direction.WEST))
			.placeNearTarget()
			.text("It can be configured never to revert to solid blocks, or only at the location it started at");

	}

}
//文件scenes/ProcessingScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.google.common.collect.ImmutableList;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.content.kinetics.millstone.MillstoneBlockEntity;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.Mode;
import com.simibubi.create.content.processing.basin.BasinBlock;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock.HeatLevel;
import com.simibubi.create.content.processing.burner.LitBlazeBurnerBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;
import com.simibubi.create.foundation.ponder.element.EntityElement;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.ponder.instruction.EmitParticlesInstruction.Emitter;
import com.simibubi.create.foundation.utility.IntAttached;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.NBTHelper;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class ProcessingScenes {

	public static void millstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("millstone", "Processing Items in the Millstone");
		scene.configureBasePlate(0, 0, 5);

		Selection belt = util.select.fromTo(1, 1, 5, 0, 1, 2)
			.add(util.select.position(1, 2, 2));
		Selection beltCog = util.select.position(2, 0, 5);

		scene.world.showSection(util.select.layer(0)
			.substract(beltCog), Direction.UP);

		BlockPos millstone = util.grid.at(2, 2, 2);
		Selection millstoneSelect = util.select.position(2, 2, 2);
		Selection cogs = util.select.fromTo(3, 1, 2, 3, 2, 2);
		scene.world.setKineticSpeed(millstoneSelect, 0);

		scene.idle(5);
		scene.world.showSection(util.select.position(4, 1, 3), Direction.DOWN);
		scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(millstone), Direction.DOWN);
		scene.idle(10);
		Vec3 millstoneTop = util.vector.topOf(millstone);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Millstones process items by grinding them")
			.pointAt(millstoneTop)
			.placeNearTarget();
		scene.idle(70);

		scene.world.showSection(cogs, Direction.DOWN);
		scene.idle(10);
		scene.world.setKineticSpeed(millstoneSelect, 32);
		scene.effects.indicateSuccess(millstone);
		scene.idle(10);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("They can be powered from the side using cogwheels")
			.pointAt(util.vector.topOf(millstone.east()))
			.placeNearTarget();
		scene.idle(70);

		ItemStack itemStack = new ItemStack(Items.WHEAT);
		Vec3 entitySpawn = util.vector.topOf(millstone.above(3));

		ElementLink<EntityElement> entity1 =
			scene.world.createItemEntity(entitySpawn, util.vector.of(0, 0.2, 0), itemStack);
		scene.idle(18);
		scene.world.modifyEntity(entity1, Entity::discard);
		scene.world.modifyBlockEntity(millstone, MillstoneBlockEntity.class,
			ms -> ms.inputInv.setStackInSlot(0, itemStack));
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(millstoneTop, Pointing.DOWN).withItem(itemStack), 30);
		scene.idle(7);

		scene.overlay.showText(40)
			.attachKeyFrame()
			.text("Throw or Insert items at the top")
			.pointAt(millstoneTop)
			.placeNearTarget();
		scene.idle(60);

		scene.world.modifyBlockEntity(millstone, MillstoneBlockEntity.class,
			ms -> ms.inputInv.setStackInSlot(0, ItemStack.EMPTY));

		scene.overlay.showText(50)
			.text("After some time, the result can be obtained via Right-click")
			.pointAt(util.vector.blockSurface(millstone, Direction.WEST))
			.placeNearTarget();
		scene.idle(60);

		ItemStack flour = AllItems.WHEAT_FLOUR.asStack();
		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(millstone, Direction.NORTH), Pointing.RIGHT).rightClick()
				.withItem(flour),
			40);
		scene.idle(50);

		scene.addKeyframe();
		scene.world.showSection(beltCog, Direction.UP);
		scene.world.showSection(belt, Direction.EAST);
		scene.idle(15);

		BlockPos beltPos = util.grid.at(1, 1, 2);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, flour);
		scene.idle(15);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, new ItemStack(Items.WHEAT_SEEDS));
		scene.idle(20);

		scene.overlay.showText(50)
			.text("The outputs can also be extracted by automation")
			.pointAt(util.vector.blockSurface(millstone, Direction.WEST)
				.add(-.5, .4, 0))
			.placeNearTarget();
		scene.idle(60);
	}

	public static void crushingWheels(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("crushing_wheels", "Processing Items with Crushing Wheels");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(.9f);

		Selection wheels = util.select.fromTo(3, 2, 2, 1, 2, 2);
		Selection kinetics = util.select.fromTo(0, 1, 5, 4, 1, 3);
		Selection kinetics2 = util.select.fromTo(0, 2, 5, 4, 2, 3);
		Selection beltCog = util.select.position(5, 0, 1);
		scene.world.setKineticSpeed(wheels, 0);
		scene.world.setBlock(util.grid.at(2, 3, 2), Blocks.AIR.defaultBlockState(), false);

		scene.world.showSection(util.select.layer(0)
			.substract(beltCog), Direction.UP);
		scene.idle(5);

		Selection belt = util.select.fromTo(4, 1, 2, 4, 4, 2)
			.add(util.select.fromTo(4, 3, 3, 4, 4, 3))
			.add(util.select.position(3, 3, 2))
			.add(util.select.position(2, 3, 2));
		Selection bottomBelt = util.select.fromTo(5, 1, 0, 2, 1, 0)
			.add(util.select.fromTo(2, 1, 2, 2, 1, 1));

		BlockPos center = util.grid.at(2, 2, 2);
		Selection wWheel = util.select.position(center.west());
		Selection eWheel = util.select.position(center.east());

		scene.world.showSection(wWheel, Direction.SOUTH);
		scene.idle(3);
		scene.world.showSection(eWheel, Direction.SOUTH);
		scene.idle(10);

		Vec3 centerTop = util.vector.topOf(center);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("A pair of Crushing Wheels can grind items very effectively")
			.pointAt(centerTop)
			.placeNearTarget();
		scene.idle(70);

		scene.world.showSection(kinetics, Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(kinetics2, Direction.DOWN);
		scene.world.setKineticSpeed(wWheel, -16);
		scene.world.setKineticSpeed(eWheel, 16);
		scene.idle(5);
		scene.effects.rotationDirectionIndicator(center.west());
		scene.effects.rotationDirectionIndicator(center.east());
		scene.idle(10);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Their Rotational Input has to make them spin into each other")
			.pointAt(util.vector.blockSurface(center.west(), Direction.NORTH))
			.placeNearTarget();
		scene.idle(40);
		scene.effects.rotationDirectionIndicator(center.west());
		scene.effects.rotationDirectionIndicator(center.east());
		scene.idle(30);

		ItemStack input = new ItemStack(Items.GOLD_ORE);
		ItemStack output = new ItemStack(Items.RAW_GOLD);
		Vec3 entitySpawn = util.vector.topOf(center.above(2));

		ElementLink<EntityElement> entity1 =
			scene.world.createItemEntity(entitySpawn, util.vector.of(0, 0.2, 0), input);
		scene.idle(18);
		scene.world.modifyEntity(entity1, Entity::discard);
		Emitter blockSpace =
			Emitter.withinBlockSpace(new ItemParticleOption(ParticleTypes.ITEM, input), util.vector.of(0, 0, 0));
		scene.effects.emitParticles(util.vector.centerOf(center)
			.add(0, -0.2, 0), blockSpace, 3, 40);
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(centerTop, Pointing.DOWN).withItem(input), 30);
		scene.idle(7);

		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("Items thrown or inserted into the top will get processed")
			.pointAt(centerTop)
			.placeNearTarget();
		scene.idle(60);

		scene.world.createItemEntity(centerTop.add(0, -1.4, 0), util.vector.of(0, 0, 0), output);
		scene.idle(10);
		scene.world.createItemEntity(centerTop.add(0, -1.4, 0), util.vector.of(0, 0, 0), output);
		scene.overlay.showControls(new InputWindowElement(centerTop.add(0, -2, 0), Pointing.UP).withItem(output), 30);
		scene.idle(40);

		scene.world.restoreBlocks(util.select.position(2, 3, 2));
		scene.world.showSection(belt, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(beltCog, Direction.UP);
		scene.idle(5);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.showSection(bottomBelt, Direction.SOUTH);
		scene.idle(5);

		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("Items can be inserted and picked up through automated means as well")
			.pointAt(centerTop.add(0, .5, 0))
			.placeNearTarget();
		scene.idle(40);

		for (int i = 0; i < 5; i++) {
			if (i < 4)
				scene.world.createItemOnBelt(util.grid.at(4, 4, 2), Direction.EAST, input);
			scene.idle(15);
			if (i < 3)
				scene.world.createItemOnBelt(util.grid.at(4, 4, 2), Direction.EAST, input);
			scene.idle(15);
			if (i > 0) {
				scene.world.createItemOnBelt(center.below(), Direction.UP, output);
				scene.idle(15);
				scene.world.createItemOnBelt(center.below(), Direction.UP, output);
			}
			scene.world.removeItemsFromBelt(util.grid.at(3, 3, 2));
			if (i < 4)
				scene.effects.emitParticles(util.vector.centerOf(center)
					.add(0, -0.2, 0), blockSpace, 3, 28);
			if (i == 0)
				scene.markAsFinished();
		}
	}

	public static void pressing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_press", "Processing Items with the Mechanical Press");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		ElementLink<WorldSectionElement> depot =
			scene.world.showIndependentSection(util.select.position(2, 1, 1), Direction.DOWN);
		scene.world.moveSection(depot, util.vector.of(0, 0, 1), 0);
		scene.idle(10);

		Selection pressS = util.select.position(2, 3, 2);
		BlockPos pressPos = util.grid.at(2, 3, 2);
		BlockPos depotPos = util.grid.at(2, 1, 1);
		scene.world.setKineticSpeed(pressS, 0);
		scene.world.showSection(pressS, Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(util.select.fromTo(2, 1, 3, 2, 1, 5), Direction.NORTH);
		scene.idle(3);
		scene.world.showSection(util.select.position(2, 2, 3), Direction.SOUTH);
		scene.idle(3);
		scene.world.showSection(util.select.position(2, 3, 3), Direction.NORTH);
		scene.world.setKineticSpeed(pressS, -32);
		scene.effects.indicateSuccess(pressPos);
		scene.idle(10);

		Vec3 pressSide = util.vector.blockSurface(pressPos, Direction.WEST);
		scene.overlay.showText(60)
			.pointAt(pressSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Mechanical Press can process items provided beneath it");
		scene.idle(70);
		scene.overlay.showText(60)
			.pointAt(pressSide.subtract(0, 2, 0))
			.placeNearTarget()
			.text("The Input items can be dropped or placed on a Depot under the Press");
		scene.idle(50);
		ItemStack copper = new ItemStack(Items.COPPER_INGOT);
		scene.world.createItemOnBeltLike(depotPos, Direction.NORTH, copper);
		Vec3 depotCenter = util.vector.centerOf(depotPos.south());
		scene.overlay.showControls(new InputWindowElement(depotCenter, Pointing.UP).withItem(copper), 30);
		scene.idle(10);

		Class<MechanicalPressBlockEntity> type = MechanicalPressBlockEntity.class;
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BELT));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), copper));
		scene.world.removeItemsFromBelt(depotPos);
		ItemStack sheet = AllItems.COPPER_SHEET.asStack();
		scene.world.createItemOnBeltLike(depotPos, Direction.UP, sheet);
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(depotCenter, Pointing.UP).withItem(sheet), 50);
		scene.idle(60);

		scene.world.hideIndependentSection(depot, Direction.NORTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(0, 1, 3, 0, 2, 3), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 0, 2, 2), Direction.SOUTH);
		scene.idle(20);
		BlockPos beltPos = util.grid.at(0, 1, 2);
		scene.overlay.showText(40)
			.pointAt(util.vector.blockSurface(beltPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("When items are provided on a belt...");
		scene.idle(30);

		ElementLink<BeltItemElement> ingot = scene.world.createItemOnBelt(beltPos, Direction.SOUTH, copper);
		scene.idle(15);
		ElementLink<BeltItemElement> ingot2 = scene.world.createItemOnBelt(beltPos, Direction.SOUTH, copper);
		scene.idle(15);
		scene.world.stallBeltItem(ingot, true);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BELT));

		scene.overlay.showText(50)
			.pointAt(pressSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Press will hold and process them automatically");

		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), copper));
		scene.world.removeItemsFromBelt(pressPos.below(2));
		ingot = scene.world.createItemOnBelt(pressPos.below(2), Direction.UP, sheet);
		scene.world.stallBeltItem(ingot, true);
		scene.idle(15);
		scene.world.stallBeltItem(ingot, false);
		scene.idle(15);
		scene.world.stallBeltItem(ingot2, true);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BELT));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), copper));
		scene.world.removeItemsFromBelt(pressPos.below(2));
		ingot2 = scene.world.createItemOnBelt(pressPos.below(2), Direction.UP, sheet);
		scene.world.stallBeltItem(ingot2, true);
		scene.idle(15);
		scene.world.stallBeltItem(ingot2, false);

	}

	public static void mixing(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_mixer", "Processing Items with the Mechanical Mixer");
		scene.configureBasePlate(0, 0, 5);
		scene.world.setBlock(util.grid.at(1, 1, 2), AllBlocks.ANDESITE_CASING.getDefaultState(), false);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 4, 3, 1, 1, 5), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 1, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 2, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 4, 2), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 1, 1, 1, 1), Direction.SOUTH);
		scene.world.showSection(util.select.fromTo(3, 1, 5, 3, 1, 2), Direction.SOUTH);
		scene.idle(20);

		BlockPos basin = util.grid.at(1, 2, 2);
		BlockPos pressPos = util.grid.at(1, 4, 2);
		Vec3 basinSide = util.vector.blockSurface(basin, Direction.WEST);

		ItemStack blue = new ItemStack(Items.BLUE_DYE);
		ItemStack red = new ItemStack(Items.RED_DYE);
		ItemStack purple = new ItemStack(Items.PURPLE_DYE);

		scene.overlay.showText(60)
			.pointAt(basinSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("With a Mixer and Basin, some Crafting Recipes can be automated");
		scene.idle(40);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basin), Pointing.LEFT).withItem(blue), 30);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basin), Pointing.RIGHT).withItem(red), 30);
		scene.idle(30);
		Class<MechanicalMixerBlockEntity> type = MechanicalMixerBlockEntity.class;
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.startProcessingBasin());
		scene.world.createItemOnBeltLike(basin, Direction.UP, red);
		scene.world.createItemOnBeltLike(basin, Direction.UP, blue);
		scene.idle(80);
		scene.world.modifyBlockEntityNBT(util.select.position(basin), BasinBlockEntity.class, nbt -> {
			nbt.put("VisualizedItems",
				NBTHelper.writeCompoundList(ImmutableList.of(IntAttached.with(1, purple)), ia -> ia.getValue()
					.serializeNBT()));
		});
		scene.idle(4);
		scene.world.createItemOnBelt(util.grid.at(1, 1, 1), Direction.UP, purple);
		scene.idle(30);

		scene.overlay.showText(80)
			.pointAt(basinSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Available recipes include any Shapeless Crafting Recipe, plus a couple extra ones");
		scene.idle(80);

		scene.rotateCameraY(-30);
		scene.idle(10);
		scene.world.setBlock(util.grid.at(1, 1, 2), AllBlocks.BLAZE_BURNER.getDefaultState()
			.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.KINDLED), true);
		scene.idle(10);

		scene.overlay.showText(80)
			.pointAt(basinSide.subtract(0, 1, 0))
			.placeNearTarget()
			.text("Some of those recipes may require the heat of a Blaze Burner");
		scene.idle(40);

		scene.rotateCameraY(30);

		scene.idle(60);
		Vec3 filterPos = util.vector.of(1, 2.75f, 2.5f);
		scene.overlay.showFilterSlotInput(filterPos, Direction.WEST, 100);
		scene.overlay.showText(100)
			.pointAt(filterPos)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The filter slot can be used in case two recipes are conflicting.");
		scene.idle(80);
	}

	public static void compacting(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_press_compacting", "Compacting items with the Mechanical Press");
		scene.configureBasePlate(0, 0, 5);
		scene.world.setBlock(util.grid.at(1, 1, 2), AllBlocks.ANDESITE_CASING.getDefaultState(), false);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 4, 3, 1, 1, 5), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 1, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 2, 2), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.position(1, 4, 2), Direction.SOUTH);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(3, 1, 1, 1, 1, 1), Direction.SOUTH);
		scene.world.showSection(util.select.fromTo(3, 1, 5, 3, 1, 2), Direction.SOUTH);
		scene.idle(20);

		BlockPos basin = util.grid.at(1, 2, 2);
		BlockPos pressPos = util.grid.at(1, 4, 2);
		Vec3 basinSide = util.vector.blockSurface(basin, Direction.WEST);

		ItemStack copper = new ItemStack(Items.COPPER_INGOT);
		ItemStack copperBlock = new ItemStack(Items.COPPER_BLOCK);

		scene.overlay.showText(60)
			.pointAt(basinSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Pressing items held in a Basin will cause them to be Compacted");
		scene.idle(40);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basin), Pointing.DOWN).withItem(copper),
			30);
		scene.idle(30);
		Class<MechanicalPressBlockEntity> type = MechanicalPressBlockEntity.class;
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BASIN));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makeCompactingParticleEffect(util.vector.centerOf(basin), copper));
		scene.world.modifyBlockEntityNBT(util.select.position(basin), BasinBlockEntity.class, nbt -> {
			nbt.put("VisualizedItems",
				NBTHelper.writeCompoundList(ImmutableList.of(IntAttached.with(1, copperBlock)), ia -> ia.getValue()
					.serializeNBT()));
		});
		scene.idle(4);
		scene.world.createItemOnBelt(util.grid.at(1, 1, 1), Direction.UP, copperBlock);
		scene.idle(30);

		scene.overlay.showText(80)
			.pointAt(basinSide)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Compacting includes any filled 2x2 or 3x3 Crafting Recipe, plus a couple extra ones");

		scene.idle(30);
		ItemStack log = new ItemStack(Items.OAK_LOG);
		ItemStack bark = new ItemStack(Items.OAK_WOOD);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basin), Pointing.DOWN).withItem(log), 30);
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BASIN));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makeCompactingParticleEffect(util.vector.centerOf(basin), log));
		scene.world.modifyBlockEntityNBT(util.select.position(basin), BasinBlockEntity.class, nbt -> {
			nbt.put("VisualizedItems",
				NBTHelper.writeCompoundList(ImmutableList.of(IntAttached.with(1, bark)), ia -> ia.getValue()
					.serializeNBT()));
		});
		scene.idle(4);
		scene.world.createItemOnBelt(util.grid.at(1, 1, 1), Direction.UP, bark);
		scene.idle(30);

		scene.rotateCameraY(-30);
		scene.idle(10);
		scene.world.setBlock(util.grid.at(1, 1, 2), AllBlocks.BLAZE_BURNER.getDefaultState()
			.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.KINDLED), true);
		scene.idle(10);

		scene.overlay.showText(80)
			.pointAt(basinSide.subtract(0, 1, 0))
			.placeNearTarget()
			.text("Some of those recipes may require the heat of a Blaze Burner");
		scene.idle(40);

		scene.rotateCameraY(30);

		scene.idle(60);
		Vec3 filterPos = util.vector.of(1, 2.75f, 2.5f);
		scene.overlay.showFilterSlotInput(filterPos, Direction.WEST, 100);
		scene.overlay.showText(100)
			.pointAt(filterPos)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The filter slot can be used in case two recipes are conflicting.");
		scene.idle(80);
	}

	public static void emptyBlazeBurner(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("empty_blaze_burner", "Using Empty Blaze Burners");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(10);
		BlockPos center = util.grid.at(2, 0, 2);

		scene.world.createEntity(w -> {
			Blaze blazeEntity = EntityType.BLAZE.create(w);
			Vec3 v = util.vector.topOf(center);
			blazeEntity.setPosRaw(v.x, v.y, v.z);
			blazeEntity.setYRot(blazeEntity.yRotO = 180);
			return blazeEntity;
		});

		scene.idle(20);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.centerOf(center.above(2)), Pointing.DOWN).rightClick()
				.withItem(AllItems.EMPTY_BLAZE_BURNER.asStack()), 40);
		scene.idle(10);
		scene.overlay.showText(60)
			.text("Right-click a Blaze with the empty burner to capture it")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(center.above(2), Direction.WEST))
			.placeNearTarget();
		scene.idle(50);

		scene.world.modifyEntities(Blaze.class, Entity::discard);
		scene.idle(20);

		scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(center.above()), Pointing.DOWN).rightClick()
			.withItem(AllItems.EMPTY_BLAZE_BURNER.asStack()), 40);
		scene.idle(10);
		scene.overlay.showText(60)
			.text("Alternatively, Blazes can be collected from their Spawners directly")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(center.above(), Direction.WEST))
			.placeNearTarget();
		scene.idle(50);
		scene.world.hideSection(util.select.position(2, 1, 2), Direction.UP);
		scene.idle(20);
		scene.world.showSection(util.select.position(1, 1, 2), Direction.DOWN);
		scene.idle(20);

		scene.world.modifyBlock(util.grid.at(1, 1, 2), s -> s.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.KINDLED),
			false);
		scene.overlay.showText(70)
			.text("You now have an ideal heat source for various machines")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(center.west()
				.above(), Direction.WEST))
			.placeNearTarget();
		scene.idle(80);

		scene.world.showSection(util.select.position(3, 1, 2), Direction.DOWN);
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(center.east()
			.above()), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(Items.FLINT_AND_STEEL)),
			40);
		scene.idle(7);
		scene.world.setBlock(util.grid.at(3, 1, 2), AllBlocks.LIT_BLAZE_BURNER.getDefaultState(), false);
		scene.idle(10);
		scene.overlay.showText(70)
			.text("For Aesthetic purposes, Empty Blaze Burners can also be lit using Flint and Steel")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(center.east()
				.above(), Direction.UP))
			.placeNearTarget();
		scene.idle(80);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(center.east()
			.above()), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(Items.SOUL_SAND)),
			40);
		scene.idle(7);
		scene.world.modifyBlock(util.grid.at(3, 1, 2),
			s -> s.setValue(LitBlazeBurnerBlock.FLAME_TYPE, LitBlazeBurnerBlock.FlameType.SOUL), false);
		scene.overlay.showText(60)
			.text("The flame can be transformed using a soul-infused item")
			.pointAt(util.vector.blockSurface(center.east()
				.above(), Direction.UP))
			.placeNearTarget();
		scene.idle(80);
		scene.overlay.showText(90)
			.colored(PonderPalette.RED)
			.text("However, without a blaze they are not suitable for industrial heating")
			.pointAt(util.vector.blockSurface(center.east()
				.above(), Direction.UP))
			.placeNearTarget();
		scene.idle(70);
	}

	public static void blazeBurner(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("blaze_burner", "Feeding Blaze Burners");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(10);

		BlockPos burner = util.grid.at(2, 1, 2);
		scene.world.showSection(util.select.position(burner), Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(burner.above()), Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Blaze Burners can provide Heat to Items processed in a Basin")
			.pointAt(util.vector.blockSurface(burner, Direction.WEST))
			.placeNearTarget();
		scene.idle(80);

		scene.world.hideSection(util.select.position(burner.above()), Direction.UP);
		scene.idle(20);
		scene.world.setBlock(burner.above(), Blocks.AIR.defaultBlockState(), false);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(burner), Pointing.DOWN).rightClick()
			.withItem(new ItemStack(Items.OAK_PLANKS)), 15);
		scene.idle(7);
		scene.world.modifyBlock(burner, s -> s.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.KINDLED), false);
		scene.idle(20);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("For this, the Blaze has to be fed with flammable items")
			.pointAt(util.vector.blockSurface(burner, Direction.WEST))
			.placeNearTarget();
		scene.idle(80);

		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(burner), Pointing.DOWN).rightClick()
			.withItem(AllItems.BLAZE_CAKE.asStack()), 30);
		scene.idle(7);
		scene.world.modifyBlock(burner, s -> s.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.SEETHING), false);
		scene.idle(20);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.colored(PonderPalette.MEDIUM)
			.text("With a Blaze Cake, the Burner can reach an even stronger level of heat")
			.pointAt(util.vector.blockSurface(burner, Direction.WEST))
			.placeNearTarget();
		scene.idle(90);

		Class<DeployerBlockEntity> teType = DeployerBlockEntity.class;
		scene.world.modifyBlockEntityNBT(util.select.position(4, 1, 2), teType,
			nbt -> nbt.put("HeldItem", AllItems.BLAZE_CAKE.asStack()
				.serializeNBT()));

		scene.world.showSection(util.select.fromTo(3, 0, 5, 2, 0, 5), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 4, 1, 5), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(2, 1, 4, 2, 1, 5), Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("The feeding process can be automated using Deployers or Mechanical Arms")
			.pointAt(util.vector.blockSurface(burner.east(2), Direction.UP));
		scene.idle(90);
	}

	public static void basin(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("basin", "Processing Items in the Basin");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		scene.world.showSection(util.select.position(1, 1, 2), Direction.DOWN);
		scene.idle(10);
		BlockPos basinPos = util.grid.at(1, 2, 2);
		scene.world.modifyBlock(basinPos, s -> s.setValue(BasinBlock.FACING, Direction.DOWN), false);
		scene.world.showSection(util.select.position(basinPos), Direction.DOWN);
		scene.idle(10);
		Vec3 basinSide = util.vector.blockSurface(basinPos, Direction.WEST);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("A Basin can hold Items and Fluids for Processing")
			.pointAt(basinSide)
			.placeNearTarget();
		scene.idle(10);

		ItemStack stack = new ItemStack(Items.BRICK);
		for (int i = 0; i < 4; i++) {
			scene.world.createItemEntity(util.vector.centerOf(basinPos.above(3)), util.vector.of(0, 0, 0), stack);
			scene.idle(10);
		}
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basinPos), Pointing.DOWN).withItem(stack),
			30);
		scene.idle(30);

		for (Direction d : Iterate.horizontalDirections) {
			scene.overlay.showOutline(PonderPalette.GREEN, new Object(), util.select.position(basinPos.below()
				.relative(d)), 60);
			scene.idle(4);
		}

		scene.overlay.showText(80)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("After a processing step, basins try to output below to the side of them")
			.pointAt(basinSide)
			.placeNearTarget();
		scene.idle(90);

		ElementLink<WorldSectionElement> depot =
			scene.world.showIndependentSection(util.select.position(3, 1, 1), Direction.EAST);
		scene.world.moveSection(depot, util.vector.of(-2, 0, 0), 0);
		scene.idle(10);
		scene.world.modifyBlock(basinPos, s -> s.setValue(BasinBlock.FACING, Direction.NORTH), false);
		scene.idle(10);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("When a valid component is present, the Basin will show an output faucet")
			.pointAt(basinSide.add(0.15, 0, -0.5))
			.placeNearTarget();
		scene.idle(90);

		scene.world.hideIndependentSection(depot, Direction.EAST);
		scene.idle(15);
		depot = scene.world.showIndependentSection(util.select.position(0, 1, 1), Direction.EAST);
		scene.world.moveSection(depot, util.vector.of(1, 0, 0), 0);
		scene.idle(20);
		scene.world.hideIndependentSection(depot, Direction.EAST);

		scene.overlay.showText(80)
			.text("A number of options are applicable here")
			.pointAt(util.vector.centerOf(util.grid.at(1, 1, 1)))
			.placeNearTarget();

		scene.idle(15);
		depot = scene.world.showIndependentSection(util.select.position(1, 1, 0), Direction.EAST);
		scene.world.moveSection(depot, util.vector.of(0, 0, 1), 0);
		scene.idle(20);
		scene.world.hideIndependentSection(depot, Direction.EAST);
		scene.idle(15);
		depot = scene.world.showIndependentSection(util.select.position(1, 1, 1), Direction.EAST);
		scene.idle(20);
		scene.world.hideIndependentSection(depot, Direction.EAST);
		scene.idle(15);
		depot = scene.world.showIndependentSection(util.select.fromTo(3, 1, 0, 2, 1, 0), Direction.EAST);
		scene.world.moveSection(depot, util.vector.of(-2, 0, 1), 0);
		scene.idle(20);
		scene.world.hideIndependentSection(depot, Direction.EAST);
		scene.idle(15);
		depot = scene.world.showIndependentSection(util.select.position(2, 1, 1), Direction.EAST);
		scene.world.moveSection(depot, util.vector.of(-1, 0, 0), 0);

		scene.idle(25);

		BlockPos pressPos = util.grid.at(1, 4, 2);
		scene.world.showSection(util.select.position(pressPos), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 4, 3, 1, 1, 5), Direction.NORTH);
		scene.idle(10);

		Class<MechanicalPressBlockEntity> type = MechanicalPressBlockEntity.class;
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BASIN));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makeCompactingParticleEffect(util.vector.centerOf(basinPos), stack));
		scene.world.modifyBlockEntityNBT(util.select.position(basinPos), BasinBlockEntity.class, nbt -> {
			nbt.put("VisualizedItems",
				NBTHelper.writeCompoundList(ImmutableList.of(IntAttached.with(1, new ItemStack(Blocks.BRICKS))),
					ia -> ia.getValue()
						.serializeNBT()));
		});
		scene.idle(4);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basinPos.below()
			.north()), Pointing.RIGHT).withItem(new ItemStack(Items.BRICKS)), 30);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("Outputs will be caught by the inventory below")
			.pointAt(basinSide.add(0, -1, -1))
			.placeNearTarget();
		scene.idle(70);

		scene.world.hideIndependentSection(depot, Direction.NORTH);
		scene.idle(10);
		scene.world.modifyBlock(basinPos, s -> s.setValue(BasinBlock.FACING, Direction.DOWN), false);
		scene.idle(20);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("Without output faucet, the Basin will retain items created in its processing")
			.pointAt(basinSide)
			.placeNearTarget();
		scene.idle(50);

		ItemStack nugget = AllItems.COPPER_NUGGET.asStack();
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basinPos), Pointing.RIGHT).withItem(nugget),
			30);
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BASIN));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makeCompactingParticleEffect(util.vector.centerOf(basinPos), nugget));

		ItemStack ingot = new ItemStack(Items.COPPER_INGOT);
		scene.idle(30);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basinPos), Pointing.RIGHT).withItem(ingot),
			30);
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.start(Mode.BASIN));
		scene.idle(30);
		scene.world.modifyBlockEntity(pressPos, type, pte -> pte.getPressingBehaviour()
			.makeCompactingParticleEffect(util.vector.centerOf(basinPos), ingot));

		ItemStack block = new ItemStack(Items.COPPER_BLOCK);
		scene.idle(30);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(basinPos), Pointing.RIGHT).withItem(block),
			30);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("This can be useful if outputs should be re-used as ingredients")
			.pointAt(basinSide)
			.placeNearTarget();
		scene.idle(80);

		scene.world.showSection(util.select.fromTo(2, 2, 5, 4, 1, 2), Direction.DOWN);
		scene.rotateCameraY(70);
		scene.world.createItemOnBelt(util.grid.at(2, 1, 2), Direction.WEST, block);
		scene.idle(40);
		scene.overlay.showText(70)
			.text("Desired outputs will then have to be extracted from the basin")
			.pointAt(util.vector.topOf(util.grid.at(3, 1, 2))
				.subtract(0, 3 / 16f, 0))
			.placeNearTarget();
		scene.idle(80);

		Vec3 filter = util.vector.of(2.5, 2.825, 2.5);
		scene.overlay.showFilterSlotInput(filter, Direction.EAST, 80);
		scene.overlay.showText(70)
			.text("A Filter might be necessary to avoid pulling out un-processed items")
			.pointAt(filter)
			.placeNearTarget();
		scene.idle(40);
		scene.markAsFinished();
	}

}
//文件scenes/PulleyScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;

public class PulleyScenes {

	public static void movement(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("rope_pulley", "Moving Structures using Rope Pulleys");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(0.95f);
		scene.setSceneOffsetY(-1);

		Selection reversable = util.select.fromTo(2, 3, 4, 2, 4, 2);
		BlockPos leverPos = util.grid.at(1, 2, 4);
		BlockPos pulleyPos = util.grid.at(2, 4, 2);
		Selection redstoneStuff = util.select.fromTo(leverPos, leverPos.east());

		scene.world.showSection(util.select.layer(0), Direction.UP);
		ElementLink<WorldSectionElement> plank =
			scene.world.showIndependentSection(util.select.position(2, 1, 2), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 4, 3, 2, 1, 4), Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(util.select.position(pulleyPos), Direction.SOUTH);
		scene.idle(20);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, 2, 40);

		scene.idle(45);
		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(pulleyPos, Direction.WEST))
			.attachKeyFrame()
			.text("Rope Pulleys can move blocks vertically when given Rotational Force")
			.placeNearTarget();
		scene.idle(70);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, -2, 40);
		scene.world.moveSection(plank, util.vector.of(0, 2, 0), 40);
		scene.idle(60);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(pulleyPos, Direction.SOUTH))
			.text("Direction and Speed of movement depend on the Rotational Input")
			.placeNearTarget();

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, 2, 40);
		scene.world.moveSection(plank, util.vector.of(0, -2, 0), 40);
		scene.idle(50);

		scene.world.hideIndependentSection(plank, Direction.NORTH);
		scene.idle(15);
		ElementLink<WorldSectionElement> chassis =
			scene.world.showIndependentSection(util.select.fromTo(2, 1, 1, 0, 2, 1), Direction.SOUTH);
		scene.world.moveSection(chassis, util.vector.of(1, 0, 1), 0);
		scene.world.replaceBlocks(util.select.fromTo(0, 2, 1, 2, 1, 1), Blocks.OAK_PLANKS.defaultBlockState(), false);

		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.position(2, 1, 0), Direction.SOUTH, chassis);
		scene.overlay.showOutline(PonderPalette.GREEN, "glue", util.select.position(3, 1, 1)
			.add(util.select.fromTo(1, 1, 2, 3, 1, 2))
			.add(util.select.position(1, 2, 2)), 40);
		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(2, 2, 0)), Pointing.RIGHT)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);
		scene.idle(15);
		scene.effects.superGlue(util.grid.at(3, 1, 1), Direction.SOUTH, true);
		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 2), Direction.NORTH))
			.placeNearTarget()
			.attachKeyFrame()
			.sharedText("movement_anchors");
		scene.idle(90);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, -2, 40);
		scene.world.moveSection(chassis, util.vector.of(0, 2, 0), 40);
		scene.idle(50);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, 2, 40);
		scene.world.moveSection(chassis, util.vector.of(0, -2, 0), 40);
		scene.idle(50);
	}

	public static void movementModes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("rope_pulley_modes", "Movement Modes of the Rope Pulley");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(0.95f);
		scene.setSceneOffsetY(-1);

		Selection reversable = util.select.fromTo(2, 3, 4, 2, 4, 2);
		BlockPos leverPos = util.grid.at(1, 2, 4);
		BlockPos pulleyPos = util.grid.at(2, 4, 2);
		Selection redstoneStuff = util.select.fromTo(leverPos, leverPos.east());
		BlockPos flowerPos = util.grid.at(2, 1, 2);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.world.showSection(util.select.position(flowerPos), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 4, 3, 2, 1, 4), Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(util.select.position(pulleyPos), Direction.SOUTH);
		ElementLink<WorldSectionElement> glass =
			scene.world.showIndependentSection(util.select.position(pulleyPos.below()), Direction.UP);
		scene.idle(20);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, 2, 40);
		scene.world.moveSection(glass, util.vector.of(0, -2, 0), 40);
		scene.idle(40);

		scene.world.destroyBlock(flowerPos);
		scene.idle(10);
		scene.overlay.showSelectionWithText(util.select.position(flowerPos), 70)
			.text("Whenever Pulleys stop moving, the moved structure reverts to blocks")
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.RED);
		scene.idle(80);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, -2, 40);
		scene.world.moveSection(glass, util.vector.of(0, 2, 0), 40);
		scene.world.hideSection(util.select.position(flowerPos), Direction.DOWN);
		scene.idle(40);

		scene.world.setBlock(flowerPos, Blocks.BLUE_ORCHID.defaultBlockState(), false);
		scene.world.showSection(util.select.position(flowerPos), Direction.DOWN);
		scene.overlay.showCenteredScrollInput(pulleyPos, Direction.UP, 60);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(pulleyPos), Pointing.DOWN).rightClick(),
			60);
		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(pulleyPos))
			.placeNearTarget()
			.attachKeyFrame()
			.sharedText("behaviour_modify_value_panel");
		scene.idle(80);

		scene.world.toggleRedstonePower(redstoneStuff);
		scene.effects.indicateRedstone(leverPos);
		scene.world.modifyKineticSpeed(reversable, f -> -f);
		scene.effects.rotationDirectionIndicator(pulleyPos.south());
		scene.world.movePulley(pulleyPos, 2, 40);
		scene.world.moveSection(glass, util.vector.of(0, -2, 0), 40);
		scene.idle(50);
		scene.overlay.showText(120)
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(flowerPos, Direction.WEST))
			.placeNearTarget()
			.text("It can be configured never to revert to solid blocks, or only at the location it started at");
		scene.idle(90);
	}

	public static void attachment(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("rope_pulley_attachment", "Moving Pulleys as part of a Contraption");
		scene.configureBasePlate(0, 0, 5);
		scene.scaleSceneView(0.95f);
		scene.setSceneOffsetY(-1);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		Selection kinetics = util.select.fromTo(4, 3, 2, 4, 1, 5);
		Selection largeCog = util.select.position(3, 0, 5);

		scene.world.showSection(kinetics, Direction.DOWN);
		ElementLink<WorldSectionElement> poles =
			scene.world.showIndependentSection(util.select.fromTo(4, 4, 2, 6, 4, 2), Direction.DOWN);
		scene.world.moveSection(poles, util.vector.of(0, -1, 0), 0);
		scene.idle(10);

		BlockPos pulleyPos = util.grid.at(3, 3, 2);
		ElementLink<WorldSectionElement> pulley =
			scene.world.showIndependentSection(util.select.position(pulleyPos), Direction.EAST);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 1, 1, 3, 1, 2)
			.add(util.select.position(3, 2, 1)), Direction.SOUTH, pulley);

		scene.idle(10);
		scene.overlay.showText(50)
			.pointAt(util.vector.blockSurface(pulleyPos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Whenever Pulleys are themselves being moved by a Contraption...");
		scene.idle(60);

		scene.world.setKineticSpeed(largeCog, -16);
		scene.world.setKineticSpeed(kinetics, 32);
		scene.effects.rotationDirectionIndicator(util.grid.at(4, 1, 5));
		scene.world.moveSection(poles, util.vector.of(-2, 0, 0), 40);
		scene.world.moveSection(pulley, util.vector.of(-2, 0, 0), 40);
		scene.idle(40);

		scene.overlay.showSelectionWithText(util.select.fromTo(1, 1, 1, 1, 1, 2), 50)
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.attachKeyFrame()
			.text("...its attached structure will be dragged with it");
		scene.idle(60);
		scene.overlay.showText(80)
			.colored(PonderPalette.RED)
			.pointAt(util.vector.topOf(pulleyPos.west(2)))
			.placeNearTarget()
			.text("Mind that pulleys are only movable while stopped");
		scene.idle(50);
	}

	public static void multiRope(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("rope_pulley_multi_rope", "Synchronised Pulley Movement");
		scene.configureBasePlate(0, 0, 5);
		scene.setSceneOffsetY(-1);
		scene.scaleSceneView(.95f);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		Selection contraption = util.select.fromTo(3, 1, 1, 1, 1, 3);
		BlockPos crankPos = util.grid.at(3, 4, 0);
		BlockPos pulley1 = util.grid.at(3, 4, 1);
		BlockPos pulley2 = util.grid.at(3, 4, 3);
		BlockPos pulley3 = util.grid.at(1, 4, 3);
		Selection kinetics = util.select.fromTo(3, 4, 0, 3, 4, 1);

		ElementLink<WorldSectionElement> planksLink = scene.world.showIndependentSection(contraption, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(util.select.position(pulley1), Direction.DOWN);
		scene.idle(4);
		scene.world.showSection(util.select.position(pulley2), Direction.DOWN);
		scene.idle(4);
		scene.world.showSection(util.select.position(pulley3), Direction.DOWN);
		scene.idle(4);
		scene.world.showSection(util.select.position(crankPos), Direction.SOUTH);
		scene.idle(15);

		scene.world.setKineticSpeed(kinetics, 32);
		scene.world.movePulley(pulley1, 2, 20);
		scene.idle(20);

		scene.world.setKineticSpeed(kinetics, 0);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(util.grid.at(3, 1, 1)))
			.placeNearTarget()
			.text("Whenever a pulley assembles a contraption...");
		scene.idle(70);

		scene.world.movePulley(pulley2, 2, 0);
		scene.world.movePulley(pulley3, 2, 0);
		scene.idle(1);
		scene.world.setKineticSpeed(kinetics, -32);
		scene.world.movePulley(pulley1, -2, 20);
		scene.world.movePulley(pulley2, -2, 20);
		scene.world.movePulley(pulley3, -2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, 2, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 4, 3), Direction.WEST))
			.placeNearTarget()
			.text("...other pulleys on the same layer will connect to the structure");
		scene.idle(60);

		scene.world.setKineticSpeed(kinetics, 32);
		scene.world.movePulley(pulley1, 2, 20);
		scene.world.movePulley(pulley2, 2, 20);
		scene.world.movePulley(pulley3, 2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, -2, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);

		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 32);
		scene.world.movePulley(pulley1, -2, 20);
		scene.world.movePulley(pulley2, -2, 20);
		scene.world.movePulley(pulley3, -2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, 2, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 4, 3), Direction.WEST))
			.placeNearTarget()
			.text("They do not require to be powered, the effect is purely cosmetic");
		scene.idle(60);

		scene.world.setKineticSpeed(kinetics, 32);
		scene.world.movePulley(pulley1, 2, 20);
		scene.world.movePulley(pulley2, 2, 20);
		scene.world.movePulley(pulley3, 2, 20);
		scene.world.moveSection(planksLink, util.vector.of(0, -2, 0), 20);
		scene.idle(20);
		scene.world.setKineticSpeed(kinetics, 0);
	}

}
//文件scenes/RedstoneScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.chassis.StickerBlock;
import com.simibubi.create.content.contraptions.chassis.StickerBlockEntity;
import com.simibubi.create.content.equipment.clipboard.ClipboardOverrides;
import com.simibubi.create.content.equipment.clipboard.ClipboardOverrides.ClipboardType;
import com.simibubi.create.content.redstone.analogLever.AnalogLeverBlockEntity;
import com.simibubi.create.content.redstone.diodes.BrassDiodeBlock;
import com.simibubi.create.content.redstone.diodes.PoweredLatchBlock;
import com.simibubi.create.content.redstone.diodes.PulseExtenderBlockEntity;
import com.simibubi.create.content.redstone.diodes.PulseRepeaterBlockEntity;
import com.simibubi.create.content.redstone.diodes.ToggleLatchBlock;
import com.simibubi.create.content.redstone.link.RedstoneLinkBlock;
import com.simibubi.create.content.redstone.link.RedstoneLinkBlockEntity;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlock;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RedstoneScenes {

	public static void sticker(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("sticker", "Attaching blocks using the Sticker");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);

		Selection redstone = util.select.fromTo(0, 2, 2, 2, 2, 2);
		BlockPos stickerPos = util.grid.at(2, 2, 2);
		Selection stickerSelect = util.select.position(stickerPos);
		BlockPos buttonPos = util.grid.at(0, 2, 2);
		BlockPos bearingPos = util.grid.at(2, 1, 2);

		scene.world.showSection(util.select.fromTo(2, 1, 2, 0, 2, 2)
			.substract(stickerSelect), Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> sticker = scene.world.showIndependentSection(stickerSelect, Direction.DOWN);
		scene.idle(10);
		ElementLink<WorldSectionElement> plank =
			scene.world.showIndependentSection(util.select.position(2, 2, 1), Direction.SOUTH);
		scene.world.configureCenterOfRotation(sticker, util.vector.centerOf(stickerPos));
		scene.world.configureCenterOfRotation(plank, util.vector.centerOf(stickerPos));
		scene.overlay.showText(60)
			.text("Stickers are ideal for Redstone-controlled block attachment")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(stickerPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(70);

		scene.world.toggleRedstonePower(redstone);
		scene.world.modifyBlock(stickerPos, s -> s.setValue(StickerBlock.EXTENDED, true), false);
		scene.effects.indicateRedstone(buttonPos);
		scene.world.modifyBlockEntityNBT(stickerSelect, StickerBlockEntity.class, nbt -> {
		});
		scene.idle(20);

		scene.world.toggleRedstonePower(redstone);
		scene.idle(20);

		scene.overlay.showText(60)
			.text("Upon receiving a signal, it will toggle its state")
			.pointAt(util.vector.blockSurface(stickerPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(70);

		scene.world.rotateBearing(bearingPos, 180 * 3, 80);
		scene.world.rotateSection(sticker, 0, 180 * 3, 0, 80);
		scene.world.rotateSection(plank, 0, 180 * 3, 0, 80);
		scene.overlay.showText(70)
			.text("If it is now moved in a contraption, the block will move with it")
			.pointAt(util.vector.topOf(stickerPos))
			.placeNearTarget();
		scene.idle(90);
		scene.addKeyframe();

		scene.world.toggleRedstonePower(redstone);
		scene.world.modifyBlock(stickerPos, s -> s.setValue(StickerBlock.EXTENDED, false), false);
		scene.effects.indicateRedstone(buttonPos);
		scene.world.modifyBlockEntityNBT(stickerSelect, StickerBlockEntity.class, nbt -> {
		});
		scene.idle(20);

		scene.world.toggleRedstonePower(redstone);
		scene.idle(20);

		scene.overlay.showText(60)
			.text("Toggled once again, the block is no longer attached")
			.pointAt(util.vector.blockSurface(stickerPos, Direction.WEST))
			.placeNearTarget();
		scene.idle(70);

		scene.world.rotateBearing(bearingPos, 180 * 3, 80);
		scene.world.rotateSection(sticker, 0, 180 * 3, 0, 80);
	}

	public static void contact(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("redstone_contact", "Redstone Contacts");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();
		scene.idle(5);
		Selection contactAndRedstone = util.select.fromTo(1, 1, 0, 1, 1, 2);
		Selection topContact = util.select.position(1, 2, 2);

		scene.world.toggleRedstonePower(contactAndRedstone);
		scene.world.toggleRedstonePower(topContact);
		scene.world.showSection(contactAndRedstone, Direction.DOWN);

		BlockPos bearingPos = util.grid.at(3, 1, 2);
		scene.idle(25);

		ElementLink<WorldSectionElement> contact = scene.world.showIndependentSection(topContact, Direction.DOWN);
		scene.idle(10);
		scene.world.toggleRedstonePower(topContact);
		scene.world.toggleRedstonePower(contactAndRedstone);
		scene.effects.indicateRedstone(util.grid.at(1, 1, 2));
		scene.idle(10);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(util.vector.of(1, 2, 2.5))
			.text("Redstone Contacts facing each other will emit a redstone signal");
		scene.idle(70);

		scene.world.showSection(util.select.position(bearingPos), Direction.DOWN);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 2, 2, 4, 2, 2), Direction.DOWN, contact);
		scene.idle(10);
		scene.effects.superGlue(util.grid.at(1, 2, 2), Direction.EAST, true);
		scene.world.configureCenterOfRotation(contact, util.vector.centerOf(bearingPos));

		int speed = 2;

		scene.idle(10);
		scene.world.rotateBearing(bearingPos, 10, speed);
		scene.world.rotateSection(contact, 0, 10, 0, speed);
		scene.idle(speed);

		scene.world.toggleRedstonePower(topContact);
		scene.world.toggleRedstonePower(contactAndRedstone);
		scene.effects.indicateRedstone(util.grid.at(1, 1, 2));
		scene.world.rotateBearing(bearingPos, 340, 34 * speed);
		scene.world.rotateSection(contact, 0, 340, 0, 34 * speed);
		scene.addKeyframe();
		scene.idle(34 * speed);

		scene.overlay.showText(100)
			.placeNearTarget()
			.pointAt(util.vector.of(1, 1.5, 2.5))
			.text("This still applies when one of them is part of a moving Contraption");

		for (int i = 0; i < 5; i++) {
			scene.world.toggleRedstonePower(topContact);
			scene.world.toggleRedstonePower(contactAndRedstone);
			scene.effects.indicateRedstone(util.grid.at(1, 1, 2));
			scene.world.rotateBearing(bearingPos, 20, 2 * speed);
			scene.world.rotateSection(contact, 0, 20, 0, 2 * speed);
			scene.idle(2 * speed);

			scene.world.toggleRedstonePower(topContact);
			scene.world.toggleRedstonePower(contactAndRedstone);
			scene.world.rotateBearing(bearingPos, 340, 34 * speed);
			scene.world.rotateSection(contact, 0, 340, 0, 34 * speed);
			scene.idle(34 * speed);

			if (i == 0)
				scene.markAsFinished();
		}

		scene.world.toggleRedstonePower(topContact);
		scene.world.toggleRedstonePower(contactAndRedstone);
		scene.world.rotateBearing(bearingPos, 10, speed);
		scene.world.rotateSection(contact, 0, 10, 0, speed);
	}

	public static void pulseExtender(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("pulse_extender", "Controlling signals using Pulse Extenders");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos circuitPos = util.grid.at(2, 1, 2);
		BlockPos leverPos = util.grid.at(4, 1, 2);

		scene.world.modifyBlockEntityNBT(util.select.position(circuitPos), PulseExtenderBlockEntity.class,
			nbt -> nbt.putInt("ScrollValue", 30));
		scene.world.showSection(util.select.layersFrom(1)
			.substract(util.select.position(circuitPos)), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.position(circuitPos), Direction.DOWN);
		scene.idle(20);

		Vec3 circuitTop = util.vector.blockSurface(circuitPos, Direction.DOWN)
			.add(0, 3 / 16f, 0);
		scene.overlay.showText(70)
			.text("Pulse Extenders can lengthen a signal passing through")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(60);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(2);
		scene.world.toggleRedstonePower(util.select.fromTo(1, 1, 2, 0, 1, 2));
		scene.idle(15);

		scene.overlay.showText(60)
			.text("They activate after a short delay...")
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(0, 1, 2)));
		scene.idle(50);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(30);
		scene.world.cycleBlockProperty(circuitPos, BrassDiodeBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 1, 2));
		scene.idle(1);
		scene.world.toggleRedstonePower(util.select.position(0, 1, 2));
		scene.idle(15);

		scene.overlay.showText(40)
			.text("...and cool down for the configured duration")
			.placeNearTarget()
			.pointAt(util.vector.topOf(util.grid.at(0, 1, 2)));
		scene.idle(50);

		scene.overlay.showRepeaterScrollInput(circuitPos, 60);
		scene.overlay.showControls(new InputWindowElement(circuitTop, Pointing.DOWN).rightClick(), 60);
		scene.idle(10);
		scene.overlay.showText(60)
			.text("Using the value panel, the discharge time can be configured")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.world.modifyBlockEntityNBT(util.select.position(circuitPos), PulseExtenderBlockEntity.class,
			nbt -> nbt.putInt("ScrollValue", 120));
		scene.idle(70);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(2);
		scene.world.toggleRedstonePower(util.select.fromTo(1, 1, 2, 0, 1, 2));
		scene.idle(20);
		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(15);
		scene.overlay.showText(50)
			.text("The configured duration can range up to an hour")
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(70);
		scene.world.cycleBlockProperty(circuitPos, BrassDiodeBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 1, 2));
		scene.idle(1);
		scene.world.toggleRedstonePower(util.select.position(0, 1, 2));
		scene.idle(15);

	}

	public static void pulseRepeater(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("pulse_repeater", "Controlling signals using Pulse Repeaters");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos circuitPos = util.grid.at(2, 1, 2);
		BlockPos leverPos = util.grid.at(4, 1, 2);

		scene.world.modifyBlockEntityNBT(util.select.position(circuitPos), PulseRepeaterBlockEntity.class,
			nbt -> nbt.putInt("ScrollValue", 30));
		scene.world.showSection(util.select.layersFrom(1)
			.substract(util.select.position(circuitPos)), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.position(circuitPos), Direction.DOWN);
		scene.idle(20);

		Vec3 circuitTop = util.vector.blockSurface(circuitPos, Direction.DOWN)
			.add(0, 3 / 16f, 0);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(30);
		scene.world.cycleBlockProperty(circuitPos, BrassDiodeBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.fromTo(1, 1, 2, 0, 1, 2));
		scene.idle(2);
		scene.world.cycleBlockProperty(circuitPos, BrassDiodeBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 1, 2));
		scene.idle(1);
		scene.world.toggleRedstonePower(util.select.position(0, 1, 2));
		scene.idle(15);

		scene.overlay.showText(60)
			.text("Pulse Repeaters emit a short pulse after a delay")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(circuitTop);

		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(70);

		scene.overlay.showRepeaterScrollInput(circuitPos, 60);
		scene.overlay.showControls(new InputWindowElement(circuitTop, Pointing.DOWN).rightClick(), 60);
		scene.idle(10);
		scene.overlay.showText(60)
			.text("Using the value panel, the charge time can be configured")
			.attachKeyFrame()
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.world.modifyBlockEntityNBT(util.select.position(circuitPos), PulseRepeaterBlockEntity.class,
			nbt -> nbt.putInt("ScrollValue", 120));
		scene.idle(70);

		scene.effects.indicateRedstone(leverPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 2, 1, 2));
		scene.idle(60);
		scene.overlay.showText(50)
			.text("Configured delays can range up to an hour")
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(60);
		scene.world.cycleBlockProperty(circuitPos, BrassDiodeBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.fromTo(1, 1, 2, 0, 1, 2));
		scene.idle(2);
		scene.world.cycleBlockProperty(circuitPos, BrassDiodeBlock.POWERING);
		scene.world.toggleRedstonePower(util.select.position(1, 1, 2));
		scene.idle(1);
		scene.world.toggleRedstonePower(util.select.position(0, 1, 2));
	}

	public static void poweredLatch(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("powered_latch", "Controlling signals using the Powered Latch");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos circuitPos = util.grid.at(2, 1, 2);
		BlockPos buttonPos = util.grid.at(4, 1, 2);
		Vec3 circuitTop = util.vector.blockSurface(circuitPos, Direction.DOWN)
			.add(0, 3 / 16f, 0);

		scene.world.showSection(util.select.layersFrom(1)
			.substract(util.select.position(circuitPos)), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.position(circuitPos), Direction.DOWN);
		scene.idle(20);

		scene.overlay.showText(40)
			.attachKeyFrame()
			.text("Powered Latches are redstone controllable Levers")
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(50);

		scene.effects.indicateRedstone(buttonPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, PoweredLatchBlock.POWERING);
		scene.idle(30);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 3, 1, 2));

		AABB bb = new AABB(circuitPos).inflate(-.48f, -.45f, -.05f)
			.move(.575, -.45, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb, 40);
		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.text("Signals at the back switch it on")
			.placeNearTarget()
			.pointAt(bb.getCenter());
		scene.idle(60);

		scene.effects.indicateRedstone(util.grid.at(2, 1, 0));
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 0, 2, 1, 1));
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, PoweredLatchBlock.POWERING);
		scene.idle(30);
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 0, 2, 1, 1));

		bb = new AABB(circuitPos).inflate(-.05f, -.45f, -.48f)
			.move(0, -.45, .575);
		AABB bb2 = new AABB(circuitPos).inflate(-.05f, -.45f, -.48f)
			.move(0, -.45, -.575);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb, 40);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb2, bb2, 40);
		scene.overlay.showText(40)
			.colored(PonderPalette.RED)
			.text("Signals from the side switch it back off")
			.placeNearTarget()
			.pointAt(bb2.getCenter());
		scene.idle(50);

		scene.addKeyframe();
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(circuitTop, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, PoweredLatchBlock.POWERING);
		scene.idle(10);

		scene.overlay.showText(50)
			.text("Powered latches can also be toggled manually")
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(circuitTop, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, PoweredLatchBlock.POWERING);
		scene.idle(10);
	}

	public static void poweredToggleLatch(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("powered_toggle_latch", "Controlling signals using the Powered Toggle Latch");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);

		BlockPos circuitPos = util.grid.at(2, 1, 2);
		BlockPos buttonPos = util.grid.at(4, 1, 2);
		Vec3 circuitTop = util.vector.blockSurface(circuitPos, Direction.DOWN)
			.add(0, 3 / 16f, 0);

		scene.world.showSection(util.select.layersFrom(1)
			.substract(util.select.position(circuitPos)), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.position(circuitPos), Direction.DOWN);
		scene.idle(20);

		scene.overlay.showText(40)
			.attachKeyFrame()
			.text("Powered Toggle Latches are redstone controllable Levers")
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(50);

		scene.effects.indicateRedstone(buttonPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, ToggleLatchBlock.POWERING);
		scene.idle(30);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 3, 1, 2));

		AABB bb = new AABB(circuitPos).inflate(-.48f, -.45f, -.05f)
			.move(.575, -.45, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb, 40);
		scene.overlay.showText(40)
			.colored(PonderPalette.GREEN)
			.text("Signals at the back will toggle its state")
			.placeNearTarget()
			.pointAt(bb.getCenter());
		scene.idle(60);

		scene.effects.indicateRedstone(buttonPos);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, ToggleLatchBlock.POWERING);
		scene.idle(30);
		scene.world.toggleRedstonePower(util.select.fromTo(4, 1, 2, 3, 1, 2));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb, 40);
		scene.overlay.showText(30)
			.colored(PonderPalette.RED)
			.text("...on and back off")
			.placeNearTarget()
			.pointAt(bb.getCenter());
		scene.idle(50);

		scene.addKeyframe();
		scene.idle(10);
		scene.overlay.showControls(new InputWindowElement(circuitTop, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, ToggleLatchBlock.POWERING);
		scene.idle(10);

		scene.overlay.showText(50)
			.text("Powered toggle latches can also be toggled manually")
			.placeNearTarget()
			.pointAt(circuitTop);
		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(circuitTop, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		scene.world.toggleRedstonePower(util.select.fromTo(2, 1, 2, 0, 1, 2));
		scene.world.cycleBlockProperty(circuitPos, ToggleLatchBlock.POWERING);
		scene.idle(10);
	}

	public static void analogLever(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("analog_lever", "Controlling signals using the Analog Lever");
		scene.configureBasePlate(0, 0, 5);

		BlockPos[] wireLocations = new BlockPos[] { util.grid.at(2, 1, 1), util.grid.at(2, 1, 0), util.grid.at(1, 1, 0),
			util.grid.at(0, 1, 0), util.grid.at(0, 1, 1), util.grid.at(0, 1, 2), util.grid.at(0, 1, 3),
			util.grid.at(0, 1, 4), util.grid.at(1, 1, 4), util.grid.at(2, 1, 4), util.grid.at(3, 1, 4),
			util.grid.at(4, 1, 4), util.grid.at(4, 1, 3), util.grid.at(4, 1, 2), util.grid.at(4, 1, 1) };

		Selection leverSelection = util.select.fromTo(2, 1, 2, 2, 2, 2);
		Selection lamp = util.select.position(4, 1, 0);
		BlockPos leverPos = util.grid.at(2, 2, 2);
		Vec3 leverVec = util.vector.centerOf(leverPos)
			.add(0, -.25, 0);

		scene.world.showSection(util.select.layersFrom(0)
			.substract(lamp)
			.substract(leverSelection), Direction.UP);
		scene.idle(5);
		scene.world.showSection(lamp, Direction.DOWN);
		scene.idle(10);

		scene.world.showSection(leverSelection, Direction.DOWN);
		scene.idle(20);

		scene.overlay.showText(60)
			.text("Analog Levers make for a compact and precise source of redstone power")
			.placeNearTarget()
			.attachKeyFrame()
			.pointAt(leverVec);
		scene.idle(70);

		IntegerProperty power = RedStoneWireBlock.POWER;
		scene.overlay.showControls(new InputWindowElement(leverVec, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		for (int i = 0; i < 7; i++) {
			scene.idle(2);
			final int state = i + 1;
			scene.world.modifyBlockEntityNBT(leverSelection, AnalogLeverBlockEntity.class,
				nbt -> nbt.putInt("State", state));
			scene.world.modifyBlock(wireLocations[i], s -> s.setValue(power, 7 - state), false);
			scene.effects.indicateRedstone(wireLocations[i]);
		}
		scene.idle(20);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Right-click to increase its analog power output")
			.placeNearTarget()
			.pointAt(leverVec);
		scene.idle(70);

		scene.overlay.showControls(new InputWindowElement(leverVec, Pointing.DOWN).rightClick()
			.whileSneaking(), 40);
		scene.idle(7);
		for (int i = 7; i > 0; i--) {
			scene.idle(2);
			final int state = i - 1;
			if (i > 3) {
				scene.world.modifyBlockEntityNBT(leverSelection, AnalogLeverBlockEntity.class,
					nbt -> nbt.putInt("State", state));
				scene.effects.indicateRedstone(wireLocations[i]);
			}
			scene.world.modifyBlock(wireLocations[i], s -> s.setValue(power, state > 2 ? 0 : 3 - state), false);
		}
		scene.world.modifyBlock(wireLocations[0], s -> s.setValue(power, 3), false);
		scene.idle(20);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("Right-click while Sneaking to decrease the power output again")
			.placeNearTarget()
			.pointAt(leverVec);
		scene.idle(70);

		scene.overlay.showControls(new InputWindowElement(leverVec, Pointing.DOWN).rightClick(), 40);
		scene.idle(7);
		for (int i = 0; i < 15; i++) {
			scene.idle(2);
			final int state = i + 1;
			if (i >= 4) {
				scene.world.modifyBlockEntityNBT(leverSelection, AnalogLeverBlockEntity.class,
					nbt -> nbt.putInt("State", state));
				scene.effects.indicateRedstone(wireLocations[i]);
			}
			scene.world.modifyBlock(wireLocations[i], s -> s.setValue(power, 15 - state), false);
		}

		scene.world.toggleRedstonePower(lamp);
		scene.effects.indicateRedstone(leverPos);
		scene.effects.indicateRedstone(util.grid.at(4, 1, 1));
		scene.idle(20);
	}

	public static void nixieTube(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("nixie_tube", "Using Nixie Tubes");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.fromTo(2, 1, 1, 2, 1, 2)), Direction.UP);
		scene.idle(10);
		scene.world.showSection(util.select.position(2, 1, 3), Direction.DOWN);
		scene.idle(20);

		Selection tubes = util.select.fromTo(3, 1, 3, 1, 1, 3);

		scene.effects.indicateRedstone(util.grid.at(2, 1, 1));
		scene.world.modifyBlockEntityNBT(util.select.position(2, 1, 1), AnalogLeverBlockEntity.class,
			nbt -> nbt.putInt("State", 11));
		scene.world.modifyBlock(util.grid.at(2, 1, 2), s -> s.setValue(RedStoneWireBlock.POWER, 11), false);
		scene.world.modifyBlockEntityNBT(tubes, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 11));
		scene.idle(20);

		Vec3 centerTube = util.vector.centerOf(2, 1, 3);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("When powered by Redstone, Nixie Tubes will display the signal strength")
			.placeNearTarget()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 3), Direction.WEST));
		scene.idle(70);

		scene.world.hideSection(util.select.position(2, 1, 3), Direction.UP);
		scene.idle(5);
		scene.world.hideSection(util.select.fromTo(2, 1, 1, 2, 1, 2), Direction.NORTH);
		scene.idle(10);
		scene.world.modifyBlockEntityNBT(tubes, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 0));
		scene.world.showSection(tubes, Direction.DOWN);
		scene.idle(20);

		ItemStack clipboard = AllBlocks.CLIPBOARD.asStack();
		ClipboardOverrides.switchTo(ClipboardType.WRITTEN, clipboard);
		scene.overlay.showControls(new InputWindowElement(centerTube.add(1, .35, 0), Pointing.DOWN).rightClick()
			.withItem(clipboard), 40);
		scene.idle(7);

		Component component = Components.literal("CREATE");
		for (int i = 0; i < 3; i++) {
			final int index = i;
			scene.world.modifyBlockEntityNBT(util.select.position(3 - i, 1, 3), NixieTubeBlockEntity.class, nbt -> {
				nbt.putString("RawCustomText", component.getString());
				nbt.putString("CustomText", Component.Serializer.toJson(component));
				nbt.putInt("CustomTextIndex", index);
			});
		}

		scene.idle(10);
		scene.world.showSection(util.select.position(4, 1, 3), Direction.DOWN);
		scene.idle(10);
		scene.special.createBirb(util.vector.topOf(util.grid.at(0, 0, 3)), ParrotElement.DancePose::new);

		scene.idle(20);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Using written Clipboards, custom text can be displayed")
			.pointAt(util.vector.topOf(util.grid.at(3, 1, 3))
				.add(-.75, -.05f, 0));
		scene.idle(90);

		InputWindowElement input =
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.UP), Pointing.DOWN)
				.withItem(new ItemStack(Items.BLUE_DYE));
		scene.overlay.showControls(input, 30);
		scene.idle(7);
		scene.world.setBlocks(util.select.fromTo(1, 1, 3, 3, 1, 3), AllBlocks.NIXIE_TUBES.get(DyeColor.BLUE)
			.getDefaultState()
			.setValue(NixieTubeBlock.FACING, Direction.WEST), false);
		scene.idle(10);
		scene.overlay.showText(80)
			.colored(PonderPalette.BLUE)
			.text("Right-Click with Dye to change their display colour")
			.attachKeyFrame()
			.pointAt(util.vector.topOf(util.grid.at(3, 1, 3))
				.add(-.75, -.05f, 0))
			.placeNearTarget();
		scene.idle(60);
	}

	public static void redstoneLink(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("redstone_link", "Using Redstone Links");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0)
			.add(util.select.fromTo(3, 1, 1, 2, 1, 1)), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 3, 0, 2, 3), Direction.DOWN);
		scene.idle(10);

		Selection redstone = util.select.fromTo(3, 1, 1, 1, 1, 1);
		BlockPos leverPos = util.grid.at(3, 1, 1);
		BlockPos link1Pos = util.grid.at(1, 1, 1);
		BlockPos link2Pos = util.grid.at(1, 2, 2);
		BlockPos link3Pos = util.grid.at(3, 2, 2);
		Selection link1Select = util.select.position(link1Pos);
		Selection link2Select = util.select.position(link2Pos);
		Selection link3Select = util.select.position(link3Pos);
		Vec3 link1Vec = util.vector.blockSurface(link1Pos, Direction.DOWN)
			.add(0, 3 / 16f, 0);
		Vec3 link2Vec = util.vector.blockSurface(link2Pos, Direction.SOUTH)
			.add(0, 0, -3 / 16f);
		Vec3 link3Vec = util.vector.blockSurface(link3Pos, Direction.SOUTH)
			.add(0, 0, -3 / 16f);

		scene.world.showSection(link1Select, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(link2Select, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(link3Select, Direction.DOWN);
		scene.idle(10);

		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("Redstone Links can transmit redstone signals wirelessly")
			.placeNearTarget()
			.pointAt(link1Vec);
		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(link2Vec, Pointing.UP).rightClick()
			.whileSneaking(), 40);
		scene.idle(7);
		scene.world.modifyBlock(link2Pos, s -> s.cycle(RedstoneLinkBlock.RECEIVER), true);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("Right-click while Sneaking to toggle receive mode")
			.placeNearTarget()
			.pointAt(link2Vec);
		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(link3Vec, Pointing.UP).rightClick()
			.withWrench(), 40);
		scene.idle(7);
		scene.world.modifyBlock(link3Pos, s -> s.cycle(RedstoneLinkBlock.RECEIVER), true);
		scene.idle(10);
		scene.overlay.showText(50)
			.text("A simple Right-click with a Wrench can do the same")
			.placeNearTarget()
			.pointAt(link3Vec);
		scene.idle(70);

		scene.addKeyframe();
		scene.idle(10);
		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(5);
		scene.world.toggleRedstonePower(util.select.fromTo(3, 2, 3, 1, 2, 2));
		scene.effects.indicateRedstone(link2Pos);
		scene.effects.indicateRedstone(link3Pos);

		scene.idle(10);
		scene.overlay.showText(70)
			.colored(PonderPalette.GREEN)
			.text("Receivers emit the redstone power of transmitters within 256 blocks")
			.placeNearTarget()
			.pointAt(link2Vec);
		scene.idle(80);
		scene.world.toggleRedstonePower(redstone);
		scene.idle(5);
		scene.world.toggleRedstonePower(util.select.fromTo(3, 2, 3, 1, 2, 2));
		scene.idle(20);

		Vec3 frontSlot = link1Vec.add(0, .025, -.15);
		Vec3 backSlot = link1Vec.add(0, .025, .15);
		Vec3 top2Slot = link2Vec.add(0, .15, 0);
		Vec3 bottom2Slot = link2Vec.add(0, -.2, 0);
		Vec3 top3Slot = link3Vec.add(0, .15, 0);
		Vec3 bottom3Slot = link3Vec.add(0, -.2, 0);

		scene.addKeyframe();
		scene.idle(10);
		scene.overlay.showFilterSlotInput(frontSlot, Direction.UP, 100);
		scene.overlay.showFilterSlotInput(backSlot, Direction.UP, 100);
		scene.idle(10);

		scene.overlay.showText(50)
			.text("Placing items in the two slots can specify a Frequency")
			.placeNearTarget()
			.pointAt(backSlot);
		scene.idle(60);

		ItemStack iron = new ItemStack(Items.IRON_INGOT);
		ItemStack gold = new ItemStack(Items.GOLD_INGOT);
		ItemStack sapling = new ItemStack(Items.OAK_SAPLING);

		scene.overlay.showControls(new InputWindowElement(frontSlot, Pointing.UP).withItem(iron), 30);
		scene.idle(7);
		scene.overlay.showControls(new InputWindowElement(backSlot, Pointing.DOWN).withItem(sapling), 30);
		scene.world.modifyBlockEntityNBT(link1Select, RedstoneLinkBlockEntity.class,
			nbt -> nbt.put("FrequencyLast", iron.save(new CompoundTag())));
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(link1Select, RedstoneLinkBlockEntity.class,
			nbt -> nbt.put("FrequencyFirst", sapling.save(new CompoundTag())));
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(bottom2Slot, Pointing.UP).withItem(iron), 30);
		scene.idle(7);
		scene.overlay.showControls(new InputWindowElement(top2Slot, Pointing.DOWN).withItem(sapling), 30);
		scene.world.modifyBlockEntityNBT(link2Select, RedstoneLinkBlockEntity.class,
			nbt -> nbt.put("FrequencyLast", iron.save(new CompoundTag())));
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(link2Select, RedstoneLinkBlockEntity.class,
			nbt -> nbt.put("FrequencyFirst", sapling.save(new CompoundTag())));
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(bottom3Slot, Pointing.UP).withItem(gold), 30);
		scene.idle(7);
		scene.overlay.showControls(new InputWindowElement(top3Slot, Pointing.DOWN).withItem(sapling), 30);
		scene.world.modifyBlockEntityNBT(link3Select, RedstoneLinkBlockEntity.class,
			nbt -> nbt.put("FrequencyLast", gold.save(new CompoundTag())));
		scene.idle(7);
		scene.world.modifyBlockEntityNBT(link3Select, RedstoneLinkBlockEntity.class,
			nbt -> nbt.put("FrequencyFirst", sapling.save(new CompoundTag())));
		scene.idle(20);

		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(2);
		scene.world.toggleRedstonePower(util.select.fromTo(1, 2, 2, 1, 2, 3));
		scene.overlay.showText(90)
			.attachKeyFrame()
			.text("Only the links with matching Frequencies will communicate")
			.placeNearTarget()
			.pointAt(link2Vec);

		scene.idle(30);
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 1)
				scene.effects.indicateRedstone(leverPos);
			scene.world.toggleRedstonePower(redstone);
			scene.idle(2);
			scene.world.toggleRedstonePower(util.select.fromTo(1, 2, 2, 1, 2, 3));
			scene.idle(20);
		}
	}

}
//文件scenes/RedstoneScenes2.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.content.redstone.RoseQuartzLampBlock;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class RedstoneScenes2 {

	public static void roseQuartzLamp(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("rose_quartz_lamp", "Rose Quartz Lamps");
		scene.configureBasePlate(0, 0, 7);

		BlockPos centerLamp = util.grid.at(3, 1, 3);
		Selection input = util.select.fromTo(3, 1, 1, 3, 1, 2);
		Selection button = util.select.position(3, 1, 1);
		Selection wire = util.select.position(3, 1, 2);
		Selection output = util.select.fromTo(5, 1, 2, 5, 1, 1);
		Selection comparator = util.select.fromTo(1, 1, 3, 0, 1, 3);

		scene.showBasePlate();
		scene.idle(15);

		ElementLink<WorldSectionElement> rowElement =
			scene.world.showIndependentSection(util.select.position(centerLamp), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(input, Direction.SOUTH);
		scene.idle(15);

		scene.world.toggleRedstonePower(input);
		scene.effects.indicateRedstone(util.grid.at(3, 1, 1));
		scene.world.cycleBlockProperty(centerLamp, RoseQuartzLampBlock.POWERING);
		scene.idle(15);

		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(centerLamp, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Rose Quartz Lamps activate on a Redstone signal");
		scene.idle(5);
		scene.world.toggleRedstonePower(button);
		scene.idle(55);

		scene.world.hideSection(input, Direction.EAST);
		scene.idle(10);
		ElementLink<WorldSectionElement> outputElement = scene.world.showIndependentSection(output, Direction.EAST);
		scene.world.moveSection(outputElement, util.vector.of(-2, 0, 0), 0);
		scene.idle(10);
		scene.world.toggleRedstonePower(wire);
		scene.world.toggleRedstonePower(output);
		scene.idle(5);

		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(centerLamp, Direction.WEST))
			.placeNearTarget()
			.text("They will continue to emit redstone power afterwards");
		scene.idle(60);

		scene.world.hideIndependentSection(outputElement, Direction.NORTH);
		scene.world.showSectionAndMerge(util.select.position(centerLamp.west()), Direction.EAST, rowElement);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.position(centerLamp.east()), Direction.WEST, rowElement);
		scene.idle(25);

		scene.overlay.showText(50)
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 3), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("When multiple lamps are arranged in a group...");
		scene.idle(40);

		ElementLink<WorldSectionElement> inputElement = scene.world.showIndependentSection(input, Direction.SOUTH);
		scene.world.moveSection(inputElement, util.vector.of(1, 0, 0), 0);
		scene.idle(15);

		scene.world.toggleRedstonePower(input);
		scene.effects.indicateRedstone(util.grid.at(4, 1, 1));
		scene.world.cycleBlockProperty(centerLamp, RoseQuartzLampBlock.POWERING);
		scene.world.cycleBlockProperty(centerLamp.east(), RoseQuartzLampBlock.POWERING);
		scene.idle(15);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(4, 1, 3), Direction.UP))
			.placeNearTarget()
			.text("...activating a Lamp will focus the signal to it, deactivating all others");

		scene.idle(5);
		scene.world.toggleRedstonePower(button);
		scene.idle(60);

		scene.world.hideIndependentSection(inputElement, Direction.NORTH);
		scene.world.moveSection(rowElement, util.vector.of(1, 0, 0), 10);
		scene.idle(15);
		scene.world.showSectionAndMerge(comparator, Direction.EAST, rowElement);
		scene.idle(15);
		scene.world.toggleRedstonePower(comparator);
		scene.world.modifyBlockEntityNBT(comparator, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 13));
		scene.idle(25);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 3), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Comparators output based on the distance to a powered lamp");
		scene.idle(90);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(centerLamp.east(2)), Pointing.DOWN).rightClick()
				.withWrench(), 20);
		scene.idle(6);
		scene.world.cycleBlockProperty(centerLamp.east(), RoseQuartzLampBlock.POWERING);
		scene.world.toggleRedstonePower(comparator);
		scene.world.modifyBlockEntityNBT(comparator, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 0));
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(centerLamp), Pointing.DOWN).rightClick()
			.withWrench(), 20);
		scene.idle(6);
		scene.world.cycleBlockProperty(centerLamp.west(), RoseQuartzLampBlock.POWERING);
		scene.world.toggleRedstonePower(comparator);
		scene.world.modifyBlockEntityNBT(comparator, NixieTubeBlockEntity.class, nbt -> nbt.putInt("RedstoneStrength", 15));
		scene.idle(20);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.UP))
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Lamps can also be toggled manually using a Wrench");
		scene.idle(50);

	}

}
//文件scenes/RollerScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.content.contraptions.actors.roller.RollerBlockEntity;
import com.simibubi.create.content.trains.station.StationBlock;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class RollerScenes {

	public static void clearAndPave(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_roller_pave", "Clearing and Paving with the Roller");
		scene.configureBasePlate(0, 0, 9);
		scene.scaleSceneView(.75f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();
		scene.idle(5);

		BlockPos stationPos = util.grid.at(7, 1, 1);
		Selection gantryPole = util.select.fromTo(9, 5, 4, 1, 5, 4);
		Selection cogs = util.select.fromTo(9, 0, 4, 9, 4, 4);
		Selection gantryCar = util.select.fromTo(7, 2, 8, 7, 4, 8);
		BlockPos bogeyPos = util.grid.at(7, 2, 4);
		Selection someRubble = util.select.fromTo(2, 1, 3, 3, 2, 5)
			.substract(util.select.fromTo(3, 1, 4, 2, 1, 4));
		Selection chest = util.select.fromTo(7, 2, 5, 8, 3, 5);
		Selection rollers = util.select.fromTo(6, 2, 3, 6, 2, 5);
		Selection train = util.select.fromTo(8, 3, 4, 7, 2, 4);
		BlockPos controlsPos = util.grid.at(7, 3, 4);

		for (int i = 8; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 4), Direction.DOWN);
			scene.idle(1);
		}

		scene.special.movePointOfInterest(util.grid.at(0, 3, 4));
		scene.idle(5);
		scene.world.showSection(util.select.position(stationPos), Direction.DOWN);
		scene.idle(5);
		ElementLink<ParrotElement> birbLink =
			scene.special.createBirb(util.vector.centerOf(8, 3, 4), FacePointOfInterestPose::new);
		ElementLink<WorldSectionElement> trainLink = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.idle(5);
		scene.world.showSectionAndMerge(rollers, Direction.EAST, trainLink);
		scene.idle(15);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, true);

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(util.grid.at(6, 2, 4)))
			.attachKeyFrame()
			.text("Mechanical rollers help to clean up terrain around tracks or paths")
			.placeNearTarget();
		scene.idle(70);

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.showSection(someRubble, Direction.DOWN);
		scene.world.toggleControls(controlsPos);

		scene.world.moveSection(trainLink, util.vector.of(-1.5, 0, 0), 30);
		scene.special.moveParrot(birbLink, util.vector.of(-1.5, 0, 0), 30);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		scene.world.animateBogey(bogeyPos, 1.5f, 30);
		scene.idle(30);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(2, 2, 4)), Pointing.DOWN)
			.showing(AllIcons.I_ROLLER_PAVE), 70);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(util.grid.at(2, 2, 4)))
			.attachKeyFrame()
			.text("In its default mode, without a material set, it will simply clear blocks like a Drill")
			.placeNearTarget();

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(util.grid.at(3, 1, 5));
			scene.world.incrementBlockBreakingProgress(util.grid.at(3, 1, 3));
			scene.world.incrementBlockBreakingProgress(util.grid.at(3, 2, 5));
		}

		scene.world.moveSection(trainLink, util.vector.of(-1, 0, 0), 20);
		scene.special.moveParrot(birbLink, util.vector.of(-1, 0, 0), 20);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		scene.world.animateBogey(bogeyPos, 1f, 20);
		scene.idle(20);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(util.grid.at(2, 2, 4));
			scene.world.incrementBlockBreakingProgress(util.grid.at(2, 1, 3));
		}

		scene.world.moveSection(trainLink, util.vector.of(-2, 0, 0), 40);
		scene.special.moveParrot(birbLink, util.vector.of(-2, 0, 0), 40);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		scene.world.animateBogey(bogeyPos, 2f, 40);
		scene.idle(40);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		scene.special.hideElement(birbLink, Direction.UP);
		scene.world.hideIndependentSection(trainLink, Direction.UP);
		scene.idle(15);

		birbLink = scene.special.createBirb(util.vector.centerOf(8, 3, 4), FacePointOfInterestPose::new);
		trainLink = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.world.toggleControls(controlsPos);
		scene.idle(5);
		scene.world.showSectionAndMerge(rollers, Direction.EAST, trainLink);
		scene.idle(15);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, true);
		scene.world.hideSection(someRubble, Direction.DOWN);

		Vec3 filterSlot = util.vector.of(6.75 - 1 / 16f, 3, 3.25 + 1 / 16f);
		scene.overlay.showFilterSlotInput(filterSlot, Direction.UP, 60);
		scene.overlay.showText(60)
			.pointAt(filterSlot.add(-.125, 0, 0))
			.attachKeyFrame()
			.text("While disassembled, a suitable paving material can be specified")
			.placeNearTarget();
		scene.idle(50);

		Block paveMaterial = Blocks.TUFF;
		ItemStack paveItem = new ItemStack(paveMaterial);
		scene.overlay.showControls(new InputWindowElement(filterSlot, Pointing.DOWN).withItem(paveItem), 40);
		scene.idle(7);
		scene.world.setFilterData(rollers, RollerBlockEntity.class, paveItem);
		scene.idle(20);

		scene.world.showSectionAndMerge(chest, Direction.DOWN, trainLink);
		scene.idle(15);
		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(util.grid.at(7, 3, 5)))
			.text("Materials can be supplied via chests or barrels attached to the structure")
			.placeNearTarget();
		scene.idle(60);

		scene.world.restoreBlocks(someRubble);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.showSection(someRubble, Direction.DOWN);
		scene.world.toggleControls(controlsPos);
		scene.world.showSection(someRubble, Direction.DOWN);

		scene.world.moveSection(trainLink, util.vector.of(-1.5, 0, 0), 30);
		scene.special.moveParrot(birbLink, util.vector.of(-1.5, 0, 0), 30);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		scene.world.animateBogey(bogeyPos, 1.5f, 30);

		scene.world.replaceBlocks(util.select.fromTo(5, 0, 3, 5, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(20);
		scene.world.replaceBlocks(util.select.fromTo(4, 0, 3, 4, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(10);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(util.grid.at(5, 0, 3)))
			.attachKeyFrame()
			.text("In addition to breaking blocks, it will now replace the layer beneath them")
			.placeNearTarget();

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(util.grid.at(3, 1, 5));
			scene.world.incrementBlockBreakingProgress(util.grid.at(3, 1, 3));
			scene.world.incrementBlockBreakingProgress(util.grid.at(3, 2, 5));
		}

		scene.world.moveSection(trainLink, util.vector.of(-1, 0, 0), 20);
		scene.special.moveParrot(birbLink, util.vector.of(-1, 0, 0), 20);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		scene.world.animateBogey(bogeyPos, 1f, 20);
		scene.idle(10);
		scene.world.replaceBlocks(util.select.fromTo(3, 0, 3, 3, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(10);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		for (int i = 0; i < 10; i++) {
			scene.idle(3);
			scene.world.incrementBlockBreakingProgress(util.grid.at(2, 2, 4));
			scene.world.incrementBlockBreakingProgress(util.grid.at(2, 1, 3));
		}

		scene.world.moveSection(trainLink, util.vector.of(-3, 0, 0), 60);
		scene.special.moveParrot(birbLink, util.vector.of(-3, 0, 0), 60);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		scene.world.animateBogey(bogeyPos, 3f, 60);
		scene.idle(10);
		scene.world.replaceBlocks(util.select.fromTo(2, 0, 3, 2, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(20);
		scene.world.replaceBlocks(util.select.fromTo(1, 0, 3, 1, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(20);
		scene.world.replaceBlocks(util.select.fromTo(0, 0, 3, 0, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(10);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		scene.special.hideElement(birbLink, Direction.UP);
		scene.world.hideIndependentSection(trainLink, Direction.UP);
		scene.idle(5);
		scene.world.hideSection(util.select.fromTo(8, 1, 4, 0, 1, 4), Direction.SOUTH);
		scene.world.hideSection(util.select.position(stationPos), Direction.UP);
		scene.idle(10);

		scene.overlay.showSelectionWithText(util.select.fromTo(5, 0, 3, 0, 0, 5), 90)
			.pointAt(util.vector.topOf(util.grid.at(3, 0, 4)))
			.attachKeyFrame()
			.colored(PonderPalette.RED)
			.text("Note that any block destroyed by a roller has a chance not to yield drops")
			.placeNearTarget();
		scene.idle(100);

		scene.world.showSection(gantryPole, Direction.DOWN);
		scene.world.showSection(cogs, Direction.WEST);
		scene.idle(10);
		ElementLink<WorldSectionElement> gantryLink = scene.world.showIndependentSection(gantryCar, Direction.UP);
		scene.world.moveSection(gantryLink, util.vector.of(0, 0, -4), 0);
		scene.idle(10);
		ElementLink<WorldSectionElement> gantryLink2 = scene.world.showIndependentSection(rollers, Direction.EAST);
		scene.idle(5);
		ElementLink<WorldSectionElement> gantryLink3 = scene.world.showIndependentSection(chest, Direction.SOUTH);
		scene.world.moveSection(gantryLink3, util.vector.of(0, 0, -2), 0);
		scene.idle(15);

		paveMaterial = Blocks.GRASS_BLOCK;
		paveItem = new ItemStack(paveMaterial);
		scene.overlay.showControls(new InputWindowElement(filterSlot, Pointing.DOWN).withItem(paveItem), 40);
		scene.idle(7);
		scene.world.setFilterData(rollers, RollerBlockEntity.class, paveItem);
		scene.idle(20);

		scene.overlay.showText(110)
			.independent()
			.attachKeyFrame()
			.text(
				"Rollers are especially useful on Trains, but can also be used on most other types of moving contraptions");
		scene.idle(20);

		scene.world.moveSection(gantryLink, util.vector.of(-5.5, 0, 0), 110);
		scene.world.moveSection(gantryLink2, util.vector.of(-5.5, 0, 0), 110);
		scene.world.moveSection(gantryLink3, util.vector.of(-5.5, 0, 0), 110);
		scene.world.setKineticSpeed(gantryPole, 48);

		for (int i = 0; i < 5; i++)
			scene.world.setKineticSpeed(util.select.position(9, i, 4), i % 2 == 0 ? -48 : 48);
		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));
		for (int i = 0; i < 5; i++) {
			scene.world.replaceBlocks(util.select.fromTo(5 - i, 0, 3, 5 - i, 0, 5), paveMaterial.defaultBlockState(),
				true);
			scene.idle(20);
		}
		scene.world.replaceBlocks(util.select.fromTo(0, 0, 3, 0, 0, 5), paveMaterial.defaultBlockState(), true);
		scene.idle(10);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 2, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));
		scene.world.setKineticSpeed(util.select.everywhere(), 0);

	}

	public static void fill(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("mechanical_roller_fill", "Filling terrain with the Roller");
		scene.configureBasePlate(0, 0, 9);
		scene.scaleSceneView(.625f);
		scene.setSceneOffsetY(-3);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);

		BlockPos stationPos = util.grid.at(7, 5, 1);
		BlockPos controlsPos = util.grid.at(7, 7, 4);
		BlockPos bogeyPos = util.grid.at(7, 6, 4);
		Selection train = util.select.fromTo(8, 6, 4, 7, 7, 5);
		Selection rollers = util.select.fromTo(6, 6, 3, 6, 6, 5);

		scene.special.movePointOfInterest(util.grid.at(0, 7, 4));

		for (int i = 8; i >= 0; i--) {
			scene.world.showSection(util.select.fromTo(i, 4, 3, i, 5, 5), Direction.DOWN);
			scene.idle(1);
		}

		// 1

		scene.idle(5);
		scene.world.showSection(util.select.fromTo(8, 1, 2, 6, 4, 2), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(8, 1, 6, 6, 4, 6), Direction.DOWN);
		scene.idle(5);

		scene.world.showSection(util.select.fromTo(7, 4, 1, 7, 5, 1), Direction.SOUTH);
		scene.idle(5);

		ElementLink<WorldSectionElement> trainLink = scene.world.showIndependentSection(train, Direction.DOWN);
		ElementLink<ParrotElement> birbLink =
			scene.special.createBirb(util.vector.centerOf(8, 7, 4), FacePointOfInterestPose::new);
		scene.idle(5);
		scene.world.showSectionAndMerge(rollers, Direction.EAST, trainLink);
		scene.idle(15);

		Vec3 filterSlot = util.vector.of(6.75 - 1 / 16f, 7, 3.75 - 1 / 16f);
		scene.overlay.showFilterSlotInput(filterSlot, Direction.UP, 60);
		scene.overlay.showText(60)
			.pointAt(filterSlot.add(-.125, 0, 0))
			.attachKeyFrame()
			.text("While disassembled, rollers can be set to other modes")
			.placeNearTarget();
		scene.idle(70);

		scene.overlay.showSelectionWithText(util.select.fromTo(5, 3, 3, 0, 1, 5), 90)
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("The 'fill' modes can help to bridge gaps between pavement and terrain")
			.placeNearTarget();
		scene.idle(100);

		scene.overlay.showControls(new InputWindowElement(filterSlot, Pointing.DOWN).showing(AllIcons.I_ROLLER_FILL),
			50);
		scene.idle(15);
		Block paveMaterial = Blocks.COARSE_DIRT;
		ItemStack paveItem = new ItemStack(paveMaterial);
		scene.overlay
			.showControls(new InputWindowElement(filterSlot.add(0, 0, -6 / 16f), Pointing.UP).withItem(paveItem), 35);
		scene.idle(7);
		scene.world.setFilterData(rollers, RollerBlockEntity.class, paveItem);
		scene.idle(10);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.toggleControls(controlsPos);
		scene.idle(20);

		scene.world.moveSection(trainLink, util.vector.of(-5.5, 0, 0), 110);
		scene.special.moveParrot(birbLink, util.vector.of(-5.5, 0, 0), 110);
		scene.world.animateBogey(bogeyPos, 5.5f, 110);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 6, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 3; i++) {
				scene.world.showSection(util.select.fromTo(5 - j, 3 - i, 3, 5 - j, 3 - i, 5), null);
				scene.idle(2);
			}

			if (j == 2)
				scene.overlay.showText(90)
					.attachKeyFrame()
					.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 3), Direction.NORTH))
					.text("On 'straight fill', they will place simple columns down to the surface")
					.placeNearTarget();

			scene.idle(14);
		}

		for (int i = 0; i < 3; i++) {
			scene.world.showSection(util.select.fromTo(0, 3 - i, 3, 0, 3 - i, 5), null);
			scene.idle(2);
		}

		scene.idle(4);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 6, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		scene.idle(15);
		scene.world.hideSection(util.select.fromTo(5, 1, 3, 0, 3, 5), Direction.SOUTH);
		scene.world.hideIndependentSection(trainLink, Direction.UP);
		scene.special.hideElement(birbLink, Direction.UP);
		scene.idle(15);

		scene.world.toggleControls(controlsPos);
		scene.idle(15);

		// 2

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, true);
		birbLink = scene.special.createBirb(util.vector.centerOf(8, 7, 4), FacePointOfInterestPose::new);
		trainLink = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.idle(5);
		scene.world.showSectionAndMerge(rollers, Direction.EAST, trainLink);
		scene.idle(25);

		scene.overlay
			.showControls(new InputWindowElement(filterSlot, Pointing.DOWN).showing(AllIcons.I_ROLLER_WIDE_FILL), 40);
		scene.idle(45);

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.toggleControls(controlsPos);
		scene.idle(20);

		scene.world.moveSection(trainLink, util.vector.of(-5.5, 0, 0), 110);
		scene.special.moveParrot(birbLink, util.vector.of(-5.5, 0, 0), 110);
		scene.world.animateBogey(bogeyPos, 5.5f, 110);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 6, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 3; i++) {
				scene.world.showSection(util.select.fromTo(5 - j, 3 - i, 1, 5 - j, 3 - i, 7), null);
				scene.idle(2);
			}

			if (j == 2)
				scene.overlay.showText(90)
					.attachKeyFrame()
					.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 3), Direction.NORTH))
					.text("On 'sloped fill', layers placed further down will increase in size")
					.placeNearTarget();

			scene.idle(14);
		}

		for (int i = 0; i < 3; i++) {
			scene.world.showSection(util.select.fromTo(0, 3 - i, 1, 0, 3 - i, 7), null);
			scene.idle(2);
		}

		scene.idle(4);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 6, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

		scene.idle(15);
		scene.world.hideSection(util.select.fromTo(5, 1, 1, 0, 3, 7), Direction.SOUTH);
		scene.world.hideIndependentSection(trainLink, Direction.UP);
		scene.special.hideElement(birbLink, Direction.UP);
		scene.idle(15);

		scene.world.toggleControls(controlsPos);
		scene.world.replaceBlocks(util.select.fromTo(5, 1, 3, 0, 3, 5), Blocks.COBBLESTONE.defaultBlockState(), false);
		scene.idle(15);

		// 3

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, true);
		scene.world.showSection(util.select.fromTo(5, 1, 3, 0, 3, 5), Direction.NORTH);
		birbLink = scene.special.createBirb(util.vector.centerOf(8, 7, 4), FacePointOfInterestPose::new);
		trainLink = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.idle(5);
		scene.world.showSectionAndMerge(rollers, Direction.EAST, trainLink);
		scene.idle(25);

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.toggleControls(controlsPos);
		scene.idle(20);

		scene.world.moveSection(trainLink, util.vector.of(-5.5, 0, 0), 110);
		scene.special.moveParrot(birbLink, util.vector.of(-5.5, 0, 0), 110);
		scene.world.animateBogey(bogeyPos, 5.5f, 110);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 6, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(-100));

		scene.overlay.showText(110)
			.attachKeyFrame()
			.independent()
			.text(
				"As opposed to 'clear & pave', neither of these modes will cause the rollers to break existing blocks")
			.placeNearTarget();

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 3; i++) {
				scene.world.showSection(util.select.fromTo(5 - j, 3 - i, 1, 5 - j, 3 - i, 7), null);
				scene.idle(2);
			}

			scene.idle(14);
		}

		for (int i = 0; i < 3; i++) {
			scene.world.showSection(util.select.fromTo(0, 3 - i, 1, 0, 3 - i, 7), null);
			scene.idle(2);
		}
		
		scene.rotateCameraY(-30);

		scene.idle(4);

		for (int i = 0; i < 3; i++)
			scene.world.modifyBlockEntity(util.grid.at(6, 6, 3 + i), RollerBlockEntity.class,
				rte -> rte.setAnimatedSpeed(0));

	}

}
//文件scenes/SteamScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock;
import com.simibubi.create.content.decoration.steamWhistle.WhistleExtenderBlock;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock.HeatLevel;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SteamScenes {

	public static void whistle(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("steam_whistle", "Setting up Steam Whistles");
		scene.configureBasePlate(0, 0, 5);
		scene.showBasePlate();

		Selection tank = util.select.fromTo(3, 1, 2, 3, 2, 2);
		Selection boiler = util.select.fromTo(2, 2, 2, 2, 3, 2);
		BlockPos leverPos = util.grid.at(1, 3, 2);
		Selection lever = util.select.position(leverPos);
		Selection whistleArea = util.select.fromTo(2, 3, 1, 2, 7, 1);
		BlockPos whistlePos = util.grid.at(2, 3, 1);
		Selection campfire = util.select.position(2, 1, 2);

		scene.idle(15);
		ElementLink<WorldSectionElement> tankElement = scene.world.showIndependentSection(tank, Direction.DOWN);
		scene.world.moveSection(tankElement, util.vector.of(-1, 0, 0), 0);
		scene.idle(10);
		ElementLink<WorldSectionElement> whistleElement =
			scene.world.showIndependentSection(whistleArea, Direction.SOUTH);
		scene.world.moveSection(whistleElement, util.vector.of(0, -1, 0), 0);
		scene.idle(15);
		scene.world.moveSection(tankElement, util.vector.of(0, -1000, 0), 0);
		scene.world.hideIndependentSection(tankElement, null);
		ElementLink<WorldSectionElement> boilerElement = scene.world.showIndependentSectionImmediately(boiler);
		scene.world.moveSection(boilerElement, util.vector.of(0, -1, 0), 0);
		scene.effects.indicateSuccess(util.grid.at(2, 1, 2));
		scene.idle(25);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Steam Whistles can be placed on a Fluid Tank")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH))
			.placeNearTarget();
		scene.idle(60);

		scene.world.moveSection(boilerElement, util.vector.of(0, 1, 0), 15);
		scene.world.moveSection(whistleElement, util.vector.of(0, 1, 0), 15);
		scene.idle(10);
		scene.world.showSection(campfire, Direction.NORTH);
		scene.idle(15);

		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("If the tank receives sufficient heat...")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 2), Direction.WEST))
			.placeNearTarget();
		scene.idle(40);

		scene.world.showSection(lever, Direction.DOWN);
		scene.idle(20);
		scene.world.toggleRedstonePower(whistleArea);
		scene.world.toggleRedstonePower(lever);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(10);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("...the Whistle will play a note when activated")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH))
			.placeNearTarget();

		scene.idle(10);
		scene.world.toggleRedstonePower(whistleArea);
		scene.world.toggleRedstonePower(lever);
		scene.idle(20);
		scene.world.toggleRedstonePower(whistleArea);
		scene.world.toggleRedstonePower(lever);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(20);
		scene.world.toggleRedstonePower(whistleArea);
		scene.world.toggleRedstonePower(lever);
		scene.idle(40);

		InputWindowElement rightClick =
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.EAST), Pointing.RIGHT)
				.withItem(AllBlocks.STEAM_WHISTLE.asStack())
				.rightClick();

		scene.overlay.showControls(rightClick, 50);
		scene.idle(6);
		BlockState extension = AllBlocks.STEAM_WHISTLE_EXTENSION.getDefaultState();
		scene.world.setBlock(whistlePos.above(), extension, false);
		scene.idle(20);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Use a Whistle item on the block to lower its pitch")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH))
			.placeNearTarget();

		scene.idle(40);

		scene.overlay.showControls(rightClick, 2);
		scene.idle(6);
		scene.world.cycleBlockProperty(whistlePos.above(), WhistleExtenderBlock.SHAPE);
		scene.idle(4);
		scene.overlay.showControls(rightClick, 2);
		scene.idle(6);
		scene.world.setBlock(whistlePos.above(2), extension, false);
		scene.world.cycleBlockProperty(whistlePos.above(), WhistleExtenderBlock.SHAPE);
		scene.idle(4);
		scene.overlay.showControls(rightClick, 2);
		scene.idle(6);
		scene.world.cycleBlockProperty(whistlePos.above(2), WhistleExtenderBlock.SHAPE);
		scene.idle(4);
		scene.overlay.showControls(rightClick, 2);
		scene.idle(6);
		scene.world.cycleBlockProperty(whistlePos.above(2), WhistleExtenderBlock.SHAPE);
		scene.world.setBlock(whistlePos.above(3), extension, false);
		scene.idle(20);

		rightClick =
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.EAST), Pointing.RIGHT)
				.withWrench()
				.rightClick();

		scene.overlay.showControls(rightClick, 50);
		scene.idle(6);
		for (int i = 0; i < 4; i++) {
			scene.world.cycleBlockProperty(whistlePos.above(i), WhistleBlock.SIZE);
			scene.idle(1);
		}
		scene.idle(20);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("Cycle between three different octaves using a Wrench")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH))
			.placeNearTarget();

		scene.idle(40);
		scene.overlay.showControls(rightClick, 4);
		scene.idle(6);
		for (int i = 0; i < 4; i++) {
			scene.world.cycleBlockProperty(whistlePos.above(i), WhistleBlock.SIZE);
			scene.idle(1);
		}

		scene.idle(20);
		scene.world.toggleRedstonePower(whistleArea);
		scene.world.toggleRedstonePower(lever);
		scene.effects.indicateRedstone(leverPos);
		scene.idle(20);
		scene.world.toggleRedstonePower(whistleArea);
		scene.world.toggleRedstonePower(lever);
		scene.idle(20);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(2, 3, 1), Direction.DOWN), Pointing.UP)
				.withItem(AllItems.GOGGLES.asStack()),
			80);
		scene.idle(6);

		scene.overlay.showText(70)
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Engineer's Goggles can help to find out the current pitch of a Whistle")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 3, 2), Direction.NORTH))
			.placeNearTarget();
		scene.idle(40);
	}

	public static void engine(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("steam_engine", "Setting up Steam Engines");
		scene.configureBasePlate(0, 0, 7);
		scene.setSceneOffsetY(-1);
		scene.scaleSceneView(.9f);
		scene.showBasePlate();

		Selection fakeGround = util.select.fromTo(4, 0, 0, 2, 0, 0);
		ElementLink<WorldSectionElement> fakeGroundElement =
			scene.world.showIndependentSection(fakeGround, Direction.UP);
		scene.world.moveSection(fakeGroundElement, util.vector.of(1, 0, 1), 0);

		Selection campfires = util.select.fromTo(4, 1, 4, 5, 1, 3);
		Selection burners = util.select.fromTo(3, 1, 3, 2, 1, 4);

		Selection tank = util.select.fromTo(4, 2, 3, 5, 2, 4);
		Selection boiler1 = util.select.fromTo(5, 4, 2, 4, 4, 1);
		Selection boiler2 = util.select.fromTo(5, 7, 6, 4, 4, 5);
		Selection boiler3 = util.select.fromTo(5, 4, 3, 4, 11, 4);

		Selection engine = util.select.position(2, 2, 3);
		Selection engine1 = util.select.fromTo(3, 4, 1, 2, 4, 1);
		BlockPos engine1ShaftPos = util.grid.at(1, 4, 1);
		Selection engine1Shaft = util.select.position(1, 4, 1);

		Selection pumpCogs = util.select.fromTo(6, 1, 7, 6, 1, 2);
		Selection largeCog = util.select.position(5, 0, 7);

		Selection pump1 = util.select.fromTo(5, 2, 2, 4, 1, 1);
		Selection pump2 = util.select.fromTo(5, 2, 7, 4, 1, 6);
		Selection pump3 = util.select.fromTo(2, 3, 7, 1, 1, 6);
		
		scene.world.modifyBlock(util.grid.at(4, 2, 7), s -> s.setValue(PumpBlock.FACING, Direction.SOUTH), false);
		scene.world.modifyBlock(util.grid.at(1, 2, 7), s -> s.setValue(PumpBlock.FACING, Direction.SOUTH), false);
		scene.world.modifyBlock(util.grid.at(2, 3, 7), s -> s.setValue(PumpBlock.FACING, Direction.SOUTH), false);
		
		scene.idle(15);
		ElementLink<WorldSectionElement> tankElement = scene.world.showIndependentSection(tank, Direction.DOWN);
		scene.world.moveSection(tankElement, util.vector.of(0, -1, 0), 0);
		scene.idle(10);
		ElementLink<WorldSectionElement> engineElement = scene.world.showIndependentSection(engine, Direction.EAST);
		scene.world.moveSection(engineElement, util.vector.of(1, -1, 0), 0);
		scene.idle(15);
		scene.world.moveSection(tankElement, util.vector.of(0, -1000, 0), 0);
		scene.world.hideIndependentSection(tankElement, null);
		ElementLink<WorldSectionElement> boilerElement = scene.world.showIndependentSectionImmediately(boiler1);
		scene.world.moveSection(boilerElement, util.vector.of(0, -3, 2), 0);
		scene.effects.indicateSuccess(util.grid.at(5, 1, 3));
		scene.effects.indicateSuccess(util.grid.at(4, 1, 3));
		scene.effects.indicateSuccess(util.grid.at(5, 1, 4));
		scene.effects.indicateSuccess(util.grid.at(4, 1, 4));
		scene.idle(25);

		scene.overlay.showText(50)
			.attachKeyFrame()
			.text("Steam Engines can be placed on a Fluid Tank")
			.pointAt(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.WEST))
			.placeNearTarget();
		scene.idle(60);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(3, 1, 3), Direction.UP), Pointing.DOWN)
				.withItem(AllBlocks.SHAFT.asStack())
				.rightClick(),
			60);
		scene.idle(10);
		scene.world.setBlock(engine1ShaftPos, AllBlocks.SHAFT.getDefaultState()
			.setValue(ShaftBlock.AXIS, Axis.Z), false);
		ElementLink<WorldSectionElement> engineShaftElement = scene.world.showIndependentSection(engine1Shaft, null);
		scene.world.moveSection(engineShaftElement, util.vector.of(0, -3, 2), 0);
		scene.idle(5);
		scene.world.moveSection(engineElement, util.vector.of(0, -1000, 0), 0);
		scene.world.hideIndependentSection(engineElement, null);
		engineElement = scene.world.showIndependentSectionImmediately(engine1);
		scene.world.moveSection(engineElement, util.vector.of(0, -3, 2), 0);
		scene.world.setBlock(engine1ShaftPos, AllBlocks.POWERED_SHAFT.getDefaultState()
			.setValue(ShaftBlock.AXIS, Axis.Z), false);
		scene.effects.indicateSuccess(util.grid.at(1, 1, 3));
		scene.idle(40);

		scene.overlay.showText(80)
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Clicking the engine with a Shaft creates the Kinetic Output")
			.pointAt(util.vector.centerOf(util.grid.at(1, 1, 3)))
			.placeNearTarget();
		scene.idle(90);

		scene.world.multiplyKineticSpeed(largeCog, -1);
		scene.world.multiplyKineticSpeed(pumpCogs, -1);
		scene.world.multiplyKineticSpeed(pump1, -1);
		scene.world.multiplyKineticSpeed(pump2, -1);

		scene.world.moveSection(boilerElement, util.vector.of(0, 1, 0), 15);
		scene.world.moveSection(engineElement, util.vector.of(0, 1, 0), 15);
		scene.world.moveSection(engineShaftElement, util.vector.of(0, 1, 0), 15);
		scene.idle(10);
		scene.world.showSection(campfires, Direction.NORTH);
		scene.idle(10);
		scene.world.hideIndependentSection(fakeGroundElement, Direction.DOWN);
		scene.world.showSection(largeCog, Direction.UP);
		scene.idle(5);
		scene.world.showSection(pump1, Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(pumpCogs, Direction.WEST);
		scene.idle(25);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.text("With sufficient Heat, Water and Boiler space...")
			.pointAt(util.vector.blockSurface(util.grid.at(4, 2, 4), Direction.UP))
			.placeNearTarget();
		scene.idle(30);

		scene.world.setKineticSpeed(engine1Shaft, 16);
		scene.effects.createRedstoneParticles(util.grid.at(3, 2, 3), 0xFFFFFF, 10);
		scene.idle(40);

		scene.overlay.showText(60)
			.text("...they will generate Rotational Force")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 3), Direction.NORTH))
			.placeNearTarget();
		scene.idle(70);

		scene.overlay.showSelectionWithText(util.select.fromTo(5, 2, 3, 4, 2, 4), 50)
			.attachKeyFrame()
			.text("The minimal setup requires 4 Fluid Tanks")
			.pointAt(util.vector.blockSurface(util.grid.at(4, 2, 4), Direction.UP))
			.placeNearTarget();
		scene.idle(60);

		scene.world.hideSection(campfires, Direction.SOUTH);
		scene.idle(15);
		ElementLink<WorldSectionElement> burnersElement = scene.world.showIndependentSection(burners, Direction.SOUTH);
		scene.world.moveSection(burnersElement, util.vector.of(2, 0, 0), 0);
		scene.idle(25);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(util.grid.at(4, 1, 3), Direction.EAST), Pointing.RIGHT)
				.withItem(new ItemStack(Items.OAK_LOG))
				.rightClick(),
			60);
		scene.idle(10);
		scene.world.setBlocks(burners, AllBlocks.BLAZE_BURNER.getDefaultState()
			.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.KINDLED), false);
		scene.idle(5);

		scene.world.setKineticSpeed(engine1Shaft, 64);
		scene.effects.createRedstoneParticles(util.grid.at(3, 2, 3), 0xFFFFFF, 10);
		scene.idle(40);

		scene.overlay.showText(80)
			.text("With the help of Blaze Burners, the power output can be increased")
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(4, 1, 3), Direction.WEST))
			.placeNearTarget();
		scene.idle(90);

		scene.world.hideSection(pump1, Direction.UP);
		scene.idle(5);
		scene.world.hideIndependentSection(boilerElement, Direction.SOUTH);
		scene.idle(10);
		boilerElement = scene.world.showIndependentSection(boiler2, Direction.SOUTH);
		scene.world.moveSection(boilerElement, util.vector.of(0, -2, -2), 0);
		scene.idle(10);
		ElementLink<WorldSectionElement> pumpElement = scene.world.showIndependentSection(pump2, Direction.DOWN);
		scene.world.moveSection(pumpElement, util.vector.of(0, 0, -5), 0);
		scene.idle(20);

		Vec3 target = util.vector.blockSurface(util.grid.at(4, 3, 3), Direction.WEST);
		scene.overlay.showText(80)
			.text("Higher power levels require more Water, Size and Heat")
			.attachKeyFrame()
			.pointAt(target)
			.placeNearTarget();
		scene.idle(90);

		scene.overlay.showControls(
			new InputWindowElement(target.add(0, 0, 0.5), Pointing.DOWN).withItem(AllItems.GOGGLES.asStack()), 60);
		scene.idle(6);
		scene.overlay.showText(80)
			.text("The boiler's current power level can be inspected with Engineer's Goggles")
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.pointAt(target.add(0, 0, 0.5))
			.placeNearTarget();
		scene.idle(90);

		scene.world.showSectionAndMerge(util.select.fromTo(3, 4, 6, 1, 4, 6), Direction.EAST, boilerElement);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.position(1, 4, 6), 64);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 5, 6, 1, 5, 6), Direction.EAST, boilerElement);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.position(1, 5, 6), -64);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 5, 5, 1, 5, 5), Direction.EAST, boilerElement);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.position(1, 5, 5), -64);
		scene.world.showSectionAndMerge(util.select.fromTo(1, 4, 7, 1, 5, 7), Direction.NORTH, boilerElement);
		scene.idle(5);
		scene.world.setKineticSpeed(util.select.position(1, 5, 7), -64);
		scene.world.setKineticSpeed(util.select.position(1, 4, 7), 64);
		scene.idle(20);

		scene.overlay.showText(100)
			.text("With each added power level, an additional Engine can output at full capacity")
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.pointAt(util.vector.blockSurface(util.grid.at(1, 3, 3), Direction.NORTH))
			.placeNearTarget();
		scene.idle(110);

		scene.overlay.showText(30)
			.text("Lvl 4")
			.colored(PonderPalette.BLUE)
			.pointAt(util.vector.blockSurface(util.grid.at(4, 4, 4), Direction.WEST))
			.placeNearTarget();
		scene.idle(40);
		scene.overlay.showSelectionWithText(util.select.fromTo(3, 2, 3, 3, 3, 4), 30)
			.text("4 Engines")
			.colored(PonderPalette.BLUE)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 3, 4), Direction.UP))
			.placeNearTarget();
		scene.idle(30);

		scene.world.hideIndependentSection(pumpElement, Direction.UP);
		scene.idle(5);
		scene.world.hideIndependentSection(boilerElement, Direction.SOUTH);
		scene.world.hideIndependentSection(engineElement, Direction.SOUTH);
		scene.world.hideIndependentSection(engineShaftElement, Direction.SOUTH);
		scene.idle(20);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.of(5, 2, 4), Pointing.DOWN).withItem(AllItems.BLAZE_CAKE.asStack())
				.rightClick(),
			10);
		scene.idle(6);
		scene.world.setBlocks(burners, AllBlocks.BLAZE_BURNER.getDefaultState()
			.setValue(BlazeBurnerBlock.HEAT_LEVEL, HeatLevel.SEETHING), false);
		scene.idle(15);

		boilerElement = scene.world.showIndependentSection(boiler3, Direction.SOUTH);
		scene.world.moveSection(boilerElement, util.vector.of(0, -2, 0), 0);
		scene.idle(10);
		pumpElement = scene.world.showIndependentSection(pump3, Direction.DOWN);
		scene.world.moveSection(pumpElement, util.vector.of(3, 0, -5), 0);
		scene.idle(20);

		ElementLink<WorldSectionElement> cogsElement =
			scene.world.showIndependentSection(util.select.position(1, 1, 7), Direction.NORTH);
		scene.world.moveSection(cogsElement, util.vector.of(0, -2, -2), 0);

		Selection previous = null;
		boolean previousForward = false;
		for (int y = 4; y < 9; y++) {
			if (y != 6)
				for (boolean left : Iterate.trueAndFalse) {
					int z = (left ^ y % 2 == 0) ? 3 : 4;
					if (previous != null)
						scene.world.setKineticSpeed(previous, previousForward ? 64 : -64);
					scene.world.showSectionAndMerge(previous = util.select.fromTo(3, y, z, 1, y, z), Direction.EAST,
						boilerElement);
					previousForward = y % 2 == 0;
					scene.idle(5);
				}

			scene.world.showSectionAndMerge(util.select.position(1, y, 7), Direction.NORTH, cogsElement);
			scene.world.setKineticSpeed(util.select.position(1, y, 7), y % 2 == 0 ? 64 : -64);
		}

		scene.world.setKineticSpeed(previous, 64);

		scene.overlay.showText(30)
			.text("Lvl 8")
			.colored(PonderPalette.BLUE)
			.pointAt(util.vector.blockSurface(util.grid.at(4, 4, 3), Direction.NORTH))
			.placeNearTarget();
		scene.idle(40);
		scene.overlay.showSelectionWithText(util.select.fromTo(3, 2, 3, 3, 6, 4), 30)
			.text("8 Engines")
			.colored(PonderPalette.BLUE)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 3, 4), Direction.UP))
			.placeNearTarget();
		scene.idle(30);

	}

}
//文件scenes/TemplateScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;

import net.minecraft.core.Direction;

public class TemplateScenes {
	
	public static void templateMethod(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("", "");
		scene.configureBasePlate(0, 0, 5);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
	}
	
}
//文件scenes/trains/TrackObserverScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.trains;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.trains.observer.TrackObserverBlockEntity;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrackObserverScenes {

	public static void observe(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("track_observer", "Detecting Trains");
		scene.configureBasePlate(1, 1, 9);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		scene.world.toggleControls(util.grid.at(5, 3, 7));
		scene.special.movePointOfInterest(util.grid.at(-10, 2, 7));

		Selection observer = util.select.position(5, 1, 4);
		Selection redstone = util.select.fromTo(5, 1, 3, 5, 1, 2);

		Selection train1 = util.select.fromTo(7, 2, 6, 3, 3, 8);
		Selection train2 = util.select.fromTo(11, 2, 6, 8, 3, 8);
		Selection train2a = util.select.fromTo(11, 2, 3, 8, 3, 5);
		Selection train2b = util.select.fromTo(11, 2, 0, 8, 3, 2);

		for (int i = 10; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 7), Direction.DOWN);
			scene.idle(1);
		}

		scene.idle(10);

		Vec3 target = util.vector.topOf(5, 0, 7);
		AABB bb = new AABB(target, target).move(0, 2 / 16f, 0);

		scene.overlay.showControls(new InputWindowElement(target, Pointing.DOWN).rightClick()
			.withItem(AllBlocks.TRACK_OBSERVER.asStack()), 40);
		scene.idle(6);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.inflate(.45f, 1 / 16f, .45f), 60);
		scene.idle(10);

		scene.overlay.showText(50)
			.pointAt(target)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("Select a Train Track then place the Observer nearby");
		scene.idle(20);

		scene.world.showSection(observer, Direction.DOWN);
		scene.idle(15);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, new AABB(util.grid.at(5, 1, 4)), 20);
		scene.idle(25);

		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(util.grid.at(5, 1, 4), Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("The Observer will detect any Trains passing over the marker");
		scene.idle(20);
		scene.world.showSection(redstone, Direction.SOUTH);
		scene.idle(30);

		ElementLink<WorldSectionElement> trainInstance1 = scene.world.showIndependentSection(train1, Direction.WEST);
		scene.world.moveSection(trainInstance1, util.vector.of(6, 0, 0), 0);
		scene.world.moveSection(trainInstance1, util.vector.of(-16, 0, 0), 80);
		scene.world.animateBogey(util.grid.at(5, 2, 7), 16, 80);
		ElementLink<ParrotElement> birb =
			scene.special.createBirb(util.vector.centerOf(12, 3, 7), FacePointOfInterestPose::new);
		scene.special.moveParrot(birb, util.vector.of(-16, 0, 0), 80);
		scene.idle(10);

		ElementLink<WorldSectionElement> trainInstance2 = scene.world.showIndependentSection(train2, Direction.WEST);
		scene.world.moveSection(trainInstance2, util.vector.of(4, 0, 0), 0);
		scene.world.moveSection(trainInstance2, util.vector.of(-14, 0, 0), 70);
		scene.world.animateBogey(util.grid.at(9, 2, 7), 14, 70);

		Selection add = redstone.add(observer);

		scene.idle(13);
		scene.world.toggleRedstonePower(add);
		scene.effects.indicateRedstone(util.grid.at(5, 1, 4));
		scene.idle(20);
		scene.world.hideIndependentSection(trainInstance1, Direction.WEST);
		scene.special.hideElement(birb, Direction.WEST);
		scene.idle(10);
		scene.world.toggleRedstonePower(add);
		scene.idle(5);
		scene.world.hideIndependentSection(trainInstance2, Direction.WEST);
		scene.idle(20);

		target = util.vector.topOf(5, 1, 4);
		bb = new AABB(target, target);
		scene.overlay.showCenteredScrollInput(util.grid.at(5, 1, 4), Direction.UP, 60);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(5, 1, 4))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Observers can be filtered to activate for matching cargo");
		scene.idle(40);

		ItemStack waterBucket = new ItemStack(Items.WATER_BUCKET);
		scene.overlay.showControls(new InputWindowElement(target, Pointing.DOWN).withItem(waterBucket), 30);
		scene.idle(6);
		scene.world.setFilterData(observer, TrackObserverBlockEntity.class, waterBucket);
		scene.idle(50);

		trainInstance1 = scene.world.showIndependentSection(train1, Direction.WEST);
		scene.world.moveSection(trainInstance1, util.vector.of(6, 0, 0), 0);
		scene.world.moveSection(trainInstance1, util.vector.of(-16, 0, 0), 80);
		scene.world.animateBogey(util.grid.at(5, 2, 7), 16, 80);
		birb = scene.special.createBirb(util.vector.centerOf(12, 3, 7), FacePointOfInterestPose::new);
		scene.special.moveParrot(birb, util.vector.of(-16, 0, 0), 80);
		scene.idle(10);

		trainInstance2 = scene.world.showIndependentSection(train2b, Direction.WEST);
		scene.world.moveSection(trainInstance2, util.vector.of(4, 0, 6), 0);
		scene.world.moveSection(trainInstance2, util.vector.of(-14, 0, 0), 70);
		scene.world.animateBogey(util.grid.at(9, 2, 1), 14, 80);

		scene.idle(33);
		scene.world.hideIndependentSection(trainInstance1, Direction.WEST);
		scene.special.hideElement(birb, Direction.WEST);
		scene.idle(10);
		scene.world.hideIndependentSection(trainInstance2, Direction.WEST);
		scene.idle(20);

		trainInstance1 = scene.world.showIndependentSection(train1, Direction.WEST);
		scene.world.moveSection(trainInstance1, util.vector.of(6, 0, 0), 0);
		scene.world.moveSection(trainInstance1, util.vector.of(-16, 0, 0), 80);
		scene.world.animateBogey(util.grid.at(5, 2, 7), 16, 80);
		birb = scene.special.createBirb(util.vector.centerOf(12, 3, 7), FacePointOfInterestPose::new);
		scene.special.moveParrot(birb, util.vector.of(-16, 0, 0), 80);
		scene.idle(10);

		trainInstance2 = scene.world.showIndependentSection(train2a, Direction.WEST);
		scene.world.moveSection(trainInstance2, util.vector.of(4, 0, 3), 0);
		scene.world.moveSection(trainInstance2, util.vector.of(-14, 0, 0), 70);
		scene.world.animateBogey(util.grid.at(9, 2, 4), 14, 70);

		scene.idle(13);
		scene.world.toggleRedstonePower(add);
		scene.effects.indicateRedstone(util.grid.at(5, 1, 4));
		scene.idle(20);
		scene.world.hideIndependentSection(trainInstance1, Direction.WEST);
		scene.special.hideElement(birb, Direction.WEST);
		scene.idle(10);
		scene.world.toggleRedstonePower(add);
		scene.idle(5);
		scene.world.hideIndependentSection(trainInstance2, Direction.WEST);

	}

}
//文件scenes/trains/TrackScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.trains;

import java.util.List;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrackScenes {

	public static void placement(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("track_placement", "Placing Train Tracks");
		scene.configureBasePlate(0, 0, 15);
		scene.scaleSceneView(.5f);
		scene.showBasePlate();
		scene.idle(10);

		ElementLink<WorldSectionElement> bgTrack =
			scene.world.showIndependentSection(util.select.position(11, 4, 9), Direction.DOWN);
		scene.world.moveSection(bgTrack, util.vector.of(0, -2, 0), 0);

		for (int i = 11; i >= 2; i--) {
			scene.world.showSectionAndMerge(util.select.position(i, 3, 9), Direction.DOWN, bgTrack);
			if (i == 5)
				scene.world.showSectionAndMerge(util.select.position(7, 4, 9), Direction.DOWN, bgTrack);
			scene.idle(2);
		}

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(5, 0, 9))
			.placeNearTarget()
			.text("A new type of rail designed for Train Contraptions");
		scene.idle(50);

		ElementLink<WorldSectionElement> fgTrack =
			scene.world.showIndependentSection(util.select.position(3, 3, 5), Direction.DOWN);
		scene.world.moveSection(fgTrack, util.vector.of(0, -2, 0), 0);
		scene.idle(20);

		Vec3 startTrack = util.vector.topOf(3, 0, 5);
		scene.overlay.showText(70)
			.pointAt(startTrack)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.text("To place rows of track in bulk, click on an existing track");
		scene.idle(30);

		ItemStack trackStack = AllBlocks.TRACK.asStack();
		scene.overlay.showControls(new InputWindowElement(startTrack, Pointing.DOWN).rightClick()
			.withItem(trackStack), 40);
		scene.idle(6);
		AABB bb = new AABB(util.grid.at(3, 1, 5)).contract(0, .75f, 0)
			.inflate(0, 0, .85f);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, startTrack, bb, 32);
		scene.idle(45);

		scene.overlay.showControls(new InputWindowElement(startTrack.add(9, 0, 0), Pointing.DOWN).rightClick()
			.withItem(trackStack), 40);
		scene.idle(6);
		scene.overlay.showText(40)
			.pointAt(util.vector.topOf(12, 0, 5))
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("Then place or select a second track");
		scene.idle(20);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, startTrack, bb.expandTowards(9, 0, 0), 30);

		scene.world.showSectionAndMerge(util.select.fromTo(12, 3, 5, 4, 3, 5), Direction.WEST, fgTrack);
		scene.idle(55);

		scene.world.hideIndependentSection(bgTrack, Direction.UP);
		scene.idle(7);
		scene.world.hideIndependentSection(fgTrack, Direction.UP);
		scene.idle(25);

		scene.world.showSection(util.select.position(8, 1, 2), Direction.SOUTH);
		scene.idle(10);
		scene.addKeyframe();

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(8, 0, 2), Pointing.DOWN).rightClick()
			.withItem(trackStack), 15);
		scene.idle(15);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(2, 0, 8), Pointing.DOWN).rightClick()
			.withItem(trackStack), 15);
		scene.idle(7);
		scene.world.showSection(util.select.position(2, 1, 8), Direction.DOWN);
		scene.idle(25);

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(7, 0, 7))
			.placeNearTarget()
			.text("Tracks can also be placed as turns or slopes");
		scene.idle(40);

		scene.world.showSection(util.select.position(12, 1, 2), Direction.SOUTH);
		scene.idle(10);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(12, 0, 2), Pointing.DOWN).rightClick()
			.withItem(trackStack), 10);
		scene.idle(15);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(2, 0, 12), Pointing.DOWN).rightClick()
			.withItem(trackStack), 10);
		scene.idle(7);
		scene.world.showSection(util.select.fromTo(12, 1, 3, 12, 1, 5), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(12, 1, 6, 6, 1, 12), Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(util.select.fromTo(5, 1, 12, 2, 1, 12), Direction.DOWN);
		scene.idle(25);

		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(11, 0, 11))
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.placeNearTarget()
			.text("When connecting, tracks will try to make each turn equally sized");
		scene.idle(70);

		scene.world.hideSection(util.select.fromTo(12, 1, 2, 12, 1, 5), Direction.NORTH);
		scene.world.hideSection(util.select.fromTo(5, 1, 12, 2, 1, 12), Direction.WEST);

		bb = new AABB(util.grid.at(5, 1, 5)).contract(0, .75f, 0)
			.inflate(3, 0, 3)
			.expandTowards(.85f, 0, .85f);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, startTrack, bb, 32);
		scene.idle(20);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, startTrack, bb.move(4, 0, 4), 32);
		scene.idle(30);

		scene.world.hideSection(util.select.fromTo(12, 1, 6, 6, 1, 12), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.position(12, 1, 2), Direction.SOUTH);
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(12, 0, 2), Pointing.DOWN).rightClick()
			.withItem(trackStack), 10);
		scene.idle(10);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(2, 0, 12), Pointing.DOWN).rightClick()
			.withItem(trackStack)
			.whileCTRL(), 60);
		scene.idle(10);

		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(2, 0, 12))
			.colored(PonderPalette.GREEN)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Holding the sprint key while connecting...");
		scene.idle(50);

		ElementLink<WorldSectionElement> longBend =
			scene.world.showIndependentSection(util.select.position(2, 2, 12), Direction.DOWN);
		scene.world.moveSection(longBend, util.vector.of(0, -1, 0), 0);
		scene.idle(30);

		scene.overlay.showText(60)
			.pointAt(util.vector.centerOf(9, 1, 9))
			.colored(PonderPalette.GREEN)
			.placeNearTarget()
			.text("...will create the longest fitting bend instead");
		scene.idle(70);

		scene.world.hideIndependentSection(longBend, Direction.UP);
		scene.world.hideSection(util.select.position(12, 1, 2), Direction.UP);
		scene.idle(5);
		scene.world.hideSection(util.select.fromTo(8, 1, 2, 2, 1, 8), Direction.UP);
		scene.idle(25);

		ElementLink<WorldSectionElement> slopeStart =
			scene.world.showIndependentSection(util.select.fromTo(12, 6, 2, 12, 9, 12), Direction.DOWN);
		scene.world.moveSection(slopeStart, util.vector.of(0, -5, 0), 0);
		scene.idle(10);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 6, 2, 2, 7, 4), Direction.DOWN, slopeStart);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 6, 6, 2, 9, 8), Direction.DOWN, slopeStart);
		scene.world.showSectionAndMerge(util.select.fromTo(2, 6, 10, 2, 11, 12), Direction.DOWN, slopeStart);
		scene.idle(20);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(12, 3, 11), Pointing.LEFT).withItem(trackStack), 30);
		scene.idle(4);
		ItemStack smoothStone = new ItemStack(Blocks.SMOOTH_STONE);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(12, 3, 11), Pointing.RIGHT).withItem(smoothStone), 26);
		scene.idle(30);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(2, 6, 11), Pointing.LEFT).withItem(trackStack), 30);
		scene.idle(4);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(2, 6, 11), Pointing.RIGHT).withItem(smoothStone), 26);
		scene.idle(10);

		scene.world.showSectionAndMerge(util.select.position(2, 12, 11), Direction.DOWN, slopeStart);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.fromTo(11, 8, 10, 3, 11, 12), Direction.UP, slopeStart);
		scene.idle(20);

		scene.overlay.showText(100)
			.pointAt(util.vector.blockSurface(util.grid.at(9, 3, 10), Direction.NORTH))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Materials in the off-hand will be paved under tracks automatically");
		scene.idle(80);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(12, 2, 7), Pointing.LEFT).withItem(trackStack), 30);
		scene.idle(4);
		smoothStone = new ItemStack(Blocks.SMOOTH_STONE_SLAB);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(12, 2, 7), Pointing.RIGHT).withItem(smoothStone), 26);
		scene.idle(30);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(2, 4, 7), Pointing.LEFT).withItem(trackStack), 30);
		scene.idle(4);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(2, 4, 7), Pointing.RIGHT).withItem(smoothStone), 26);
		scene.idle(10);

		scene.world.showSectionAndMerge(util.select.position(2, 10, 7), Direction.DOWN, slopeStart);
		scene.idle(2);
		scene.world.showSectionAndMerge(util.select.fromTo(11, 7, 6, 3, 11, 8), Direction.UP, slopeStart);
		scene.idle(20);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(12, 1, 3), Pointing.LEFT).withItem(trackStack), 30);
		scene.idle(4);
		smoothStone = AllBlocks.METAL_GIRDER.asStack();
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(12, 1, 3), Pointing.RIGHT).withItem(smoothStone), 26);
		scene.idle(30);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(2, 2, 3), Pointing.LEFT).withItem(trackStack), 30);
		scene.idle(4);
		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(2, 2, 3), Pointing.RIGHT).withItem(smoothStone), 26);
		scene.idle(10);

		scene.world.showSectionAndMerge(util.select.position(2, 8, 3), Direction.DOWN, slopeStart);
	}

	public static void portal(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("track_portal", "Tracks and the Nether");
		scene.configureBasePlate(0, 0, 9);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();
		scene.world.showSection(util.select.fromTo(2, 1, 7, 6, 6, 7), Direction.UP);
		scene.idle(10);

		for (int i = 1; i <= 5; i++) {
			scene.world.showSection(util.select.position(4, 1, i), Direction.DOWN);
			scene.idle(2);
		}
		
		scene.world.toggleControls(util.grid.at(4, 3, 3));

		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(4, 0, 6))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Tracks placed up against a nether portal...");
		scene.idle(50);

		scene.world.showSection(util.select.position(4, 1, 6), Direction.DOWN);

		scene.idle(20);
		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(4, 0, 6))
			.placeNearTarget()
			.text("...will attempt to create a paired track on the other side");
		scene.idle(40);

		ElementLink<WorldSectionElement> t1 =
			scene.world.showIndependentSection(util.select.fromTo(5, 2, 1, 3, 3, 2), Direction.DOWN);
		ElementLink<WorldSectionElement> t2 =
			scene.world.showIndependentSection(util.select.fromTo(5, 2, 3, 3, 3, 3), Direction.DOWN);
		ElementLink<WorldSectionElement> t3 =
			scene.world.showIndependentSection(util.select.fromTo(5, 2, 4, 3, 3, 5), Direction.DOWN);

		ElementLink<ParrotElement> birb =
			scene.special.createBirb(util.vector.centerOf(4, 3, 2), FacePointOfInterestPose::new);
		scene.special.conductorBirb(birb, true);
		scene.special.movePointOfInterest(util.grid.at(4, 4, 10));

		scene.addKeyframe();
		scene.idle(30);

		for (ElementLink<WorldSectionElement> e : List.of(t1, t2, t3))
			scene.world.moveSection(e, util.vector.of(0, 0, 6), 30);
		scene.special.moveParrot(birb, util.vector.of(0, 0, 5.6), 28);
		scene.world.animateBogey(util.grid.at(4, 2, 3), -6, 30);

		for (ElementLink<WorldSectionElement> e : List.of(t3, t2, t1)) {
			scene.idle(2);
			scene.world.hideIndependentSection(e, Direction.SOUTH);
		}

		scene.world.hideSection(util.select.layers(0, 1), Direction.UP);
		scene.rotateCameraY(360);
		scene.idle(15);
		scene.special.movePointOfInterest(util.grid.at(4, 4, 0));
		ElementLink<WorldSectionElement> nether =
			scene.world.showIndependentSection(util.select.layers(7, 1), Direction.UP);
		scene.world.moveSection(nether, util.vector.of(0, -7, 0), 0);
		scene.special.moveParrot(birb, util.vector.of(0, 0, -.1f), 1);
		scene.idle(25);

		ElementLink<WorldSectionElement> s1 =
			scene.world.showIndependentSection(util.select.fromTo(5, 2, 1, 3, 3, 5), null);
		scene.world.rotateSection(s1, 0, 180, 0, 0);
		scene.world.moveSection(s1, util.vector.of(0, 0, 3.5f), 0);
		scene.world.moveSection(s1, util.vector.of(0, 0, -3.5f), 18);
		scene.special.moveParrot(birb, util.vector.of(0, 0, -3.5f), 18);
		scene.world.animateBogey(util.grid.at(4, 2, 3), -3.5f, 18);
		scene.idle(30);

		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(util.grid.at(3, 2, 3)))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Trains on this track are now able to travel across dimensions");
		scene.idle(40);

	}

	public static void chunks(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("track_chunks", "Traversing unloaded Chunks");
		scene.configureBasePlate(0, 0, 9);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);
		
		scene.world.cycleBlockProperty(util.grid.at(5, 3, 4), BlazeBurnerBlock.HEAT_LEVEL);
		
		ElementLink<WorldSectionElement> stationElement =
			scene.world.showIndependentSection(util.select.fromTo(0, 0, 0, 8, 0, 8), Direction.UP);
		ElementLink<WorldSectionElement> stationTrackElement =
			scene.world.showIndependentSection(util.select.position(0, 2, 0), Direction.UP);
		scene.world.showSection(util.select.position(0, 3, 0), Direction.DOWN);
		scene.idle(10);

		Selection vPlatform = util.select.fromTo(7, 1, 6, 1, 2, 8);
		Selection vStation = util.select.position(7, 1, 1);
		Selection dPlatform = util.select.fromTo(7, 3, 6, 1, 4, 8);
		Selection dStation = util.select.position(1, 1, 1);
		Selection train = util.select.fromTo(6, 2, 3, 2, 3, 5);
		Selection track = util.select.fromTo(7, 1, 4, 37, 1, 4);

		scene.world.animateTrainStation(util.grid.at(7, 1, 1), true);
		scene.world.toggleControls(util.grid.at(4, 3, 4));

		for (int i = 6; i >= 2; i--) {
			scene.world.showSectionAndMerge(util.select.position(i, 1, 4), Direction.DOWN, stationTrackElement);
			scene.idle(2);
		}

		scene.world.showSectionAndMerge(vPlatform, Direction.NORTH, stationElement);
		scene.idle(5);
		scene.world.showSectionAndMerge(vStation, Direction.DOWN, stationElement);
		ElementLink<ParrotElement> birb =
			scene.special.createBirb(util.vector.centerOf(2, 2, 7), FacePointOfInterestPose::new);
		scene.special.movePointOfInterest(util.grid.at(4, 3, 4));
		scene.idle(5);
		ElementLink<WorldSectionElement> trainElement = scene.world.showIndependentSection(train, Direction.DOWN);

		scene.idle(10);
		ElementLink<WorldSectionElement> trackElement = scene.world.showIndependentSection(track, Direction.EAST);
		scene.world.moveSection(trackElement, util.vector.of(-36, 0, 0), 0);

		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(1, 0, 4))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Tracks stay functional outside of loaded chunks");
		scene.idle(60);

		scene.idle(30);
		scene.world.animateTrainStation(util.grid.at(7, 1, 1), false);
		scene.world.moveSection(trackElement, util.vector.of(12, 0, 0), 120);
		scene.world.moveSection(stationElement, util.vector.of(12, 0, 0), 120);
		scene.world.moveSection(stationTrackElement, util.vector.of(12, 0, 0), 120);
		scene.world.animateBogey(util.grid.at(4, 2, 4), 12f, 120);
		scene.special.moveParrot(birb, util.vector.of(12, 0, 0), 120);
		scene.idle(15);
		scene.world.hideIndependentSection(stationElement, null);
		scene.special.hideElement(birb, null);
		scene.idle(10);
		scene.world.hideIndependentSection(trainElement, null);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.BLUE, trainElement,
			new AABB(util.grid.at(4, 2, 4)).inflate(1, .75f, .5f), 280);

		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 4), Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.text("Trains will travel through inactive sections of the world without issue");
		scene.idle(70);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 4), Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.text("They will still stop at stations or red signals");
		scene.idle(50);

		scene.world.moveSection(trackElement, util.vector.of(19, 0, 0), 190);
		scene.world.moveSection(stationTrackElement, util.vector.of(19, 0, 0), 190);
		scene.world.animateBogey(util.grid.at(4, 2, 4), 19f, 190);

		scene.idle(30);
		scene.overlay.showText(90)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 4), Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.attachKeyFrame()
			.text("However, Drills and other on-board machines will not operate");
		scene.idle(80);

		stationElement = scene.world.showIndependentSection(util.select.fromTo(0, 0, 0, 8, 0, 8)
			.add(dStation), null);
		ElementLink<WorldSectionElement> dPlatformElement =
			scene.world.showIndependentSection(dPlatform, null);
		birb = scene.special.createBirb(util.vector.centerOf(-2, 2, 7), FacePointOfInterestPose::new);
		scene.world.moveSection(dPlatformElement, util.vector.of(-8, -2, 0), 0);
		scene.world.moveSection(stationElement, util.vector.of(-8, 0, 0), 0);
		scene.world.moveSection(stationElement, util.vector.of(8, 0, 0), 80);
		scene.world.moveSection(dPlatformElement, util.vector.of(8, 0, 0), 80);
		scene.special.moveParrot(birb, util.vector.of(8, 0, 0), 80);

		scene.idle(30);
		trainElement = scene.world.showIndependentSection(train, null);
		scene.idle(20);

		scene.overlay.showText(90)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 4), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Once near a Player, the train will re-appear");
		scene.idle(30);
		scene.world.animateTrainStation(util.grid.at(1, 1, 1), true);
		scene.idle(30);
	}

}
//文件scenes/trains/TrainScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.trains;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.trains.station.StationBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrainScenes {

	public static void controls(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("train_controls", "Controlling Trains");
		scene.configureBasePlate(1, 0, 9);
		scene.scaleSceneView(.75f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		for (int i = 10; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 4), Direction.DOWN);
			scene.idle(1);
		}

		BlockPos stationPos = util.grid.at(4, 1, 1);
		Selection station = util.select.position(stationPos);
		Selection whistle = util.select.fromTo(4, 3, 4, 4, 4, 4);
		Selection train = util.select.fromTo(5, 2, 3, 1, 3, 5)
			.substract(whistle);

		scene.world.showSection(station, Direction.DOWN);
		scene.idle(20);

		ElementLink<WorldSectionElement> trainElement = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.idle(15);

		BlockPos initialControlsPos = util.grid.at(3, 3, 4);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, train,
			new AABB(initialControlsPos).contract(-6 / 16f, 2 / 16f, 0), 85);
		scene.idle(15);

		scene.overlay.showText(70)
			.pointAt(util.vector.of(3.35f, 3.75f, 5))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Train Controls are required on every train contraption");
		scene.idle(60);

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.effects.indicateSuccess(stationPos);
		scene.world.animateTrainStation(stationPos, true);
		scene.world.toggleControls(initialControlsPos);
		scene.idle(20);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(initialControlsPos), Pointing.DOWN).rightClick(), 70);
		scene.idle(20);

		scene.overlay.showText(60)
			.pointAt(util.vector.of(3.35f, 3.75f, 5))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Once assembled, right-click the block to start driving");
		scene.idle(60);

		scene.world.moveSection(trainElement, util.vector.of(4, 0, 0), 20);
		scene.world.animateBogey(util.grid.at(3, 2, 4), -4f, 20);
		scene.world.animateTrainStation(stationPos, false);
		scene.idle(30);

		scene.overlay.showText(60)
			.pointAt(util.vector.of(7.35f, 3.75f, 5))
			.placeNearTarget()
			.text("Accelerate and steer the Train using movement keybinds");
		scene.idle(60);

		scene.world.moveSection(trainElement, util.vector.of(-4, 0, 0), 30);
		scene.world.animateBogey(util.grid.at(3, 2, 4), 4f, 30);
		scene.idle(40);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(initialControlsPos), Pointing.DOWN).scroll(), 70);
		scene.idle(20);

		scene.overlay.showText(90)
			.pointAt(util.vector.of(3.35f, 3.75f, 5))
			.placeNearTarget()
			.text("If desired, the top speed can be fine-tuned using the mouse wheel");
		scene.idle(90);

		scene.world.moveSection(trainElement, util.vector.of(2, 0, 0), 30);
		scene.world.animateBogey(util.grid.at(3, 2, 4), -2f, 30);
		scene.idle(40);

		scene.world.moveSection(trainElement, util.vector.of(-3, 0, 0), 60);
		scene.world.animateBogey(util.grid.at(3, 2, 4), 3f, 60);
		scene.idle(70);

		scene.overlay.showText(50)
			.pointAt(util.vector.of(2.35f, 3.75f, 5))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Hold space to approach a nearby Station");
		scene.idle(40);

		scene.world.moveSection(trainElement, util.vector.of(1, 0, 0), 20);
		scene.world.animateBogey(util.grid.at(3, 2, 4), -1f, 20);
		scene.idle(20);
		scene.effects.indicateSuccess(stationPos);
		scene.world.animateTrainStation(stationPos, true);
		scene.idle(10);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(stationPos))
			.placeNearTarget()
			.text("Trains can only be disassembled back into blocks at Stations");
		scene.idle(40);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.world.toggleControls(initialControlsPos);
		scene.idle(20);
		scene.world.showSectionAndMerge(whistle, Direction.DOWN, trainElement);
		scene.idle(20);
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.effects.indicateSuccess(stationPos);
		scene.world.toggleControls(initialControlsPos);
		scene.idle(20);

		scene.overlay.showText(70)
			.pointAt(util.vector.of(4.95f, 3.75f, 5))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Assembled Whistles can be activated with the sprint key");

		scene.idle(40);
		scene.world.toggleRedstonePower(whistle);
		scene.idle(20);
		scene.world.toggleRedstonePower(whistle);
		scene.idle(20);

		scene.overlay.showText(70)
			.pointAt(util.vector.of(3.35f, 3.75f, 5))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Sneak or click again to stop controlling the Train");
		scene.idle(60);
	}

	public static void schedule(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("train_schedule", "Using Train Schedules");
		scene.configureBasePlate(1, 0, 9);
		scene.scaleSceneView(.75f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		scene.world.cycleBlockProperty(util.grid.at(3, 3, 4), BlazeBurnerBlock.HEAT_LEVEL);
		
		for (int i = 10; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 4), Direction.DOWN);
			scene.idle(1);
		}

		scene.world.toggleControls(util.grid.at(4, 3, 4));
		scene.world.toggleControls(util.grid.at(4, 3, 7));

		BlockPos stationPos = util.grid.at(5, 1, 1);
		Selection train1 = util.select.fromTo(6, 2, 3, 2, 3, 5);
		Selection train2 = util.select.fromTo(6, 2, 6, 2, 3, 8);

		scene.idle(10);

		scene.world.showSection(util.select.position(stationPos), Direction.DOWN);
		scene.idle(5);
		ElementLink<WorldSectionElement> trainElement1 = scene.world.showIndependentSection(train1, Direction.DOWN);
		scene.idle(10);
		scene.world.animateTrainStation(stationPos, true);
		scene.idle(10);

		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 3, 4), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Schedules allow Trains to be controlled by other Drivers");
		scene.idle(80);

		Vec3 target = util.vector.topOf(util.grid.at(4, 0, 2));
		scene.overlay.showControls(new InputWindowElement(target, Pointing.RIGHT).rightClick()
			.withItem(AllItems.SCHEDULE.asStack()), 80);
		scene.overlay.showText(80)
			.pointAt(target)
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Right-click with the item in hand to open its Interface");
		scene.idle(100);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(3, 3, 4)), Pointing.DOWN).rightClick()
				.withItem(AllItems.SCHEDULE.asStack()), 80);
		scene.idle(6);
		scene.world.conductorBlaze(util.grid.at(3, 3, 4), true);
		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 3, 4), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Once programmed, the Schedule can be handed off to a Train Driver");
		scene.idle(80);

		scene.world.moveSection(trainElement1, util.vector.of(12, 0, 0), 60);
		scene.world.animateBogey(util.grid.at(4, 2, 4), -12f, 60);
		scene.world.animateTrainStation(stationPos, false);
		scene.idle(20);
		scene.world.hideIndependentSection(trainElement1, null);
		scene.idle(25);

		ElementLink<WorldSectionElement> trainElement2 = scene.world.showIndependentSection(train2, Direction.DOWN);
		scene.world.moveSection(trainElement2, util.vector.of(0, 0, -3), 0);
		scene.idle(10);
		Vec3 birbVec = util.vector.topOf(util.grid.at(3, 0, 7));
		ElementLink<ParrotElement> birb = scene.special.createBirb(birbVec, FacePointOfInterestPose::new);
		scene.world.animateTrainStation(stationPos, true);

		scene.overlay.showText(110)
			.pointAt(birbVec)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Any mob or blaze burner sitting in front of Train Controls is an eligible conductor");
		scene.idle(80);

		scene.overlay.showControls(new InputWindowElement(util.vector.centerOf(util.grid.at(3, 1, 7)), Pointing.DOWN)
			.withItem(new ItemStack(Items.LEAD)), 30);
		scene.idle(40);
		target = util.vector.centerOf(util.grid.at(3, 3, 4));
		scene.overlay.showControls(new InputWindowElement(target.add(0.5, 0, 0), Pointing.RIGHT).rightClick()
			.withItem(new ItemStack(Items.LEAD)), 30);
		scene.idle(6);
		scene.special.moveParrot(birb, target.subtract(birbVec), 5);
		scene.effects.indicateSuccess(util.grid.at(3, 3, 4));
		scene.idle(15);

		scene.overlay.showText(70)
			.pointAt(target)
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.text("Creatures on a lead can be given their seat more conveniently");
		scene.idle(80);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(3, 3, 4)), Pointing.DOWN)
			.withItem(AllItems.SCHEDULE.asStack()), 15);
		scene.idle(6);
		scene.special.conductorBirb(birb, true);
		scene.special.movePointOfInterest(util.grid.at(16, 4, 4));
		scene.idle(14);

		scene.world.moveSection(trainElement2, util.vector.of(3, 0, 0), 30);
		scene.world.animateBogey(util.grid.at(4, 2, 7), -3f, 30);
		scene.special.moveParrot(birb, util.vector.of(3, 0, 0), 30);
		scene.idle(40);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(util.grid.at(6, 3, 4)), Pointing.DOWN).rightClick(), 70);
		scene.idle(6);
		scene.special.conductorBirb(birb, false);
		scene.special.movePointOfInterest(util.grid.at(3, 4, 1));
		scene.idle(19);
		scene.overlay.showText(70)
			.pointAt(target.add(3, 0, 0))
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.attachKeyFrame()
			.text("Schedules can be retrieved from Drivers at any moment");
		scene.idle(80);

	}

}
//文件scenes/trains/TrainSignalScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.trains;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.trains.signal.SignalBlock;
import com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.DancePose;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrainSignalScenes {

	public static void placement(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("train_signal_placement", "Placing Train Signals");
		scene.configureBasePlate(1, 0, 12);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		for (int i = 13; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 6), Direction.DOWN);
			scene.idle(1);
		}

		scene.idle(10);

		BlockPos stationPos = util.grid.at(11, 1, 3);
		Selection station = util.select.position(stationPos);
		BlockPos signalPos = util.grid.at(8, 1, 3);
		Selection firstSignal = util.select.position(signalPos);
		Selection fakeSignal = util.select.position(7, 1, 3);
		Selection secondSignal = util.select.position(8, 1, 9);
		Selection thirdSignal = util.select.fromTo(9, 1, 9, 9, 4, 9);
		Selection firstNixie = util.select.position(8, 2, 3);
		Selection secondNixie = util.select.position(8, 2, 9);
		Selection thirdNixie = util.select.position(9, 4, 8);
		Selection train = util.select.fromTo(5, 2, 5, 1, 3, 7);
		
		scene.world.toggleControls(util.grid.at(3, 3, 6));

		Vec3 marker = util.vector.topOf(8, 0, 6)
			.add(0, 3 / 16f, 0);

		AABB bb = new AABB(marker, marker);
		AABB bb3 = bb.move(3, 0, 0);

		scene.overlay.showControls(new InputWindowElement(marker, Pointing.DOWN).rightClick()
			.withItem(AllBlocks.TRACK_SIGNAL.asStack()), 40);
		scene.idle(6);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.move(0, -1 / 16f, 0), 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.move(0, -1 / 16f, 0)
			.inflate(.45f, 1 / 16f, .45f), 100);
		scene.idle(10);

		scene.overlay.showText(70)
			.pointAt(marker)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("Select a Train Track then place the Signal nearby");
		scene.idle(60);

		ElementLink<WorldSectionElement> signalElement = scene.world.showIndependentSection(fakeSignal, Direction.DOWN);
		scene.world.moveSection(signalElement, util.vector.of(1, 0, 0), 0);
		scene.idle(15);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, new AABB(signalPos), 20);
		scene.idle(25);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(signalPos, Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Signals control the flow of Trains not driven by players");
		scene.idle(70);

		ElementLink<WorldSectionElement> trainElement = scene.world.showIndependentSection(train, Direction.DOWN);
		Vec3 birbVec = util.vector.centerOf(util.grid.at(2, 3, 6));
		ElementLink<ParrotElement> birb = scene.special.createBirb(birbVec, FacePointOfInterestPose::new);

		scene.idle(10);
		scene.world.showSection(station, Direction.DOWN);

		scene.idle(10);

		scene.overlay.showText(80)
			.pointAt(marker.add(-.45, 0, 0))
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("Scheduled Trains will never cross signals in the opposite direction");
		scene.idle(90);

		scene.overlay.showControls(
			new InputWindowElement(birbVec.add(0, 0.5, 0), Pointing.DOWN).withItem(AllItems.SCHEDULE.asStack()), 40);
		scene.idle(6);
		scene.special.movePointOfInterest(util.grid.at(19, 4, 6));

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb3, bb3, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb3, bb3.inflate(.45f, 0, .45f), 40);
		scene.idle(15);

		AABB bb2 = new AABB(marker, marker).move(-.45, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.move(-4, 0, 0), 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.expandTowards(-4, 0, 0), 20);
		scene.idle(15);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb.inflate(.45f, 0, .45f), 40);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb3, bb3.inflate(.45f, 0, .45f), 45);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb2, bb2.expandTowards(-4, 0, 0), 45);
		scene.idle(20);
		scene.special.movePointOfInterest(util.grid.at(5, 1, 4));
		scene.idle(20);

		scene.overlay.showControls(new InputWindowElement(marker, Pointing.DOWN).rightClick()
			.withItem(AllBlocks.TRACK_SIGNAL.asStack()), 40);
		scene.idle(6);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.move(0, -1 / 16f, 0), 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.move(0, -1 / 16f, 0)
			.inflate(.45f, 1 / 16f, .45f), 70);
		scene.idle(30);
		scene.world.showSection(secondSignal, Direction.DOWN);
		scene.idle(10);
		scene.world.moveSection(signalElement, util.vector.of(0, -1000, 0), 0);
		scene.world.showIndependentSectionImmediately(firstSignal);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, new AABB(util.grid.at(8, 1, 9)), 40);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(8, 1, 9), Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("...unless a second signal is added facing the opposite way.");
		scene.idle(90);
		scene.world.hideIndependentSection(signalElement, null);

		scene.overlay.showControls(
			new InputWindowElement(birbVec.add(0, 0.5, 0), Pointing.DOWN).withItem(AllItems.SCHEDULE.asStack()), 40);
		scene.idle(6);
		scene.special.movePointOfInterest(util.grid.at(19, 4, 6));

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb3, bb3, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb3, bb3.inflate(.45f, 0, .45f), 40);
		scene.idle(15);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.move(-4, 0, 0), 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.expandTowards(-4, 0, 0), 40);
		scene.idle(5);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb.inflate(.45f, 0, .45f), 30);
		scene.idle(5);

		AABB bb4 = new AABB(marker, marker).move(.45, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb4, bb4, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb4, bb4.expandTowards(2, 0, 0), 20);
		scene.idle(15);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb4, bb4.expandTowards(2, 0, 0), 25);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb3, bb3.inflate(.45f, 0, .45f), 25);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb2, bb2.expandTowards(-4, 0, 0), 25);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.inflate(.45f, 0, .45f), 25);
		scene.idle(20);

		scene.world.moveSection(trainElement, util.vector.of(7, 0, 0), 25);
		scene.world.animateBogey(util.grid.at(3, 2, 6), -7f, 25);
		scene.special.moveParrot(birb, util.vector.of(7, 0, 0), 25);
		scene.idle(25);

		scene.world.animateTrainStation(stationPos, true);
		scene.world.changeSignalState(util.grid.at(8, 1, 9), SignalState.RED);
		scene.world.changeSignalState(util.grid.at(9, 4, 9), SignalState.RED);
		scene.idle(25);

		scene.world.showSection(thirdSignal, Direction.DOWN);
		scene.rotateCameraY(-90);
		scene.special.movePointOfInterest(util.grid.at(8, 2, 9));
		scene.idle(5);
		scene.world.showSection(firstNixie, Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(secondNixie, Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(thirdNixie, Direction.SOUTH);
		scene.idle(15);

		scene.overlay.showText(100)
			.pointAt(util.vector.blockSurface(util.grid.at(8, 2, 9), Direction.SOUTH))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Nixie tubes can be attached to make a signal's lights more visible");
		scene.idle(70);
	}

	public static void signaling(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("train_signal_signaling", "Collision Prevention with Signals");
		scene.configureBasePlate(1, 0, 15);
		scene.scaleSceneView(.5f);
		scene.showBasePlate();
		scene.rotateCameraY(55);

		for (int i = 16; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 7), Direction.DOWN);
			scene.world.showSection(util.select.position(i, 1, 15 - i), Direction.DOWN);
			scene.idle(1);
		}
		
		scene.world.toggleControls(util.grid.at(13, 3, 7));
		scene.world.toggleControls(util.grid.at(13, 3, 1));
		scene.world.toggleControls(util.grid.at(13, 3, 4));

		Selection train1 = util.select.fromTo(11, 2, 6, 15, 3, 8);
		Selection train2a = util.select.fromTo(15, 2, 3, 11, 3, 5);
		Selection train2b = util.select.fromTo(19, 2, 3, 16, 3, 5);
		Selection train3 = util.select.fromTo(11, 2, 0, 15, 3, 2);
		BlockPos s1Pos = util.grid.at(11, 3, 9);
		Selection s1 = util.select.fromTo(11, 1, 9, 11, 4, 9);
		BlockPos s2Pos = util.grid.at(5, 1, 5);
		Selection s2 = util.select.fromTo(5, 1, 5, 5, 2, 5);
		BlockPos s3Pos = util.grid.at(9, 1, 2);
		Selection s3 = util.select.fromTo(9, 1, 2, 10, 1, 2);
		BlockPos s4Pos = util.grid.at(7, 1, 12);
		Selection s4 = util.select.fromTo(7, 1, 12, 6, 1, 12);

		float pY = 3 / 16f;
		Vec3 m1 = util.vector.topOf(11, 0, 7)
			.add(0, pY, 0);
		Vec3 m2 = util.vector.topOf(5, 0, 7)
			.add(0, pY, 0);
		Vec3 m3 = util.vector.topOf(12, 0, 3)
			.add(0, pY, 0);
		Vec3 m4 = util.vector.topOf(4, 0, 11)
			.add(0, pY, 0);

		scene.idle(10);

		scene.world.showSection(s1, Direction.DOWN);
		scene.idle(8);

		Vec3 x1 = util.vector.of(17, 1 + pY, 7.5);
		Vec3 x2 = util.vector.of(0, 1 + pY, 7.5);
		Vec3 xz1 = util.vector.of(1, 1 + pY, 15);
		Vec3 xz2 = util.vector.of(16, 1 + pY, 0);

		scene.overlay.showBigLine(PonderPalette.OUTPUT, x1, m1.add(.45, 0, 0), 100);
		scene.overlay.showBigLine(PonderPalette.RED, x2, m1.add(-.45, 0, 0), 100);
		scene.overlay.showBigLine(PonderPalette.RED, xz1, xz2, 100);
		scene.idle(35);

		scene.overlay.showText(60)
			.pointAt(m1.add(-.45, 0, 0))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Train Signals divide a track into segments");
		scene.idle(50);

		scene.world.showSection(s2, Direction.DOWN);
		scene.idle(8);

		scene.overlay.showBigLine(PonderPalette.OUTPUT, x1, m1.add(.45, 0, 0), 80);
		scene.overlay.showBigLine(PonderPalette.BLUE, x2, m2.add(-.45, 0, 0), 75);
		scene.overlay.showBigLine(PonderPalette.RED, m2.add(.45, 0, 0), m1.add(-.45, 0, 0), 75);
		scene.overlay.showBigLine(PonderPalette.RED, xz1, xz2, 75);
		scene.idle(25);

		scene.world.showSection(s3, Direction.DOWN);
		scene.world.showSection(s4, Direction.DOWN);
		scene.idle(8);

		scene.overlay.showBigLine(PonderPalette.OUTPUT, x1, m1.add(.45, 0, 0), 50);
		scene.overlay.showBigLine(PonderPalette.BLUE, m2.add(-.45, 0, 0), x2, 50);
		scene.overlay.showBigLine(PonderPalette.FAST, xz1, m4.add(-.45, 0, .45), 50);
		scene.overlay.showBigLine(PonderPalette.RED, m2.add(.45, 0, 0), m1.add(-.45, 0, 0), 50);
		scene.overlay.showBigLine(PonderPalette.RED, m4.add(.45, 0, -.45), m3.add(-.45, 0, .45), 50);
		scene.overlay.showBigLine(PonderPalette.GREEN, m3.add(.45, 0, -.45), xz2, 50);
		scene.idle(40);

		ElementLink<WorldSectionElement> trainElement = scene.world.showIndependentSection(train1, null);
		ElementLink<ParrotElement> birb1 =
			scene.special.createBirb(util.vector.centerOf(18, 3, 7), FacePointOfInterestPose::new);
		scene.world.moveSection(trainElement, util.vector.of(4, 0, 0), 0);
		scene.world.moveSection(trainElement, util.vector.of(-9, 0, 0), 45);
		scene.world.animateBogey(util.grid.at(13, 2, 7), 9f, 45);
		scene.special.moveParrot(birb1, util.vector.of(-9, 0, 0), 45);
		scene.idle(20);

		scene.world.changeSignalState(s1Pos, SignalState.RED);
		scene.effects.indicateRedstone(s1Pos.above());
		scene.world.changeSignalState(s3Pos, SignalState.RED);
		scene.effects.indicateRedstone(s3Pos.east());
		scene.overlay.showBigLine(PonderPalette.RED, m2.add(.45, 0, 0), m1.add(-.45, 0, 0), 220);
		scene.overlay.showBigLine(PonderPalette.RED, m4.add(.45, 0, -.45), m3.add(-.45, 0, .45), 220);
		scene.idle(25);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(s1Pos.above(), Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("If a Segment is occupied, no other Trains will be allowed entry");
		scene.idle(50);

		ElementLink<WorldSectionElement> trainElement2 = scene.world.showIndependentSection(train3, null);
		ElementLink<ParrotElement> birb2 =
			scene.special.createBirb(util.vector.centerOf(18, 3, 7), FacePointOfInterestPose::new);
		scene.world.moveSection(trainElement2, util.vector.of(4, 0, 6), 0);
		scene.world.moveSection(trainElement2, util.vector.of(-4.5, 0, 0), 35);
		scene.world.animateBogey(util.grid.at(13, 2, 1), 4.5f, 35);
		scene.special.moveParrot(birb2, util.vector.of(-4.5, 0, 0), 35);
		scene.idle(40);
		scene.special.movePointOfInterest(s1Pos.above(2));
		scene.idle(10);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(util.grid.at(9, 0, 6)))
			.attachKeyFrame()
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("Thus, each Segment will contain only one Train at a time");
		scene.idle(90);

		scene.world.hideIndependentSection(trainElement, Direction.UP);
		scene.special.hideElement(birb1, Direction.UP);
		scene.idle(3);
		scene.world.hideIndependentSection(trainElement2, Direction.UP);
		scene.special.hideElement(birb2, Direction.UP);
		scene.idle(3);
		scene.world.changeSignalState(s1Pos, SignalState.GREEN);
		scene.world.changeSignalState(s3Pos, SignalState.GREEN);
		scene.idle(20);

		scene.overlay.showControls(
			new InputWindowElement(util.vector.blockSurface(s1Pos, Direction.EAST), Pointing.RIGHT).rightClick()
				.withWrench(),
			80);
		scene.idle(6);
		scene.world.cycleBlockProperty(s1Pos, SignalBlock.TYPE);
		scene.idle(15);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(s1Pos, Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("A second Signal mode is available via the Wrench");
		scene.idle(70);

		AABB bb = new AABB(m1, m1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb.inflate(.45f, 0, .45f), 140);
		scene.idle(10);

		AABB bb2 = bb.move(-.45, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.expandTowards(-5, 0, 0), 130);
		scene.idle(10);

		AABB bb3 = bb.move(-6, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb3, bb3, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb3, bb3.inflate(.45f, 0, .45f), 120);
		scene.idle(10);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(s2Pos, Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.text("Segments of a brass signal usually lead into standard signals");
		scene.idle(70);

		scene.overlay.showText(60)
			.pointAt(util.vector.blockSurface(s1Pos, Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.text("This special Signal can stop trains under a second condition");
		scene.idle(60);

		trainElement = scene.world.showIndependentSection(train1, Direction.DOWN);
		scene.world.moveSection(trainElement, util.vector.of(-10.5, 0, 0), 0);
		birb1 = scene.special.createBirb(util.vector.centerOf(3, 3, 7)
			.add(.5, 0, 0), DancePose::new);
		scene.idle(10);
		scene.world.changeSignalState(s2Pos, SignalState.RED);
		scene.effects.indicateRedstone(s2Pos.above());
		scene.overlay.showBigLine(PonderPalette.RED, m2.add(-.45, 0, 0), x2, 220);
		scene.idle(15);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb.inflate(.45f, 0, .45f), 140);
		scene.idle(10);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.expandTowards(-5, 0, 0), 130);
		scene.idle(10);

		trainElement2 = scene.world.showIndependentSection(train3, null);
		birb2 = scene.special.createBirb(util.vector.centerOf(18, 3, 7), FacePointOfInterestPose::new);

		scene.world.moveSection(trainElement2, util.vector.of(4, 0, 6), 0);
		scene.world.moveSection(trainElement2, util.vector.of(-4.5, 0, 0), 35);
		scene.world.animateBogey(util.grid.at(13, 2, 1), 4.5f, 35);
		scene.special.moveParrot(birb2, util.vector.of(-4.5, 0, 0), 35);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb.inflate(.45f, 0, .45f), 140);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb2, bb2.expandTowards(-5, 0, 0), 130);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb3, bb3, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb3, bb3.inflate(.45f, 0, .45f), 120);
		scene.idle(5);
		scene.world.changeSignalState(s1Pos, SignalState.RED);
		scene.effects.indicateRedstone(s1Pos.above());
		scene.idle(15);

		scene.overlay.showText(50)
			.pointAt(util.vector.blockSurface(s1Pos, Direction.WEST))
			.placeNearTarget()
			.text("It will stop Trains, which, upon entering...");
		scene.idle(50);

		AABB trainBB = new AABB(util.grid.at(13, 2, 7)).inflate(1, 1, .25f);
		for (int i = 1; i < 14; i++) {
			scene.idle(2);
			scene.overlay.chaseBoundingBoxOutline(i == 13 ? PonderPalette.RED : PonderPalette.OUTPUT, trainBB,
				trainBB.move(-i * .5, 0, 0), i == 13 ? 100 : 5);
		}

		scene.special.movePointOfInterest(util.grid.at(5, 3, 7));
		scene.idle(20);

		scene.overlay.showText(80)
			.pointAt(util.vector.of(7, 4, 7))
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("...would not be able to leave the Segment immediately");
		scene.idle(40);
		scene.idle(50);

		ElementLink<WorldSectionElement> trainElement3a = scene.world.showIndependentSection(train2a, null);
		scene.world.rotateSection(trainElement3a, 0, 45, 0, 0);
		scene.world.moveSection(trainElement3a, util.vector.of(4, 0, -6), 0);
		scene.world.moveSection(trainElement3a, util.vector.of(-20, 0, 20), 40);
		scene.world.animateBogey(util.grid.at(13, 2, 4), -20f, 40);
		ElementLink<ParrotElement> birb3 =
			scene.special.createBirb(util.vector.of(18, 3.5, -2), FacePointOfInterestPose::new);
		scene.special.moveParrot(birb3, util.vector.of(-20, 0, 20), 40);
		scene.idle(5);

		scene.effects.indicateRedstone(s3Pos.east());
		scene.world.changeSignalState(s3Pos, SignalState.RED);

		ElementLink<WorldSectionElement> trainElement3b = scene.world.showIndependentSection(train2b, null);
		scene.world.rotateSection(trainElement3b, 0, 45, 0, 0);
		scene.world.moveSection(trainElement3b, util.vector.of(0.5, 0, -7), 0);
		scene.world.moveSection(trainElement3b, util.vector.of(-20, 0, 20), 40);
		scene.world.animateBogey(util.grid.at(17, 2, 4), -20f, 40);
		scene.idle(10);

		scene.effects.indicateRedstone(s4Pos.west());
		scene.world.changeSignalState(s4Pos, SignalState.RED);

		scene.idle(5);
		scene.world.changeSignalState(s3Pos, SignalState.GREEN);
		scene.world.hideIndependentSection(trainElement3a, null);
		scene.special.hideElement(birb3, null);
		scene.idle(5);
		scene.world.hideIndependentSection(trainElement3b, null);
		scene.idle(15);
		scene.world.changeSignalState(s4Pos, SignalState.GREEN);
		scene.idle(15);

		scene.overlay.showBigLine(PonderPalette.GREEN, m2.add(.45, 0, 0), m1.add(-.45, 0, 0), 100);
		scene.overlay.showBigLine(PonderPalette.GREEN, m4.add(.45, 0, -.45), m3.add(-.45, 0, .45), 100);
		scene.idle(15);
		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(util.grid.at(9, 0, 6)))
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("This helps keeping queued Trains out of a busy Segment");
		scene.idle(60);
	}

	public static void redstone(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("train_signal_redstone", "Signals & Redstone");
		scene.configureBasePlate(0, 0, 9);
		scene.scaleSceneView(.75f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		for (int i = 1; i <= 7; i++) {
			scene.world.showSection(util.select.position(6, 1, i), Direction.DOWN);
			scene.idle(2);
		}

		scene.idle(10);

		Selection train = util.select.fromTo(5, 2, 3, 7, 3, 7);
		Selection lever = util.select.fromTo(2, 1, 3, 1, 1, 3);
		Selection comparator = util.select.fromTo(2, 1, 1, 1, 1, 1);
		Selection signal = util.select.fromTo(3, 1, 3, 3, 2, 3);
		BlockPos signalPos = util.grid.at(3, 1, 3);

		scene.world.showSection(signal, Direction.DOWN);
		scene.idle(10);
		scene.world.showSection(lever, Direction.EAST);
		scene.idle(15);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 3), Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Signals can be forced red by a redstone signal");
		scene.idle(40);

		scene.world.toggleRedstonePower(lever);
		scene.effects.indicateRedstone(util.grid.at(1, 1, 3));
		scene.world.changeSignalState(signalPos, SignalState.RED);
		scene.idle(40);

		scene.world.toggleRedstonePower(lever);
		scene.effects.indicateRedstone(util.grid.at(1, 1, 3));
		scene.world.changeSignalState(signalPos, SignalState.GREEN);
		scene.idle(40);

		scene.world.hideSection(lever, Direction.SOUTH);
		scene.idle(15);
		ElementLink<WorldSectionElement> comparatorElement =
			scene.world.showIndependentSection(comparator, Direction.SOUTH);
		scene.world.moveSection(comparatorElement, util.vector.of(0, 0, 2), 0);
		scene.idle(15);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(util.grid.at(3, 2, 3), Direction.WEST))
			.attachKeyFrame()
			.placeNearTarget()
			.text("Conversely, red signals emit a comparator output");
		scene.idle(40);

		scene.world.toggleControls(util.grid.at(6, 3, 5));
		scene.world.showSection(train, Direction.DOWN);
		scene.special.createBirb(util.vector.centerOf(util.grid.at(6, 3, 4)), DancePose::new);
		scene.idle(10);
		scene.world.toggleRedstonePower(comparator);
		scene.effects.indicateRedstone(signalPos);
		scene.world.changeSignalState(signalPos, SignalState.RED);
	}

}
//文件scenes/trains/TrainStationScenes.java
package com.simibubi.create.infrastructure.ponder.scenes.trains;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.trains.station.StationBlock;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement;
import com.simibubi.create.foundation.ponder.element.ParrotElement.FacePointOfInterestPose;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrainStationScenes {

	public static void assembly(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("train_assembly", "Assembling Trains");
		scene.configureBasePlate(1, 0, 12);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		for (int i = 13; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 6), Direction.DOWN);
			scene.idle(1);
		}

		BlockState air = Blocks.AIR.defaultBlockState();
		scene.world.setBlock(util.grid.at(10, 2, 6), air, false);
		scene.world.setBlock(util.grid.at(6, 2, 6), air, false);
		scene.world.setBlock(util.grid.at(3, 2, 6), air, false);

		scene.idle(10);

		Selection station = util.select.position(11, 1, 3);
		Selection controls = util.select.fromTo(9, 3, 6, 10, 3, 6);
		Selection train1 = util.select.fromTo(12, 2, 5, 8, 2, 7)
			.substract(util.select.position(10, 2, 6));
		Selection train2 = util.select.fromTo(7, 2, 5, 2, 2, 7)
			.substract(util.select.position(6, 2, 6))
			.substract(util.select.position(3, 2, 6));
		Selection train3 = util.select.fromTo(7, 2, 1, 3, 3, 3);

		BlockPos stationPos = util.grid.at(11, 1, 3);
		Vec3 marker = util.vector.topOf(11, 0, 6)
			.add(0, 3 / 16f, 0);
		Vec3 stationTop = util.vector.topOf(stationPos);

		AABB bb = new AABB(util.vector.topOf(11, 0, 6), util.vector.topOf(11, 0, 6)).move(0, 2 / 16f, 0);

		scene.overlay.showControls(new InputWindowElement(marker, Pointing.DOWN).rightClick()
			.withItem(AllBlocks.TRACK_STATION.asStack()), 40);
		scene.idle(6);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.inflate(.45f, 1 / 16f, .45f), 100);
		scene.idle(10);

		scene.overlay.showText(70)
			.pointAt(marker)
			.placeNearTarget()
			.colored(PonderPalette.GREEN)
			.text("Select a Train Track then place the Station nearby");
		scene.idle(60);

		scene.world.showSection(station, Direction.DOWN);
		scene.idle(15);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb,
			new AABB(stationPos).contract(1 / 16f, 2 / 16f, 1 / 16f), 20);
		scene.idle(25);

		scene.overlay.showText(80)
			.pointAt(marker)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Stations are the Waypoints of your Track Network");
		scene.idle(90);

		scene.overlay.showControls(new InputWindowElement(stationTop, Pointing.DOWN).rightClick(), 50);
		scene.idle(16);
		scene.overlay.showText(70)
			.pointAt(stationTop)
			.placeNearTarget()
			.attachKeyFrame()
			.text("To create a new Train, open the UI and switch to Assembly Mode");
		scene.idle(50);

		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.effects.indicateSuccess(stationPos);

		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(marker, Pointing.DOWN).withItem(new ItemStack(Items.BARRIER)),
			60);
		scene.idle(6);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb.inflate(.45f, 1 / 16f, .45f), 80);
		scene.idle(10);
		scene.overlay.showText(70)
			.pointAt(marker)
			.placeNearTarget()
			.colored(PonderPalette.RED)
			.text("During Assembly no scheduled trains will approach this station");
		scene.idle(85);

		ItemStack casing = AllBlocks.RAILWAY_CASING.asStack();
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(11, 0, 6), Pointing.RIGHT).rightClick()
			.withItem(casing), 80);
		scene.idle(6);
		scene.world.restoreBlocks(util.select.position(10, 2, 6));
		ElementLink<WorldSectionElement> trainElement1 =
			scene.world.showIndependentSection(util.select.position(10, 2, 6), Direction.DOWN);
		scene.idle(20);
		scene.overlay.showText(70)
			.pointAt(util.vector.blockSurface(util.grid.at(10, 2, 6), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Create new bogeys by using Train Casing on Tracks");
		scene.idle(55);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(4, 0, 6), Pointing.RIGHT).rightClick()
			.withItem(casing), 15);
		scene.idle(6);
		scene.world.setBlock(util.grid.at(3, 2, 6), AllBlocks.SMALL_BOGEY.getDefaultState(), false);
		ElementLink<WorldSectionElement> trainElement2 =
			scene.world.showIndependentSection(util.select.position(3, 2, 6), Direction.DOWN);
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(7, 0, 6), Pointing.RIGHT).rightClick()
			.withItem(casing), 15);
		scene.idle(6);
		scene.world.setBlock(util.grid.at(6, 2, 6), AllBlocks.SMALL_BOGEY.getDefaultState(), false);
		scene.world.showSectionAndMerge(util.select.position(6, 2, 6), Direction.DOWN, trainElement2);
		scene.idle(30);

		scene.overlay.showText(50)
			.pointAt(util.vector.topOf(3, 0, 6))
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Click the track again to cycle between bogey designs");
		scene.idle(35);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(4, 0, 6), Pointing.RIGHT).rightClick(), 15);
		scene.idle(6);
		scene.world.restoreBlocks(util.select.position(3, 2, 6));
		scene.idle(20);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(7, 0, 6), Pointing.RIGHT).rightClick(), 15);
		scene.idle(6);
		scene.world.restoreBlocks(util.select.position(6, 2, 6));
		scene.idle(30);

		scene.overlay.showOutline(PonderPalette.GREEN, casing, util.select.position(10, 2, 6)
			.add(util.select.position(6, 2, 6))
			.add(util.select.position(3, 2, 6)), 40);

		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(3, 2, 6))
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.GREEN)
			.text("Attach blocks with the help of Super Glue");
		scene.idle(35);

		scene.world.showSectionAndMerge(train1, Direction.DOWN, trainElement1);
		scene.idle(10);
		scene.world.showSectionAndMerge(train2, Direction.DOWN, trainElement2);
		scene.idle(5);
		scene.world.showSectionAndMerge(util.select.fromTo(6, 4, 5, 6, 3, 7), Direction.WEST, trainElement2);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.fromTo(5, 3, 6, 4, 4, 7), Direction.NORTH, trainElement2);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 3, 6, 3, 5, 6), Direction.DOWN, trainElement2);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.fromTo(3, 5, 5, 3, 6, 5), Direction.SOUTH, trainElement2);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.position(3, 3, 5), Direction.EAST, trainElement2);
		scene.idle(3);
		scene.world.showSectionAndMerge(util.select.position(5, 3, 5), Direction.SOUTH, trainElement2);
		scene.idle(10);

		AABB glue1 = new AABB(util.grid.at(10, 2, 6));
		AABB glue2 = new AABB(util.grid.at(4, 2, 6));
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glue2, glue2, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glue2, glue2.inflate(2, 0, 1)
			.expandTowards(1, 3, 0), 60);
		scene.idle(5);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glue1, glue1, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, glue1, glue1.inflate(1.25, 0, .25)
			.expandTowards(0, 1, 0), 60);
		scene.idle(15);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(4, 2, 6)), Pointing.UP)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);
		scene.idle(5);
		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(10, 2, 6)), Pointing.UP)
			.withItem(AllItems.SUPER_GLUE.asStack()), 40);
		scene.idle(55);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(5, 3, 5)), Pointing.DOWN)
			.withItem(new ItemStack(Items.CHARCOAL)), 40);
		scene.idle(10);
		scene.overlay.showText(90)
			.pointAt(util.vector.blockSurface(util.grid.at(5, 3, 5), Direction.WEST))
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Assembled Trains will move faster if they can find fuel in assembled chests or barrels");
		scene.idle(100);
		scene.overlay.showSelectionWithText(util.select.fromTo(4, 3, 6, 5, 4, 7), 60)
			.pointAt(util.vector.blockSurface(util.grid.at(5, 4, 6), Direction.UP))
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.text("Fuel stored in Vaults will not be consumed by the train");
		scene.idle(75);

		ElementLink<WorldSectionElement> controlsElement = scene.world.showIndependentSection(controls, Direction.DOWN);
		scene.idle(15);
		scene.overlay.showText(60)
			.pointAt(util.vector.topOf(10, 3, 6))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Every Train requires Train Controls on board");
		scene.idle(55);
		scene.world.showSectionAndMerge(util.select.position(8, 3, 6), Direction.DOWN, controlsElement);
		scene.idle(15);
		scene.world.moveSection(controlsElement, util.vector.of(1, 0, 0), 10);
		scene.idle(15);

		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(9, 3, 6))
			.placeNearTarget()
			.text("An optional second one allows departure from Stations in both directions");
		scene.idle(75);

		scene.overlay.showControls(new InputWindowElement(stationTop, Pointing.DOWN).rightClick(), 50);
		scene.idle(16);
		scene.overlay.showText(60)
			.pointAt(stationTop)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Open the Station UI and confirm the Assembly process");
		scene.idle(50);

		scene.world.toggleControls(util.grid.at(10, 3, 6));
		scene.world.toggleControls(util.grid.at(8, 3, 6));
		scene.world.cycleBlockProperty(stationPos, StationBlock.ASSEMBLING);
		scene.effects.indicateSuccess(stationPos);
		scene.world.animateTrainStation(stationPos, true);
		scene.idle(20);

		ElementLink<ParrotElement> birb =
			scene.special.createBirb(util.vector.centerOf(10, 3, 6), FacePointOfInterestPose::new);
		scene.idle(15);
		scene.special.movePointOfInterest(util.grid.at(18, 3, 6));
		scene.idle(15);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.moveSection(controlsElement, util.vector.of(18, 0, 0), 70);
		scene.world.moveSection(trainElement1, util.vector.of(18, 0, 0), 70);
		scene.world.moveSection(trainElement2, util.vector.of(18, 0, 0), 70);
		scene.world.animateBogey(util.grid.at(10, 2, 6), -18f, 70);
		scene.world.animateBogey(util.grid.at(6, 2, 6), -18f, 70);
		scene.world.animateBogey(util.grid.at(3, 2, 6), -18f, 70);
		scene.special.moveParrot(birb, util.vector.of(18, 0, 0), 70);

		scene.idle(10);
		scene.world.hideIndependentSection(controlsElement, null);
		scene.world.hideIndependentSection(trainElement1, null);
		scene.special.hideElement(birb, null);
		scene.idle(20);
		scene.world.hideIndependentSection(trainElement2, null);
		scene.idle(20);

		scene.overlay.showText(70)
			.pointAt(stationTop)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Trains can be disassembled back into blocks at stations only");
		scene.idle(85);

		scene.overlay.showControls(new InputWindowElement(stationTop, Pointing.DOWN).rightClick()
			.withItem(new ItemStack(Items.FILLED_MAP)), 75);
		scene.idle(15);
		scene.overlay.showText(70)
			.pointAt(stationTop)
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("When used on a station, maps will add a labeled marker at the location");
		scene.idle(70);

		for (int i = 8; i >= 3; i--) {
			scene.world.showSection(util.select.position(i, 1, 2), Direction.DOWN);
			scene.idle(1);
		}

		scene.world.toggleControls(util.grid.at(5, 3, 2));
		scene.idle(10);
		ElementLink<WorldSectionElement> trainElement3 = scene.world.showIndependentSection(train3, Direction.DOWN);
		scene.world.moveSection(trainElement3, util.vector.of(0, 0, 4), 0);
		scene.idle(15);

		Vec3 target = util.vector.topOf(util.grid.at(5, 3, 6));
		scene.overlay.showControls(new InputWindowElement(target, Pointing.DOWN).rightClick()
			.withWrench(), 75);
		scene.idle(15);

		scene.overlay.showText(70)
			.pointAt(target)
			.placeNearTarget()
			.attachKeyFrame()
			.colored(PonderPalette.BLUE)
			.text("Assembled Trains can be relocated to nearby Tracks using the Wrench");
		scene.idle(60);

		scene.overlay
			.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(6, 0, 2)), Pointing.DOWN).rightClick()
				.withWrench(), 15);
		scene.idle(15);
		scene.world.moveSection(trainElement3, util.vector.of(0, 0, -4), 5);

	}

	public static void autoSchedule(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("auto_schedule", "Stations & Scheduling");
		scene.configureBasePlate(1, 0, 12);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);
		scene.showBasePlate();

		for (int i = 13; i >= 0; i--) {
			scene.world.showSection(util.select.position(i, 1, 6), Direction.DOWN);
			scene.idle(1);
		}

		scene.world.toggleControls(util.grid.at(7, 3, 6));

		scene.idle(4);
		Selection redstone = util.select.fromTo(8, 1, 2, 8, 1, 1);
		Selection belt = util.select.fromTo(9, 1, 3, 12, 1, 3);
		Selection largeCog = util.select.position(13, 0, 4);
		Selection cog = util.select.position(12, 1, 4);
		BlockPos stationPos = util.grid.at(8, 1, 3);
		Selection train = util.select.fromTo(9, 2, 5, 5, 3, 7);
		Selection station = util.select.position(stationPos);

		scene.world.showSection(station, Direction.DOWN);
		scene.idle(10);

		ElementLink<WorldSectionElement> trainElement = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.world.moveSection(trainElement, util.vector.of(-4, 0, 0), 0);
		Vec3 target = util.vector.centerOf(2, 3, 6);
		ElementLink<ParrotElement> birb = scene.special.createBirb(target, FacePointOfInterestPose::new);
		scene.idle(10);

		scene.overlay.showText(90)
			.pointAt(target)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Schedules can be used to provide drivers with a destination");
		scene.idle(70);
		scene.overlay.showControls(
			new InputWindowElement(target.add(0, 0.5, 0), Pointing.DOWN).withItem(AllItems.SCHEDULE.asStack()), 40);
		scene.idle(6);
		scene.special.movePointOfInterest(util.grid.at(9, 4, 6));

		Vec3 marker = util.vector.topOf(8, 0, 6)
			.add(0, 3 / 16f, 0);
		AABB bb = new AABB(marker, marker);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb.inflate(.45f, 0, .45f), 40);
		scene.idle(15);

		AABB bb2 = new AABB(marker, marker).move(-.45, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.move(-4, 0, 0), 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.expandTowards(-4, 0, 0), 20);
		scene.idle(15);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb, bb.inflate(.45f, 0, .45f), 25);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.GREEN, bb2, bb2.expandTowards(-4, 0, 0), 25);
		scene.idle(20);

		scene.world.showSection(redstone, Direction.SOUTH);

		scene.world.moveSection(trainElement, util.vector.of(4, 0, 0), 20);
		scene.world.animateBogey(util.grid.at(7, 2, 6), -4f, 20);
		scene.special.moveParrot(birb, util.vector.of(4, 0, 0), 20);
		scene.idle(20);

		scene.world.animateTrainStation(stationPos, true);
		scene.world.toggleRedstonePower(redstone);
		scene.effects.indicateRedstone(stationPos);
		scene.idle(25);
		scene.overlay.showText(80)
			.pointAt(util.vector.topOf(stationPos.north())
				.subtract(0, 14 / 16f, 0))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Comparators will receive a signal whenever a Train is present");
		scene.idle(90);

		scene.world.hideSection(redstone, Direction.NORTH);
		scene.world.animateTrainStation(stationPos, false);
		scene.world.moveSection(trainElement, util.vector.of(0, 1, 0), 5);
		scene.special.moveParrot(birb, util.vector.of(0, 2, 0), 5);
		scene.idle(7);
		scene.world.moveSection(trainElement, util.vector.of(4, 0, 0), 10);
		scene.world.rotateSection(trainElement, 0, 180, 0, 10);
		scene.special.moveParrot(birb, util.vector.of(6, 0, 0), 10);
		scene.idle(12);
		scene.world.moveSection(trainElement, util.vector.of(0, -1, 0), 5);
		scene.special.moveParrot(birb, util.vector.of(0, -2, 0), 5);
		scene.idle(25);

		target = target.add(10, 0, 0);
		scene.overlay.showText(90)
			.pointAt(marker.add(-.45, 0, 0))
			.colored(PonderPalette.RED)
			.placeNearTarget()
			.attachKeyFrame()
			.text("Mind that a Station can only be approached from the indicated direction");
		scene.idle(70);
		scene.overlay.showControls(
			new InputWindowElement(target.add(0, 0.5, 0), Pointing.DOWN).withItem(AllItems.SCHEDULE.asStack()), 40);
		scene.idle(6);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb, 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb, bb.inflate(.45f, 0, .45f), 40);
		scene.idle(15);

		bb2 = new AABB(marker, marker).move(.45, 0, 0);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.move(4, 0, 0), 1);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.OUTPUT, bb2, bb2.expandTowards(4, 0, 0), 20);
		scene.idle(15);

		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb, bb.inflate(.45f, 0, .45f), 45);
		scene.overlay.chaseBoundingBoxOutline(PonderPalette.RED, bb2, bb2.expandTowards(4, 0, 0), 45);
		scene.idle(20);

		scene.special.movePointOfInterest(util.grid.at(11, 2, 5));
		scene.idle(25);

		scene.world.hideIndependentSection(trainElement, Direction.EAST);
		scene.special.hideElement(birb, Direction.EAST);
		scene.idle(20);

		scene.world.multiplyKineticSpeed(util.select.everywhere(), .75f);

		scene.world.showSection(largeCog, Direction.UP);
		scene.world.showSection(cog, Direction.DOWN);
		scene.idle(3);
		scene.world.showSection(belt, Direction.SOUTH);
		scene.idle(15);

		scene.overlay.showText(70)
			.pointAt(util.vector.topOf(stationPos)
				.add(-.5, 0, 0))
			.placeNearTarget()
			.attachKeyFrame()
			.text("Stations can also be used to assign new Schedules automatically");
		scene.idle(40);

		trainElement = scene.world.showIndependentSection(train, Direction.DOWN);
		scene.world.moveSection(trainElement, util.vector.of(-4, 0, 0), 0);
		target = util.vector.centerOf(2, 3, 6);
		birb = scene.special.createBirb(target, FacePointOfInterestPose::new);
		scene.idle(10);
		scene.world.moveSection(trainElement, util.vector.of(4, 0, 0), 20);
		scene.world.animateBogey(util.grid.at(7, 2, 6), -4f, 20);
		scene.special.moveParrot(birb, util.vector.of(4, 0, 0), 20);
		scene.idle(10);

		scene.world.createItemOnBelt(util.grid.at(11, 1, 3), Direction.DOWN, AllItems.SCHEDULE.asStack());
		scene.idle(10);
		scene.world.animateTrainStation(stationPos, true);
		scene.idle(10);
		scene.overlay.showControls(
			new InputWindowElement(util.vector.topOf(stationPos), Pointing.DOWN).withItem(AllItems.SCHEDULE.asStack()),
			20);
		scene.idle(30);
		scene.effects.indicateSuccess(stationPos);
		scene.idle(10);
		target = util.vector.centerOf(6, 3, 6);
		scene.overlay.showLine(PonderPalette.GREEN, util.vector.topOf(stationPos)
			.add(0, -.125, .45), target.add(0, 0, -.5), 40);
		scene.idle(10);
		scene.effects.indicateSuccess(util.grid.at(6, 3, 6));
		scene.special.conductorBirb(birb, true);
		scene.special.movePointOfInterest(util.grid.at(18, 4, 6));
		scene.idle(25);

		scene.overlay.showText(80)
			.pointAt(target)
			.placeNearTarget()
			.attachKeyFrame()
			.text("The Schedule placed on a station will automatically copy itself to present trains");
		scene.idle(90);

		scene.world.moveSection(trainElement, util.vector.of(8, 0, 0), 30);
		scene.special.moveParrot(birb, util.vector.of(8, 0, 0), 30);
		scene.world.animateBogey(util.grid.at(7, 2, 6), -8f, 30);
		scene.world.animateTrainStation(stationPos, false);
		scene.idle(10);
		scene.world.hideIndependentSection(trainElement, null);
		scene.special.hideElement(birb, null);
		scene.idle(25);

		scene.overlay.showText(100)
			.pointAt(util.vector.topOf(stationPos)
				.add(-.5, 0, 0))
			.placeNearTarget()
			.colored(PonderPalette.BLUE)
			.text("As opposed to manual scheduling, drivers will not take the item with them");
		scene.idle(60);
	}

}
//文件scenes/TunnelScenes.java
package com.simibubi.create.infrastructure.ponder.scenes;

import java.util.Vector;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.belt.BeltBlock;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.logistics.tunnel.BrassTunnelBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.filtering.SidedFilteringBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollOptionBehaviour;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.NBTHelper;
import com.simibubi.create.foundation.utility.Pointing;
import com.simibubi.create.foundation.utility.VecHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class TunnelScenes {

	public static void andesite(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("andesite_tunnel", "Using Andesite Tunnels");
		scene.configureBasePlate(0, 0, 5);

		scene.world.cycleBlockProperty(util.grid.at(2, 1, 2), BeltBlock.CASING);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 5, 4, 1, 3), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(4, 1, 2, 0, 1, 2), Direction.SOUTH);
		scene.idle(10);

		Vector<ElementLink<WorldSectionElement>> tunnels = new Vector<>(3);
		for (int i = 0; i < 3; i++) {
			tunnels.add(scene.world.showIndependentSection(util.select.position(1 + i, 2, 4), Direction.DOWN));
			scene.world.moveSection(tunnels.get(i), util.vector.of(0, 0, -2), 0);
			scene.idle(4);
		}

		for (int i = 0; i < 3; i++) {
			scene.world.cycleBlockProperty(util.grid.at(1 + i, 1, 2), BeltBlock.CASING);
			scene.world.modifyBlockEntityNBT(util.select.position(1 + i, 1, 2), BeltBlockEntity.class,
				nbt -> NBTHelper.writeEnum(nbt, "Casing", BeltBlockEntity.CasingType.ANDESITE), true);
			scene.idle(4);
		}

		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(util.grid.at(1, 2, 2)))
			.placeNearTarget()
			.text("Andesite Tunnels can be used to cover up your belts");
		scene.idle(70);

		for (int i = 0; i < 3; i++) {
			scene.world.cycleBlockProperty(util.grid.at(1 + i, 1, 2), BeltBlock.CASING);
			scene.world.hideIndependentSection(tunnels.get(i), Direction.UP);
			scene.idle(4);
		}
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(2, 1, 0, 0, 1, 1), Direction.SOUTH);
		scene.idle(10);
		scene.world.showSection(util.select.position(2, 2, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.cycleBlockProperty(util.grid.at(2, 1, 2), BeltBlock.CASING);

		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(util.vector.blockSurface(util.grid.at(2, 2, 2), Direction.NORTH))
			.placeNearTarget()
			.text("Whenever an Andesite Tunnel has connections to the sides...");
		scene.idle(70);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(util.grid.at(4, 1, 2)), Pointing.DOWN)
			.withItem(new ItemStack(Items.COPPER_INGOT)), 20);
		scene.idle(7);
		scene.world.createItemOnBelt(util.grid.at(4, 1, 2), Direction.UP, new ItemStack(Items.COPPER_INGOT, 64));
		scene.idle(40);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 1 / 16f);
		scene.overlay.showText(80)
			.attachKeyFrame()
			.text("...they will split exactly one item off of any passing stacks")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 0), Direction.WEST))
			.placeNearTarget();
		scene.idle(90);
		scene.overlay.showText(80)
			.text("The remainder will continue on its path")
			.pointAt(util.vector.blockSurface(util.grid.at(0, 1, 2), Direction.UP))
			.placeNearTarget();
		scene.idle(90);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), 16f);
	}

	public static void brass(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("brass_tunnel", "Using Brass Tunnels");
		scene.configureBasePlate(1, 0, 5);
		scene.world.cycleBlockProperty(util.grid.at(3, 1, 2), BeltBlock.CASING);

		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(5, 1, 5, 5, 1, 3), Direction.DOWN);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(5, 1, 2, 1, 1, 2), Direction.SOUTH);
		scene.idle(10);

		Vector<ElementLink<WorldSectionElement>> tunnels = new Vector<>(3);
		for (int i = 0; i < 3; i++) {
			tunnels.add(scene.world.showIndependentSection(util.select.position(2 + i, 2, 4), Direction.DOWN));
			scene.world.moveSection(tunnels.get(i), util.vector.of(0, 0, -2), 0);
			scene.idle(4);
		}

		for (int i = 0; i < 3; i++) {
			scene.world.cycleBlockProperty(util.grid.at(2 + i, 1, 2), BeltBlock.CASING);
			scene.world.modifyBlockEntityNBT(util.select.position(2 + i, 1, 2), BeltBlockEntity.class,
				nbt -> NBTHelper.writeEnum(nbt, "Casing", BeltBlockEntity.CasingType.BRASS), true);
			scene.idle(4);
		}

		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(util.vector.topOf(util.grid.at(2, 2, 2)))
			.placeNearTarget()
			.text("Brass Tunnels can be used to cover up your belts");
		scene.idle(70);

		for (int i = 0; i < 3; i++) {
			scene.world.cycleBlockProperty(util.grid.at(2 + i, 1, 2), BeltBlock.CASING);
			scene.world.hideIndependentSection(tunnels.get(i), Direction.UP);
			scene.idle(4);
		}
		scene.idle(10);
		scene.world.showSection(util.select.fromTo(3, 1, 0, 1, 1, 1), Direction.SOUTH);
		scene.idle(10);
		scene.world.showSection(util.select.position(3, 2, 2), Direction.DOWN);
		scene.idle(10);
		scene.world.cycleBlockProperty(util.grid.at(3, 1, 2), BeltBlock.CASING);
		scene.idle(10);

		BlockPos tunnelPos = util.grid.at(3, 2, 2);
		for (Direction d : Iterate.horizontalDirections) {
			if (d == Direction.SOUTH)
				continue;
			Vec3 filter = getTunnelFilterVec(tunnelPos, d);
			scene.overlay.showFilterSlotInput(filter, d, 40);
			scene.idle(3);
		}

		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(getTunnelFilterVec(tunnelPos, Direction.WEST))
			.placeNearTarget()
			.text("Brass Tunnels have filter slots on each open side");
		scene.idle(70);

		scene.rotateCameraY(70);

		scene.idle(20);
		Vec3 tunnelFilterVec = getTunnelFilterVec(tunnelPos, Direction.EAST);
		scene.overlay.showFilterSlotInput(tunnelFilterVec, Direction.EAST, 10);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(tunnelFilterVec)
			.placeNearTarget()
			.text("Filters on inbound connections simply block non-matching items");
		ItemStack copper = new ItemStack(Items.COPPER_INGOT);
		Class<BrassTunnelBlockEntity> tunnelClass = BrassTunnelBlockEntity.class;
		scene.world.modifyBlockEntity(tunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.EAST, copper));
		scene.overlay.showControls(new InputWindowElement(tunnelFilterVec, Pointing.DOWN).withItem(copper), 30);
		ItemStack zinc = AllItems.ZINC_INGOT.asStack();
		scene.world.createItemOnBelt(util.grid.at(5, 1, 2), Direction.EAST, zinc);
		scene.idle(70);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), -2);
		scene.idle(20);
		scene.rotateCameraY(-70);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), -.5f);
		scene.idle(20);
		scene.world.modifyBlockEntity(tunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.EAST, ItemStack.EMPTY));

		tunnelFilterVec = getTunnelFilterVec(tunnelPos, Direction.NORTH);
		scene.overlay.showFilterSlotInput(tunnelFilterVec, Direction.NORTH, 40);
		tunnelFilterVec = getTunnelFilterVec(tunnelPos, Direction.WEST);
		scene.overlay.showFilterSlotInput(tunnelFilterVec, Direction.WEST, 40);
		scene.overlay.showText(60)
			.attachKeyFrame()
			.pointAt(tunnelFilterVec)
			.placeNearTarget()
			.text("Filters on outbound connections can be used to sort items by type");
		scene.idle(70);

		scene.overlay.showControls(new InputWindowElement(tunnelFilterVec, Pointing.LEFT).withItem(copper), 30);
		scene.world.modifyBlockEntity(tunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.WEST, copper));
		scene.idle(4);
		tunnelFilterVec = getTunnelFilterVec(tunnelPos, Direction.NORTH);
		scene.overlay.showControls(new InputWindowElement(tunnelFilterVec, Pointing.RIGHT).withItem(zinc), 30);
		scene.world.modifyBlockEntity(tunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.NORTH, zinc));

		scene.world.multiplyKineticSpeed(util.select.everywhere(), 1.5f);
		for (int i = 0; i < 6; i++) {
			scene.world.createItemOnBelt(util.grid.at(5, 1, 2), Direction.EAST, i % 2 == 0 ? zinc : copper);
			scene.idle(12);
		}

		scene.idle(30);
		scene.world.modifyBlockEntity(tunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.NORTH, ItemStack.EMPTY));
		scene.world.modifyBlockEntity(tunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.WEST, ItemStack.EMPTY));
		scene.idle(10);

		Vec3 tunnelTop = util.vector.topOf(tunnelPos);
		scene.overlay.showCenteredScrollInput(tunnelPos, Direction.UP, 120);
		scene.overlay.showText(120)
			.attachKeyFrame()
			.pointAt(tunnelTop)
			.placeNearTarget()
			.text(
				"Whenever a passing item has multiple valid exits, the distribution mode will decide how to handle it");
		for (int i = 0; i < 3; i++) {
			scene.idle(40);
			scene.world.createItemOnBelt(util.grid.at(5, 1, 2), Direction.EAST, AllItems.BRASS_INGOT.asStack(63));
		}
		scene.idle(30);

		scene.world.hideSection(util.select.position(3, 2, 2), Direction.UP);
		scene.idle(5);
		scene.world.hideSection(util.select.fromTo(5, 1, 2, 1, 1, 0), Direction.UP);
		scene.idle(15);

		ElementLink<WorldSectionElement> newBelt =
			scene.world.showIndependentSection(util.select.fromTo(3, 3, 2, 0, 3, 4)
				.add(util.select.fromTo(5, 3, 3, 4, 3, 3)), Direction.DOWN);
		scene.world.moveSection(newBelt, util.vector.of(0, -2, -1), 0);
		scene.idle(15);
		for (int i = 0; i < 3; i++) {
			scene.idle(4);
			scene.world.showSectionAndMerge(util.select.position(3, 4, 2 + i), Direction.DOWN, newBelt);
		}

		scene.overlay.showSelectionWithText(util.select.fromTo(3, 1, 1, 3, 2, 3), 80)
			.attachKeyFrame()
			.placeNearTarget()
			.text("Brass Tunnels on parallel belts will form a group");
		scene.idle(90);

		ItemStack item1 = new ItemStack(Items.CARROT);
		ItemStack item2 = new ItemStack(Items.HONEY_BOTTLE);
		ItemStack item3 = new ItemStack(Items.SWEET_BERRIES);

		tunnelFilterVec = getTunnelFilterVec(tunnelPos, Direction.WEST);
		BlockPos newTunnelPos = tunnelPos.above(2)
			.south();
		scene.overlay
			.showControls(new InputWindowElement(tunnelFilterVec.add(0, 0, -1), Pointing.RIGHT).withItem(item1), 20);
		scene.world.modifyBlockEntity(newTunnelPos.north(), tunnelClass,
			be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
				.setFilter(Direction.WEST, item1));
		scene.idle(4);
		scene.overlay.showControls(new InputWindowElement(tunnelFilterVec, Pointing.DOWN).withItem(item2), 20);
		scene.world.modifyBlockEntity(newTunnelPos, tunnelClass, be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
			.setFilter(Direction.WEST, item2));
		scene.idle(4);
		scene.overlay.showControls(new InputWindowElement(tunnelFilterVec.add(0, 0, 1), Pointing.LEFT).withItem(item3),
			20);
		scene.world.modifyBlockEntity(newTunnelPos.south(), tunnelClass,
			be -> be.getBehaviour(SidedFilteringBehaviour.TYPE)
				.setFilter(Direction.WEST, item3));
		scene.idle(30);

		scene.overlay.showText(80)
			.pointAt(tunnelTop)
			.placeNearTarget()
			.text("Incoming Items will now be distributed across all connected exits");
		scene.idle(90);

		BlockPos beltPos = util.grid.at(5, 3, 3);
		Vec3 m = util.vector.of(0, 0.1, 0);
		Vec3 spawn = util.vector.centerOf(util.grid.at(5, 3, 2));
		scene.world.createItemEntity(spawn, m, item1);
		scene.idle(12);
		scene.world.createItemOnBelt(beltPos, Direction.UP, item1);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.createItemEntity(spawn, m, item2);
		scene.idle(12);
		scene.world.createItemOnBelt(beltPos, Direction.UP, item2);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.createItemEntity(spawn, m, item3);
		scene.idle(12);
		scene.world.createItemOnBelt(beltPos, Direction.UP, item3);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(50);

		scene.world.showSectionAndMerge(util.select.position(3, 5, 2), Direction.DOWN, newBelt);

		scene.overlay.showText(80)
			.pointAt(util.vector.blockSurface(tunnelPos.above()
				.north(), Direction.WEST))
			.placeNearTarget()
			.text("For this, items can also be inserted into the Tunnel block directly");
		scene.idle(20);

		beltPos = util.grid.at(3, 3, 3);
		spawn = util.vector.centerOf(util.grid.at(3, 5, 1));
		scene.world.createItemEntity(spawn, m, item1);
		scene.idle(12);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, item1);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.createItemEntity(spawn, m, item2);
		scene.idle(12);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, item2);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.world.createItemEntity(spawn, m, item3);
		scene.idle(12);
		scene.world.createItemOnBelt(beltPos, Direction.EAST, item3);
		scene.world.modifyEntities(ItemEntity.class, Entity::discard);
		scene.idle(30);

	}

	protected static Vec3 getTunnelFilterVec(BlockPos pos, Direction d) {
		return VecHelper.getCenterOf(pos)
			.add(Vec3.atLowerCornerOf(d.getNormal())
				.scale(.5))
			.add(0, 0.3, 0);
	}

	public static void brassModes(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("brass_tunnel_modes", "Distribution Modes of the Brass Tunnel");
		scene.configureBasePlate(0, 1, 5);
		BlockState barrier = Blocks.BARRIER.defaultBlockState();
		scene.world.setBlock(util.grid.at(1, 1, 0), barrier, false);
		scene.world.showSection(util.select.layer(0), Direction.UP);
		scene.idle(5);
		scene.world.showSection(util.select.fromTo(1, 1, 1, 5, 1, 5)
			.add(util.select.fromTo(3, 2, 5, 1, 2, 5)), Direction.DOWN);
		scene.idle(10);
		for (int i = 0; i < 3; i++) {
			scene.world.showSection(util.select.position(3 - i, 2, 3), Direction.DOWN);
			scene.idle(4);
		}

		Vec3 tunnelTop = util.vector.topOf(util.grid.at(2, 2, 3));
		scene.overlay.showControls(new InputWindowElement(tunnelTop, Pointing.DOWN).rightClick(), 80);
		scene.idle(7);
		scene.overlay.showCenteredScrollInput(util.grid.at(2, 2, 3), Direction.UP, 120);
		scene.overlay.showText(120)
			.attachKeyFrame()
			.pointAt(tunnelTop)
			.placeNearTarget()
			.text("The distribution behaviour of Brass Tunnels can be configured");
		scene.idle(130);

		Class<BrassTunnelBlockEntity> tunnelClass = BrassTunnelBlockEntity.class;
		ElementLink<WorldSectionElement> blockage =
			scene.world.showIndependentSection(util.select.position(4, 1, 0), Direction.UP);
		scene.world.moveSection(blockage, util.vector.of(-3, 0, 0), 0);

		Vec3 modeVec = util.vector.of(4, 2.5, 3);
		scene.overlay.showControls(new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_SPLIT),
			140);

		ElementLink<WorldSectionElement> blockage2 = null;

		for (int i = 0; i < 32; i++) {
			if (i < 30)
				scene.world.createItemOnBelt(util.grid.at(1, 1, 5), Direction.EAST, new ItemStack(Items.SNOWBALL, 12));
			scene.idle(i > 8 ? 30 : 40);

			if (i == 0) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.pointAt(tunnelTop)
					.placeNearTarget()
					.text("'Split' will attempt to distribute the stack evenly between available outputs");
			}

			if (i == 2) {
				scene.overlay.showText(60)
					.text("If an output is unable to take more items, it will be skipped")
					.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.GREEN);
			}

			if (i == 4) {
				scene.overlay.showControls(
					new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_FORCED_SPLIT), 140);
				scene.world.modifyBlockEntity(util.grid.at(1, 2, 3), tunnelClass,
					be -> be.getBehaviour(ScrollOptionBehaviour.TYPE)
						.setValue(BrassTunnelBlockEntity.SelectionMode.FORCED_SPLIT.ordinal()));
			}

			if (i == 5) {
				scene.overlay.showText(80)
					.attachKeyFrame()
					.text("'Forced Split' will never skip outputs, and instead wait until they are free")
					.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.RED);
				scene.idle(60);
				scene.world.moveSection(blockage, util.vector.of(-1, 0, 0), 10);
				scene.world.setBlock(util.grid.at(1, 1, 0), Blocks.AIR.defaultBlockState(), false);
				scene.world.multiplyKineticSpeed(util.select.everywhere(), 1.5f);
			}

			if (i == 7) {
				scene.world.modifyBlockEntity(util.grid.at(1, 2, 3), tunnelClass,
					be -> be.getBehaviour(ScrollOptionBehaviour.TYPE)
						.setValue(BrassTunnelBlockEntity.SelectionMode.ROUND_ROBIN.ordinal()));
				scene.overlay.showControls(
					new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_ROUND_ROBIN), 140);
				scene.overlay.showText(80)
					.attachKeyFrame()
					.pointAt(tunnelTop)
					.placeNearTarget()
					.text("'Round Robin' keeps stacks whole, and cycles through outputs iteratively");
			}

			if (i == 7) {
				scene.world.moveSection(blockage, util.vector.of(1, 0, 0), 10);
				scene.world.setBlock(util.grid.at(1, 1, 0), barrier, false);
			}

			if (i == 13) {
				scene.overlay.showText(60)
					.text("Once Again, if an output is unable to take more items, it will be skipped")
					.placeNearTarget()
					.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
					.colored(PonderPalette.GREEN);
			}

			if (i == 15) {
				scene.overlay.showControls(
					new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_FORCED_ROUND_ROBIN), 140);
				scene.world.modifyBlockEntity(util.grid.at(1, 2, 3), tunnelClass,
					be -> be.getBehaviour(ScrollOptionBehaviour.TYPE)
						.setValue(BrassTunnelBlockEntity.SelectionMode.FORCED_ROUND_ROBIN.ordinal()));
			}

			if (i == 16) {
				scene.overlay.showText(50)
					.attachKeyFrame()
					.placeNearTarget()
					.text("'Forced Round Robin' never skips outputs")
					.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
					.colored(PonderPalette.RED);
				scene.idle(30);
				scene.world.moveSection(blockage, util.vector.of(-1, 0, 0), 10);
				scene.world.setBlock(util.grid.at(1, 1, 0), Blocks.AIR.defaultBlockState(), false);
			}

			if (i == 19) {
				scene.overlay.showControls(
					new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_PREFER_NEAREST), 140);
				scene.world.modifyBlockEntity(util.grid.at(1, 2, 3), tunnelClass,
					be -> be.getBehaviour(ScrollOptionBehaviour.TYPE)
						.setValue(BrassTunnelBlockEntity.SelectionMode.PREFER_NEAREST.ordinal()));
				scene.world.moveSection(blockage, util.vector.of(1, 0, 0), 10);
				scene.world.setBlock(util.grid.at(1, 1, 0), barrier, false);
				scene.overlay.showText(70)
					.attachKeyFrame()
					.text("'Prefer Nearest' prioritizes the outputs closest to the items' input location")
					.pointAt(util.vector.blockSurface(util.grid.at(1, 1, 2), Direction.UP))
					.placeNearTarget()
					.colored(PonderPalette.GREEN);
			}

			if (i == 21) {
				scene.world.setBlock(util.grid.at(2, 1, 0), Blocks.BARRIER.defaultBlockState(), false);
				blockage2 = scene.world.showIndependentSection(util.select.position(4, 1, 0), Direction.UP);
				scene.world.moveSection(blockage2, util.vector.of(-2, 0, 0), 0);
			}

			if (i == 25) {
				scene.world.hideIndependentSection(blockage, Direction.DOWN);
				scene.world.setBlock(util.grid.at(1, 1, 0), Blocks.AIR.defaultBlockState(), false);
				scene.world.hideIndependentSection(blockage2, Direction.DOWN);
				scene.world.setBlock(util.grid.at(2, 1, 0), Blocks.AIR.defaultBlockState(), false);
			}

			if (i == 26) {
				scene.overlay.showControls(
					new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_RANDOMIZE), 140);
				scene.world.modifyBlockEntity(util.grid.at(1, 2, 3), tunnelClass,
					be -> be.getBehaviour(ScrollOptionBehaviour.TYPE)
						.setValue(BrassTunnelBlockEntity.SelectionMode.RANDOMIZE.ordinal()));
			}

			if (i == 27) {
				scene.overlay.showText(70)
					.attachKeyFrame()
					.text("'Randomize' will distribute whole stacks to randomly picked outputs")
					.pointAt(tunnelTop)
					.placeNearTarget();
			}
		}

		scene.world.hideSection(util.select.fromTo(3, 2, 5, 1, 2, 5), Direction.UP);
		scene.idle(10);
		scene.overlay
			.showControls(new InputWindowElement(modeVec, Pointing.RIGHT).showing(AllIcons.I_TUNNEL_SYNCHRONIZE), 140);
		scene.world.modifyBlockEntity(util.grid.at(1, 2, 3), tunnelClass,
			be -> be.getBehaviour(ScrollOptionBehaviour.TYPE)
				.setValue(BrassTunnelBlockEntity.SelectionMode.SYNCHRONIZE.ordinal()));
		scene.idle(30);
		scene.overlay.showText(70)
			.attachKeyFrame()
			.text("'Synchronize Inputs' is a unique setting for Brass Tunnels")
			.pointAt(tunnelTop)
			.placeNearTarget();

		ItemStack item1 = new ItemStack(Items.CARROT);
		ItemStack item2 = new ItemStack(Items.HONEY_BOTTLE);
		ItemStack item3 = AllItems.POLISHED_ROSE_QUARTZ.asStack();

		scene.world.createItemOnBelt(util.grid.at(3, 1, 4), Direction.UP, item1);
		scene.world.createItemOnBelt(util.grid.at(2, 1, 4), Direction.UP, item2);
		scene.world.createItemOnBelt(util.grid.at(3, 1, 5), Direction.SOUTH, item1);
		scene.world.createItemOnBelt(util.grid.at(2, 1, 5), Direction.SOUTH, item2);

		scene.idle(80);
		scene.world.createItemOnBelt(util.grid.at(2, 1, 5), Direction.SOUTH, item2);
		scene.rotateCameraY(-90);
		scene.idle(20);
		scene.world.multiplyKineticSpeed(util.select.everywhere(), .5f);

		scene.overlay.showText(70)
			.text("Items are only allowed past if every tunnel in the group has one waiting")
			.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 4), Direction.UP))
			.placeNearTarget()
			.colored(PonderPalette.OUTPUT);
		scene.idle(60);
		scene.world.createItemOnBelt(util.grid.at(1, 1, 5), Direction.SOUTH, item3);
		scene.idle(90);
		scene.rotateCameraY(90);

		scene.overlay.showText(100)
			.text("This ensures that all affected belts supply items at the same rate")
			.pointAt(util.vector.blockSurface(util.grid.at(1, 2, 3), Direction.WEST))
			.placeNearTarget()
			.colored(PonderPalette.GREEN);
	}

}
//文件SharedText.java
package com.simibubi.create.infrastructure.ponder;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.ponder.PonderLocalization;

public class SharedText {
	public static void gatherText() {
		// Add entries used across several ponder scenes (Safe for hotswap)

		add("sneak_and", "Sneak +");
		add("ctrl_and", "Ctrl +");

		add("rpm8", "8 RPM");
		add("rpm16", "16 RPM");
		add("rpm16_source", "Source: 16 RPM");
		add("rpm32", "32 RPM");

		add("movement_anchors", "With the help of Super Glue, larger structures can be moved");
		add("behaviour_modify_value_panel", "This behaviour can be modified using the value panel");
		add("storage_on_contraption", "Inventories attached to the Contraption will pick up their drops automatically");
	}

	private static void add(String k, String v) {
		PonderLocalization.registerShared(Create.asResource(k), v);
	}
}
