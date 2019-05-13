package com.group.restaurante.dao.repository;


import com.group.restaurante.core.dto.InvoiceDetailDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.InvoiceRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
@Component("InvoiceRepository")
public class InvoiceRepositoryImpl implements InvoiceRepository {

    private static Log logger = LogFactory.getLog(InvoiceRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Long getSequence() throws RestaurantException {
        logger.info("INFO!!! InvoiceRepositoryImpl -> getSequence");
        try {
            String query = "select nextval('public.factura_idfactura_seq')";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            return ((BigInteger)q.getSingleResult()).longValue();
        }catch (Exception e) {
            logger.error("ERROR!!! InvoiceRepositoryImpl -> getSequence -> " + e.getMessage());
            throw new RestaurantException(e);
        }

    }

    @Override
    public void addInvoice(InvoiceRequest request) throws RestaurantException {
        logger.info("INFO!!! InvoiceRepositoryImpl -> addInvoice");
        try {
            Long sequence = this.getSequence();
            String query = "insert into public.\"Factura\"(idfactura, idcliente, idcamarero, idmesa) values(?, ?, ?, ?)";
            System.out.println("query --> " + query);
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, sequence);
            q.setParameter(2, request.getIdClient());
            q.setParameter(3, request.getIdWaiter());
            q.setParameter(4, request.getIdTable());
            q.executeUpdate();
            String queryDetail = "insert into public.\"DetalleFactura\"(idfactura, idcocinero, plato, importe) values(?, ?, ?, ?)";
            System.out.println("queryDetail --> " + queryDetail);
            for (InvoiceDetailDto detailDto : request.getInvoiceDetailDtos()) {
                Query q2 = entityManager.createNativeQuery(queryDetail);
                q2.setParameter(1, sequence);
                q2.setParameter(2, detailDto.getIdChef());
                q2.setParameter(3, detailDto.getPlate());
                q2.setParameter(4, detailDto.getValue());
                q2.executeUpdate();
            }
        }catch (Exception e) {
            logger.error("ERROR!!! InvoiceRepositoryImpl -> addInvoice -> " + e.getMessage());
            throw new RestaurantException(e);
        }
    }

}
