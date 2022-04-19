/*
 * Ian Stamper, Carson Sitter, Terrell Vergith
 * October 14th, 2021
 * CIS 293: Advanced Technologies
 * The First Circle: A Minecraft Mod that adds a new dimension with new resources, obstacles, and restrictions.
 * 
 * Filename: PlayerWeaponParticleEffectsProcedure.java
 */

package net.mcreator.classproject.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.classproject.item.ScytheItem;
import net.mcreator.classproject.item.DarkSwordItem;
import net.mcreator.classproject.ClassprojectMod;

import java.util.Map;
import java.util.HashMap;

public class PlayerWeaponParticleEffectsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerWeaponParticleEffects!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency x for procedure PlayerWeaponParticleEffects!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency y for procedure PlayerWeaponParticleEffects!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency z for procedure PlayerWeaponParticleEffects!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency world for procedure PlayerWeaponParticleEffects!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ScytheItem.block)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SOUL, x, y, z, (int) 1, 0.3, 1, 0.3, 0.1);
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == DarkSwordItem.block)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, x, y, z, (int) 3, 0.3, 1, 0.3, 1);
			}
		}
	}
}
