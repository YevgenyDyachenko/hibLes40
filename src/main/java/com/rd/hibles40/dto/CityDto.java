package com.rd.hibles40.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CityDto {
    private Long id;
    private String name;
    private int age;
    private String address;
    private String countryName;
}
