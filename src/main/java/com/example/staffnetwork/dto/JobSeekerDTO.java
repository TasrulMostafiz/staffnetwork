package com.example.staffnetwork.dto;

import com.example.staffnetwork.database.entity.Gender;
import com.example.staffnetwork.database.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class JobSeekerDTO {
    private UUID id;
    @NotBlank(message = "firstname is required!")
    @NotNull
    private String firstname;
    @NotBlank(message = "lastname is required!")
    @NotNull
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Past
    private LocalDate dob;
    private String phone;
}
