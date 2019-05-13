package com.group.restaurante.dao.repository;

import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.core.request.InvoiceRequest;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
public interface InvoiceRepository {

    Long getSequence() throws RestaurantException;
    void addInvoice(InvoiceRequest request) throws RestaurantException;

}
