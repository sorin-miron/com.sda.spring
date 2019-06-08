package com.sda.patientportal.controller;

import com.sda.patientportal.model.Patient;
import com.sda.patientportal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(@RequestParam(name = "lastName", required = false) String lastName) {
        if (lastName != null) {
            return patientService.getByLastName(lastName);
        }
        return patientService.getAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        patient.setId(null); // ca sa nu bag in seama id-ul primit de la client
        Patient patient1 = patientService.create(patient);
        System.out.println("Patient " + patient1.getFirstName() + " " + patient1.getLastName() + " created.");
        return patient1;
    }

    @GetMapping(value = "/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
        if (!id.equals(patient.getId())) {
            throw new RuntimeException("Ids do not match");
        }
        if (patientService.getById(patient.getId()) != null)
            return patientService.update(patient);
        throw new RuntimeException("Patient not found");
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
        System.out.println("Patient deleted");
    }
}
