package com.group.restaurante.starter.test;

import com.group.restaurante.core.exception.RestaurantException;
import com.group.restaurante.dao.repository.InvoiceRepository;
import com.group.restaurante.starter.RestauranteApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Anderson Q. on 12/05/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestauranteApplication.class)
public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void  getTables() throws RestaurantException {

        Long sequence = invoiceRepository.getSequence();
        Assert.assertNotNull(sequence);
    }
}
