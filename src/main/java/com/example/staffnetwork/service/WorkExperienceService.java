package com.example.staffnetwork.service;

import com.example.staffnetwork.dto.WorkExperienceDTO;

import java.util.List;
import java.util.UUID;

public interface WorkExperienceService {
    public WorkExperienceDTO saveWorkExperience(WorkExperienceDTO WorkExperienceDTO);
    public WorkExperienceDTO editWorkExperience(WorkExperienceDTO WorkExperienceDTO);
    public WorkExperienceDTO getWorkExperienceById(UUID id);
    public List<WorkExperienceDTO> getWorkExperienceByUserId(UUID id);
}
