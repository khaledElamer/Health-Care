package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.Orders;
import Healthy.Healthy.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Orders getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @PostMapping
    public Orders create(@RequestBody Orders order) {
        return orderService.create(order);
    }

    @PutMapping("/{id}")
    public Orders updateById(@RequestBody Orders order, @PathVariable Long id) {
        return orderService.updateById(order, id);
    }
}

