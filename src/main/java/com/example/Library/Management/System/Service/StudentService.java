package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entities.Student;
import com.example.Library.Management.System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student has been added Successfully!";
    }

    public String findNameByEmail(String email){

        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }


    public String updateMobileNo(Integer studentId, String newContact){

        Student student=studentRepository.findById(studentId).get();

        student.setContact(newContact);

        studentRepository.save(student);

        return "Contact updated successfully";
    }

    public String updateAge(Integer studentId, int newAge){

        Student student=studentRepository.findById(studentId).get();

        student.setAge(newAge);

        studentRepository.save(student);

        return "Age updated successfully";
    }
}
