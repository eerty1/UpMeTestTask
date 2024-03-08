package com.upme.web;

import com.upme.crud_service.CrudService;
import com.upme.model.Coordinates;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import static com.upme.navigation.RedirectUrl.HOLE_REDIRECT;
import static com.upme.navigation.ViewName.COORDINATES_UPDATE;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/coordinates/update")
public class CoordinatesUpdateController {
    private final CrudService<Coordinates> coordinatesCrudService;

    @GetMapping(path = "/{id}")
    public String showCoordinatesUpdatePage(@PathVariable Long id, Model model) {
        model.addAttribute("coordinates", coordinatesCrudService.findById(id));
        return "coordinatesUpdate";
    }

    @PutMapping
    public String updateCoordinates(@Valid Coordinates coordinates, Errors errors) {
        return coordinatesCrudService.update(coordinates, errors, HOLE_REDIRECT.getUrl(), COORDINATES_UPDATE.getName());
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCoordinates(@PathVariable Long id) {
        return coordinatesCrudService.delete(id, HOLE_REDIRECT.getUrl());
    }
}
