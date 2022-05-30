package com.operation.management.quaternary2.repository;

import com.operation.management.quaternary2.model.MMSCmpH;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MMSCmpHRepository extends JpaRepository<MMSCmpH, String>, JpaSpecificationExecutor<MMSCmpH>{
    Page<MMSCmpH> findAll(Pageable pageable);

    @Query(value="SELECT p FROM MMSCmpH p WHERE p.MSG_ID LIKE %:MSG_ID%")
    Page<MMSCmpH> findByMMSCmpHMsgId(@Param("MSG_ID")String MSG_ID, Pageable pageable);
    
}
