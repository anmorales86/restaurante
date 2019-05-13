package com.group.restaurante.starter.test;

import com.group.restaurante.core.dto.ReportClientDto;
import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.dao.repository.ReportClientRepository;
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
public class ReportClientRepositoryTest {

    @Autowired
    private ReportClientRepository reportClientRepository;

    @Test
    public void  getReportClient() throws RestaurantException {
        List<ReportClientDto> tableDtoList = reportClientRepository.getReportClient();
        Assert.assertNotNull(tableDtoList);
    }

}
