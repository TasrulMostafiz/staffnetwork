package com.example.staffnetwork.service;


import com.example.staffnetwork.database.entity.Education;
import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.database.entity.User;
import com.example.staffnetwork.database.entity.WorkExperience;
import com.example.staffnetwork.dto.EducationDTO;
import com.example.staffnetwork.dto.JobSeekerDTO;
import com.example.staffnetwork.dto.UserDTO;
import com.example.staffnetwork.dto.WorkExperienceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    private ModelMapper modelMapper;

    public MapperService(){
        modelMapper=new ModelMapper();
        modelMapper.typeMap(Education.class,EducationDTO.class).addMappings(mapper ->{
            mapper.map(src -> src.getUser().getId(),EducationDTO::setUser_id);
        });
    }

    public JobSeekerDTO mapJobSeekerToJobSeekerDTO(JobSeeker jobSeeker){
        return modelMapper.map(jobSeeker, JobSeekerDTO.class);
    }

    public JobSeeker mapJobSeekerDTOTJobSeeker(JobSeekerDTO jobSeekerDTO){
        return modelMapper.map(jobSeekerDTO, JobSeeker.class);
    }
    public UserDTO mapUserToUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public EducationDTO mapEducationToEducationDTO(Education education){return modelMapper.map(education,EducationDTO.class);}
    public Education mapEducationDTOToEducation(EducationDTO educationDTO){return modelMapper.map(educationDTO,Education.class);}
    public WorkExperienceDTO mapWorkExperienceToWorkExperienceDTO(WorkExperience workExperience){return modelMapper.map(workExperience, WorkExperienceDTO.class);}
    public WorkExperience mapWorkExperienceDTOToWorkExperience(WorkExperienceDTO workExperienceDTO){return modelMapper.map(workExperienceDTO,WorkExperience.class);}
}
