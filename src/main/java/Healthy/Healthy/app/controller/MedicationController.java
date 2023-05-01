package Healthy.Healthy.app.controller;


import Healthy.Healthy.app.entity.Medication;
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

    @GetMapping("")
    public List<Medication> getAll() {
        return medicationService.getAll();
    }

    @GetMapping("/{id}")
    public Medication getById(@PathVariable Long id) {
        return medicationService.getById(id);
    }

    @PostMapping("")
    public Medication create(@RequestBody Medication medication) {
        return medicationService.create(medication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        medicationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public Medication updateById(@RequestBody Medication medication, @PathVariable Long id) {
        return medicationService.updateById(medication, id);
    }

}
