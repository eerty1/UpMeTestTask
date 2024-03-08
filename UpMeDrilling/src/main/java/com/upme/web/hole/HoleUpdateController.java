package com.upme.web.hole;

import com.upme.crud_service.CrudService;
import com.upme.model.Hole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.upme.navigation.RedirectUrl.HOLE_REDIRECT;
import static com.upme.navigation.ViewName.HOLE_UPDATE;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/hole/update")
public class HoleUpdateController {
    private final CrudService<Hole> holeCrudService;

    @GetMapping(path = "/{id}")
    public String showHoleUpdatePage(@PathVariable Long id, Model model) {
        model.addAttribute("hole", holeCrudService.findById(id));
        return HOLE_UPDATE.getName();
    }

    @PutMapping
    public String updateHole(@Valid Hole hole, Errors errors) {
        return holeCrudService.update(hole, errors, HOLE_REDIRECT.getUrl(), HOLE_UPDATE.getName());
    }
}
