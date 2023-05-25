package com.rd.hibles40.service;

import com.rd.hibles40.domain.*;
import com.rd.hibles40.dto.CountryDto;
import com.rd.hibles40.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public void save(County studentGroup) {
        countryRepository.save(studentGroup);
    }

    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryService::buildStudentGroupDto)
                .collect(Collectors.toList());
    }

    private static CountryDto buildStudentGroupDto(County studentGroup) {
        return CountryDto.builder()
                .id(studentGroup.getId())
                .name(studentGroup.getName())
                .citiesName(studentGroup.getCities().stream()
                        .map(City::getName)
                        .collect(Collectors.toList()))
                .build();
    }
}