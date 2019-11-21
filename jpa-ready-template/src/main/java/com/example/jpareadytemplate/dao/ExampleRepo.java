package com.example.jpareadytemplate.dao;

import com.example.jpareadytemplate.model.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepo extends JpaRepository<ExampleModel, Long> {
}
