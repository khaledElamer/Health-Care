package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.exception.ClinicNotFoundException;
import Healthy.Healthy.app.repository.ClinicRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ClinicServiceImpl implements ClinicService{
        private final ClinicRepository clinicRepository;

        public ClinicServiceImpl(ClinicRepository clinicRepository) {
            this.clinicRepository = clinicRepository;
        }

        @Override
        public List<Clinic> getAll() {
            return clinicRepository.findAll();
        }

        @Override
        public Clinic getById(Long id) {
            return clinicRepository.findById(id).orElseThrow(() -> new ClinicNotFoundException(id));
        }

        @Override
        public void deleteById(Long id) {
            clinicRepository.deleteById(id);
        }

        @Override
        public Clinic create(Clinic clinic) {
            return clinicRepository.save(clinic);
        }

        @Override
        public Clinic updateById(Clinic clinic, Long id) {
            Clinic existingClinic = clinicRepository.findById(id)
                    .orElseThrow(() -> new ClinicNotFoundException(id));
            existingClinic.setClinicNumber(clinic.getClinicNumber());
            existingClinic.setName(clinic.getName());
            existingClinic.setAddress(clinic.getAddress());
            existingClinic.setSpecialization(clinic.getSpecialization());
            existingClinic.setSchedule(clinic.getSchedule());
            existingClinic.setHospital(clinic.getHospital());
            existingClinic.setMedicalInsurances(clinic.getMedicalInsurances());
            existingClinic.setReservations(clinic.getReservations());
            return clinicRepository.save(existingClinic);
        }
}
