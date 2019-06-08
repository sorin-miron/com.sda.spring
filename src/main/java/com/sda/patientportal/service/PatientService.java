package com.sda.patientportal.service;

import com.sda.patientportal.model.Patient;
import com.sda.patientportal.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService() {
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient getById(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public List<Patient> getByLastName(String lastName){
        Optional<List<Patient>> patients = patientRepository.findByLastName(lastName);
        return patients.orElse(null);
    }

    public Patient update(Patient patient){
        return patientRepository.save(patient);
    }

    public void delete(Long id){
        patientRepository.deleteById(id);
    }

}
