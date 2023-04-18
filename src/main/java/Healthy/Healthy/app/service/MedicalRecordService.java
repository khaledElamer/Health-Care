package Healthy.Healthy.app.service;


import Healthy.Healthy.app.Model.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecord findById(Long id);
    List<MedicalRecord> findAll();
    MedicalRecord save(MedicalRecord medicalRecord);
    void deleteById(Long id);
}

