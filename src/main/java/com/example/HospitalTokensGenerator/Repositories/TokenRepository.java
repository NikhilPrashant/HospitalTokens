package com.example.HospitalTokensGenerator.Repositories;

import com.example.HospitalTokensGenerator.Entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
}
