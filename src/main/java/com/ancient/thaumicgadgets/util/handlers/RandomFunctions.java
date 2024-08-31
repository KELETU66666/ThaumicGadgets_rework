package com.ancient.thaumicgadgets.util.handlers;

import java.util.Random;

public class RandomFunctions {
    public static final RandomFunctions INSTANCE = new RandomFunctions();
    public static final Random rand = new Random();

    public double getRandomPartcileVelocity(double bound) {
        return (rand.nextDouble() - 0.5D) * 2.0D * bound;
    }
}