package dev.svg.ih.services;

import dev.svg.ih.models.Doctor;
import dev.svg.ih.models.Status;
import dev.svg.ih.repositories.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorsById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsByStatus(Status status) {
        return doctorRepository.findByStatus(status);
    }

    public List<Doctor> getDoctorsByDepartment(String department) {
        return doctorRepository.findByDepartment(department);
    }

    public List<Doctor> getDoctorsByStatusAndDepartment(Status status, String department) {
        return doctorRepository.findByStatusAndDepartment(status, department);
    }

    public Doctor addDoctor(Doctor doctor) {
        if (doctorRepository.existsById(doctor.getDoctorId())) {
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED);
        }
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(long id, Doctor doctor) {
        if (doctorRepository.findById(id).isPresent()) {
            return doctorRepository.save(doctor);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
