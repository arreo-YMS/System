package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.ServerList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServerListRepository extends JpaRepository<ServerList, Long>, JpaSpecificationExecutor<ServerList>{
    
    Optional<ServerList> findById(Long id);

    @Query(value="SELECT p FROM ServerList p WHERE p.server_user LIKE %:server_user%")
    Page<ServerList> findByServerList(@Param("server_user")String server_user, Pageable pageable);
    
}
