package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Medication;
import Healthy.Healthy.app.entity.Orders;
import Healthy.Healthy.app.entity.Pharmacy;
import Healthy.Healthy.app.exception.OrderNotFoundException;
import Healthy.Healthy.app.repository.MedicationRepository;
import Healthy.Healthy.app.repository.OrderRepository;
import Healthy.Healthy.app.repository.PharmacyRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private PharmacyRepository pharmacyRepository;

    private MedicationRepository medicationRepository;



    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Orders create(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Orders updateById(Orders order, Long id) {
        Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        existingOrder.setDeliveryOption(order.getDeliveryOption());
        existingOrder.setDosage(order.getDosage());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setMedicationName(order.getMedicationName());
        existingOrder.setPharmacy(order.getPharmacy());

        return orderRepository.save(existingOrder);
    }
    @Override
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();

    }
    @Override
    public List<Medication> getAllMedication() {
        return medicationRepository.findAll();

    }
}