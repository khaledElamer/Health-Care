    package Healthy.Healthy.app.entity;
    
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    

        @Column(name = "schedule")
        private String schedule;
    
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "hospital_id")
        private Hospital hospital;
    
        @OneToMany(mappedBy = "clinic", targetEntity = MedicalInsurance.class , cascade = CascadeType.ALL)
        @JsonIgnore
        private List<MedicalInsurance> medicalInsurances;
    
        @OneToMany(mappedBy = "clinic", targetEntity = Reservation.class , cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Reservation> reservations;
    
    }
    
