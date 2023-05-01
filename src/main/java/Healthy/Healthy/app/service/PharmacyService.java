package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> getAllPharmacies();
    Pharmacy getPharmacyById(Long id);
    Pharmacy createPharmacy(Pharmacy pharmacy);
    void deletePharmacy(Long id);
    Pharmacy updatePharmacy(Long id, Pharmacy pharmacy);
}
