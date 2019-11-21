package com.example.eurekaclientjdbcjpafeignqueuetemplate.dao;

import com.example.eurekaclientjdbcjpafeignqueuetemplate.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
