package com.example.first.service;

import com.example.first.dao.entity.StudentEntity;
import com.example.first.dao.repository.StudentRepository;
import com.example.first.model.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.first.mapper.StudentMapper.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;


    public void createStudent(StudentDto dto) {
        repository.save(mapDtoToEntity(dto));
    }

    public StudentDto getStudent(Long id) {
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        StudentDto dto = mapEntityToDto(entity);
        return dto;
    }

    public List getStudents() {
        List entities = (List) repository.findAll();
        List dto = mapEntitiesToDtos(entities);
        return dto;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public void updateStudent(Long id, StudentDto dto) {
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setAge(dto.getAge());
        repository.save(entity);
    }

    public void updateStudentName(Long id, String name) {
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        entity.setName(name);
        repository.save(entity);
    }

    public void updateStudentLastname(Long id, String lastname) {
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        entity.setLastname(lastname);
        repository.save(entity);
    }

    public void updateStudentAge(Long id, Integer age) {
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        entity.setAge(age);
        repository.save(entity);
    }

}
