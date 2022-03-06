package com.example.first.model.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

    private String name;
    private String lastname;
    private Integer age;

}
