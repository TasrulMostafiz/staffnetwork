package com.example.staffnetwork.database.repository;

import com.example.staffnetwork.database.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {
}