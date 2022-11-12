package com.tahir.artificialintelligence.models;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponseData{
    private HttpStatus status;
    private List<Response> response;
    private String error;
    private LocalDateTime timestamp;

    public ResponseData() {
    }

    public ResponseData(List<Response> response) {
        this.status = HttpStatus.OK;
        this.response = response;
        this.error = null;
        this.timestamp = LocalDateTime.now();
    }
}
