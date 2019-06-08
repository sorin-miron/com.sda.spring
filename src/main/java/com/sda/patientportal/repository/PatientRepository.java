package com.sda.patientportal.repository;

import com.sda.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<List<Patient>> findByLastName(String lastName);
}
