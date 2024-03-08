package com.upme.crud_service;

import com.upme.model.Coordinates;
import com.upme.repository.CrudPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("coordinatesCrudService")
public class CoordinatesCrudService extends CrudService<Coordinates> {
    @Autowired
    public CoordinatesCrudService(CrudPagingAndSortingRepository<Coordinates, Long> crudPagingAndSortingRepository) {
        super(crudPagingAndSortingRepository);
    }

    public List<Double> getBothCoordinates() {
        List<Double> bothCoordinates = new ArrayList<>();
        crudPagingAndSortingRepository.findAll().forEach(coordinates -> {
            bothCoordinates.add(coordinates.getX());
            bothCoordinates.add(coordinates.getY());
        });
        return bothCoordinates;
    }
}
