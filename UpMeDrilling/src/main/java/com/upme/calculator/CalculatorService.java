package com.upme.calculator;

import com.upme.decimal_utils.DecimalUtils;
import com.upme.model.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    private final DecimalUtils decimalUtils;

    public double add(Calculator calculator) {
        return calculator.getA() + calculator.getB();
    }

    public double subtract(Calculator calculator) {
        return calculator.getA() - calculator.getB();
    }

    public double multiply(Calculator calculator) {
        return calculator.getA() * calculator.getB();
    }

    public double divide(Calculator calculator) {
        return decimalUtils.setScale(calculator.getA() / calculator.getB());
    }
}
