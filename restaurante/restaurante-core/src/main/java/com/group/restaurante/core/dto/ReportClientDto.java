package com.group.restaurante.core.dto;

import java.io.Serializable;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
public class ReportClientDto implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReportClientDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
