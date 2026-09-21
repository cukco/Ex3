package com.example.demo.Service;

import com.example.demo.DTO.PatientCreateDTO;
import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient addPatient(PatientCreateDTO  dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setGender(dto.getGender());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setAddress(dto.getAddress());
        patient.setDob(dto.getDob());
        return patientRepo.save(patient);
    }

}
