package com.aliabiba.restaurant.service.src.OrderService;

import com.aliabiba.restaurant.model.src.constants.CourseNames;
import com.aliabiba.restaurant.model.src.constants.FoodNames;
import com.aliabiba.restaurant.model.src.constants.MealType;
import com.aliabiba.restaurant.model.src.Order;
import com.aliabiba.restaurant.model.src.foodItem.FoodItem;
import com.aliabiba.restaurant.model.src.meal.DinnerMeal;
import com.aliabiba.restaurant.model.src.meal.Meal;
import com.aliabiba.restaurant.service.src.MealFactory.MealFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * @author aliabiba
 */
@Service
public class OrderServiceImpl implements OrderService {
    private String INVALID_MEAL_TYPE = "Unable to process: Invalid meal name";

    /**
     * Returns a string of the items ordered
     * @param order a string of the meal and items ordered
     * @return string containing the items ordered or error
     */
    public String orderMeal(String order) {
        Order foodOrder = parseOrder(order);
        Meal meal = MealFactory.createMeal(foodOrder);
        if(meal != null) {
            return compileMeal(meal);
        } else {
            //TODO: throw exception
            return INVALID_MEAL_TYPE;
        }
    }

    /**
     * Returns a string of the names of the food ordered. If there is an invalid order,
     * it will specify the incorrect components
     * @return the names and quantities of items ordered
     */
    private String compileMeal(Meal meal) {
        StringBuilder orderSb = new StringBuilder();
        StringBuilder errorSb = new StringBuilder();
        Map<Integer, FoodItem> foodItems = meal.getFoodItems();
        Iterator<Map.Entry<Integer, Integer>> iterator = meal.getOrderedItems().entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            FoodItem currentItem = foodItems.get(entry.getKey());

            if(currentItem.getMin() > entry.getValue()) {
                errorSb.append(currentItem.getCourse().label + " is missing. ");
            } else if ((currentItem.getMax() > 0) && currentItem.getMax() < entry.getValue()) {
                errorSb.append(currentItem.getName().label + " cannot be ordered more than " + currentItem.getMax() + " times.");
            } else if(entry.getValue() > 0){
                orderSb.append(currentItem.getName().label);
                if(entry.getValue() > 1) orderSb.append("(" + entry.getValue() + ")");
                if(iterator.hasNext()) orderSb.append(", ");
            }
            if((currentItem.getCourse() == CourseNames.DRINK && (entry.getValue() <= 0 || meal instanceof DinnerMeal))) {
                orderSb.append(FoodNames.WATER.label);
                if(iterator.hasNext()) orderSb.append(", ");
            }
        }
        if(errorSb.length() > 0) {
            errorSb.insert(0, "Unable to process: ");
            return errorSb.toString();
        } else {
            return orderSb.toString();
        }
    }

    /**
     * Takes order string and parses to Order object
     * @param order string containing the meal and items ordered
     * @return Order
     */
    private Order parseOrder(String order) {
        Order foodOrder = new Order();
        ArrayList<Integer> items = new ArrayList<>();

        if(order.length() > 0) {
            foodOrder.setMealType(order.substring(0, order.indexOf(' ')).toUpperCase());
            order = order.substring(order.indexOf(' ') + 1);

            if(order.length() > 0) {
                for (String i : order.split(",")) {
                    items.add(Integer.parseInt(i));
                }
            }

            foodOrder.setItems(items);
        }
        return foodOrder;
    }
}
