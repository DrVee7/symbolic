package com.symbolic.symbolic.controller;

import com.symbolic.symbolic.entity.Hospital;
import com.symbolic.symbolic.entity.MedicalPractitioner;
import com.symbolic.symbolic.entity.Patient;
import com.symbolic.symbolic.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping("/hospitals")
    public ResponseEntity<?> getAllHospitals(){
        List<Hospital> hospitals = new ArrayList<>();
        hospitals.addAll(hospitalRepository.findAll());

        if (hospitals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    @GetMapping("/hospital")
    public ResponseEntity<?> getHospital(@RequestParam("id")Long id){
        Optional<Hospital> hospitalData = hospitalRepository.findById(id);

        if (hospitalData.isPresent()) {
            Hospital hospital = hospitalData.get();
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            String errorMessage = "No hospital found with id " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/hospital")
    public ResponseEntity<?> addHospitalFacility(@RequestBody Hospital hospital){
        Hospital newHospital = new Hospital(
                hospital.getFacilityId(),
                hospital.getLatitude(),
                hospital.getLongitude(),
                hospital.getSpeceialization()
        );
        hospitalRepository.save(newHospital);
        return new ResponseEntity<>(newHospital, HttpStatus.CREATED);
    }

    @PutMapping("/hospital")
    public ResponseEntity<?> updateHospital(@RequestParam("id") Long id, @RequestBody Hospital hospital) {
        Optional<Hospital> hospital1 = hospitalRepository.findById(id);

        if (hospital1.isPresent()) {
            Hospital hospitalData = hospital1.get();
            hospitalData.setFacilityId(hospital.getFacilityId());
            hospitalData.setLatitude(hospital.getLatitude());
            hospitalData.setLongitude(hospital.getLongitude());
            hospitalData.setSpeceialization(hospital.getSpeceialization());
            hospitalRepository.save(hospitalData);

            return new ResponseEntity<>(hospitalData, HttpStatus.OK);
        } else {
            String errorMessage = "No hospital found with id " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/hospital")
    public ResponseEntity<?> deleteHospital(@RequestParam("id")Long id){
        if (hospitalRepository.existsById(id)) {
            hospitalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            String errorMessage = "No Hospital found with id " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}
