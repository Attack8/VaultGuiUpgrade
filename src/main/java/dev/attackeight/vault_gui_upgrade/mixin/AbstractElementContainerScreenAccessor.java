package dev.attackeight.vault_gui_upgrade.mixin;

import iskallia.vault.client.gui.framework.element.spi.ElementStore;
import iskallia.vault.client.gui.framework.screen.AbstractElementContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = AbstractElementContainerScreen.class, remap = false)
public interface AbstractElementContainerScreenAccessor {

    @Accessor
    ElementStore getElementStore();
}
