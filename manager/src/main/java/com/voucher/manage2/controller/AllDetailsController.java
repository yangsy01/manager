package com.voucher.manage2.controller;


import com.voucher.manage2.dto.details.TopMessage;
import com.voucher.manage2.dto.roomInfo.AddressAndHireDTO;
import com.voucher.manage2.service.AllDetailsService;
import com.voucher.manage2.tkmapper.entity.Fileselfbelong;
import com.voucher.manage2.utils.FileUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "details", produces = {"text/json;charset=utf-8"})
public class AllDetailsController {

    @Resource
    private AllDetailsService allDetailsService;

    /**
     * 所有资产详情
     */
    @RequestMapping("roomInfoDetails")
    public String roomInfoDetails(String roomGuid) {
        if (roomGuid == null) {
            roomGuid = "";
        }
        Map<String, Object> all = allDetailsService.findAll(roomGuid);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 房屋情况日志
     */
    @RequestMapping("roomCon")
    public String roomCon(String roomGuid, int pageIndex, int pageSize) {
        if (roomGuid == null) {
            roomGuid = "";
        }
        Map<String, Object> all = allDetailsService.findRoomCon(roomGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();
    }

    /**
     * 维修情况
     */
    @RequestMapping("roomRepair")
    public String roomRepair(String roomGuid, int pageIndex, int pageSize) {
        if (roomGuid == null) {
            roomGuid = "";
        }
        Map<String, Object> all = allDetailsService.findRoomRepair(roomGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();
    }

    /**
     * 资产检查记录
     */
    @RequestMapping("roomCheck")
    public String roomCheck(String roomGuid, int pageIndex, int pageSize) {
        if (roomGuid == null) {
            roomGuid = "";
        }
        Map<String, Object> all = allDetailsService.findRoomCheck(roomGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 安全巡查记录
     */
    @RequestMapping("safeCheck")
    public String safeCheck(String roomGuid, int pageIndex, int pageSize) {
        if (roomGuid == null) {
            roomGuid = "";
        }
        Map<String, Object> all = allDetailsService.findSafeCheck(roomGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 当前隐患
     */
    @RequestMapping("nowDanger")
    public String nowDanger(String roomGuid, int pageIndex, int pageSize) {
        if (roomGuid == null) {
            roomGuid = "";
        }
        Map<String, Object> all = allDetailsService.findNowDanger(roomGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 经营信息
     */
    @RequestMapping("chartInfoDetails")
    public String chartInfoDetails(String chartGuid) {
        if (chartGuid == null) {
            chartGuid = "";
        }
        Map<String, Object> map = allDetailsService.findAllByChartGuid(chartGuid);
        return JSONObject.fromObject(map).toString();
    }

    /**
     * 通过chartGuid 返回地址
     * @param chartGuid
     * @return
     */
    @RequestMapping("returnAddress")
    public String returnAddress(String chartGuid) {
        if (chartGuid == null) {
            chartGuid = "";
        }
        List<String> list = allDetailsService.returnAddress(chartGuid);
        return JSONArray.fromObject(list).toString();
    }

    /**
     * 未缴纳租金情况明细
     * @param chartGuid  chartGuid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("nonpayment")
    public String nonpayment(String chartGuid, int pageIndex, int pageSize) {
        if (chartGuid == null) {
            chartGuid = "";
        }
        Map<String, Object> all = allDetailsService.findNonpayment(chartGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 租金已抵扣明细
     * @param chartGuid  chartGuid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("deducted")
    public String deducted(String chartGuid, int pageIndex, int pageSize) {
        if (chartGuid == null) {
            chartGuid = "";
        }
        Map<String, Object> all = allDetailsService.findDeducted(chartGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 租金缴纳明细
     * @param chartGuid  chartGuid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("payment")
    public String payment(String chartGuid, int pageIndex, int pageSize) {
        if (chartGuid == null) {
            chartGuid = "";
        }
        Map<String, Object> all = allDetailsService.findPayment(chartGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 保证金缴纳明细
     * @param chartGuid  chartGuid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("marginPay")
    public String marginPay(String chartGuid, int pageIndex, int pageSize) {
        if (chartGuid == null) {
            chartGuid = "";
        }
        Map<String, Object> all = allDetailsService.findMarginPay(chartGuid, pageIndex, pageSize);
        //所有数据
        return JSONObject.fromObject(all).toString();

    }

    /**
     * 详情头部信息
     */
    @RequestMapping("topMessage")
    public String topMessage(String roomGuid){
        TopMessage topMessage = allDetailsService.findTopMessage(roomGuid);
        return JSONObject.fromObject(topMessage).toString();
    }


    /**
     * 返回图片
     * @param roomGuid
     */
    @RequestMapping("roomPIC")
    public String roomPIC(String roomGuid){
        List<Fileselfbelong> list = allDetailsService.findPIC(roomGuid);
        String s = returnPIC(list);
        return s;
    }

    /**
     * 返回图片
     * @param guid chartGUID
     */
    @RequestMapping("chartPIC")
    public String chartPIC(String guid){
        List<Fileselfbelong> list = allDetailsService.findChartPIC(guid);
        String s = returnPIC(list);
        return s;
    }

    /**
     * 代理图片路径
     * @param list
     * @return
     */
    private static String returnPIC(List<Fileselfbelong> list){
        ArrayList<String> arrayList = new ArrayList<>();
        for (Fileselfbelong fileselfbelong : list) {
            String upfilefullname = fileselfbelong.getUpfilefullname();
//            String url = FileUtils.re() + File.separator + FileUtils.FILE_URL_PATH_PREFIX + File.separator + "PIC"+ File.separator  + upfilefullname;
            String url = FileUtils.re() + File.separator + FileUtils.FILE_URL_PATH_PREFIX1 + File.separator  + upfilefullname;
            arrayList.add(url);
        }
        return JSONArray.fromObject(arrayList).toString();
    }


}
