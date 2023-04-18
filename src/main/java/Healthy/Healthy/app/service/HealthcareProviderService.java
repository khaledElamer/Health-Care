package Healthy.Healthy.app.service;


import Healthy.Healthy.app.Model.HealthcareProvider;

import java.util.List;

public interface HealthcareProviderService {
        HealthcareProvider findById(Long id);
        List<HealthcareProvider> findAll();
        HealthcareProvider save(HealthcareProvider healthcareProvider);
        void deleteById(Long id);
        List<HealthcareProvider> findBySpecialty(String specialty);
        List<HealthcareProvider> findByCity(String city);


}
