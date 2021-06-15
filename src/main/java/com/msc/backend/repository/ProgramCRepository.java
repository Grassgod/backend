package com.msc.backend.repository;

import com.msc.backend.entity.ProgramC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramCRepository extends JpaRepository<ProgramC, Long> {
    Boolean existsByFileName(String fileName);
}
