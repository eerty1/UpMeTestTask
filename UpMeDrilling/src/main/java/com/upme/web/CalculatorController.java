package com.upme.web;

import com.upme.calculator.CalculatorService;
import com.upme.crud_service.CoordinatesCrudService;
import com.upme.model.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.upme.navigation.ViewName.CALCULATOR;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final CoordinatesCrudService coordinatesCrudService;

    @ModelAttribute("calculator")
    public Calculator getCalculator() {
        return new Calculator();
    }

    @ModelAttribute("coordinates")
    public List<Double> getBothCoordinates() {
        return coordinatesCrudService.getBothCoordinates();
    }

    @GetMapping
    public String showCalculatorPage() {
        return "calculator";
    }

    @PostMapping(params = "addition")
    public String add(@ModelAttribute("calculator") Calculator calculator, Model model) {
        model.addAttribute("result", calculatorService.add(calculator));
        return CALCULATOR.getName();
    }

    @PostMapping(params = "subtraction")
    public String subtract(@ModelAttribute("calculator") Calculator calculator, Model model) {
        model.addAttribute("result", calculatorService.subtract(calculator));
        return CALCULATOR.getName();
    }

    @PostMapping(params = "multiplication")
    public String multiply(@ModelAttribute("calculator") Calculator calculator, Model model) {
        model.addAttribute("result", calculatorService.multiply(calculator));
        return CALCULATOR.getName();
    }

    @PostMapping(params = "division")
    public String divide(@ModelAttribute("calculator") Calculator calculator, Model model) {
        model.addAttribute("result", calculatorService.divide(calculator));
        return CALCULATOR.getName();
    }
}
