package dev.svg.ih.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Doctor {

    @Id
    @Column(name = "employee_id")
    private long doctorId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    List<Patient> patients;
}
