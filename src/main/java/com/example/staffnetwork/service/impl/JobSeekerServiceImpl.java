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
//            jobSeeker.setUser(userRepository.findByIdEquals(jobSeeker.getId()).get());
            JobSeeker jobSeeker = mapperService.mapJobSeekerDTOTJobSeeker(jobSeekerDTO);
            jobSeekerRepository.save(jobSeeker);
            jobSeekerDTO=mapperService.mapJobSeekerToJobSeekerDTO(jobSeeker);
        }catch (Exception e){
            throw new StaffNetworkAPIException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return jobSeekerDTO;
    }
}
