package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
    List<String> getGenderOptions();
    List<Clinic> getAllClinics();
}
