package com.group.restaurante.rest;

import com.group.restaurante.business.services.RestaurantService;
import com.group.restaurante.core.constant.ErrorCode;
import com.group.restaurante.core.constant.ErrorMessage;
import com.group.restaurante.core.dto.*;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.*;
import com.group.restaurante.core.response.ErrorResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anderson Q. on 7/05/2019.
 */
@RestController
@CrossOrigin(origins  = "*")
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class RestauranteRest {

    private final RestaurantService restaurantService;

    private static Log logger = LogFactory.getLog(RestauranteRest.class);


    @Autowired
    public RestauranteRest(@Qualifier("RestaurantService") RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    @ResponseBody
    public List<ClientDto> getClients() throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getClients");
        List<ClientDto> response = this.restaurantService.getClients();
        return response;
    }

    @RequestMapping(value = "/getChefs", method = RequestMethod.GET)
    @ResponseBody
    public List<ChefDto> getChefs() throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getChefs");
        List<ChefDto> response = this.restaurantService.getChefs();
        return response;
    }

    @RequestMapping(value = "/getWaiters", method = RequestMethod.GET)
    @ResponseBody
    public List<WaiterDto> getWaiters() throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getWaiters");
        List<WaiterDto> response = this.restaurantService.getWaiters();
        return response;
    }

    @RequestMapping(value = "/getTables", method = RequestMethod.GET)
    @ResponseBody
    public List<TableDto> getTables() throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getTables");
        List<TableDto> response = this.restaurantService.getTables();
        return response;
    }

    @RequestMapping(value = "/addClient",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void addClient(@RequestBody ClientRequest request) throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> addClient");
        logger.info("INFO!!! ClientRequest -> " + request.toString());
        this.restaurantService.addClient(request);
    }

    @RequestMapping(value = "/addChef",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void addChef(@RequestBody ChefRequest request) throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getChefs");
        logger.info("INFO!!! ChefRequest -> " + request.toString());
        this.restaurantService.addChef(request);
    }

    @RequestMapping(value = "/addWaiter",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void addWaiter(@RequestBody WaiterRequest request) throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> addWaiter");
        logger.info("INFO!!! WaiterRequest -> " + request.toString());
        this.restaurantService.addWaiter(request);
    }

    @RequestMapping(value = "/addTable",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void addTable(@RequestBody TableRequest request) throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> addTable");
        logger.info("INFO!!! TableRequest -> " + request.toString());
        this.restaurantService.addTable(request);
    }

    @RequestMapping(value = "/addInvoice",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void addInvoice(@RequestBody InvoiceRequest request) throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> addInvoice");
        logger.info("INFO!!! InvoiceRequest -> " + request.toString());
        this.restaurantService.addInvoice(request);
    }

    @RequestMapping(value = "/getReportWaiter", method = RequestMethod.GET)
    @ResponseBody
    public List<ReportWaiterDto> getReportWaiter() throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getReportWaiter");
        List<ReportWaiterDto> response = this.restaurantService.getReportWaiter();
        return response;
    }

    @RequestMapping(value = "/getReportClient", method = RequestMethod.GET)
    @ResponseBody
    public List<ReportClientDto> getReportClient() throws RestaurantException {
        logger.info("INFO!!! RestauranteRest -> getReportWaiter");
        List<ReportClientDto> response = this.restaurantService.getReportClient();
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ErrorResponse handleException(Exception ex) {
        logger.info("INFO!!! RestauranteRest -> getChefs");
        logger.info("INFO!!! Exception -> " + ex.toString());
        ErrorResponse errorResponse = new ErrorResponse();
        String code = (ex instanceof RestaurantException) ?
                ((RestaurantException) ex).getCode() : ErrorCode.UNEXPECTED_ERROR;
        String message = (ex instanceof RestaurantException) ?
                ((RestaurantException) ex).getMessage() : ErrorMessage.UNEXPECTED_ERROR;

        errorResponse.setCode(code);
        errorResponse.setMessage(message);

        return errorResponse;
    }

}
