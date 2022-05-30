package com.operation.management.tertiaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.tertiary.model.CmmCdauth;
import com.operation.management.tertiary.repository.CmmCdauthRepository;
import com.operation.management.tertiaryController.CmmCdauthController.CreateCmmCdauthRequest;
import com.operation.management.tertiaryDto.CmmCdauthDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CmmCdauthService {

    @Autowired
    private CmmCdauthRepository cmmCdauthRepository;

    public CmmCdauthDto view(String mbrId) throws Exception{
        Optional<CmmCdauth> opt = cmmCdauthRepository.findById(mbrId);
        if(opt.isPresent()){
            return new CmmCdauthDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }

    public CmmCdauthDto insert(CmmCdauthDto model) throws Exception{
        CmmCdauth cmmCdauth = cmmCdauthRepository.save(model.toEntity());
        return new CmmCdauthDto(cmmCdauth);
    }


    @Transactional
    public CmmCdauthDto updateCmmCdauth(CreateCmmCdauthRequest model, String mbrId) throws Exception{
        CmmCdauthDto view = this.view(mbrId);
        view.setAuthSeq(model.getAuthSeq());
        view.setMbrIp(model.getMbrIp());
        view.setMbrPort(model.getMbrPort());
        view.setSpdpsec(model.getSpdpsec());
        view.setMaxLimitRate(model.getMaxLimitRate());
        view.setRmk(model.getRmk());
        view.setDelYn(model.getDelYn());
        view.setRegUsr(model.getRegUsr());
        view.setRegDttm(model.getRegDttm());
        view.setUptUsr(model.getUptUsr());
        view.setUptDttm(model.getUptDttm());
        view.setMbrLevel(model.getMbrLevel());
        view.setSpamFg(model.getSpamFg());
        view.setMbrIp2(model.getMbrIp2());
        view.setClient_version(model.getClient_version());
        view.setOpChgFg(model.getOpChgFg());
        view.setSmtFg(model.getSmtFg());
        view.setAlarmType(model.getAlarmType());
        view.setPrivateLineFg(model.getPrivateLineFg());
        view.setCallBlockFg(model.getCallBlockFg());
        view.setBlock60Fg(model.getBlock60Fg());
        view.setUpdateUser(model.getUpdateUser());
        view.setUpdateDate(model.getUpdateDate());
        view.setAuthSecretData(model.getAuthSecretData());
        view.setAuthCredentialData(model.getAuthCredentialData());
        CmmCdauth cmmCdauth = cmmCdauthRepository.save(view.toEntity());
        return new CmmCdauthDto(cmmCdauth);

    }


    public Optional<CmmCdauth> findById(String mbrId) throws Exception{
        return cmmCdauthRepository.findById(mbrId);
    }


    public List<CmmCdauth> getAllCmmCdauth(){
        return cmmCdauthRepository.findAll();
    }

    public Page<CmmCdauth> findAllCmmCdauth(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<CmmCdauth> cDauthList = cmmCdauthRepository.findAll(pageable);
        return cDauthList;

    }
    


    public Page<CmmCdauth> findByMbrId(String mbrId, Pageable pageable){
        Page<CmmCdauth> cDauthSearch = cmmCdauthRepository.findByMbrId(mbrId, pageable);
        return cDauthSearch;
    }
    
}
