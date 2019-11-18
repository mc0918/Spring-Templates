package com.example.eurekaclientjdbcjpafeignqueuetemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties
@Table(name = "<your table name>")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int your_id_here;
}
