package com.example.demo.Controller;

import com.example.demo.DTO.EmployeeCreateDTO;
import com.example.demo.DTO.EmplyeeUpdateDTO;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeCreateDTO dto) {
        Employee employee = employeeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}/avatar")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmplyeeUpdateDTO dto)  {
        try {
            Employee employee = employeeService.updateAvatar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        } catch (java.net.SocketTimeoutException e) {
            throw new RuntimeException("Kết nối tới Cloudinary quá lâu, vui lòng thử lại!");
        } catch (IOException e) {
            throw new RuntimeException("Lỗi đọc/ghi file trong quá trình upload: " + e.getMessage());
        }

    }
}
