package com.voucher.manage2.controller;

import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.service.SecurityConditionBarService;
import com.voucher.manage2.service.SecurityConditionService;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import com.voucher.manage2.utils.DistinctUtils;
import com.voucher.manage2.utils.ListUtils;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "security", produces = {"text/json;charset=utf-8"})
public class SecurityConController {

    @Resource
    private SecurityConditionService service;
    @Resource
    private SecurityConditionBarService barService;
    @Resource
    private RoominfoMapper roominfoMapper;

    //隐患处数
    @RequestMapping("hidDanger")
    String hidDanger() {
        String s = service.hidDanger();
        return s;
    }

    //本年已整改处数
    @RequestMapping("having")
    String having() {
        String s = service.having();
        return s;
    }

    //正在整改
    @RequestMapping("aba")
    String abarbeitung() {
        String abarbeitung = service.abarbeitung();
        return abarbeitung;
    }

    //未整改
    @RequestMapping("noAba")
    String noAbarbeitung() {
        String s = service.noAbarbeitung();
        return s;
    }


    //无隐患资产占比
    @RequestMapping("notDgRate")
    String notDgRateBar() {
        String s = service.notDgRateBar();
        return s;
    }

    //历来隐患情况统计
    @RequestMapping("havingRate")
    String havingRateBar() {
        String s = service.HavingRateBar();
        return s;
    }

    //整改率，根据时间判断
    @RequestMapping("yinHuanRate")
    String yinHuanRateBar() {
        String s = service.yinHuanRateBar();
        return s;
    }

    //==================柱状图======================
    @RequestMapping("secData")
    public String operateData(@RequestBody JSONObject mapKV) {
        String name = mapKV.getString("name");
        String column = mapKV.getString("column");
        List<String> list = DistinctUtils.getMonthAll(mapKV);
        switch (name) {
            case "1":
                return barService.patrolBar(name, column, list);
            case "2":
                return barService.hidDangerBar(name, column, list);
            case "3":
                return barService.abarbeitungBar(name, column, list);
            case "4":
                return barService.noAbarbeitungBar(name, column, list);
            case "5":
                return barService.dgRoomBar(name, column, list);
            case "6":
                return barService.hidRateBar(name, column, list);
            case "7":
                return barService.abaRateBar(name, column, list);
            case "8":
                return barService.dgRoomRateBar(name, column, list);
            default:
                return "参数异常";
        }
    }


//=============      详情     =========================



    /**
     * 隐患处数
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("hidDangerDetails")
    public String hidDangerDetails(int pageIndex, int pageSize) {
        //所有数据

        List<RoomInfoDTO> allDetails = roominfoMapper.hidDangerDetails(DistinctUtils.nowYear());
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }

    /**
     * 正在整改
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("abarbeitungDetails")
    public String abarbeitungDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = roominfoMapper.abarbeitungDetails(DistinctUtils.nowYear());
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }


    /**
     * 未整改
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("noAbarbeitungDetails")
    public String noAbarbeitungDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = roominfoMapper.noAbarbeitungDetails(DistinctUtils.nowYear());
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }


    /**
     * 本年已整改处数
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("dangerRoomDetails")
    public String dangerRoomDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = roominfoMapper.findYiZGaiDetails(DistinctUtils.nowYear());
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }

}
