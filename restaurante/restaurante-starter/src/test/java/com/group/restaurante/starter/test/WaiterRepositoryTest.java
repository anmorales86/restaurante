package com.group.restaurante.starter.test;

import com.group.restaurante.core.dto.WaiterDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.dao.repository.WaiterRepository;
import com.group.restaurante.starter.RestauranteApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by User on 12/05/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestauranteApplication.class)
public class WaiterRepositoryTest {

    @Autowired
    private WaiterRepository waiterRepository;

    @Test
    public void  getWaiters() throws RestaurantException {

        List<WaiterDto> waiterDtoList = waiterRepository.getWaiters();
        Assert.assertNotNull(waiterDtoList);
    }

}
