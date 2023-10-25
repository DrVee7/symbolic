package com.symbolic.symbolic.repository;

import com.symbolic.symbolic.entity.MedicalPractitioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalPractitionerRepository extends JpaRepository<MedicalPractitioner, Long> {
    List<MedicalPractitioner> findMedicalPractitionerByPatientsId(Long patientId);   List<MedicalPractitioner> findByLatitudeBetweenAndLongitudeBetween(
            Double minLatitude,
            Double minLongitude,
            Double maxLatitude,
            Double maxLongitude);

}
