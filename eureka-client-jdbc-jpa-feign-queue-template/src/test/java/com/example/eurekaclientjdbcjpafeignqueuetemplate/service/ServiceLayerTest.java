package com.example.eurekaclientjdbcjpafeignqueuetemplate.service;

import com.example.eurekaclientjdbcjpafeignqueuetemplate.dao.ModelRepository;
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
    private ModelRepository modelRepository;

    @Before
    public void setUp() throws Exception {
        serviceLayer = new ServiceLayer(modelRepository);
    }

    @Test
    public void shouldPutTestHere() {
    }
}