package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Medication;
import Healthy.Healthy.app.exception.MedicationNotFoundException;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.MedicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;

    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public List<Medication> getAll() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication getById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new MedicationNotFoundException(id));
    }

    @Override
    public Medication create(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public void deleteById(Long id) {
        medicationRepository.deleteById(id);
    }

    @Override
    public Medication updateById(Medication medication, Long id) {
        Medication existingMedication = medicationRepository.findById(id)
                .orElseThrow(() -> new MedicationNotFoundException(id));
        existingMedication.setName(medication.getName());
        existingMedication.setManufacturer(medication.getManufacturer());
        existingMedication.setDescription(medication.getDescription());
        existingMedication.setOrderMedications(medication.getOrderMedications());
        existingMedication.setPharmacy(medication.getPharmacy());
        return medicationRepository.save(existingMedication);
    }

}

