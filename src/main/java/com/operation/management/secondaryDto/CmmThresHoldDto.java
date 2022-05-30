package com.operation.management.secondaryDto;


import com.operation.management.secondary.model.CmmThresHold;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CmmThresHoldDto {
    
    private String mbrId;
    private String msgType;
    private String grpCd;
    @Builder.Default private int tCnt = 2147483647;
    @Builder.Default private int dCnt = 2147483647;
    @Builder.Default private int mCnt = 2147483647;
    @Builder.Default private String delYn = "N";
    private String upt;
    private String adtId;
    @Builder.Default private int aCnt = 2147483647;
    @Builder.Default String aReset = "N";
    @Builder.Default private String limitMode = "T";

    
    public CmmThresHoldDto(CmmThresHold cmmThresHold){
        this.mbrId = cmmThresHold.getMbrId();
        this.msgType = cmmThresHold.getMsgType();
        this.grpCd = cmmThresHold.getGrpCd();
        this.tCnt = cmmThresHold.getTCnt();
        this.dCnt = cmmThresHold.getDCnt();
        this.mCnt = cmmThresHold.getMCnt();
        this.delYn = cmmThresHold.getDelYn();
        this.upt = cmmThresHold.getUpt();
        this.adtId = cmmThresHold.getAdtId();
        this.aCnt = cmmThresHold.getACnt();
        this.aReset = cmmThresHold.getAReset();
        this.limitMode = cmmThresHold.getLimitMode();
    }

    public CmmThresHold toEntity(){
        return CmmThresHold.builder()
                            .mbrId(mbrId)
                            .msgType(msgType)
                            .grpCd(grpCd)
                            .tCnt(tCnt)
                            .dCnt(dCnt)
                            .mCnt(mCnt)
                            .delYn(delYn)
                            .upt(upt)
                            .adtId(adtId)
                            .aCnt(aCnt)
                            .aReset(aReset)
                            .limitMode(limitMode)
                            .build();
    }
}
