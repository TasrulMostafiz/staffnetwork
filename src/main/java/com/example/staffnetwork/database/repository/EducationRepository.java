package com.example.staffnetwork.database.repository;

import com.example.staffnetwork.database.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {
    @Query("select e from Education e where e.user.id = ?1")
    List<Education> findByUser_IdEquals(UUID id);

}