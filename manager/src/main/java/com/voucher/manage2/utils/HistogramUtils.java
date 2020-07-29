package com.voucher.manage2.utils;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class HistogramUtils {

    public static HashMap<Object, Object> returnMap(int x, List<String> list1, List<String> allMonth, KeyObjDTO k1, String name){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", name);
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
        return map;
    }

    public static List<String> returnList(int x,List<String> list,List<String> requestList){
        //将所有的年+月存入到不重复newList中
        List<String> newList = DistinctUtils.getList(list, x);
        //补齐时间段
        List<String> allMonth = new ArrayList<>();
        if (requestList == null || requestList.size() == 0) {
            allMonth = DistinctUtils.getAllMonth(newList);
        } else {
            allMonth = requestList;
        }
        return allMonth;
    }

    public static List<String> returnDateList(List<Roominfo> roominfos){
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo roominfo : roominfos) {
            if (roominfo != null) {
                Date indate = roominfo.getIndate();
                if (indate != null) {
                    String format = slf.format(indate);
                    list.add(format);
                }
            }
        }
        return list;
    }

    public static List<String> returnChartList(List<Chartinfo> chartinfos){
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Chartinfo roominfo : chartinfos) {
            if (roominfo != null) {
                Date indate = roominfo.getConcludedate();
                if (indate != null) {
                    String format = slf.format(indate);
                    list.add(format);
                }
            }
        }
        return list;
    }
}
