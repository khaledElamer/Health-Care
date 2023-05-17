package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.MedicalInsurance;
import Healthy.Healthy.app.exception.MedicalInsuranceNotFoundException;
import Healthy.Healthy.app.repository.MedicalInsuranceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicalInsuranceServiceImpl implements MedicalInsuranceService {

    private final MedicalInsuranceRepository medicalInsuranceRepository;

    public MedicalInsuranceServiceImpl(MedicalInsuranceRepository medicalInsuranceRepository) {
        this.medicalInsuranceRepository = medicalInsuranceRepository;
    }

    @Override
    public List<MedicalInsurance> getAll() {
        return medicalInsuranceRepository.findAll();
    }

    @Override
    public MedicalInsurance getById(Long id) {
        return medicalInsuranceRepository.findById(id)
                .orElseThrow(() -> new MedicalInsuranceNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        medicalInsuranceRepository.deleteById(id);
    }

    @Override
    public MedicalInsurance create(MedicalInsurance medicalInsurance) {
        return medicalInsuranceRepository.save(medicalInsurance);
    }

    @Override
    public MedicalInsurance updateById(MedicalInsurance medicalInsurance, Long id) {
        MedicalInsurance existingMedicalInsurance = medicalInsuranceRepository.findById(id)
                .orElseThrow(() -> new MedicalInsuranceNotFoundException(id));
        existingMedicalInsurance.setInsuranceNumber(medicalInsurance.getInsuranceNumber());
        existingMedicalInsurance.setInsuranceProvider(medicalInsurance.getInsuranceProvider());
        existingMedicalInsurance.setClinic(medicalInsurance.getClinic());
//        existingMedicalInsurance.setOrders(medicalInsurance.getOrders());
        return medicalInsuranceRepository.save(existingMedicalInsurance);
    }

}
