package Healthy.Healthy.app.entity;

import Healthy.Healthy.app.enums.InsuranceProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "medicalInsurance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "insurance_provider")
    private InsuranceProvider insuranceProvider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

}
