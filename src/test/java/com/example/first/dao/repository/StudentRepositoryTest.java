package com.example.first.dao.repository;

import com.example.first.dao.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    private static final Long ID = 1L;

    @Test
    void getStudentById() {
        Optional<StudentEntity> student = repository.findById(ID);
        assertTrue(student.isPresent());
        student.ifPresent(entity -> assertEquals("Name", entity.getName()));
    }

    @Test
    void saveStudent() {
        StudentEntity student = StudentEntity.builder().name("HEY").build();
        repository.save(student);
        assertNotNull(student.getId());
    }

}