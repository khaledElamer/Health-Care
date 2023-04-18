package Healthy.Healthy.app.service;


import Healthy.Healthy.app.Model.Appointment;
import Healthy.Healthy.app.Model.HealthcareProvider;
import Healthy.Healthy.app.Model.Patient;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> findByPatient(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }

    @Override
    public List<Appointment> findByHealthcareProvider(HealthcareProvider healthcareProvider) {
        return appointmentRepository.findByHealthcareProvider(healthcareProvider);
    }
}


