package com.sda.patientportal.controller;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAll();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.create(doctor);
    }

    @GetMapping(value = "/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable Long id){
        if(!id.equals(doctor.getId())){
            return null;
        } else
            return doctorService.update(doctor);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Long id){
        doctorService.delete(id);
        System.out.println("Doctor deleted");
    }
}
