package com.example.eurekaclientjdbcjpafeignqueuetemplate.service;

import com.example.eurekaclientjdbcjpafeignqueuetemplate.dao.ModelRepository;
import com.example.eurekaclientjdbcjpafeignqueuetemplate.model.Model;
import com.example.eurekaclientjdbcjpafeignqueuetemplate.viewmodel.ModelViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    private ModelRepository modelRepository;

    @Autowired
    public ServiceLayer(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public ModelViewModel buildViewModel(Model model) {
        return null;
    }
}
