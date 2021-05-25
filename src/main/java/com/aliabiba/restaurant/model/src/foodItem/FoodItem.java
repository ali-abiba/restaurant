package com.aliabiba.restaurant.model.src.foodItem;

import com.aliabiba.restaurant.model.src.constants.CourseNames;
import com.aliabiba.restaurant.model.src.constants.FoodNames;

public class FoodItem {
    private FoodNames name;
    private CourseNames course;
    private int min;
    private int max;

    public FoodItem(FoodNames name, CourseNames course, int min, int max) {
        this.name = name;
        this.course = course;
        this.min = min;
        this.max = max;
    }

    public FoodNames getName() {
        return name;
    }

    public void setName(FoodNames name) {
        this.name = name;
    }

    public CourseNames getCourse() {
        return course;
    }

    public void setCourse(CourseNames course) {
        this.course = course;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
