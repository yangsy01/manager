package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.dto.KeyValueDTO;
import com.voucher.manage2.service.FinancialConditionService;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.ChartinfoMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class FinancialConditionServiceImpl implements FinancialConditionService {

    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private ChartinfoMapper chartinfoMapper;


    @Override
    public String emptyRoom() {
        Integer empty = roominfoMapper.findEmpty();
        HashMap<String, Object> map = new HashMap<>();
        map.put("空置房屋", empty);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("空置房屋---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    /**
     * 到期合同：定义为chartinfo表中的isHistory字段为1就是到期合同
     * isHistory字段:是否已经退租，false否0，true是1
     * @return
     */
    @Override
    public String contractDue() {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        String format = slf.format(new Date());
        Date parse = null;
        try {
            parse = slf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer count = chartinfoMapper.findExpire(parse);
        if(count == null){
            count = 0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("到期合同", count);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("到期合同---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String rentalHousing() {
        List<Roominfo> roominfos = roominfoMapper.findState();
        int count1 = 0; //已出租住宅房
        for (Roominfo roominfo : roominfos) {
            String state = roominfo.getState();
            String roomproperty = roominfo.getRoomproperty();
            if("已出租".equals(state)){
                if("住宅房".equals(roomproperty)){
                    count1++;
                }
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("已出租住宅房", count1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("已出租住宅房---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String rentalOffice() {
        List<Roominfo> roominfos = roominfoMapper.findState();
        int count1 = 0; //已出租营业房
        for (Roominfo roominfo : roominfos) {
            String state = roominfo.getState();
            String roomproperty = roominfo.getRoomproperty();
            if("已出租".equals(state)){
                if("营业房".equals(roomproperty)){
                    count1++;
                }
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("已出租营业房", count1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("已出租营业房---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String housingCon() {
        List<Roominfo> roominfos = roominfoMapper.findState();
        int count1 = 0; //已出租
        int count2 = 0; //空置
        int count3 = 0; //不可出租
        int count4 = 0; //不可出租2
        for (Roominfo roominfo : roominfos) {
            String state = roominfo.getState();
            String roomproperty = roominfo.getRoomproperty();
            if("住宅房".equals(roomproperty)){
                if("已出租".equals(state)){
                    count1++;
                }else if ("空置".equals(state)){
                    count2++;
                }else if("不可出租".equals(state) ){
                    count3++;
                }else if( "不可出租2".equals(state)){
                    count4++;
                }
            }
        }
        KeyVCountDTO keyVCountDTO1 = new KeyVCountDTO();
        keyVCountDTO1.setName("已出租");
        keyVCountDTO1.setValue(count1);
        KeyVCountDTO keyVCountDTO2 = new KeyVCountDTO();
        keyVCountDTO2.setName("空置");
        keyVCountDTO2.setValue(count2);
        KeyVCountDTO keyVCountDTO3 = new KeyVCountDTO();
        keyVCountDTO3.setName("不可出租");
        keyVCountDTO3.setValue(count3+count4);
        ArrayList<KeyVCountDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyVCountDTO1);
        keyVCountDTOs.add(keyVCountDTO2);
        keyVCountDTOs.add(keyVCountDTO3);
        JSONArray jsonArray = JSONArray.fromObject(keyVCountDTOs);
        log.info("住宅房屋情况---" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    @Override
    public String officeCon() {
        List<Roominfo> roominfos = roominfoMapper.findState();
        int count1 = 0; //已出租
        int count2 = 0; //空置
        int count3 = 0; //不可出租
        int count4 = 0; //不可出租2
        for (Roominfo roominfo : roominfos) {
            String state = roominfo.getState();
            String roomproperty = roominfo.getRoomproperty();
            if("营业房".equals(roomproperty)){
                if("已出租".equals(state)){
                    count1++;
                }else if ("空置".equals(state)){
                    count2++;
                }else if("不可出租".equals(state) ){
                    count3++;
                }else if( "不可出租2".equals(state) ){
                    count4++;
                }
            }
        }
        KeyVCountDTO keyVCountDTO1 = new KeyVCountDTO();
        keyVCountDTO1.setName("已出租");
        keyVCountDTO1.setValue(count1);
        KeyVCountDTO keyVCountDTO2 = new KeyVCountDTO();
        keyVCountDTO2.setName("空置");
        keyVCountDTO2.setValue(count2);
        KeyVCountDTO keyVCountDTO3 = new KeyVCountDTO();
        keyVCountDTO3.setName("不可出租");
        keyVCountDTO3.setValue(count3+count4);
        ArrayList<KeyVCountDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyVCountDTO1);
        keyVCountDTOs.add(keyVCountDTO2);
        keyVCountDTOs.add(keyVCountDTO3);
        JSONArray jsonArray = JSONArray.fromObject(keyVCountDTOs);
        log.info("营业房屋情况---" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    @Override
    public String rentReviseCon() {
        int count1 = 0; //已出租
        int count2 = 0; //空置
        int count3 = 0; //不可出租
        int count4 = 0; //不可出租2
        List<CountAndSum> roomPCountAndSum = roominfoMapper.findRoomNature();
        for (CountAndSum countAndSum : roomPCountAndSum) {
            String name = countAndSum.getName();
            Integer sumD = countAndSum.getCountD();
            if(sumD == null){
                sumD = 0;
            }
            if("已出租".equals(name)){
                count1 = sumD;
            }
            if("空置".equals(name)){
                count2 = sumD;
            }
            if("不可出租".equals(name)  ){
                count3 = sumD;
            }
            if( "不可出租2".equals(name) ){
                count4 = sumD;
            }
        }

        KeyVCountDTO k1 = new KeyVCountDTO();
        k1.setName("已出租");
        k1.setValue(count1);
        KeyVCountDTO k2 = new KeyVCountDTO();
        k2.setName("空置");
        k2.setValue(count2);
        KeyVCountDTO k3 = new KeyVCountDTO();
        k3.setName("不可出租");
        k3.setValue(count3+count4);
        ArrayList<KeyVCountDTO> arrayList = new ArrayList<>();
        arrayList.add(k1);
        arrayList.add(k2);
        arrayList.add(k3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        String string = jsonArray.toString();
        log.info("租赁处数情况---" + jsonArray);
        return string;
    }

    @Override
    public String rentAreaCon() {
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        List<CountAndSum> roomPCountAndSum = roominfoMapper.findRoomNature();
        for (CountAndSum countAndSum : roomPCountAndSum) {
            String name = countAndSum.getName();
            Double sumD = countAndSum.getSumD();
            if(sumD == null){
                sumD = 0.0;
            }
            if("已出租".equals(name)){
                count1 = sumD;
            }
            if("空置".equals(name)){
                count2 = sumD;
            }
            if("不可出租".equals(name)){
                count3 = sumD;
            }
        }

        KeyValueDTO k1 = new KeyValueDTO();
        k1.setName("已出租");
        k1.setValue(DoubleUtils.convert(count1));
        KeyValueDTO k2 = new KeyValueDTO();
        k2.setName("空置");
        k2.setValue(DoubleUtils.convert(count2));
        KeyValueDTO k3 = new KeyValueDTO();
        k3.setName("不可出租");
        k3.setValue(DoubleUtils.convert(count3));
        ArrayList<KeyValueDTO> arrayList = new ArrayList<>();
        arrayList.add(k1);
        arrayList.add(k2);
        arrayList.add(k3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        String string = jsonArray.toString();
        log.info("租赁面积情况---" + jsonArray);
        return string;
    }
}
