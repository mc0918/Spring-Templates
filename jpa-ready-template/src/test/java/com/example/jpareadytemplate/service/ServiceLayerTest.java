package com.example.jpareadytemplate.service;

import com.example.jpareadytemplate.dao.ExampleRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {
    private ServiceLayer serviceLayer;
    private ExampleRepo exampleRepo;

    @Before
    public void setUp() throws Exception {
        exampleRepo.deleteAll();

        setUpRepoMock();
        serviceLayer = new ServiceLayer(exampleRepo);
    }

    private void setUpRepoMock(){
        //set up mocks here
    }

    @Test
    public void shouldPutTestsHere(){}
}