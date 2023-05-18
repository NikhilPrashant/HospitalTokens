package com.example.HospitalTokensGenerator.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "health_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthcardEntity {

    @Id
    @Column(unique = true)
    private String hipId;

    @OneToOne
    @JoinColumn
    private PatientEntity patient;

    @OneToMany(mappedBy = "healthcard", cascade = CascadeType.ALL)
    private List<TokenEntity> tokenEntities = new ArrayList<>();

    public HealthcardEntity(String hipId) {
        this.hipId = hipId;
    }
}
