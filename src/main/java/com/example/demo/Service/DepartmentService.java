package com.example.demo.Service;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.Model.Department;
import com.example.demo.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public Department createDepartment(DepartmentDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        return departmentRepo.save(department);
    }
}
