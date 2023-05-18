package com.example.HospitalTokensGenerator.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "slips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int currSlip = 1;

    private LocalDate localDate;
}
