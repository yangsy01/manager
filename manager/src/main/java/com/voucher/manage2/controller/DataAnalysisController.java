package com.voucher.manage2.controller;

import com.voucher.manage2.service.AssetsConditionBarService;
import com.voucher.manage2.service.DataAnalysisService;
import com.voucher.manage2.service.SecurityConditionBarService;
import com.voucher.manage2.utils.DistinctUtils;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "data", produces = {"text/json;charset=utf-8"})
public class DataAnalysisController {
    @Resource
    private DataAnalysisService dataAnalysisService;
    @Resource
    private AssetsConditionBarService conditionBarService;

    @RequestMapping("assetsData")
    public String assetsData(@RequestBody JSONObject mapKV) {
        String name = mapKV.getString("name");
        String column = mapKV.getString("column");

        List<String> list = DistinctUtils.getMonthAllNew(mapKV);

        switch (name) {
            case "1":
                return dataAnalysisService.findCountBar(name, column, list);    //资产总数
            case "2":
                return dataAnalysisService.findAreaBar(name, column, list);     //总面积
            case "3":
                return dataAnalysisService.findChartBar(name, column, list);    //合同总数
            case "4":
                return dataAnalysisService.findEarningsBar(name, column, list);     //按月的总收益

            case "5":
                return dataAnalysisService.patrolBar(name, column, list);       //巡查
            case "6":
                return dataAnalysisService.hidDangerBar(name, column, list);    //隐患
            case "7":
                return dataAnalysisService.abarbeitungBar(name, column, list);  //正在整改
            case "8":
                return dataAnalysisService.noAbarbeitungBar(name, column, list);    //未整改
            case "9":
                return dataAnalysisService.notDgRateBar(name, column, list);    //无隐患资产占比
            case "10":
                return dataAnalysisService.HavingRateBar(name, column, list);   //历来隐患情况统计
            case "11":
                return dataAnalysisService.yinHuanRateBar(name, column, list);  //整改率，根据时间判断
            default:
                return "参数异常";
        }
    }
//
//    @RequestMapping("secData")
//    public String operateData(@RequestBody JSONObject mapKV) {
//        String name = mapKV.getString("name");
//        String column = mapKV.getString("column");
//        List<String> list = DistinctUtils.getMonthAll(mapKV);
//        switch (name) {
//            case "1":
//                return dataAnalysisService.patrolBar(name, column, list);       //巡查
//            case "2":
//                return dataAnalysisService.hidDangerBar(name, column, list);    //隐患
//            case "3":
//                return dataAnalysisService.abarbeitungBar(name, column, list);  //正在整改
//            case "4":
//                return dataAnalysisService.noAbarbeitungBar(name, column, list);    //未整改
//            case "5":
//                return dataAnalysisService.notDgRateBar(name, column, list);    //无隐患资产占比
//            case "6":
//                return dataAnalysisService.HavingRateBar(name, column, list);   //隐患资产占比
//            case "7":
//                return dataAnalysisService.yinHuanRateBar(name, column, list);  //整改率，根据时间判断
//            default:
//                return "参数异常";
//        }
//    }
}
