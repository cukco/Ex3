package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Double salary;

    @Column(name = "department_id")
    private Long departmentId;

    @Column
    private String avatarUrl;


    public Employee() {}
    public Employee(String fullName, String email, String phone, Double salary, Long departmentId, String avatarUrl) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Double getSalary() {return salary;}
    public void setSalary(Double salary) {this.salary = salary;}
    public Long getDepartmentId() {return departmentId;}
    public void setDepartmentId(Long id) {this.departmentId = id;}
    public String getAvatarUrl() {return avatarUrl;}
    public void setAvatarUrl(String avatarUrl) {this.avatarUrl = avatarUrl;}

}
