package com.example.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.CloudinaryConfig;
import com.example.demo.DTO.EmployeeCreateDTO;
import com.example.demo.DTO.EmplyeeUpdateDTO;
import com.example.demo.Exception.DuplicateResourceException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.DepartmentRepo;
import com.example.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private Cloudinary cloudinary;


    public Employee create(EmployeeCreateDTO dto) {
        if(!departmentRepo.existsById(dto.getDepartmentId())) {throw new ResourceNotFoundException("Department not found");}

        if(employeeRepo.existsEmployeesByEmail(dto.getEmail())) {throw new DuplicateResourceException("Email already exists");}

        Employee employee = new Employee();
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());
        employee.setDepartmentId(dto.getDepartmentId());
        employee.setFullName(dto.getFullName());
        return employeeRepo.save(employee);
    }

    public Employee updateAvatar(EmplyeeUpdateDTO dto) throws IOException {
        Employee employee = employeeRepo.findById(dto.getId()).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Map map= cloudinary.uploader().upload(dto.getFile().getInputStream(), ObjectUtils.emptyMap());
        String url=map.get("url").toString();
        employee.setAvatarUrl(url);
        return employeeRepo.save(employee);
    }

}
