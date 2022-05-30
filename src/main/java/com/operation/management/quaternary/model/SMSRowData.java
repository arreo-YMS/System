package com.operation.management.quaternary.model;

import javax.persistence.Column;
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
public class SMSRowData {

    
    @Column(name = "GW")
    private String gw;
    @Id
    @Column(name = "MSG_ID")
    private String msgId;
    @Column(name = "CMP_MSG_ID")
    private String cmpMsgId;
    @Column(name = "SMS_FG")
    private String smsFg;
    @Column(name = "SMS_GB")
    private String smsGb;
    @Column(name = "USED_CD")
    private String usedCd;
    @Column(name = "SND_GB")
    private String sndGb;
    @Column(name = "SND_SKT_FG")
    private String sktFg;
    @Column(name = "SND_KTF_FG")
    private String ktfFg;
    @Column(name = "SND_LGT_FG")
    private String lgtFg;
    @Column(name = "GRP_CD")
    private String grpCd;
    @Column(name = "AUTH_SEQ")
    private String authSeq;
    @Column(name = "SVR_CD")
    private String svrCd;
    @Column(name = "MSG_GB")
    private String msgGb;
    @Column(name = "RSRVD_ID")
    private String rsrvdId;
    @Column(name = "PHN_ID")
    private String phnId;
    @Column(name = "RCV_PHN_ID")
    private String rcvPhnId;
    @Column(name = "CALLBACK")
    private String callBack;
    @Column(name = "SND_DT")
    private String sndDt;
    @Column(name = "SND_ODR")
    private String sndOdr;
    @Column(name = "SND_MSG")
    private String sndMsg;
    @Column(name = "CMP_SND_DTTM")
    private String cmpSndD;
    @Column(name = "CMP_RCV_DTTM")
    private String cmpRcvD;
    @Column(name = "CMP_REG_DTTM")
    private String cmpRegD;
    @Column(name = "REG_SND_DTTM")
    private String regSndD;
    @Column(name = "REG_RCV_DTTM")
    private String regRcvD;
    @Column(name = "REG_PTO_DTTM")
    private String regPtoD;
    @Column(name = "SMS_ST")
    private String smsSt;
    @Column(name = "RSLT_VAL")
    private int rsltVal;
    @Column(name = "NAT_CD")
    private String natCd;
    @Column(name = "SETTLE_CD")
    private String settleCd;
    @Column(name = "MNO_CD")
    private String mnoCd;
    @Column(name = "CID_RESULT")
    private String cidResult;
    @Column(name = "COPY_FG")
    private String copyFg;
    @Column(name = "INST_FG")
    private String instFg;


    @Builder
        public SMSRowData(String gw, String msgId, String cmpMsgId, String smsFg, String smsGb, 
        String usedCd, String sndGb, String sktFg, String ktfFg, String lgtFg, String grpCd,
        String authSeq, String svrCd,String msgGb, String rsrvdId, String phnId, String rcvPhnId, 
        String callBack, String sndDt, String sndOdr, String sndMsg, String cmpSndD, String cmpRcvD,
        String cmpRegD, String regSndD, String regRcvD, String regPtoD, String smsSt, int rsltVal,
        String natCd, String settleCd, String mnoCd, String cidResult, String copyFg, String instFg){
            this.gw = gw;
            this.msgId = msgId;
            this.cmpMsgId = cmpMsgId;
            this.smsFg = smsFg;
            this.smsGb = smsGb;
            this.usedCd = usedCd;
            this.sndGb = sndGb;
            this.sktFg = sktFg;
            this.ktfFg = ktfFg;
            this.lgtFg = lgtFg;
            this.grpCd = grpCd;
            this.authSeq = authSeq;
            this.svrCd = svrCd;
            this.msgGb = msgGb;
            this.rsrvdId = rsrvdId;
            this.phnId = phnId;
            this.rcvPhnId = rcvPhnId;
            this.callBack = callBack;
            this.sndDt = sndDt;
            this.sndOdr = sndOdr;
            this.sndMsg = sndMsg;
            this.cmpSndD = cmpSndD;
            this.cmpRcvD = cmpRcvD;
            this.cmpRegD = cmpRegD;
            this.regSndD = regSndD;
            this.regRcvD = regRcvD;
            this.regPtoD = regPtoD;
            this.smsSt = smsSt;
            this.rsltVal = rsltVal;
            this.natCd = natCd;
            this.settleCd = settleCd;
            this.mnoCd = mnoCd;
            this.cidResult = cidResult;
            this.copyFg = copyFg;
            this.instFg = instFg;
        }
   
    
}
