package com.upme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.upme.model.ValidationErrorMessages.NOT_EMPTY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Coordinates {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotNull(message = NOT_EMPTY)
    private Double x;
    @NotNull(message = NOT_EMPTY)
    private Double y;

    public Coordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}
