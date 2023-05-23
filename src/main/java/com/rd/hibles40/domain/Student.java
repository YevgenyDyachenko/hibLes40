package com.rd.hibles40.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String address;

//    @ManyToOne
//    @JoinColumn(name="student_group_id")
//    private StudentGroup studentGroup;
}