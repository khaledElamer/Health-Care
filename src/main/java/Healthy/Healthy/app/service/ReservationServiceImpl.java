package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.Reservation;
import Healthy.Healthy.app.exception.ResourceNotFoundException;
import Healthy.Healthy.app.repository.ReservationRepository;
import Healthy.Healthy.app.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
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
        existingReservation.setUser(reservation.getUser());

        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
