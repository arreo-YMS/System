package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.BlockUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlockUserRepository extends JpaRepository<BlockUser, Long>, JpaSpecificationExecutor<BlockUser> {
    
    Optional<BlockUser> findById(Long id);

    @Query(value="SELECT p FROM BlockUser p WHERE p.server_user LIKE %:server_user%")
    Page<BlockUser> findByBlockId(@Param("server_user")String server_user, Pageable pageable);
    
}
