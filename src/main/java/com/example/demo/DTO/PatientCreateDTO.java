package com.example.demo.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class PatientCreateDTO {
    private String name;

    private LocalDate dob;

    private String address;

    private String phoneNumber;

    private String gender;

    public PatientCreateDTO() {}
    public PatientCreateDTO(String name, String address, String phoneNumber, String gender) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

}
