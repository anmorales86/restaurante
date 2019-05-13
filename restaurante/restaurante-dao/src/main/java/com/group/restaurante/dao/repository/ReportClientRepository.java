package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ReportClientDto;
import com.group.restaurante.core.exception.RestaurantException;

import java.util.List;

/**
 * Created by User on 12/05/2019.
 */
public interface ReportClientRepository {

    List<ReportClientDto> getReportClient() throws RestaurantException;

}
