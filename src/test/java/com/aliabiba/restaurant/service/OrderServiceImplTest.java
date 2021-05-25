package com.aliabiba.restaurant.service;

import com.aliabiba.restaurant.service.src.MealFactory.MealFactory;
import com.aliabiba.restaurant.service.src.OrderService.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {
    OrderServiceImpl sut;

    @BeforeEach
    public void setup() throws Exception {
        sut = new OrderServiceImpl();
    }

    @Test
    public void testInvalidMealName() {
        String order = sut.orderMeal("Brunch 1,2,3");

        assertEquals("Unable to process: Invalid meal name", order);
    }

    @Test
    public void testCreateFullBreakfast() {
        String order = sut.orderMeal("Breakfast 1,2,3");

        assertEquals("Eggs, Toast, Coffee" , order);
    }

    @Test
    public void testCreateFullBreakfastMultipleCoffee () {
        String order = sut.orderMeal("Breakfast 1,2,3,3,3");

        assertEquals("Eggs, Toast, Coffee(3)" , order);
    }

    @Test
    public void testCreateFullLunch () {
        String order = sut.orderMeal("Lunch 1,2,3");

        assertEquals("Salad, Chips, Soda", order);
    }

    @Test
    public void testCreateFullLunchMultipleChips () {
        String order = sut.orderMeal("Lunch 1,2,2,3");

        assertEquals("Salad, Chips(2), Soda", order);
    }

    @Test
    public void testCreateFullDinner() {
        String order = sut.orderMeal("Dinner 1,2,3,4");

        assertEquals("Steak, Potatoes, Wine, Water, Cake", order);
    }

    @Test
    public void testCreateMealWithNoMain() {
        String order = sut.orderMeal("Lunch 2,3");

        assertEquals("Unable to process: Main is missing. ", order);
    }

    @Test
    public void testCreateMeealWithNoSide() {
        String order = sut.orderMeal("Breakfast 1,3");

        assertEquals("Unable to process: Side is missing. ", order);

    }
}
