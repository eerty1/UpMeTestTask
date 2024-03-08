package com.upme.crud_service.coordinates_calculation_pattern;

import com.upme.decimal_utils.DecimalUtils;
import com.upme.model.Detail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("defaultPattern")
@RequiredArgsConstructor
@Getter
public class DefaultPattern implements CoordinatesCalculationPattern {
    private final String name = "Default pattern";
    private final DecimalUtils decimalUtils;

    @Override
    public Double calculatePosition(Detail detail) {
        return decimalUtils.setScale(
                detail.getLength() / 2 + detail.getWidth() * 0.5 + detail.getHeight() / 3
        );
    }
}
