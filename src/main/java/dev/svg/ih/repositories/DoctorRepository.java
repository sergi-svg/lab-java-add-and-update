package dev.svg.ih.repositories;

import dev.svg.ih.models.Doctor;
import dev.svg.ih.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByStatus(Status status);

    List<Doctor> findByDepartment(String department);

    List<Doctor> findByStatusAndDepartment(Status status, String department);

}
