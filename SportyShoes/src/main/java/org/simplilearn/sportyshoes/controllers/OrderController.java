package org.simplilearn.sportyshoes.controllers;

import org.apache.tomcat.util.json.ParseException;
import org.simplilearn.sportyshoes.dto.OrderItemsDto;
import org.simplilearn.sportyshoes.entities.Orders;
import org.simplilearn.sportyshoes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sportyshoes/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("")
    public ResponseEntity<Orders> createAnOrder(@RequestBody OrderItemsDto orderItemsDto){
        Orders orders=orderService.createOrUpdateAnOrder(orderItemsDto);
        return new ResponseEntity<Orders>(orders, HttpStatus.OK);
    }
}
