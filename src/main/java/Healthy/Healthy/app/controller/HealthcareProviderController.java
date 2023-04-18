package Healthy.Healthy.app.controller;


import Healthy.Healthy.app.Model.HealthcareProvider;
import Healthy.Healthy.app.service.HealthcareProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/healthcare-providers")
public class HealthcareProviderController {
    private final HealthcareProviderService healthcareProviderService;

    public HealthcareProviderController(HealthcareProviderService healthcareProviderService) {
        this.healthcareProviderService = healthcareProviderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthcareProvider> getHealthcareProviderById(@PathVariable Long id) {
        HealthcareProvider healthcareProvider = healthcareProviderService.findById(id);
        if (healthcareProvider == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(healthcareProvider);
    }

    @GetMapping
    public List<HealthcareProvider> getAllHealthcareProviders() {
        return healthcareProviderService.findAll();
    }

    @PostMapping
    public ResponseEntity<HealthcareProvider> createHealthcareProvider(@RequestBody HealthcareProvider healthcareProvider) {
        healthcareProvider = healthcareProviderService.save(healthcareProvider);
        return ResponseEntity.created(URI.create("/healthcare-providers/" + healthcareProvider.getId())).body(healthcareProvider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthcareProvider> updateHealthcareProvider(@PathVariable Long id, @RequestBody HealthcareProvider healthcareProvider) {
        if (!id.equals(healthcareProvider.getId())) {
            return ResponseEntity.badRequest().build();
        }
        healthcareProvider = healthcareProviderService.save(healthcareProvider);
        return ResponseEntity.ok(healthcareProvider);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthcareProviderById(@PathVariable Long id) {
        healthcareProviderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/specialty/{specialty}")
    public List<HealthcareProvider> getHealthcareProvidersBySpecialty(@PathVariable String specialty) {
        return healthcareProviderService.findBySpecialty(specialty);
    }

    @GetMapping("/city/{city}")
    public List<HealthcareProvider> getHealthcareProvidersByCity(@PathVariable String city) {
        return healthcareProviderService.findByCity(city);
    }
}

