package com.operation.management.quaternaryDto;

import com.operation.management.quaternary.model.SMSRowData;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SMSRowDataDto {
    private String gw;
    private String msgId;
    private String cmpMsgId;
    private String smsFg;
    private String smsGb;
    private String usedCd;
    private String sndGb;
    private String sktFg;
    private String ktfFg;
    private String lgtFg;
    private String grpCd;
    private String authSeq;
    private String svrCd;
    private String msgGb;
    private String rsrvdId;
    private String phnId;
    private String rcvPhnId;
    private String callBack;
    private String sndDt;
    private String sndOdr;
    private String sndMsg;
    private String cmpSndD;
    private String cmpRcvD;
    private String cmpRegD;
    private String regSndD;
    private String regRcvD;
    private String regPtoD;
    private String smsSt;
    private int rsltVal;
    private String natCd;
    private String settleCd;
    private String mnoCd;
    private String cidResult;
    private String copyFg;
    private String instFg;

    @Builder
    public SMSRowDataDto(SMSRowData smsRowData){
            this.gw = smsRowData.getGw();
            this.msgId = smsRowData.getMsgId();
            this.cmpMsgId = smsRowData.getCmpMsgId();
            this.smsFg = smsRowData.getSmsFg();
            this.smsGb = smsRowData.getSmsGb();
            this.usedCd = smsRowData.getUsedCd();
            this.sndGb = smsRowData.getSndGb();
            this.sktFg = smsRowData.getSktFg();
            this.ktfFg = smsRowData.getKtfFg();
            this.lgtFg = smsRowData.getLgtFg();
            this.grpCd = smsRowData.getGrpCd();
            this.authSeq = smsRowData.getAuthSeq();
            this.svrCd = smsRowData.getSvrCd();
            this.msgGb = smsRowData.getMsgGb();
            this.rsrvdId = smsRowData.getRsrvdId();
            this.phnId = smsRowData.getPhnId();
            this.rcvPhnId = smsRowData.getRcvPhnId();
            this.callBack = smsRowData.getCallBack();
            this.sndDt = smsRowData.getSndDt();
            this.sndOdr = smsRowData.getSndOdr();
            this.sndMsg = smsRowData.getSndMsg();
            this.cmpSndD = smsRowData.getCmpSndD();
            this.cmpRcvD = smsRowData.getCmpRcvD();
            this.cmpRegD = smsRowData.getCmpRegD();
            this.regSndD = smsRowData.getRegSndD();
            this.regRcvD = smsRowData.getRegRcvD();
            this.regPtoD = smsRowData.getRegPtoD();
            this.smsSt = smsRowData.getSmsSt();
            this.rsltVal = smsRowData.getRsltVal();
            this.natCd = smsRowData.getNatCd();
            this.settleCd = smsRowData.getSettleCd();
            this.mnoCd = smsRowData.getMnoCd();
            this.cidResult = smsRowData.getCidResult();
            this.copyFg = smsRowData.getCopyFg();
            this.instFg = smsRowData.getInstFg();
    }

    public SMSRowData toEntity(){
        return SMSRowData.builder()
                         .gw(gw).msgId(msgId).cmpMsgId(cmpMsgId)
                         .smsFg(smsFg).smsGb(smsGb).usedCd(usedCd)
                         .sndGb(sndGb).sktFg(sktFg).ktfFg(ktfFg)
                         .lgtFg(lgtFg).grpCd(grpCd).authSeq(authSeq)
                         .svrCd(svrCd).msgGb(msgGb).rsrvdId(rsrvdId)
                         .phnId(phnId).rcvPhnId(rcvPhnId).callBack(callBack)
                         .sndDt(sndDt).sndOdr(sndOdr).sndMsg(sndMsg)
                         .cmpSndD(cmpSndD).cmpRcvD(cmpRcvD).cmpRegD(cmpRegD)
                         .regSndD(regSndD).regRcvD(regRcvD).regPtoD(regPtoD)
                         .smsSt(smsSt).rsltVal(rsltVal).natCd(natCd)
                         .settleCd(settleCd).mnoCd(mnoCd).cidResult(cidResult)
                         .copyFg(copyFg).instFg(instFg).build();
    }
    
}
