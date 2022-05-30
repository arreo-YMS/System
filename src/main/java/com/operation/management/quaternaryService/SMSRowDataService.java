package com.operation.management.quaternaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.operation.management.quaternary.model.SMSRowData;
import com.operation.management.quaternary.repository.SMSRowDataRepository;
import com.operation.management.quaternaryDto.SMSRowDataDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SMSRowDataService {

    @Autowired
    private SMSRowDataRepository smsRowDataRepository;

    public SMSRowDataDto view(String msgId) throws Exception{
        Optional<SMSRowData> opt = smsRowDataRepository.findById(msgId);
        if(opt.isPresent()){
            return new SMSRowDataDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }

    public List<SMSRowData> getAllSMSRowData(){
        return smsRowDataRepository.findAll();
    }




    public Page<SMSRowData> findAllSmsRowDataMsgId(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<SMSRowData> smsRowDataList = smsRowDataRepository.findAll(pageable);
        return smsRowDataList;

    }


    public Page<SMSRowData> findBySmsRowDataMsgId(String msgId, Pageable pageable){

        Page<SMSRowData> smsRowDataSearch = smsRowDataRepository.findBySmsRowDataMsgId(msgId, pageable);
        return smsRowDataSearch;
    }

    
}
