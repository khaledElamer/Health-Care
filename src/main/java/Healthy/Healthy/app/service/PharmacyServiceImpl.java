package Healthy.Healthy.app.service;

import java.util.List;
import java.util.Optional;

import Healthy.Healthy.app.exception.HospitalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Healthy.Healthy.app.entity.Pharmacy;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.PharmacyRepository;
import Healthy.Healthy.app.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy getPharmacyById(Long id) {
        Optional<Pharmacy> pharmacy = pharmacyRepository.findById(id);
        return pharmacy.orElseThrow(() -> new ResourceNotFoundException("Pharmacy", "id", id));
    }


    @Override
    public Pharmacy createPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    public void deletePharmacy(Long id) {
        Optional<Pharmacy> pharmacy = pharmacyRepository.findById(id);
        if (pharmacy.isPresent()) {
            pharmacyRepository.delete(pharmacy.get());
        } else {
            throw new ResourceNotFoundException("Pharmacy", "id", id);
        }
    }

    @Override
    public Pharmacy updatePharmacy(Long id, Pharmacy pharmacy) {
        Optional<Pharmacy> optionalPharmacy = pharmacyRepository.findById(id);
        if (optionalPharmacy.isPresent()) {
            Pharmacy updatedPharmacy = optionalPharmacy.get();
            updatedPharmacy.setName(pharmacy.getName());
            updatedPharmacy.setAddress(pharmacy.getAddress());
            updatedPharmacy.setPhone(pharmacy.getPhone());
            updatedPharmacy.setLocation(pharmacy.getLocation());
            updatedPharmacy.setHospital(pharmacy.getHospital());
            updatedPharmacy.setMedications(pharmacy.getMedications());
            updatedPharmacy.setOrderMedications(pharmacy.getOrderMedications());
            return pharmacyRepository.save(updatedPharmacy);
        } else {
            throw new ResourceNotFoundException("Pharmacy", "id", id);
        }
    }
}
