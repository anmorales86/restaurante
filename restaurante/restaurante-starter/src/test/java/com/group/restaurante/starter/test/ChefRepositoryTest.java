package com.group.restaurante.starter.test;

import com.group.restaurante.core.dto.ChefDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.dao.repository.ChefRepository;
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
public class ChefRepositoryTest {

    @Autowired
    private ChefRepository chefRepository;

    @Test
    public void  getChefs() throws RestaurantException {

        List<ChefDto> chefDtoList = chefRepository.getChefs();
        Assert.assertNotNull(chefDtoList);
    }

}
