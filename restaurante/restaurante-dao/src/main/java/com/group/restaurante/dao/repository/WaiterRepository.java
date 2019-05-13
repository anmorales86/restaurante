package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.WaiterDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.WaiterRequest;

import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public interface WaiterRepository {

    List<WaiterDto> getWaiters() throws RestaurantException;
    void addWaiter(WaiterRequest waiterRequest) throws RestaurantException;

}
