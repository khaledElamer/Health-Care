package Healthy.Healthy.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "hospital", targetEntity = Clinic.class, cascade = CascadeType.ALL)
    @JsonIgnore  // Ignore the clinics property during serialization
    private List<Clinic> clinics;

    @OneToMany(mappedBy = "hospital", targetEntity = Pharmacy.class, cascade = CascadeType.ALL)
    @JsonIgnore  // Ignore the pharmacies property during serialization
    private List<Pharmacy> pharmacies;
}
