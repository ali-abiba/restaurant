package com.aliabiba.restaurant.service.src.MealFactory;

import com.aliabiba.restaurant.model.src.meal.BreakfastMeal;
import com.aliabiba.restaurant.model.src.meal.DinnerMeal;
import com.aliabiba.restaurant.model.src.meal.LunchMeal;
import com.aliabiba.restaurant.model.src.meal.Meal;
import com.aliabiba.restaurant.model.src.Order;
import org.springframework.stereotype.Component;

@Component
public class MealFactory {
    public static Meal createMeal(Order order) {
        switch (order.getMealType()) {
            case "BREAKFAST":
                return new BreakfastMeal(order.getItems());
            case "LUNCH":
                return new LunchMeal(order.getItems());
            case "DINNER":
                return new DinnerMeal(order.getItems());
            default:
                return null;
        }
    }
}
