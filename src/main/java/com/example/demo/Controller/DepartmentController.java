package com.example.demo.Controller;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.Model.Department;
import com.example.demo.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DepartmentDTO dto) {
        Department department = departmentService.createDepartment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }
}
