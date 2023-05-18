package com.example.HospitalTokensGenerator.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String name;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private HealthcardEntity healthcardEntity;

    private boolean hasActiveToken;

    @Nullable
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private TokenEntity activeTokenEntity;
}
