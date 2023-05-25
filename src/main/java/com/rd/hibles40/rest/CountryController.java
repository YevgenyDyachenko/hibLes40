package com.rd.hibles40.rest;

import com.rd.hibles40.domain.County;
import com.rd.hibles40.dto.CountryDto;
import com.rd.hibles40.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService studentGroupService;

    @PostMapping("/countries")
    public void save(@RequestBody County studentGroup) {
        studentGroupService.save(studentGroup);
    }

    @GetMapping("/countries")
    public List<CountryDto> findAll() {
        return studentGroupService.findAll();
    }
}