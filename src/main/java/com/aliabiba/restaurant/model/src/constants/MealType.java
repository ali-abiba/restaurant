package com.aliabiba.restaurant.model.src.constants;

/**
 * @author aliabiba
 */
public enum MealType {
    //Ideally this would be stored in a DB
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner");

    public final String label;

    private MealType(String label) {
        this.label = label;
    }
}
