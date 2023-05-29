package Healthy.Healthy.app.entity;

import Healthy.Healthy.app.enums.Gender;
import Healthy.Healthy.app.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String confirmPassword;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(name = "gender", nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    public Gender gender;

    @Column(nullable = false)
    private boolean agreePolicy;


}
