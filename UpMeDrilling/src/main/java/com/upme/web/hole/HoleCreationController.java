package com.upme.web.hole;

import com.upme.crud_service.CrudService;
import com.upme.crud_service.HoleCrudService;
import com.upme.crud_service.coordinates_calculation_pattern.CoordinatesCalculationPattern;
import com.upme.crud_service.coordinates_calculation_pattern.PatternStorage;
import com.upme.model.Detail;
import com.upme.model.Hole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.upme.navigation.RedirectUrl.DETAIL_REDIRECT;
import static com.upme.navigation.ViewName.HOLE_CREATION;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/hole")
public class HoleCreationController {
    private final CrudService<Detail> detailCrudService;
    private final HoleCrudService holeCrudService;
    private final PatternStorage patternStorage;

    @ModelAttribute("details")
    public Iterable<Detail> findAllDetails() {
        return detailCrudService.findAll();
    }


    @ModelAttribute("hole")
    public Hole getEmptyHole() {
        return new Hole();
    }


    @Bean
    @ModelAttribute("patterns")
    public List<CoordinatesCalculationPattern> coordinatesCalculationPatterns() {
        return patternStorage.coordinatesCalculationPatterns;
    }

    @GetMapping("/creation")
    public String showHoleCreationPage() {
        return HOLE_CREATION.getName();
    }

    @PostMapping
    public String saveHole(@Valid Hole hole, Errors errors) {
        return holeCrudService.save(hole, errors, DETAIL_REDIRECT.getUrl(), HOLE_CREATION.getName());
    }

    @PostMapping(params = {"addCoordinates"})
    public String addCoordinates(Hole hole) {
        return holeCrudService.addHole(hole);
    }

    @PostMapping(params = {"removeCoordinates"})
    public String removeCoordinates(@RequestParam("removeCoordinates") int coordinatesId, Hole hole) {
        return holeCrudService.removeHole(coordinatesId, hole);
    }
}
