package com.aliabiba.restaurant.controller;

import com.aliabiba.restaurant.service.src.OrderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    @Autowired
    protected OrderService orderService;

    @GetMapping("order/{order}")
    public String orderMeal(@PathVariable String order) {
        return orderService.orderMeal(order);
    }
}
