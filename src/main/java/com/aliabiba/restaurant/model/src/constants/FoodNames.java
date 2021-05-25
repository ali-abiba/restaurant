package com.aliabiba.restaurant.model.src.constants;

/**
 * @author aliabiba
 */
public enum FoodNames {
    // Ideally this would be stored in a DB
    EGGS("Eggs"),
    TOAST("Toast"),
    COFFEE("Coffee"),
    SALAD("Salad"),
    CHIPS("Chips"),
    SODA("Soda"),
    STEAK("Steak"),
    POTATOES("Potatoes"),
    WINE("Wine"),
    WATER("Water"),
    CAKE("Cake");

    public final String label;

    private FoodNames(String label) {
        this.label = label;
    }
}
