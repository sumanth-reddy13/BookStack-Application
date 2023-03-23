package com.example.student_management_system.Controllers;

import com.example.student_management_system.Dto.StudentUpdateMobRequestDto;
import com.example.student_management_system.Models.Student;
import com.example.student_management_system.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @PutMapping("/updateMobNo")
    public String updateMobNo(@RequestBody StudentUpdateMobRequestDto studentUpdateMobRequestDto) {
        return studentService.updateMobileNo(studentUpdateMobRequestDto);
    }

    @GetMapping("/getStudentByEmail/{email}")
    public Student getStudent(@PathVariable("email") String email) {
        return studentService.findStudent(email);
    }

    @PutMapping("/issueBook")
    public String issueBook(@RequestParam("bName") String bookName, @RequestParam("st_id") int student_id) {
        return studentService.getBook(bookName, student_id);
    }

    @DeleteMapping("delete")
    public String deleteStudent(@RequestParam("id") int id) {
        return studentService.delete(id);
    }
}
