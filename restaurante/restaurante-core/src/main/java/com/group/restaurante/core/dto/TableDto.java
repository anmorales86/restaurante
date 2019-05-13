package com.group.restaurante.core.dto;

import java.io.Serializable;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public class TableDto implements Serializable {

    private Long idTable;
    private Long maxComensaNumber;
    private String location;

    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long idTable) {
        this.idTable = idTable;
    }

    public Long getMaxComensaNumber() {
        return maxComensaNumber;
    }

    public void setMaxComensaNumber(Long maxComensaNumber) {
        this.maxComensaNumber = maxComensaNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TableDto{" +
                "idTable=" + idTable +
                ", maxComensaNumber='" + maxComensaNumber + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
