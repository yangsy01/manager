package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.service.SecurityConditionBarService;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
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

@Service
@Slf4j
public class SecurityConditionServiceBarImpl implements SecurityConditionBarService {

    @Resource
    private RoominfoMapper roominfoMapper;

    @Override
    public String patrolBar(String name, String column, List<String> requestList) {
        return null;
    }

    @Override
    public String hidDangerBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> hiddenChecks = roominfoMapper.findHidDanger();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roominfo hiddenCheck : hiddenChecks) {
            if(hiddenCheck != null){
                Date date = hiddenCheck.getIndate();
                if (date != null) {
                    String format = slf.format(date);
                    list.add(format);
                }
            }

        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0;
            for (Roominfo hiddenCheck : hiddenChecks) {
                if(hiddenCheck != null){
                    if(hiddenCheck != null){
                        Date date = hiddenCheck.getIndate();    //日期
                        if (date != null) {
                            Integer ishidden = hiddenCheck.getIshidden();
                            if(ishidden == null){
                                ishidden = 0;
                            }
                            String format = slf.format(date);
                            if (format.equals(s)) {
                                if (ishidden > 0 ) {
                                    count1++;
                                }
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("隐患处数");
        HashMap<Object, Object> map = new HashMap<>();
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
        map.put("title", "隐患处数");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("隐患处数---" + jsonObject);
        return string;
    }

    @Override
    public String abarbeitungBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> hiddenChecks = roominfoMapper.findAbarbeitung();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roominfo hiddenCheck : hiddenChecks) {
            if(hiddenCheck != null){
                Date date = hiddenCheck.getIndate();
                if (date != null) {
                    String format = slf.format(date);
                    list.add(format);
                }
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            int count1 = 0;
            for (Roominfo hiddenCheck : hiddenChecks) {
                if(hiddenCheck != null){
                    Date date = hiddenCheck.getIndate();    //日期
                    if (date != null) {
                        Integer neatenFlow = hiddenCheck.getNeatenFlow();
                        if(neatenFlow == null){
                            neatenFlow = 0;
                        }
                        String format = slf.format(date);
                        if (format.equals(s)) {
                            if (neatenFlow > 0) {
                                count1++;
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("正在整改");
        HashMap<Object, Object> map = new HashMap<>();
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
        map.put("title", "正在整改");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("正在整改---" + jsonObject);
        return string;
    }

    @Override
    public String noAbarbeitungBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> hiddenChecks = roominfoMapper.weiZhengGai();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roominfo hiddenCheck : hiddenChecks) {
            if(hiddenCheck != null){
                Date date = hiddenCheck.getIndate();
                if (date != null) {
                    String format = slf.format(date);
                    list.add(format);
                }
            }
        }

        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            int count1 = 0;
            for (Roominfo hiddenCheck : hiddenChecks) {
                Date date = hiddenCheck.getIndate();    //日期
                if (date != null) {

                    Integer ishidden = hiddenCheck.getIshidden();
                    Integer neatenFlow = hiddenCheck.getNeatenFlow();
                    if(ishidden == null){
                        ishidden = 0;
                    }
                    if(neatenFlow == null){
                        neatenFlow = 0;
                    }
                    if(neatenFlow == 0 && ishidden >0 ){
                        count1++;
                    }
                }

            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("未整改处数");
        HashMap<Object, Object> map = new HashMap<>();
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
        map.put("title", "未整改处数");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("未整改处数---" + jsonObject);
        return string;
    }

    @Override
    public String dgRoomBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> roominfos = roominfoMapper.findDgHouse();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo roominfo : roominfos) {
            if(roominfo != null){
                Date indate = roominfo.getIndate();
                if (indate != null) {
                    String format = slf.format(indate);
                    list.add(format);
                }
            }

        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //危房

            for (Roominfo roominfo : roominfos) {
                Date indate = roominfo.getIndate();//日期
                if (indate != null) {
                    String dangerclassification = roominfo.getDangerclassification();
                    String format = slf.format(indate);
                    if (format.equals(s)) {
                        if ("D级".equals(dangerclassification)) {
                            count1++;
                        }

                    }
                }

            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("危房");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "危房处数");
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
        log.info("危房处数---" + jsonObject);
        return string;
    }

    @Override
    public String hidRateBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> hiddenChecks = roominfoMapper.findHidDanger();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roominfo hiddenCheck : hiddenChecks) {
            if(hiddenCheck != null){
                Date date = hiddenCheck.getIndate();
                if (date != null) {
                    String format = slf.format(date);
                    list.add(format);
                }
            }

        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            double count1 = 0;
            double count2 = hiddenChecks.size();
            for (Roominfo hiddenCheck : hiddenChecks) {
                Date date = hiddenCheck.getIndate();    //日期
                if (date != null) {
                    Integer ishidden = hiddenCheck.getIshidden();
                    if(ishidden == null){
                        ishidden = 0;
                    }
                    String format = slf.format(date);
                    if (format.equals(s)) {
                        if (ishidden > 0) {
                            count1++;
                        }
                    }
                }

            }
            double convert = 0;
            if (count2 == 0) {
                convert = 0;
            } else {
                convert = DoubleUtils.convert(count1 / count2);
            }
            list1.add(convert + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("隐患率");
        HashMap<Object, Object> map = new HashMap<>();
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
        map.put("title", "隐患率");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("隐患率---" + jsonObject);
        return string;
    }

    @Override
    public String abaRateBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> hiddenChecks = roominfoMapper.findAbarbeitung();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roominfo hiddenCheck : hiddenChecks) {
            if(hiddenCheck != null){
                Date date = hiddenCheck.getIndate();
                if (date != null) {
                    String format = slf.format(date);
                    list.add(format);
                }
            }

        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            double count1 = 0;
            double count2 = hiddenChecks.size();
            for (Roominfo hiddenCheck : hiddenChecks) {
                Date date = hiddenCheck.getIndate();    //日期
                if (date != null) {
                    Integer neatenFlow = hiddenCheck.getNeatenFlow();
                    if(neatenFlow == null){
                        neatenFlow = 0;
                    }
                    String format = slf.format(date);
                    if (format.equals(s)) {
                        if (neatenFlow > 0 ) {
                            count1++;
                        }
                    }
                }

            }
            double convert = 0;
            if (count2 == 0) {
                convert = 0;
            } else {
                convert = DoubleUtils.convert(count1 / count2);
            }
            list1.add(convert + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("整改率");
        HashMap<Object, Object> map = new HashMap<>();
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
        map.put("title", "整改率");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("整改率---" + jsonObject);
        return string;
    }

    @Override
    public String dgRoomRateBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> roominfos = roominfoMapper.findDgHouse();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo roominfo : roominfos) {
            if(roominfo != null){
                Date indate = roominfo.getIndate();
                if (indate != null) {
                    String format = slf.format(indate);
                    list.add(format);
                }
            }

        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            double count1 = 0; //危房
            double count2 = roominfos.size();
            for (Roominfo roominfo : roominfos) {
                Date indate = roominfo.getIndate();//日期
                if (indate != null) {
                    String dangerclassification = roominfo.getDangerclassification();
                    String format = slf.format(indate);
                    if (format.equals(s)) {
                        if ("D级".equals(dangerclassification)) {
                            count1++;
                        }
                    }
                }
            }
            double convert = 0;
            if (count2 == 0) {
                convert = 0;
            } else {
                convert = DoubleUtils.convert(count1 / count2);
            }
            list1.add(convert + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("危房率");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "危房率");
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
        log.info("危房率---" + jsonObject);
        return string;
    }
}
