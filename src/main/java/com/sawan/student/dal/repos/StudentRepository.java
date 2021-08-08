package com.sawan.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.sawan.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
