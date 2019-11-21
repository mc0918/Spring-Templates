package com.example.jpareadytemplate.service;

import com.example.jpareadytemplate.dao.ExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    private ExampleRepo exampleRepo;

    @Autowired
    public ServiceLayer(ExampleRepo exampleRepo){
        this.exampleRepo = exampleRepo;
    }

    //Logic here
}
