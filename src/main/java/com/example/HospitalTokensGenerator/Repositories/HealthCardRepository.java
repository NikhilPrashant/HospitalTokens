package com.example.HospitalTokensGenerator.Repositories;

import com.example.HospitalTokensGenerator.Entities.HealthcardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCardRepository extends JpaRepository<HealthcardEntity, String> {
}
