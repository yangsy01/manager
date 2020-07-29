package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.service.OperateConditionService;
import com.voucher.manage2.tkmapper.entity.*;
import com.voucher.manage2.tkmapper.mapper.*;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OperateConditionServiceImpl implements OperateConditionService {

    @Resource
    private RoominfoMapper roominfoMapper;

    @Resource
    private RoomassetsaccountingMapper accountingMapper;
    @Resource
    private RoomassetsledgerMapper ledgerMapper;

    @Override
    public String chartAdd() {
        String nowYear = DistinctUtils.nowYear();   //当前年
        Integer count = accountingMapper.findCount(nowYear);
        Double areaCount = accountingMapper.findAreaCount(nowYear);
        if(count == null){
            count = 0;
        }
        if(areaCount == null){
            areaCount = 0.0;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("资产新增处数", count);
        map.put("资产新增面积", DoubleUtils.convert(areaCount));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("资产新增---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String chartCut() {
        String nowYear = DistinctUtils.nowYear();   //当前年
        Integer count = ledgerMapper.findCount(nowYear);
        Double areaCount = ledgerMapper.findAreaCount(nowYear);
        if(count == null){
            count = 0;
        }
        if(areaCount == null){
            areaCount = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("资产减少处数", count);
        map.put("资产减少面积", DoubleUtils.convert(areaCount));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("资产减少---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String noCertificate() {
        Integer count = roominfoMapper.findWeiBan(); //双证均无
        Double area = roominfoMapper.findWeiBanArea();

        if(count == null){
            count = 0;
        }
        if(area == null){
            area = 0.0;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("双证均无", count);
        map.put("双证均无面积", DoubleUtils.convert(area));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("双证均无---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String pledged() {
        List<Roominfo> roominfos = roominfoMapper.findIsPawn();
        int count1 = 0; //抵押房屋数
        double countA1 = 0; //抵押房屋数
        for (Roominfo roominfo : roominfos) {
            String ispawn = roominfo.getIspawn();
            if("是".equals(ispawn)){
                Double buildarea = roominfo.getBuildarea();
                if(buildarea == null){
                    buildarea = 0.0;
                }
                count1++;
                countA1+=buildarea;
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("已抵押房产数", count1);
        map.put("已抵押房产面积", countA1);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("已抵押房产数---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    @Override
    public String chartAddCon() {
        String nowYear = DistinctUtils.nowYear();   //当前年
        List<Roomassetsaccounting> accountings = accountingMapper.findAccountingType(nowYear);
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        for (Roomassetsaccounting accounting : accountings) {
            String assetsaccountingtype = accounting.getAssetsaccountingtype();
            if("购买资产".equals(assetsaccountingtype)){
                count1++;
            }
            else if("接收资产".equals(assetsaccountingtype)){
                count2++;
            }
            else if("拆迁还房".equals(assetsaccountingtype)){
                count3++;
            }
            else if("新建房产".equals(assetsaccountingtype)){
                count4++;
            }
            else if("代管资产".equals(assetsaccountingtype)){
                count5++;
            }
        }
        KeyVCountDTO keyVCountDTO1 = new KeyVCountDTO();
        keyVCountDTO1.setName("购买资产");
        keyVCountDTO1.setValue(count1);
        KeyVCountDTO keyVCountDTO2 = new KeyVCountDTO();
        keyVCountDTO2.setName("接收资产");
        keyVCountDTO2.setValue(count2);
        KeyVCountDTO keyVCountDTO3 = new KeyVCountDTO();
        keyVCountDTO3.setName("拆迁还房");
        keyVCountDTO3.setValue(count3);
        KeyVCountDTO keyVCountDTO4 = new KeyVCountDTO();
        keyVCountDTO4.setName("新建房产");
        keyVCountDTO4.setValue(count4);
        KeyVCountDTO keyVCountDTO5 = new KeyVCountDTO();
        keyVCountDTO5.setName("代管资产");
        keyVCountDTO5.setValue(count5);
        ArrayList<KeyVCountDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyVCountDTO1);
        keyVCountDTOs.add(keyVCountDTO2);
        keyVCountDTOs.add(keyVCountDTO3);
        keyVCountDTOs.add(keyVCountDTO4);
        keyVCountDTOs.add(keyVCountDTO5);
        JSONArray jsonArray = JSONArray.fromObject(keyVCountDTOs);
        log.info("资产处数增加情况---" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    @Override
    public String chartCutCon() {
        String nowYear = DistinctUtils.nowYear();   //当前年
        List<Roomassetsledger> roomassetsledgers = ledgerMapper.findLedgerType(nowYear);
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        for (Roomassetsledger roomassetsledger : roomassetsledgers) {
            String assetsledgertype = roomassetsledger.getAssetsledgertype();
            if("拆迁".equals(assetsledgertype)){
                count1++;
            }
            else if("拆除".equals(assetsledgertype)){
                count2++;
            }
            else if("划拨".equals(assetsledgertype)){
                count3++;
            }
            else if("出售".equals(assetsledgertype)){
                count4++;
            }
            else if("灭失".equals(assetsledgertype)){
                count5++;
            }
        }
        KeyVCountDTO keyVCountDTO1 = new KeyVCountDTO();
        keyVCountDTO1.setName("拆迁");
        keyVCountDTO1.setValue(count1);
        KeyVCountDTO keyVCountDTO2 = new KeyVCountDTO();
        keyVCountDTO2.setName("拆除");
        keyVCountDTO2.setValue(count2);
        KeyVCountDTO keyVCountDTO3 = new KeyVCountDTO();
        keyVCountDTO3.setName("划拨");
        keyVCountDTO3.setValue(count3);
        KeyVCountDTO keyVCountDTO4 = new KeyVCountDTO();
        keyVCountDTO4.setName("出售");
        keyVCountDTO4.setValue(count4);
        KeyVCountDTO keyVCountDTO5 = new KeyVCountDTO();
        keyVCountDTO5.setName("灭失");
        keyVCountDTO5.setValue(count5);
        ArrayList<KeyVCountDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyVCountDTO1);
        keyVCountDTOs.add(keyVCountDTO2);
        keyVCountDTOs.add(keyVCountDTO3);
        keyVCountDTOs.add(keyVCountDTO4);
        keyVCountDTOs.add(keyVCountDTO5);
        JSONArray jsonArray = JSONArray.fromObject(keyVCountDTOs);
        log.info("资产处数减少情况---" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    @Override
    public String certificateCon() {
        List<Roominfo> roominfos = roominfoMapper.findCertificate();
//        int count1 = 0; //不动产权证
//        int count2 = 0; //双证齐全
//        int count3 = 0; //单有房产证
//        int count4 = 0; //单有土地证
//        int count5 = 0; //未办证
        Map<String,Object> map1 = roominfoMapper.findRealEstateNo();     //不动产权证
        Map<String,Object> map2 = roominfoMapper.findTwo();              //双证齐全
        Map<String,Object> map3 = roominfoMapper.findPropertyRightNo();  //单有房产证
        Map<String,Object> map4 = roominfoMapper.findGlebeCardNo();      //单有土地证
        Map<String,Object> map5 = roominfoMapper.findNot();              //未办证

        Integer allCount1 = (Integer) map1.get("allCount");
        Integer allCount2 = (Integer) map2.get("allCount");
        Integer allCount3 = (Integer) map3.get("allCount");
        Integer allCount4 = (Integer) map4.get("allCount");
        Integer allCount5 = (Integer) map5.get("allCount");

        KeyVCountDTO keyVCountDTO1 = new KeyVCountDTO();
        keyVCountDTO1.setName("有不动产权证");
        keyVCountDTO1.setValue(allCount1);
        KeyVCountDTO keyVCountDTO2 = new KeyVCountDTO();
        keyVCountDTO2.setName("双证齐全");
        keyVCountDTO2.setValue(allCount2);
        KeyVCountDTO keyVCountDTO3 = new KeyVCountDTO();
        keyVCountDTO3.setName("单有房产证");
        keyVCountDTO3.setValue(allCount3);
        KeyVCountDTO keyVCountDTO4 = new KeyVCountDTO();
        keyVCountDTO4.setName("单有土地证");
        keyVCountDTO4.setValue(allCount4);
        KeyVCountDTO keyVCountDTO5 = new KeyVCountDTO();
        keyVCountDTO5.setName("双证均无");
        keyVCountDTO5.setValue(allCount5);

        ArrayList<KeyVCountDTO> k = new ArrayList<>();
        k.add(keyVCountDTO1);
        k.add(keyVCountDTO2);
        k.add(keyVCountDTO3);
        k.add(keyVCountDTO4);
        k.add(keyVCountDTO5);
        JSONArray jsonArray = JSONArray.fromObject(k);
        String string = jsonArray.toString();
        System.out.println("权证办理情况---" + jsonArray);
        return string;
    }

    @Override
    public String cAreaAdd() {
        String nowYear = DistinctUtils.nowYear();   //当前年
        List<Roomassetsaccounting> accountings = accountingMapper.findAccountingType(nowYear);
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        double count5 = 0;
        for (Roomassetsaccounting accounting : accountings) {
            String assetsaccountingtype = accounting.getAssetsaccountingtype();
            double a = accounting.getArea();
            if("购买资产".equals(assetsaccountingtype)){
                count1 += a;
            }
            else if("接收资产".equals(assetsaccountingtype)){
                count2 += a;
            }
            else if("拆迁还房".equals(assetsaccountingtype)){
                count3 += a;
            }
            else if("新建房产".equals(assetsaccountingtype)){
                count4 += a;
            }
            else if("代管资产".equals(assetsaccountingtype)){
                count5 += a;
            }
        }
        KeyObjDTO keyObjDTO1 = new KeyObjDTO();
        keyObjDTO1.setName("购买资产");
        keyObjDTO1.setValue(DoubleUtils.convert(count1));
        KeyObjDTO keyObjDTO2 = new KeyObjDTO();
        keyObjDTO2.setName("接收资产");
        keyObjDTO2.setValue(DoubleUtils.convert(count2));
        KeyObjDTO keyObjDTO3 = new KeyObjDTO();
        keyObjDTO3.setName("拆迁还房");
        keyObjDTO3.setValue(DoubleUtils.convert(count3));
        KeyObjDTO keyObjDTO4 = new KeyObjDTO();
        keyObjDTO4.setName("新建房产");
        keyObjDTO4.setValue(DoubleUtils.convert(count4));
        KeyObjDTO keyObjDTO5 = new KeyObjDTO();
        keyObjDTO5.setName("代管资产");
        keyObjDTO5.setValue(DoubleUtils.convert(count5));
        ArrayList<KeyObjDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyObjDTO1);
        keyVCountDTOs.add(keyObjDTO2);
        keyVCountDTOs.add(keyObjDTO3);
        keyVCountDTOs.add(keyObjDTO4);
        keyVCountDTOs.add(keyObjDTO5);
        JSONArray jsonArray = JSONArray.fromObject(keyVCountDTOs);
        log.info("资产处数增加情况---" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    @Override
    public String cAreaCut() {
        String nowYear = DistinctUtils.nowYear();   //当前年
        List<Roomassetsledger> roomassetsledgers = ledgerMapper.findLedgerType(nowYear);
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        double count5 = 0;
        for (Roomassetsledger roomassetsledger : roomassetsledgers) {
            String assetsledgertype = roomassetsledger.getAssetsledgertype();
            double a = roomassetsledger.getArea();
            if("拆迁".equals(assetsledgertype)){
                count1 += a;
            }
            else if("拆除".equals(assetsledgertype)){
                count2 += a;
            }
            else if("划拨".equals(assetsledgertype)){
                count3 += a;
            }
            else if("出售".equals(assetsledgertype)){
                count4 += a;
            }
            else if("灭失".equals(assetsledgertype)){
                count5 += a;
            }
        }
        KeyObjDTO keyObjDTO1 = new KeyObjDTO();
        keyObjDTO1.setName("拆迁");
        keyObjDTO1.setValue(DoubleUtils.convert(count1));
        KeyObjDTO keyObjDTO2 = new KeyObjDTO();
        keyObjDTO2.setName("拆除");
        keyObjDTO2.setValue(DoubleUtils.convert(count2));
        KeyObjDTO keyObjDTO3 = new KeyObjDTO();
        keyObjDTO3.setName("划拨");
        keyObjDTO3.setValue(DoubleUtils.convert(count3));
        KeyObjDTO keyObjDTO4 = new KeyObjDTO();
        keyObjDTO4.setName("出售");
        keyObjDTO4.setValue(DoubleUtils.convert(count4));
        KeyObjDTO keyObjDTO5 = new KeyObjDTO();
        keyObjDTO5.setName("灭失");
        keyObjDTO5.setValue(DoubleUtils.convert(count5));
        ArrayList<KeyObjDTO> keyVCountDTOs = new ArrayList<>();
        keyVCountDTOs.add(keyObjDTO1);
        keyVCountDTOs.add(keyObjDTO2);
        keyVCountDTOs.add(keyObjDTO3);
        keyVCountDTOs.add(keyObjDTO4);
        keyVCountDTOs.add(keyObjDTO5);

        JSONArray jsonArray = JSONArray.fromObject(keyVCountDTOs);
        log.info("资产处数减少情况---" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    @Override
    public String certConArea() {
        Map<String,Object> map1 = roominfoMapper.findRealEstateNo();     //不动产权证
        Map<String,Object> map2 = roominfoMapper.findTwo();              //双证齐全
        Map<String,Object> map3 = roominfoMapper.findPropertyRightNo();  //单有房产证
        Map<String,Object> map4 = roominfoMapper.findGlebeCardNo();      //单有土地证
        Map<String,Object> map5 = roominfoMapper.findNot();              //未办证

        Double allCount1 = (Double) map1.get("allArea");
        Double allCount2 = (Double) map2.get("allArea");
        Double allCount3 = (Double) map3.get("allArea");
        Double allCount4 = (Double) map4.get("allArea");
        Double allCount5 = (Double) map5.get("allArea");
        if(allCount1 == null){
            allCount1 = 0.0;
        }
        if(allCount2 == null){
            allCount2 = 0.0;
        }
        if(allCount3 == null){
            allCount3 = 0.0;
        }
        if(allCount4 == null){
            allCount4 = 0.0;
        }
        if(allCount5 == null){
            allCount5 = 0.0;
        }
        KeyObjDTO keyVCountDTO1 = new KeyObjDTO();
        keyVCountDTO1.setName("有不动产权证");
        keyVCountDTO1.setValue(DoubleUtils.convert(allCount1));
        KeyObjDTO keyVCountDTO2 = new KeyObjDTO();
        keyVCountDTO2.setName("双证齐全");
        keyVCountDTO2.setValue(DoubleUtils.convert(allCount2));
        KeyObjDTO keyVCountDTO3 = new KeyObjDTO();
        keyVCountDTO3.setName("单有房产证");
        keyVCountDTO3.setValue(DoubleUtils.convert(allCount3));
        KeyObjDTO keyVCountDTO4 = new KeyObjDTO();
        keyVCountDTO4.setName("单有土地证");
        keyVCountDTO4.setValue(DoubleUtils.convert(allCount4));
        KeyObjDTO keyVCountDTO5 = new KeyObjDTO();
        keyVCountDTO5.setName("双证均无");
        keyVCountDTO5.setValue(DoubleUtils.convert(allCount5));

        ArrayList<KeyObjDTO> k = new ArrayList<>();
        k.add(keyVCountDTO1);
        k.add(keyVCountDTO2);
        k.add(keyVCountDTO3);
        k.add(keyVCountDTO4);
        k.add(keyVCountDTO5);
        return JSONArray.fromObject(k).toString();
    }
}
