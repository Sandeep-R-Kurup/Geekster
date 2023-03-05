package com.SandeepRkurup.customerQueries.controller;


import com.SandeepRkurup.customerQueries.model.Student;
import com.SandeepRkurup.customerQueries.service.StudentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

// create student
    @PostMapping("/create_student")
    public ResponseEntity<String> createStudent(@RequestBody String studentData){
        JSONObject errorList=isValidStudent(studentData);
        if(errorList.isEmpty()){
            Student student=setStudent(studentData);
            return new ResponseEntity<>("Student created at:- "+student.getStudentId(), HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(errorList.toString(),HttpStatus.BAD_REQUEST);
    }

    // json object
    private Student setStudent(String studentData) {
        JSONObject studentObj=new JSONObject(studentData);
        Student student=new Student();
        student.setFirstName(studentObj.getString("firstName"));
        student.setLastName(studentObj.getString("lastName"));
        student.setAge(studentObj.getInt("age"));
        student.setActive(true);
        Date date=new Date(System.currentTimeMillis());
        student.setAdmissionDate(date);

        Student Student=studentService.saveStudent(student);
        return Student;
    }

    // Validation
    private JSONObject isValidStudent(String studentData) {
        JSONObject studentObj=new JSONObject(studentData);
        JSONObject errorList=new JSONObject();
        if(!studentObj.has("firstName")){
            errorList.put("firstName","Missing parameter");
        }
        if(!studentObj.has("lastName")){
            errorList.put("lastName","Missing parameter");
        }
        if(!studentObj.has("age")){
            errorList.put("age","Missing parameter");
        }
        return errorList;
    }

    @GetMapping("/getStudentByFirstAndLastName")
    public ResponseEntity<String> findStudentByfirstAndlastName(@RequestParam String firstName, @RequestParam String lastName){
        JSONArray students=studentService.findStudentByfirstNameAndLastName(firstName,lastName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with firstName"+firstName+"and lastName"+lastName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentByFirstName")
    public ResponseEntity<String> findStudentByfirstName(@RequestParam String firstName){
        JSONArray students=studentService.findStudentByfirstName(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByDate")
    public ResponseEntity<String> findStudentBydate(@RequestParam Date startDate,@RequestParam Date endDate){
        JSONArray students=studentService.findStudentByDate(startDate,endDate);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user btw "+startDate+" & " +endDate+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentWithAgelessthan")
    public ResponseEntity<String> findStudentWithAgelessthan(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAgelessthan(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age less than "+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentWithAgemorethan")
    public ResponseEntity<String> findStudentWithAgemorethan(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAgemorethan(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age more than "+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentWithagein")
    public ResponseEntity<String> findStudentWithagein(@RequestParam List<Integer> ages){
        JSONArray students=studentService.findStudentbyagein(ages);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user in age"+ages+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getactivestudent")
    public ResponseEntity<String> getactivestudent(){
        JSONArray students=studentService.getactivestudent();
        if(students.isEmpty()){
            return new ResponseEntity<>("No active students exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getinactivestudent")
    public ResponseEntity<String> getinactivestudent(){
        JSONArray students=studentService.getinactivestudent();
        if(students.isEmpty()){
            return new ResponseEntity<>("No inactive students exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

}