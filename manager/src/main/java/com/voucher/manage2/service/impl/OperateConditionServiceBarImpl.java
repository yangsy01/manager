package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.service.OperateConditionBarService;
import com.voucher.manage2.tkmapper.entity.*;
import com.voucher.manage2.tkmapper.mapper.*;
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
public class OperateConditionServiceBarImpl implements OperateConditionBarService {

    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private RoomassetsaccountingMapper accountingMapper;
    @Resource
    private RoomassetsledgerMapper ledgerMapper;

    @Override
    public String chartAddBarC(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roomassetsaccounting> roomassetsaccountings = accountingMapper.findAreaBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roomassetsaccounting roomassetsaccounting : roomassetsaccountings) {
            Date date = roomassetsaccounting.getAssetsaccountingdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //资产新增处数
            for (Roomassetsaccounting roomassetsaccounting : roomassetsaccountings) {
                Date date = roomassetsaccounting.getAssetsaccountingdate();    //日期
                if (date != null) {
                    String format = slf.format(date);
                    if (format.equals(s)) {
                        count1++;
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("资产新增处数");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "资产处数新增");
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
        log.info("资产新增---" + jsonObject);
        return string;
    }


    public String chartAddBarA(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roomassetsaccounting> roomassetsaccountings = accountingMapper.findAreaBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roomassetsaccounting roomassetsaccounting : roomassetsaccountings) {
            Date date = roomassetsaccounting.getAssetsaccountingdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : allMonth) {
            double count2 = 0; //到期新增面积
            for (Roomassetsaccounting roomassetsaccounting : roomassetsaccountings) {
                Date date = roomassetsaccounting.getAssetsaccountingdate();    //日期
                if (date != null) {
                    double area = roomassetsaccounting.getArea();
                    String format = slf.format(date);
                    if (format.equals(s)) {
                        count2 += area;
                    }
                }
            }
            list2.add(DoubleUtils.convert(count2) + "");
        }
        KeyObjDTO k2 = new KeyObjDTO();
        k2.setName("资产新增面积");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "资产面积新增");
        if (x != 1) {
            ArrayList<Object> arrayList2 = new ArrayList<>();
            List<Object> arr2 = DistinctUtils.arr(arrayList2, list2, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr2.add(0, year);
            k2.setValue(arr2);
        } else {
            k2.setValue(list2);
            map.put("date", allMonth);
        }
        map.put("data1", k2);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("资产新增---" + jsonObject);
        return string;
    }

    @Override
    public String chartCutBarC(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roomassetsledger> roomassetsledgers = ledgerMapper.findAreaBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roomassetsledger roomassetsledger : roomassetsledgers) {
            Date date = roomassetsledger.getAssetsledgerdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //资产减少处数
            for (Roomassetsledger roomassetsledger : roomassetsledgers) {
                Date date = roomassetsledger.getAssetsledgerdate();    //日期
                if (date != null) {
                    String format = slf.format(date);
                    if (format.equals(s)) {
                        count1++;
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("资产减少处数");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "资产处数减少");
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
        log.info("资产减少---" + jsonObject);
        return string;
    }

    public String chartCutBarA(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roomassetsledger> roomassetsledgers = ledgerMapper.findAreaBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roomassetsledger roomassetsledger : roomassetsledgers) {
            Date date = roomassetsledger.getAssetsledgerdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : allMonth) {
            double count2 = 0; //到期减少面积
            for (Roomassetsledger roomassetsledger : roomassetsledgers) {
                Date date = roomassetsledger.getAssetsledgerdate();    //日期
                if (date != null) {
                    double area = roomassetsledger.getArea();
                    String format = slf.format(date);
                    if (format.equals(s)) {
                        count2 += area;
                    }
                }
            }
            list2.add(DoubleUtils.convert(count2) + "");
        }
        KeyObjDTO k2 = new KeyObjDTO();
        k2.setName("资产减少面积");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "资产面积减少");
        if (x != 1) {
            ArrayList<Object> arrayList2 = new ArrayList<>();
            List<Object> arr2 = DistinctUtils.arr(arrayList2, list2, x);
            //拿到年份
            List<String> year = DistinctUtils.year(allMonth, x);
            arr2.add(0, year);
            k2.setValue(arr2);
        } else {
            k2.setValue(list2);
            map.put("date", allMonth);
        }
        map.put("data1", k2);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("资产减少---" + jsonObject);
        return string;
    }

    @Override
    public String noCertificateBar(String name, String column, List<String> requestList) {
        return null;
    }

    @Override
    public String pledgedBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roominfo> roominfos = roominfoMapper.findIsPawn();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo roominfo : roominfos) {
            Date indate = roominfo.getIndate();
            if (indate != null) {
                String format = slf.format(indate);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();

        for (String s : allMonth) {
            int count1 = 0; //已抵押
            for (Roominfo roominfo : roominfos) {
                Date indate = roominfo.getIndate();//日期
                if (indate != null) {
                    String ispawn = roominfo.getIspawn();
                    String format = slf.format(indate);
                    if (format.equals(s)) {
                        if ("是".equals(ispawn)) {
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("已抵押房产");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "已抵押房产");
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
        log.info("已抵押房产---" + jsonObject);
        return string;
    }

    @Override
    public String chartAddConBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 6) {
            name = "购买资产";
        } else if (i == 7) {
            name = "接收资产";
        } else if (i == 8) {
            name = "拆迁还房";
        } else if (i == 9) {
            name = "新建房产";
        } else {
            name = "代管资产";
        }

        List<Roomassetsaccounting> accountings = accountingMapper.findDateAndType();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();

        for (Roomassetsaccounting accounting : accountings) {
            Date date = accounting.getAssetsaccountingdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0;
            for (Roomassetsaccounting accounting : accountings) {
                Date date = accounting.getAssetsaccountingdate();    //日期
                if (date != null) {
                    String format = slf.format(date);
                    String type = accounting.getAssetsaccountingtype();        //房屋类型
                    if (format.equals(s)) {
                        if (name.equals(type)) {
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name);
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
        map.put("title", "租赁情况统计_租赁增加");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("租赁情况统计_租赁增加---" + jsonObject);
        return string;
    }

    @Override
    public String chartCutConBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 11) {
            name = "拆迁";
        } else if (i == 12) {
            name = "拆除";
        } else if (i == 13) {
            name = "划拨";
        } else if (i == 14) {
            name = "出售";
        } else {
            name = "灭失";
        }

        List<Roomassetsledger> roomassetsledgers = ledgerMapper.findDateAndType();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roomassetsledger roomassetsledger : roomassetsledgers) {
            Date date = roomassetsledger.getAssetsledgerdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0;
            for (Roomassetsledger roomassetsledger : roomassetsledgers) {
                Date date = roomassetsledger.getAssetsledgerdate();    //日期
                if (date != null) {
                    String format = slf.format(date);
                    String type = roomassetsledger.getAssetsledgertype();        //房屋类型
                    if (format.equals(s)) {
                        if (name.equals(type)) {
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }

        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name);
        HashMap<Object, Object> map = new HashMap<>();
        if (x != 1) {
            ArrayList<Object> arrayList1 = new ArrayList<>();
            List<Object> arr1 = DistinctUtils.arr(arrayList1, list1, x);
            List<String> year = DistinctUtils.year(allMonth, x);
            arr1.add(0, year);
            k1.setValue(arr1);
        } else {
            k1.setValue(list1);
            map.put("date", allMonth);
        }
        map.put("title", "租赁情况统计_租赁减少");
        map.put("data1", k1);

        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("租赁情况统计_租赁减少 ---" + jsonObject);
        return string;
    }

    @Override
    public String certificateConBar(String name, String column, List<String> requestList) {
        return null;
    }

    @Override
    public String cAreaAddBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 16) {
            name = "购买资产";
        } else if (i == 17) {
            name = "接收资产";
        } else if (i == 18) {
            name = "拆迁还房";
        } else if (i == 19) {
            name = "新建房产";
        } else {
            name = "代管资产";
        }

        List<Roomassetsaccounting> accountings = accountingMapper.findDateAndType();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();

        for (Roomassetsaccounting accounting : accountings) {
            Date date = accounting.getAssetsaccountingdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            double count1 = 0;
            for (Roomassetsaccounting accounting : accountings) {
                Date date = accounting.getAssetsaccountingdate();    //日期
                if (date != null) {
                    String format = slf.format(date);
                    String type = accounting.getAssetsaccountingtype();        //房屋类型
                    double area = accounting.getArea();
                    if (format.equals(s)) {
                        if (name.equals(type)) {
                            count1 += area;
                        }
                    }
                }
            }
            list1.add(DoubleUtils.convert(count1) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name);
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
        map.put("title", "租赁情况统计_租赁面积增加");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("租赁情况统计_租赁面积增加---" + jsonObject);
        return string;
    }

    @Override
    public String cAreaCutBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 11) {
            name = "拆迁";
        } else if (i == 12) {
            name = "拆除";
        } else if (i == 13) {
            name = "划拨";
        } else if (i == 14) {
            name = "出售";
        } else {
            name = "灭失";
        }
        List<Roomassetsledger> roomassetsledgers = ledgerMapper.findDateAndType();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        ArrayList<String> list = new ArrayList<>();
        for (Roomassetsledger roomassetsledger : roomassetsledgers) {
            Date date = roomassetsledger.getAssetsledgerdate();
            if (date != null) {
                String format = slf.format(date);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            double count1 = 0;
            for (Roomassetsledger roomassetsledger : roomassetsledgers) {
                Date date = roomassetsledger.getAssetsledgerdate();    //日期
                if (date != null) {
                    String format = slf.format(date);
                    String type = roomassetsledger.getAssetsledgertype();        //房屋类型
                    double area = roomassetsledger.getArea();
                    if (format.equals(s)) {
                        if (name.equals(type)) {
                            count1 += area;
                        }
                    }
                }
            }
            list1.add(DoubleUtils.convert(count1) + "");
        }

        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name);
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
        map.put("title", "租赁情况统计_租赁面积减少");
        map.put("data1", k1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        log.info("租赁情况统计_租赁面积减少 ---" + jsonObject);
        return string;
    }
}
