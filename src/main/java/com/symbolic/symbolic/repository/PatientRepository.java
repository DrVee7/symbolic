package com.symbolic.symbolic.repository;

import com.symbolic.symbolic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findPatientsByPractitionersId(Long practitionerId);

}
