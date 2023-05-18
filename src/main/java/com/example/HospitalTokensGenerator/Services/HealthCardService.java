package com.example.HospitalTokensGenerator.Services;

import com.example.HospitalTokensGenerator.Entities.HealthcardEntity;
import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import org.springframework.stereotype.Service;

@Service
public class HealthCardService {

    public HealthcardEntity addHealthCard(PatientEntity patient) {
        HealthcardEntity healthcard = new HealthcardEntity();
        healthcard.setHipId(patient.getId() + "_" + patient.getName());
        healthcard.setPatient(patient);
        return healthcard;
    }
}
