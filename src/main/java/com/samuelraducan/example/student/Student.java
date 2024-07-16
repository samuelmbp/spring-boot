package com.samuelraducan.example.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.samuelraducan.example.studentprofile.StudentProfile;
import com.samuelraducan.example.school.School;
import jakarta.persistence.*;

@Entity
@Table(name = "students") // Can change the table name
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    // Change the column name and length
    // @Column(name = "c_firstName", length= 20)
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private Integer age;

    // CascadeType.ALL:
    //  - WHEN STUDENT IS REMOVED, THE STUDENT PROFILE ALSO IS REMOVED
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    // Does not need to serialize the parent (school)
        // avoids infinite loop between school and student
    @JsonBackReference
    private School school;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
