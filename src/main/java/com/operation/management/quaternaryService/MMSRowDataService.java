package com.operation.management.quaternaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.operation.management.quaternary.model.MMSRowData;
import com.operation.management.quaternary.repository.MMSRowDataRepository;
import com.operation.management.quaternaryDto.MMSRowDataDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MMSRowDataService {

    @Autowired
    private MMSRowDataRepository mmsRowDataRepository;

    public MMSRowDataDto view(String msgId) throws Exception{
        Optional<MMSRowData> opt = mmsRowDataRepository.findById(msgId);
        if(opt.isPresent()){
            return new MMSRowDataDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public List<MMSRowData> getAllMMSRowData(){
        return mmsRowDataRepository.findAll();
    }
    

    public Page<MMSRowData> findAllMmsRowDataMsgId(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<MMSRowData> mmsRowDataList = mmsRowDataRepository.findAll(pageable);
        return mmsRowDataList;

    }


    public Page<MMSRowData> findByMmsRowDataMsgId(String msgId, Pageable pageable){

        Page<MMSRowData> mmsRowDataSearch = mmsRowDataRepository.findByMmsRowDataMsgId(msgId, pageable);
        return mmsRowDataSearch;
    }
}
