package com.aliabiba.restaurant.model.src.meal;

import com.aliabiba.restaurant.model.src.constants.CourseNames;
import com.aliabiba.restaurant.model.src.constants.FoodNames;
import com.aliabiba.restaurant.model.src.foodItem.FoodItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinnerMeal extends Meal {

    public DinnerMeal (List<Integer> items) {
        super(items);
    }


    protected Map<Integer, FoodItem> initializeFoodItems() {
        Map<Integer, FoodItem> foodMap = new HashMap<>();

        foodMap.put(1, new FoodItem(FoodNames.STEAK, CourseNames.MAIN, 1, 1));
        foodMap.put(2, new FoodItem(FoodNames.POTATOES, CourseNames.SIDE, 1 ,1));
        foodMap.put(3, new FoodItem(FoodNames.WINE, CourseNames.DRINK, 0, 1));
        foodMap.put(4, new FoodItem(FoodNames.CAKE, CourseNames.DESSERT, 1, 1));

        return foodMap;
    }
}
