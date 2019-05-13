package com.group.restaurante.core.exception;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public class RestaurantException extends Exception {

    public String getCode() {
        return "-1";
    }

    public RestaurantException() {
    }

    public RestaurantException(String message) {
        super(message);
    }

    public RestaurantException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestaurantException(Throwable cause) {
        super(cause);
    }

}
