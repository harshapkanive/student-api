package com.cruds.student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
    private  StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}/age")
    public Student updateStudentAge(@PathVariable Long studentId) {
        return studentService.updateStudentAge(studentId);
    }

    @GetMapping("/age-range")
    public List<Student> getStudentsBetweenAgeRange() {
        return studentService.getStudentsBetweenAgeRange(18, 25);
    }
}