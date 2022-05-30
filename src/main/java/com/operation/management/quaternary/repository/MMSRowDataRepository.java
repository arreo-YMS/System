package com.operation.management.quaternary.repository;

import java.util.Optional;

import com.operation.management.quaternary.model.MMSRowData;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MMSRowDataRepository extends JpaRepository<MMSRowData, String>, JpaSpecificationExecutor<MMSRowData> {
    Optional<MMSRowData> findById(String msgId);

    Page<MMSRowData> findAll(Pageable pageable);

    @Query(value="SELECT p FROM MMSRowData p WHERE p.msgId LIKE %:msgId%")
    Page<MMSRowData> findByMmsRowDataMsgId(@Param("msgId")String msgId, Pageable pageable);
    
}
