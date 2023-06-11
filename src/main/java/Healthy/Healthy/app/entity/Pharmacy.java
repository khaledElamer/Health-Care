package Healthy.Healthy.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pharmacy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = true)
    private String location;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "01[0-9]{9}", message = "Invalid Egyptian telephone number. Please provide a valid number starting with '01' followed by 9 digits.")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonBackReference // this annotation to avoid the back reference serialization
    private List<Medication> medications;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference //  this annotation to handle the bidirectional relationship
    private List<OrderMedication> orderMedications = new ArrayList<>();

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, targetEntity = Orders.class)
    @JsonBackReference
    private List<Orders> orders;


}
