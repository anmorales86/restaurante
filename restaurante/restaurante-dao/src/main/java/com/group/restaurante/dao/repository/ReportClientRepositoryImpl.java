package com.group.restaurante.dao.repository;

import com.group.restaurante.core.dto.ReportClientDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.dao.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
@Component("ReportClientRepository")
public class ReportClientRepositoryImpl implements ReportClientRepository {

    private static Log logger = LogFactory.getLog(ReportClientRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ReportClientDto> getReportClient() throws RestaurantException {
        logger.info("INFO!!! ReportClientRepositoryImpl -> getReportClient");
        try {
            String query = "SELECT DISTINCT COALESCE(c.nombre,'')||' '||COALESCE(c.apellido1,'')||' '||COALESCE(c.apellido2,'') NOMBRE_CAMARERO, sum(df.importe) TOTAL " +
                           " FROM public.\"Factura\" f, public.\"DetalleFactura\" df, " +
                           " public.\"Cliente\" c " +
                           " where f.idfactura = df.idfactura " +
                           " and f.idcliente = c.idcliente " +
                           " group by NOMBRE_CAMARERO " +
                           " HAVING sum(df.importe) >= 100000";

            System.out.println("--> " + query);
            Query q = entityManager.createNativeQuery(query);
            List<ReportClientDto> clientDtoList = Util.resetToListReportClientDto(q.getResultList().toArray());
            return clientDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! ReportClientRepositoryImpl -> getReportClient -> " + e.getMessage());
            throw new RestaurantException(e);
        }

    }

}
