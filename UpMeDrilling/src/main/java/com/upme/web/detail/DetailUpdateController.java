package com.upme.web.detail;

import com.upme.crud_service.CrudService;
import com.upme.model.Detail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.upme.navigation.RedirectUrl.DETAIL_REDIRECT;
import static com.upme.navigation.ViewName.DETAIL_UPDATE;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/detail/update")
public class DetailUpdateController {
    private final CrudService<Detail> detailCrudService;

    @GetMapping(path = "/{id}")
    public String showDetailUpdatePage(@PathVariable Long id, Model model) {
        model.addAttribute("detail", detailCrudService.findById(id));
        return DETAIL_UPDATE.getName();
    }

    @PutMapping
    public String updateDetail(@Valid Detail detail, Errors errors) {
        return detailCrudService.update(detail, errors, DETAIL_REDIRECT.getUrl(), DETAIL_UPDATE.getName());
    }
}
