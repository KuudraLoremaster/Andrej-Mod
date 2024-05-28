package net.kuudraloremaster.andrejmod.entity.client;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kuudraloremaster.andrejmod.entity.animations.ModAnimationDefinitions;
import net.kuudraloremaster.andrejmod.entity.custom.GoonerEntity;
import net.kuudraloremaster.andrejmod.entity.custom.RhinoEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GoonerModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart Gooner;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart skull;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public GoonerModel(ModelPart root) {
		this.Gooner = root.getChild("Gooner");
		this.body = root.getChild("Gooner").getChild("body");
		this.torso = root.getChild("Gooner").getChild("body").getChild("torso");
		this.skull = root.getChild("Gooner").getChild("body").getChild("torso").getChild("skull");
		this.left_arm = root.getChild("Gooner").getChild("body").getChild("torso").getChild("left_arm");
		this.right_arm = root.getChild("Gooner").getChild("body").getChild("torso").getChild("right_arm");
		this.left_leg = root.getChild("Gooner").getChild("body").getChild("left_leg");
		this.right_leg = root.getChild("Gooner").getChild("body").getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Gooner = partdefinition.addOrReplaceChild("Gooner", CubeListBuilder.create(), PartPose.offset(-5.0F, 24.0F, 0.0F));

		PartDefinition body = Gooner.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -19.0F, -15.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition skull = torso.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 32).addBox(-7.0F, -28.1F, -10.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(36, 32).addBox(-20.0F, -18.0F, -9.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 32).addBox(8.0F, -18.0F, -9.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 52).addBox(-10.0F, -9.0F, -9.0F, 5.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 52).addBox(-7.0F, -9.0F, -9.0F, 5.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.GOONERWALKANIMATION, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((GoonerEntity) entity).idleAnimationState, ModAnimationDefinitions.GOONER_IDLE_ANIMATION, ageInTicks, 1f);
        this.animate(((GoonerEntity) entity).attackAnimationState, ModAnimationDefinitions.GoonerAttackAnimation, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.skull.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.skull.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Gooner.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Gooner;
	}
}