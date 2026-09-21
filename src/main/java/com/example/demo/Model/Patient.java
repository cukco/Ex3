package com.example.demo.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDate dob;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String gender;

    public Patient() {}

    public Patient(Long id, String name, LocalDate dob, String address, String phoneNumber, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public LocalDate getDob() {return dob;}
    public void setDob(LocalDate dob) {this.dob = dob;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

}
