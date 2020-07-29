package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.service.StatementThreeService;
import com.voucher.manage2.service.StatementTwoService;
import com.voucher.manage2.tkmapper.entity.Roomassetsaccounting;
import com.voucher.manage2.tkmapper.entity.Roomassetsledger;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.RoomassetsaccountingMapper;
import com.voucher.manage2.tkmapper.mapper.RoomassetsledgerMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class StatementThreeServiceImpl implements StatementThreeService {

    @Resource
    private RoomassetsaccountingMapper accountingMapper;
    @Resource
    private RoomassetsledgerMapper ledgerMapper;
    @Resource
    private RoominfoMapper roominfoMapper;

    @Override
    public Map<String, Object> addChart(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        double countA1 = 0;
        double countA2 = 0;
        double countA3 = 0;
        double countA4 = 0;
        double countA5 = 0;

        if (list == null || list.size() == 0) {
            countAndSums = accountingMapper.findByType();
        } else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = accountingMapper.findByDateType(s1,s2);
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
            if ("购买资产".equals(name)) {
                count1 = countD;
                countA1 = sumD;
            } else if ("接收资产".equals(name)) {
                count2 = countD;;
                countA2 = sumD;
            } else if ("拆迁还房".equals(name)) {
                count3 = countD;;
                countA3 = sumD;
            } else if ("新建房产".equals(name)) {
                count4 = countD;;
                countA4 = sumD;
            } else if ("代管资产".equals(name)) {
                count5 = countD;;
                countA5 = sumD;
            }
        }

        Map<String, Object> map = new HashMap<>();
        //户数
        map.put("buyChartH", count1);
        map.put("receiveChartH", count2);
        map.put("removeChartH", count3);
        map.put("newChartH", count4);
        map.put("escrowChartH", count5);
        map.put("addChartH", count1 + count2 + count3 + count4 + count5);    //总户数

        //面积
        map.put("buyChartA", DoubleUtils.convert(countA1));
        map.put("receiveChartA", DoubleUtils.convert(countA2));
        map.put("removeChartA", DoubleUtils.convert(countA3));
        map.put("newChartA", DoubleUtils.convert(countA4));
        map.put("escrowChartA", DoubleUtils.convert(countA5));
        map.put("addChartA", DoubleUtils.convert(countA1 + countA2 + countA3 + countA4 + countA5));    //总面积

        return map;
    }

    @Override
    public Map<String, Object> cutChart(List<String> list) {
        List<CountAndSum> countAndSums = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        double countA1 = 0;
        double countA2 = 0;
        double countA3 = 0;
        double countA4 = 0;
        double countA5 = 0;

        if (list == null || list.size() == 0) {
            countAndSums = ledgerMapper.findByType();

        } else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = ledgerMapper.findByDateType(s1,s2);
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
            if ("拆迁".equals(name)) {
                count1 = countD;
                countA1 = sumD;
            } else if ("拆除".equals(name)) {
                count2 = countD;
                countA2 = sumD;
            } else if ("划拨".equals(name)) {
                count3 = countD;
                countA3 = sumD;
            } else if ("出售".equals(name)) {
                count4 = countD;
                countA4 = sumD;
            } else if ("灭失".equals(name)) {
                count5 = countD;
                countA5 = sumD;
            }
        }

        Map<String, Object> map = new HashMap<>();
        //户数
        map.put("removeH", count1);
        map.put("dismantleH", count2);
        map.put("transferH", count3);
        map.put("sellH", count4);
        map.put("lossH", count5);
        map.put("cutChartH", count1 + count2 + count3 + count4 + count5);    //总户数

        //面积
        map.put("removeA", DoubleUtils.convert(countA1));
        map.put("dismantleA", DoubleUtils.convert(countA2));
        map.put("transferA", DoubleUtils.convert(countA3));
        map.put("sellA", DoubleUtils.convert(countA4));
        map.put("lossA", DoubleUtils.convert(countA5));
        map.put("cutChartA", DoubleUtils.convert(countA1 + countA2 + countA3 + countA4 + countA5));    //总面积

        return map;

    }

    @Override
    public Map<String, Object> propertyRight(List<Date> list) {

        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        Map<String,Object> map4 = new HashMap<>();
        Map<String,Object> map5 = new HashMap<>();


        if(list != null && list.size() > 0){
            Date date1 = list.get(0);
            Date date2 = list.get(1);
            map1 = roominfoMapper.findRealEstateNoByDate(date1,date2);     //不动产权证
            map2 = roominfoMapper.findTwoByDate(date1,date2);              //双证齐全
            map3 = roominfoMapper.findPropertyRightNoByDate(date1,date2);  //单有房产证
            map4 = roominfoMapper.findGlebeCardNoByDate(date1,date2);      //单有土地证
            map5 = roominfoMapper.findNotByDate(date1,date2);              //未办证
        }
        else {
            map1 = roominfoMapper.findRealEstateNo();     //不动产权证
            map2 = roominfoMapper.findTwo();              //双证齐全
            map3 = roominfoMapper.findPropertyRightNo();  //单有房产证
            map4 = roominfoMapper.findGlebeCardNo();      //单有土地证
            map5 = roominfoMapper.findNot();              //未办证
        }

        Integer allCount1 = (Integer) map1.get("allCount");
        Double allArea1 = (Double) map1.get("allArea");
        if(allArea1 == null){
            allArea1 = 0.0;
        }
        if(allCount1 == null){
            allCount1 = 0;
        }

        Integer allCount2 = (Integer) map2.get("allCount");
        Double allArea2 = (Double) map2.get("allArea");
        if(allArea2 == null){
            allArea2 = 0.0;
        }
        if(allCount2 == null){
            allCount2 = 0;
        }

        Integer allCount3 = (Integer) map3.get("allCount");
        Double allArea3 = (Double) map3.get("allArea");
        if(allArea3 == null){
            allArea3 = 0.0;
        }
        if(allCount3 == null){
            allCount3 = 0;
        }


        Integer allCount4 = (Integer) map4.get("allCount");
        Double allArea4 = (Double) map4.get("allArea");
        if(allArea4 == null){
            allArea4 = 0.0;
        }
        if(allCount4 == null){
            allCount4 = 0;
        }

        Integer allCount5 = (Integer) map5.get("allCount");
        Double allArea5 = (Double) map5.get("allArea");
        if(allArea5 == null){
            allArea5 = 0.0;
        }
        if(allCount5 == null){
            allCount5 = 0;
        }


        Map<String, Object> map = new HashMap<>();
        map.put("propertyCardH", allCount1);
        map.put("bothH", allCount2);
        map.put("houseProH", allCount3);
        map.put("landCardH", allCount4);
        map.put("noRushH", allCount5);
        //面积
        map.put("propertyCardA", DoubleUtils.convert(allArea1));
        map.put("bothA", DoubleUtils.convert(allArea2));
        map.put("houseProA", DoubleUtils.convert(allArea3));
        map.put("landCardA", DoubleUtils.convert(allArea4));
        map.put("noRushA", DoubleUtils.convert(allArea5));
        return map;
    }

    @Override
    public Map<String, Object> impawn(List<String> list) {
//        List<Roominfo> roominfos = roominfoMapper.findImPawn();
        List<CountAndSum> countAndSums = new ArrayList<>();
        int count1 = 0; //已抵押住宅房
        int count2 = 0; //已抵押营业房
        int count3 = 0; //已抵押土地
        //面积
        double countA1 = 0; //已抵押住宅房
        double countA2 = 0; //已抵押营业房
        double countA3 = 0; //已抵押土地
        if (list == null || list.size() == 0) {
            countAndSums = roominfoMapper.findByIsPawn();
        } else {
            String s1 = list.get(0);
            String s2 = list.get(1);
            countAndSums = roominfoMapper.findByDateIsPawn(s1,s2);
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
            if ("住宅房".equals(name)) {
                count1 = countD;
                countA1 = sumD;
            }
            if ("营业房".equals(name)) {
                count2 = countD;
                countA2 = sumD;
            }
            if ( "土地".equals(name) ) {
                count3 = countD;
                countA3 = sumD;
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("residenceHD", count1);
        map.put("businessHD", count2);
        map.put("landHD", count3);
        map.put("imPawnHD", count1 + count2 + count3);       //合计
        //面积
        map.put("residenceAD", DoubleUtils.convert(countA1));
        map.put("businessAD", DoubleUtils.convert(countA2));
        map.put("landAD", DoubleUtils.convert(countA3));
        map.put("imPawnAD", DoubleUtils.convert(countA1 + countA2 + countA3));    //合计

        return map;
    }


}
