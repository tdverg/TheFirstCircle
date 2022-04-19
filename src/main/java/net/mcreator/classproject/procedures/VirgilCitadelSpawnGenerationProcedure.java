/*
 * Ian Stamper, Carson Sitter, Terrell Vergith
 * October 14th, 2021
 * CIS 293: Advanced Technologies
 * The First Circle: A Minecraft Mod that adds a new dimension with new resources, obstacles, and restrictions.
 * 
 * Filename: VirgilCitadelSpawnGenerationProcedure.java
 */

package net.mcreator.classproject.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.classproject.entity.VirgilEntity;
import net.mcreator.classproject.ClassprojectMod;

import java.util.Map;

public class VirgilCitadelSpawnGenerationProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency x for procedure VirgilCitadelSpawnGeneration!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency y for procedure VirgilCitadelSpawnGeneration!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency z for procedure VirgilCitadelSpawnGeneration!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency world for procedure VirgilCitadelSpawnGeneration!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new VirgilEntity.CustomEntity(VirgilEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if (world instanceof ServerWorld) {
			Template template = ((ServerWorld) world).getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("classproject", "citadeloflimbus"));
			if (template != null) {
				template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) y, (int) z),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
						((World) world).rand);
			}
		}
	}
}
