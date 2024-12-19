package dev.attackeight.vault_gui_upgrade;

import iskallia.vault.VaultMod;
import iskallia.vault.client.atlas.TextureAtlasRegion;
import iskallia.vault.init.ModTextureAtlases;

public class MoreScreenTextures {

    public static final TextureAtlasRegion TUMBLE_1;
    public static final TextureAtlasRegion TUMBLE_2;
    public static final TextureAtlasRegion TUMBLE_3;
    public static final TextureAtlasRegion TUMBLE_4;

    static {
        TUMBLE_1 = TextureAtlasRegion.of(ModTextureAtlases.SCREEN, VaultMod.id("gui/screen/tumble_1"));
        TUMBLE_2 = TextureAtlasRegion.of(ModTextureAtlases.SCREEN, VaultMod.id("gui/screen/tumble_2"));
        TUMBLE_3 = TextureAtlasRegion.of(ModTextureAtlases.SCREEN, VaultMod.id("gui/screen/tumble_3"));
        TUMBLE_4 = TextureAtlasRegion.of(ModTextureAtlases.SCREEN, VaultMod.id("gui/screen/tumble_4"));
    }
}
