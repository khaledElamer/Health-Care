package Healthy.Healthy.app.entity;

import Healthy.Healthy.app.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(name = "gender", nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @Column(nullable = false)
    private String medicalRecordNumber;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "01[0-9]{9}", message = "Invalid Egyptian telephone number. Please provide a valid number starting with '01' followed by 9 digits.")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
