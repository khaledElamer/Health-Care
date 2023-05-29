package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Orders;
import Healthy.Healthy.app.entity.Pharmacy;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderService {
    List<Orders> getAll();
    Orders getById(Long id);
    void deleteById(Long id);
    Orders create(Orders order);
    Orders updateById(Orders order, Long id);
    List<Pharmacy> getAllPharmacies();
}
