package com.example.HospitalTokensGenerator.Controllers;

import com.example.HospitalTokensGenerator.DTOs.AppointmentDto;
import com.example.HospitalTokensGenerator.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PutMapping("/completed")
    public ResponseEntity<String> appointment(@RequestBody AppointmentDto appointmentDto) {
        try {
            String response = appointmentService.appointment(appointmentDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
