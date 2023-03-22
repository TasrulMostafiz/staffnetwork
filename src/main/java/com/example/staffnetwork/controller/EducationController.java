package com.example.staffnetwork.controller;

import com.example.staffnetwork.dto.EducationDTO;
import com.example.staffnetwork.service.EducationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/education")
public class EducationController {
    @Autowired
    private EducationService educationService;
    @PostMapping("/save")
    public ResponseEntity<EducationDTO> saveEducation(@Valid @RequestBody EducationDTO educationDTO){
        return new ResponseEntity<>(educationService.saveEducation(educationDTO), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<EducationDTO> editEducation(@Valid @RequestBody EducationDTO educationDTO){
        return new ResponseEntity<>(educationService.editEducation(educationDTO), HttpStatus.OK);
    }
}
