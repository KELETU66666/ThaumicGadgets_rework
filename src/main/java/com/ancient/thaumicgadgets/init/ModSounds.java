package com.ancient.thaumicgadgets.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.List;


public class ModSounds {
    public static final List<SoundEvent> SOUNDS = new ArrayList<>();
    public static SoundEvent ObserverAmbient;

    public static SoundEvent ObserverHurt;
    public static SoundEvent ObserverDeath;
    public static SoundEvent PassiveSay;
    public static SoundEvent PassiveHurt;
    public static SoundEvent PassiveDeath;
    public static SoundEvent AssistSay;
    public static SoundEvent AssistHurt;
    public static SoundEvent AssistDeath;
    public static SoundEvent AggressiveSay;
    public static SoundEvent AggressiveHurt;
    public static SoundEvent AggressiveDeath;
    public static SoundEvent MinotaurSay;
    public static SoundEvent MinotaurHurt;
    public static SoundEvent BoxOpen1;
    public static SoundEvent BoxOpen2;
    public static SoundEvent BagOpen;
    public static SoundEvent BookHit;
    public static SoundEvent None;

    public static void registerSounds() {
        ObserverAmbient = registerSound("observer_ambient");
        ObserverHurt = registerSound("observer_hurt");
        ObserverDeath = registerSound("observer_death");
        PassiveSay = registerSound("passive_say");
        PassiveHurt = registerSound("passive_hurt");
        PassiveDeath = registerSound("passive_death");
        AssistSay = registerSound("assist_say");
        AssistHurt = registerSound("assist_hurt");
        AssistDeath = registerSound("assist_death");
        AggressiveSay = registerSound("aggressive_say");
        AggressiveHurt = registerSound("aggressive_hurt");
        AggressiveDeath = registerSound("aggressive_death");
        MinotaurSay = registerSound("minotaur_say");
        MinotaurHurt = registerSound("minotaur_hurt");
        BoxOpen1 = registerSound("box_open1");
        BoxOpen2 = registerSound("box_open2");
        BagOpen = registerSound("bag_open");
        BookHit = registerSound("book_hit");
        None = registerSound("none");
    }


    public static SoundEvent registerSound(String soundName) {
        ResourceLocation loc = new ResourceLocation("thaumicgadgets", soundName);
        SoundEvent sound = (new SoundEvent(loc)).setRegistryName(loc);
        SOUNDS.add(sound);
        return sound;
    }
}