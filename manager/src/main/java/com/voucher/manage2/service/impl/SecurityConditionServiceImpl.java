package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.service.SecurityConditionService;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.HiddenCheckMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoHiddenItemMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class SecurityConditionServiceImpl implements SecurityConditionService {
    @Resource
    private HiddenCheckMapper hiddenCheckMapper;
    @Resource
    private RoominfoMapper roominfoMapper;

    @Override
    public String patrol() {
        int count = hiddenCheckMapper.findCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("巡查次数", count);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("巡查次数---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String hidDanger() {
        String date = DistinctUtils.nowYear();
        Integer hidDanger = roominfoMapper.hidDanger(date);
        HashMap<String, Object> map = new HashMap<>();
        map.put("隐患处数", hidDanger);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("隐患处数---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String abarbeitung() {
        String date = DistinctUtils.nowYear();
        Integer abarbeitung = roominfoMapper.abarbeitung(date);
        //隐患处数就是巡查异常处数
        HashMap<String, Object> map = new HashMap<>();
        map.put("正在整改", abarbeitung);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("正在整改---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String noAbarbeitung() {
        String date = DistinctUtils.nowYear();
        Integer s = roominfoMapper.noAbarbeitung(date);
        //隐患处数就是巡查异常处数
        HashMap<String, Object> map = new HashMap<>();
        map.put("未整改处数", s);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("未整改处数---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String dgRoom() {

        Integer s = roominfoMapper.dgRoom();
        if(s == null){
            s = 0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("危房处数", s);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("危房处数---" + jsonObject);
        String string = jsonObject.toString();
        return string;

    }


    @Override
    public String hidRate() {
        List<Roominfo> hiddenChecks = roominfoMapper.findCheckName();
        double count1 = hiddenChecks.size(); //全部
        double count2 = 0; //异常
        for (Roominfo roominfo : hiddenChecks) {
            if(roominfo != null){
                if(roominfo.getIshidden() > 0){
                    count2++;
                }
            }
        }
        double convert = 0;
        if(count1 != 0){
            convert = DoubleUtils.convert(count2/count1);
        }else {
            convert = 0;
        }
        //隐患处数就是巡查异常处数
        HashMap<String, Object> map = new HashMap<>();
        map.put("隐患率", convert);

        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("隐患率---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String abaRate() {
        List<Roominfo> hiddenChecks = roominfoMapper.findNeatenFlow();
        double count2 = 0; //正在整改
        double count1 = hiddenChecks.size();    //全部
        for (Roominfo roominfo : hiddenChecks) {
            if(roominfo != null) {
                if (roominfo.getNeatenFlow() > 0) {
                    count2++;
                }
            }
        }
        double convert = 0;
        if(count1 != 0){
            convert = DoubleUtils.convert(count2/count1);
        }else {
            convert = 0;
        }
        //隐患处数就是巡查异常处数
        HashMap<String, Object> map = new HashMap<>();
        map.put("整改率", convert);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("整改率---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String dgRoomRate() {
        List<Roominfo> roominfos = roominfoMapper.findDangerClassification();
        double count = roominfos.size();    //总房
        double count1 = 0;  //危房
        for (Roominfo roominfo : roominfos) {
            if(roominfo != null){
                String dangerclassification = roominfo.getDangerclassification();
                if("D级".equals(dangerclassification)){
                    count1++;
                }
            }
        }
        double convert = 0;
        if(count != 0){
            convert = DoubleUtils.convert(count1/count);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("危房率", convert);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("危房率---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String having() {

        String date = DistinctUtils.nowYear();
        Integer count1 = hiddenCheckMapper.findYiZhengGai(date);
        if(count1 == null){
            count1 = 0;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("整改完成", count1);
        return JSONArray.fromObject(map).toString();
    }

    @Override
    public String notDgRateBar() {
        Integer countAll = roominfoMapper.findAllRoom();   //总资产
        Integer count1 = roominfoMapper.findAllYinHuan();    //隐患资产
        if(countAll == null){
            countAll = 0;
        }
        if(count1 == null){
            count1 = 0;
        }
        KeyObjDTO keyObjDTO1 = new KeyObjDTO();
        keyObjDTO1.setName("隐患资产");
        keyObjDTO1.setValue(count1);
        KeyObjDTO keyObjDTO2 = new KeyObjDTO();
        keyObjDTO2.setName("无隐患资产");
        keyObjDTO2.setValue(countAll - count1);
        ArrayList<KeyObjDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyObjDTO1);
        keyVCountDTOs.add(keyObjDTO2);
        return JSONArray.fromObject(keyVCountDTOs).toString();
    }

    @Resource
    private RoominfoHiddenItemMapper roominfoHiddenItemMapper;

    @Override
    public String HavingRateBar() {
        Integer huoZai = roominfoHiddenItemMapper.findHuoZai();         //火灾隐患
        Integer roomStru = roominfoHiddenItemMapper.findRoomStru();     //房屋结构隐患
        Integer sheShi = roominfoHiddenItemMapper.findSheShi();         //配套设施隐患
        Integer natural = roominfoHiddenItemMapper.findNatural();       //自然灾害隐患
        if(huoZai == null){
            huoZai = 0;
        }
        if(roomStru == null){
            roomStru = 0;
        }
        if(sheShi == null){
            sheShi = 0;
        }
        if(natural == null){
            natural = 0;
        }
        KeyObjDTO keyObjDTO1 = new KeyObjDTO();
        keyObjDTO1.setName("火灾隐患");
        keyObjDTO1.setValue(huoZai);
        KeyObjDTO keyObjDTO2 = new KeyObjDTO();
        keyObjDTO2.setName("房屋结构隐患");
        keyObjDTO2.setValue(roomStru);
        KeyObjDTO keyObjDTO3 = new KeyObjDTO();
        keyObjDTO3.setName("配套设施隐患");
        keyObjDTO3.setValue(sheShi);
        KeyObjDTO keyObjDTO4 = new KeyObjDTO();
        keyObjDTO4.setName("自然灾害隐患");
        keyObjDTO4.setValue(natural);


        KeyObjDTO keyObjDTO5 = new KeyObjDTO();
        keyObjDTO5.setName("违章搭建隐患");
        keyObjDTO5.setValue(sheShi);
        KeyObjDTO keyObjDTO6 = new KeyObjDTO();
        keyObjDTO6.setName("其他隐患");
        keyObjDTO6.setValue(natural);

        List<KeyObjDTO> list = new ArrayList<>();
        list.add(keyObjDTO1);
        list.add(keyObjDTO2);
        list.add(keyObjDTO3);
        list.add(keyObjDTO4);
        list.add(keyObjDTO5);
        list.add(keyObjDTO6);
        return JSONArray.fromObject(list).toString();
    }

    @Override
    public String yinHuanRateBar() {
        String date = DistinctUtils.nowYear();
        Integer count2 = roominfoMapper.hidDanger(date);   //本年隐患资产数
        Integer count1 = hiddenCheckMapper.findYiZhengGai(date);  //本年整改完成的资产
        if(count2 == null){
            count2 = 0;
        }
        if(count1 == null){
            count1 = 0;
        }
        KeyObjDTO keyObjDTO1 = new KeyObjDTO();
        keyObjDTO1.setName("本年未整改完成的资产");
        keyObjDTO1.setValue(count2);
        KeyObjDTO keyObjDTO2 = new KeyObjDTO();
        keyObjDTO2.setName("本年整改完成的资产");
        keyObjDTO2.setValue(count1);
        ArrayList<KeyObjDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyObjDTO1);
        keyVCountDTOs.add(keyObjDTO2);
        return JSONArray.fromObject(keyVCountDTOs).toString();
    }
}
