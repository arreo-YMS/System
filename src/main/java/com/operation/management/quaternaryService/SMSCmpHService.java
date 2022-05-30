package com.operation.management.quaternaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.operation.management.quaternary.model.SMSCmpH;
import com.operation.management.quaternary.repository.SMSCmpHRepository;
import com.operation.management.quaternaryDto.SMSCmpHDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class SMSCmpHService {

    @Autowired
    SMSCmpHRepository smsCmpHRepository;

    public SMSCmpHDto view(String MSG_ID) throws Exception{
        Optional<SMSCmpH> opt = smsCmpHRepository.findById(MSG_ID);
        if(opt.isPresent()){
            return new SMSCmpHDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스없음");
        }
    }

    public List<SMSCmpH> getAllSMSCmpH(){
        return smsCmpHRepository.findAll();
    }

    public Slice<SMSCmpH> findAllSmsCmpHMsgId(int page, int size, String MSG_ID){
        Pageable pageable = PageRequest.of(page, size);
        Slice<SMSCmpH> smsCmpHList = smsCmpHRepository.findAll(MSG_ID, pageable);
        return smsCmpHList;
        
    }


    public Page<SMSCmpH> findBySmsCmpHMsgId(String MSG_ID, Pageable pageable){
        Page<SMSCmpH> smsCmpHSearch = smsCmpHRepository.findBySMSCmpHMsgId(MSG_ID, pageable);
        return smsCmpHSearch;
    }



    
}
