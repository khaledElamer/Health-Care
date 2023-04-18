package Healthy.Healthy.app.controller;


import Healthy.Healthy.app.Model.Appointment;
import Healthy.Healthy.app.Model.HealthcareProvider;
import Healthy.Healthy.app.Model.Patient;
import Healthy.Healthy.app.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public Appointment findById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @GetMapping
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @PostMapping
    public Appointment save(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        appointmentService.deleteById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> findByPatient(@PathVariable Long patientId) {
        Patient patient = new Patient();
        patient.setId(patientId);
        return appointmentService.findByPatient(patient);
    }

    @GetMapping("/healthcareProvider/{healthcareProviderId}")
    public List<Appointment> findByHealthcareProvider(@PathVariable Long healthcareProviderId) {
        HealthcareProvider healthcareProvider = new HealthcareProvider();
        healthcareProvider.setId(healthcareProviderId);
        return appointmentService.findByHealthcareProvider(healthcareProvider);
    }
}

