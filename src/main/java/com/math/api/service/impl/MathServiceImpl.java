package com.math.api.service.impl;

import com.math.api.entity.Maths;
import com.math.api.service.MathService;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public int min(Maths numbers) throws Exception{
        int[] elements = new int[numbers.getQualifier() + 1];
        for (int i = 1; i <= numbers.getQualifier(); i++) elements[i] = Integer.MAX_VALUE;
        for (int elem : numbers.getNumbers())
            for (int i = numbers.getQualifier(); i >= elem; i--)
                if (elements[i - elem] != Integer.MAX_VALUE)
                    elements[i] = Math.min(elements[i], elements[i - elem] + 1);
        return elements[numbers.getQualifier()];
    }
}
