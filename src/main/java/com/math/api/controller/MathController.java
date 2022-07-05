package com.math.api.controller;

import com.math.api.common.Routes;
import com.math.api.common.error.ResourceNotFoundException;
import com.math.api.entity.Maths;
import com.math.api.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MathController {

    @Autowired
    private MathService service;

    @PostMapping(path = Routes.MIN)
    public ResponseEntity<Integer> min(
            @Valid @RequestBody Maths maths
    ) {
        try {
            return new ResponseEntity<>(service.min(maths), HttpStatus.OK);
        }catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

}
