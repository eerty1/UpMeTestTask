package com.upme.model;

import com.upme.crud_service.coordinates_calculation_pattern.CoordinatesCalculationPattern;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.upme.model.ValidationErrorMessages.NOT_EMPTY;
import static com.upme.model.ValidationErrorMessages.RIGHT_ANGLE;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Hole {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotNull(message = NOT_EMPTY)
    private Double diameter;
    @NotNull(message = NOT_EMPTY)
    private Double depth;
    @NotNull(message = NOT_EMPTY)
    private Double drillSpeedEntrance;
    @NotNull(message = NOT_EMPTY)
    private Double drillSpeedExit;
    @NotNull(message = NOT_EMPTY)
    @Min(value = 90, message = RIGHT_ANGLE)
    @Max(value = 90, message = RIGHT_ANGLE)
    private Double holeAngle;
    @Transient
    private CoordinatesCalculationPattern coordinatesCalculationPattern;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @Valid
    @OneToMany(cascade = ALL, fetch = LAZY)
    @JoinColumn(name = "hole_id")
    private List<Coordinates> coordinates = new ArrayList<>();

    public void addCoordinates(Coordinates coordinatesInstance) {
        coordinates.add(coordinatesInstance);
    }
}
