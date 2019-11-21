package com.example.jpareadytemplate.controller;

import com.example.jpareadytemplate.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ServiceLayer serviceLayer;

}
