package com.upme.crud_service;

import com.upme.model.Coordinates;
import com.upme.model.Hole;
import com.upme.repository.CrudPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import static com.upme.navigation.ViewName.HOLE_CREATION;

@Service("holeCrudService")
public class HoleCrudService extends CrudService<Hole> {

    @Autowired
    public HoleCrudService(CrudPagingAndSortingRepository<Hole, Long> crudPagingAndSortingRepository) {
        super(crudPagingAndSortingRepository);
    }

    @Override
    public String save(Hole entity, Errors errors, String ... viewName) {
        if (errors.hasErrors()) {
            return viewName[1];
        }
        if (entity.getCoordinates().isEmpty()) {
            Double position = entity.getCoordinatesCalculationPattern().calculatePosition(entity.getDetail());
            entity.addCoordinates(
                    new Coordinates(position, position)
            );
        }
        crudPagingAndSortingRepository.save(entity);
        return viewName[0];
    }

    public String addHole(Hole hole) {
        hole.addCoordinates(new Coordinates());
        return HOLE_CREATION.getName();
    }

    public String removeHole(int coordinatesId, Hole hole) {
        hole.getCoordinates().remove(coordinatesId);
        return HOLE_CREATION.getName();
    }
}
