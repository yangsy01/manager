package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.service.StatementFourService;
import com.voucher.manage2.tkmapper.entity.HiddenCheck;
import com.voucher.manage2.tkmapper.entity.HiddenNeaten;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.HiddenCheckMapper;
import com.voucher.manage2.tkmapper.mapper.HiddenNeatenMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class StatementFourServiceImpl implements StatementFourService {

    @Resource
    private HiddenCheckMapper hiddenCheckMapper;
    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private HiddenNeatenMapper neatenMapper;

    @Override
    public Map<String, Object> securityPar(List<String> list) {
        Map<String, Object> map = new HashMap<>();
        Integer count = 0;  //巡查
        Integer count1 = 0; //隐患
        Integer count2 = 0; //正在整改
        Integer count3 = 0; //未整改
        Integer count4 = 0; //危房

        if (list == null || list.size() == 0) {
            count = hiddenCheckMapper.findCount();  //巡查
            count1 = roominfoMapper.findYinHuan();
            count2 = roominfoMapper.findZaiZhengGai();
            count3 = roominfoMapper.findWeiZhengGai();
            count4 = roominfoMapper.findWeiFang();
        } else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            count = hiddenCheckMapper.findByDateCount(s1, s2);  //巡查
            count1 = roominfoMapper.findByDateYinHuan(s1, s2);
            count2 = roominfoMapper.findByDateZaiZhengGai(s1, s2);
            count3 = roominfoMapper.findByDateWeiZhengGai(s1, s2);
            count4 = roominfoMapper.findByDateWeiFang(s1, s2);
        }
        if (count == null) {
            count = 0;
        }
        if (count1 == null) {
            count1 = 0;
        }
        if (count2 == null) {
            count2 = 0;
        }
        if (count3 == null) {
            count3 = 0;
        }
        if (count4 == null) {
            count4 = 0;
        }
        map.put("patrol", count);
        map.put("hiddenTro", count1);
        map.put("abarbeitung", count2);
        map.put("noabarbeitung", count3);
        map.put("dangerousRoom", count4);

        return map;
    }

    @Override
    public Map<String, Object> maintain(List<String> list) {
        List<HiddenNeaten> hiddenNeatens = new ArrayList<>();
        if (list != null && list.size() > 0) {
            String date1 = list.get(0);
            String date2 = list.get(1);
            hiddenNeatens = neatenMapper.findDataByDate(date1, date2);
        } else {
            hiddenNeatens = neatenMapper.findData();
        }

        //拿到现在的年分
        double count1 = 0;     //面积
        double count2 = 0;     //送审金额
        double count3 = 0;     //审定金额
        double count4 = 0;     //审减金额
        String nowYear = DistinctUtils.nowYear();
        for (HiddenNeaten hiddenNeaten : hiddenNeatens) {
            if (hiddenNeaten != null) {
                Double area = hiddenNeaten.getArea();
                Double amount = hiddenNeaten.getAmount();
                Double auditingamount = hiddenNeaten.getAuditingamount();
                Double amounttotal = hiddenNeaten.getAmounttotal();
                if (area == null) {
                    area = 0.0;
                }

                if (amount == null) {
                    amount = 0.0;
                }
                if (auditingamount == null) {
                    auditingamount = 0.0;
                }

                if (amounttotal == null) {
                    amounttotal = 0.0;
                }
                count1 += area;
                count2 += amount;
                count3 += auditingamount;
                count4 += amounttotal;
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("repairYear", nowYear);
        map.put("repair", DoubleUtils.convert(count1));
        map.put("review", DoubleUtils.convert(count2));
        map.put("authorized", DoubleUtils.convert(count3));
        map.put("shenJian", DoubleUtils.convert(count4));

        return map;
    }
}
