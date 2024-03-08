package com.upme.web.detail;

import com.upme.crud_service.CrudService;
import com.upme.model.Detail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.upme.navigation.RedirectUrl.DETAIL_REDIRECT;
import static com.upme.navigation.ViewName.DETAIL_CREATION;

@Controller
@RequiredArgsConstructor
@RequestMapping("/detail")
public class DetailCreationController {

    private final CrudService<Detail> detailCrudService;

    @ModelAttribute("detail")
    public Detail getEmptyDetail() {
        return new Detail();
    }

    @GetMapping(path = "/creation")
    public String showDetailCreationPage() {
        return DETAIL_CREATION.getName();
    }

    @PostMapping
    public String saveDetail(@Valid Detail detail, Errors errors) {
        return detailCrudService.save(detail, errors, DETAIL_REDIRECT.getUrl(), DETAIL_CREATION.getName());
    }
}
