package com.group.restaurante.core.request;

import java.io.Serializable;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public class TableRequest implements Serializable {

    private Long maxComensaNumber;
    private String location;

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
        return "TableRequest{" +
                "maxComensaNumber=" + maxComensaNumber +
                ", location='" + location + '\'' +
                '}';
    }
}
