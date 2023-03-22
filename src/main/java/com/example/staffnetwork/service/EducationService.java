package com.example.staffnetwork.service;

import com.example.staffnetwork.dto.EducationDTO;
import com.example.staffnetwork.dto.JobSeekerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface EducationService {
    public EducationDTO saveEducation(EducationDTO educationDTO);
    public EducationDTO editEducation(EducationDTO educationDTO);
    public EducationDTO getEducationById(UUID id);
    public List<EducationDTO> getEducationByUserId(UUID id);
}
