
package net.mcreator.classproject.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.classproject.itemgroup.LimboItemGroup;
import net.mcreator.classproject.ClassprojectModElements;

@ClassprojectModElements.ModElement.Tag
public class ScytheItem extends ClassprojectModElements.ModElement {
	@ObjectHolder("classproject:scythe")
	public static final Item block = null;
	public ScytheItem(ClassprojectModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ShardOfDarknessItem.block));
			}
		}, 3, -2f, new Item.Properties().group(LimboItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("scythe"));
	}
}
