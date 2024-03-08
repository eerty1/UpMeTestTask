package com.upme.web.hole;

import com.upme.crud_service.CrudService;
import com.upme.model.Hole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.upme.navigation.RedirectUrl.HOLE_REDIRECT;
import static com.upme.navigation.ViewName.HOLES;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/hole")
public class HoleController {
    private final CrudService<Hole> holeCrudService;

    @ModelAttribute("holes")
    public Iterable<Hole> findAllHoles() {
        return holeCrudService.findAll();
    }

    @GetMapping
    public String showHolesPage() {
        return HOLES.getName();
    }

    @DeleteMapping(path = "/{id}")
    public String deleteHole(@PathVariable Long id) {
        return holeCrudService.delete(id, HOLE_REDIRECT.getUrl());
    }
}
