package com.group.restaurante.business.services;

import com.group.restaurante.core.dto.*;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.*;

import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public interface RestaurantService {

    List<ClientDto> getClients() throws RestaurantException;
    void addClient(ClientRequest clientRequest) throws RestaurantException;

    List<ChefDto> getChefs() throws RestaurantException;
    void addChef(ChefRequest chefRequest) throws RestaurantException;

    List<WaiterDto> getWaiters() throws RestaurantException;
    void addWaiter(WaiterRequest waiterRequest) throws RestaurantException;

    List<TableDto> getTables() throws RestaurantException;
    void addTable(TableRequest tableRequest) throws RestaurantException;

    void addInvoice(InvoiceRequest tableRequest) throws RestaurantException;

    List<ReportWaiterDto> getReportWaiter() throws RestaurantException;
    List<ReportClientDto> getReportClient() throws RestaurantException;

}
