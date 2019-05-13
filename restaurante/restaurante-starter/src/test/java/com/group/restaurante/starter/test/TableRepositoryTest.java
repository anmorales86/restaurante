package com.group.restaurante.starter.test;

import com.group.restaurante.core.dto.TableDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.dao.repository.TableRepository;
import com.group.restaurante.starter.RestauranteApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestauranteApplication.class)
public class TableRepositoryTest {

    @Autowired
    private TableRepository tableRepository;

    @Test
    public void  getTables() throws RestaurantException {

        List<TableDto> tableDtoList = tableRepository.getTables();
        Assert.assertNotNull(tableDtoList);
    }

    @Test
    public void  getTables2() throws RestaurantException {

        List<TableDto> tableDtoList = tableRepository.getTables();

        tableDtoList.removeIf(data->data.getMaxComensaNumber() < 9L);

        Assert.assertNotNull(tableDtoList);
    }

    @Test
    public void  getTablesByNumMaxComensa() throws RestaurantException {
        Long maxNumber = 9L;
        List<TableDto> tableDtoList = tableRepository.getTablesWithNumMaxComensa(maxNumber);
        Assert.assertNotNull(tableDtoList);
    }

}
