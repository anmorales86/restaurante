package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ChefDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.ChefRequest;
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
@Component("ChefRepository")
public class ChefRepositoryImpl implements ChefRepository {

    private static Log logger = LogFactory.getLog(ChefRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ChefDto> getChefs() throws RestaurantException {
        logger.info("INFO!!! ChefRepositoryImpl -> getChefs");
        try {
            String query = "SELECT idCocinero, nombre, apellido1, apellido2 FROM public.\"Cocinero\"";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            List<ChefDto> chefDtoList = Util.resetToListChefDto(q.getResultList().toArray());
            return chefDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! ChefRepositoryImpl -> getChefs -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

    @Override
    @Transactional
    public void addChef(ChefRequest chefRequest) throws RestaurantException {
        logger.info("INFO!!! ChefRepositoryImpl -> addChef");
        try {
            String query = "insert into public.\"Cocinero\"(nombre, apellido1, apellido2) values(?, ?, ?)";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, chefRequest.getName());
            q.setParameter(2, chefRequest.getLastName1());
            q.setParameter(3, chefRequest.getLastName2());
            q.executeUpdate();
        }catch (Exception e) {
            logger.error("ERROR!!! ChefRepositoryImpl -> addChef -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

}
