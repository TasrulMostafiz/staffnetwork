package com.example.staffnetwork.database.repository;

import com.example.staffnetwork.database.entity.JobSeeker;
import com.example.staffnetwork.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, UUID> {
}