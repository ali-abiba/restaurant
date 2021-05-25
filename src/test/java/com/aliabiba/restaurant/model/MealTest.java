package com.aliabiba.restaurant.model;

import com.aliabiba.restaurant.model.src.constants.CourseNames;
import com.aliabiba.restaurant.model.src.constants.FoodNames;
import com.aliabiba.restaurant.model.src.meal.BreakfastMeal;
import com.aliabiba.restaurant.model.src.meal.DinnerMeal;
import com.aliabiba.restaurant.model.src.meal.LunchMeal;
import com.aliabiba.restaurant.model.src.meal.Meal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {
    private Meal sut;

    @Test
    public void testBreakfastFoodItems(){
        sut = new BreakfastMeal(new ArrayList<>());

        assertEquals(sut.getFoodItems().size(), 3);
        assertEquals(sut.getFoodItems().get(1).getCourse(), CourseNames.MAIN);
        assertEquals(sut.getFoodItems().get(2).getCourse(), CourseNames.SIDE);
        assertEquals(sut.getFoodItems().get(3).getCourse(), CourseNames.DRINK);

        assertEquals(sut.getFoodItems().get(1).getName(), FoodNames.EGGS);
        assertEquals(sut.getFoodItems().get(2).getName(), FoodNames.TOAST);
        assertEquals(sut.getFoodItems().get(3).getName(), FoodNames.COFFEE);
    }

    @Test
    public void testLunchFoodItems(){
        sut = new LunchMeal(new ArrayList<>());

        assertEquals(sut.getFoodItems().size(), 3);
        assertEquals(sut.getFoodItems().get(1).getCourse(), CourseNames.MAIN);
        assertEquals(sut.getFoodItems().get(2).getCourse(), CourseNames.SIDE);
        assertEquals(sut.getFoodItems().get(3).getCourse(), CourseNames.DRINK);

        assertEquals(sut.getFoodItems().get(1).getName(), FoodNames.SALAD);
        assertEquals(sut.getFoodItems().get(2).getName(), FoodNames.CHIPS);
        assertEquals(sut.getFoodItems().get(3).getName(), FoodNames.SODA);
    }


    @Test
    public void testDinnerFoodItems(){
        sut = new DinnerMeal(new ArrayList<>());

        assertEquals(sut.getFoodItems().size(), 4);
        assertEquals(sut.getFoodItems().get(1).getCourse(), CourseNames.MAIN);
        assertEquals(sut.getFoodItems().get(2).getCourse(), CourseNames.SIDE);
        assertEquals(sut.getFoodItems().get(3).getCourse(), CourseNames.DRINK);
        assertEquals(sut.getFoodItems().get(4).getCourse(), CourseNames.DESSERT);


        assertEquals(sut.getFoodItems().get(1).getName(), FoodNames.STEAK);
        assertEquals(sut.getFoodItems().get(2).getName(), FoodNames.POTATOES);
        assertEquals(sut.getFoodItems().get(3).getName(), FoodNames.WINE);
    }

    @Test
    public void testBreakfastAllItemsOrderedOnce(){
        sut = new BreakfastMeal(Arrays.asList(1,2,3));

        assertEquals(3, sut.getOrderedItems().size());
        assertEquals(1, sut.getOrderedItems().get(1));
        assertEquals(1, sut.getOrderedItems().get(2));
        assertEquals(1, sut.getOrderedItems().get(3));
    }

    @Test
    public void testLunchAllItemsOrderedOnce() {
        sut = new LunchMeal(Arrays.asList(1,2,3));

        assertEquals(3, sut.getOrderedItems().size());
        assertEquals(1, sut.getOrderedItems().get(1));
        assertEquals(1, sut.getOrderedItems().get(2));
        assertEquals(1, sut.getOrderedItems().get(3));
    }

    @Test
    public void testDinnerAllItemsOrderedOnce() {
        sut = new DinnerMeal(Arrays.asList(1,2,3,4));

        assertEquals(4, sut.getOrderedItems().size());
        assertEquals(1, sut.getOrderedItems().get(1));
        assertEquals(1, sut.getOrderedItems().get(2));
        assertEquals(1, sut.getOrderedItems().get(3));
        assertEquals(1, sut.getOrderedItems().get(4));
    }
}
