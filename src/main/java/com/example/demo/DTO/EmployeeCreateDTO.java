package com.example.demo.DTO;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class EmployeeCreateDTO {
    @NotNull
    private String fullName;

    @Email
    private String email;

    @Pattern(regexp = "^0(3|5|7|8|9)[0-9]{8}$")
    private String phone;

    @Min(value = 5000000)
    private Double salary;

    @NotNull
    private Long departmentId;

    public EmployeeCreateDTO() {}
    public EmployeeCreateDTO(String email, String phone, double salary, Long departmentId, String fullName) {
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
        this.fullName = fullName;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Double getSalary() {return salary;}
    public void setSalary(Double salary) {this.salary = salary;}
    public Long getDepartmentId() {return departmentId;}
    public void setDepartmentId(Long departmentId) {this.departmentId = departmentId;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}


}
