package com.rd.hibles40.rest;

import com.rd.hibles40.dto.CityDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rd.hibles40.domain.City;
import com.rd.hibles40.service.CityService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService studentService;

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cities/name/{name}")
    public ResponseEntity<City> findByName(@PathVariable String name) {
        return studentService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cities/find")
    public ResponseEntity<City> findByParam(@RequestParam String name, @RequestParam int age) {
        return studentService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cities")
    public ResponseEntity<Void> save(@RequestBody City city) {
        studentService.save(city);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/cities/{id}/groups/{groupId}")
    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long groupId) {
        studentService.addGroup(id, groupId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/cities/{id}")
    public void deleteById(@PathVariable Long id) {

    }


}