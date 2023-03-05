package com.SandeepRkurup.customerQueries.service;

import com.SandeepRkurup.customerQueries.model.Student;
import com.SandeepRkurup.customerQueries.repository.StudentRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student saveStudent(Student student) {
        Student student1=studentRepository.save(student);
        return student1;
    }

    public JSONObject createResponse (Student student){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("studentId",student.getStudentId());
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());

        jsonObject.put("age",student.getAge());
        jsonObject.put("active",student.getActive());
        jsonObject.put("admission_date",student.getAdmissionDate());
        return jsonObject;
    }

    public JSONArray findStudentByfirstNameAndLastName(String firstName, String lastName) {
        List<Student> students=studentRepository.findStudentByfirstNameandLastName(firstName,lastName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstName(String firstName) {
        List<Student> students=studentRepository.findStudentByfirstName(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByDate(Date startDate, Date endDate) {
        List<Student> students=studentRepository.findStudentByDate(startDate,endDate);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByAgelessthan(Integer age) {
        List<Student> students=studentRepository.findStudentByAgelessthan(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByAgemorethan(Integer age) {
        List<Student> students=studentRepository.findStudentByAgemorethan(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentbyagein(List<Integer> ages) {
        List<Student> students=studentRepository.findStudentbyagein(ages);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }


    public JSONArray getactivestudent() {
        List<Student> students=studentRepository.getactivestudent();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray getinactivestudent() {
        List<Student> students=studentRepository.getinactivestudent();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }


}

