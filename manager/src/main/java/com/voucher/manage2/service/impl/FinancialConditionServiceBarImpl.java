package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.service.FinancialConditionBarService;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.ChartinfoMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
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
public class FinancialConditionServiceBarImpl implements FinancialConditionBarService {
    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private ChartinfoMapper chartinfoMapper;

    @Override
    public String emptyRoomBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roominfo> roominfos = roominfoMapper.findEmptyRoom();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //资产计数
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                String state = roominfo.getState();
                if (concludedate != null) {
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if ("空置".equals(state)) {
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("空置房屋");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "空置房屋");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String contractDueBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Chartinfo> chartInfos = chartinfoMapper.findIsHistory();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnChartList(chartInfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //到期合同
            for (Chartinfo chartInfo : chartInfos) {
                if(chartInfo != null){
                    Date concludedate = chartInfo.getConcludedate();
                    if(concludedate != null){
                        String format = slf.format(concludedate);
                        if(s.equals(format)){
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("到期合同");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "到期合同");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String rentalHousingBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> roominfos = roominfoMapper.findState();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //资产计数
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                String state = roominfo.getState();         //房屋出租状态
                if (concludedate != null) {
                    String roomproperty = roominfo.getRoomproperty();   //住宅，营业
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if ("已出租".equals(state)) {
                            if ("住宅房".equals(roomproperty)) {
                                count1++;
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("已出租住宅房");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "已出租住宅房");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String rentalOfficeBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Roominfo> roominfos = roominfoMapper.findState();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //资产计数
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                String state = roominfo.getState();         //房屋出租状态
                if (concludedate != null) {
                    String roomproperty = roominfo.getRoomproperty();   //住宅，营业
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if ("已出租".equals(state)) {
                            if ("营业房".equals(roomproperty)) {
                                count1++;
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("已出租营业房");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "已出租营业房");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String housingConBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 5) {
            name = "空置";
        } else if (i == 6) {
            name = "已出租";
        } else {
            name = "不可出租";
        }
        List<Roominfo> roominfos = roominfoMapper.findState();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                if (concludedate != null) {
                    String state = roominfo.getState();         //房屋出租状态
                    String roomproperty = roominfo.getRoomproperty();   //住宅，营业
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if ("住宅房".equals(roomproperty)) {
                            if (name.equals(state)) {
                                count1++;
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name + "处数");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "住宅房屋情况");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String officeConBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 8) {
            name = "空置";
        } else if (i == 9) {
            name = "已出租";
        } else {
            name = "不可出租";
        }
        List<Roominfo> roominfos = roominfoMapper.findState();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                if (concludedate != null) {
                    String state = roominfo.getState();         //房屋出租状态
                    String roomproperty = roominfo.getRoomproperty();   //住宅，营业
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if ("营业房".equals(roomproperty)) {
                            if (name.equals(state)) {
                                count1++;
                            }

                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name + "处数");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "营业房屋情况");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String rentReviseConBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 11) {
            name = "住宅房";
        } else if (i == 12) {
            name = "营业房";
        } else {
            name = "土地";
        }

        List<Roominfo> roominfos = roominfoMapper.findState();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            int count1 = 0;
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                if (concludedate != null) {
                    String roomproperty = roominfo.getRoomproperty();   //住宅，营业，土地
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if (name.equals(roomproperty)) {
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name + "处数");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "租赁处数情况");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String rentAreaConBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 14) {
            name = "住宅房";
        } else if (i == 15) {
            name = "营业房";
        } else {
            name = "土地";
        }

        List<Roominfo> roominfos = roominfoMapper.findState();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        //得到时间集合
        List<String> list = HistogramUtils.returnDateList(roominfos);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            double count1 = 0; //住宅房面积
            for (Roominfo roominfo : roominfos) {
                Date concludedate = roominfo.getIndate();    //日期
                if (concludedate != null) {
                    String roomproperty = roominfo.getRoomproperty();   //住宅，营业，其他
                    double buildarea = roominfo.getBuildarea();
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if (name.equals(roomproperty)) {
                            count1 += buildarea;
                        }
                    }
                }
            }
            list1.add(DoubleUtils.convert(count1) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name + "面积");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "租赁面积情况");
        return JSONObject.fromObject(map).toString();
    }
}
