package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.MedicalInsurance;
import Healthy.Healthy.app.service.MedicalInsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-insurances")
public class MedicalInsuranceController {

    private final MedicalInsuranceService medicalInsuranceService;

    public MedicalInsuranceController(MedicalInsuranceService medicalInsuranceService) {
        this.medicalInsuranceService = medicalInsuranceService;
    }

    @GetMapping
    public ResponseEntity<List<MedicalInsurance>> getAll() {
        List<MedicalInsurance> medicalInsurances = medicalInsuranceService.getAll();
        return ResponseEntity.ok(medicalInsurances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalInsurance> getById(@PathVariable Long id) {
        MedicalInsurance medicalInsurance = medicalInsuranceService.getById(id);
        return ResponseEntity.ok(medicalInsurance);
    }

    @PostMapping
    public ResponseEntity<MedicalInsurance> create(@RequestBody MedicalInsurance medicalInsurance) {
        MedicalInsurance createdMedicalInsurance = medicalInsuranceService.create(medicalInsurance);
        return new ResponseEntity<>(createdMedicalInsurance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalInsurance> updateById(@RequestBody MedicalInsurance medicalInsurance, @PathVariable Long id) {
        MedicalInsurance updatedMedicalInsurance = medicalInsuranceService.updateById(medicalInsurance, id);
        return ResponseEntity.ok(updatedMedicalInsurance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        medicalInsuranceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
