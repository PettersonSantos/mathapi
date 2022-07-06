package com.math.api.service.impl;

import com.math.api.entity.Maths;
import com.math.api.service.MathService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public List<Integer> max(Maths numbers) throws Exception {

        if (numbers.getQualifier() == null) {
            throw new Exception("Qualifier is null or empty");
        }

        List<Integer> t = new ArrayList<>();

        for (int elem : numbers.getNumbers())
            if (elem > numbers.getQualifier()) t.add(elem);

        return t;
    }

    @Override
    public List<Integer> min(Maths numbers) throws Exception{

        if (numbers.getQualifier() == null) {
            throw new Exception("Qualifier is null or empty");
        }

        List<Integer> t = new ArrayList<>();

        for (int elem : numbers.getNumbers())
            if (elem < numbers.getQualifier()) t.add(elem);

        return t;
    }

    @Override
    public double avg(List<Integer> numbers) {

        double n = 0;

        for (int elem : numbers)
            n += elem;

        return n / numbers.size();
    }

    @Override
    public double median(List<Integer> numbers) {
        Collections.sort(numbers);
        double median;
        int totalElem = numbers.size();

        if (totalElem %2 ==0) {
            int sumOfMiddleElements = numbers.get(totalElem / 2) +
                    numbers.get(totalElem / 2 - 1);
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            median = (double) numbers.get(numbers.size() / 2);
        }
        return median;
    }

    @Override
    public double percentile(List<Integer> numbers, Double percentile) throws Exception {

        if (percentile.equals(0.0)) {
            throw new Exception("Percentile is null or empty");
        }

        Collections.sort(numbers);

        return numbers.get((int) Math.round(percentile / 100.0 * (numbers.size() - 1)));
    }
}
