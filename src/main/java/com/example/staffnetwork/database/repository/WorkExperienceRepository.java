package com.example.staffnetwork.database.repository;

import com.example.staffnetwork.database.entity.Education;
import com.example.staffnetwork.database.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, UUID> {
    @Query("select e from WorkExperience e where e.user.id = ?1")
    List<WorkExperience> findByUser_IdEquals(UUID id);
}