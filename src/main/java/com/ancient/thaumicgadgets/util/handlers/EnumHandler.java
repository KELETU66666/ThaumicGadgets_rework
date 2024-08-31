package com.ancient.thaumicgadgets.util.handlers;

public class EnumHandler {
    public enum PouchTypes {
        pouch_magic_1("pouch_magic_1", 18),
        pouch_magic_2("pouch_magic_2", 27),
        pouch_magic_3("pouch_magic_3", 36),
        pouch_hungry_magic_1("pouch_hungry_magic_1", 18),
        pouch_hungry_magic_2("pouch_hungry_magic_2", 27),
        pouch_hungry_magic_3("pouch_hungry_magic_3", 36),
        pouch_void("pouch_void", 18);

        private String name;

        private int slotCount;

        PouchTypes(String name, int slotCount) {
            this.slotCount = slotCount;
            this.name = name;
        }


        public String getName() {
            return this.name;
        }


        public int getSlotCount() {
            return this.slotCount;
        }


        public String toString() {
            return getName();
        }
    }

    public enum CustomParticles {
        LIGHTNING(0, "lightning", "com.ancient.thaumicgadgets.particles.ParticleCustomLightning"),
        BUBBLE(1, "bubble", "com.ancient.thaumicgadgets.particles.ParticleCustomBubble"),
        SMOKE(2, "smoke", "com.ancient.thaumicgadgets.particles.ParticleCustomSmoke");

        private final String name;

        private final int id;
        private final String cl;

        CustomParticles(int id, String name, String cl) {
            this.name = name;
            this.id = id;
            this.cl = cl;
        }


        public String getName() {
            return this.name;
        }


        public int getID() {
            return this.id;
        }


        public String getParticle() {
            return this.cl;
        }


        public String toString() {
            return getName();
        }
    }

    public enum MultiBlocks {
        BLAST_FURNACE(2, "blast_furnace");

        private final String name;

        private final int id;

        MultiBlocks(int id, String name) {
            this.name = name;
            this.id = id;
        }


        public String getName() {
            return this.name;
        }


        public int getId() {
            return this.id;
        }


        public String toString() {
            return this.name;
        }
    }
}