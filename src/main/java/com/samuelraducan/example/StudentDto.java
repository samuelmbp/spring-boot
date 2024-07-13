package com.samuelraducan.example;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
