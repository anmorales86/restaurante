package com.group.restaurante.core.request;

import java.io.Serializable;

/**
 * Created by User on 11/05/2019.
 */
public class WaiterRequest implements Serializable {

    private String name;
    private String lastName1;
    private String lastName2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    @Override
    public String toString() {
        return "WaiterRequest{" +
                "name='" + name + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                '}';
    }
}
