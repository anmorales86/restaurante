package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ClientDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.ClientRequest;
import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public interface ClientRepository {

    List<ClientDto> getClients() throws RestaurantException;
    void addClient(ClientRequest clientRequest) throws RestaurantException;

}
