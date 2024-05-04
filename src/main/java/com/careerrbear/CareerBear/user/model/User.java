package com.careerrbear.CareerBear.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "USERS")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NEW_ACOUNT")
    private boolean newAccount;

    @Column(name = "BIRTHDAY")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "JOIN_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    @Column(name = "ROLE")
    private Role accountRole;
}
