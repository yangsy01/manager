package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.roomInfo.DataList;
import com.voucher.manage2.dto.roomInfo.DataNumber;
import com.voucher.manage2.dto.roomInfo.DataNumberDto;
import com.voucher.manage2.service.DataAnalysisService;
import com.voucher.manage2.tkmapper.mapper.ChartinfoMapper;
import com.voucher.manage2.tkmapper.mapper.HiddenCheckMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DoubleUtils;
import com.voucher.manage2.utils.HistogramUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Resource
    private ChartinfoMapper chartinfoMapper;
    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private HiddenCheckMapper hiddenCheckMapper;
    @Resource
    private HiddenCheckMapper checkMapper;

    @Override
    public String findCountBar(String name, String column, List<String> requestList) {
        /*int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String date : allMonth) {
            //资产计数
            Date parse = returnDate(date);
            Integer count1 = roominfoMapper.findCountByNow(parse);  //过去到现在的所有数据
            if (count1 == null) {
                count1 = 0;
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("资产数量");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "资产数量");*/

        List<DataList> dataList=roominfoMapper.dataNumber();

        DataNumberDto dataNumberDto=new DataNumberDto();
        DataNumber dataNumber=new DataNumber();


        List dateList=new ArrayList();
        List numberList=new ArrayList();

        for(DataList list:dataList){
            //时间戳转时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String data = sdf.format(new Date(list.getInDate().getTime()));
            dateList.add(data);
            numberList.add(list.getNumber());

		}
        dataNumber.setValue(numberList);
        dataNumberDto.setDate(dateList);
        dataNumberDto.setData1(dataNumber);
        dataNumberDto.setTitle("资产数量");

        return JSONObject.fromObject(dataNumberDto).toString();
    }

    @Override
    public String findAreaBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String date : allMonth) {
            //资产计数
            Date parse = returnDate(date);
            Double count1 = roominfoMapper.findAreaByNow(parse);  //过去到现在的所有数据
            if (count1 == null) {
                count1 = 0.0;
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
        List<Date> dates = chartinfoMapper.findConcludeDate();
        List<String> list = returnList(dates);

        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String date : allMonth) {
            //合同计数
            Date parse = returnDate(date);
            Integer count1 = chartinfoMapper.findCountByNow(parse);
            if (count1 == null) {
                count1 = 0;
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

        List<Date> dates = chartinfoMapper.findConcludeDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String date : allMonth) {
            Date parse = returnDate(date);
            Double count1 = chartinfoMapper.findTotalHireByNow(parse);
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("合同收益");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "合同收益");
        return JSONObject.fromObject(map).toString();

    }


    //===========安全数据柱状图================

    @Override
    public String patrolBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = checkMapper.findDate();
        List<String> list = returnList(dates);

        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Date date = returnDate(s);
            Integer count1 = hiddenCheckMapper.xunCha(date);
            if(count1 == null){
                count1 = 0;
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("巡查处数");

        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "巡查处数");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String hidDangerBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        //根据不重复的年月进行判断
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : allMonth) {
            Date date = returnDate(s);
            Integer count1 = roominfoMapper.findYinHuanBy(date);
            if(count1 == null){
                count1 = 0;
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("隐患处数");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "隐患处数");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String abarbeitungBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            Date date = returnDate(s);
            Integer count1 =  roominfoMapper.findZhengZaiZG(date);
            if(count1 == null){
                count1 = 0;
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("正在整改");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "正在整改");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String noAbarbeitungBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);

        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            Date date = returnDate(s);
            Integer count1 =  roominfoMapper.findWeiZG(date);
            if(count1 == null){
                count1 = 0;
            }
            list1.add(count1 + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("未整改处数");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "未整改处数");
        return JSONObject.fromObject(map).toString();
    }


    @Override
    public String notDgRateBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String s : allMonth) {
            Date parse = returnDate(s);
            Integer count2 = roominfoMapper.findCountByNow(parse);      //总资产
            Integer count1 = roominfoMapper.findYinHuanByNow(parse);    //隐患资产
            if (count1 == null) {
                count1 = 0;
            }
            if (count2 == null) {
                count2 = 0;
            }
            if (count2 != 0) {
                double c = count2 - count1;
                double bc = count2;
                double convert = DoubleUtils.convert1(c / bc);
                list1.add(convert + "");
            }
            else {
                list1.add(0.0+"");
            }
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("无隐患资产占比");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "无隐患资产占比");
        return JSONObject.fromObject(map).toString();
    }

    @Override
    public String HavingRateBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String date : allMonth) {
            Date parse = returnDate(date);
            Integer count2 = roominfoMapper.findCountByNow(parse);   //总资产
            Integer count1 = roominfoMapper.findYinHuanByNow(parse);    //隐患资产
            if (count1 == null) {
                count1 = 0;
            }
            if (count2 == null) {
                count2 = 0;
            }
            double convert = 0;
            if (count2 == 0) {
                convert = 0;
            } else {
                double c = count1;
                double bc = count2;
                convert = DoubleUtils.convert1(c / bc);
            }
            list1.add(convert + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("隐患资产占比");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "隐患资产占比");
        return JSONObject.fromObject(map).toString();
    }


    @Override
    public String yinHuanRateBar(String name, String column, List<String> requestList) {
        int x = Integer.parseInt(column);   //同列
        List<Date> dates = roominfoMapper.findDate();
        List<String> list = returnList(dates);
        //将所有的年+月存入到不重复newList中
        List<String> allMonth = HistogramUtils.returnList(x, list, requestList);
        ArrayList<String> list1 = new ArrayList<>();
        //根据不重复的年月进行判断
        for (String date : allMonth) {
            Date parse = returnDate(date);
            Integer count2 = roominfoMapper.findYinHuanByNow(parse);   //当前隐患资产数
            Integer count1 = hiddenCheckMapper.findYiZhengGaiByNow(parse);  //整改完成的资产
            if (count1 == null) {
                count1 = 0;
            }
            if (count2 == null) {
                count2 = 0;
            }
            double convert = 0;
            if (count2 == 0) {
                convert = 0;
            } else {
                double c = count1;
                double bc = count2;
                convert = DoubleUtils.convert1(c / bc);
            }
            list1.add(convert + "");
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("本年已整改隐患占比");
        HashMap<Object, Object> map = HistogramUtils.returnMap(x, list1, allMonth, k1, "本年已整改隐患占比");
        return JSONObject.fromObject(map).toString();
    }

    private static Date returnDate(String date) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        String str = date + "-01";
        Date parse = null;
        try {
            parse = slf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    private static List<String> returnList(List<Date> dates) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<>();
        for (Date date : dates) {
            list.add(slf.format(date));
        }
        return list;
    }

}
