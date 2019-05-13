package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ChefDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.ChefRequest;

import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public interface ChefRepository {

    List<ChefDto> getChefs() throws RestaurantException;
    void addChef(ChefRequest chefRequest) throws RestaurantException;

}
