
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
public class DarkSwordItem extends ClassprojectModElements.ModElement {
	@ObjectHolder("classproject:dark_sword")
	public static final Item block = null;
	public DarkSwordItem(ClassprojectModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ShardOfDarknessItem.block));
			}
		}, 3, -3f, new Item.Properties().group(LimboItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("dark_sword"));
	}
}
