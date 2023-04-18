package Healthy.Healthy.app.Model;

import Healthy.Healthy.app.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "healthcare_providers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthcareProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String city;

    @ManyToMany(mappedBy = "healthcareProviders")
    private List<MedicalRecord> medicalRecords;


}
