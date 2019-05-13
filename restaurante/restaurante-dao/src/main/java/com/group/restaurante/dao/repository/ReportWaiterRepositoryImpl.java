package com.group.restaurante.dao.repository;


import com.group.restaurante.core.dto.ReportWaiterDto;
import com.group.restaurante.core.exception.RestaurantException;
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
 * Created by Anderson Q. on 12/05/2019.
 */
@Component("ReportWaiterRepository")
public class ReportWaiterRepositoryImpl implements ReportWaiterRepository {

    private static Log logger = LogFactory.getLog(ReportWaiterRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ReportWaiterDto> getReportWaiter() throws RestaurantException {
        logger.info("INFO!!! ReportWaiterRepositoryImpl -> getReportWaiter");
        try {
            String query = "SELECT DISTINCT COALESCE(c.nombre,'')||' '||COALESCE(c.apellido1,'')||' '||COALESCE(c.apellido2,'') NOMBRE_CAMARERO, to_char(f.fechafactura,'DD-MM-YYYY') FECHA, sum(df.importe) TOTAL " +
                            " FROM public.\"Factura\" f, public.\"DetalleFactura\" df,  " +
                            " public.\"Camarero\" c  " +
                            " where f.idfactura = df.idfactura " +
                            " and f.idcamarero = c.idcamarero " +
                            " group by NOMBRE_CAMARERO, FECHA " +
                            " UNION ALL " +
                            " select DISTINCT COALESCE(c.nombre,'')||' '||COALESCE(c.apellido1,'')||' '||COALESCE(c.apellido2,'') NOMBRE_CAMARERO, '' FECHA, SUM(0) TOTAL " +
                            " from public.\"Camarero\" c " +
                            " WHERE c.idcamarero NOT IN ( " +
                            " SELECT distinct c.idcamarero " +
                            " FROM public.\"Factura\" f, public.\"DetalleFactura\" df, " +
                            " public.\"Camarero\" c " +
                            " where f.idfactura = df.idfactura " +
                            " and f.idcamarero = c.idcamarero " +
                            " ) " +
                            " group by NOMBRE_CAMARERO, FECHA " +
                            " order by NOMBRE_CAMARERO, FECHA ";




            System.out.println("--> " + query);
            Query q = entityManager.createNativeQuery(query);
            List<ReportWaiterDto> clientDtoList = Util.resetToListReportWaiterDto(q.getResultList().toArray());
            return clientDtoList;
        }catch (Exception e) {
            logger.error("ERROR!!! ReportWaiterRepositoryImpl -> getReportWaiter -> " + e.getMessage());
            throw new RestaurantException(e);
        }

    }

}
