package com.voucher.manage2.controller;


import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.service.FinancialConditionBarService;
import com.voucher.manage2.service.FinancialConditionService;
import com.voucher.manage2.service.FinancialDetailsService;
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
@RequestMapping(value = "finCon", produces = {"text/json;charset=utf-8"})
public class FinancialConController {

    @Resource
    private FinancialConditionService service;
    @Resource
    private FinancialConditionBarService barService;

    //空置房屋
    @RequestMapping("emptyRoom")
    String emptyRoom() {
        String s = service.emptyRoom();
        return s;
    }

    //逾期合同
    @RequestMapping("contractDue")
    String contractDue() {
        String s = service.contractDue();
        return s;
    }

    //出租住宅房
    @RequestMapping("rentalHousing")
    String rentalHousing() {
        String s = service.rentalHousing();
        return s;
    }

    //出租营业房
    @RequestMapping("rentalOffice")
    String rentalOffice() {
        String s = service.rentalOffice();
        return s;
    }

    //资产出租情况
    @RequestMapping("rentReviseCon")
    String rentReviseCon() {
        String s = service.rentReviseCon();
        return s;
    }

    //资产出租面积情况
    @RequestMapping("rentAreaCon")
    String rentAreaCon() {
        String s = service.rentAreaCon();
        return s;
    }

    //住宅房情况
    @RequestMapping("housingCon")
    String housingCon() {
        String s = service.housingCon();
        return s;
    }

    //营业房情况
    @RequestMapping("officeCon")
    String officeCon() {
        String s = service.officeCon();
        return s;
    }



    //=================柱状图==================================
    @RequestMapping("finData")
    public String finData(@RequestBody JSONObject mapKV) {
        String name = mapKV.getString("name");
        String column = mapKV.getString("column");
        List<String> list = DistinctUtils.getMonthAll(mapKV);

        switch (name) {
            case "1":
                return barService.emptyRoomBar(name, column, list);
            case "2":
                return barService.contractDueBar(name, column, list);
            case "3":
                return barService.rentalHousingBar(name, column, list);
            case "4":
                return barService.rentalOfficeBar(name, column, list);


            case "5":
                return barService.housingConBar(name, column, list);
            case "6":
                return barService.housingConBar(name, column, list);
            case "7":
                return barService.housingConBar(name, column, list);


            case "8":
                return barService.officeConBar(name, column, list);
            case "9":
                return barService.officeConBar(name, column, list);
            case "10":
                return barService.officeConBar(name, column, list);


            case "11":
                return barService.rentReviseConBar(name, column, list);
            case "12":
                return barService.rentReviseConBar(name, column, list);
            case "13":
                return barService.rentReviseConBar(name, column, list);

            case "14":
                return barService.rentAreaConBar(name, column, list);
            case "15":
                return barService.rentAreaConBar(name, column, list);
            case "16":
                return barService.rentAreaConBar(name, column, list);

            default:
                return "参数异常";
        }
    }

    //===================  详情  ============================
    @Resource
    private FinancialDetailsService financialDetailsService;

    /**
     * 空置房屋
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("emptyRoomDetails")
    public String emptyRoomDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = financialDetailsService.emptyRoomDetails();
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }


    /**
     * 逾期合同
     *
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("overdueRoomDetails")
    public String overdueRoomDetails(int pageIndex, int pageSize) {
        //所有数据
        List<ChartInfoDTO> allDetails = financialDetailsService.overdueChartDetails();
        String s = ListUtils.chartString(allDetails, pageIndex, pageSize);
        return s;
    }


    /**
     * 已出租住宅房
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("rentRoomDetails")
    public String rentRoomDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = financialDetailsService.rentRoomDetails();
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }


    /**
     * 已出租营业房
     * @param pageIndex 所在页数
     * @param pageSize  行数
     * @return
     */
    @RequestMapping("businessRoomDetails")
    public String businessRoomDetails(int pageIndex, int pageSize) {
        //所有数据
        List<RoomInfoDTO> allDetails = financialDetailsService.businessRoomDetails();
        String stringReturn = ListUtils.roomString(allDetails, pageIndex, pageSize);
        return stringReturn;
    }
}
