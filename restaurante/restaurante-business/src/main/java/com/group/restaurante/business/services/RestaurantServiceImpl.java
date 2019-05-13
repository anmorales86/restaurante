package com.group.restaurante.business.services;

import com.group.restaurante.core.dto.*;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.*;
import com.group.restaurante.dao.repository.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
@Service("RestaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    private final ClientRepository clientRepository;
    private final ChefRepository chefRepository;
    private final WaiterRepository waiterRepository;
    private final TableRepository tableRepository;
    private final InvoiceRepository invoiceRepository;
    private final ReportWaiterRepository reportWaiterRepository;
    private final ReportClientRepository reportClientRepository;


    private static Log logger = LogFactory.getLog(RestaurantServiceImpl.class);

    @Autowired
    public RestaurantServiceImpl(@Qualifier("ClientRepository") ClientRepository clientRepository,
                                 @Qualifier("ChefRepository") ChefRepository chefRepository,
                                 @Qualifier("WaiterRepository") WaiterRepository waiterRepository,
                                 @Qualifier("TableRepository") TableRepository tableRepository,
                                 @Qualifier("InvoiceRepository") InvoiceRepository invoiceRepository,
                                 @Qualifier("ReportWaiterRepository") ReportWaiterRepository reportWaiterRepository,
                                 @Qualifier("ReportClientRepository") ReportClientRepository reportClientRepository) {
        this.clientRepository = clientRepository;
        this.chefRepository = chefRepository;
        this.waiterRepository = waiterRepository;
        this.tableRepository = tableRepository;
        this.invoiceRepository = invoiceRepository;
        this.reportWaiterRepository = reportWaiterRepository;
        this.reportClientRepository = reportClientRepository;
    }

    @Override
    public List<ClientDto> getClients() throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> getClients");
        List<ClientDto> clientDtoList = this.clientRepository.getClients();
        return clientDtoList;
    }

    @Override
    public void addClient(ClientRequest clientRequest) throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> addClient");
        logger.info("INFO!!! ClientRequest -> " + clientRequest.toString());
        this.clientRepository.addClient(clientRequest);

    }

    @Override
    public List<ChefDto> getChefs() throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> getChefs");
        List<ChefDto> chefDtoList = this.chefRepository.getChefs();
        return chefDtoList;
    }

    @Override
    public void addChef(ChefRequest chefRequest) throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> addChef");
        logger.info("INFO!!! ChefRequest -> " + chefRequest.toString());
        this.chefRepository.addChef(chefRequest);
    }

    @Override
    public List<WaiterDto> getWaiters() throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> getWaiters");
        List<WaiterDto> waiterDtoList = this.waiterRepository.getWaiters();
        return waiterDtoList;
    }

    @Override
    public void addWaiter(WaiterRequest waiterRequest) throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> addWaiter");
        logger.info("INFO!!! WaiterRequest -> " + waiterRequest.toString());
        this.waiterRepository.addWaiter(waiterRequest);
    }

    @Override
    public List<TableDto> getTables() throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> getTables");
        List<TableDto> tableDtoList = this.tableRepository.getTables();
        return tableDtoList;
    }

    @Override
    public void addTable(TableRequest tableRequest) throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> addTable");
        logger.info("INFO!!! TableRequest -> " + tableRequest.toString());
        this.tableRepository.addTable(tableRequest);
    }

    @Override
    public void addInvoice(InvoiceRequest invoiceRequest) throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> addInvoice");
        logger.info("INFO!!! InvoiceRequest -> " + invoiceRequest.toString());
        this.invoiceRepository.addInvoice(invoiceRequest);
    }

    @Override
    public List<ReportWaiterDto> getReportWaiter() throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> getReportWaiter");
        List<ReportWaiterDto> reportWaiterDtoList = this.reportWaiterRepository.getReportWaiter();
        return reportWaiterDtoList;
    }

    @Override
    public List<ReportClientDto> getReportClient() throws RestaurantException {
        logger.info("INFO!!! RestaurantServiceImpl -> getReportWaiter");
        List<ReportClientDto> reportClientDtoList = this.reportClientRepository.getReportClient();
        return reportClientDtoList;
    }

}
