package com.example.staffnetwork.service;

import com.example.staffnetwork.dto.EducationDTO;
import com.example.staffnetwork.dto.JobSeekerDTO;
import org.springframework.stereotype.Service;

public interface EducationService {
    public EducationDTO saveEducation(EducationDTO educationDTO);
}
