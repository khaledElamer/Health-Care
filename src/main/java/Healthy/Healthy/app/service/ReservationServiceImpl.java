package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.entity.Reservation;
import Healthy.Healthy.app.enums.Gender;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.ClinicRepository;
import Healthy.Healthy.app.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClinicRepository clinicRepository;


    public ReservationServiceImpl(ReservationRepository reservationRepository, ClinicRepository clinicRepository) {
        this.reservationRepository = reservationRepository;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found","Id",id));
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found","id",id));

        existingReservation.setName(reservation.getName());
        existingReservation.setAge(reservation.getAge());
        existingReservation.setGender(reservation.getGender());
        existingReservation.setAddress(reservation.getAddress());
        existingReservation.setReservationTime(reservation.getReservationTime());
        existingReservation.setMedicalRecordNumber(reservation.getMedicalRecordNumber());
        existingReservation.setClinic(reservation.getClinic());
        existingReservation.setPhoneNumber(reservation.getPhoneNumber());
        existingReservation.setUser(reservation.getUser());

        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
    @Override
    public List<String> getGenderOptions() {
        return Arrays.stream(Gender.values())
                .map(Gender::getValue)
                .collect(Collectors.toList());
    }
    @Override
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }
}
