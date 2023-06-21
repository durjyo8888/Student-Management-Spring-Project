package com.example.Student_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get_Info")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo){
        Student s = studentService.getStudent(admnNo);
        if(s == null){
            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s, HttpStatus.ACCEPTED);
    }
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int admnNo){
        Student s = studentService.getStudentByPathVariable(admnNo);
        if(s == null){
            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete_Student")
    public ResponseEntity DeleteStudent(@RequestParam("id") int admnNo){
        String s = studentService.DeleteStudent(admnNo);
        return new ResponseEntity(s, HttpStatus.GONE);
    }

   @PutMapping("/Update_course")
    public ResponseEntity UpdateCourse(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse){
        Student s = studentService.UpdateCourse(admnNo, newCourse);
        return new ResponseEntity(s, HttpStatus.OK);
    }

     //total number of students whose age is greater than 25
    @GetMapping("/get_total_students")
    public ResponseEntity getTotalStudent(){
        int ans = studentService.getTotalStudent();
        return new ResponseEntity(ans, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list_of_student")
    public ResponseEntity getAllStudent(){
        List<Student> list = new ArrayList<>(studentService.getAllStudent());
        return new ResponseEntity(list, HttpStatus.ACCEPTED);
    }
}


//APIs basic spring boot

//    Map<Integer,Student> studentDb = new HashMap<>();
//    @GetMapping("/get_Info")
//    public Student getStudent(@RequestParam("id") int admnNo){
//        return studentDb.get(admnNo);
//    }
//    @PostMapping("/add_student")
//    public String addStudent(@RequestBody Student student){
//        studentDb.put(student.getAdmnNo(), student);
//        return "Student added successfully";
//    }
//    @GetMapping("/get/{id}")
//    public Student getStudentByPathVariable(@PathVariable("id") int admbNo){
//        return studentDb.get(admbNo);
//    }
//
//    @DeleteMapping("/delete_Student")
//    public String DeleteStudent(@RequestParam("id") int admnNo){
//        studentDb.remove(admnNo);
//        return "student delete successfully";
//    }
//
//    @PutMapping("/Update_course")
//    public Student UpdateCourse(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse){
//        if(!studentDb.containsKey(admnNo)){
//            throw new RuntimeException("Student doesn't exist");
//        }
//        Student student = studentDb.get(admnNo);
//        student.setCourse(newCourse);
//        return student;
//    }
//
//    //total number of students whose age is greater than 25
//    @GetMapping("/get_total_students")
//    public int getTotalStudent(){
//
//        int total = 0;
//        for(int admnNo: studentDb.keySet()){
//            if(studentDb.get(admnNo).getAge()>25){
//                total++;
//            }
//        }
//        return total;
//    }



//API with three layer

//    @Autowired
//    StudentService studentService;
//    @GetMapping("/get_Info")
//    public Student getStudent(@RequestParam("id") int admnNo){
//        return studentService.getStudent(admnNo);
//    }
//    @PostMapping("/add_student")
//    public String addStudent(@RequestBody Student student){
//        return studentService.addStudent(student);
//    }
//    @GetMapping("/get/{id}")
//    public Student getStudentByPathVariable(@PathVariable("id") int admnNo){
//        return studentService.getStudentByPathVariable(admnNo);
//    }
//
//    @DeleteMapping("/delete_Student")
//    public String DeleteStudent(@RequestParam("id") int admnNo){
//        return studentService.DeleteStudent(admnNo);
//
//    }
//
//    @PutMapping("/Update_course")
//    public Student UpdateCourse(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse){
//        return studentService.UpdateCourse(admnNo, newCourse);
//    }
//
//    //total number of students whose age is greater than 25
//    @GetMapping("/get_total_students")
//    public int getTotalStudent(){
//        return studentService.getTotalStudent();
//    }
//
//    @GetMapping("/list_of_student")
//    public List<Student> getAllStudent(){
//        return studentService.getAllStudent();
//    }




//    API with ResponseEntity

//    @Autowired
//    StudentService studentService;
//    @GetMapping("/get_Info")
//    public ResponseEntity getStudent(@RequestParam("id") int admnNo){
//        Student s = studentService.getStudent(admnNo);
//        if(s == null){
//            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity(s, HttpStatus.ACCEPTED);
//    }
//    @PostMapping("/add_student")
//    public ResponseEntity addStudent(@RequestBody Student student){
//        String s = studentService.addStudent(student);
//        return new ResponseEntity<>(s, HttpStatus.CREATED);
//    }
//    @GetMapping("/get/{id}")
//    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int admnNo){
//        Student s = studentService.getStudentByPathVariable(admnNo);
//        if(s == null){
//            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity(s, HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping("/delete_Student")
//    public ResponseEntity DeleteStudent(@RequestParam("id") int admnNo){
//        String s = studentService.DeleteStudent(admnNo);
//        return new ResponseEntity(s, HttpStatus.GONE);
//    }
//
//    @PutMapping("/Update_course")
//    public ResponseEntity UpdateCourse(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse){
//        Student s = studentService.UpdateCourse(admnNo, newCourse);
//        return new ResponseEntity(s, HttpStatus.OK);
//    }
//
//    //total number of students whose age is greater than 25
//    @GetMapping("/get_total_students")
//    public ResponseEntity getTotalStudent(){
//        int ans = studentService.getTotalStudent();
//        return new ResponseEntity(ans, HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping("/list_of_student")
//    public ResponseEntity getAllStudent(){
//        List<Student> list = new ArrayList<>(studentService.getAllStudent());
//        return new ResponseEntity(list, HttpStatus.ACCEPTED);
//    }