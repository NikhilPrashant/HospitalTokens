package com.example.HospitalTokensGenerator.Services;

import com.example.HospitalTokensGenerator.Converters.TokenConverter;
import com.example.HospitalTokensGenerator.DTOs.TokenEntryDto;
import com.example.HospitalTokensGenerator.Entities.HealthcardEntity;
import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import com.example.HospitalTokensGenerator.Entities.TokenEntity;
import com.example.HospitalTokensGenerator.Enums.Counters;
import com.example.HospitalTokensGenerator.Repositories.HealthCardRepository;
import com.example.HospitalTokensGenerator.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HealthCardRepository healthCardRepository;

    public String createToken(TokenEntryDto tokenEntryDto) throws Exception {
        try {
            PatientEntity patient = patientRepository.findById(tokenEntryDto.getPatientId()).get();
            HealthcardEntity healthcard = healthCardRepository.findById(patient.getHealthcardEntity().getHipId()).get();
            Counters counter = Counters.valueOf(tokenEntryDto.getCounter());
            TokenEntity token = TokenConverter.tokenDtoToEntity(patient, healthcard, counter);
            token.setTokenId();
            //Minimize or Shift
            token.setActive(true);
            patient.setHasActiveToken(true);
            patient.setActiveTokenEntity(token);
            //Here
            //Udate List Fn
            List<TokenEntity> tokenEntities = healthcard.getTokenEntities();
            tokenEntities.add(token);
            healthcard.setTokenEntities(tokenEntities);
            patient.setHealthcardEntity(healthcard);
            patientRepository.save(patient);
            //Here
            return "Success";
        } catch (Exception e) {
            throw e;
        }
    }
}
