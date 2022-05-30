package com.operation.management.primaryDto;


import com.operation.management.primary.model.ThresHold;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThresHoldDto {
    private String grp_cd;
    private String grp_nm;
    private String start_date;
    private String used_yn;
    @Builder.Default private String limit_price = "0";
    @Builder.Default private float sms_price = 0;
    @Builder.Default private float lms_price = 0;
    @Builder.Default private float mms_price = 0;
    private String alarm_group;
    private String reset_yn;
    private String reset_day;
    @Builder.Default private String reset_price = "0";
    private String reset_dttm;

    
    public ThresHoldDto(ThresHold thresHold){
        this.grp_cd = thresHold.getGrp_cd();
        this.grp_nm = thresHold.getGrp_nm();
        this.start_date = thresHold.getStart_date();
        this.used_yn = thresHold.getUsed_yn();
        this.limit_price = thresHold.getLimit_price();
        this.sms_price = thresHold.getSms_price();
        this.lms_price = thresHold.getLms_price();
        this.mms_price = thresHold.getMms_price();
        this.alarm_group = thresHold.getAlarm_group();
        this.reset_yn = thresHold.getReset_yn();
        this.reset_day = thresHold.getReset_day();
        this.reset_price = thresHold.getReset_price();
        this.reset_dttm = thresHold.getReset_dttm();
    }

    public ThresHold toEntity(){
        return ThresHold.builder().grp_cd(grp_cd).grp_nm(grp_nm)
                        .start_date(start_date).used_yn(used_yn)
                        .limit_price(limit_price).sms_price(sms_price)
                        .lms_price(lms_price).mms_price(mms_price)
                        .alarm_group(alarm_group)
                        .reset_yn(reset_yn).reset_day(reset_day)
                        .reset_price(reset_price).reset_dttm(reset_dttm)
                        .build();    
    }
}
