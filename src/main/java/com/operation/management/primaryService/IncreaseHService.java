package com.operation.management.primaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.primary.model.IncreaseH;
import com.operation.management.primary.repository.IncreaseHRepository;
import com.operation.management.primaryController.IncreaseHController.CreateMemberRequest;
import com.operation.management.primaryDto.IncreaseHDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IncreaseHService {
    @Autowired
    private IncreaseHRepository increaseHRepository;


    public IncreaseHDto view(Long uid) throws Exception{
        Optional<IncreaseH> opt = increaseHRepository.findById(uid);
        if(opt.isPresent()){
            return new IncreaseHDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }

    @Transactional
    public IncreaseHDto insert(IncreaseHDto model1) throws Exception{
        IncreaseH increaseH = increaseHRepository.save(model1.toEntity());
        return new IncreaseHDto(increaseH);
    }

    
    @Transactional
    public IncreaseHDto update(CreateMemberRequest model, long uid) throws Exception{
        IncreaseHDto view = this.view(uid);
        view.setStatus(model.getStatus());
        view.setLimit_price(model.getLimit_price());
        view.setSms_price(model.getSms_price());
        view.setLms_price(model.getLms_price());
        view.setMms_price(model.getMms_price());
        IncreaseH increaseH = increaseHRepository.save(view.toEntity());
        return new IncreaseHDto(increaseH);
    }


    public Optional<IncreaseH> findById(Long uid) throws Exception{
        return increaseHRepository.findById(uid);
    }


    @Transactional
    public void delete(long uid) throws Exception{
        this.view(uid);
            increaseHRepository.deleteById(uid);
    }


    // public List<IncreaseH> getALLUsers() {
    //     return increaseHRepository.findAll();
    // }

    public List<IncreaseH> getALLUsers(){
        return increaseHRepository.findAll(Sort.by(Sort.Direction.DESC, "uid"));
    }


    public Page<IncreaseH> findAllIncreaseH(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<IncreaseH> increaseHList = increaseHRepository.findAll(pageable);
        return increaseHList;

    }


    public Page<IncreaseH> findByGrpCd(String grp_cd, Pageable pageable){

        Page<IncreaseH> increaseHSearch = increaseHRepository.findByGrpCd(grp_cd, pageable);
        return increaseHSearch;
    }

}
