package Healthy.Healthy.app.service;


import Healthy.Healthy.app.Model.Patient;

import java.util.List;

public interface PatientService {
        Patient findById(Long id);
        List<Patient> findAll();
        Patient save(Patient patient);
        void deleteById(Long id);
        List<Patient> findByLastName(String lastName);
        List<Patient> findByCity(String city);


}
