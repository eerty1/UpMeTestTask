package com.upme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.upme.model.ValidationErrorMessages.*;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Detail {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Size(min = 3, max = 30, message = NOT_IN_RANGE)
    private String name;
    @NotNull(message = NOT_EMPTY)
    private Double length;
    @NotNull(message = NOT_EMPTY)
    private Double width;
    @NotNull(message = NOT_EMPTY)
    @Min(value = 4, message = WRONG_HEIGHT)
    @Max(value = 50, message = WRONG_HEIGHT)
    private Double height;

    @OneToMany(mappedBy = "detail", cascade = ALL)
    private List<Hole> holes = new ArrayList<>();

}
