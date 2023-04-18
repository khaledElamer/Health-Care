package Healthy.Healthy.app.repository;


import Healthy.Healthy.app.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByLastName(String lastName);
    List<Patient> findByCity(String city);

}
