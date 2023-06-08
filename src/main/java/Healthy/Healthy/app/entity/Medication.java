package Healthy.Healthy.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "medication")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = true)
//    private String manufacturer;

    @Column(nullable = false)
    private double price;

//    @Column(nullable = true)
//    private String description;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private List<OrderMedication> orderMedications;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

}

