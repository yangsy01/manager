package com.voucher.manage2.controller;

import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.service.AssetsConditionBarService;
import com.voucher.manage2.service.AssetsConditionService;
import com.voucher.manage2.service.AssetsDetailsService;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.ListUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "assetsCon", produces = {"text/json;charset=utf-8"})
public class AssetsConditionController {

    @Resource
    private AssetsConditionService conditionService;
    @Resource
    private AssetsConditionBarService conditionBarService;
    @Resource
    private AssetsDetailsService assetsDetailsService;
    @Resource
    private RoominfoMapper roominfoMapper;

    /**
     * 资产总数量
     *
     * @return
     */
    @RequestMapping(value = "count")
    public String findChartInfoCount() {
        String count = conditionService.findChartInfoCount();
        return count;
    }

    /**
     * 资产总面积
     *
     * @return
     */
    @RequestMapping("area")
    public String findChartInfoArea() {
        String a = conditionService.findChartInfoArea();
        return a;
    }

    /**
     * 合同总户数
     *
     * @return
     */
    @RequestMapping("users")
    public String findChartInfoUsers() {
        String users = conditionService.findChartInfoUsers();
        return users;
    }

    /**
     * 出租总收益
     *
     * @return
     */
    @RequestMapping("earnings")
    public String findChartInfoEarnings() {
        String e = conditionService.findChartInfoEarnings();
        return e;
    }

    /**
     * 资产面积占比
     *
     * @return
     */
    @RequestMapping("roomArea")
    public String findRoomArea() {
        String roomArea = conditionService.findRoomArea();
        return roomArea;
    }

    /**
     * 资产数量占比
     *
     * @return
     */
    @RequestMapping("roomProperty")
    public String findRoomProperty() {
        String roomProperty = conditionService.findRoomProperty();
        return roomProperty;
    }

    /**
     * 资产分类占比
     *
     * @return
     */
    @RequestMapping("dictionary")
    public String findSecurityRegion() {
        List<Map<String,Object>> list = roominfoMapper.findSecurityRegion();
        ArrayList<KeyObjDTO> arrayList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            KeyObjDTO keyObjDTO = new KeyObjDTO();
            Object count = map.get("count");
            String securityRegion = (String) map.get("SecurityRegion");
            keyObjDTO.setName(securityRegion);
            keyObjDTO.setValue(count);

         arrayList.add(keyObjDTO);
        }
        return JSONArray.fromObject(arrayList).toString();
    }

    /**
     * 资产结构占比
     *
     * @return
     */
    @RequestMapping("structure")
    public String findStructure() {
        String structure = conditionService.findStructure();
        return structure;
    }

    //    ======================柱状图==================================

    @RequestMapping("assetsData")
    public String assetsData(@RequestBody JSONObject mapKV) {
        String name = mapKV.getString("name");
        String column = mapKV.getString("column");

        List<String> list = DistinctUtils.getMonthAllNew(mapKV);

        switch (name) {
            case "1":
                return conditionBarService.findCountBar(name, column, list);
            case "2":
                return conditionBarService.findAreaBar(name, column, list);
            case "3":
                return conditionBarService.findChartBar(name, column, list);
            case "4":
                return conditionBarService.findEarningsBar(name, column, list);

            case "5":
                return conditionBarService.findRoomPropertyBar(name, column, list);
            case "6":
                return conditionBarService.findRoomPropertyBar(name, column, list);
            case "7":
                return conditionBarService.findRoomPropertyBar(name, column, list);

            case "8":
                return conditionBarService.findRoomAreaBar(name, column, list);
            case "9":
                return conditionBarService.findRoomAreaBar(name, column, list);
            case "10":
                return conditionBarService.findRoomAreaBar(name, column, list);

            case "11":
                return conditionBarService.findRoomAreaBar(name, column, list);
            case "12":
                return conditionBarService.findRoomAreaBar(name, column, list);
            case "13":
                return conditionBarService.findStructureBar(name, column, list);
            case "14":
                return conditionBarService.findStructureBar(name, column, list);
            case "15":
                return conditionBarService.findStructureBar(name, column, list);

            default:
                return "参数异常";
        }
    }

    //    ==================  详情  =====================================

    /**
     * 所有资产基础数据
     * roomInfoBasic
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("roomInfoDetails")
    public String roomInfoBasic(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = assetsDetailsService.roomInfoDetails();
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }

    /**
     * 所有合同
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     *                  chartInfoBasic
     * @return
     */
    @RequestMapping("chartInfoDetails")
    public String chartInfoBasic(int pageIndex, int pageSize) {
        //所有数据
        List<ChartInfoDTO> allDetails = assetsDetailsService.chartInfoDetails();
        String s = ListUtils.chartString(allDetails, pageIndex, pageSize);
        return s;
    }




}
