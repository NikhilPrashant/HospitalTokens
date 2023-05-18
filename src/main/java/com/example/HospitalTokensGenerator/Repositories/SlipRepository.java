package com.example.HospitalTokensGenerator.Repositories;

import com.example.HospitalTokensGenerator.Entities.SlipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlipRepository extends JpaRepository<SlipEntity, Integer> {
}
