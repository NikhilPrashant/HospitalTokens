package com.example.HospitalTokensGenerator.Repositories;

import com.example.HospitalTokensGenerator.Entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
}
