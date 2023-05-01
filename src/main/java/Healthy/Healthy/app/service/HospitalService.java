package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAll();

    Hospital getById(Long id);

    void deleteById(Long id);

    Hospital create(Hospital hospital);

    Hospital updateById(Hospital hospital, Long id);
}
