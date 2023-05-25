package com.rd.hibles40.service;


import com.rd.hibles40.domain.City;
import com.rd.hibles40.dto.CityDto;
import com.rd.hibles40.repository.CountryRepository;
import com.rd.hibles40.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository studentRepository;
    private final CountryRepository countryRepository;

    public List<CityDto> findAll() {
        return studentRepository.findAll().stream()
                .map(CityService::buildStudentDto)
                .collect(Collectors.toList());
    }

    private static CityDto buildStudentDto(City city) {
        var groupName = "NO GROUP";
        if (city.getStudentGroup() != null) {
            groupName = city.getStudentGroup().getName();
        }
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .age(city.getAge())
                .address(city.getAddress())
                .countryName(groupName)
                .build();
    }

    public Optional<City> findById(Long id) {

        return studentRepository.findById(id);
    }

    public Optional<City> findByName(String name) {
        return studentRepository.findCityByName(name);
    }

    public void save(City city) {

        studentRepository.save(city);
    }
    public void addGroup(Long studentId, Long groupId) {
        var group = countryRepository.findById(groupId).get();
        var student = studentRepository.findById(studentId).get();
        student.setStudentGroup(group);

        studentRepository.save(student);
    }
}