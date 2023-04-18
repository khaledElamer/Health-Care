package Healthy.Healthy.app.service;



import Healthy.Healthy.app.Model.Appointment;
import Healthy.Healthy.app.Model.HealthcareProvider;
import Healthy.Healthy.app.Model.Patient;

import java.util.List;

public interface AppointmentService {
        Appointment findById(Long id);
        List<Appointment> findAll();
        Appointment save(Appointment appointment);
        void deleteById(Long id);
        List<Appointment> findByPatient(Patient patient);
        List<Appointment> findByHealthcareProvider(HealthcareProvider healthcareProvider);


}
