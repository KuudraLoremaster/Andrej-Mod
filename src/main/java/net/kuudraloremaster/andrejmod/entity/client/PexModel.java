package net.kuudraloremaster.andrejmod.entity.client;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kuudraloremaster.andrejmod.entity.animations.ModAnimationDefinitions;
import net.kuudraloremaster.andrejmod.entity.custom.PexEntity;
import net.kuudraloremaster.andrejmod.entity.custom.RhinoEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PexModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart Pex;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart chest;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart head;

	public PexModel(ModelPart root) {
		this.Pex = root.getChild("Pex");
		this.left_leg = Pex.getChild("left_leg");
		this.right_leg = Pex.getChild("right_leg");
		this.body = Pex.getChild("body");
		this.chest = body.getChild("chest");
		this.left_arm = body.getChild("left_arm");
		this.right_arm = body.getChild("right_arm");
		this.head = Pex.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Pex = partdefinition.addOrReplaceChild("Pex", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = Pex.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(30, 0).addBox(-4.0F, -7.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = Pex.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(30, 0).addBox(-8.0F, -7.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 0.0F));

		PartDefinition body = Pex.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -21.0F, -1.0F, 8.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 53).addBox(-9.0F, -18.0F, -1.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(15, 36).addBox(-9.0F, -18.0F, -1.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, 0.0F));

		PartDefinition head = Pex.addOrReplaceChild("head", CubeListBuilder.create().texOffs(23, 17).addBox(-5.0F, -29.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.animate(((PexEntity) entity).idleAnimationState, ModAnimationDefinitions.PEXIDLE, ageInTicks, 1f);
	this.animateWalk(ModAnimationDefinitions.PEXWALK, limbSwing, limbSwingAmount, 2f, 1f);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Pex.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Pex;
	}
}