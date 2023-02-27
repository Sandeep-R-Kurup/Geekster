package com.SandeepRKurup.Weeklytest.service;

import com.SandeepRKurup.Weeklytest.model.Student;
import com.SandeepRKurup.Weeklytest.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class studentService {
    @Autowired
    studentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public String deleteStudent(String studentId) {
        for (Student student : studentRepository.findAll()) {
            if (Objects.equals(student.getStudent_Id(), Integer.valueOf(studentId))){
                studentRepository.delete(student);
                return "Student Deleted";
            }
        }
        return "Student Not found";
    }
}
