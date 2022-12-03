 package com.ancient.thaumicgadgets.init;

 import java.util.ArrayList;
 import java.util.List;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundEvent;




 public class ModSounds
 {
/* 13 */   public static final List<SoundEvent> SOUNDS = new ArrayList<>();

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
/* 37 */     ObserverAmbient = registerSound("observer_ambient");
/* 38 */     ObserverHurt = registerSound("observer_hurt");
/* 39 */     ObserverDeath = registerSound("observer_death");
/* 40 */     PassiveSay = registerSound("passive_say");
/* 41 */     PassiveHurt = registerSound("passive_hurt");
/* 42 */     PassiveDeath = registerSound("passive_death");
/* 43 */     AssistSay = registerSound("assist_say");
/* 44 */     AssistHurt = registerSound("assist_hurt");
/* 45 */     AssistDeath = registerSound("assist_death");
/* 46 */     AggressiveSay = registerSound("aggressive_say");
/* 47 */     AggressiveHurt = registerSound("aggressive_hurt");
/* 48 */     AggressiveDeath = registerSound("aggressive_death");
/* 49 */     MinotaurSay = registerSound("minotaur_say");
/* 50 */     MinotaurHurt = registerSound("minotaur_hurt");
/* 51 */     BoxOpen1 = registerSound("box_open1");
/* 52 */     BoxOpen2 = registerSound("box_open2");
/* 53 */     BagOpen = registerSound("bag_open");
/* 54 */     BookHit = registerSound("book_hit");
/* 55 */     None = registerSound("none");
   }


   public static SoundEvent registerSound(String soundName) {
/* 60 */     ResourceLocation loc = new ResourceLocation("tg", soundName);
/* 61 */     SoundEvent sound = (SoundEvent)(new SoundEvent(loc)).setRegistryName(loc);
/* 62 */     SOUNDS.add(sound);
/* 63 */     return sound;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\init\ModSounds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */