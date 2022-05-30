package com.operation.management.primaryService;


import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.primary.model.RemoteStatus;
import com.operation.management.primary.repository.RemoteStatusRepository;
import com.operation.management.primaryController.RemoteStatusController.CreateRemoteStatusRequest;
import com.operation.management.primaryDto.RemoteStatusDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RemoteStatusService {

    @Autowired
    private RemoteStatusRepository remoteStatusRepository;

    public RemoteStatusDto view(Long key) throws Exception{
        Optional<RemoteStatus> opt = remoteStatusRepository.findById(key);
        if(opt.isPresent()){
            return new RemoteStatusDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public RemoteStatusDto insert(RemoteStatusDto model) throws Exception{
        RemoteStatus remoteStatus = remoteStatusRepository.save(model.toEntity());
        return new RemoteStatusDto(remoteStatus);
    }


    @Transactional
    public RemoteStatusDto updateRemoteStatus(CreateRemoteStatusRequest model, long key) throws Exception{
        RemoteStatusDto view = this.view(key);
        view.setEmail(model.getEmail());
        view.setStatus(model.getStatus());
        view.setServer_ip(model.getServer_ip());
        view.setServer_user(model.getServer_user());
        view.setReason(model.getReason());
        view.setPhn_id(model.getPhn_id());
        view.setAlarm_type(model.getAlarm_type());
        RemoteStatus remoteStatus = remoteStatusRepository.save(view.toEntity());
        return new RemoteStatusDto(remoteStatus);

    }


    public Optional<RemoteStatus> findById(Long key) throws Exception{
        return remoteStatusRepository.findById(key);
    }


    @Transactional
    public void delete(long key) throws Exception{
        this.view(key);
        remoteStatusRepository.deleteById(key);
    }


    public List<RemoteStatus> getAllRemoteStatus(){
        return remoteStatusRepository.findAll();
    }
    

    public Page<RemoteStatus> findAllRemoteStatus(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<RemoteStatus> remoteStatusList = remoteStatusRepository.findAll(pageable);
        return remoteStatusList;

    }


    public Page<RemoteStatus> findByName(String name, Pageable pageable){

        Page<RemoteStatus> remoteStatusSearch = remoteStatusRepository.findByName(name, pageable);
        return remoteStatusSearch;
    }
}
