package com.upme.crud_service.coordinates_calculation_pattern;


import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatternConverter implements Converter<String, CoordinatesCalculationPattern> {
    private final PatternStorage patternStorage;
    private final CoordinatesCalculationPattern defaultPattern;

    @Override
    public CoordinatesCalculationPattern convert(@NonNull String source) {
        return patternStorage.coordinatesCalculationPatterns
                .stream()
                .filter(pattern -> pattern.getName().equals(source))
                .findAny()
                .orElse(defaultPattern);
    }
}
