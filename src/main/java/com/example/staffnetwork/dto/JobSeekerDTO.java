package com.example.staffnetwork.dto;

import com.example.staffnetwork.database.entity.Gender;
import com.example.staffnetwork.database.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class JobSeekerDTO {
    private UUID id;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dob;
    private String phone;
}
