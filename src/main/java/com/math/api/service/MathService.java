package com.math.api.service;

import com.math.api.entity.Maths;

import java.util.List;

public interface MathService {
    List<Integer> min(Maths numbers) throws Exception;
    List<Integer> max(Maths numbers) throws Exception;
    double avg(List<Integer> numbers);

    double median(List<Integer> numbers);

    double percentile(List<Integer> numbers, Double percentile) throws Exception;
}
