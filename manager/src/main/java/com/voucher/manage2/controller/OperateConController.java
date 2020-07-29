package com.voucher.manage2.controller;


import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.service.OperateConditionBarService;
import com.voucher.manage2.service.OperateConditionService;
import com.voucher.manage2.tkmapper.mapper.RoomassetsaccountingMapper;
import com.voucher.manage2.tkmapper.mapper.RoomassetsledgerMapper;
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
@RequestMapping(value = "operate", produces = {"text/json;charset=utf-8"})
public class OperateConController {

    @Resource
    private OperateConditionService service;
    @Resource
    private OperateConditionBarService serviceBar;

    //    资产处数新增
    @RequestMapping("chartAdd")
    public String chartAdd() {
        String s = service.chartAdd();
        return s;
    }

    // 资产处数减少
    @RequestMapping("chartCut")
    public String chartCut() {
        String s = service.chartCut();
        return s;
    }

    // 双证均无
    @RequestMapping("noCert")
    public String noCertificate() {
        String s = service.noCertificate();
        return s;
    }

    //  已抵押房产
    @RequestMapping("pledged")
    public String pledged() {
        String pledged = service.pledged();
        return pledged;
    }

    //    资产增加情况
    @RequestMapping("chartAddCon")
    public String chartAddCon() {
        String s = service.chartAddCon();
        return s;
    }

    //            资产减少情况
    @RequestMapping("chartCutCon")
    public String chartCutCon() {
        String s = service.chartCutCon();
        return s;
    }

    // 权证办理情况(数量)
    @RequestMapping("certCon")
    String certificateCon() {
        String s = service.certificateCon();
        return s;
    }

    //权证办理情况（面积）
    @RequestMapping("certConArea")
    String certConArea() {
        String s = service.certConArea();
        return s;
    }



    // 资产面积增加情况
    @RequestMapping("cAreaAdd")
    String cAreaAdd() {
        String s = service.cAreaAdd();
        return s;
    }

    // 资产面积减少情况
    @RequestMapping("cAreaCut")
    String cAreaCut() {
        String s = service.cAreaCut();
        return s;
    }


    //=================柱状图==================================

    @RequestMapping("operateData")
    public String operateData(@RequestBody JSONObject mapKV) {
        String name = mapKV.getString("name");
        String column = mapKV.getString("column");
        List<String> list = DistinctUtils.getMonthAll(mapKV);
        switch (name) {
            case "1":
                return serviceBar.chartAddBarC(name, column, list);
            case "2":
                return serviceBar.chartAddBarA(name, column, list);

            case "3":
                return serviceBar.chartCutBarC(name, column, list);
            case "4":
                return serviceBar.chartCutBarA(name, column, list);

            case "5":
                return serviceBar.pledgedBar(name, column, list);

            case "6":
                return serviceBar.chartAddConBar(name, column, list);
            case "7":
                return serviceBar.chartAddConBar(name, column, list);
            case "8":
                return serviceBar.chartAddConBar(name, column, list);
            case "9":
                return serviceBar.chartAddConBar(name, column, list);
            case "10":
                return serviceBar.chartAddConBar(name, column, list);

            case "11":
                return serviceBar.chartCutConBar(name, column, list);
            case "12":
                return serviceBar.chartCutConBar(name, column, list);
            case "13":
                return serviceBar.chartCutConBar(name, column, list);
            case "14":
                return serviceBar.chartCutConBar(name, column, list);
            case "15":
                return serviceBar.chartCutConBar(name, column, list);

            case "16":
                return serviceBar.cAreaAddBar(name, column, list);
            case "17":
                return serviceBar.cAreaAddBar(name, column, list);
            case "18":
                return serviceBar.cAreaAddBar(name, column, list);
            case "19":
                return serviceBar.cAreaAddBar(name, column, list);
            case "20":
                return serviceBar.cAreaAddBar(name, column, list);

            case "21":
                return serviceBar.cAreaCutBar(name, column, list);
            case "22":
                return serviceBar.cAreaCutBar(name, column, list);
            case "23":
                return serviceBar.cAreaCutBar(name, column, list);
            case "24":
                return serviceBar.cAreaCutBar(name, column, list);
            case "25":
                return serviceBar.cAreaCutBar(name, column, list);
            default:
                return "参数异常";
        }
    }

    //=================  详情  =====================
    @Resource
    private RoomassetsaccountingMapper roomassetsaccountingMapper;
    @Resource
    private RoomassetsledgerMapper roomassetsledgerMapper;
    @Resource
    private RoominfoMapper roominfoMapper;

    /**
     * 资产增加表
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("rentAddDetails")
    public String rentAddDetails(int pageIndex, int pageSize) {
        //所有数据
        String nowYear = DistinctUtils.nowYear();   //当前年
        List<RoomInfoDTO> allDetails = roomassetsaccountingMapper.rentAddDetails(nowYear);
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }

    /**
     * 资产减少表
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("rentCutDetails")
    public String rentCutDetails(int pageIndex, int pageSize) {
        //所有数据
        String nowYear = DistinctUtils.nowYear();   //当前年
        List<RoomInfoDTO> allDetails = roomassetsledgerMapper.rentCutDetails(nowYear);
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }

    /**
     * 未办证房产
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("noCardDetails")
    public String noCardDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = roominfoMapper.noCardDetails();
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }

    /**
     * 已抵押房产
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("isPawnDetails")
    public String isPawnDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = roominfoMapper.isPawn();
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }
}
