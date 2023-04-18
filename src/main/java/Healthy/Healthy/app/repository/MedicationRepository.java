package Healthy.Healthy.app.repository;

import Healthy.Healthy.app.Model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {

}
