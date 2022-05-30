package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.RemoteUserList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RemoteUserListRepository extends JpaRepository<RemoteUserList, Long>, JpaSpecificationExecutor<RemoteUserList> {
    Optional<RemoteUserList> findById(Long id);
    
    @Query(value="SELECT p FROM RemoteUserList p WHERE p.name LIKE %:name%")
    Page<RemoteUserList> findByName(@Param("name")String name, Pageable pageable);
}
