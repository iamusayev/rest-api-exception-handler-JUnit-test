package com.example.first.controller;


import com.example.first.model.dto.StudentDto;
import com.example.first.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentDto dto) {
        service.createStudent(dto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @GetMapping
    public List getStudents() {
        return service.getStudents();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PostMapping("/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestBody StudentDto dto) {
        service.updateStudent(id, dto);
    }

    @PatchMapping("/{id}/name")
    public void updateStudentName(@PathVariable Long id,
                                  @RequestParam(value = "value") String name) {
        service.updateStudentName(id, name);
    }

    @PatchMapping("/{id}/lastname")
    public void updateStudentLastname(@PathVariable Long id,
                                      @RequestParam(value = "value") String lastname) {
        service.updateStudentLastname(id, lastname);
    }

    @PatchMapping("/{id}/age")
    public void updateStudentAge(@PathVariable Long id,
                                 @RequestParam(value = "value") Integer age) {
        service.updateStudentAge(id, age);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "Employee not found";
    }
}

