package dev.svg.ih.controllers;

import dev.svg.ih.models.Doctor;
import dev.svg.ih.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Doctor> getDoctorsById(@PathVariable("id") Long id) {
        return doctorService.getDoctorsById(id);
    }

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PutMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @PatchMapping("/doctors/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Doctor updateDoctorDepartment(@PathVariable long id, @RequestParam String department) {
        Doctor doctor = doctorService.getDoctorsById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id: " + id));
        doctor.setDepartment(department);
        return doctorService.updateDoctor(id, doctor);
    }


    /*
    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctors(@RequestParam Optional<Status> status, @RequestParam Optional<String> department) {
        if (status.isPresent() && department.isPresent()) {
            return doctorService.getDoctorsByStatusAndDepartment(status.get(), department.get());
        } else if (status.isPresent()) {
            return doctorService.getDoctorsByStatus(status.get());
        } else if (department.isPresent()) {
            return doctorService.getDoctorsByDepartment(department.get());
        } else {
            return doctorService.getAllDoctors();
        }
    }
    */
}