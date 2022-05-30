package com.operation.management.primaryService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.primary.model.ThresHold;
import com.operation.management.primary.repository.ThresHoldRepository;
import com.operation.management.primaryController.ThresHoldController.CreateThresHoldRequest;
import com.operation.management.primaryDto.ThresHoldDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ThresHoldService {
    @Autowired
    private ThresHoldRepository thresHoldRepository;


    // 페이징 추가
    // @Transactional
    // public Page<ThresHold> getAllThresHold(Pageable pageable){
    //     return thresHoldRepository.findAll(pageable);
    // }


    public ThresHoldDto viewThresHold(String grp_cd) throws Exception{
        Optional<ThresHold> opt = thresHoldRepository.findById(grp_cd);
        if(opt.isPresent()){
            return new ThresHoldDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스없음2");
        }
    }

    @Transactional
    public ThresHoldDto insert(ThresHoldDto model) throws Exception{
        ThresHold thresHold = thresHoldRepository.save(model.toEntity());
        return new ThresHoldDto(thresHold);
    }

    @Transactional
    public ThresHoldDto updateThresHold(CreateThresHoldRequest model, String grp_cd)throws Exception{
        ThresHoldDto viewThresHold = this.viewThresHold(grp_cd);
        viewThresHold.setGrp_nm(model.getGrp_nm());
        viewThresHold.setStart_date(model.getStart_date());
        viewThresHold.setUsed_yn(model.getUsed_yn());
        viewThresHold.setAlarm_group(model.getAlarm_group());
        viewThresHold.setLimit_price(model.getLimit_price());
        viewThresHold.setSms_price(model.getSms_price());
        viewThresHold.setLms_price(model.getLms_price());
        viewThresHold.setMms_price(model.getMms_price());
        viewThresHold.setReset_yn(model.getReset_yn());
        viewThresHold.setReset_day(model.getReset_day());
        viewThresHold.setReset_price(model.getReset_price());
        viewThresHold.setReset_dttm(model.getReset_dttm());
        ThresHold thresHold = thresHoldRepository.save(viewThresHold.toEntity());
        return new ThresHoldDto(thresHold);
    }

    public Optional<ThresHold> findById(String grp_cd) throws Exception{
        return thresHoldRepository.findById(grp_cd);
    }

    @Transactional
    public void deleteThresHold(String grp_cd) throws Exception{
        this.viewThresHold(grp_cd);
        thresHoldRepository.deleteById(grp_cd);
    }

    public List<ThresHold> getAllThresHold(){
        return thresHoldRepository.findAll();
        }


    public HashMap<String, Object> grpCdOverlap(String grp_cd){
        HashMap<String, Object> map = new HashMap<>();
    
        Optional<ThresHold> thDto = thresHoldRepository.findById(grp_cd);


        if(!thDto.toString().equals("Optional.empty")){
            map.put("result", 0);
        }else{
            map.put("result", 1);
        }

        return map;
    }


    public Page<ThresHold> findAllThresHold(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<ThresHold> thresHoldList = thresHoldRepository.findAll(pageable);
        return thresHoldList;

    }


    public Page<ThresHold> findByGrpCd(String grp_cd, Pageable pageable){

        Page<ThresHold> thresHoldSearch = thresHoldRepository.findByGrpCd(grp_cd, pageable);
        return thresHoldSearch;
    }

}
