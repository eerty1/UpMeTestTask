package com.upme.repository;

import com.upme.model.Coordinates;
import org.springframework.stereotype.Repository;

@Repository("coordinatesRepository")
public interface CoordinatesRepository extends CrudPagingAndSortingRepository<Coordinates, Long> {
}
