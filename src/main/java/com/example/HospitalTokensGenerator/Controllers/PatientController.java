package com.example.HospitalTokensGenerator.Controllers;

import com.example.HospitalTokensGenerator.DTOs.PatientEntryDto;
import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import com.example.HospitalTokensGenerator.Repositories.PatientRepository;
import com.example.HospitalTokensGenerator.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@RequestBody PatientEntryDto patientEntryDto) {
        try {
            System.out.println(patientEntryDto);
            String response = patientService.addPatient(patientEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
