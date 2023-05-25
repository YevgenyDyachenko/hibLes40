package com.rd.hibles40.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "country")
   
    private List<City> cities;
}