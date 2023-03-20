package com.example.staffnetwork.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dob;
    private String phone;


}
