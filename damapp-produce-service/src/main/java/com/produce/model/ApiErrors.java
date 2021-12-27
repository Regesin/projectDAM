package com.produce.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiErrors {

    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String path;
}
