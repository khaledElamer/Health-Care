package Healthy.Healthy.app.controller;


import Healthy.Healthy.app.Model.MedicalRecord;
import Healthy.Healthy.app.service.MedicalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecords")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecord(@PathVariable Long id) {
        return medicalRecordService.findById(id);
    }

    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.findAll();
    }

    @PostMapping
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.save(medicalRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteById(id);
    }
}
