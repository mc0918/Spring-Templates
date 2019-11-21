package com.example.jpareadytemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "<TABLE_NAME>")
public class ExampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
