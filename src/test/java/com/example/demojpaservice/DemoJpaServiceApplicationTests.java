package com.example.demojpaservice;

import com.example.demojpaservice.domain.Document;
import com.example.demojpaservice.service.EstatementGateway;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJpaServiceApplicationTests {

    @Autowired
    private EstatementGateway estatementGateway;

    @Test
    public void contextLoads() {
        Document document = new Document();
        document.setContractNumber("1122334455");
        Long id = estatementGateway.addDocument(document);

        Assert.assertEquals(new Long(1), id);

        estatementGateway.deleteDocument(id);


    }

}
