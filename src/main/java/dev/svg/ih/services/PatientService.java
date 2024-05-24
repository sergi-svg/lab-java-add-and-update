package dev.svg.ih.services;


import dev.svg.ih.models.Doctor;
import dev.svg.ih.models.Patient;
import dev.svg.ih.repositories.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientsById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientsByDateOfBirth(String dateOfBirth) {
        return patientRepository.findByDateOfBirth(dateOfBirth);
    }

    public List<Patient> getPatientsByDoctor(Doctor doctor) {
        return patientRepository.findPatientsByDoctor(doctor);
    }

    public List<Patient> getPatientsByDateOfBirthAndDoctor(String dateOfBirth, Doctor doctor) {
        return patientRepository.findByDateOfBirthAndDoctor(dateOfBirth, doctor);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(long id,Patient patient) {
        if (patientRepository.findById(id).isPresent()) {
            return patientRepository.save(patient);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}