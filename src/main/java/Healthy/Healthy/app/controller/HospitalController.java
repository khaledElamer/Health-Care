package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.Hospital;
import Healthy.Healthy.app.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private  HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAll();
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable Long id) {
        return hospitalService.getById(id);
    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalService.create(hospital);
    }

    @PutMapping("/{id}")
    public Hospital updateHospitalById(@RequestBody Hospital hospital, @PathVariable Long id) {
        return hospitalService.updateById(hospital, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalById(@PathVariable Long id) {
        hospitalService.deleteById(id);
    }
}
