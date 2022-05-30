package com.operation.management.quaternary.repository;

import com.operation.management.quaternary.model.SMSCmpH;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SMSCmpHRepository extends JpaRepository<SMSCmpH, String>, JpaSpecificationExecutor<SMSCmpH>{
    
    @Query(value="SELECT p FROM SMSCmpH p WHERE ROWNUM <= 100")
    Slice<SMSCmpH> findAll(String MSG_ID, Pageable pageable);
  
    @Query(value="SELECT p FROM SMSCmpH p WHERE p.MSG_ID LIKE :MSG_ID%")
    Page<SMSCmpH> findBySMSCmpHMsgId(@Param("MSG_ID")String MSG_ID, Pageable pageable);
    
}
