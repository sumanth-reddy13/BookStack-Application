package com.example.student_management_system.Controllers;

import com.example.student_management_system.Dto.StudentUpdateMobRequestDto;
import com.example.student_management_system.Models.Student;
import com.example.student_management_system.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/issueBook")
    public String issueBook(@RequestParam("bName") String bookName, @RequestParam("st_id") int student_id) {
        return studentService.getBook(bookName, student_id);
    }
}
