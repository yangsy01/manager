package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.hireList.HireListDTO;
import com.voucher.manage2.service.RentConditionService;
import com.voucher.manage2.tkmapper.mapper.HirelistMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class RentConditionServiceImpl implements RentConditionService {
    @Resource
    private HirelistMapper hirelistMapper;


    @Override
    public String receivable() {
        String s = DistinctUtils.nowYear();
        Double count = hirelistMapper.findYingShou(s);
        if (count == null) {
            count = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("年度应收租金", DoubleUtils.convert(count));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("年度应收租金---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String take() {
        String s = DistinctUtils.nowYear();
        Double count1 = hirelistMapper.findYiShou(s); //当前年份的已交租金
        if (count1 == null) {
            count1 = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("年度已收租金", DoubleUtils.convert(count1));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("年度已收租金---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String noTake() {
        String s = DistinctUtils.nowYear();
        Double count = hirelistMapper.findWeiShou(s); //当前年份的未交租金
        if (count == null) {
            count = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("年度未收租金", DoubleUtils.convert(count));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("年度未收租金---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String received() {
//        //当前年月
//        String nowYear = DistinctUtils.nowYear();
//        Double count = hirelistMapper.findShiShou(nowYear); //年度实收租金
//        if (count == null) {
//            count = 0.0;
//        }
        //当前年
        String nowYear = DistinctUtils.nowYear();
        //已收
        Double count1 = hirelistMapper.findYiShou(nowYear); //当前年份的已交租金
        //预收
        String yearLast = Integer.parseInt(nowYear) + "-12";     //年末时间
        Double count2 = hirelistMapper.findReceiveAdvance(nowYear, yearLast);   //receive in advance 年度预收租金
        //实收历欠
        String yearFirst = nowYear + "-01";     //年初时间
        Double count3 = hirelistMapper.findThroughOwe(nowYear, yearFirst);       //  年度实收历欠租金 through owe
        if (count1 == null) {
            count1 = 0.0;
        }
        if (count2 == null) {
            count2 = 0.0;
        }
        if (count3 == null) {
            count3 = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("年度实收租金", DoubleUtils.convert(count1+count2+count3));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("年度实收租金---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String throughOwe() {
        //当前年
        String nowYear = DistinctUtils.nowYear();
        String yearFirst = nowYear + "-01";     //年初时间
        Double count = hirelistMapper.findThroughOwe(nowYear, yearFirst);       //  年度实收历欠租金 through owe
        if (count == null) {
            count = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("年度实收历欠租金", DoubleUtils.convert(count));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("年度实收历欠租金---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String precollected() {
        //当前年
        String nowYear = DistinctUtils.nowYear();
        String yearLast = Integer.parseInt(nowYear) + "-12";     //年末时间
        Double count = hirelistMapper.findReceiveAdvance(nowYear, yearLast);   //receive in advance 年度预收租金
        if (count == null) {
            count = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("年度预收租金", DoubleUtils.convert(count));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("年度预收租金---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String hireCon() {
        //根据某年截取1--12月，这次截取现在时间的年份
        String nowYear = DistinctUtils.nowYear();
        //根据年份补充1-12月
        List<String> now = DistinctUtils.polishing(nowYear);
        List<String> list1 = new ArrayList<>();    //总租金
        List<String> list2 = new ArrayList<>();    //已交租金
        //根据不重复的年月进行判断
        List<HireListDTO> allCount = hirelistMapper.findYingShouByYear(nowYear);
        List<HireListDTO> count = hirelistMapper.findYiShouByYear(nowYear);
        for (String s : now) {
            for (HireListDTO key : allCount) {
                if(key != null){
                    if(s.equals(key.getHireDate())){
                        Double hireCount = key.getHireCount();
                        if(hireCount == null){
                            hireCount = 0.0;
                        }
                        list1.add(DoubleUtils.convert(hireCount)+"");
                    }
                }
                else {
                    list1.add(0.0+"");
                }

            }
            for (HireListDTO key : count) {
                if(key != null){
                    if(s.equals(key.getHireDate())){
                        Double hireCount = key.getHireCount();
                        if(hireCount == null){
                            hireCount = 0.0;
                        }
                        list2.add(DoubleUtils.convert(hireCount)+"");
                    }
                }
                else {
                    list2.add(0.0+"");
                }
            }
        }

        List<Object> list = DistinctUtils.saveList(list1, list2);
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("租金收取情况");
        HashMap<Object, Object> map = new HashMap<>();
        k1.setValue(list);
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("租金收取情况---" + jsonObject);
        return string;
    }

    @Override
    public String monthHireCon(JSONObject mapKV) {

        //选取月份
        int data = mapKV.getInt("month");
        //根据月份传输数据
        int x = data;
        //防止x值溢出
        if (x < 0 || x > 12) {
            x = 1;
        }
        //根据某年截取1--12月，这次截取现在时间的年份
        String nowYear = DistinctUtils.nowYear();
        //根据传递过来的月份进行拼接
        String s = null;
        if (data >= 10) {
            s = nowYear + "-" + data;
        } else {
            s = nowYear + "-0" + data;
        }
        Double count1 = hirelistMapper.findLiShou(nowYear, s);    //历收
        Double count2 = hirelistMapper.findYuShou(nowYear, s);    //预收
        Double count3 = hirelistMapper.findDangYue(nowYear, s);    //当月

        if (count1 == null) {
            count1 = 0.0;
        }
        if (count2 == null) {
            count2 = 0.0;
        }
        if (count3 == null) {
            count3 = 0.0;
        }
        double c1 = DoubleUtils.convert(count1);
        double c2 = DoubleUtils.convert(count2);
        double c3 = DoubleUtils.convert(count3);


        KeyObjDTO k1 = new KeyObjDTO();
        KeyObjDTO k2 = new KeyObjDTO();
        KeyObjDTO k3 = new KeyObjDTO();
        k1.setName("历收");
        k2.setName("预收");
        k3.setName("当月");
        k1.setValue(c1);
        k2.setValue(c2);
        k3.setValue(c3);

        ArrayList<KeyObjDTO> keyObjDTO = new ArrayList<>();
        keyObjDTO.add(k1);
        keyObjDTO.add(k2);
        keyObjDTO.add(k3);

        JSONArray jsonObject = JSONArray.fromObject(keyObjDTO);
        log.info("当月租金收入情况---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String yingShouLQ() {
        //当前年
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        Double count = hirelistMapper.findYingShouLQ(slf.format(new Date()));
        if (count == null) {
            count = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("应收历欠租金", DoubleUtils.convert(count));
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String yiShou() {
        //当前年
        String nowYear = DistinctUtils.nowYear();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy");
        Double count = hirelistMapper.findYishouNowYear(nowYear,slf.format(new Date()));
        if (count == null) {
            count = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("应收历欠租金", DoubleUtils.convert(count));
        return JSONObject.fromObject(map).toString();
    }

}

