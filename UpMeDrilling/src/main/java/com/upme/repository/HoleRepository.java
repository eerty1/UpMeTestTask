package com.upme.repository;

import com.upme.model.Hole;
import org.springframework.stereotype.Repository;

@Repository("holeRepository")
public interface HoleRepository extends CrudPagingAndSortingRepository<Hole, Long> {
}
