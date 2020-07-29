package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.service.StatementTwoService;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class StatementTwoServiceImpl implements StatementTwoService {

    @Resource
    private RoominfoMapper roominfoMapper;

    @Override
    public Map<String,Object> roomConAndArea(List<String> list) {
        List<CountAndSum> countAndSums1 = new ArrayList<>();
        List<CountAndSum> countAndSums2 = new ArrayList<>();
        List<CountAndSum> countAndSums3 = new ArrayList<>();
        //Z:住宅  Y:营业  L:其他  A:area
        int countZ1 = 0; //已出租
        int countZ2 = 0; //空置
        int countZ3 = 0; //不可出租
        int countZ4 = 0; //不可出租2
        int countY1 = 0; //已出租
        int countY2 = 0; //空置
        int countY3 = 0; //不可出租
        int countY4 = 0; //不可出租2
        int countL1 = 0; //已出租
        int countL2 = 0; //空置
        int countL3 = 0; //不可出租
        int countL4 = 0; //不可出租2

        //面积
        double countZA1 = 0; //已出租
        double countZA2 = 0; //空置
        double countZA3 = 0; //不可出租
        double countZA4 = 0; //不可出租2
        double countYA1 = 0; //已出租
        double countYA2 = 0; //空置
        double countYA3 = 0; //不可出租
        double countYA4 = 0; //不可出租2
        double countLA1 = 0; //已出租
        double countLA2 = 0; //空置
        double countLA3 = 0; //不可出租
        double countLA4 = 0; //不可出租2

        if(list == null || list.size() == 0){
            countAndSums1 = roominfoMapper.findRoomByState();
            countAndSums2 = roominfoMapper.findDoBusByState();
            countAndSums3 = roominfoMapper.findLandByState();
        }
        else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums1 = roominfoMapper.findRoomByDate(s1,s2);
            countAndSums2 = roominfoMapper.findDoBusByDate(s1,s2);
            countAndSums3 = roominfoMapper.findLandByDate(s1,s2);
        }
        for (CountAndSum countAndSum1 : countAndSums1) {
            String name = countAndSum1.getName();
            Integer countD = countAndSum1.getCountD();
            Double sumD = countAndSum1.getSumD();
            if(countD == null){
                countD = 0;
            }
            if(sumD == null){
                sumD = 0.0;
            }
            if("已出租".equals(name)){
                countZ1 = countD;
                countZA1 = sumD;
            }
            if("空置".equals(name)){
                countZ2 = countD;
                countZA2 = sumD;
            }
            if("不可出租".equals(name)  ){
                countZ3 = countD;
                countZA3 = sumD;
            }
            if( "不可出租2".equals(name) ){
                countZ4 = countD;
                countZA4 = sumD;
            }
        }
        for (CountAndSum countAndSum2 : countAndSums2) {
            String name = countAndSum2.getName();
            Integer countD = countAndSum2.getCountD();
            Double sumD = countAndSum2.getSumD();
            if(countD == null){
                countD = 0;
            }
            if(sumD == null){
                sumD = 0.0;
            }
            if("已出租".equals(name)){
                countY1 = countD;
                countYA1 = sumD;
            }
            if("空置".equals(name)){
                countY2 = countD;
                countYA2 = sumD;
            }
            if("不可出租".equals(name)  ){
                countY3 = countD;
                countYA3 = sumD;
            }
            if( "不可出租2".equals(name) ){
                countY4 = countD;
                countYA4 = sumD;
            }
        }
        for (CountAndSum countAndSum3 : countAndSums3) {
            String name = countAndSum3.getName();
            Integer countD = countAndSum3.getCountD();
            Double sumD = countAndSum3.getSumD();
            if(countD == null){
                countD = 0;
            }
            if(sumD == null){
                sumD = 0.0;
            }
            if("已出租".equals(name)){
                countL1 = countD;
                countLA1 = sumD;
            }
            if("空置".equals(name)){
                countL2 = countD;
                countLA2 = sumD;
            }
            if("不可出租".equals(name)  ){
                countL3 = countD;
                countLA3 = sumD;
            }
            if( "不可出租2".equals(name) ){
                countL4 = countD;
                countLA4 = sumD;
            }
        }
        Map<String, Object> map = new HashMap<>();
        //数量
        map.put("rentOutCJA",countZ1);
        map.put("emptyCJA",countZ2);
        map.put("notRentCJA",countZ3+countZ4);
        map.put("rentOutCJB",countY1);
        map.put("emptyCJB",countY2);
        map.put("notRentCJB",countY3+countY4);
        map.put("rentOutCJC",countL1);
        map.put("emptyCJC",countL2);
        map.put("notRentCJC",countL3+countL4);
        //面积
        map.put("rentOutAJA",DoubleUtils.convert(countZA1));
        map.put("emptyAJA",DoubleUtils.convert(countZA2));
        map.put("notRentAJA", DoubleUtils.convert(countZA3+countZA4));
        map.put("rentOutAJB",DoubleUtils.convert(countYA1));
        map.put("emptyAJB",DoubleUtils.convert(countYA2));
        map.put("notRentAJB",DoubleUtils.convert(countYA3+countYA4));
        map.put("rentOutAJC",DoubleUtils.convert(countLA1));
        map.put("emptyAJC",DoubleUtils.convert(countLA2));
        map.put("notRentAJC",DoubleUtils.convert(countLA3+countLA4));

        return map;
    }

    public Map<String,Object> rentOut(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        int count1 = 0; //住宅房
        int count2 = 0; //营业房
        int count3 = 0; //其他
        double count4 = 0; //住宅房area
        double count5 = 0; //营业房area
        double count6 = 0; //其他  area

        if(list == null || list.size() == 0){
            countAndSums = roominfoMapper.findYiRent();
        }
        else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = roominfoMapper.findByDateYiRent(s1,s2);
        }
        for (CountAndSum countAndSum : countAndSums) {
            String name = countAndSum.getName();
            Integer countD = countAndSum.getCountD();
            Double sumD = countAndSum.getSumD();
            if(countD == null){
                countD = 0;
            }
            if(sumD == null){
                sumD = 0.0;
            }
            if("住宅房".equals(name)){
                count1 = countD;
                count4 = sumD;
            }
            if("营业房".equals(name)){
                count2 = countD;
                count5 = sumD;
            }
            if("其他".equals(name) || "土地".equals(name)){
                count3 = countD;
                count6 = sumD;
            }
        }
        Map<String, Object> map = new HashMap<>();
        //数量
        map.put("resRoomCJD",count1);
        map.put("BusRoomCJD",count2);
        map.put("landCJD",count3);
        //面积
        map.put("resRoomAJD",DoubleUtils.convert(count4));
        map.put("BusRoomAJD",DoubleUtils.convert(count5));
        map.put("landAJD",DoubleUtils.convert(count6));

        return map;

    }
}
