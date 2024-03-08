package com.upme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface CrudPagingAndSortingRepository<T, ID> extends CrudRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}
