package com.dishe.vip.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiErrorBody {

    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
