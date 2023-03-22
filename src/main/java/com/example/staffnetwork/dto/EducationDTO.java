package com.example.staffnetwork.dto;

import com.example.staffnetwork.database.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class EducationDTO {
    private UUID id;
    private String school_name;
    @NotBlank(message = "degree_name is required!")
    @NotNull
    private String degree_name;
    @Past
    private LocalDate start_date;
    private LocalDate end_date;
    private boolean isRunning;
    private float duration;
}
