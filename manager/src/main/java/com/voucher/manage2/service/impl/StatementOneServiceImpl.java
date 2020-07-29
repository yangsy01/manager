package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.service.StatementOneService;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.ChartinfoMapper;
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
public class StatementOneServiceImpl implements StatementOneService {

    @Resource
    private RoominfoMapper roominfoMapper;


    public Map<String,Object> findRoomCountAndArea(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        int countC1 = 0;
        int countC2 = 0;
        int countC3 = 0;
        //数组为空的时候
        if(list == null || list.size() == 0){
            countAndSums = roominfoMapper.findRoomPCountAndSum();
        }
        else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = roominfoMapper.findByDateArea(s1,s2);
        }
        for (CountAndSum countAndSum : countAndSums) {
            String roomProperty = countAndSum.getName();
            Double sumD = countAndSum.getSumD();
            Integer countD = countAndSum.getCountD();
            if(sumD == null){
                sumD = 0.0;
            }
            if(countD == null){
                countD = 0;
            }
            if("住宅房".equals(roomProperty)){
                count1 = sumD;
                countC1 = countD;
            }
            if("营业房".equals(roomProperty)){
                count2 = sumD;
                countC2 = countD;
            }
            if("其他".equals(roomProperty) || "土地".equals(roomProperty) ){
                count3 = sumD;
                countC3 = countD;
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("roomAreaZ", DoubleUtils.convert(count1) );
        resultMap.put("doBAreaZ",DoubleUtils.convert(count2));
        resultMap.put("landAreaZ",DoubleUtils.convert(count3));
        resultMap.put("roomCountZ", countC1 );
        resultMap.put("doBCountZ",countC2);
        resultMap.put("landCountZ",countC3);
//        resultMap.put("allAreaZ",DoubleUtils.convert(count1+count2+count3));
        return resultMap;
    }

    public Map<String,Object> findRoomProperty(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        int count1 = 0; //住宅房
        int count2 = 0; //营业房
        int count3 = 0; //其他
        if(list == null || list.size() == 0){
            countAndSums = roominfoMapper.findRoomPCountAndSum();
        }
        else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = roominfoMapper.findByDateCount(s1,s2);

        }
        for (CountAndSum countAndSum : countAndSums) {
            Integer countD = countAndSum.getCountD();
            String roomProperty = countAndSum.getName();
            if(countD == null){
                countD = 0;
            }
            if("住宅房".equals(roomProperty)){
                count1 = countD;
            }
            if("营业房".equals(roomProperty)){
                count2 = countD;
            }
            if("其他".equals(roomProperty) || "土地".equals(roomProperty)){
                count3 = countD;
            }
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("roomCZ",count1);
        resultMap.put("doBCZ",count2);
        resultMap.put("landCZ",count3);
        resultMap.put("allRoomZ",count1+count2+count3);

        return resultMap;
    }

    public Map<String,Object> findStructure(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        int count1 = 0; //砖木
        int count2 = 0; //砖混
        int count3 = 0; //框架
        int count4 = 0; //钢结构
        int count5 = 0; //其他

        double countA1 = 0; //砖木
        double countA2 = 0; //砖混
        double countA3 = 0; //框架
        double countA4 = 0; //钢结构
        double countA5 = 0; //其他

        if(list == null || list.size() == 0){
            countAndSums = roominfoMapper.findStructureCount();
        }
        else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = roominfoMapper.findByDateStr(s1,s2);
        }
        for (CountAndSum countAndSum : countAndSums) {
            String roomProperty = countAndSum.getName();
            Integer countD = countAndSum.getCountD();
            Double sumD = countAndSum.getSumD();
            if(sumD == null){
                sumD = 0.0;
            }
            if(countD == null){
                countD = 0;
            }
            if("砖木".equals(roomProperty)){
                count1 = countD;
                countA1 = sumD;
            }
            if("砖混".equals(roomProperty)){
                count2 = countD;
                countA2 = sumD;
            }
            if("框架".equals(roomProperty)){
                count3 = countD;
                countA3 = sumD;
            }
            if("钢结构".equals(roomProperty)){
                count4 = countD;
                countA4 = sumD;
            }
            if("其他".equals(roomProperty) || "土地".equals(roomProperty) ){
                count5 = countD;
                countA5 = sumD;
            }
        }
        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("timberZ",count1);
        resultMap.put("brickZ",count2);
        resultMap.put("brickConZ",count3);
        resultMap.put("steelZ",count4);
        resultMap.put("elseZ",count5);

        resultMap.put("timberAZ",countA1);
        resultMap.put("brickAZ",countA2);
        resultMap.put("brickConAZ",countA3);
        resultMap.put("steelAZ",countA4);
        resultMap.put("elseAZ",countA5);
//        resultMap.put("allStrZ",count1+count2+count3+count4+count5);

        return resultMap;

    }

    @Override
    public Map<String, Object> findNature(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        CountAndSum cas = new CountAndSum();
        int count1 = 0; //已出租
        int count2 = 0; //空置
        int count3 = 0; //不可出租
        int count4 = 0; //不可出租2

        double countA1 = 0; //已出租
        double countA2 = 0; //空置
        double countA3 = 0; //不可出租
        double countA4 = 0; //不可出租2

        if(list == null || list.size() == 0){
            countAndSums = roominfoMapper.findRoomNature();
            cas = roominfoMapper.findRoomCountAndSum();
        }
        else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = roominfoMapper.findRoomNatureByDate(s1,s2);
            cas = roominfoMapper.findRoomCASByDate(s1,s2);
        }
        for (CountAndSum countAndSum : countAndSums) {
            String roomProperty = countAndSum.getName();
            Integer countD = countAndSum.getCountD();
            Double sumD = countAndSum.getSumD();
            if(countD == null){
                countD = 0;
            }
            if("已出租".equals(roomProperty)){
                count1 = countD;
                countA1 = sumD;
            }
            if("空置".equals(roomProperty)){
                count2 = countD;
                countA2 = sumD;
            }
            if("不可出租".equals(roomProperty) ){
                count3 = countD;
                countA3 = sumD;
            }
            if( "不可出租2".equals(roomProperty) ){
                count4 = countD;
                countA4 = sumD;
            }



        }
        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("yiRentX",count1);
        resultMap.put("emptyX",count2);
        resultMap.put("noRentX",count3+count4);

        resultMap.put("yiRentAX",DoubleUtils.convert(countA1));
        resultMap.put("emptyAX",DoubleUtils.convert(countA2));
        resultMap.put("noRentAX",DoubleUtils.convert(countA3+countA4));
//        resultMap.put("allNatX",count1+count2+count3);

        //资产总计
        Integer allRoom = cas.getCountD();      //资产数量
        Double allRoomArea = cas.getSumD();     //资产面积
        if(allRoom == null){
            allRoom = 0;
        }
        if(allRoomArea == null){
            allRoomArea = 0.0;
        }
        resultMap.put("allRoom",allRoom);
        resultMap.put("allRoomArea",DoubleUtils.convert(allRoomArea));
        return resultMap;
    }
}
