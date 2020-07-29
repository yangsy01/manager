package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.service.AssetsConditionService;
import com.voucher.manage2.tkmapper.entity.Datadictionary;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.mapper.DatadictionaryMapper;
import com.voucher.manage2.tkmapper.mapper.HirelistMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.DoubleUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 资产状况
 */
@Service
@Slf4j
public class AssetsConditionServiceImpl implements AssetsConditionService {

    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private DatadictionaryMapper datadictionaryMapper;
    @Resource
    private HirelistMapper hirelistMapper;


    /**
     * 资产总数量
     *
     * @return
     */
    @Override
    public String findChartInfoCount() {
        int i = roominfoMapper.findCountRoomInfo();
        HashMap<String, Object> map = new HashMap<>();
        map.put("count", i);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("资产总数量---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    /**
     * 资产总面积
     *
     * @return
     */
    @Override
    public String findChartInfoArea() {
        List<Roominfo> list = roominfoMapper.areaCount();
        double count =  0;
        for (Roominfo roominfo : list) {
            double buildarea = roominfo.getBuildarea();
            count += buildarea;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("allCount", DoubleUtils.convert(count));
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("资产总面积---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    /**
     * 合同总户数
     *
     * @return
     */
    @Override
    public String findChartInfoUsers() {
        Integer count = roominfoMapper.findCountChart();
        HashMap<String, Object> map = new HashMap<>();
        map.put("count", count);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("合同总户数---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    /**
     * 当年总收入
     * @return
     */
    @Override
    public String findChartInfoEarnings() {
        String nowYear = DistinctUtils.nowYear();
        String yearFirst = nowYear + "-01-01";
        String yearLast = (Integer.parseInt(nowYear)+1) + "-01-01";
        Double allHire = hirelistMapper.findAllHire(yearFirst,yearLast);
        if(allHire == null){
            allHire = 0.0;
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);//这里是小数位
        String format = df.format(allHire);
        String removeStr = ",";//去掉千分符号
        String replace = format.replace(removeStr, "");

        HashMap<String, Object> map = new HashMap<>();
        map.put("count", replace);
        JSONObject jsonObject = JSONObject.fromObject(map);
        log.info("出租总收益---" + jsonObject);
        String string = jsonObject.toString();
        return string;
    }

    /**
     * 资产数量
     * @return
     */
    @Override
    public String findRoomProperty() {
        List<Roominfo> chartinfos = roominfoMapper.findRoomProperty();
        int count1 = 0; //住宅房
        int count2 = 0; //营业房
        int count3 = 0; //土地

        for (Roominfo chartinfo : chartinfos) {
            String roomproperty = chartinfo.getRoomproperty();
            if("住宅房".equals(roomproperty)){
                count1++;
            }
            else if("营业房".equals(roomproperty)){
                count2++;
            }
            else if("土地".equals(roomproperty) ){
                count3++;
            }
        }
        KeyVCountDTO k1 = new KeyVCountDTO();
        k1.setName("住宅房");
        k1.setValue(count1);
        KeyVCountDTO k2 = new KeyVCountDTO();
        k2.setName("营业房");
        k2.setValue(count2);
        KeyVCountDTO k3 = new KeyVCountDTO();
        k3.setName("土地");
        k3.setValue(count3);
        ArrayList<KeyVCountDTO> arrayList = new ArrayList<>();
        arrayList.add(k1);
        arrayList.add(k2);
        arrayList.add(k3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        String string = jsonArray.toString();
        log.info("住宅（营业）户数占总户数比例数据---" + jsonArray);
        return string;
    }

    /**
     * 资产面积
     *
     * @return
     */
    @Override
    public String findRoomArea() {
        List<Roominfo> roominfos = roominfoMapper.findArea();
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        for (Roominfo roominfo : roominfos) {
            String roomproperty = roominfo.getRoomproperty();
            double buildarea = roominfo.getBuildarea();
            if("住宅房".equals(roomproperty)){
                count1 += buildarea ;
            }
            else if("营业房".equals(roomproperty)){
                count2 += buildarea;
            }
            else if("土地".equals(roomproperty) ){
                count3 += buildarea;
            }
        }
        KeyObjDTO k1 = new KeyObjDTO();
        k1.setName("住宅房");
        k1.setValue(DoubleUtils.convert(count1));
        KeyObjDTO k2 = new KeyObjDTO();
        k2.setName("营业房");
        k2.setValue(DoubleUtils.convert(count2));
        KeyObjDTO k3 = new KeyObjDTO();
        k3.setName("土地");
        k3.setValue(DoubleUtils.convert(count3));
        ArrayList<KeyObjDTO> arrayList = new ArrayList<>();
        arrayList.add(k1);
        arrayList.add(k2);
        arrayList.add(k3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        String s = jsonArray.toString();
        log.info("住宅、营业、其他面积占总面积比例数据---" + jsonArray);
        return s;
    }

    /**
     * 资产分类
     * @return
     */
    @Override
    public String findDataDictionary() {
        List<Datadictionary> list = datadictionaryMapper.findContent();
        int count1 = 0; //保障性住房
        int count2 = 0; //经营性住房
        int count3 = 0; //其他
        for (Datadictionary datadictionary : list) {
            String content = datadictionary.getContent();
            if("保障性住房".equals(content)){
                count1++;
            }
            else if("经营性住房".equals(content)){
                count2++;
            }
            else {
                count3++;
            }
        }
        KeyVCountDTO k1 = new KeyVCountDTO();
        k1.setName("保障性住房");
        k1.setValue(count1);
        KeyVCountDTO k2 = new KeyVCountDTO();
        k2.setName("经营性住房");
        k2.setValue(count2);
        KeyVCountDTO k3 = new KeyVCountDTO();
        k3.setName("其他");
        k3.setValue(count3);
        ArrayList<KeyVCountDTO> arrayList = new ArrayList<>();
        arrayList.add(k1);
        arrayList.add(k2);
        arrayList.add(k3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        log.info("经营性住房，保障性，及其他所占比例----" + jsonArray);
        String string = jsonArray.toString();
        return string;
    }

    /**
     * 资产结构
     * @return
     */
    @Override
    public String findStructure() {
        List<Roominfo> roominfos = roominfoMapper.findStructure();
        int count1 = 0; //砖木
        int count2 = 0; //砖混
        int count3 = 0; //框架
        int count4 = 0; //钢结构
        int count5 = 0; //null也默认为其他
        for (Roominfo roominfo : roominfos) {
            if(roominfo != null){
                String structure = roominfo.getStructure();
                if(structure != null){
                    if("砖木".equals(structure)){
                        count1++;
                    }
                    else if("砖混".equals(structure)){
                        count2++;
                    }
                    else if("框架".equals(structure)){
                        count3++;
                    }
                    else if("钢结构".equals(structure)){
                        count4++;
                    }else {
                        count5++;
                    }
                }
            }
        }
        KeyVCountDTO k1 = new KeyVCountDTO();
        KeyVCountDTO k2 = new KeyVCountDTO();
        KeyVCountDTO k3 = new KeyVCountDTO();
        KeyVCountDTO k4 = new KeyVCountDTO();
        KeyVCountDTO k5 = new KeyVCountDTO();
        k1.setName("砖木");
        k1.setValue(count1);
        k2.setName("砖混");
        k2.setValue(count2);
        k3.setName("框架");
        k3.setValue(count3);
        k4.setName("钢结构");
        k4.setValue(count4);
        k5.setName("其他");
        k5.setValue(count5);
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(k1);
        arrayList.add(k2);
        arrayList.add(k3);
        arrayList.add(k4);
        arrayList.add(k5);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        String string = jsonArray.toString();
        return string;
    }


}
