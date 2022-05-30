package com.operation.management.primaryController;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.operation.management.common.GetSort;
import com.operation.management.primary.model.IncreaseH;
import com.operation.management.primary.repository.IncreaseHRepository;
import com.operation.management.primaryDto.IncreaseHDto;
import com.operation.management.primaryService.IncreaseHService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class IncreaseHController {

    @Autowired
    private IncreaseHService increaseHService;

    @Autowired
    private IncreaseHRepository increaseHRepository;




    @GetMapping("/increaseH")
   public String findByGrpCd(@RequestParam(value="grp_cd", defaultValue="null")String grp_cd, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!grp_cd.equals("null")){
        Page<IncreaseH> allUsers = increaseHService.findByGrpCd(grp_cd, pageable);
        model.addAttribute("allUsers", allUsers);
    }else{
        Page<IncreaseH> allUsers = increaseHService.findAllIncreaseH(page, 10);
        model.addAttribute("allUsers", allUsers);
    }
        model.addAttribute("increaseHSearchgrpcd", grp_cd);
       return "countHistory/increaseH.html";
   }
    



    //     //추가한거페이징
    // @GetMapping("/increaseH")
    // public String indexPage(Model model, @PageableDefault(size = 10, sort = "uid", direction = Sort.Direction.DESC) Pageable pageable){
    //     Page<IncreaseH> allUsers = increaseHService.getAllUsers(pageable);
    //     model.addAttribute("allUsers", allUsers);
    //     return "countHistory/increaseH.html";
    // }



    // @RequestMapping("/increaseH")
    // String indexPage(Model model){
    //     List<IncreaseH> allUsers = increaseHService.getALLUsers();
    //     model.addAttribute("allUsers", allUsers);
    //     return "countHistory/increaseH.html";
    // }

    @RequestMapping(value="/getincreaseH", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String ,Object> indexPage(@RequestParam HashMap<String, Object> map){
        ArrayList<IncreaseH> ary = new ArrayList<>();

        PageRequest pageRequest = PageRequest.of(Integer.valueOf((String)map.get("page")), Integer.valueOf((String)map.get("size")), GetSort.getSort((String) map.get("sortColumn"), (String) map.get("order")));

        Iterator<IncreaseH> it = increaseHRepository.findAll(pageRequest).iterator();

        while(it.hasNext()){
            IncreaseH key = it.next();
            ary.add(key);
        }
        map.put("IncreaseH", ary);
        return map;
    }

    
    // @RequestMapping("/")
    // public String list(Model model){
    //     return "/index";
    // }


    @GetMapping(value = "/insertIncreaseH")
    public String insertIncreaseH() {
        return "countHistory/insertIncreaseH";
    }


    @PostMapping("/insert")
    public String insert(IncreaseHDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setCreate_dttm(now);
        increaseHService.insert(model);
        return "redirect:/increaseH";
    }


    @GetMapping(value = "/editIncreaseH")
    public String updateIncrease(Long uid, Model model) throws Exception{
       IncreaseH data = increaseHService.findById(uid).map(m->m).orElse(null);
        model.addAttribute("data", data);
        return "countHistory/editIncreaseH";
        
    }


    @PostMapping("/update/{uid}")
    public String update(@PathVariable("uid") Long uid, CreateMemberRequest model) throws Exception{
        increaseHService.update(model, uid);
        return "redirect:/increaseH";
    }


    @PostMapping("/list/{uid}")
    public String delete(@PathVariable("uid") Long uid) throws Exception{
        increaseHService.delete(uid);
        return "redirect:/increaseH";
    }

    
    @GetMapping("/{uid}")
    public ResponseEntity<?> view(@PathVariable("uid") final long uid){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<IncreaseHDto>(increaseHService.view(uid), HttpStatus.OK);
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
    public static class CreateMemberRequest {
        private String status;
        private String limit_price;
        private Float sms_price;
        private Float lms_price;
        private Float mms_price;
   
    }
}
