package com.samuelraducan.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(
            SchoolRepository schoolRepository,
            SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto) // shorter version
                // .map(school -> schoolMapper.toSchoolDto(school))
                .collect(Collectors.toList());
    }

    public SchoolDto saveSchool(SchoolDto schoolDto) {
        School school = schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }
}
