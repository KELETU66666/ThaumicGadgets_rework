package com.ancient.thaumicgadgets.keys;

import net.minecraft.client.settings.KeyBinding;


public enum Keybindings {
    OPEN_GUI("key.thaumicgadgets.open_gui", 19),
    ARMOR_ABILITY("key.thaumicgadgets.armor_ability", 46);

    private final KeyBinding bind;


    Keybindings(String name, int defaultKeyCode) {
        this.bind = new KeyBinding(name, defaultKeyCode, "key.categories.tg");
    }


    public KeyBinding getKeyding() {
        return this.bind;
    }


    public boolean isPressed() {
        return this.bind.isPressed();
    }
}