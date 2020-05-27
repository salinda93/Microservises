package com.sldevcode.microservices.orderservice.controller;

import com.sldevcode.microservices.orderservice.dto.OrderRequest;
import com.sldevcode.microservices.orderservice.dto.OrderResponse;
import com.sldevcode.microservices.orderservice.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody OrderResponse createOrder(@RequestBody OrderRequest request){

        System.out.println("Order Details : " + request);
        return orderService.createOrder(request);

    }


}
