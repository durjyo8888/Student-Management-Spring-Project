package com.example.Student_Management;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> studentDb = new HashMap<>();

    public Student getStudent(int admnNo) {
        return studentDb.get(admnNo);
    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getAdmnNo())){
            return "student already present";
        }
        studentDb.put(student.getAdmnNo(), student);
        return "Student added successfully";
    }

    public Student getStudentByPathVariable(int admnNo) {
        return studentDb.get(admnNo);
    }

    public String DeleteStudent(int admnNo) {
        studentDb.remove(admnNo);
        return "student delete successfully";
    }

    public Student UpdateCourse(int admnNo, String newCourse) {
        if(!studentDb.containsKey(admnNo)){
            throw new RuntimeException("Student doesn't exist");
        }
        Student student = studentDb.get(admnNo);
        student.setCourse(newCourse);
        return student;
    }

    public int getTotalStudent() {
        int total = 0;
        for(int admnNo : studentDb.keySet()){
            if(studentDb.get(admnNo).getAge() > 25){
                total++;
            }
        }
        return total;
    }

    public List<Student> getAllStudent() {
        return new ArrayList<>(studentDb.values());
    }
}
