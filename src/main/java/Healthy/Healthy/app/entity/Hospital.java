package Healthy.Healthy.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hospital")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospital_number")
    private String hospitalNumber;

    @Column(name = "available_specialties")
    private String availableSpecialties;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;


    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Clinic> clinics;

//    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
//    private List<Pharmacy> pharmacies;

}
