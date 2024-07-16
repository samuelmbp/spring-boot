package com.samuelraducan.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First name should not be empty")
        String firstName,

        @NotEmpty(message = "Last name should not be empty")
        String lastName,

        String email,
        Integer schoolId
) {
}
