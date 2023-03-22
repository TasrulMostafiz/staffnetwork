package com.example.staffnetwork.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    @ManyToOne()
    @JoinColumn(
            name = "user_id"
    )
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
