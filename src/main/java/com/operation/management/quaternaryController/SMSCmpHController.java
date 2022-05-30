package com.operation.management.quaternaryController;

import com.operation.management.quaternary.model.SMSCmpH;
import com.operation.management.quaternaryDto.SMSCmpHDto;
import com.operation.management.quaternaryService.SMSCmpHService;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SMSCmpHController {

    @Autowired
    private SMSCmpHService smsCmpHService;

    @GetMapping("/smsCmpH")
   public String findBySmsRowDataMsgId(@RequestParam(value="MSG_ID", defaultValue="null")String MSG_ID, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!MSG_ID.equals("null")){
        Page<SMSCmpH> allSMSCmpH = smsCmpHService.findBySmsCmpHMsgId(MSG_ID, pageable);
        model.addAttribute("allSMSCmpH", allSMSCmpH);
    }else{
        Slice<SMSCmpH> allSMSCmpH = smsCmpHService.findAllSmsCmpHMsgId(page, 10, MSG_ID);
        model.addAttribute("allSMSCmpH", allSMSCmpH);
    }
        model.addAttribute("smsCmpHSearchId", MSG_ID);
        return "rowData/smsCmpH.html";
   }


   @GetMapping("/smsCmpH/{MSG_ID}")
    public ResponseEntity<?> view(@PathVariable("MSG_ID") final String MSG_ID){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<SMSCmpHDto>(smsCmpHService.view(MSG_ID), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }
    
}
