package dev.attackeight.vault_gui_upgrade;

import com.mojang.blaze3d.vertex.PoseStack;
import iskallia.vault.client.atlas.TextureAtlasRegion;
import iskallia.vault.client.gui.framework.element.TextureAtlasElement;
import iskallia.vault.client.gui.framework.render.spi.IElementRenderer;
import iskallia.vault.client.gui.framework.spatial.spi.IPosition;
import org.jetbrains.annotations.NotNull;

public class ChangingTextureAtlasElement<E extends TextureAtlasElement<E>> extends TextureAtlasElement<E> {
    int state = -1;
    TextureAtlasRegion[] textures;

    public ChangingTextureAtlasElement(IPosition position, TextureAtlasRegion... textureAtlasRegion) {
        super(position, textureAtlasRegion[0]);
        textures = textureAtlasRegion;
    }

    @Override
    public void render(IElementRenderer renderer, @NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        if (state != -1) renderer.render(this.textures[state], poseStack, this.worldSpatial);
    }

    public void setState(int state) {
        this.state = state;
    }
}
