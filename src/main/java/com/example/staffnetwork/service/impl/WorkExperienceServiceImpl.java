package com.example.staffnetwork.service.impl;

import com.example.staffnetwork.database.entity.WorkExperience;
import com.example.staffnetwork.database.repository.WorkExperienceRepository;
import com.example.staffnetwork.database.repository.UserRepository;
import com.example.staffnetwork.dto.WorkExperienceDTO;
import com.example.staffnetwork.dto.WorkExperienceDTO;
import com.example.staffnetwork.exceptoins.ResourceNotFoundException;
import com.example.staffnetwork.exceptoins.StaffNetworkAPIException;
import com.example.staffnetwork.service.MapperService;
import com.example.staffnetwork.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
    @Autowired
    private WorkExperienceRepository workExperienceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapperService mapperService;
    @Override
    public WorkExperienceDTO saveWorkExperience(WorkExperienceDTO workExperienceDTO) {
        try {
            WorkExperience workExperience = mapperService.mapWorkExperienceDTOToWorkExperience(workExperienceDTO);
            workExperience.setUser(userRepository.findByIdEquals(workExperienceDTO.getUser_id()).get());
            workExperienceRepository.save(workExperience);
            workExperienceDTO=mapperService.mapWorkExperienceToWorkExperienceDTO(workExperience);
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return workExperienceDTO;
    }

    @Override
    public WorkExperienceDTO editWorkExperience(WorkExperienceDTO workExperienceDTO) {
        try{
            Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(workExperienceDTO.getId());
            if(workExperienceOptional.isPresent()){
                WorkExperience workExperience=mapperService.mapWorkExperienceDTOToWorkExperience(workExperienceDTO);
                workExperience.setUser(userRepository.findByIdEquals(workExperienceDTO.getUser_id()).get());
                workExperienceRepository.save(workExperience);
                workExperienceDTO=mapperService.mapWorkExperienceToWorkExperienceDTO(workExperience);
            }else {
                throw new ResourceNotFoundException("WorkExperience not found","id",workExperienceDTO.getId());
            }
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return workExperienceDTO;
    }

    @Override
    public WorkExperienceDTO getWorkExperienceById(UUID id) {
        return mapperService.mapWorkExperienceToWorkExperienceDTO(workExperienceRepository.findById(id).get());
    }

    @Override
    public List<WorkExperienceDTO> getWorkExperienceByUserId(UUID id) {
        return workExperienceRepository.findByUser_IdEquals(id).stream()
                .map(WorkExperience -> mapperService.mapWorkExperienceToWorkExperienceDTO(WorkExperience))
                .collect(Collectors.toList());
    }
}
