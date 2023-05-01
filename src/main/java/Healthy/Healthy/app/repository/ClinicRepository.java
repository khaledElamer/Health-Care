package Healthy.Healthy.app.repository;

import Healthy.Healthy.app.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {
}
