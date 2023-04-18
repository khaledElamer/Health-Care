package Healthy.Healthy.app.service;


import Healthy.Healthy.app.Model.Medication;

import java.util.List;

public interface MedicationService {
    Medication findById(Long id);
    List<Medication> findAll();
    Medication save(Medication medication);
    void deleteById(Long id);
}
