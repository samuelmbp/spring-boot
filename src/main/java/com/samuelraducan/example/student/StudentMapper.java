package com.samuelraducan.example.student;

import com.samuelraducan.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto studentDto) {
        if (studentDto == null) {
            throw new NullPointerException("StudentDto cannot be null");
        }

        Student student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        School school = new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
