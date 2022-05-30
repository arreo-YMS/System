package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.LimitStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LimitStatusRepository extends JpaRepository<LimitStatus, Long>, JpaSpecificationExecutor<LimitStatus> {

    Optional<LimitStatus> findById(Long uid);

    Page<LimitStatus> findAll(Pageable pageable);

    @Query(value="SELECT p FROM LimitStatus p WHERE p.grp_cd LIKE %:grp_cd%")
    Page<LimitStatus> findByGrpCd(@Param("grp_cd")String grp_cd, Pageable pageable);
}
