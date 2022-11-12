package com.tahir.artificialintelligence.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class TestUtils {

    public static <T> ResponseEntity<T> okResponse(T payload){
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
    public static String asJsonString(final Object jsonObject){
        try {
            return new ObjectMapper().writeValueAsString(jsonObject);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
