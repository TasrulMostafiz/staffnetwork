package com.example.staffnetwork.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education")
public class Education extends BaseEntity{
    @Id
    @Column(name = "user_id")
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @Transient
    private User user;
    @NotBlank(message = "school_name is required!")
    @NotNull
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
