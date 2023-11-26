package com.application.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "department", length = 10)
    private String department;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "joiningDate")
    private LocalDate joiningDate;

}
