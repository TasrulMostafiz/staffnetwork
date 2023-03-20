package com.example.staffnetwork.service;

import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.dto.JobSeekerDTO;

public interface JobSeekerService {
    public JobSeekerDTO saveJobSeeker(JobSeekerDTO jobSeekerDTO);
    public JobSeekerDTO editJobSeeker(JobSeekerDTO jobSeekerDTO);
}
