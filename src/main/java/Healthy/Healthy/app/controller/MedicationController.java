package Healthy.Healthy.app.controller;


import Healthy.Healthy.app.Model.Medication;
import Healthy.Healthy.app.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable("id") Long id) {
        Medication medication = medicationService.findById(id);
        return ResponseEntity.ok(medication);
    }

    @GetMapping
    public ResponseEntity<List<Medication>> getAllMedications() {
        List<Medication> medications = medicationService.findAll();
        return ResponseEntity.ok(medications);
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) {
        Medication savedMedication = medicationService.save(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable("id") Long id, @RequestBody Medication medication) {
        Medication updatedMedication = medicationService.findById(id);
        updatedMedication.setName(medication.getName());
        updatedMedication.setDosage(medication.getDosage());
        updatedMedication.setFrequency(medication.getFrequency());
        updatedMedication.setMedicalRecord(medication.getMedicalRecord());
        Medication savedMedication = medicationService.save(updatedMedication);
        return ResponseEntity.ok(savedMedication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable("id") Long id) {
        medicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
