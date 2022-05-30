package com.operation.management.quaternaryDto;

import com.operation.management.quaternary.model.MMSRowData;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MMSRowDataDto {
    private String gw;
    private String msgId;
    private String smsFg;
    private String smsGb;
    private String usedCd;
    private String msgGb;
    private String grpCd;
    private String usrCd;
    private String rsrvdId;
    private String phnId;
    private String rcvPhnId;
    private String sndDt;
    private String sndOdr;
    private String sndMsg;
    private String srvFg;
    private String callBack;
    private String cmpMsgId;
    private String cmpSndD;
    private String cmptoregD;
    private String regSndD;
    private String regRcvD;
    private int rsltValue;
    private String natCd;
    private String settleCd;
    private String assignCd;
    private String mnoCd;
    private int regRsltVal;
    private String regRsltValDsc;
    private String mmsGroup;
    private int mmsSize;
    private String mmsConType;
    private String readReplyD;
    private int readReplyVal;
    private String regReportKey;
    private int rsltValDsc;
    private String authSeq;
    private String readReplyCd;
    private String copyFlag;
    private String subject;
    private String sndMsgText;

    @Builder
    public MMSRowDataDto(MMSRowData mmsRowData){
        this.gw = mmsRowData.getGw();
        this.msgId = mmsRowData.getMsgId();
        this.smsFg = mmsRowData.getSmsFg();
        this.smsGb = mmsRowData.getSmsGb();
        this.usedCd = mmsRowData.getUsedCd();
        this.msgGb = mmsRowData.getMsgGb();
        this.grpCd = mmsRowData.getGrpCd();
        this.usrCd = mmsRowData.getUsrCd();
        this.rsrvdId = mmsRowData.getRsrvdId();
        this.phnId = mmsRowData.getPhnId();
        this.rcvPhnId = mmsRowData.getRcvPhnId();
        this.sndDt = mmsRowData.getSndDt();
        this.sndOdr = mmsRowData.getSndOdr();
        this.sndMsg = mmsRowData.getSndMsg();
        this.srvFg = mmsRowData.getSrvFg();
        this.callBack = mmsRowData.getCallBack();
        this.cmpMsgId = mmsRowData.getCmpMsgId();
        this.cmpSndD = mmsRowData.getCmpSndD();
        this.cmptoregD = mmsRowData.getCmptoregD();
        this.regSndD = mmsRowData.getRegSndD();
        this.regRcvD = mmsRowData.getRegRcvD();
        this.rsltValue = mmsRowData.getRsltValue();
        this.natCd = mmsRowData.getNatCd();
        this.settleCd = mmsRowData.getSettleCd();
        this.assignCd = mmsRowData.getAssignCd();
        this.mnoCd = mmsRowData.getMnoCd();
        this.regRsltVal = mmsRowData.getRegRsltVal();
        this.regRsltValDsc = mmsRowData.getRegRsltValDsc();
        this.mmsGroup = mmsRowData.getMmsGroup();
        this.mmsSize = mmsRowData.getMmsSize();
        this.mmsConType = mmsRowData.getMmsConType();
        this.readReplyD = mmsRowData.getReadReplyD();
        this.readReplyVal = mmsRowData.getReadReplyVal();
        this.regReportKey = mmsRowData.getRegReportKey();
        this.rsltValDsc = mmsRowData.getRsltValDsc();
        this.authSeq = mmsRowData.getAuthSeq();
        this.readReplyCd = mmsRowData.getReadReplyCd();
        this.copyFlag = mmsRowData.getCopyFlag();
        this.subject = mmsRowData.getSubject();
        this.sndMsgText =mmsRowData.getSndMsgText();
    }

    public MMSRowData toEntity(){
        return MMSRowData.builder().gw(gw).msgId(msgId).smsFg(smsFg)
                                   .smsGb(smsGb).usedCd(usedCd).msgGb(msgGb)
                                   .grpCd(grpCd).usrCd(usrCd).rsrvdId(rsrvdId)
                                   .phnId(phnId).rcvPhnId(rcvPhnId).sndDt(sndDt)
                                   .sndOdr(sndOdr).sndMsg(sndMsg).srvFg(srvFg)
                                   .callBack(callBack).cmpMsgId(cmpMsgId).cmpSndD(cmpSndD)
                                   .cmptoregD(cmptoregD).regSndD(regSndD).regRcvD(regRcvD)
                                   .rsltValue(rsltValue).natCd(natCd).settleCd(settleCd)
                                   .assignCd(assignCd).mnoCd(mnoCd).regRsltVal(regRsltVal)
                                   .regRsltValDsc(regRsltValDsc).mmsGroup(mmsGroup).mmsSize(mmsSize)
                                   .mmsConType(mmsConType).readReplyD(readReplyD).readReplyVal(readReplyVal)
                                   .regReportKey(regReportKey).rsltValDsc(rsltValDsc).authSeq(authSeq)
                                   .readReplyCd(readReplyCd).copyFlag(copyFlag).subject(subject)
                                   .sndMsgText(sndMsgText)
                                   .build();
    }
    
}
