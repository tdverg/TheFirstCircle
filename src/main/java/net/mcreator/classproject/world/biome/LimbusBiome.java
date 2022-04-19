
package net.mcreator.classproject.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.classproject.block.LimbgrassBlock;
import net.mcreator.classproject.block.LimbdirtBlock;
import net.mcreator.classproject.ClassprojectModElements;

@ClassprojectModElements.ModElement.Tag
public class LimbusBiome extends ClassprojectModElements.ModElement {
	public static Biome biome;
	public LimbusBiome(ClassprojectModElements instance) {
		super(instance, 21);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-13068699).setWaterColor(-11013497).setWaterFogColor(-11311026)
						.withSkyColor(-13068699).withFoliageColor(-7566196).withGrassColor(-9700030)
						.setParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.1f)).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(LimbgrassBlock.block.getDefaultState(),
								LimbdirtBlock.block.getDefaultState(), LimbdirtBlock.block.getDefaultState())));
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0.1f).scale(0.2f).temperature(0.5f)
						.downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("classproject:limbus"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
