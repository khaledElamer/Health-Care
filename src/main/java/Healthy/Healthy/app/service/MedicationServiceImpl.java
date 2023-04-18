package Healthy.Healthy.app.service;

import Healthy.Healthy.app.Model.Medication;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.MedicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicationServiceImpl implements MedicationService {
     private MedicationRepository medicationRepository;
    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication findById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication", "id", id));
    }

    @Override
    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication save(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public void deleteById(Long id) {
        medicationRepository.deleteById(id);
    }
}

