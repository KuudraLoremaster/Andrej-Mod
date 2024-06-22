package net.kuudraloremaster.andrejmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.custom.PexEntity;
import net.kuudraloremaster.andrejmod.entity.custom.RaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RaRenderer extends MobRenderer<RaEntity, RaModel<RaEntity>> {
    public RaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RaModel<RaEntity>(pContext.bakeLayer(ModModelLayers.RA_LAYER)), 2);
    }

    @Override
    public ResourceLocation getTextureLocation(RaEntity raEntity) {
        return new ResourceLocation(AndrejMod.MOD_ID, "textures/entity/ra.png");
    }

    @Override
    public void render(RaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
