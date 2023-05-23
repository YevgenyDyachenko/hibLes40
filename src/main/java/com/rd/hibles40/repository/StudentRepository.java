package com.rd.hibles40.repository;


import com.rd.hibles40.domain.Student;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByName(String name);

    Optional<Student> findStudentByNameAndAge(String name, int age);
}