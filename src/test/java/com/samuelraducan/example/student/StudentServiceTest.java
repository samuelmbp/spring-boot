package com.samuelraducan.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    // Mocking the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_create_a_student() {
        StudentDto studentDto = new StudentDto(
                "John", "Doe", "john@mail.com", 1
        );
        Student student = new Student(
                "John", "Doe", "john@mail.com", 1
        );

        Student savedStudent = new Student(
                "John", "Doe", "john@mail.com", 1
        );
        savedStudent.setId(1);

        // Mocking the return type
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "John", "Doe", "john@mail.com"
                ));

        StudentResponseDto responseDto = studentService.createStudent(studentDto);

        assertEquals(studentDto.firstName(), responseDto.firstName());
        assertEquals(studentDto.lastName(), responseDto.lastName());
        assertEquals(studentDto.email(), responseDto.email());

        verify(studentMapper, times(1))
                .toStudent(studentDto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_all_students() {
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "john@mail.com", 1));

        // Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John", "Doe", "john@mail.com"
                ));

        List<StudentResponseDto> studentResponseDtos =
                studentService.findAllStudents();

        // When
        assertEquals(students.size(), studentResponseDtos.size());
        verify(studentRepository, times(1)).findAll();
    }
}