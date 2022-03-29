package com.hastobe.csms.controller;

import com.hastobe.csms.util.DateConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity generateResponse( String message, HttpStatus status, Object responseObj) {
        Map<String, Object> body = new HashMap();
        body.put("message", message);
        body.put("status", status.value());
        body.put("data", responseObj);
        body.put("timestamp", DateConverter.getLocalDateTimeAsString());

        return new ResponseEntity(body,status);
    }

}
