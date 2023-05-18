package com.example.HospitalTokensGenerator.Services;

import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import com.example.HospitalTokensGenerator.Entities.TokenEntity;
import com.example.HospitalTokensGenerator.Repositories.PatientRepository;
import com.example.HospitalTokensGenerator.Repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TokenRepository tokenRepository;

    public String appointment(Long tokenId) throws Exception {
        try {
            TokenEntity token = tokenRepository.findById(tokenId).get();
            PatientEntity patient = patientRepository.findById(token.getPatient().getId()).get();
            token.setActive(false);
            patient.setActiveTokenEntity(token);
            patient.setHasActiveToken(false);
            patientRepository.save(patient);
            return "Success";
        } catch (Exception e) {
            throw e;
        }
    }
}
