package com.operation.management.quaternaryDto;

import com.operation.management.quaternary.model.SMSCmpH;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SMSCmpHDto {
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
    public SMSCmpHDto(SMSCmpH smsCmpH){
        this.MSG_ID = smsCmpH.getMSG_ID();
        this.SMS_FG = smsCmpH.getSMS_FG();
        this.SMS_GB = smsCmpH.getSMS_GB();
        this.USED_CD = smsCmpH.getUSED_CD();
        this.MSG_GB = smsCmpH.getMSG_GB();
        this.GRP_CD = smsCmpH.getGRP_CD();
        this.USR_CD = smsCmpH.getUSR_CD();
        this.RSRVD_ID = smsCmpH.getRSRVD_ID();
        this.PHN_ID = smsCmpH.getPHN_ID();
        this.RCV_PHN_ID = smsCmpH.getRCV_PHN_ID();
        this.SND_DT = smsCmpH.getSND_DT();
        this.SND_ODR = smsCmpH.getSND_ODR();
        this.SND_MSG = smsCmpH.getSND_MSG();
        this.SRV_FG = smsCmpH.getSRV_FG();
        this.CALLBACK = smsCmpH.getCALLBACK();
        this.CMP_MSG_ID = smsCmpH.getCMP_MSG_ID();
        this.CMP_SND_DTTM = smsCmpH.getCMP_SND_DTTM();
        this.CMP_RCV_DTTM = smsCmpH.getCMP_RCV_DTTM();
        this.CMPTOREG_DTTM = smsCmpH.getCMPTOREG_DTTM();
        this.REG_SND_DTTM = smsCmpH.getREG_SND_DTTM();
        this.REG_RCV_DTTM = smsCmpH.getREG_RCV_DTTM();
        this.RSLT_VAL = smsCmpH.getRSLT_VAL();
        this.NAT_CD = smsCmpH.getNAT_CD();
        this.SETTLE_CD = smsCmpH.getSETTLE_CD();
        this.RSLT_VAL_DSC = smsCmpH.getRSLT_VAL_DSC();
        this.MNO_CD = smsCmpH.getMNO_CD();
        this.AUTH_SEQ = smsCmpH.getAUTH_SEQ();
        this.CID_RESULT = smsCmpH.getCID_RESULT();
    }

    public SMSCmpH toEntity(){
        return SMSCmpH.builder()
                    .MSG_ID(MSG_ID).SMS_FG(SMS_FG)
                    .SMS_GB(SMS_GB).USED_CD(USED_CD)
                    .MSG_GB(MSG_GB).GRP_CD(GRP_CD)
                    .USR_CD(USR_CD).RSRVD_ID(RSRVD_ID)
                    .PHN_ID(PHN_ID).RCV_PHN_ID(RCV_PHN_ID)
                    .SND_DT(SND_DT).SND_ODR(SND_ODR)
                    .SND_MSG(SND_MSG).SRV_FG(SRV_FG)
                    .CALLBACK(CALLBACK).CMP_MSG_ID(CMP_MSG_ID)
                    .CMP_SND_DTTM(CMP_SND_DTTM).CMP_RCV_DTTM(CMP_RCV_DTTM)
                    .CMPTOREG_DTTM(CMPTOREG_DTTM).REG_SND_DTTM(REG_SND_DTTM)
                    .REG_RCV_DTTM(REG_RCV_DTTM).RSLT_VAL(RSLT_VAL)
                    .NAT_CD(NAT_CD).SETTLE_CD(SETTLE_CD)
                    .RSLT_VAL_DSC(RSLT_VAL_DSC).MNO_CD(MNO_CD)
                    .AUTH_SEQ(AUTH_SEQ).CID_RESULT(CID_RESULT)
                    .build();
    }
    
}
