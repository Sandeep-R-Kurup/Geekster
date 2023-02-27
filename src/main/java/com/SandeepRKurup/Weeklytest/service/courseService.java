package com.SandeepRKurup.Weeklytest.service;

import com.SandeepRKurup.Weeklytest.model.Course;
import com.SandeepRKurup.Weeklytest.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class courseService {


    @Autowired
    courseRepository courseRepository;
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public String deleteCourse(String courseId) {
        for (Course course : courseRepository.findAll()) {
            if (Objects.equals(course.getCourse_Id(), Integer.valueOf(courseId))){
                courseRepository.delete(course);
                return "Deleted";
            }
        }
        return "Not found";
    }
}

