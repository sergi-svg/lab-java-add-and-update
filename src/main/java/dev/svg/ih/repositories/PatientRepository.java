package dev.svg.ih.repositories;

import dev.svg.ih.models.Doctor;
import dev.svg.ih.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirth(String dateOfBirth);

    List<Patient> findPatientsByDoctor(Doctor doctor);

    List<Patient> findByDateOfBirthAndDoctor(String dateOfBirth, Doctor doctor);
}
