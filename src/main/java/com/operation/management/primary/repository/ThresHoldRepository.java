package com.operation.management.primary.repository;


import com.operation.management.primary.model.ThresHold;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ThresHoldRepository extends JpaRepository<ThresHold, String>, JpaSpecificationExecutor<ThresHold> {

    
    Page<ThresHold> findAll(Pageable pageable);

    @Query(value="SELECT p FROM ThresHold p WHERE p.grp_cd LIKE %:grp_cd%")
    Page<ThresHold> findByGrpCd(@Param("grp_cd")String grp_cd, Pageable pageable);
}
