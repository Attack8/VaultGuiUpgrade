package dev.attackeight.vault_gui_upgrade.mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractContainerScreen.class)
public interface AbstractContainerScreenAccessor<T extends AbstractContainerMenu> {

    @Invoker
    T invokeGetMenu();

    @Accessor
    int getLeftPos();

    @Accessor
    int getTopPos();
}
