package com.example.staffnetwork.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "job_seeker")
public class JobSeeker extends BaseEntity {

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
    @NotBlank(message = "phone is required!")
    @NotNull
    private String phone;


}
