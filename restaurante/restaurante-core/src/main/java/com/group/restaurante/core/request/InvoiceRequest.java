package com.group.restaurante.core.request;

import com.group.restaurante.core.dto.InvoiceDetailDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
public class InvoiceRequest implements Serializable {

    private Long idClient;
    private Long idWaiter;
    private Long idTable;
    private List<InvoiceDetailDto> invoiceDetailDtos;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdWaiter() {
        return idWaiter;
    }

    public void setIdWaiter(Long idWaiter) {
        this.idWaiter = idWaiter;
    }

    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long idTable) {
        this.idTable = idTable;
    }

    public List<InvoiceDetailDto> getInvoiceDetailDtos() {
        return invoiceDetailDtos;
    }

    public void setInvoiceDetailDtos(List<InvoiceDetailDto> invoiceDetailDtos) {
        this.invoiceDetailDtos = invoiceDetailDtos;
    }

    @Override
    public String toString() {
        return "InvoiceRequest{" +
                "idClient=" + idClient +
                ", idWaiter=" + idWaiter +
                ", idTable=" + idTable +
                ", invoiceDetailDtos=" + invoiceDetailDtos +
                '}';
    }
}
