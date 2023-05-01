package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.OrderMedication;
import Healthy.Healthy.app.service.OrderMedicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-medications")
public class OrderMedicationController {

    private OrderMedicationService orderMedicationService;

    public OrderMedicationController(OrderMedicationService orderMedicationService) {
        this.orderMedicationService = orderMedicationService;
    }

    @GetMapping
    public List<OrderMedication> getAllOrderMedications() {
        return orderMedicationService.getAllOrderMedications();
    }

    @GetMapping("/{id}")
    public OrderMedication getOrderMedicationById(@PathVariable Long id) {
        return orderMedicationService.getOrderMedicationById(id);
    }

    @PostMapping
    public OrderMedication createOrderMedication(@RequestBody OrderMedication orderMedication) {
        return orderMedicationService.createOrderMedication(orderMedication);
    }

    @PutMapping("/{id}")
    public OrderMedication updateOrderMedication(@PathVariable Long id, @RequestBody OrderMedication orderMedication) {
        return orderMedicationService.updateOrderMedication(id, orderMedication);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderMedication(@PathVariable Long id) {
        orderMedicationService.deleteOrderMedication(id);
    }
}