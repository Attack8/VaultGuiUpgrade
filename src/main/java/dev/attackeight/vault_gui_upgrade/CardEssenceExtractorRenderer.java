package dev.attackeight.vault_gui_upgrade;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import iskallia.vault.block.BlackMarketBlock;
import iskallia.vault.block.entity.CardEssenceExtractorTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CardEssenceExtractorRenderer implements BlockEntityRenderer<CardEssenceExtractorTileEntity> {
    public CardEssenceExtractorRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(CardEssenceExtractorTileEntity cardEssenceTile, float partialTicks, @NotNull PoseStack matrixStack, @NotNull MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Level world = cardEssenceTile.getLevel();
        if (world != null) {
            Direction dir = cardEssenceTile.getBlockState().getValue(BlackMarketBlock.FACING);
            ItemStack toRender = cardEssenceTile.getEssenceInputStack();
            if (toRender != ItemStack.EMPTY) {
                Minecraft minecraft = Minecraft.getInstance();
                float scale = 0.35f;
                matrixStack.pushPose();
                matrixStack.pushPose();
                BakedModel bakedModel = minecraft.getItemRenderer().getModel(toRender, null, null, 0);
                matrixStack.mulPose(Vector3f.YN.rotationDegrees(90));
                double yOffset = cardEssenceTile.getExtractProgress() * 0.4;
                matrixStack.translate(0.75, 1.1 - yOffset, -0.52);
                matrixStack.scale(scale, scale, scale);
                int rot = 0;
                if (dir == Direction.WEST) {
                    rot = 90;
                }

                if (dir == Direction.SOUTH) {
                    rot = 180;
                }

                if (dir == Direction.EAST) {
                    rot = 270;
                }

                matrixStack.mulPose(Vector3f.YP.rotationDegrees((float) rot));
                if (dir == Direction.WEST) {
                    matrixStack.translate(0.7, 0.0, -0.8);
                }
                if (dir == Direction.EAST) {
                    matrixStack.translate(0.8, 0.0, 0.7);
                }
                if (dir == Direction.SOUTH) {
                    matrixStack.translate(1.45, 0.0, -0.1);
                }
                minecraft.getItemRenderer().render(toRender, ItemTransforms.TransformType.FIXED, true, matrixStack, buffer, combinedLight, combinedOverlay, bakedModel);
                matrixStack.popPose();
                matrixStack.popPose();
            }
        }
    }
}
