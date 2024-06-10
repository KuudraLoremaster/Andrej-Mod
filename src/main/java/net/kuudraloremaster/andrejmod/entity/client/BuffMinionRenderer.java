package net.kuudraloremaster.andrejmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.custom.BuffMinionEntity;
import net.kuudraloremaster.andrejmod.entity.custom.GoonerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BuffMinionRenderer extends MobRenderer<BuffMinionEntity, BuffMinionModel<BuffMinionEntity>> {
    public BuffMinionRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BuffMinionModel<>(pContext.bakeLayer(ModModelLayers.BUFF_LAYER)), 2);
    }

    @Override
    public ResourceLocation getTextureLocation(BuffMinionEntity buffMinionEntity) {
        return new ResourceLocation(AndrejMod.MOD_ID, "textures/entity/buff_minion.png");
    }

    @Override
    public void render(BuffMinionEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
