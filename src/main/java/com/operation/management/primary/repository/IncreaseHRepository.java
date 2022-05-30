package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.IncreaseH;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IncreaseHRepository extends JpaRepository<IncreaseH, Long>, JpaSpecificationExecutor<IncreaseH>{

    Optional<IncreaseH> findById(Long uid);
    
    Page<IncreaseH> findAll(Pageable pageable);

    @Query(value="SELECT p FROM IncreaseH p WHERE p.grp_cd LIKE %:grp_cd%")
    Page<IncreaseH> findByGrpCd(@Param("grp_cd")String grp_cd, Pageable pageable);
}
