package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.dto.details.hire.MarginPay;
import com.voucher.manage2.dto.details.hire.Payment;
import com.voucher.manage2.tkmapper.entity.Hirepay;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HirepayMapper extends Mapper<Hirepay>, InsertListMapper<Hirepay> {

    @Select("select amount,printmemo,printcount,operator,optdate,ticketno from HirePay where inType = '租金' and ChartGUID = #{chartGuid} ")
    List<Payment> findPayment(String chartGuid);

    @Select("select amount,printmemo,printcount,operator,optdate,ticketno from HirePay where inType = '保证金' and ChartGUID = #{chartGuid} ")
    List<MarginPay> findMarginPay(String chartGuid);
}