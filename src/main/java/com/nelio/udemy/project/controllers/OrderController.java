package com.nelio.udemy.project.controllers;

import com.nelio.udemy.project.entities.Order;
import com.nelio.udemy.project.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {

        var list = orderService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Order> findById(@PathVariable(name = "id") Long id) {

        var order = orderService.findById(id);

        return ResponseEntity.ok().body(order);
    }
}
