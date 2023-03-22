package com.example.staffnetwork.controller;


import com.example.staffnetwork.dto.WorkExperienceDTO;
import com.example.staffnetwork.dto.WorkExperienceDTO;
import com.example.staffnetwork.service.WorkExperienceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/workexperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceService workExperienceService;
    @PostMapping("/save")
    public ResponseEntity<WorkExperienceDTO> saveWorkExperience(@Valid @RequestBody WorkExperienceDTO WorkExperienceDTO){
        return new ResponseEntity<>(workExperienceService.saveWorkExperience(WorkExperienceDTO), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<WorkExperienceDTO> editWorkExperience(@Valid @RequestBody WorkExperienceDTO WorkExperienceDTO){
        return new ResponseEntity<>(workExperienceService.editWorkExperience(WorkExperienceDTO), HttpStatus.OK);
    }

    @GetMapping("/WorkExperiencebyid/{id}")
    public ResponseEntity<WorkExperienceDTO> getWorkExperienceById(@PathVariable("id") String id){
        return new ResponseEntity<>(workExperienceService.getWorkExperienceById(UUID.fromString(id)), HttpStatus.OK);
    }

    @GetMapping("/WorkExperiencebyuserid/{id}")
    public ResponseEntity<List<WorkExperienceDTO>> getWorkExperienceByUserId(@PathVariable("id") String id){
        return new ResponseEntity<>(workExperienceService.getWorkExperienceByUserId(UUID.fromString(id)), HttpStatus.OK);
    }
}
