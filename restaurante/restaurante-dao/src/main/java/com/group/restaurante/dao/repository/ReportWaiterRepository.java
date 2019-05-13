package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ReportWaiterDto;
import com.group.restaurante.core.exception.RestaurantException;

import java.util.List;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
public interface ReportWaiterRepository {

    List<ReportWaiterDto> getReportWaiter() throws RestaurantException;

}
