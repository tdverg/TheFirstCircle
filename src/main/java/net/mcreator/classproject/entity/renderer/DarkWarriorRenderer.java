package net.mcreator.classproject.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.classproject.entity.DarkWarriorEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DarkWarriorRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DarkWarriorEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelDarkWarrior(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("classproject:textures/darkwarrior.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelDarkWarrior extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftArm;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer Head;
		public ModelDarkWarrior() {
			textureWidth = 64;
			textureHeight = 64;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(Body, 0.0F, -1.5708F, 0.0F);
			Body.setTextureOffset(0, 0).addBox(-4.5F, -29.0F, -4.5F, 9.0F, 17.0F, 11.0F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(RightArm);
			RightArm.setTextureOffset(37, 45).addBox(-1.5F, -27.0F, 6.0F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(RightLeg);
			RightLeg.setTextureOffset(40, 30).addBox(-1.5F, -12.0F, 1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(LeftArm);
			LeftArm.setTextureOffset(40, 15).addBox(-1.5F, -27.0F, -7.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(LeftLeg);
			LeftLeg.setTextureOffset(40, 0).addBox(-1.5F, -12.0F, -3.0F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(Head);
			Head.setTextureOffset(0, 28).addBox(-7.5F, -36.5F, -4.5F, 9.0F, 8.0F, 11.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
