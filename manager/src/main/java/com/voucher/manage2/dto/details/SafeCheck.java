package com.voucher.manage2.dto.details;

import lombok.Data;

@Data
public class SafeCheck {
    private String checkResult; //检查结果
    private String content; //检查内容
    private String memo;    //备注
    private String checkName;   //检查人员
    private String checkDate;
    private String isPic;   //是否有图片
    private String state;   //状态

}
