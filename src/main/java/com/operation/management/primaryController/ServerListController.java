package com.operation.management.primaryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.operation.management.primary.model.ServerList;
import com.operation.management.primaryDto.ServerListDto;
import com.operation.management.primaryService.ServerListService;

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
public class ServerListController {

    @Autowired
    private ServerListService serverListService;

    @RequestMapping("/serverList")
    String serverListPage(Model model){
        List<ServerList> allServerList = serverListService.getAllServerList();
        model.addAttribute("allServerList", allServerList);
        return "remoteServerList/serverList.html";
    }




    @GetMapping("/serverList")
   public String findByGrpCd(@RequestParam(value="server_user", defaultValue="null")String server_user, @RequestParam(value="page", defaultValue="0") int page, Model model, Pageable pageable){

    if(!server_user.equals("null")){
        Page<ServerList> allServerList = serverListService.findByServerList(server_user, pageable);
        model.addAttribute("allServerList", allServerList);
    }else{
        Page<ServerList> allServerList = serverListService.findAllServerList(page, 10);
        model.addAttribute("allServerList", allServerList);
    }
        model.addAttribute("serverSearchId", server_user);
        return "remoteServerList/serverList.html";
   }




    @GetMapping(value = "/insertServerList")
    public String insertServerList(){
        return "remoteServerList/insertServerList";
    }


    @PostMapping("/insertServer")
    public String insert(ServerListDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setUpdate_dttm(now);
        serverListService.insert(model);
        return "redirect:/serverList";
    }


    @GetMapping(value = "editServerList")
    public String updateServerList(Long id, Model model) throws Exception{
        ServerList dataS = serverListService.findById(id).map(m->m).orElse(null);
        model.addAttribute("dataS", dataS);
        return "remoteServerList/editServerList";
    }

    @PostMapping("/updateServer/{id}")
    public String updateServerList(@PathVariable("id") Long id, CreateServerListRequest model)throws Exception{
        serverListService.updateServerList(model, id);
        return "redirect:/serverList";
    }


    @PostMapping("/listS/{id}")
    public String deleteServerList(@PathVariable("id") Long id) throws Exception{
        serverListService.delete(id);
        return "redirect:/serverList";
    }


    @GetMapping("/serverList/{id}")
    public ResponseEntity<?> view(@PathVariable("id") final long id){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<ServerListDto>(serverListService.view(id), HttpStatus.OK);
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
    public static class CreateServerListRequest{
        private String server_ip;
        private String server_user;
        private String status;
    }
    
}
