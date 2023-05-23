package com.rd.hibles40.rest;

import com.rd.hibles40.domain.StudentGroup;
import com.rd.hibles40.dto.StudentGroupDto;
import com.rd.hibles40.service.StudentGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentGroupController {

    private final StudentGroupService studentGroupService;

    @PostMapping("/studentGroups")
    public void save(@RequestBody StudentGroup studentGroup) {
        studentGroupService.save(studentGroup);
    }

    @GetMapping("/studentGroups")
    public List<StudentGroupDto> findAll() {
        return studentGroupService.findAll();
    }
}