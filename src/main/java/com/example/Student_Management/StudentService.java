package com.example.Student_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int admnNo) {
        return studentRepository.getStudent(admnNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentByPathVariable(int admnNo) {
        return studentRepository.getStudentByPathVariable(admnNo);
    }

    public String DeleteStudent(int admnNo) {
        return studentRepository.DeleteStudent(admnNo);
    }

    public Student UpdateCourse(int admnNo, String newCourse) {
        return studentRepository.UpdateCourse(admnNo, newCourse);
    }


    public int getTotalStudent() {
        return studentRepository.getTotalStudent();
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }
}
