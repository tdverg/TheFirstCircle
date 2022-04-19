/*
 * Ian Stamper, Carson Sitter, Terrell Vergith
 * October 14th, 2021
 * CIS 293: Advanced Technologies
 * The First Circle: A Minecraft Mod that adds a new dimension with new resources, obstacles, and restrictions.
 * 
 * Filename: FelFireEntityCollidesInTheBlockProcedure.java
 */

package net.mcreator.classproject.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.classproject.ClassprojectMod;

import java.util.Map;

public class FelFireEntityCollidesInTheBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ClassprojectMod.LOGGER.warn("Failed to load dependency entity for procedure FelFireEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
		entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 3);
	}
}
