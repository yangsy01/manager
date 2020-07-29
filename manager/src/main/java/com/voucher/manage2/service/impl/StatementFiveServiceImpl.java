package com.voucher.manage2.service.impl;

import com.voucher.manage2.service.StatementFiveService;
import com.voucher.manage2.tkmapper.mapper.HirelistMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatementFiveServiceImpl implements StatementFiveService {
    @Resource
    private HirelistMapper hirelistMapper;

    @Override
    public Map<String, Object> annualRentC(Date date) {
        HashMap<String, Object> map = new HashMap<>();
        //当前年yue
        SimpleDateFormat slf = new SimpleDateFormat("yyyy");
        Double count1 = null;  //当前年份的应收租金
        Double count2 = null;    //当前年份的已交租金
        if(date != null){
            count1 = hirelistMapper.findYingShouNow(slf.format(date));
            count2 = hirelistMapper.findYiShouNow(slf.format(date));
        }
        else {
            count1 = hirelistMapper.findYingShouNow(slf.format(new Date()));
            count2 = hirelistMapper.findYiShouNow(slf.format(new Date()));
        }
        if (count1 == null) {
            count1 = 0.0;
        }
        if (count2 == null) {
            count2 = 0.0;
        }

        double than = 0;   //非空判断
        if (count1 != 0) {
            than = count2 / count1;
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);//这里是小数位
        String format = df.format(count1);
        String removeStr = ",";//去掉千分符号
        String replace = format.replace(removeStr, "");

        map.put("accountsY", replace);    // 年度应收
        map.put("receivedY", DoubleUtils.convert(count2));    // 年度已交租金
        map.put("proportionY", DoubleUtils.convert(than * 100) + "%");    // 已交/应收

        return map;
    }

    @Override
    public Map<String, Object> monthlyAmount(Date date) {

        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat slf1 = new SimpleDateFormat("yyyy");
        //当前年月
        String nowYearM = null;
        //当前年份
        String nowYear = null;
        if(date != null){
            nowYearM = slf.format(date);
            nowYear = slf1.format(date);
        }
        else {
            nowYearM = slf.format(new Date());
            nowYear = DistinctUtils.nowYear();
        }
        double count1 = 0;  //本月租金
        double count2 = 0;  //预收租金
        double count3 = 0;  //收取历欠租金
        //户数
        int c1 = 0;  //本月租金 计数
        int c2 = 0;  //预收租金 计数
        int c3 = 0;  //收取历欠租金 计数

//        if (list == null || list.size() == 0) {
            Map<String, Object> dangYue = hirelistMapper.findDangYueCountAndSum(nowYear, nowYearM);
            Map<String, Object> yuShou = hirelistMapper.findYuShouCountAndSum(nowYear, nowYearM);
            Map<String, Object> liShou = hirelistMapper.findLiShouCountAndSum(nowYear, nowYearM);
            Double sumH1 = (Double) dangYue.get("sumH");
            Integer countH1 = (Integer) dangYue.get("countH");
            Double sumH2 = (Double) yuShou.get("sumH");
            Integer countH2 = (Integer) yuShou.get("countH");
            Double sumH3 = (Double) liShou.get("sumH");
            Integer countH3 = (Integer) liShou.get("countH");
            if (sumH1 == null) {
                sumH1 = 0.0;
            }
            if (countH1 == null) {
                countH1 = 0;
            }
            if (sumH2 == null) {
                sumH2 = 0.0;
            }
            if (countH2 == null) {
                countH2 = 0;
            }
            if (sumH3 == null) {
                sumH3 = 0.0;
            }
            if (countH3 == null) {
                countH3 = 0;
            }
            count1 = sumH1;
            c1 = countH1;
            count2 = sumH2;
            c2 = countH2;
            count3 = sumH3;
            c3 = countH3;

        HashMap<String, Object> map = new HashMap<>();
        //金额
        double all = count1 + count2 + count3; //总金额
        double than1 = 0;
        double than2 = 0;
        double than3 = 0;
        if (all != 0) {
            than1 = count1 / all;
            than2 = count2 / all;
            than3 = count3 / all;
        }
        map.put("all", Math.round(all));
        map.put("moneyA", DoubleUtils.convert(count1));
        map.put("moneyB", DoubleUtils.convert(count2));
        map.put("moneyD", DoubleUtils.convert(count3));
        //金额占比
        map.put("propA", DoubleUtils.convert(than1 * 100) + "%");
        map.put("propB", DoubleUtils.convert(than2 * 100) + "%");
        map.put("propD", DoubleUtils.convert(than3 * 100) + "%");
        //户数
        int allC = c1 + c2 + c3; //总户数
        double thanC1 = 0;
        double thanC2 = 0;
        double thanC3 = 0;
        if (all != 0) {
            thanC1 = c1 / allC;
            thanC2 = c2 / allC;
            thanC3 = c3 / allC;
        }

        map.put("countA", c1);
        map.put("countB", c2);
        map.put("countD", c3);
        //户数占比
        map.put("propCA", DoubleUtils.convert(thanC1 * 100) + "%");
        map.put("propCB", DoubleUtils.convert(thanC2 * 100) + "%");
        map.put("propCD", DoubleUtils.convert(thanC3 * 100) + "%");

        return map;
    }

    @Override
    public Map<String, Object> MonthlyCharge(Date date) {

        HashMap<String, Object> map = new HashMap<>();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //当前年月
        String nowYearM = null;
        if(date != null){
            nowYearM = slf.format(date);
        }
        else {
            nowYearM = slf.format(new Date());
        }

        double count1 = 0;  //当前年月份的应收租金
        double count2 = 0;  //当前年月份的已交租金

            Double yingShou = hirelistMapper.findYingShou(nowYearM);
            Double yiShou = hirelistMapper.findYiShou(nowYearM);
            if (yingShou == null) {
                yingShou = 0.0;
            }
            if (yiShou == null) {
                yiShou = 0.0;
            }
            count1 = yingShou;
            count2 = yiShou;


        double than = 0;   //非空判断
        if (count1 != 0) {
            than = count2 / count1;
        }
        map.put("accountsM", DoubleUtils.convert(count1));    // 月度应收
        map.put("receivedM", DoubleUtils.convert(count2));    // 月度已交租金
        map.put("proportionM", DoubleUtils.convert(than * 100) + "%");    // 已交/应收

        return map;
    }
}
