package com.example.HospitalTokensGenerator.Entities;

import com.example.HospitalTokensGenerator.Enums.Counters;
import com.example.HospitalTokensGenerator.Functions.SlipGenerator;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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

    private LocalDate creationDate;

    private boolean isActive;

    private boolean isCancelled;

    @Nullable
    private String suggestion;

    public TokenEntity() {
        this.creationDate = LocalDate.now();
    }

    public void setTokenId() {
        this.tokenId = "" + creationDate + "_" + SlipGenerator.getCurrSlip() + "_" + counter.getId() + "_" + patient.getId() + "_" + healthcard.getHipId();
    }
}
