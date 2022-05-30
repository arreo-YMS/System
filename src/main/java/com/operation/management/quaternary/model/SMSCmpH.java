package com.operation.management.quaternary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SMS_CMP_H")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SMSCmpH {
    


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
    private String CMP_RCV_DTTM;
    private String CMPTOREG_DTTM;
    private String REG_SND_DTTM;
    private String REG_RCV_DTTM;
    private Integer RSLT_VAL;
    private String NAT_CD;
    private String SETTLE_CD;
    private String RSLT_VAL_DSC;
    private String MNO_CD;
    private String AUTH_SEQ;
    private String CID_RESULT;


    @Builder
        public SMSCmpH(String MSG_ID,
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
        String CMP_RCV_DTTM,
        String CMPTOREG_DTTM,
        String REG_SND_DTTM,
        String REG_RCV_DTTM,
        Integer RSLT_VAL,
        String NAT_CD,
        String SETTLE_CD,
        String RSLT_VAL_DSC,
        String MNO_CD,
        String AUTH_SEQ,
        String CID_RESULT){
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
            this.CMP_RCV_DTTM = CMP_RCV_DTTM;
            this.CMPTOREG_DTTM = CMPTOREG_DTTM;
            this.REG_SND_DTTM = REG_SND_DTTM;
            this.REG_RCV_DTTM = REG_RCV_DTTM;
            this.RSLT_VAL = RSLT_VAL;
            this.NAT_CD = NAT_CD;
            this.SETTLE_CD = SETTLE_CD;
            this.RSLT_VAL_DSC = RSLT_VAL_DSC;
            this.MNO_CD = MNO_CD;
            this.AUTH_SEQ = AUTH_SEQ;
            this.CID_RESULT = CID_RESULT;
        }
}
