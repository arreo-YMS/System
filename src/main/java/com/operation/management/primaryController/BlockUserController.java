package com.operation.management.primaryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.operation.management.primary.model.BlockUser;
import com.operation.management.primaryDto.BlockUserDto;
import com.operation.management.primaryService.BlockUserService;

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
public class BlockUserController {

    @Autowired
    private BlockUserService blockUserService;

    @RequestMapping("/blockUser")
    String blockUserPage(Model model){
        List<BlockUser> allBlockUser = blockUserService.getAllBlockUser();
        model.addAttribute("allBlockUser", allBlockUser);
        return "remoteBlockUser/blockUser.html";
    }




    @GetMapping("/blockUser")
   public String findByGrpCd(@RequestParam(value="server_user", defaultValue="null")String server_user, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!server_user.equals("null")){
        Page<BlockUser> allBlockUser = blockUserService.findByBlockId(server_user, pageable);
        model.addAttribute("allBlockUser", allBlockUser);
    }else{
        Page<BlockUser> allBlockUser = blockUserService.findAllBlockUser(page, 10);
        model.addAttribute("allBlockUser", allBlockUser);
    }
        model.addAttribute("blockSearchId", server_user);
       return "remoteBlockUser/blockUser.html";
   }





    @GetMapping(value = "/insertBlockUser")
    public String insertBlockUser(){
        return "remoteBlockUser/insertBlockUser";
    }
    

    @PostMapping("/insertBlock")
    public String insert(BlockUserDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setCreate_dttm(now);
        blockUserService.insert(model);
        return "redirect:/blockUser";
    }


    @GetMapping(value = "editBlockUser")
    public String updateBlockUser(Long id, Model model) throws Exception{
        BlockUser dataB = blockUserService.findById(id).map(m->m).orElse(null);
        model.addAttribute("dataB", dataB);
        return "remoteBlockUser/editBlockUser";
    }


    @PostMapping("/updateBlockUser/{id}")
    public String updateBlockUser(@PathVariable("id") Long id, CreateBlockUserRequest model)throws Exception{
        blockUserService.updateBlockUser(model, id);
        return "redirect:/blockUser";
    }


    @PostMapping("/listB/{id}")
    public String deleteBlockUser(@PathVariable("id") Long id) throws Exception{
        blockUserService.delete(id);
        return "redirect:/blockUser";
    }


    @GetMapping("/blockUser/{id}")
    public ResponseEntity<?> view(@PathVariable("id") final long id){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<BlockUserDto>(blockUserService.view(id), HttpStatus.OK);
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
    public static class CreateBlockUserRequest{
        private String server_ip;
        private String server_user;
    }
}
