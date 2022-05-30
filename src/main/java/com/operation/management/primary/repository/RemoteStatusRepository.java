package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.RemoteStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RemoteStatusRepository extends JpaRepository<RemoteStatus, Long>, JpaSpecificationExecutor<RemoteStatus> {
    Optional<RemoteStatus> findById(Long key);
    

    @Query(value="SELECT p FROM RemoteStatus p WHERE p.name LIKE %:name%")
    Page<RemoteStatus> findByName(@Param("name")String name, Pageable pageable);
}
