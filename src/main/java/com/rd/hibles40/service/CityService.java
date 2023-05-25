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

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(CityService::buildCityDto)
                .collect(Collectors.toList());
    }

    private static CityDto buildCityDto(City city) {
        var countryName = "NO COUNTRY";

        if (city.getCountry() != null) {
            countryName = city.getCountry().getName();

        }
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .age(city.getAge())
                .address(city.getAddress())
                .countryName(countryName)
                .build();
    }

    public Optional<City> findById(Long id) {

        return cityRepository.findById(id);
    }

    public Optional<City> findByName(String name) {
        return cityRepository.findCityByName(name);
    }

    public void save(City city) {

        cityRepository.save(city);
    }
    public void addGroup(Long cityId, Long groupId) {
        var county = countryRepository.findById(groupId).get();
        var city = cityRepository.findById(cityId).get();
        city.setCountry(county);

        cityRepository.save(city);
    }
}