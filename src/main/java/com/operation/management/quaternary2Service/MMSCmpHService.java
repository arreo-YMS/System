package com.operation.management.quaternary2Service;

import com.operation.management.quaternary2.model.MMSCmpH;
import com.operation.management.quaternary2.repository.MMSCmpHRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MMSCmpHService {

    @Autowired
    MMSCmpHRepository mmsCmpHRepository;

    public Page<MMSCmpH> findAllMmsCmpHMsgId(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<MMSCmpH> smsCmpHList = mmsCmpHRepository.findAll(pageable);
        return smsCmpHList;
        
    }

    public Page<MMSCmpH> findByMmsCmpHMsgId(String MSG_ID, Pageable pageable){
        Page<MMSCmpH> smsCmpHSearch = mmsCmpHRepository.findByMMSCmpHMsgId(MSG_ID, pageable);
        return smsCmpHSearch;
    }
}
