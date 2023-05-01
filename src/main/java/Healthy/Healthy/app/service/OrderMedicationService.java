package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.OrderMedication;

import java.util.List;

public interface OrderMedicationService {
    List<OrderMedication> getAllOrderMedications();

    OrderMedication getOrderMedicationById(Long id);

    OrderMedication createOrderMedication(OrderMedication orderMedication);

    OrderMedication updateOrderMedication(Long id, OrderMedication orderMedication);

    void deleteOrderMedication(Long id);
}
