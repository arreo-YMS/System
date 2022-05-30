package com.operation.management.primaryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.operation.management.primary.model.RemoteStatus;
import com.operation.management.primaryDto.RemoteStatusDto;
import com.operation.management.primaryService.RemoteStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class RemoteStatusController {

    @Autowired
    private RemoteStatusService remoteStatusService;

    @RequestMapping("/remoteStatus")
    String remoteStatusPage(Model model){
        List<RemoteStatus> allRemoteStatus = remoteStatusService.getAllRemoteStatus();
        model.addAttribute("allRemoteStatus", allRemoteStatus);
        return "remoteStatus/remoteStatus.html";
    }



    @GetMapping("/remoteStatus")
   public String findByName(@RequestParam(value="name", defaultValue="null")String name, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!name.equals("null")){
        Page<RemoteStatus> allRemoteStatus = remoteStatusService.findByName(name, pageable);
        model.addAttribute("allRemoteStatus", allRemoteStatus);
    }else{
        Page<RemoteStatus> allRemoteStatus = remoteStatusService.findAllRemoteStatus(page, 10);
        model.addAttribute("allRemoteStatus", allRemoteStatus);
    }
        model.addAttribute("serverSearchId", name);
        return "remoteStatus/remoteStatus.html";
   }




    @GetMapping(value = "/insertRemoteStatus")
    public String insertRemoteStatus(){
        return "remoteStatus/insertRemoteStatus";
    }


    @PostMapping("/insertRStatus")
    public String insert(RemoteStatusDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setCreate_dttm(now);
        model.setUpdate_dttm(now);
        remoteStatusService.insert(model);
        return "redirect:/remoteStatus";
    }


    @GetMapping(value = "/editRemoteStatus")
    public String updateRemoteStatus(Long key, Model model) throws Exception{
        RemoteStatus dataRS = remoteStatusService.findById(key).map(m->m).orElse(null);
        model.addAttribute("dataRS", dataRS);
        return "remoteStatus/editRemoteStatus";
    }


    @PostMapping("/updateRemoteStatus/{key}")
    public String updateRemoteStatus(@PathVariable("key") Long key, CreateRemoteStatusRequest model)throws Exception{
        remoteStatusService.updateRemoteStatus(model, key);
        return "redirect:/remoteStatus";
    }


    @PostMapping("/listRS/{key}")
    public String deleteRemoteStatus(@PathVariable("key") Long key) throws Exception{
        remoteStatusService.delete(key);
        return "redirect:/remoteStatus";
    }


    @GetMapping("/remoteStatus/{key}")
    public ResponseEntity<?> view(@PathVariable("key") final long key){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<RemoteStatusDto>(remoteStatusService.view(key), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRemoteStatusRequest{
    private String email;
    private String status;
    private String server_ip;
    private String server_user;
    private String reason;
    private String start_time;
    private String end_time;
    private String create_ip;
    private String update_admin;
    private String phn_id;
    private String alarm_type;

    }
}
