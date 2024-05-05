package com.careerrbear.CareerBear.user.model;

import com.careerrbear.CareerBear.quiz.model.DetailedQuiz;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ACCOUNT_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NEW_ACCOUNT")
    private boolean newAccount;

    @Column(name = "BIRTHDAY")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "JOIN_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private Role accountRole;
}
