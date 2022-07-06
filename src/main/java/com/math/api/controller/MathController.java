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
import java.util.List;

@RestController
public class MathController {

    @Autowired
    private MathService service;

    @PostMapping(path = Routes.MIN)
    public ResponseEntity<List<Integer>> min(
            @Valid @RequestBody Maths maths
    ) {
        try {
            return new ResponseEntity<>(service.min(maths), HttpStatus.OK);
        }catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping(path = Routes.MAX)
    public ResponseEntity<List<Integer>> max(
            @Valid @RequestBody Maths maths
    ) {
        try {
            return new ResponseEntity<>(service.max(maths), HttpStatus.OK);
        }catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping(path = Routes.AVG)
    public ResponseEntity<Double> avg(
            @Valid @RequestBody Maths maths
    ) {
        try {
            return new ResponseEntity<>(service.avg(maths.getNumbers()), HttpStatus.OK);
        }catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping(path = Routes.MEDIAN)
    public ResponseEntity<Double> median(
            @Valid @RequestBody Maths maths
    ) {
        try {
            return new ResponseEntity<>(service.median(maths.getNumbers()), HttpStatus.OK);
        }catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping(path = Routes.PERCENTILE)
    public ResponseEntity<Double> percentile(
            @Valid @RequestBody Maths maths
    ) {
        try {
            return new ResponseEntity<>(service.percentile(maths.getNumbers(), maths.getPercentile()), HttpStatus.OK);
        }catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

}
