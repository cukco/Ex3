package com.example.demo.Exception;

import com.example.demo.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error("Lỗi hệ thống xảy ra:",e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(new ApiResponse<>("ERROR","Đã có lỗi xảy ra",e.getMessage()));

    }
}
