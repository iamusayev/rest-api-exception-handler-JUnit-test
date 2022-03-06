package com.example.first.mapper;

import com.example.first.dao.entity.StudentEntity;
import com.example.first.model.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {


    public static StudentEntity mapDtoToEntity(StudentDto dto) {
        return StudentEntity.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .age(dto.getAge())
                .build();
    }

    public static StudentDto mapEntityToDto(StudentEntity entity) {
        return StudentDto.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .age(entity.getAge())
                .build();
    }

    public static List<StudentDto> mapEntitiesToDtos(List<StudentEntity> entities) {
        List<StudentDto> dtos = new ArrayList<>();
        for (StudentEntity entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }
        return dtos;
    }

}
