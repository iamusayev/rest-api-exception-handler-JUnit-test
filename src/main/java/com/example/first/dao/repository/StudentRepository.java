package com.example.first.dao.repository;


import com.example.first.dao.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {
}
