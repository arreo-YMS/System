package com.operation.management.secondary.repository;

import java.util.Optional;

import com.operation.management.secondary.model.CmmThresHold;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CmmThresHoldRepository extends JpaRepository<CmmThresHold, String> {
    
    Optional<CmmThresHold> findById(String mbrId);

    @Query(value="SELECT p FROM CmmThresHold p WHERE p.mbrId LIKE %:mbrId%")
    Page<CmmThresHold> findByMbrId(@Param("mbrId")String mbrId, Pageable pageable);
}
