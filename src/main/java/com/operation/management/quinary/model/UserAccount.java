package com.operation.management.quinary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "ARREO_EMP")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccount {

    @Id
    private String EMP_ID;
    private String PASSWD;
    private String INFO_PASSWD;
    private String EMP_NM;
    private String RESI_NO;
    private String RESI_NO_YN;
    private String SEX_GB;
    private String EMP_EMAIL;
    private String BIRTH_DT;
    private String LUN_GB;
    private String MARRY_DT;
    private String MARRY_GB;
    private String ZIP_CD;
    private String ADDR;
    private String HOME_TEL; 
    private String HAND_TEL;
    private String PRVLG_GB;     
    private String DEPT_CD1;
    private String DEPT_CD2;
    private String TITLE_CD1;
    private String TITLE_CD2;
    private String EMP_IP;
    private String SMALL_TEL;
    private String REG_USR;
    private String REG_DTTM;
    private String UPT_USR;
    private String UPT_DTTM;
    private String DEL_YN;
    private String RSRVD_ID;
    private String NOTI_YN;
    private String AIWS_DEPT_IDX;   
    private String AIWS_POS_IDX;  
    private String AIWS_MENU_IDX;   
    private String AIWS_AUTH_IDX;   
    private String DEL_DTTM;
    private int DISP_SEQ;
    private String CEF_SEQ;
    private String EMP_PART;
    private String CARD_ID;
    private String DISP_YN;
    private String INCOME_DT;
    private String WORK_JIKMU_GBN;
    private String EMP_TYPE;
    private String SMALL1_TEL;
    private String COMP_ID;
    private String EXPIRE_DT;
    private String EXPIRE_GUBUN;  
    private String ARREO_PHN_ID; 
    private String VALID_YN;
    private int EMP_NO;
    private String ALIAS_NM;
    private String PASSWD_TYPE; 
    private String REG_STAT;
    private String AIWS_ROLE_IDX;


    @Builder
        public UserAccount(String EMP_ID, String PASSWD, String INFO_PASSWD, String EMP_NM,
                           String RESI_NO, String RESI_NO_YN, String SEX_GB, String EMP_EMAIL, 
                           String BIRTH_DT, String LUN_GB, String MARRY_DT, String MARRY_GB, 
                           String ZIP_CD, String ADDR, String HOME_TEL, String HAND_TEL, 
                           String PRVLG_GB, String DEPT_CD1, String DEPT_CD2, String TITLE_CD1, 
                           String TITLE_CD2, String EMP_IP, String SMALL_TEL, String REG_USR, 
                           String REG_DTTM, String UPT_USR, String UPT_DTTM, String DEL_YN, 
                           String RSRVD_ID, String NOTI_YN, String AIWS_DEPT_IDX, String AIWS_POS_IDX, 
                           String AIWS_MENU_IDX, String AIWS_AUTH_IDX, String DEL_DTTM, int DISP_SEQ, 
                           String CEF_SEQ, String EMP_PART, String CARD_ID, String DISP_YN,
                           String INCOME_DT, String WORK_JIKMU_GBN, String EMP_TYPE, 
                           String SMALL1_TEL, String COMP_ID, String EXPIRE_DT, String EXPIRE_GUBUN, 
                           String ARREO_PHN_ID , String VALID_YN, int EMP_NO, String ALIAS_NM, 
                           String PASSWD_TYPE, String REG_STAT, String AIWS_ROLE_IDX){
                                this.EMP_ID = EMP_ID;
                                this.PASSWD = PASSWD;
                                this.INFO_PASSWD = INFO_PASSWD;
                                this.EMP_NM = EMP_NM;
                                this.RESI_NO = RESI_NO;
                                this.RESI_NO_YN = RESI_NO_YN;
                                this.SEX_GB = SEX_GB;
                                this.EMP_EMAIL = EMP_EMAIL;
                                this.BIRTH_DT = BIRTH_DT;
                                this.LUN_GB = LUN_GB;
                                this.MARRY_DT = MARRY_DT;
                                this.MARRY_GB = MARRY_GB;
                                this.ZIP_CD = ZIP_CD;
                                this.ADDR = ADDR;
                                this.HOME_TEL = HOME_TEL;
                                this.HAND_TEL = HAND_TEL;
                                this.PRVLG_GB = PRVLG_GB;
                                this.DEPT_CD1 = DEPT_CD1;
                                this.DEPT_CD2 = DEPT_CD2;
                                this.TITLE_CD1 = TITLE_CD1;
                                this.TITLE_CD2 = TITLE_CD2;
                                this.EMP_IP = EMP_IP;
                                this.SMALL_TEL = SMALL_TEL;
                                this.REG_USR = REG_USR;
                                this.REG_DTTM = REG_DTTM;
                                this.UPT_USR = UPT_USR;
                                this.UPT_DTTM = UPT_DTTM;
                                this.DEL_YN = DEL_YN;
                                this.RSRVD_ID = RSRVD_ID;
                                this.NOTI_YN = NOTI_YN;
                                this.AIWS_DEPT_IDX = AIWS_DEPT_IDX;
                                this.AIWS_POS_IDX = AIWS_POS_IDX;
                                this.AIWS_MENU_IDX = AIWS_MENU_IDX;
                                this.AIWS_AUTH_IDX = AIWS_AUTH_IDX;
                                this.DEL_DTTM = DEL_DTTM;
                                this.DISP_SEQ = DISP_SEQ;
                                this.CEF_SEQ = CEF_SEQ;
                                this.EMP_PART = EMP_PART;
                                this.CARD_ID = CARD_ID;
                                this.DISP_YN = DISP_YN;
                                this.INCOME_DT = INCOME_DT;
                                this.WORK_JIKMU_GBN = WORK_JIKMU_GBN;
                                this.EMP_TYPE = EMP_TYPE;
                                this.SMALL1_TEL = SMALL1_TEL;
                                this.COMP_ID = COMP_ID;
                                this.EXPIRE_DT = EXPIRE_DT;
                                this.EXPIRE_GUBUN = EXPIRE_GUBUN;
                                this.ARREO_PHN_ID = ARREO_PHN_ID;
                                this.VALID_YN = VALID_YN;
                                this.EMP_NO = EMP_NO;
                                this.ALIAS_NM = ALIAS_NM;
                                this.PASSWD_TYPE = PASSWD_TYPE;
                                this.REG_STAT = REG_STAT;
                                this.AIWS_ROLE_IDX = AIWS_ROLE_IDX;
                           }



}
