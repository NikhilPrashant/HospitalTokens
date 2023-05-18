package com.example.HospitalTokensGenerator.Entities;

import com.example.HospitalTokensGenerator.Enums.Counters;
import com.example.HospitalTokensGenerator.Functions.SlipGenerator;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
@Table(name = "tokens")
@Data
@AllArgsConstructor
@Builder
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tokenId;

    @ManyToOne
    @JoinColumn
    private HealthcardEntity healthcard;

    @OneToOne
    @JoinColumn
    private PatientEntity patient;

    private Counters counter;

    private int tokenNumber;

    private LocalDate creationDate;

    private boolean isActive;

    private boolean isCancelled;

    @Nullable
    private String suggestion;

    public TokenEntity() {
        this.creationDate = LocalDate.now();
    }

    public void setTokenId() {
        this.tokenNumber = SlipGenerator.getCurrSlip();
        this.tokenId = new StringBuilder()
                .append(creationDate).append("_")
                .append(tokenNumber)
                .append("_").append(counter.getId())
                .append("_").append(patient.getId())
                .append("_").append(healthcard.getHipId())
                .toString();
    }
}
