package com.example.HospitalTokensGenerator.Repositories;

import com.example.HospitalTokensGenerator.Entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    @Query(value = "UPDATE tokens SET is_cancelled = true WHERE is_active = true;", nativeQuery = true)
    void cancelTokens();
    @Query(value = "UPDATE tokens SET is_active = false;", nativeQuery = true)
    void deactivateTokens();
}
