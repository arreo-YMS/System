package com.operation.management.primaryController;

import java.util.List;

import com.operation.management.primary.model.RemoteUserList;
import com.operation.management.primaryDto.RemoteUserListDto;
import com.operation.management.primaryService.RemoteUserListService;

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
public class RemoteUserListController {

    @Autowired
    private RemoteUserListService userListService;

    @RequestMapping("/remoteUserList")
    String blockUserPage(Model model){
        List<RemoteUserList> allUserList = userListService.getAllUserList();
        model.addAttribute("allUserList", allUserList);
        return "remoteUserList/remoteUserList.html";
    }



    @GetMapping("/remoteUserList")
   public String findByName(@RequestParam(value="name", defaultValue = "null")String name, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!name.equals("null")){
        Page<RemoteUserList> allUserList = userListService.findByName(name, pageable);
        model.addAttribute("allUserList", allUserList);
    }else{
        Page<RemoteUserList> allUserList = userListService.findAllRemoteUserList(page, 10);
        model.addAttribute("allUserList", allUserList);
    }
        model.addAttribute("remoteUserSearchName", name);
        return "remoteUserList/remoteUserList.html";
   }




    @GetMapping(value = "/insertUserList")
    public String insertUserList(){
        return "remoteUserList/insertRemoteUserList";
    }


    @PostMapping("/insertUser")
    public String insert(RemoteUserListDto model) throws Exception{
        userListService.insert(model);
        return "redirect:/remoteUserList";
    }


    @GetMapping(value = "editUserList")
    public String updateUserList(Long id, Model model) throws Exception{
        RemoteUserList dataU = userListService.findById(id).map(m->m).orElse(null);
        model.addAttribute("dataU", dataU);
        return "remoteUserList/editRemoteUserList";
    }


    @PostMapping("/updateUserList/{id}")
    public String updateUserList(@PathVariable("id") Long id, CreateUserListRequest model, String name, @RequestParam(value="page", defaultValue="0") int page, Model model1, Pageable pageable)throws Exception{
        userListService.updateUserList(model, id);

        if(!name.equals("null")){
            Page<RemoteUserList> allUserList = userListService.findByName(name, pageable);
            model1.addAttribute("allUserList", allUserList);
        }else{
            Page<RemoteUserList> allUserList = userListService.findAllRemoteUserList(page, 10);
            model1.addAttribute("allUserList", allUserList);
        }
            model1.addAttribute("remoteUserSearchName", name);
            return "redirect:/remoteUserList?name="+"null";
       }
    


    @PostMapping("/listU/{id}")
    public String deleteUserList(@PathVariable("id") Long id) throws Exception{
        userListService.delete(id);
        return "redirect:/remoteUserList";
    }


    @GetMapping("/userList/{id}")
    public ResponseEntity<?> view(@PathVariable("id") final long id){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<RemoteUserListDto>(userListService.view(id), HttpStatus.OK);
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
    public static class CreateUserListRequest{
        private String name;
        private String email;
        private String phn_id;
        private String used_yn;
        private String type;
        private String server_user;
        private String server_ip; 
    }
    
}
