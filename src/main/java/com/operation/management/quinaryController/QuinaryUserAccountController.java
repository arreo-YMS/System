package com.operation.management.quinaryController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.operation.management.quinary.model.UserAccount;
import com.operation.management.quinary.repository.UserAccountRepository;
import com.operation.management.quinaryService.QuinaryUserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class QuinaryUserAccountController {
    @Autowired
    private UserAccountRepository user;

    @Autowired
    private QuinaryUserAccountService quinaryUserAccountService;

    public QuinaryUserAccountController(UserAccountRepository user){
        this.user = user;
    }

    @GetMapping("/")
    public String login(){
        return "login/login";
    }


    @PostMapping("/login")
    @ResponseBody
    public HashMap<String, Object> loginTest(@RequestParam(name = "EMP_ID")String EMP_ID, @RequestParam(name = "PASSWD")String PASSWD, HttpSession httpSession) throws Exception{

        HashMap<String, Object> map = new HashMap<>();

        //평문으로 들어온 PWD로 유저 조회
        map = quinaryUserAccountService.getUser(EMP_ID, PASSWD);


        UserAccount userAccount = (UserAccount)map.get("userVO");

        if(userAccount != null){
            httpSession.setAttribute("userVO", userAccount);


            return map;
        }else{
            httpSession.setAttribute("userVO", userAccount);

            map.put("msg", "ID또는 비밀번호가 일치하지않습니다.");

            return map;
        }
        

        
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null){
            httpSession.invalidate();
        }
        return "redirect:/";
    }
}
