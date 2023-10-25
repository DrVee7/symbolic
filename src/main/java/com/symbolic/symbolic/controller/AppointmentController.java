package com.symbolic.symbolic.controller;

import com.symbolic.symbolic.entity.Appointment;
import com.symbolic.symbolic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public ResponseEntity<?> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        appointments.addAll(appointmentRepository.findAll());

        if (appointments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/appointment")
    public ResponseEntity<?> getAppointment(@RequestParam("id") Long id) {
        Optional<Appointment> appointmentData = appointmentRepository.findById(id);

        if (appointmentData.isPresent()) {
            Appointment appointment = appointmentData.get();
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } else {
            String errorMessage = "No appointment found with id " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = new Appointment(
                appointment.getAppointmentId(),
                appointment.getSchedule(),
                appointment.getCost()
        );
        appointmentRepository.save(newAppointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }


    @PutMapping("/appointment")
    public ResponseEntity<?> updateAppointment(@RequestParam("id") Long id, @RequestBody Appointment appointment) {
        Optional<Appointment> appointment1 = appointmentRepository.findById(id);

        if (appointment1.isPresent()) {
            Appointment appointmentData = appointment1.get();
            appointmentData.setAppointmentId(appointment.getAppointmentId());
            appointmentData.setSchedule(appointment.getSchedule());
            appointmentData.setCost(appointment.getCost());

            appointmentRepository.save(appointmentData);

            return new ResponseEntity<>(appointmentData, HttpStatus.OK);
        } else {
            String errorMessage = "No appointment found with id " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/appointment")
    public ResponseEntity<?> deleteAppointment(@RequestParam("id") Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            String errorMessage = "No appointment found with id " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}
