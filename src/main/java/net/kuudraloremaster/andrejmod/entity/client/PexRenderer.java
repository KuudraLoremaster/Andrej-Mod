package net.kuudraloremaster.andrejmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.custom.PexEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PexRenderer extends MobRenderer<PexEntity, PexModel<PexEntity>> {
    public PexRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PexModel<>(pContext.bakeLayer(ModModelLayers.PEX_LAYER)), 2);
    }

    @Override
    public ResourceLocation getTextureLocation(PexEntity pexEntity) {
        return new ResourceLocation(AndrejMod.MOD_ID, "textures/entity/pex.png");
    }

    @Override
    public void render(PexEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
