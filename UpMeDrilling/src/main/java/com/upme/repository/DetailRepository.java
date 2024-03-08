package com.upme.repository;

import com.upme.model.Detail;
import org.springframework.stereotype.Repository;

@Repository("detailRepository")
public interface DetailRepository extends CrudPagingAndSortingRepository<Detail, Long> {
    boolean existsByName(String name);
}

