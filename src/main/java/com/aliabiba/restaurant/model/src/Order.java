package com.aliabiba.restaurant.model.src;

import com.aliabiba.restaurant.model.src.constants.MealType;

import java.util.List;


/**
 * @author aliabiba
 */
public class Order {
    private String mealType;
    private List<Integer> items;

    public Order(String mealType, List<Integer> items) {
        this.items = items;
        this.mealType = mealType;
    }

    public Order() {
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
}
