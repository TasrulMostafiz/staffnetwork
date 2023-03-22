package com.example.staffnetwork.dto;

import com.example.staffnetwork.database.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class WorkExperienceDTO {
    private UUID id;
    private UUID user_id;
    @NotBlank(message = "postname is required!")
    @NotNull
    private String postname;
    @NotBlank(message = "organization is required!")
    @NotNull
    private String organization;
    @NotBlank(message = "responsibility is required!")
    @NotNull
    private String responsibility;
    @Past
    private LocalDate start_date;
    private LocalDate end_date;
    private boolean isCurrent;
    private float duration;
}
