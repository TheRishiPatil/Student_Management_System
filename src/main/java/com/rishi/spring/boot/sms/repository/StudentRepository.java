package com.rishi.spring.boot.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.spring.boot.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
