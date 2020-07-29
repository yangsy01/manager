package com.voucher.manage2.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatementFiveService {
    public Map<String, Object> annualRentC(Date list);   //annualRentCollection  年度租金收取
    public Map<String, Object> monthlyAmount(Date list);   //The monthly amount  月度实收
    public Map<String, Object> MonthlyCharge(Date list);     //月度租金收取
}
