package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.Clinic;
import Healthy.Healthy.app.entity.Reservation;
import Healthy.Healthy.app.enums.Gender;
import Healthy.Healthy.app.service.ClinicService;
import Healthy.Healthy.app.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ClinicService clinicService;


    public ReservationController(ReservationService reservationService, ClinicService clinicService) {
        this.reservationService = reservationService;
        this.clinicService = clinicService;
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    @PostMapping("")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservation);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/gender")
    public List<String> getGenderOptions() {
        return Arrays.stream(Gender.values())
                .map(Gender::getValue)
                .collect(Collectors.toList());
    }

    @GetMapping("/clinics")
    public ResponseEntity<List<Clinic>> getClinicOptions() {
        List<Clinic> clinics = clinicService.getAll();
        return ResponseEntity.ok(clinics);
    }
}
