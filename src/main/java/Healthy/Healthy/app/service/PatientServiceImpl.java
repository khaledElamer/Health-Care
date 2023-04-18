package Healthy.Healthy.app.service;

import Healthy.Healthy.app.Model.Patient;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    @Override
    public List<Patient> findByCity(String city) {
        return patientRepository.findByCity(city);
    }
}
