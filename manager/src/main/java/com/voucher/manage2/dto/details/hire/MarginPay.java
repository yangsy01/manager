package com.voucher.manage2.dto.details.hire;

import lombok.Data;

import java.util.Date;

//保证金缴纳明细  intype 为保证金
@Data
public class MarginPay {
    private Double amount;      //保证金
    private String printmemo;   //备注
    private Double printcount;  //打印次数
    private String operator;    //操作员
    private Date optdate;       //缴纳日期
    private String ticketno;    //票号
}
