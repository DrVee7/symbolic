package com.symbolic.symbolic.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "appointment")
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

    public Long getId() {
        return id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Date getSchedule() {
        return schedule;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}