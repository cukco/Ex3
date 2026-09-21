package com.example.demo.Controller;

import com.example.demo.DTO.PatientCreateDTO;
import com.example.demo.Model.Patient;
import com.example.demo.Service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {
    @Autowired
    private PatientService  patientService;

    @PostMapping
    public ResponseEntity<?> addPatient(@RequestBody PatientCreateDTO  dto) {
        log.info("Tiếp nhận bệnh nhân mới: {}", dto.getName());
        int age=LocalDate.now().getYear()-dto.getDob().getYear();
        if ( age> 120) {
            log.warn("CẢNH BÁO: Bệnh nhân {} có số tuổi bất thường: {} tuổi",
                    dto.getName(), age);
        }
        Patient patient=patientService.addPatient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }
}
