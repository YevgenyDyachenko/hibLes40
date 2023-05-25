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

    public void save(County county) {
        countryRepository.save(county);
    }

    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryService::buildCountryDto)
                .collect(Collectors.toList());
    }

    private static CountryDto buildCountryDto(County county) {
        return CountryDto.builder()
                .id(county.getId())
                .name(county.getName())
                .citiesName(county.getCities().stream()
                        .map(City::getName)
                        .collect(Collectors.toList()))
                .build();
    }
}