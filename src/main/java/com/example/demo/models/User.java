package com.example.demo.models;

import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status",columnDefinition = "false")
    private boolean status;
}
