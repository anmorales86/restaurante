package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.TableDto;
import com.group.restaurante.core.dto.WaiterDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.TableRequest;
import com.group.restaurante.core.request.WaiterRequest;
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
@Component("TableRepository")
public class TableRepositoryImpl implements TableRepository {

    private static Log logger = LogFactory.getLog(TableRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<TableDto> getTables() throws RestaurantException {
        logger.info("INFO!!! TableRepositoryImpl -> getTables");
        try {
            String query = "SELECT idmesa, nummaxcomensa, ubicacion FROM public.\"Mesa\"";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            List<TableDto> tableDtoList = Util.resetToListTableDto(q.getResultList().toArray());
            return tableDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! TableRepositoryImpl -> getTables -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

    @Override
    @Transactional
    public void addTable(TableRequest tableRequest) throws RestaurantException {
        logger.info("INFO!!! TableRepositoryImpl -> addTable");
        try {
            String query = "insert into public.\"Mesa\"(nummaxcomensa, ubicacion) values(?, ?)";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, Integer.parseInt(String.valueOf(tableRequest.getMaxComensaNumber())));
            q.setParameter(2, tableRequest.getLocation());

            q.executeUpdate();
        }catch (Exception e) {
            logger.error("ERROR!!! TableRepositoryImpl -> addTable -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

    @Override
    @Transactional
    public List<TableDto> getTablesWithNumMaxComensa(Long maxNumber) throws RestaurantException {
        logger.info("INFO!!! TableRepositoryImpl -> getTablesWithNumMaxComensa");
        try {
            String query = "SELECT idmesa, nummaxcomensa, ubicacion FROM public.\"Mesa\" WHERE nummaxcomensa <= ?";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, maxNumber);
            List<TableDto> tableDtoList = Util.resetToListTableDto(q.getResultList().toArray());
            return tableDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! TableRepositoryImpl -> getTablesWithNumMaxComensa -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

}
