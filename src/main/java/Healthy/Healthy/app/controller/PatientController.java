package Healthy.Healthy.app.controller;


import Healthy.Healthy.app.Model.Patient;
import Healthy.Healthy.app.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient currentPatient = patientService.findById(id);
        currentPatient.setName(patient.getName());
        currentPatient.setGender(patient.getGender());
        currentPatient.setDateOfBirth(patient.getDateOfBirth());
        currentPatient.setPhoneNumber(patient.getPhoneNumber());
        currentPatient.setAddress(patient.getAddress());
        Patient updatedPatient = patientService.save(currentPatient);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Patient>> getPatientsByLastName(@PathVariable String lastName) {
        List<Patient> patients = patientService.findByLastName(lastName);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Patient>> getPatientsByCity(@PathVariable String city) {
        List<Patient> patients = patientService.findByCity(city);
        return ResponseEntity.ok(patients);
    }
}

