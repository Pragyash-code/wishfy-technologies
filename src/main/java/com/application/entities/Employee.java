package com.application.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @NotNull
    @Column(name = "id", length = 10)
    private int id;

    @NotNull
    @Column(name = "name", length = 50)
    private String name;

    @NotNull
    @Column(name = "department", length = 10)
    private String department;

    @NotNull
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @Column(name = "joiningDate", length = 50)
    private LocalDate joiningDate;

}
