package com.voucher.manage2.utils;

import com.voucher.manage2.dto.KeyVListDTO;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class DistinctUtils {

    /**
     * 得到不重复年份
     *
     * @param list
     * @param x    代表几年同列展示数据
     * @return
     */
    public static List<String> getList(List<String> list, int x) {
        //将所有的年+月存入到不重复newList中
        Set set = new HashSet(list);
        List<String> newList = new ArrayList<>(set);
        return newList;

    }

    public static List<Object> arr(ArrayList<Object> arrayList, List<String> list, int x) {
        //补充对应年月应有的数据
        //size < x*12  的时候补充
        int size = list.size();
        if (size < x * 12) {
            for (int i = 0; i < (x * 12 - size); i++) {
                list.add(0 + "");
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i < 12) {
                ArrayList<String> a1 = new ArrayList<>();
                String s = list.get(i);
                String e = list.get(i + (x - 1) * 12);
                //X=3
                String s3 = list.get(i + (x - 1) * (x - 2) * 12);
                a1.add((i + 1) + "月");
                a1.add(s);
                a1.add(e);
                if (x == 3) {
                    a1.add(s3);
                }
                arrayList.add(a1);
            }
        }
        return arrayList;
    }

    public static ArrayList<Object> month() {
        //月份
        ArrayList<Object> monthList = new ArrayList<>();
        monthList.add("1月");
        monthList.add("2月");
        monthList.add("3月");
        monthList.add("4月");
        monthList.add("5月");
        monthList.add("6月");
        monthList.add("7月");
        monthList.add("8月");
        monthList.add("9月");
        monthList.add("10月");
        monthList.add("11月");
        monthList.add("12月");
        return monthList;
    }

    public static List<String> year(List<String> newList, int x) {

        if (x > newList.size())
            x = newList.size();
        List<String> list = newList.stream().map(e -> e.substring(0, 4)).collect(Collectors.toList());
        HashSet<String> set = new HashSet<>(list);
        List<String> list1 = new ArrayList<>(set);
        int s = 0 ;
        if(list1 != null && list1.size() > 0){
            s = Integer.parseInt(list1.get(0)); //取最小值
        }
        int size = list1.size();
        if(size == 1){
            list1.add((s-1)+"");
            list1.add((s-2)+"");
        }
        else if (size == 2){
            list1.add((s-2)+"");
        }
        List<String> list2 = list1.subList(0, x);
        list2.add(0, "年份");
        return list2;

    }

    /**
     * @param minDate 最小时间
     * @param maxDate 最大时间
     * @return 日期集合 格式为 年-月
     * @throws Exception
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        if(minDate != null){
            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        }

        if(maxDate != null){
            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        }

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    //根据时间集合返回值
    public static List<String> getAllMonth(List<String> newList) {
//        Collections.sort(newList);
        String max = null;
        String min = null;
        if(newList != null && newList.size() > 0 ){
            max = newList.get(newList.size() - 1);   //最大年份
            min = newList.get(0);                //最小年份
        }
        //补齐中间的所有年份
        List<String> monthBetween = null;
        try {
            monthBetween = DistinctUtils.getMonthBetween(min, max);     //所有年份
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monthBetween;
    }

    //根据大小时间返回值
    public static List<String> getAllMonth01(String min, String max) {
        //补齐中间的所有年份
        List<String> monthBetween = null;
        try {
            monthBetween = DistinctUtils.getMonthBetween(min, max);     //所有年份
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monthBetween;
    }

    //用当前年份得到当前年起始时间，到当前时间，放到list中
    public static List<String> nowDateList() {
        Date date = new Date();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat slf1 = new SimpleDateFormat("yyyy");
        String format = slf1.format(date);  //2019
        String min = format + "-01-01 00:00:00";
        Date minDate = null;
        try {
            minDate = slf.parse(min);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> arrayList = new ArrayList<>();
        arrayList.add(min);
        arrayList.add(slf.format(date));

        return arrayList;
    }


    //当前实际年份
    public static String nowYear() {
        SimpleDateFormat slf1 = new SimpleDateFormat("yyyy");
        Date now = new Date();
        String format1 = slf1.format(now);
        return format1;
    }


    //补齐最初月份到1月和最后月份到12月
    public static List<String> polishing(List<String> newList) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        String first = newList.get(0);
        String last = newList.get(newList.size() - 1);
        Date parseF = null;
        Date parseL = null;
        try {
            parseF = slf.parse(first);
            parseL = slf.parse(last);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(parseF);
        c2.setTime(parseL);
        int firstMonth = c1.get(Calendar.MONTH);
        int endMonth = c2.get(Calendar.MONTH);
        int firstYear = c1.get(Calendar.YEAR);
        int endYear = c2.get(Calendar.YEAR);
        if (firstMonth != 1) {    //第一个月不是一月，补齐
            newList.add(firstYear + "-01");
        }
        if (endMonth != 12) {     //最后一个月不是12月，补齐
            newList.add(endYear + "-12");
        }
        return newList;
    }

    //根据年份补充1-12月
    public static List<String> polishing(String year) {
        List<String> list = new ArrayList<>();
        list.add(year + "-01");
        list.add(year + "-02");
        list.add(year + "-03");
        list.add(year + "-04");
        list.add(year + "-05");
        list.add(year + "-06");
        list.add(year + "-07");
        list.add(year + "-08");
        list.add(year + "-09");
        list.add(year + "-10");
        list.add(year + "-11");
        list.add(year + "-12");
        return list;
    }

    public static List<Object> saveList(List<String> list1, List<String> list2) {

        List<Object> bigList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            List<Object> list = new ArrayList<>();
            String s1 = list1.get(i);
            String s2 = list2.get(i);
            list.add((i + 1) + "月");
            list.add(s1);
            list.add(s2);
            bigList.add(list);
        }
        List<String> title = new ArrayList<>();
        title.add("月份");
        title.add("应收租金");
        title.add("已收租金");
        bigList.add(0, title);
        return bigList;

    }

    public static List<Object> saveList(List<String> list1, List<String> list2, List<String> list3) {

        List<Object> bigList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            List<Object> list = new ArrayList<>();
            String s1 = list1.get(i);
            String s2 = list2.get(i);
            String s3 = list3.get(i);
            list.add((i + 1) + "月");
            list.add(s1);
            list.add(s2);
            list.add(s3);
            bigList.add(list);
        }
        List<String> title = new ArrayList<>();
        title.add("月份");
        title.add("历收");
        title.add("预收");
        title.add("当月");
        bigList.add(0, title);
        return bigList;

    }


    //将得到的日期得到年份
    public static String year(String date) {
        SimpleDateFormat slf1 = new SimpleDateFormat("yyyy");
        Date parse = null;
        try {
            parse = slf1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String format = slf1.format(parse);
        return format;
    }

    public static String year(Date date) {
        SimpleDateFormat slf1 = new SimpleDateFormat("yyyy");
        String format = slf1.format(date);
        return format;
    }

    //获取年+月格式
    public static String getNandM(Date indate) {
        SimpleDateFormat slf1 = new SimpleDateFormat("yyyy-MM");
        String format = slf1.format(indate);
        return format;
    }


    //将前台传过来的月份进行补充
    public static List<String> getMonthAll(JSONObject mapKV) {
        JSONArray array = mapKV.getJSONArray("time");

        boolean empty = array.isEmpty();
        long start = 0;
        long end = 0;
        List<String> list = null;

        if (!empty) {
            start = array.getLong(0);
            end = array.getLong(1);
            //取两段日期中的所有日期 ，按年+月  存入list
            Date date1 = new Date(start);
            Date date2 = new Date(end);
            SimpleDateFormat slfDate = new SimpleDateFormat("yyyy-MM");
            String format1 = slfDate.format(date1);
            String format2 = slfDate.format(date2);
            list = DistinctUtils.getAllMonth01(format1, format2);

        }
        return list;
    }

    public static List<String> getMonthAllNew(JSONObject mapKV) {
        JSONArray array = mapKV.getJSONArray("time");

        boolean empty = array.isEmpty();
        long start = 0;
        long end = 0;
        List<String> list = new ArrayList<>();

        if (!empty) {
            start = array.getLong(0);
            end = array.getLong(1);
            //取两段日期中的所有日期 ，按年+月  存入list
            Date date1 = new Date(start);
            Date date2 = new Date(end);
            SimpleDateFormat slfDate = new SimpleDateFormat("yyyy-MM");
            String format1 = slfDate.format(date1);
            String format2 = slfDate.format(date2);
            list = DistinctUtils.getAllMonth01(format1, format2);

        }
        return list;
    }

}
