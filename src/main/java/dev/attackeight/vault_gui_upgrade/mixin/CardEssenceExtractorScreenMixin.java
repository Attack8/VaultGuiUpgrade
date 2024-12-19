package dev.attackeight.vault_gui_upgrade.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.attackeight.vault_gui_upgrade.ChangingTextureAtlasElement;
import dev.attackeight.vault_gui_upgrade.MoreScreenTextures;
import dev.attackeight.vault_gui_upgrade.VaultGuiUpgrade;
import iskallia.vault.client.gui.framework.ScreenTextures;
import iskallia.vault.client.gui.framework.spatial.Spatials;
import iskallia.vault.client.gui.screen.block.CardEssenceExtractorScreen;
import iskallia.vault.container.inventory.CardEssenceExtractorContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CardEssenceExtractorScreen.class, remap = false)
public class CardEssenceExtractorScreenMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addCardTumble(CardEssenceExtractorContainer container, Inventory inventory, Component title, CallbackInfo ci) {
        AbstractElementContainerScreenAccessor cs = (AbstractElementContainerScreenAccessor) this;
        cs.getElementStore().addElement(new ChangingTextureAtlasElement(
                Spatials.positionXY(42, 33),
                MoreScreenTextures.TUMBLE_1,
                MoreScreenTextures.TUMBLE_2,
                MoreScreenTextures.TUMBLE_3,
                MoreScreenTextures.TUMBLE_4
        ).layout((screen, gui, parent, world) -> {
            world.translateXY(gui);
        }));
    }

    @Inject(method = "render", at = @At("HEAD"), remap = true)
    private void renderCardTumble(PoseStack poseStack, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        AbstractElementContainerScreenAccessor cs = (AbstractElementContainerScreenAccessor) this;
        float progress = ((CardEssenceExtractorScreen) (Object) this).getMenu().getTileEntity().getExtractProgress();
        int state = -1;
        if (progress > 0.0) state = 0;
        if (progress > 0.25) state = 1;
        if (progress > 0.5) state = 2;
        if (progress > 0.75) state = 3;

        ((ChangingTextureAtlasElement) cs.getElementStore().getRenderedElementList().get(cs.getElementStore().getRenderedElementList().size() - 1)).setState(state);
    }
}
