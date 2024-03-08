package com.upme.navigation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RedirectUrl {
    DETAIL_REDIRECT("redirect:/detail"),
    HOLE_REDIRECT("redirect:/hole");

    private final String url;
}
