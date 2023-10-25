package com.symbolic.symbolic.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "hospitals")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "appointment_id")
    private Long appointmentId;
    @Column(name = "schedule")
    private Date schedule;
    @Column(name = "cost")
    private BigDecimal cost;
    @ManyToMany(
            fetch=FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "practitioner_appointment",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id")
    )
    private Set<Patient> patients;

    public Appointment(Long appointmentId, Date schedule, BigDecimal cost) {
        this.appointmentId = appointmentId;
        this.schedule = schedule;
        this.cost = cost;
    }
}