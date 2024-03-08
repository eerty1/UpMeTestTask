package com.upme.crud_service.coordinates_calculation_pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatternStorage {

    /*
    This is the way I understood the part of the task about "patterns".
    In order to implement "patterns" I decided to use Strategy pattern;
    It seems to me that this approach is a very convenient solution to make calculation patterns interchangeable, as the task demands
    Here "coordinatesCalculationPatterns" list is a storage, where different implementations of the patterns are stored
    and fetched by name when selected in thymeleaf template
    */


    public final List<CoordinatesCalculationPattern> coordinatesCalculationPatterns = new ArrayList<>();

    @Autowired
    public PatternStorage(DefaultPattern defaultPattern) {
        coordinatesCalculationPatterns.add(defaultPattern);
    }
}
