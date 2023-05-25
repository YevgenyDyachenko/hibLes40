package com.rd.hibles40.repository;


import com.rd.hibles40.domain.City;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findCityByName(String name);

    Optional<City> findCityByNameAndAge(String name, int age);
}