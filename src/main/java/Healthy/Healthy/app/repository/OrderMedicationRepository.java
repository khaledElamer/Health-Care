package Healthy.Healthy.app.repository;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.entity.OrderMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMedicationRepository extends JpaRepository<OrderMedication,Long> {
}
