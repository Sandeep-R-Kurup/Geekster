package com.SandeepRkurup.customerQueries.repository;

import com.SandeepRkurup.customerQueries.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from tbl_student where first_name=:firstName and last_name=:lastName",nativeQuery = true)
    List<Student> findStudentByfirstNameandLastName(String firstName, String lastName);
    @Query(value = "select * from tbl_student where first_name=:firstName",nativeQuery = true)
    List<Student> findStudentByfirstName(String firstName);
    @Query(value = "select * from tbl_student where admission_date between :startDate and :endDate",nativeQuery = true)
    List<Student> findStudentByDate(Date startDate, Date endDate);
    @Query(value = "select * from tbl_student where age<:age",nativeQuery = true)
    List<Student> findStudentByAgelessthan(Integer age);
    @Query(value = "select * from tbl_student where age>:age",nativeQuery = true)
    List<Student> findStudentByAgemorethan(Integer age);
    @Query(value = "select * from tbl_student where age in(:ages)",nativeQuery = true)
    List<Student> findStudentbyagein(List<Integer> ages);
    @Query(value = "select * from tbl_student where active=true",nativeQuery = true)
    List<Student> getactivestudent();
    @Query(value = "select * from tbl_student where active=false",nativeQuery = true)
    List<Student> getinactivestudent();


}
