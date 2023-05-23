package com.rd.hibles40.service;

import com.rd.hibles40.domain.*;
import com.rd.hibles40.dto.StudentGroupDto;
import com.rd.hibles40.repository.StudentGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;

    public void save(StudentGroup studentGroup) {
        studentGroupRepository.save(studentGroup);
    }

    public List<StudentGroupDto> findAll() {
        return studentGroupRepository.findAll()
                .stream()
                .map(StudentGroupService::buildStudentGroupDto)
                .collect(Collectors.toList());
    }

    private static StudentGroupDto buildStudentGroupDto(StudentGroup studentGroup) {
        return StudentGroupDto.builder()
                .id(studentGroup.getId())
                .name(studentGroup.getName())
                .studentsName(studentGroup.getStudents().stream()
                        .map(Student::getName)
                        .collect(Collectors.toList()))
                .build();
    }
}