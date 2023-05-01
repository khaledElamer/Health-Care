package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> getAll();

    Clinic getById(Long id);

    void deleteById(Long id);

    Clinic create(Clinic clinic);

    Clinic updateById(Clinic clinic, Long id);
}
