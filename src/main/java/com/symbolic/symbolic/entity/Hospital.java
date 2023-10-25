package com.symbolic.symbolic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "hospitals")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Hospital {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "facility_id")
    private Long facilityId;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "specialization")
    private String speceialization;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "hospital_patients",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;

    public Hospital(Long facilityId, Double longitude, Double latitude, String speceialization) {
        this.facilityId = facilityId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.speceialization = speceialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getSpeceialization() {
        return speceialization;
    }

    public void setSpeceialization(String speceialization) {
        this.speceialization = speceialization;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
