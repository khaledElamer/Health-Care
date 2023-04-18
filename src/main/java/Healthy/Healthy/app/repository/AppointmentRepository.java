package Healthy.Healthy.app.repository;


import Healthy.Healthy.app.Model.Appointment;
import Healthy.Healthy.app.Model.HealthcareProvider;
import Healthy.Healthy.app.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByHealthcareProvider(HealthcareProvider healthcareProvider);
}
