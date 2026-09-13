package com.example.demo.Exception;

import com.example.demo.ApiResponse;
import org.apache.http.MethodNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String,String>> handleException(MethodArgumentNotValidException e) {
        Map<String,String> map = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            map.put(fieldName, errorMessage);
        });
        return new ApiResponse<>("FAIL","Invalid Data",map);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse<String> handleException(DuplicateResourceException e) {
        return new ApiResponse<>("FAIL",e.getMessage(),null);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<String> handleException(ResourceNotFoundException e) {
        return new ApiResponse<>("FAIL",e.getMessage(),null);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.CONTENT_TOO_LARGE)
    public ApiResponse<String> handleException(MaxUploadSizeExceededException e) {
        return new ApiResponse<>("FAIL","Max file size is 2MB",null);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> handleException(RuntimeException e) {
        return new ApiResponse<>("FAIL",e.getMessage(),null);
    }

}
