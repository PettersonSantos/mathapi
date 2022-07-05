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
    public void testMinReturnNoError(){
        Maths maths = new Maths();
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 2, 1, 4, 3, 5, 6);
        maths.setNumbers(list);
        maths.setQualifier(6);
        int resp = service.min(maths);
        Assertions.assertEquals(resp, 1);
    }
}
