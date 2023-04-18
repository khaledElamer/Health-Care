package Healthy.Healthy.app.service;


import Healthy.Healthy.app.Model.HealthcareProvider;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.HealthcareProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HealthcareProviderServiceImpl implements HealthcareProviderService {
    private final HealthcareProviderRepository healthcareProviderRepository;

    public HealthcareProviderServiceImpl(HealthcareProviderRepository healthcareProviderRepository) {
        this.healthcareProviderRepository = healthcareProviderRepository;
    }

    @Override
    public HealthcareProvider findById(Long id) {
        return healthcareProviderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HealthcareProvider", "id", id));
    }

    @Override
    public List<HealthcareProvider> findAll() {
        return healthcareProviderRepository.findAll();
    }

    @Override
    public HealthcareProvider save(HealthcareProvider healthcareProvider) {
        return healthcareProviderRepository.save(healthcareProvider);
    }

    @Override
    public void deleteById(Long id) {
        healthcareProviderRepository.deleteById(id);
    }

    @Override
    public List<HealthcareProvider> findBySpecialty(String specialty) {
        return healthcareProviderRepository.findBySpecialty(specialty);
    }

    @Override
    public List<HealthcareProvider> findByCity(String city) {
        return healthcareProviderRepository.findByCity(city);
    }
}

