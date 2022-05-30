package com.operation.management.quaternaryController;


import com.operation.management.quaternary.model.MMSRowData;
import com.operation.management.quaternaryDto.MMSRowDataDto;
import com.operation.management.quaternaryService.MMSRowDataService;

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
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MMSRowDataContoller {

    @Autowired
    private MMSRowDataService mmsRowDataService;


    // @GetMapping(value = "/mmsRowData")
    // String smsRowdata(Model model) {
    //     List<MMSRowData> allMMSRowdata = mmsRowDataService.getAllMMSRowData();
    //     model.addAttribute("allMMSRowdata", allMMSRowdata);
    //     return "rowData/mmsRowData";
        
    // }


    @GetMapping("/mmsRowData")
    public String findByMmsRowDataMsgId(@RequestParam(value="msgId", defaultValue="null")String msgId, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!msgId.equals("null")){
        Page<MMSRowData> allMMSRowdata = mmsRowDataService.findByMmsRowDataMsgId(msgId, pageable);
        model.addAttribute("allMMSRowdata", allMMSRowdata);
    }else{
        Page<MMSRowData> allMMSRowdata = mmsRowDataService.findAllMmsRowDataMsgId(page, 10);
        model.addAttribute("allMMSRowdata", allMMSRowdata);
    }
        model.addAttribute("smsRowDataSearchId", msgId);
        return "rowData/mmsRowData.html";
   }

    @GetMapping("/mmsRowData/{msgId}")
    public ResponseEntity<?> view(@PathVariable("msgid") final String msgId){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<MMSRowDataDto>(mmsRowDataService.view(msgId), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }
    
}
