package net.kuudraloremaster.andrejmod.entity.client;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kuudraloremaster.andrejmod.entity.animations.ModAnimationDefinitions;
import net.kuudraloremaster.andrejmod.entity.custom.RaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class RaModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart Ra;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart torso;
	private final ModelPart head;

	public RaModel(ModelPart root) {
		this.Ra = root.getChild("Ra");
		this.left_leg = Ra.getChild("left_leg");
		this.right_leg = Ra.getChild("right_leg");
		this.right_arm = Ra.getChild("right_arm");
		this.left_arm = Ra.getChild("left_arm");
		this.torso = Ra.getChild("torso");
		this.head = Ra.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Ra = partdefinition.addOrReplaceChild("Ra", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = Ra.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(30, 13).addBox(4.0F, -7.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = Ra.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(18, 21).addBox(-5.0F, -7.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = Ra.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 25).addBox(8.0F, -14.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = Ra.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(30, 29).addBox(-11.0F, -14.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = Ra.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -15.0F, -4.0F, 15.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = Ra.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -22.0F, -4.0F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(-1.0F, -19.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.RaWalkAnimation, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((RaEntity) entity).idleAnimationState, ModAnimationDefinitions.RaIdleAnimation, ageInTicks, 1f);
		this.animate(((RaEntity) entity).attackAnimationState, ModAnimationDefinitions.RaAttackAnimation, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Ra.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Ra;
	}
}