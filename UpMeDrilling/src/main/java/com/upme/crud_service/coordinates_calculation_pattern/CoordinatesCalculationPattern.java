package com.upme.crud_service.coordinates_calculation_pattern;

import com.upme.model.Detail;

public interface CoordinatesCalculationPattern {
    String getName();

    Double calculatePosition(Detail detail);
}
