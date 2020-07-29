package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.service.AssetsConditionBarService;
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
public class AssetsConditionServiceBarImpl implements AssetsConditionBarService {
    @Resource
    private ChartinfoMapper chartinfoMapper;
    @Resource
    private RoominfoMapper roominfoMapper;

    @Override
    public String findCountBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roominfo> chartInfos = roominfoMapper.findCountBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        List<Date> concludeDate = chartinfoMapper.findConcludeDate();
        for (Date s : concludeDate) {
            if(s != null){
                list.add(slf.format(s));
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            int count1 = 0; //资产计数
            for (Roominfo chartInfo : chartInfos) {
                if (chartInfo != null) {
                    Date concludedate = chartInfo.getIndate();    //日期
                    if (concludedate != null) {
                        if (concludedate != null) {
                            String format = slf.format(concludedate);
                            if (format.equals(s)) {
                                count1++;
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("资产数量");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "资产数量");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String findAreaBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Roominfo> chartInfos = roominfoMapper.findAreaBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo chartInfo : chartInfos) {
            Date concludedate = chartInfo.getIndate();
            if (concludedate != null) {
                String format = slf.format(concludedate);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            double count1 = 0; //资产计数
            for (Roominfo chartInfo : chartInfos) {
                if (chartInfo != null) {
                    Date concludedate = chartInfo.getIndate();    //日期
                    if (concludedate != null) {
                        double area = chartInfo.getBuildarea();  //资产面积
                        String format = slf.format(concludedate);
                        if (format.equals(s)) {
                            count1 += area;
                        }
                    }
                }
            }
            list1.add(DoubleUtils.convert(count1) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("资产面积");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "资产面积");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String findChartBar(String name, String column, List<String> requestList) {
        //几年同列
        int x = Integer.parseInt(column);   //同列

        List<Chartinfo> chartInfos = chartinfoMapper.findCountBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Chartinfo chartInfo : chartInfos) {
            if (chartInfo != null) {
                Date concludedate = chartInfo.getConcludedate();
                if (concludedate != null) {
                    String format = slf.format(concludedate);
                    list.add(format);
                }
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //资产计数
            for (Chartinfo chartInfo : chartInfos) {
                if (chartInfo != null) {
                    Date concludedate = chartInfo.getConcludedate();    //日期
                    if (concludedate != null) {
                        String format = slf.format(concludedate);
                        if (format.equals(s)) {
                            count1++;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("合同数量");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "合同数量");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String findEarningsBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列

        List<Chartinfo> chartInfos = chartinfoMapper.findTotalHireBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Chartinfo chartInfo : chartInfos) {
            Date concludedate = chartInfo.getConcludedate();
            if (concludedate != null) {
                String format = slf.format(concludedate);
                list.add(format);
            }
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            double count1 = 0; //资产计数
            for (Chartinfo chartInfo : chartInfos) {
                Date concludedate = chartInfo.getConcludedate();    //日期
                if (concludedate != null) {
                    double totalhire = chartInfo.getTotalhire();
                    if (totalhire != 0) {
                        String format = slf.format(concludedate);
                        if (format.equals(s)) {
                            count1 += totalhire;
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("合同收益");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "合同收益");
        return JSONObject.fromObject(map).toString();
    }


    @Override
    public String findRoomPropertyBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 5) {
            name = "住宅房";
        } else if (i == 6) {
            name = "营业房";
        } else {
            name = "土地";
        }
        //  状态获取end
        List<Roominfo> chartInfos = roominfoMapper.findRoomProperty();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo chartInfo : chartInfos) {
            if (chartInfo != null) {
                Date concludedate = chartInfo.getIndate();
                String format = null;
                if (concludedate != null) {
                    format = slf.format(concludedate);
                }
                list.add(format);
            }

        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            if (s != null) {
                int count1 = 0;
                for (Roominfo chartInfo : chartInfos) {
                    Date concludedate = chartInfo.getIndate();    //日期
                    if (concludedate != null) {
                        String roomproperty = chartInfo.getRoomproperty();  //房屋类型
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
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name + "数量");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "资产总数量");
        return JSONObject.fromObject(map).toString();

    }


    @Override
    public String findRoomAreaBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 8) {
            name = "住宅房";
        } else if (i == 9) {
            name = "营业房";
        } else {
            name = "土地";
        }
        List<Roominfo> chartInfos = roominfoMapper.findAreaBar();
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Roominfo chartInfo : chartInfos) {
            String format = null;
            if (chartInfo != null) {
                Date concludedate = chartInfo.getIndate();
                if (concludedate != null) {
                    format = slf.format(concludedate);
                }
            }
            list.add(format);
        }
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            double count1 = 0;
            for (Roominfo chartInfo : chartInfos) {
                Date concludedate = chartInfo.getIndate();    //日期
                if (concludedate != null) {
                    String roomproperty = chartInfo.getRoomproperty();  //房屋类型
                    double area = chartInfo.getBuildarea();
                    String format = slf.format(concludedate);
                    if (format.equals(s)) {
                        if (name.equals(roomproperty)) {
                            count1 += area;
                        }
                    }
                }
            }
            list1.add(DoubleUtils.convert(count1) + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name + "面积");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "资产总面积");
        return JSONObject.fromObject(map).toString();
    }


    @Override
    public String findDataDictionaryBar() {
        return null;
    }

    @Override
    public String findStructureBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        int i = Integer.parseInt(name);
        if (i == 11) {
            name = "砖木";
        } else if (i == 12) {
            name = "砖混";
        } else if (i == 13) {
            name = "框架";
        } else if (i == 14) {
            name = "钢结构";
        } else {
            name = "其他";
        }
        List<Roominfo> roominfos = roominfoMapper.findStructure();
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
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            int count1 = 0; //砖木
            for (Roominfo roominfo : roominfos) {
                if (roominfo != null) {
                    Date indate = roominfo.getIndate();//日期
                    if (indate != null) {
                        String structure = roominfo.getStructure();//房屋类型
                        String format = slf.format(indate);
                        if (format.equals(s)) {
                            if (name.equals(structure)) {
                                count1++;
                            }
                        }
                    }
                }
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName(name);
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "资产结构");
        return JSONObject.fromObject(map).toString();
    }


}
