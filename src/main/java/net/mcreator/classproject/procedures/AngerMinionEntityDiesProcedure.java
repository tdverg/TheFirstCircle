/*
 * Ian Stamper, Carson Sitter, Terrell Vergith
 * October 14th, 2021
 * CIS 293: Advanced Technologies
 * The First Circle: A Minecraft Mod that adds a new dimension with new resources, obstacles, and restrictions.
 * 
 * Filename: AngerMinionEntityDiesProcedure.java
 */

package net.mcreator.classproject.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.classproject.item.ShardOfDarknessItem;
import net.mcreator.classproject.ClassprojectMod;

import java.util.Map;

public class AngerMinionEntityDiesProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency x for procedure AngerMinionEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency y for procedure AngerMinionEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency z for procedure AngerMinionEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency world for procedure AngerMinionEntityDies!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double random1 = 0;
		double random2 = 0;
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("You will never escape this realm."), ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		random1 = (double) Math.random();
		if ((random1 >= 0.99)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
						new ItemStack(ShardOfDarknessItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
						new ItemStack(ShardOfDarknessItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
						new ItemStack(ShardOfDarknessItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		} else if ((random1 >= 0.75)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
						new ItemStack(ShardOfDarknessItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
						new ItemStack(ShardOfDarknessItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		} else if ((random1 >= 0.5)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
						new ItemStack(ShardOfDarknessItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		}
		random2 = (double) Math.random();
		if ((random2 >= 0.99)) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
			}
		}
	}
}
