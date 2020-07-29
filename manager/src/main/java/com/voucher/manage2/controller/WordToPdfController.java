package com.voucher.manage2.controller;


import com.voucher.manage2.service.*;

import com.voucher.manage2.utils.DistinctUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * word转PDF文档
 * 返回PDF文档地址
 */
@CrossOrigin
@RestController
@RequestMapping("convert")
public class WordToPdfController {


    @Autowired
    private WordToPdfService wordToPdfService;

    @Autowired
    private ReplaceKeywordsService replaceKeywordsService;
    @Resource
    private StatementOneService oneService;
    @Resource
    private StatementTwoService twoService;
    @Resource
    private StatementThreeService threeService;
    @Resource
    private StatementFourService fourService;
    @Resource
    private StatementFiveService fiveService;

    /**
     * 替换关键字
     *
     * @throws IOException
     */
    @RequestMapping("acquireData")
    public Object acquireData(@RequestBody JSONObject mapKV) throws IOException {
        String number = mapKV.getString("number");        //页面识别码 1 , 2 , 3 , 4, 5  对应五个页面
        int x = Integer.parseInt(number);
        JSONArray array = mapKV.getJSONArray("date");     //日期筛选
        boolean empty = array.isEmpty();
        long start = 0;
        long end = 0;
        List<String> list2 = new ArrayList<>();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> map = new HashMap<>();
        if (!empty) {
            start = array.getLong(0);
            end = array.getLong(1);
            //取两段日期中的所有日期 ，按年+月  存入list
            Date date1 = new Date(start);
            Date date2 = new Date(end);
            list2.add(slf.format(date1));
            list2.add(slf.format(date2));
            map.put("startTime", slf.format(date1));   //操作日期
            map.put("endTime", slf.format(date2));   //操作日期
        } else {
            map.put("time", slf.format(new Date()));     //操作日期
            String s = DistinctUtils.nowYear();
            String yearFirst = s + "-01-01";
            String yearEnd   = s + "-12-31";
            map.put("startTime", yearFirst);   //操作日期
            map.put("endTime", yearEnd);   //操作日期
        }


        //查询需要的数据装入map
        if (x == 1) {
            //资产状况报表
            long start1 = System.currentTimeMillis();
            Map<String, Object> map1 = oneService.findRoomCountAndArea(list2);       //户数 + 面积
            Map<String, Object> map3 = oneService.findStructure(list2);             //资产结构
            Map<String, Object> map4 = oneService.findNature(list2);                //资产状态 + 资产总计

            long end1 = System.currentTimeMillis();
            System.out.println("查询用时..." + (end1 - start1) + "ms");
            map.putAll(map1);
            map.putAll(map3);
            map.putAll(map4);
        } else if (x == 2) {
            //经营状况报表
            long start1 = System.currentTimeMillis();
            Map<String, Object> map4 = twoService.roomConAndArea(list2);    //（住宅，营业，其他情况）
            Map<String, Object> map5 = twoService.rentOut(list2);           //已出租资产状况
            long end1 = System.currentTimeMillis();
            System.out.println("查询用时..." + (end1 - start1) + "ms");
            map.putAll(map4);
            map.putAll(map5);
        } else if (x == 3) {
            //产权/财务状况报表(C)
            if(list2 == null || list2.size() == 0){
                String s = DistinctUtils.nowYear();
                String yearFirst = s + "-01-01";
                String yearEnd   = s + "-12-31";
                list2.add(yearFirst);
                list2.add(yearEnd);
            }
            long start1 = System.currentTimeMillis();
            Map<String, Object> map6 = threeService.addChart(list2);         //租赁增加
            Map<String, Object> map7 = threeService.cutChart(list2);         //租赁减少
//            Map<String, Object> map8 = threeService.propertyRight(listDate);    //办证情况
//            Map<String, Object> map9 = threeService.impawn(list2);           //抵押情况
            long end1 = System.currentTimeMillis();
            System.out.println("查询用时..." + (end1 - start1) + "ms");
            map.putAll(map6);
            map.putAll(map7);
        } else if (x == 4) {
            //安全巡查状况报表
            long start1 = System.currentTimeMillis();
            Map<String, Object> map10 = fourService.securityPar(list2);
            Map<String, Object> map11 = fourService.maintain(list2);
            long end1 = System.currentTimeMillis();
            System.out.println("查询用时..." + (end1 - start1) + "ms");
            map.putAll(map10);
            map.putAll(map11);
        }
//        else if(x == 5){
//            //租金状况报表
//            long start1 = System.currentTimeMillis();
//            Map<String, Object> map12 = fiveService.annualRentC(list1);
//            Map<String, Object> map13 = fiveService.monthlyAmount(list);
//            Map<String, Object> map14 = fiveService.MonthlyCharge(list);
//            long end1 = System.currentTimeMillis();
//            System.out.println("查询用时..." + (end1 - start1) + "ms");
//            map.putAll(map12);
//            map.putAll(map13);
//            map.putAll(map14);
//        }


        //替换关键字
        String replaceWordPath = replaceKeywordsService.printWord(map, x);

        //word转PDF方法
        String pdfAdress = wordToPdfService.convert(replaceWordPath);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("pdfAdress", pdfAdress);
        return resultMap;

    }


    /**
     * 替换关键字
     *
     * @throws IOException
     */
    @RequestMapping("rentData")
    public Object rentData(@RequestBody JSONObject mapKV) throws IOException, ParseException {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        Date date = new Date(mapKV.getLong("date"));
        Map<String, Object> map = new HashMap<>();
        if (date != null) {
            map.put("time", slf.format(date));   //操作日期
        } else {
            map.put("time", "--");   //操作日期
        }
        //查询需要的数据装入map
        //租金状况报表
        long start1 = System.currentTimeMillis();
        Map<String, Object> map12 = fiveService.annualRentC(date);
        Map<String, Object> map13 = fiveService.monthlyAmount(date);
        Map<String, Object> map14 = fiveService.MonthlyCharge(date);
        long end1 = System.currentTimeMillis();
        System.out.println("查询用时..." + (end1 - start1) + "ms");
        map.putAll(map12);
        map.putAll(map13);
        map.putAll(map14);

        int x = 5;
        //替换关键字
        String replaceWordPath = replaceKeywordsService.printWord(map, x);

        //word转PDF方法
        String pdfAdress = wordToPdfService.convert(replaceWordPath);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("pdfAdress", pdfAdress);
        return resultMap;

    }
}
