package com.operation.management.quinaryService;

import java.util.HashMap;

import com.operation.management.common.Xutil;
import com.operation.management.quinary.model.UserAccount;
import com.operation.management.quinary.repository.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuinaryUserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;


    public HashMap<String, Object> getUser(String EMP_ID, String PASSWD) throws Exception{

        String enc_PASSWD = Xutil.encryptSHA256Emp(PASSWD);

        HashMap<String, Object> map = new HashMap<>();

        UserAccount userAccount = userAccountRepository.findUser(EMP_ID, PASSWD);

        if(userAccount != null){
            map.put("userVO", userAccount);

            return map;
        }else{
            userAccount = userAccountRepository.findUser(EMP_ID, enc_PASSWD);

            map.put("userVO", userAccount);
            
            return map;
        }

        // if(userAccount != null){
        //     map.put("userVO", userAccount);
        // }else{
        //     map.put("userVO", userAccount);
        // }
    }
}
