package com.example.staffnetwork.service.impl;

import com.example.staffnetwork.database.entity.Education;
import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.database.repository.EducationRepository;
import com.example.staffnetwork.database.repository.JobSeekerRepository;
import com.example.staffnetwork.database.repository.UserRepository;
import com.example.staffnetwork.dto.EducationDTO;
import com.example.staffnetwork.exceptoins.StaffNetworkAPIException;
import com.example.staffnetwork.service.EducationService;
import com.example.staffnetwork.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private MapperService mapperService;
    @Override
    public EducationDTO saveEducation(EducationDTO educationDTO) {
        try {
            Education  education = mapperService.mapEducationDTOToEducation(educationDTO);
            educationRepository.save(education);
            educationDTO=mapperService.mapEducationToEducationDTO(education);
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return educationDTO;
    }
}
