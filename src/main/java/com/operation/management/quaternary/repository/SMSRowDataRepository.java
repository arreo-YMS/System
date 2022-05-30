package com.operation.management.quaternary.repository;

import java.util.Optional;

import com.operation.management.quaternary.model.SMSRowData;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SMSRowDataRepository extends JpaRepository<SMSRowData, String>, JpaSpecificationExecutor<SMSRowData> {
    Optional<SMSRowData> findById(String msgId);

    Page<SMSRowData> findAll(Pageable pageable);
    

    @Query(value="SELECT p FROM SMSRowData p WHERE p.msgId LIKE %:msgId%")
    Page<SMSRowData> findBySmsRowDataMsgId(@Param("msgId")String msgId, Pageable pageable);
}
