package Healthy.Healthy.app.entity;

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

    @Column(name = "insurance_provider")
    private String insuranceProvider;


    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @OneToMany(mappedBy = "medicalInsurance" ,cascade = CascadeType.ALL)
    private List<Orders> orders;

}
