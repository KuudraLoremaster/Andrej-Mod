package net.kuudraloremaster.andrejmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.custom.GoonerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoonerRenderer extends MobRenderer<GoonerEntity, GoonerModel<GoonerEntity>> {
    public GoonerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GoonerModel<>(pContext.bakeLayer(ModModelLayers.GOONER_LAYER)), 2);
    }

    @Override
    public ResourceLocation getTextureLocation(GoonerEntity goonerEntity) {
        return new ResourceLocation(AndrejMod.MOD_ID, "textures/entity/gooner.png");
    }

    @Override
    public void render(GoonerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
