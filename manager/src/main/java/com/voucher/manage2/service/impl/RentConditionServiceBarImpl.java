package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.service.RentConditionBarService;
import com.voucher.manage2.tkmapper.entity.Hirelist;
import com.voucher.manage2.tkmapper.mapper.HirelistMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import com.voucher.manage2.utils.HistogramUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class RentConditionServiceBarImpl implements RentConditionBarService {

    @Resource
    private HirelistMapper hirelistMapper;

    @Override
    public String receivableBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<String> list = hirelistMapper.findHiredate();
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Double yingShou = hirelistMapper.findYingShou(s);  //年度应收租金
            if(yingShou == null){
                yingShou = 0.0;
            }
            list1.add(DoubleUtils.convert(yingShou) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("年度应收租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "年度应收租金");
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("年度应收租金---" + jsonObject);
        return string;
    }

    @Override
    public String takeBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<String> list = hirelistMapper.findHiredate();
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Double yiShou = hirelistMapper.findYiShou(s); //年度已收租金
            if(yiShou == null){
                yiShou = 0.0;
            }
            list1.add(DoubleUtils.convert(yiShou) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("年度已收租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "年度已收租金");
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("年度已收租金---" + jsonObject);
        return string;
    }

    @Override
    public String noTakeBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<String> list = hirelistMapper.findHiredate();
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Double count1 = hirelistMapper.findWeiShou(s); //年度未收租金
            if(count1 == null){
                count1 = 0.0;
            }
            list1.add(DoubleUtils.convert(count1) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("年度未收租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "年度未收租金");
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("年度未收租金---" + jsonObject);
        return string;
    }

    @Override
    public String receivedBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<String> list = hirelistMapper.findHiredate();
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Double shiShou = hirelistMapper.findShiShou(s); //年度实收租金
            if(shiShou == null){
                shiShou = 0.0;
            }
            list1.add(DoubleUtils.convert(shiShou) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("年度实收租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "年度实收租金");
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("年度实收租金---" + jsonObject);
        return string;
    }

    @Override
    public String throughOweBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<String> list = hirelistMapper.findHiredate();
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        String nowYear = DistinctUtils.nowYear();   //当前年
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Double liShou = hirelistMapper.findLiShou(nowYear, s);  //年度实收历欠租金
            if(liShou == null){
                liShou = 0.0;
            }
            list1.add(DoubleUtils.convert(liShou) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("年度实收历欠租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "年度实收历欠租金");
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("年度实收历欠租金---" + jsonObject);
        return string;
    }

    @Override
    public String precollectedBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<String> list = hirelistMapper.findHiredate();
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        ArrayList<String> list1 = new ArrayList<>();
        String nowYear = DistinctUtils.nowYear();   //当前年
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            Double yuShou = hirelistMapper.findYuShou(nowYear, s);  //年度预收租金
            if(yuShou == null){
                yuShou = 0.0;
            }
            list1.add(DoubleUtils.convert(yuShou) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("年度预收租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "年度预收租金");
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("年度预收租金---" + jsonObject);
        return string;
    }

    /**
     * 只统计当年的数据--租金收取情况
     *
     * @return
     */
    @Override
    public String hireCon() {
        List<Hirelist> hirelists = hirelistMapper.findDateAndHire();

        //newList就是固定日期
        String nowYear = DistinctUtils.nowYear();
        List<String> newList = DistinctUtils.polishing(nowYear);

        //补齐时间段
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : newList) {
            double count1 = 0; //应收租金
            double count2 = 0; //已收租金
            for (Hirelist hirelist : hirelists) {
                String hiredate = hirelist.getHiredate();    //日期
                if (hiredate != null) {
                    double hire = hirelist.getHire();           //租金
                    String state = hirelist.getState();         //状态
                    if (hiredate.equals(s)) {
                        count1 += hire;
                        if ("已交".equals(state)) {
                            count2 += hire;
                        }
                    }
                }
            }
            list1.add(DoubleUtils.convert(count1) + "");
            list2.add(DoubleUtils.convert(count2) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        KeyObjDTO k2 = new KeyObjDTO();
        k1.setName("应收租金");
        k2.setName("已收租金");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "租金收取情况");
        k1.setValue(list1);
        k2.setValue(list2);
        map.put("date", newList);
        map.put("data1", k1);
        map.put("data2", k2);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("租金收取情况---" + jsonObject);
        return string;
    }

    @Override
    public String monthHireCon() {
        List<Hirelist> hirelists = hirelistMapper.findDate();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //根据某年截取1--12月，这次截取现在时间的年份
        String nowYear = DistinctUtils.nowYear();
        //根据年份补充1-12月
        List<String> now = DistinctUtils.polishing(nowYear);

        ArrayList<String> list1 = new ArrayList<>();    //历收
        ArrayList<String> list2 = new ArrayList<>();    //预收
        ArrayList<String> list3 = new ArrayList<>();    //当月
        //根据不重复的年月进行判断
        for (String s : now) {
            double count1 = 0; //历收
            double count2 = 0; //预收
            double count3 = 0; //当月
            for (Hirelist hirelist : hirelists) {
                String hiredate = hirelist.getHiredate();    //日期
                String hireYear = DistinctUtils.year(hiredate);

                Date optdate = hirelist.getOptdate();
                if (optdate != null) {
                    String format = slf.format(optdate);
                    String optYear = DistinctUtils.year(optdate);
                    double hire = hirelist.getHire();        //租金
                    if (s.equals(format)) {
                        if (optdate != null) {
                            if (Integer.parseInt(optYear + "") == 2019) {
                                if (Integer.parseInt(hireYear) < 2019) {
                                    count1 += hire;
                                } else if (Integer.parseInt(hireYear) > 2019) {
                                    count2 += hire;
                                } else if (Integer.parseInt(hireYear) == 2019) {
                                    count3 += hire;
                                }
                            }
                        }
                    }
                }
            }
            double c1 = DoubleUtils.convert(count1);
            double c2 = DoubleUtils.convert(count2);
            double c3 = DoubleUtils.convert(count3);
            list1.add(c1 + "");
            list2.add(c2 + "");
            list3.add(c3 + "");

        }

        List<Object> list = DistinctUtils.saveList(list1, list2, list3);

        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("当月租金收入情况");
        HashMap<Object, Object> map = new HashMap<>();
        k1.setValue(list);
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("当月租金收入情况---" + jsonObject);
        return string;
    }


}
