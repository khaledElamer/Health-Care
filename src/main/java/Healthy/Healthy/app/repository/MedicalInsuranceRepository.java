package Healthy.Healthy.app.repository;

import Healthy.Healthy.app.entity.MedicalInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalInsuranceRepository extends JpaRepository<MedicalInsurance,Long> {
}
