package com.lliscano.springrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "users", schema = "public")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(sequenceName = "users_id_seq", name = "users_id_seq", schema = "public", allocationSize = 1)
    private Long id;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "birthdate", nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date birthdate;

    @Column(name = "gender", nullable = false, length = 100)
    private String gender;
}
