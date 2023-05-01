package Healthy.Healthy.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clinic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clinic_number")
    private String clinicNumber;

    @Column(name = "clinic_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "specialization")
    private String specialization;

    @ElementCollection
    @CollectionTable(name = "clinic_schedule", joinColumns = @JoinColumn(name = "clinic_id"))
    @Column(name = "schedule")
    private List<String> schedule;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<MedicalInsurance> medicalInsurances;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}

