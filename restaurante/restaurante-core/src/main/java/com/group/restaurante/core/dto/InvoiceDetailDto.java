package com.group.restaurante.core.dto;

import java.io.Serializable;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
public class InvoiceDetailDto implements Serializable {

    private Long idChef;
    private String plate;
    private Long value;

    public Long getIdChef() {
        return idChef;
    }

    public void setIdChef(Long idChef) {
        this.idChef = idChef;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InvoiceDetailDto{" +
                "idChef=" + idChef +
                ", plate='" + plate + '\'' +
                ", value=" + value +
                '}';
    }
}
