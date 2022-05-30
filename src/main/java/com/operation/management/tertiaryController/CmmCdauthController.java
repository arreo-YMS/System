package com.operation.management.tertiaryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.operation.management.tertiary.model.CmmCdauth;
import com.operation.management.tertiaryDto.CmmCdauthDto;
import com.operation.management.tertiaryService.CmmCdauthService;

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
public class CmmCdauthController {

    @Autowired
    private CmmCdauthService cmmCdauthService;



// 원래쓰던ㄱ거
    @RequestMapping("/cmmCdauth")
    String cmmCdauth(Model model){
        List<CmmCdauth> allCmmCdauth = cmmCdauthService.getAllCmmCdauth();
        model.addAttribute("allCmmCdauth", allCmmCdauth);
        return "cmmCdauth/cmmCdauth.html";
    }

    // @RequestMapping("cmmCdauth")
    // public String cmmCdauth(Model model, Pageable pageable){
    //     model.addAttribute("allCmmCdauth", cmmCdauthService.findAllCmmCdauth(pageable));
    //     Page<CmmCdauth> allCmmCdauth = cmmCdauthService.findAllCmmCdauth(pageable);

    //     log.debug("총 element 수 : {}, 전체 page 수 : {}, 페이지에 표시할 element 수 : {}, 현재 페이지 index : {}, 현재 페이지의 element 수 : {}",
    //     allCmmCdauth.getTotalElements(), allCmmCdauth.getTotalPages(), allCmmCdauth.getSize(),
    //     allCmmCdauth.getNumber(), allCmmCdauth.getNumberOfElements());
    //     return "cmmCdauth/cmmCdauth.html";
    // }
    

    // @GetMapping("/cmmCdauth")
    // public String findAllCmmCdauth(@RequestParam(value="page", defaultValue="0")int page, Model model){
    //     Page<CmmCdauth> allCmmCdauth = cmmCdauthService.findAllCmmCdauth(page, 10);
    //     model.addAttribute("allCmmCdauth", allCmmCdauth);



    //     return "cmmCdauth/cmmCdauth.html";
    // }
    

 




    //검색 1차
   @GetMapping("/cmmCdauth")
   public String findByMbrId(@RequestParam(value="mbrId", defaultValue = "null")String mbrId, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!mbrId.equals("null")){
        Page<CmmCdauth> allCmmCdauth = cmmCdauthService.findByMbrId(mbrId, pageable);
        model.addAttribute("allCmmCdauth", allCmmCdauth);
    }else{
        Page<CmmCdauth> allCmmCdauth = cmmCdauthService.findAllCmmCdauth(page, 10);
        model.addAttribute("allCmmCdauth", allCmmCdauth);
    }
        model.addAttribute("cmmCdauthSearchMbrId", mbrId);
       return "cmmCdauth/cmmCdauth.html";
   }
    

   

//추가한거
    // @GetMapping("/cmmCdauth")
    // String cmmCdauth(Model model){
    //     Page<CmmCdauth> allCmmCdauth = cmmCdauthService.getAllCmmCdauth(PageRequest PageRequest, @RequestParam("page") Integer page, @RequestParam("size")Integer size);
    //     PageRequest pageRequest = PageRequest.of(page, size);
    //     model.addAttribute("allCmmCdauth", allCmmCdauth);
    //     return "cmmCdauth/cmmCdauth.html";
    
    // }



    @GetMapping(value = "editCmmCdauth")
    public String updateCmmCdauth(String mbrId, Model model) throws Exception{
        CmmCdauth dataCmm = cmmCdauthService.findById(mbrId).map(m->m).orElse(null);
        model.addAttribute("dataCmm", dataCmm);
        return "cmmCdauth/editCmmCdauth";
    }


    @PostMapping("/updateCmmCdauth/{mbrId}")
    public String updateCmmCdauth(@PathVariable("mbrId") String mbrId, CreateCmmCdauthRequest model, @RequestParam(value="page", defaultValue="0") int page, Model model1, Pageable pageable)throws Exception{
        

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = dateFormat.format(date);

        model.setUptDttm(now);
        model.setUpdateDate(now);

        cmmCdauthService.updateCmmCdauth(model, mbrId);
        if(!mbrId.equals("null")){
            Page<CmmCdauth> allCmmCdauth = cmmCdauthService.findByMbrId(mbrId, pageable);
            model1.addAttribute("allCmmCdauth", allCmmCdauth);
        }else{
            Page<CmmCdauth> allCmmCdauth = cmmCdauthService.findAllCmmCdauth(page, 10);
            model1.addAttribute("allCmmCdauth", allCmmCdauth);
        }
            model1.addAttribute("cmmCdauthSearchMbrId", mbrId);

        return "redirect:/cmmCdauth";
    }


    @GetMapping("/cmmCdauth/{mbrId}")
    public ResponseEntity<?> view(@PathVariable("mbrId") final String mbrId){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<CmmCdauthDto>(cmmCdauthService.view(mbrId), HttpStatus.OK);
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
    public static class CreateCmmCdauthRequest{
        private String authSeq;
        private String mbrIp;
        private String mbrPort;
        private int spdpsec;
        private int maxLimitRate;
        private String rmk;
        private String delYn;
        private String regUsr;
        private String regDttm;
        private String uptUsr;
        private String uptDttm;
        private int mbrLevel;
        private String spamFg;
        private String mbrIp2;
        private String client_version;;
        private String opChgFg;
        private String smtFg;
        private String alarmType;
        private String privateLineFg;
        private String callBlockFg;
        private String block60Fg;
        private String updateUser;
        private String updateDate;
        private String authSecretData;
        private String authCredentialData;
    }
}
