package com.rd.hibles40.rest;

import com.rd.hibles40.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rd.hibles40.domain.Student;
import com.rd.hibles40.service.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity<Student> findByName(@PathVariable String name) {
        return studentService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/students/find")
    public ResponseEntity<Student> findByParam(@RequestParam String name, @RequestParam int age) {
        return studentService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/students")
    public ResponseEntity<Void> save(@RequestBody Student student) {
        studentService.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/students/{id}/groups/{groupId}")
    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long groupId) {
        studentService.addGroup(id, groupId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/students/{id}")
    public void deleteById(@PathVariable Long id) {

    }


}