package dev.attackeight.vault_gui_upgrade.mixin;

import dev.attackeight.vault_gui_upgrade.CardEssenceExtractorRenderer;
import iskallia.vault.block.entity.CardEssenceExtractorTileEntity;
import iskallia.vault.init.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModBlocks.class, remap = false)
public class ModBlocksMixin {

    @Shadow @Final public static BlockEntityType<CardEssenceExtractorTileEntity> CARD_ESSENCE_EXTRACTOR_TILE_ENTITY;

    @Inject(method = "registerTileEntityRenderers", at = @At("TAIL"))
    private static void addEssenceExtractorBER(EntityRenderersEvent.RegisterRenderers event, CallbackInfo ci) {
        event.registerBlockEntityRenderer(CARD_ESSENCE_EXTRACTOR_TILE_ENTITY, CardEssenceExtractorRenderer::new);
    }
}
