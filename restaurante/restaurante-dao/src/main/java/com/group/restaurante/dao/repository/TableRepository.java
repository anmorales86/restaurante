package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.TableDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.TableRequest;

import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public interface TableRepository {

    List<TableDto> getTables() throws RestaurantException;
    void addTable(TableRequest tableRequest) throws RestaurantException;
    List<TableDto> getTablesWithNumMaxComensa(Long maxNumber) throws RestaurantException;

}
