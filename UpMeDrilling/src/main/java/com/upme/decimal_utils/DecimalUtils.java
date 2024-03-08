package com.upme.decimal_utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

@Component
public class DecimalUtils {

    public Double setScale(Double value) {
        return BigDecimal
                .valueOf(value)
                .setScale(2, HALF_UP)
                .doubleValue();
    }
}
