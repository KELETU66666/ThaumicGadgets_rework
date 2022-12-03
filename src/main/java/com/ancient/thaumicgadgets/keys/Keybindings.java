package com.ancient.thaumicgadgets.keys;

import net.minecraft.client.settings.KeyBinding;



public enum Keybindings
{
    /*  9 */   OPEN_GUI("key.tg.open_gui", 19),
    /* 10 */   ARMOR_ABILITY("key.tg.armor_ability", 46);

    private final KeyBinding bind;


    Keybindings(String name, int defaultKeyCode) {
        /* 17 */     this.bind = new KeyBinding(name, defaultKeyCode, "key.categories.tg");
    }


    public KeyBinding getKeyding() {
        /* 22 */     return this.bind;
    }


    public boolean isPressed() {
        /* 27 */     return this.bind.isPressed();
    }
}


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\keys\Keybindings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */