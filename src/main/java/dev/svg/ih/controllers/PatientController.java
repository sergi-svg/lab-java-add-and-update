package dev.svg.ih.controllers;

import dev.svg.ih.models.Patient;
import dev.svg.ih.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatientsById(@PathVariable("id") Long id) {
        return patientService.getPatientsById(id);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    /*
    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(@RequestParam Optional<String> dateOfBirth, @RequestParam Optional<Doctor> doctor) {
        if (dateOfBirth.isPresent() && doctor.isPresent()) {
            return patientService.getPatientsByDateOfBirthAndDoctor(dateOfBirth.get(), doctor.get());
        } else if (dateOfBirth.isPresent()) {
            return patientService.getPatientsByDateOfBirth(dateOfBirth.get());
        } else if (doctor.isPresent()) {
            return patientService.getPatientsByDoctor(doctor.get());
        } else {
            return patientService.getAllPatients();
        }
    }
    */
}