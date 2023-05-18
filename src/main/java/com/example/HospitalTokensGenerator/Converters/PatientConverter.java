package com.example.HospitalTokensGenerator.Converters;

import com.example.HospitalTokensGenerator.DTOs.PatientEntryDto;
import com.example.HospitalTokensGenerator.Entities.PatientEntity;

public class PatientConverter {

    public static PatientEntity patientDtoToEntity(PatientEntryDto patientEntryDto) {
        PatientEntity patient = PatientEntity.builder().name(patientEntryDto.getName()).build();
        return patient;
    }
}
