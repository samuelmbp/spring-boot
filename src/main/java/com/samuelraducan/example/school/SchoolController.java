package com.samuelraducan.example.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.saveSchool(schoolDto);
    }
}
