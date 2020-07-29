package com.voucher.manage2.controller;

import com.voucher.manage2.service.RentConditionBarService;
import com.voucher.manage2.service.RentConditionService;
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
@RequestMapping(value = "rentCon",produces = {"text/json;charset=utf-8"})
public class RentConController {

    @Resource
    private RentConditionService service;
    @Resource
    private RentConditionBarService barService;

    //年度应收租金
    @RequestMapping("receivable")
    public String receivable(){
        String receivable = service.receivable();
        return receivable;
    }
    //年度已收租金
    @RequestMapping("take")
    public String take(){
        String take = service.take();
        return take;
    }
    //年度未收租金
    @RequestMapping("noTake")
    public String noTake(){
        String s = service.noTake();
        return s;
    }



    //年度实收租金
    @RequestMapping("received")
    public String received(){
        String received = service.received();
        return received;
    }
    //年度收取历欠租金
    @RequestMapping("throughOwe")
    public String throughOwe(){
        String s = service.throughOwe();
        return s;
    }
    //年度已收租金
    @RequestMapping("yiShow")
    public String yiShow(){
        String s = service.yiShou();
        return s;
    }
    //年度预收租金
    @RequestMapping("precollected")
    public String precollected(){
        String precollected = service.precollected();
        return precollected;
    }

    //应收历欠租金
    @RequestMapping("yingShouLQ")
    public String yingShouLQ(){
        String s = service.yingShouLQ();
        return s;
    }


    //租金收取状况
    @RequestMapping("hireCon")
    public String hireCon() {
        String s = service.hireCon();
        return s;
    }

    //当月租金收入情况
    @RequestMapping("monCon")
    public String monthHireCon(@RequestBody JSONObject mapKV) {
        String s = service.monthHireCon(mapKV);
        return s;
    }

    //======================柱状图======================================
    @RequestMapping("rentData")
    public String operateData(@RequestBody JSONObject mapKV){
        String name = mapKV.getString("name");
        String column = mapKV.getString("column");
        List<String> list = DistinctUtils.getMonthAll(mapKV);
        switch (name){
            case "1" :
                return barService.receivableBar(name,column,list);
            case "2":
                return barService.takeBar(name,column,list);

            case "3":
                return barService.noTakeBar(name,column,list);
            case "4":
                return barService.receivedBar(name,column,list);
            case "5":
                return barService.throughOweBar(name,column,list);
            case "6":
                return barService.precollectedBar(name,column,list);

            default:
                return "参数异常";
        }
    }



}
