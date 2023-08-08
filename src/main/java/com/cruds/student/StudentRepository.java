package com.cruds.student;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeBetween(int minAge, int maxAge);
}

