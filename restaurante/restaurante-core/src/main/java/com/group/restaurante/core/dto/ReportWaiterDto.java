package com.group.restaurante.core.dto;

import java.io.Serializable;

/**
 * Created by User on 12/05/2019.
 */
public class ReportWaiterDto implements Serializable {

    private String name;
    private String date;
    private Long total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReportWaiterDto{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", total=" + total +
                '}';
    }
}
