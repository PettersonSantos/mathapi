package com.math.api.service.impl;

import com.math.api.entity.Maths;
import com.math.api.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MathServiceImplTest {
    private MathService service;

    @BeforeEach
    void initUseCase(){
        service = new MathServiceImpl();
    }

    @Test
    public void testMinReturnNoError() throws Exception {
        Maths maths = new Maths();
        List<Integer> list = new ArrayList<>();
        List<Integer> wait = new ArrayList<>();
        Collections.addAll(list, 2, 1, 4, 3, 5, 6);
        Collections.addAll(wait, 2,1);
        maths.setNumbers(list);
        maths.setQualifier(3);
        List<Integer> resp = service.min(maths);
        Assertions.assertEquals(resp, wait);
    }

    @Test
    public void testMaxReturnNoError() throws Exception {
        Maths maths = new Maths();
        List<Integer> list = new ArrayList<>();
        List<Integer> wait = new ArrayList<>();
        Collections.addAll(list, 2, 1, 4, 3, 5, 6);
        Collections.addAll(wait, 4,5,6);
        maths.setNumbers(list);
        maths.setQualifier(3);
        List<Integer> resp = service.max(maths);
        Assertions.assertEquals(resp, wait);
    }

    @Test
    public void testAvgReturnNoError() throws Exception {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 2, 1, 4, 3, 5, 6);

        double resp = service.avg(list);
        Assertions.assertEquals(resp, 3.5);
    }

    @Test
    public void testMedianReturnNoError() throws Exception {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 2, 1, 4, 3, 5, 6);

        double resp = service.median(list);
        Assertions.assertEquals(resp, 3.5);
    }

    @Test
    public void testPercentileReturnNoError() throws Exception {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0,1,2,3,4,5,6,7,8,9,10);


        Assertions.assertEquals(service.percentile(list, 20.0), 2.0);
        Assertions.assertEquals(service.percentile(list, 80.0), 8.0);
        Assertions.assertEquals(service.percentile(list, 100.0), 10.0);
    }

    @Test
    public void testPercentileOthersValues() throws Exception {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0,1,2,3);

        Assertions.assertEquals(service.percentile(list, 51.0), 2.0);
        Assertions.assertEquals(service.percentile(list, 49.0), 1.0);
    }


}
