package org.niebieskidom.entity;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private Character sex;
    @NotNull
    @NotEmpty
    private String parentsName1;
    private String parentsName2;
    @NotNull
    @NotEmpty
    @DateTimeFormat
    private LocalDateTime birthDate;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String parentsAddress;
    @NotNull
    @NotEmpty
    private Integer parentsPhoneNumber;
    @NotNull
    @NotEmpty
    @Email
    private String parentsEmail;
    @NotNull
    @NotEmpty
    private String infoAboutNeeds;
    @NotNull
    @NotEmpty
    private String infoAboutHealth;
    @NotNull
    @NotEmpty
    private String infoAboutVaccination;
    @NotNull
    @NotEmpty
    @PESEL
    private String pesel;
    @NotNull
    @NotEmpty
    private boolean agreement;
}
