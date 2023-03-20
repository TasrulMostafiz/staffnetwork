package com.example.staffnetwork.controller;

import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.dto.JobSeekerDTO;
import com.example.staffnetwork.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobseeker")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;
    @PostMapping("/save")
    public ResponseEntity<JobSeekerDTO> saveTask(@RequestBody JobSeekerDTO jobSeeker){
        return new ResponseEntity<>(jobSeekerService.saveJobSeeker(jobSeeker), HttpStatus.OK);
    }
}
