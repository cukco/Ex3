package com.example.demo.DTO;

import com.example.demo.Extension.FileExtension;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class EmplyeeUpdateDTO {
    @NotNull
    private Long id;

    @NotNull
    @FileExtension
    private MultipartFile file;

    public EmplyeeUpdateDTO() {}

    public EmplyeeUpdateDTO(Long id, MultipartFile file) {
        this.id = id;
        this.file = file;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public MultipartFile getFile() {return file;}
    public void setFile(MultipartFile file) {this.file = file;}

}
