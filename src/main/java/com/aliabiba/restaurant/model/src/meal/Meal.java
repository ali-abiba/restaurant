package com.aliabiba.restaurant.model.src.meal;

import com.aliabiba.restaurant.model.src.constants.CourseNames;
import com.aliabiba.restaurant.model.src.constants.FoodNames;
import com.aliabiba.restaurant.model.src.foodItem.FoodItem;

import java.util.*;

/**
 * @author aliabiba
 */
public abstract class Meal {
    // the names of foods that belong to a meal type along with their ID's
    protected Map<Integer, FoodItem> foodItems;
    // the IDs of the food ordered and the number of times ordered
    protected Map<Integer, Integer> orderedItems;

    public Meal(List<Integer> orderedItems) {
        this.foodItems = initializeFoodItems();
        initializeOrderedItems(orderedItems);
    }

    /**
     * Initializes the items ordered
     * @param itemsOrdered the items ordered
     */
    protected void initializeOrderedItems(List<Integer> itemsOrdered) {
        orderedItems = new HashMap<Integer, Integer>();
        Iterator<Map.Entry<Integer, FoodItem>> iterator = foodItems.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, FoodItem> entry = iterator.next();
            orderedItems.put(entry.getKey(), Collections.frequency(itemsOrdered, entry.getKey()));
        }
    }

    /**
     * Returns a Map of the potential food names and ID's for the meal type
     * @return map of the ID's and names of the food items
     */
    protected abstract Map<Integer, FoodItem> initializeFoodItems();

    public Map<Integer, FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Map<Integer, FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public Map<Integer, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<Integer, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
