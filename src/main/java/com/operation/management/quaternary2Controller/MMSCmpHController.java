package com.operation.management.quaternary2Controller;

import com.operation.management.quaternary2.model.MMSCmpH;
import com.operation.management.quaternary2Service.MMSCmpHService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MMSCmpHController {
    @Autowired
    private MMSCmpHService mmsCmpHService;
    
    @GetMapping("/mmsCmpH")
   public String findByMmsRowDataMsgId(@RequestParam(value="MSG_ID", defaultValue="null")String MSG_ID, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!MSG_ID.equals("null")){
        Page<MMSCmpH> allMMSCmpH = mmsCmpHService.findByMmsCmpHMsgId(MSG_ID, pageable);
        model.addAttribute("allMMSCmpH", allMMSCmpH);
    }else{
        Page<MMSCmpH> allMMSCmpH = mmsCmpHService.findAllMmsCmpHMsgId(page, 10);
        model.addAttribute("allMMSCmpH", allMMSCmpH);
    }
        model.addAttribute("mmsCmpHSearchId", MSG_ID);
        return "rowData/mmsCmpH.html";
   }
}
