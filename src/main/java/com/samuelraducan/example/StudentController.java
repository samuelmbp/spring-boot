package com.samuelraducan.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World From First Controller";
    }

    @PostMapping("/students")
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        Student student = toStudent(studentDto);
        Student savedStudent =  studentRepository.save(student);
        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        School school = new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String name) {
        return studentRepository.findAllByFirstNameContaining(name);
    }


    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }
}
