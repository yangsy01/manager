package com.voucher.manage2.dto.details.useful;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 经营信息
 */
@Data
public class Manage {
    private String charter;         //承租人
    private String sex;         //性别
    private String charterproperty;             //承租人性质
    private String creditrating;         //信誉等级
    private String cardtype;         //证件类型
    private String idno;         //证件号
    private String corporation;         //法人代表
    private String phone;         //联系电话
    private String homeaddress;         //联系地址
    private String charttype;       //安置类型
    private String chartproperty;         //租赁性质
    private Double area;         //计租面积
    private Double hire;         //月租金
    private Double chartcriterion;         //租赁标准
    private Double addrate;         //租赁标准后面的 率
    private Double assureamount;         //保证金
    private String contractno;         //合同编号
    private Date concludedate;         //签订日期
    private Date chartbegindate;         //合同起始
    private Date chartenddate;         //合同终止
    private String fareitem;         //经营项目
    private String lowprotect;         //是否低保
    private Double totalhire;         //合同总额
    private Double rentYi;         //已交租金 0 与hireList表关联获取
    private Double rentWei;         //未交租金 0
    private String rentEndDate;     //租金交至
    private String batchesReason; //欠租原因 0
    private String operator;         //经办人
    private Double settlementFees;  //房屋安置費 0
    private Double CNGFees;  //天然氣安裝費 0
    private String stopCollectRent; //暫停收租原因 0
    private String memo;         //备注


}
