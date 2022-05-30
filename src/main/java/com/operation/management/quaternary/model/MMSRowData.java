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
@Table(name = "MMS_CMP_H")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MMSRowData {

    @Id
    @Column(name = "GW")
    private String gw;
    @Column(name = "MSG_ID")
    private String msgId;
    @Column(name = "SMS_FG")
    private String smsFg;
    @Column(name = "SMS_GB")
    private String smsGb;
    @Column(name = "USED_CD")
    private String usedCd;
    @Column(name = "MSG_GB")
    private String msgGb;
    @Column(name = "GRP_CD")
    private String grpCd;
    @Column(name = "USR_CD")
    private String usrCd;
    @Column(name = "RSRVD_ID")
    private String rsrvdId;
    @Column(name = "PHN_ID")
    private String phnId;
    @Column(name = "RCV_PHN_ID")
    private String rcvPhnId;
    @Column(name = "SND_DT")
    private String sndDt;
    @Column(name = "SND_ODR")
    private String sndOdr;
    @Column(name = "SND_MSG")
    private String sndMsg;
    @Column(name = "SRV_FG")
    private String srvFg;
    @Column(name = "CALLBACK")
    private String callBack;
    @Column(name = "CMP_MSG_ID")
    private String cmpMsgId;
    @Column(name = "CMP_SND_DTTM")
    private String cmpSndD;
    @Column(name = "CMPTOREG_DTTM")
    private String cmptoregD;
    @Column(name = "REG_SND_DTTM")
    private String regSndD;
    @Column(name = "REG_RCV_DTTM")
    private String regRcvD;
    @Column(name = "RSLT_VAL")
    private int rsltValue;
    @Column(name = "NAT_CD")
    private String natCd;
    @Column(name = "SETTLE_CD")
    private String settleCd;
    @Column(name = "ASSIGN_CD")
    private String assignCd;
    @Column(name = "MNO_CD")
    private String mnoCd;
    @Column(name = "REG_RSLT_VAL")
    private int regRsltVal;
    @Column(name = "REG_RSLT_VAL_DSC")
    private String regRsltValDsc;
    @Column(name = "MMS_GROUP")
    private String mmsGroup;
    @Column(name = "MMS_SIZE")
    private int mmsSize;
    @Column(name = "MMS_CON_TYPE")
    private String mmsConType;
    @Column(name = "READ_REPLY_DTTM")
    private String readReplyD;
    @Column(name = "READ_REPLY_VAL")
    private int readReplyVal;
    @Column(name = "REG_REPORT_KEY")
    private String regReportKey;
    @Column(name = "RSLT_VAL_DSC")
    private int rsltValDsc;
    @Column(name = "AUTH_SEQ")
    private String authSeq;
    @Column(name = "READ_REPLY_CD")
    private String readReplyCd;
    @Column(name = "COPY_FLAG")
    private String copyFlag;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "SND_MSG_TEXT")
    private String sndMsgText;


    @Builder
    public MMSRowData(String gw, String msgId, String smsFg,String smsGb, String usedCd,
    String msgGb, String grpCd, String usrCd, String rsrvdId, String phnId, String rcvPhnId,
    String sndDt, String sndOdr, String sndMsg, String srvFg, String callBack,
    String cmpMsgId, String cmpSndD, String cmptoregD, String regSndD, String regRcvD, int rsltValue,
    String natCd, String settleCd, String assignCd, String mnoCd, int regRsltVal,
    String regRsltValDsc, String mmsGroup, int mmsSize, String mmsConType, String readReplyD, 
    int readReplyVal, String regReportKey, int rsltValDsc, String authSeq, String readReplyCd, 
    String copyFlag, String subject, String sndMsgText){
        this.gw = gw;
        this.msgId = msgId;
        this.smsFg = smsFg;
        this.smsGb = smsGb;
        this.usedCd = usedCd;
        this.msgGb = msgGb;
        this.grpCd = grpCd;
        this.usrCd = usrCd;
        this.rsrvdId = rsrvdId;
        this.phnId = phnId;
        this.rcvPhnId = rcvPhnId;
        this.sndDt = sndDt;
        this.sndOdr = sndOdr;
        this.sndMsg = sndMsg;
        this.srvFg = srvFg;
        this.callBack = callBack;
        this.cmpMsgId = cmpMsgId;
        this.cmpSndD = cmpSndD;
        this.cmptoregD = cmptoregD;
        this.regSndD = regSndD;
        this.regRcvD = regRcvD;
        this.rsltValue = rsltValue;
        this.natCd =natCd;
        this.settleCd = settleCd;
        this.assignCd = assignCd;
        this.mnoCd = mnoCd;
        this.regRsltVal = regRsltVal;
        this.regRsltValDsc = regRsltValDsc;
        this.mmsGroup = mmsGroup;
        this.mmsSize = mmsSize;
        this.mmsConType = mmsConType;
        this.readReplyD = readReplyD;
        this.readReplyVal = readReplyVal;
        this.regReportKey = regReportKey;
        this.rsltValDsc = rsltValDsc;
        this.authSeq = authSeq;
        this.readReplyCd = readReplyCd;
        this.copyFlag = copyFlag;
        this.subject = subject;
        this.sndMsgText = sndMsgText;
    }
    
}
