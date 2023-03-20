package com.example.staffnetwork.service.impl;

import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.database.repository.JobSeekerRepository;
import com.example.staffnetwork.database.repository.UserRepository;
import com.example.staffnetwork.dto.JobSeekerDTO;
import com.example.staffnetwork.exceptoins.ResourceNotFoundException;
import com.example.staffnetwork.exceptoins.StaffNetworkAPIException;
import com.example.staffnetwork.service.JobSeekerService;
import com.example.staffnetwork.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperService mapperService;

    @Override
    public JobSeekerDTO saveJobSeeker(JobSeekerDTO jobSeekerDTO) {
        try {
            JobSeeker jobSeeker = mapperService.mapJobSeekerDTOTJobSeeker(jobSeekerDTO);
            jobSeekerRepository.save(jobSeeker);
            jobSeekerDTO=mapperService.mapJobSeekerToJobSeekerDTO(jobSeeker);
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return jobSeekerDTO;
    }

    @Override
    public JobSeekerDTO editJobSeeker(JobSeekerDTO jobSeekerDTO) {
        try
        {
            Optional<JobSeeker> jobSeekerOptional = jobSeekerRepository.findById(jobSeekerDTO.getId());
            if(jobSeekerOptional.isPresent()){
                JobSeeker jobSeeker=mapperService.mapJobSeekerDTOTJobSeeker(jobSeekerDTO);
                jobSeekerRepository.save(jobSeeker);
                jobSeekerDTO=mapperService.mapJobSeekerToJobSeekerDTO(jobSeeker);
            }else{
                throw new ResourceNotFoundException("Job Seeker not found","id",jobSeekerDTO.getId());
            }
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return jobSeekerDTO;
    }
}
