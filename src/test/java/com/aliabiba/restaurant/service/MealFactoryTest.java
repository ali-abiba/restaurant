package com.aliabiba.restaurant.service;

import com.aliabiba.restaurant.model.src.Order;
import com.aliabiba.restaurant.model.src.constants.MealType;
import com.aliabiba.restaurant.model.src.meal.BreakfastMeal;
import com.aliabiba.restaurant.model.src.meal.DinnerMeal;
import com.aliabiba.restaurant.model.src.meal.LunchMeal;
import com.aliabiba.restaurant.model.src.meal.Meal;
import com.aliabiba.restaurant.service.src.MealFactory.MealFactory;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MealFactoryTest {
    private MealFactory sut;
    private Order order;

    @BeforeEach
    public void setup() throws Exception {
        sut = new MealFactory();
        order = new Order();
        order.setItems(Arrays.asList(1,2,3));
    }

    @Test
    public void testCreateBreakfastMeal() {
        order.setMealType("BREAKFAST");
        Meal meal = sut.createMeal(order);


        assertTrue(meal instanceof BreakfastMeal);
    }


    @Test
    public void testCreateLunchMeal() {
        order.setMealType("LUNCH");
        Meal meal = sut.createMeal(order);


        assertTrue(meal instanceof LunchMeal);
    }


    @Test
    public void testCreateDinnerMeal() {
        order.setMealType("DINNER");
        Meal meal = sut.createMeal(order);


        assertTrue(meal instanceof DinnerMeal);
    }
}
