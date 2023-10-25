package com.symbolic.symbolic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "prescription")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Prescription {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dosage")
    private Integer dosage;

    @Column(name = "frequency")
    private Integer frequency;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "instructions")
    private String instructions;

    public Prescription(Integer dosage, Integer frequency, BigDecimal cost, String instructions) {
        this.dosage = dosage;
        this.frequency = frequency;
        this.cost = cost;
        this.instructions = instructions;
    }
}