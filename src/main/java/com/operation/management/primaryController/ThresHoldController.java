package com.operation.management.primaryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.operation.management.primary.model.ThresHold;
import com.operation.management.primaryDto.IncreaseHDto;
import com.operation.management.primaryDto.ThresHoldDto;
import com.operation.management.primaryService.IncreaseHService;
import com.operation.management.primaryService.ThresHoldService;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class ThresHoldController {

    @Autowired
    private ThresHoldService thresHoldService;

    @Autowired
    private IncreaseHService increaseHService;


    @GetMapping("/thresHold")
   public String findByGrpCd(@RequestParam(value="grp_cd", defaultValue = "null")String grp_cd, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!grp_cd.equals("null")){
        Page<ThresHold> allThresHold = thresHoldService.findByGrpCd(grp_cd, pageable);
        model.addAttribute("allThresHold", allThresHold);
    }else{
        Page<ThresHold> allThresHold = thresHoldService.findAllThresHold(page, 10);
        model.addAttribute("allThresHold", allThresHold);
    }
        model.addAttribute("thresHoldSearchGrpCd", grp_cd);
       return "countThresHold/thresHold.html";
   }


    @RequestMapping("/thresHold")
    String thresHoldPage(Model model){
        List<ThresHold> allThresHold = thresHoldService.getAllThresHold();
        model.addAttribute("allThresHold", allThresHold);
        return "countThresHold/thresHold.html";
    }


    @GetMapping(value = "/insertThresHold")
    public String insertThresHold(){
        return "countThresHold/insertThresHold";
    }

    @PostMapping("/insertThres")
    public String insert(ThresHoldDto model) throws Exception{
        thresHoldService.insert(model);

        IncreaseHDto model1 = new IncreaseHDto();
        model1.setGrp_cd(model.getGrp_cd());
        model1.setStatus(model.getUsed_yn());
        model1.setStart_date(model.getStart_date());
        model1.setLimit_price(model.getLimit_price());
        model1.setSms_price(model.getSms_price());
        model1.setLms_price(model.getLms_price());
        model1.setMms_price(model.getMms_price());
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        
        model1.setCreate_dttm(now);

        increaseHService.insert(model1);
        

        return "redirect:/thresHold";
    }


    @GetMapping(value = "/editThresHold")
    public String updateThresHold(String grp_cd, Model model) throws Exception{
        ThresHold dataT = thresHoldService.findById(grp_cd).map(m->m).orElse(null);
        model.addAttribute("dataT", dataT);
        return "countThresHold/editThresHold";
    }


    @PostMapping("/updateThresHold/{grp_cd}")
    public String updateThresHold(@PathVariable("grp_cd") String grp_cd, CreateThresHoldRequest model, @RequestParam("plusAry") String plusAry, @RequestParam("empNm") String empNm, @RequestParam(value="page", defaultValue="0") int page, Model model2, Pageable pageable) throws Exception{
        thresHoldService.updateThresHold(model, grp_cd);
        
        IncreaseHDto model1 = new IncreaseHDto();
        String[] stack = plusAry.split(",");
        String[] empNmStack = empNm.split(",");

        for (int i = 0; i < empNmStack.length; i++) {
            model1.setRmk(empNmStack[i]);
            
        }



        for (int i = 0; i < stack.length; i++) {

            model1.setGrp_cd(model.getGrp_cd());
            model1.setStatus(model.getUsed_yn());
            model1.setStart_date(model.getStart_date());
            
            model1.setLimit_price(stack[i]);

            model1.setSms_price(model.getSms_price());
            model1.setLms_price(model.getLms_price());
            model1.setMms_price(model.getMms_price());

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = dateFormat.parse(dateFormat.format(date));
            
            model1.setCreate_dttm(now);

            increaseHService.insert(model1);
        }
        thresHoldService.updateThresHold(model, grp_cd);
        if(!grp_cd.equals("null")){
            Page<ThresHold> allThresHold = thresHoldService.findByGrpCd(grp_cd, pageable);
            model2.addAttribute("allCmmCdauth", allThresHold);
        }else{
            Page<ThresHold> allThresHold = thresHoldService.findAllThresHold(page, 10);
            model2.addAttribute("allThresHold", allThresHold);
        }
            model2.addAttribute("thresHoldSearchGrpCd", grp_cd);

        return "redirect:/thresHold";
    }

    @PostMapping("/listT/{grp_cd}")
    public String deleteThresHold(@PathVariable("grp_cd") String grp_cd) throws Exception{
        thresHoldService.deleteThresHold(grp_cd);
        return "redirect:/thresHold";
    }


    @GetMapping("/{grp_cd}")
    public ResponseEntity<?> viewThresHold(@PathVariable("grp_cd") final String grp_cd){
        ResponseEntity<?> entity = null;
        try{
            entity = new ResponseEntity<ThresHoldDto>(thresHoldService.viewThresHold(grp_cd), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }
    @ResponseBody
    @RequestMapping(value = "/idCheck.do", method = {RequestMethod.GET})
    public HashMap<String, Object> idChk(String grp_cd)throws Exception{
        HashMap<String, Object> map = thresHoldService.grpCdOverlap(grp_cd);

        return map;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateThresHoldRequest {
        private String grp_cd;
        private String grp_nm;
        private String start_date;
        private String used_yn;
        private String limit_price;
        private float sms_price;
        private float lms_price;
        private float mms_price;
        private String alarm_group;
        private String reset_yn;
        private String reset_day;
        private String reset_price;
        private String reset_dttm;
    }
    
}
