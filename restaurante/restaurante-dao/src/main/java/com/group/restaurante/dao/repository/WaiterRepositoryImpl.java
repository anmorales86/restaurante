package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.WaiterDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.WaiterRequest;
import com.group.restaurante.dao.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
@Component("WaiterRepository")
public class WaiterRepositoryImpl implements WaiterRepository {

    private static Log logger = LogFactory.getLog(WaiterRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<WaiterDto> getWaiters() throws RestaurantException {
        logger.info("INFO!!! WaiterRepositoryImpl -> getWaiters");
        try {
            String query = "SELECT idcamarero, nombre, apellido1, apellido2 FROM public.\"Camarero\"";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            List<WaiterDto> waiterDtoList = Util.resetToListWaiterDto(q.getResultList().toArray());
            return waiterDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! WaiterRepositoryImpl -> getWaiters -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

    @Override
    @Transactional
    public void addWaiter(WaiterRequest waiterRequest) throws RestaurantException {
        logger.info("INFO!!! WaiterRepositoryImpl -> addWaiter");
        try {
            String query = "insert into public.\"Camarero\"(nombre, apellido1, apellido2) values(?, ?, ?)";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, waiterRequest.getName());
            q.setParameter(2, waiterRequest.getLastName1());
            q.setParameter(3, waiterRequest.getLastName2().equals("") ? null : waiterRequest.getLastName2());
            q.executeUpdate();
        }catch (Exception e) {
            logger.error("ERROR!!! WaiterRepositoryImpl -> addWaiter -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

}
