package com.voucher.manage2.dto.details.hire;


import lombok.Data;

import java.util.Date;

//已抵扣租金明细
@Data
public class Deducted {
    private String hireDate;
    private Double hire;
    private Date beginDate;
    private Date endDate;
    private Double chartCriterion;         //租赁标准
    private String state;                  //状态
    private String payfashion;
    private String instruction;
    private String operator;
    private Date optdate;

}
