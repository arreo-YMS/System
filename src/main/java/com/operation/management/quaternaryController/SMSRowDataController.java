package com.operation.management.quaternaryController;


import com.operation.management.quaternary.model.SMSRowData;
import com.operation.management.quaternaryDto.SMSRowDataDto;
import com.operation.management.quaternaryService.SMSRowDataService;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SMSRowDataController {

    @Autowired
    private SMSRowDataService smsRowDataService;

    // @GetMapping(value = "/smsRowData")
    // String smsRowdata(Model model) {
    //     List<SMSRowData> allSMSRowdata = smsRowDataService.getAllSMSRowData();
    //     model.addAttribute("allSMSRowdata", allSMSRowdata);
    //     return "rowData/smsRowData";
    // }


    @GetMapping("/smsRowData")
   public String findBySmsRowDataMsgId(@RequestParam(value="msgId", defaultValue="null")String msgId, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!msgId.equals("null")){
        Page<SMSRowData> allSMSRowdata = smsRowDataService.findBySmsRowDataMsgId(msgId, pageable);
        model.addAttribute("allSMSRowdata", allSMSRowdata);
    }else{
        Page<SMSRowData> allSMSRowdata = smsRowDataService.findAllSmsRowDataMsgId(page, 10);
        model.addAttribute("allSMSRowdata", allSMSRowdata);
    }
        model.addAttribute("smsRowDataSearchId", msgId);
        return "rowData/smsRowData.html";
   }



 

    @GetMapping("/smsRowData/{msgId}")
    public ResponseEntity<?> view(@PathVariable("msgId") final String msgId){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<SMSRowDataDto>(smsRowDataService.view(msgId), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }
    
}
