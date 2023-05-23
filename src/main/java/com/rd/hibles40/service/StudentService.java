package com.rd.hibles40.service;


import com.rd.hibles40.domain.Student;
import com.rd.hibles40.dto.StudentDto;
import com.rd.hibles40.repository.StudentGroupRepository;
import com.rd.hibles40.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentGroupRepository studentGroupRepository;

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(StudentService::buildStudentDto)
                .collect(Collectors.toList());
    }

    private static StudentDto buildStudentDto(Student student) {
        var groupName = "NO GROUP";
        if (student.getStudentGroup() != null) {
            groupName = student.getStudentGroup().getName();
        }
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .address(student.getAddress())
                .groupName(groupName)
                .build();
    }

    public Optional<Student> findById(Long id) {

        return studentRepository.findById(id);
    }

    public Optional<Student> findByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public void save(Student student) {

        studentRepository.save(student);
    }
    public void addGroup(Long studentId, Long groupId) {
        var group = studentGroupRepository.findById(groupId).get();
        var student = studentRepository.findById(studentId).get();
        student.setStudentGroup(group);

        studentRepository.save(student);
    }
}