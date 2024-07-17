package net.kuudraloremaster.andrejmod.entity.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.custom.HollowPurpleEntity;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.Pointer;
import team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry;
import team.lodestar.lodestone.registry.client.LodestoneShaderRegistry;
import team.lodestar.lodestone.systems.particle.render_types.LodestoneWorldParticleRenderType;
import team.lodestar.lodestone.systems.rendering.LodestoneRenderType;
import team.lodestar.lodestone.systems.rendering.StateShards;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;
import team.lodestar.lodestone.systems.rendering.rendeertype.RenderTypeProvider;
import team.lodestar.lodestone.systems.rendering.shader.ShaderHolder;

import java.awt.*;

import static com.mojang.blaze3d.vertex.VertexFormat.Mode.QUADS;
import static com.mojang.blaze3d.vertex.VertexFormat.Mode.TRIANGLES;
import static net.kuudraloremaster.andrejmod.worldgen.dimension.ModDimensions.INFINITEVOID_LEVEL_KEY;
import static net.minecraft.client.renderer.RenderType.CompositeState.builder;
import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.*;


public class HollowPurpleRenderer extends EntityRenderer<HollowPurpleEntity> {
//    public HollowPurpleRenderer(EntityRendererProvider.Context context) {
//        super(context);
//    }
////    the dude that got it to work code
////    public static final Identifier DEFAULT_SKIN_LOCATION = new Identifier(GalacticCuriosities.MOD_ID,"textures/dripstone.png");
////    public static final LodestoneRenderType RENDER_TYPE = createGenericRenderType("additive_block",VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.TRIANGLES, builder().setShaderState(POSITION_TEXTURE_SHADER).setTransparencyState(StateShards.NO_TRANSPARENCY).setTextureState(DEFAULT_SKIN_LOCATIONS));
////    public void render(PlanetEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
////        VFXBuilders.createWorld().setColor(new Color(100,200,200)).setAlpha(1F).setRenderType(RENDER_TYPE).renderSphere( matrices, 10,50,50);
////    }
//    public static final ResourceLocation DEFAULT_SKIN_LOCATION = new ResourceLocation(AndrejMod.MOD_ID,"block/mod_portal");
//    public static final LodestoneRenderType RENDER_TYPE =
//            createGenericRenderType("additive_block", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.TRIANGLES,
//                    LodestoneRenderTypeRegistry.builder()
//                    .setShaderState(LodestoneShaderRegistry.TRIANGLE_TEXTURE)
//                    .setTransparencyState(StateShards.NORMAL_TRANSPARENCY)
//                    .setTextureState(DEFAULT_SKIN_LOCATION));
//    // LodestoneCompositeStateBuilder
//    public static final RenderType renderer =
//            RenderType.create("additive_block", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.TRIANGLES, 2097152, false, false,
//                    builder().setShaderState(LodestoneShaderRegistry.TRIANGLE_TEXTURE.getShard()).setTransparencyState(StateShards.NORMAL_TRANSPARENCY).setTextureState(new TextureStateShard(DEFAULT_SKIN_LOCATION,false, false)).createCompositeState(true));
//    public void render(HollowPurpleEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
//
//
//        VertexConsumer buffer = bufferSource.getBuffer(RenderType.solid());
//        poseStack.pushPose();
////        poseStack.translate(entity.getX(), entity.getY(), entity.getZ());
//        VFXBuilders.WorldVFXBuilder builder = VFXBuilders.createWorld();
//        builder.setColor(Color.PINK)
//                .setLight(light)
//                .setRenderType(RENDER_TYPE)
//                .setAlpha(1.0F)
//                .renderSphere(poseStack, 30, 20,20);
//
//        poseStack.popPose();
//        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, light);
//    }
//    @Override
//    public ResourceLocation getTextureLocation(HollowPurpleEntity entity) {
//        return DEFAULT_SKIN_LOCATION;
//    }
//
//    @Override
//    public boolean shouldRender(HollowPurpleEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
//        return true;
//    }
public static final ResourceLocation DEFAULT_SKIN_LOCATION = new ResourceLocation(AndrejMod.MOD_ID,"textures/object/white.png");

    protected static final RenderStateShard.CullStateShard NO_CULL = new RenderStateShard.CullStateShard(false);
    protected static final RenderStateShard.TransparencyStateShard NO_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("no_transparency", () -> {
        RenderSystem.disableBlend();
    }, () -> {
    });
    protected static final RenderStateShard.TransparencyStateShard TRANSLUCENT_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("translucent_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });
    public static final LodestoneRenderType TEX =
            createGenericRenderType(
                    "tex", DefaultVertexFormat.POSITION_COLOR_TEX, TRIANGLES, new RenderStateShard.ShaderStateShard(GameRenderer::getPositionColorTexLightmapShader), TRANSLUCENT_TRANSPARENCY,
                    new TextureStateShard(DEFAULT_SKIN_LOCATION, false, false), NO_CULL);
    public HollowPurpleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }
        public static final LodestoneRenderType RENDER_TYPE =
            createGenericRenderType("additive_block", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.TRIANGLES,
                    LodestoneRenderTypeRegistry.builder()
                    .setShaderState(LodestoneShaderRegistry.TRIANGLE_TEXTURE)
                    .setTransparencyState(StateShards.NORMAL_TRANSPARENCY)
                    .setTextureState(DEFAULT_SKIN_LOCATION));
    @Override
    public ResourceLocation getTextureLocation(HollowPurpleEntity pEntity) {
        return DEFAULT_SKIN_LOCATION;
    }
    @Override
    public void render(@NotNull HollowPurpleEntity pEntity, float pEntityYaw, float pPartialTick, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.getCommandSenderWorld().dimension() == INFINITEVOID_LEVEL_KEY) {
            pPoseStack.scale(2,2,2);
            VFXBuilders.createWorld().setColor(new Color(192,74,219)).setAlpha(1F).setRenderType(TEX).renderSphere(pPoseStack, 10,20,20);
            VFXBuilders.createWorld().setColor(new Color(255, 255, 255)).setAlpha(1F).setRenderType(TEX).renderSphere(pPoseStack, 5,10,10);
            return;
        }
        VFXBuilders.createWorld().setColor(new Color(192,74,219)).setAlpha(1F).setRenderType(TEX).renderSphere(pPoseStack, 4,20,20);
        VFXBuilders.createWorld().setColor(new Color(255, 255, 255)).setAlpha(1F).setRenderType(TEX).renderSphere(pPoseStack, 2,10,10);


    }

}
