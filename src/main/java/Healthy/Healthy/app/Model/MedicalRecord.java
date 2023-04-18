package Healthy.Healthy.app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "medical_records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String allergies;

    @Column(nullable = false)
    private String medicalHistory;

    @OneToMany(mappedBy = "medicalRecord")
    private List<Medication> medications;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany
    @JoinTable(
            name = "medical_record_healthcare_provider",
            joinColumns = @JoinColumn(name = "medical_record_id"),
            inverseJoinColumns = @JoinColumn(name = "healthcare_provider_id"))
    private List<HealthcareProvider> healthcareProviders;
}

