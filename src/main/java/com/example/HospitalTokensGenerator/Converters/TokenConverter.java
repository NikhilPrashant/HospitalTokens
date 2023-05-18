package com.example.HospitalTokensGenerator.Converters;

import com.example.HospitalTokensGenerator.DTOs.TokenEntryDto;
import com.example.HospitalTokensGenerator.Entities.HealthcardEntity;
import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import com.example.HospitalTokensGenerator.Entities.TokenEntity;
import com.example.HospitalTokensGenerator.Enums.Counters;
import com.example.HospitalTokensGenerator.Repositories.HealthCardRepository;
import com.example.HospitalTokensGenerator.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TokenConverter {

    public static TokenEntity tokenDtoToEntity(PatientEntity patient, HealthcardEntity healthcard, Counters counter) {
        TokenEntity tokenEntity = TokenEntity.builder().patient(patient).healthcard(healthcard).counter(counter).creationDate(LocalDate.now()).build();
        return tokenEntity;
    }
}
