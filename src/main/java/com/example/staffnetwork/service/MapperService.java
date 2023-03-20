package com.example.staffnetwork.service;


import com.example.staffnetwork.database.entity.User;
import com.example.staffnetwork.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    private ModelMapper modelMapper;

    public MapperService(){
        modelMapper=new ModelMapper();
    }
    public UserDTO mapUserToUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
}
