package com.aliabiba.restaurant.model.src.constants;

public enum CourseNames {
    MAIN("Main"),
    SIDE("Side"),
    DRINK("Drink"),
    DESSERT("Dessert");

    public final String label;

    private CourseNames(String label) {
        this.label = label;
    }
}
