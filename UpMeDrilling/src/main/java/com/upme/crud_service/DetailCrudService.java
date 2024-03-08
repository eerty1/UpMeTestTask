package com.upme.crud_service;

import com.upme.model.Detail;
import com.upme.repository.CrudPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("detailCrudService")
public class DetailCrudService extends CrudService<Detail> {
    @Autowired
    public DetailCrudService(CrudPagingAndSortingRepository<Detail, Long> crudPagingAndSortingRepository) {
        super(crudPagingAndSortingRepository);
    }
}