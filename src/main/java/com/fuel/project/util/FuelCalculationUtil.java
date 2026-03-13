package com.fuel.project.util;
 
public class FuelCalculationUtil {
 
    // Calculate fuel percentage
    public static float calculateFuelPercentage(float currentFuel, float totalCapacity) {
 
        if (totalCapacity == 0) {
            return 0;
        }
 
        return (currentFuel / totalCapacity) * 100;
    }
 
    // Calculate drop between two readings
    public static float calculateFuelDrop(float previousLevel, float currentLevel) {
 
        return previousLevel - currentLevel;
    }
 
    // Check sudden drop
    public static boolean isSuddenDrop(float previousLevel, float currentLevel, float threshold) {
 
        float drop = previousLevel - currentLevel;
 
        return drop >= threshold;
    }
}
 