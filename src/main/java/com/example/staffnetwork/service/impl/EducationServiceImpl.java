package com.example.staffnetwork.service.impl;

import com.example.staffnetwork.database.entity.Education;
import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.database.repository.EducationRepository;
import com.example.staffnetwork.database.repository.JobSeekerRepository;
import com.example.staffnetwork.database.repository.UserRepository;
import com.example.staffnetwork.dto.EducationDTO;
import com.example.staffnetwork.exceptoins.ResourceNotFoundException;
import com.example.staffnetwork.exceptoins.StaffNetworkAPIException;
import com.example.staffnetwork.service.EducationService;
import com.example.staffnetwork.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapperService mapperService;
    @Override
    public EducationDTO saveEducation(EducationDTO educationDTO) {
        try {
            Education  education = mapperService.mapEducationDTOToEducation(educationDTO);
            education.setUser(userRepository.findByIdEquals(educationDTO.getUser_id()).get());
            educationRepository.save(education);
            educationDTO=mapperService.mapEducationToEducationDTO(education);
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return educationDTO;
    }

    @Override
    public EducationDTO editEducation(EducationDTO educationDTO) {
        try{
            Optional<Education> educationOptional = educationRepository.findById(educationDTO.getId());
            if(educationOptional.isPresent()){
                Education education=mapperService.mapEducationDTOToEducation(educationDTO);
                education.setUser(userRepository.findByIdEquals(educationDTO.getUser_id()).get());
                educationRepository.save(education);
                educationDTO=mapperService.mapEducationToEducationDTO(education);
            }else {
                throw new ResourceNotFoundException("Education not found","id",educationDTO.getId());
            }
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return educationDTO;
    }

    @Override
    public EducationDTO getEducationById(UUID id) {
        return mapperService.mapEducationToEducationDTO(educationRepository.findById(id).get());
    }

    @Override
    public List<EducationDTO> getEducationByUserId(UUID id) {
        return educationRepository.findByUser_IdEquals(id).stream()
                .map(education -> mapperService.mapEducationToEducationDTO(education))
                .collect(Collectors.toList());
    }
}
