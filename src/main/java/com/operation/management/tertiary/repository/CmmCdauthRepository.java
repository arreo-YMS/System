package com.operation.management.tertiary.repository;


import java.util.Optional;

import com.operation.management.tertiary.model.CmmCdauth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CmmCdauthRepository extends JpaRepository<CmmCdauth, String>, JpaSpecificationExecutor<CmmCdauth>{
    Optional<CmmCdauth> findById(String mbrId);

//추가한거
    // Page<CmmCdauth> findByMbrId(Pageable pageable);

    Page<CmmCdauth> findAll(Pageable pageable);


    @Query(value="SELECT p FROM CmmCdauth p WHERE p.mbrId LIKE %:mbrId%")
    Page<CmmCdauth> findByMbrId(@Param("mbrId")String mbrId, Pageable pageable);



}
