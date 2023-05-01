package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.OrderMedication;
import Healthy.Healthy.app.repository.OrderMedicationRepository;
import Healthy.Healthy.app.service.OrderMedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMedicationServiceImpl implements OrderMedicationService {

    @Autowired
    private OrderMedicationRepository orderMedicationRepository;

    @Override
    public List<OrderMedication> getAllOrderMedications() {
        return orderMedicationRepository.findAll();
    }

    @Override
    public OrderMedication getOrderMedicationById(Long id) {
        return orderMedicationRepository.findById(id).orElse(null);
    }

    @Override
    public OrderMedication createOrderMedication(OrderMedication orderMedication) {
        return orderMedicationRepository.save(orderMedication);
    }

    @Override
    public OrderMedication updateOrderMedication(Long id, OrderMedication orderMedication) {
        OrderMedication existingOrderMedication = getOrderMedicationById(id);

        if (existingOrderMedication != null) {
            existingOrderMedication.setName(orderMedication.getName());
            existingOrderMedication.setPrice(orderMedication.getPrice());
            existingOrderMedication.setQuantity(orderMedication.getQuantity());
            existingOrderMedication.setTotal(orderMedication.getTotal());
            existingOrderMedication.setPharmacy(orderMedication.getPharmacy());
            existingOrderMedication.setMedication(orderMedication.getMedication());
            existingOrderMedication.setOrders(orderMedication.getOrders());

            return orderMedicationRepository.save(existingOrderMedication);
        }

        return null;
    }

    @Override
    public void deleteOrderMedication(Long id) {
        orderMedicationRepository.deleteById(id);
    }
}
