
package net.mcreator.classproject.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.classproject.itemgroup.LimboItemGroup;
import net.mcreator.classproject.ClassprojectModElements;

@ClassprojectModElements.ModElement.Tag
public class ShardOfDarknessItem extends ClassprojectModElements.ModElement {
	@ObjectHolder("classproject:shard_of_darkness")
	public static final Item block = null;
	public ShardOfDarknessItem(ClassprojectModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LimboItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("shard_of_darkness");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
