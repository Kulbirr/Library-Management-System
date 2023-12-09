package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entities.Student;
import com.example.Library.Management.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/get_user")
    public String findNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }


    @PutMapping("/update_mob")
    public String updateMobileNo(@RequestParam("Id") Integer studentId, @RequestParam("mobile") String newContact){

        return studentService.updateMobileNo(studentId, newContact);
    }

    @PutMapping("/update_age")
    public String UpdateAge(@RequestParam("Id") Integer studentId,@RequestParam("age") int newAge){

        return studentService.updateAge(studentId, newAge);
    }
}
