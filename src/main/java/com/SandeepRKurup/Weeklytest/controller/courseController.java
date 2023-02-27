package com.SandeepRKurup.Weeklytest.controller;


import com.SandeepRKurup.Weeklytest.repository.courseRepository;
import com.SandeepRKurup.Weeklytest.repository.studentRepository;
import com.SandeepRKurup.Weeklytest.service.courseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SandeepRKurup.Weeklytest.model.Course;
import com.SandeepRKurup.Weeklytest.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class courseController {
    @Autowired
    courseService courseService;
    @Autowired
    studentRepository studentRepository;
    @Autowired
    courseRepository courseRepository;


    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody String newCourse) {

        JSONObject json = new JSONObject(newCourse);
        Course course = new Course();
        course.setDescription(json.getString("description"));
        course.setTitle(json.getString("title"));
        course.setDuration(json.getString("duration"));

        List<Student> list=new ArrayList<>();
        String studentid = json.getString("student_id");
        Student student = studentRepository.findById(Integer.valueOf(studentid)).get();
        if(null != student){
            list.add(student);
        }
        course.setStudentList(list);
        Course cs = courseRepository.save(course);
        return new ResponseEntity<String>(cs.toString(), HttpStatusCode.valueOf(200));

    }
    @GetMapping("/get-course")
    public List<Course> getAllCourse(){
        List<Course> list = courseService.getAllCourse();
        return list;
    }
    @DeleteMapping("/delete-course/{course_id}")
    public String deleteCourse(@PathVariable String course_id){
        return courseService.deleteCourse(course_id);
    }

    @PutMapping("/update-course/{courseid}")
    public ResponseEntity<String> updateCourse(@RequestBody String updatedCourse, @PathVariable String courseid){

        for (Course course : courseRepository.findAll()) {
            if(Objects.equals(course.getCourse_Id(), Integer.valueOf(courseid))){
                JSONObject json = new JSONObject(updatedCourse);
                Course crs = new Course();
                crs.setDescription(json.getString("description"));
                crs.setTitle(json.getString("title"));
                crs.setDuration(json.getString("duration"));

                course.setDescription(crs.getDescription());
                course.setTitle(crs.getTitle());
                course.setDuration(crs.getDuration());
                Course cs = courseRepository.save(course);
                return new ResponseEntity<String>(cs.toString(), HttpStatusCode.valueOf(200));
            }
        }
        return new ResponseEntity<String>("Not found", HttpStatusCode.valueOf(400));

    }



}
