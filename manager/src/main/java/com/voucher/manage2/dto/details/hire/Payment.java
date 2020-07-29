package com.voucher.manage2.dto.details.hire;

import lombok.Data;

import java.util.Date;

//租金缴纳明细 intype 为租金
@Data
public class Payment {
    private Double amount;          //缴纳金额
    private String printmemo;       //备注
    private Double printcount;      //打印次数
    private String operator;        //操作员
    private Date optdate;           //交租日期
    private String ticketno;        //发票号
}
