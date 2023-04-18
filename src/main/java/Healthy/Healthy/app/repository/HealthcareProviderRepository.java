package Healthy.Healthy.app.repository;


import Healthy.Healthy.app.Model.HealthcareProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider,Long> {
    List<HealthcareProvider> findBySpecialty(String specialty);
    List<HealthcareProvider> findByCity(String city);

}
