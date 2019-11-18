package com.example.eurekaclientjdbcjpafeignqueuetemplate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Object, Integer> {
}
