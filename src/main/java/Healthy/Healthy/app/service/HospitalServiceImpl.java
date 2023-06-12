package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Hospital;
import Healthy.Healthy.app.exception.HospitalNotFoundException;
import Healthy.Healthy.app.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }


    @Override
    public Hospital getById(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));
    }
    @Override
    public void deleteById(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public Hospital create(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital updateById(Hospital hospital, Long id) {
        Hospital existingHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));
        existingHospital.setHospitalName(hospital.getHospitalName());
        existingHospital.setHospitalNumber(hospital.getHospitalNumber());
        existingHospital.setAvailableSpecialties(hospital.getAvailableSpecialties());
        existingHospital.setLocation(hospital.getLocation());
        existingHospital.setClinics(hospital.getClinics());
        existingHospital.setPharmacies(hospital.getPharmacies());
        existingHospital.setPhoneNumber(hospital.getPhoneNumber());
        existingHospital.setAvailableServices(hospital.getAvailableServices());
        return hospitalRepository.save(existingHospital);
    }
}
