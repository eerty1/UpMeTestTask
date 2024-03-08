package com.upme.navigation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ViewName {
    DETAILS("details"),
    DETAIL_CREATION("detailCreation"),
    DETAIL_UPDATE("detailUpdate"),
    HOLES("holes"),
    HOLE_CREATION("holeCreation"),
    HOLE_UPDATE("holeUpdate"),
    COORDINATES_UPDATE("coordinatesUpdate"),
    CALCULATOR("calculator");

    private final String name;
}
