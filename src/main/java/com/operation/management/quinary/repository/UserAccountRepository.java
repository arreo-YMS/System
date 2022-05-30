package com.operation.management.quinary.repository;

import com.operation.management.quinary.model.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

    // @Query("select m from UserAccount m where EMP_ID = :EMP_ID and PASSWD = :PASSWD")
    @Query("SELECT m FROM UserAccount m WHERE EMP_ID = :EMP_ID AND PASSWD =  CASE PASSWD_TYPE WHEN 'S' THEN :PASSWD ELSE :PASSWD END")
    UserAccount findUser(@Param("EMP_ID") String EMP_ID,@Param("PASSWD") String PASSWD);
  
    // UserAccount findUser(String EMP_ID, String encPASSWD, String PASSWD);
}
