package com.cruds.student;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
	
	@Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
    }

    public Student updateStudentAge(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));

        LocalDate currentDate = LocalDate.now();
        LocalDate dob = LocalDate.of(student.getDateOfBirth().getYear(), student.getDateOfBirth().getMonth(), student.getDateOfBirth().getDay());

        int age = Period.between(dob, currentDate).getYears();
        student.setAge(age);

        return studentRepository.save(student);
    }
    
    public List<Student> getAll()
    {
    	return studentRepository.findAll();
    }

    public List<Student> getStudentsBetweenAgeRange(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }
}

