package com.aliabiba.restaurant.model.src.meal;

import com.aliabiba.restaurant.model.src.constants.CourseNames;
import com.aliabiba.restaurant.model.src.constants.FoodNames;
import com.aliabiba.restaurant.model.src.foodItem.FoodItem;

import java.util.*;

public class BreakfastMeal extends Meal {

    public BreakfastMeal(List<Integer> items) {
        super(items);
    }

    protected Map<Integer, FoodItem> initializeFoodItems() {
        Map<Integer, FoodItem> foodMap = new HashMap<>();

        foodMap.put(1, new FoodItem(FoodNames.EGGS, CourseNames.MAIN, 1, 1));
        foodMap.put(2, new FoodItem(FoodNames.TOAST, CourseNames.SIDE, 1 ,1));
        foodMap.put(3, new FoodItem(FoodNames.COFFEE, CourseNames.DRINK, 0, 0));

        return foodMap;
    }
}
