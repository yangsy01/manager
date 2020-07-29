package com.voucher.manage2.dto.details.hire;

import lombok.Data;

import java.util.Date;

//未缴纳租金明细
@Data
public class Nonpayment {
    private String hireDate;
    private Double hire;
    private Date beginDate;
    private Date endDate;
    private Double chartCriterion;         //租赁标准
    private String state;                  //状态
}
