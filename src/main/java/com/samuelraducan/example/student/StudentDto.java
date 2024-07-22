package com.samuelraducan.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record StudentDto(
        @NotEmpty(message = "First name should not be empty")
        String firstName,

        @NotEmpty(message = "Last name should not be empty")
        String lastName,

        @Email(message = "Please add a valid email address")
        String email,

        Integer schoolId
) {
}
