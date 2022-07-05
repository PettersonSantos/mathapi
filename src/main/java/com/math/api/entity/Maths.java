package com.math.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Maths {
    @NotNull
    private List<Integer> numbers;
    @NotNull
    private Integer qualifier;
}
