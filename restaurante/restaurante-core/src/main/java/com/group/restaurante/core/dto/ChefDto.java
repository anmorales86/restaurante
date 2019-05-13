package com.group.restaurante.core.dto;

import java.io.Serializable;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public class ChefDto implements Serializable {

    private Long idChef;
    private String name;
    private String lastName1;
    private String lastName2;

    public Long getIdChef() {
        return idChef;
    }

    public void setIdChef(Long idChef) {
        this.idChef = idChef;
    }

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
        return "ChefDto{" +
                "idClient=" + idChef +
                ", name='" + name + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                '}';
    }
}
