package com.upme.crud_service;

import com.upme.repository.CrudPagingAndSortingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
public abstract class CrudService<T> {
    protected final CrudPagingAndSortingRepository<T, Long> crudPagingAndSortingRepository;

    public Iterable<T> findAll() {
        return crudPagingAndSortingRepository.findAll(Sort.by("id"));
    }

    public T findById(Long id) {
        return crudPagingAndSortingRepository.findById(id).orElseThrow();
    }

    public String save(T entity, Errors errors, String ... viewName) {
        if (errors.hasErrors()) {
            return viewName[1];
        }
        crudPagingAndSortingRepository.save(entity);
        return viewName[0];
    }

    public String update(T entity, Errors errors, String ... viewName) {
        if (errors.hasErrors()) {
            return viewName[1];
        }
        crudPagingAndSortingRepository.save(entity);
        return viewName[0];
    }

    public String delete(Long id, String viewName) {
        crudPagingAndSortingRepository.deleteById(id);
        return viewName;
    }
}
