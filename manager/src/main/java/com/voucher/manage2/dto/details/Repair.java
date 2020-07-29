package com.voucher.manage2.dto.details;

import lombok.Data;

@Data
public class Repair {
    private String date;    //日期
    private String scan;    //扫描件
    private String repairCon;   //维修情况
    private String operator;    //操作员
    private String operatorDate;    //操作日期

}
