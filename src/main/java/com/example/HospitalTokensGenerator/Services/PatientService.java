package com.example.HospitalTokensGenerator.Services;

import com.example.HospitalTokensGenerator.Converters.PatientConverter;
import com.example.HospitalTokensGenerator.DTOs.PatientEntryDto;
import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import com.example.HospitalTokensGenerator.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private HealthCardService healthCardService;

    @Autowired
    private PatientRepository patientRepository;

    public String addPatient(PatientEntryDto patientEntryDto) throws Exception {
        try {
            PatientEntity patient = PatientConverter.patientDtoToEntity(patientEntryDto);
            patient = patientRepository.save(patient);
            patient.setHealthcardEntity(healthCardService.addHealthCard(patient));
            patientRepository.save(patient);
            return "Success";
        } catch (Exception e) {
            throw e;
        }
    }
}
