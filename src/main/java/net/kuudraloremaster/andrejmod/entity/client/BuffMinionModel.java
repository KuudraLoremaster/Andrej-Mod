package net.kuudraloremaster.andrejmod.entity.client;// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kuudraloremaster.andrejmod.entity.animations.ModAnimationDefinitions;
import net.kuudraloremaster.andrejmod.entity.custom.BuffMinionEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class BuffMinionModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("andrejmod", "buffminion"), "main");
	private final ModelPart Buffminion;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart torso;
	private final ModelPart abs;
	private final ModelPart pecs;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart head;
	private final ModelPart goggle;

	public BuffMinionModel(ModelPart root) {
		this.Buffminion = root.getChild("Buffminion");
		this.left_leg = Buffminion.getChild("left_leg");
		this.right_leg = Buffminion.getChild("right_leg");
		this.torso = Buffminion.getChild("torso");
		this.abs = torso.getChild("abs");
		this.pecs = torso.getChild("pecs");
		this.left_arm = torso.getChild("left_arm");
		this.right_arm = torso.getChild("right_arm");
		this.head = Buffminion.getChild("head");
		this.goggle = head.getChild("goggle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Buffminion = partdefinition.addOrReplaceChild("Buffminion", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = Buffminion.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -11.0F, -19.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = Buffminion.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -11.0F, -7.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 19.0F));

		PartDefinition torso = Buffminion.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 86).addBox(-5.0F, -55.0F, -20.0F, 14.0F, 44.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition abs = torso.addOrReplaceChild("abs", CubeListBuilder.create().texOffs(142, 20).addBox(-1.0F, -35.0F, -15.0F, 14.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(104, 141).addBox(-1.0F, -28.0F, -15.0F, 14.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(138, 76).addBox(-1.0F, -35.0F, 2.0F, 14.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(104, 126).addBox(-1.0F, -28.0F, 2.0F, 14.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(104, 126).addBox(-1.0F, -21.0F, 2.0F, 14.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(104, 126).addBox(-1.0F, -21.0F, -15.0F, 14.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pecs = torso.addOrReplaceChild("pecs", CubeListBuilder.create().texOffs(108, 0).addBox(-1.0F, -47.0F, -16.0F, 15.0F, 7.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(108, 0).addBox(-1.0F, -47.0F, 1.0F, 15.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(104, 86).addBox(-1.0F, -48.0F, -32.0F, 11.0F, 28.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(104, 86).addBox(-1.0F, -48.0F, -32.0F, 11.0F, 28.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 49.0F));

		PartDefinition head = Buffminion.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 176).addBox(-12.0F, -107.0F, -15.0F, 32.0F, 52.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition goggle = head.addOrReplaceChild("goggle", CubeListBuilder.create().texOffs(163, 232).addBox(19.0F, -96.0F, -10.0F, 11.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.WalkAnimation, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((BuffMinionEntity) entity).idleAnimationState, ModAnimationDefinitions.IdleAnimation, ageInTicks, 1f);
		this.animate(((BuffMinionEntity) entity).attackAnimationState, ModAnimationDefinitions.AttackAnimation, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Buffminion.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart root() {
		return Buffminion;
	}
}