package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.service.ClinicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public List<Clinic> getAllClinics() {
        return clinicService.getAll();
    }

    @GetMapping("/{id}")
    public Clinic getClinicById(@PathVariable Long id) {
        return clinicService.getById(id);
    }

    @PostMapping
    public Clinic createClinic(@RequestBody Clinic clinic) {
        return clinicService.create(clinic);
    }

    @PutMapping("/{id}")
    public Clinic updateClinicById(@RequestBody Clinic clinic, @PathVariable Long id) {
        return clinicService.updateById(clinic, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClinicById(@PathVariable Long id) {
        clinicService.deleteById(id);
    }
}
