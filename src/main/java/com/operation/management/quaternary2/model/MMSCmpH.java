package com.operation.management.quaternary2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MMS_CMP_H")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString


public class MMSCmpH {

    @Id
    private String MSG_ID;
    private String SMS_FG;
    private String SMS_GB;
    private String USED_CD;
    private String MSG_GB;
    private String GRP_CD;
    private String USR_CD;
    private String RSRVD_ID;
    private String PHN_ID;
    private String RCV_PHN_ID;
    private String SND_DT;
    private String SND_ODR;
    private String SND_MSG;
    private String SRV_FG;
    private String CALLBACK;
    private String CMP_MSG_ID;
    private String CMP_SND_DTTM;
    private String CMPTOREG_DTTM;
    private String REG_SND_DTTM;
    private String REG_RCV_DTTM;
    private Integer RSLT_VAL;
    private String NAT_CD;
    private String SETTLE_CD;
    private String ASSIGN_CD;
    private String MNO_CD;
    private Integer REG_RSLT_VAL;
    private String REG_RSLT_VAL_DSC;
    private String MMS_GROUP;
    private String MMS_SIZE;
    private String MMS_CON_TYPE;
    private String READ_REPLY_DTTM;
    private Integer READ_REPLY_VAL;
    private String REG_REPORT_KEY;
    private String RSLT_VAL_DSC;
    private String AUTH_SEQ;
    private String READ_REPLY_CD;
    private String SUBJECT;
    private String SND_MSG_TEXT;
    private Integer TEXT_SIZE;


    @Builder
        public MMSCmpH(String MSG_ID,
        String SMS_FG,
        String SMS_GB,
        String USED_CD,
        String MSG_GB,
        String GRP_CD,
        String USR_CD,
        String RSRVD_ID,
        String PHN_ID,
        String RCV_PHN_ID,
        String SND_DT,
        String SND_ODR,
        String SND_MSG,
        String SRV_FG,
        String CALLBACK,
        String CMP_MSG_ID,
        String CMP_SND_DTTM,
        String CMPTOREG_DTTM,
        String REG_SND_DTTM,
        String REG_RCV_DTTM,
        Integer RSLT_VAL,
        String NAT_CD,
        String SETTLE_CD,
        String ASSIGN_CD,
        String MNO_CD,
        Integer REG_RSLT_VAL,
        String REG_RSLT_VAL_DSC,
        String MMS_GROUP,
        String MMS_SIZE,
        String MMS_CON_TYPE,
        String READ_REPLY_DTTM,
        Integer READ_REPLY_VAL,
        String REG_REPORT_KEY,
        String RSLT_VAL_DSC,
        String AUTH_SEQ,
        String READ_REPLY_CD,
        String SUBJECT,
        String SND_MSG_TEXT,
        Integer TEXT_SIZE){
            this.MSG_ID = MSG_ID;
            this.SMS_FG = SMS_FG;
            this.SMS_GB = SMS_GB;
            this.USED_CD = USED_CD;
            this.MSG_GB = MSG_GB;
            this.GRP_CD = GRP_CD;
            this.USR_CD = USR_CD;
            this.RSRVD_ID = RSRVD_ID;
            this.PHN_ID = PHN_ID;
            this.RCV_PHN_ID = RCV_PHN_ID;
            this.SND_DT = SND_DT;
            this.SND_ODR = SND_ODR;
            this.SND_MSG = SND_MSG;
            this.SRV_FG = SRV_FG;
            this.CALLBACK = CALLBACK;
            this.CMP_MSG_ID = CMP_MSG_ID;
            this.CMP_SND_DTTM =CMP_SND_DTTM ;
            this.CMPTOREG_DTTM = CMPTOREG_DTTM;
            this.REG_SND_DTTM = REG_SND_DTTM;
            this.REG_RCV_DTTM = REG_RCV_DTTM;
            this.RSLT_VAL = RSLT_VAL;
            this.NAT_CD = NAT_CD;
            this.SETTLE_CD = SETTLE_CD;
            this.ASSIGN_CD = ASSIGN_CD;
            this.MNO_CD = MNO_CD;
            this.REG_RSLT_VAL = REG_RSLT_VAL;
            this.REG_RSLT_VAL_DSC = REG_RSLT_VAL_DSC;
            this.MMS_GROUP = MMS_GROUP;
            this.MMS_SIZE = MMS_SIZE; 
            this.MMS_CON_TYPE = MMS_CON_TYPE;
            this.READ_REPLY_DTTM = READ_REPLY_DTTM;
            this.READ_REPLY_VAL = READ_REPLY_VAL;
            this.REG_REPORT_KEY = REG_REPORT_KEY;
            this.RSLT_VAL_DSC = RSLT_VAL_DSC;
            this.AUTH_SEQ = AUTH_SEQ;
            this.READ_REPLY_CD = READ_REPLY_CD;
            this.SUBJECT = SUBJECT;
            this.SND_MSG_TEXT = SND_MSG_TEXT;
            this.TEXT_SIZE = TEXT_SIZE;
        }

    
}
