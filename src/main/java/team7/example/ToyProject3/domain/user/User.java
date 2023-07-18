package team7.example.ToyProject3.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, name = "name")
    private String name;

    @Column(length = 100, nullable = false, name = "password")
    private String password;

    @Column(length = 30, nullable = false, name = "email")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    private String nickname;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;



}