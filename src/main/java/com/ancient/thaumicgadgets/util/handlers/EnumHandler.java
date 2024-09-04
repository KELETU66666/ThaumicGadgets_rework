package com.ancient.thaumicgadgets.util.handlers;

public class EnumHandler {

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