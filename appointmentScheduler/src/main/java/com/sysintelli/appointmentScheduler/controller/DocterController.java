package com.sysintelli.appointmentScheduler.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sysintelli.appointmentScheduler.configuration.SlotInfo;
import com.sysintelli.appointmentScheduler.model.Doctor;
import com.sysintelli.appointmentScheduler.service.DoctorService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctorsList")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/totalAvailableSlots/{doctorId}")
    public ResponseEntity<List<SlotInfo>> getTotalAvailableSlotsByDay(
            @PathVariable Long doctorId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<SlotInfo> totalSlotsByDay = doctorService.getTotalAvailableSlotsByDay(doctorId, startDate, endDate);
        return ResponseEntity.ok(totalSlotsByDay);
    }
}