package com.rd.hibles40.repository;



import com.rd.hibles40.domain.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<County, Long> {
}