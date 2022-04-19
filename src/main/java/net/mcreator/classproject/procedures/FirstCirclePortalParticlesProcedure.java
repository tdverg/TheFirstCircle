/*
 * Ian Stamper, Carson Sitter, Terrell Vergith
 * October 14th, 2021
 * CIS 293: Advanced Technologies
 * The First Circle: A Minecraft Mod that adds a new dimension with new resources, obstacles, and restrictions.
 * 
 * Filename: FirstCirclePortalParticlesProcedure.java
 */

package net.mcreator.classproject.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.classproject.ClassprojectMod;

import java.util.Map;

public class FirstCirclePortalParticlesProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency x for procedure FirstCirclePortalParticles!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency y for procedure FirstCirclePortalParticles!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency z for procedure FirstCirclePortalParticles!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency world for procedure FirstCirclePortalParticles!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, (int) 5, 1, 2, 1, 0.1);
		}
	}
}
