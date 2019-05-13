package com.group.restaurante.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Anderson Q. on 7/05/2019.
 */

@SpringBootApplication(scanBasePackages = {"com.group.restaurante"})
public class RestauranteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestauranteApplication.class, args);
    }
}
