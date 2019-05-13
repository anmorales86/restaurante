package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ClientDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.ClientRequest;
import com.group.restaurante.dao.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
@Component("ClientRepository")
public class ClientRepositoryRepositoryImpl implements ClientRepository {

    private static Log logger = LogFactory.getLog(ClientRepositoryRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ClientDto> getClients() throws RestaurantException {
        logger.info("INFO!!! ClientRepositoryRepositoryImpl -> getClients");
        try {
            String query = "SELECT idcliente, nombre, apellido1, apellido2, observaciones FROM public.\"Cliente\"";
            System.out.println("--> " + query);
            Query q = entityManager.createNativeQuery(query);
            List<ClientDto> clientDtoList = Util.resetToListClientDto(q.getResultList().toArray());
            return clientDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! ClientRepositoryRepositoryImpl -> getClients -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

    @Override
    @Transactional
    public void addClient(ClientRequest clientRequest) throws RestaurantException {
        logger.info("INFO!!! ClientRepositoryRepositoryImpl -> addClient");
        try {
            String query = "insert into public.\"Cliente\"(nombre, apellido1, apellido2, observaciones) values(?, ?, ?, ?)";
            System.out.println("--> " + query);
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, clientRequest.getName());
            q.setParameter(2, clientRequest.getLastName1());
            q.setParameter(3, clientRequest.getLastName2());
            q.setParameter(4, clientRequest.getComment());
            q.executeUpdate();
        }catch (Exception e) {
            logger.error("ERROR!!! ClientRepositoryRepositoryImpl -> addClient -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

}
