package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.entity.MedicalInsurance;
import Healthy.Healthy.app.enums.InsuranceProvider;

import java.util.List;

public interface MedicalInsuranceService {
    List<MedicalInsurance> getAll();

    MedicalInsurance getById(Long id);

    void deleteById(Long id);

    MedicalInsurance create(MedicalInsurance medicalInsurance);

    MedicalInsurance updateById(MedicalInsurance medicalInsurance, Long id);
    InsuranceProvider[] getEnums();

}
