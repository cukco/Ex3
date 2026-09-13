package com.example.demo.DTO;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDTO {
    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    @Nullable
    @Size(max = 100)
    private String description;

    public DepartmentDTO() {}
    public DepartmentDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}
