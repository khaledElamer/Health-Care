package Healthy.Healthy.app.service;


import Healthy.Healthy.app.entity.Medication;

import java.util.List;

public interface MedicationService {
        List<Medication> getAll();
        Medication getById(Long id);
        Medication create(Medication medication);
        void deleteById(Long id);
        Medication updateById(Medication medication, Long id);

}
