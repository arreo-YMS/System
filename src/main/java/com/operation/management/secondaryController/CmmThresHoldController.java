package com.operation.management.secondaryController;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.operation.management.secondary.model.CmmThresHold;
import com.operation.management.secondaryDto.CmmThresHoldDto;
import com.operation.management.secondaryService.CmmThresHoldService;

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
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class CmmThresHoldController {

    @Autowired
    private CmmThresHoldService cmmThresHoldService;



    // @RequestMapping("/cmmThresHold")
    // String cmmThresHoldPage(Model model){
    //     List<CmmThresHold> allCmmThresHold = cmmThresHoldService.getAllCmmThresHold();
    //     model.addAttribute("allCmmThresHold", allCmmThresHold);
    //     return "cmmThresHold/cmmThresHold.html";
    // }


    @GetMapping("/cmmThresHold")
   public String findByMbrId(@RequestParam(value="mbrId", defaultValue = "null")String mbrId, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!mbrId.equals("null")){
        Page<CmmThresHold> allCmmThresHold = cmmThresHoldService.findByMbrId(mbrId, pageable);
        model.addAttribute("allCmmThresHold", allCmmThresHold);
    }else{
        Page<CmmThresHold> allCmmThresHold = cmmThresHoldService.findAllCmmThresHold(page, 10);
        model.addAttribute("allCmmThresHold", allCmmThresHold);
    }
        model.addAttribute("cmmThresHoldSearchMbrId", mbrId);
        return "cmmThresHold/cmmThresHold.html";
   }


    


    // @RequestMapping("/cmmThresHold")
    // String cmmThresHoldPage(Model model){
    //     List<CmmThresHold> allCmmThresHold = cmmThresHoldService.getAllCmmThresHold();
    //     model.addAttribute("allCmmThresHold", allCmmThresHold);
    //     return "cmmThresHold/cmmThresHold.html";
    // }

    @GetMapping(value = "/insertCmmThres")
    public String insertCmmThresHold(){
        return "cmmThresHold/insertCmmThresHold";
    }


    @PostMapping("/insertCmmThres")
    public String insert(CmmThresHoldDto model) throws Exception{

        //추가할때 ADT_DTTM(upt)를 직접기입할 경우 아래 simpleDate주석처리
        //자동으로 현재 날짜로 insert하고 싶을경우 아래 simpleDate 주석해제
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = dateFormat.format(date);
        model.setUpt(now);
        cmmThresHoldService.insert(model);
        return "redirect:/cmmThresHold";
    }


    @GetMapping(value = "editCmmThresHold")
    public String updateCmmThresHold(String mbrId, Model model) throws Exception{
        CmmThresHold dataC = cmmThresHoldService.findById(mbrId).map(m->m).orElse(null);
        model.addAttribute("dataC", dataC);
        return "cmmThresHold/editCmmThresHold";
    }


    @PostMapping("/updateCmmThresHold/{mbrId}")
    public String updateCmmThresHold(@PathVariable("mbrId") String mbrId, CreateCmmThresHoldRequest model, @RequestParam(value="page", defaultValue="0") int page, Model model1, Pageable pageable)throws Exception{

        //수정할때 ADT_DTTM(upt)를 직접기입할 경우 아래 simpleDate주석처리
        //자동으로 현재 날짜로 insert하고 싶을경우 아래 simpleDate 주석해제
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = dateFormat.format(date);
        model.setUpt(now);

        cmmThresHoldService.updateCmmThresHold(model, mbrId);
        if(!mbrId.equals("null")){
            Page<CmmThresHold> allCmmCdauth = cmmThresHoldService.findByMbrId(mbrId, pageable);
            model1.addAttribute("allCmmCdauth", allCmmCdauth);
        }else{
            Page<CmmThresHold> allCmmCdauth = cmmThresHoldService.findAllCmmThresHold(page, 10);
            model1.addAttribute("allCmmCdauth", allCmmCdauth);
        }
            model1.addAttribute("cmmCdauthSearchMbrId", mbrId);

        return "redirect:/cmmThresHold?mbrId="+"null";
    }


    @GetMapping("/cmmThresHold/{mbrId}")
    public ResponseEntity<?> view(@PathVariable("mbrId") final String mbrId){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<CmmThresHoldDto>(cmmThresHoldService.view(mbrId), HttpStatus.OK);
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
    public static class CreateCmmThresHoldRequest{
        private int tCnt;
        private int dCnt;
        private int mCnt;
        private String delYn;
        private String upt;
        private String adtId;
    }
}
