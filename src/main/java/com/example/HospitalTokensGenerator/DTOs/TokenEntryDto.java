package com.example.HospitalTokensGenerator.DTOs;

import com.example.HospitalTokensGenerator.Enums.Counters;
import lombok.Data;

@Data
public class TokenEntryDto {

    int patientId;
    String counter;
}
