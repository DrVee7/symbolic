package com.symbolic.symbolic.controller;

/*
import com.symbolic.symbolic.entity.Appointment;
import com.symbolic.symbolic.entity.Prescription;
import com.symbolic.symbolic.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionController {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/prescriptions")
    public ResponseEntity<?> getAllPrescriptions(){
        List<Prescription> prescriptions = new ArrayList<>();
        prescriptions.addAll(prescriptionRepository.findAll());

        if (prescriptions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

//    @GetMapping("/prescription")
//    public ResponseEntity<?> getAllPrescription(@RequestParam("id")Long id){
//
//    }
}*/
