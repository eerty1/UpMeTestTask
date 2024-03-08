package com.upme.web.detail;

import com.upme.crud_service.CrudService;
import com.upme.model.Detail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.upme.navigation.RedirectUrl.DETAIL_REDIRECT;
import static com.upme.navigation.ViewName.DETAILS;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/detail")
public class DetailController {
    private final CrudService<Detail> detailCrudService;

    @ModelAttribute("details")
    public Iterable<Detail> findAllDetails() {
        return detailCrudService.findAll();
    }

    @GetMapping
    public String showDetailsPage() {
        return DETAILS.getName();
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDetail(@PathVariable Long id) {
        return detailCrudService.delete(id, DETAIL_REDIRECT.getUrl());
    }
}
