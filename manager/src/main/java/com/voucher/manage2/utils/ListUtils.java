package com.voucher.manage2.utils;

import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.dto.details.*;
import com.voucher.manage2.dto.page.Pagefenye;
import com.voucher.manage2.tkmapper.entity.*;
import com.voucher.manage2.tkmapper.mapper.*;
import net.sf.json.JSONObject;
import java.util.*;

public class ListUtils {

    public static <T> List<T> convert(List<T> allDetails, int pageIndex, int pageSize) {

        Pagefenye<T> pageInfo = new Pagefenye<>(allDetails.size(), pageIndex, pageSize, 5);

        //判断是否是最后一页,如果最后一页就显示最后一页的几条，不是最后一页就显示pageSize条
        if (pageIndex == pageInfo.getTotalPage())
            pageInfo.setList(allDetails.subList((pageIndex - 1) * pageSize, allDetails.size()));
        else {
            pageInfo.setList(allDetails.subList((pageIndex - 1) * pageSize, (pageIndex - 1) * pageSize + pageSize));
        }
        List<T> list = pageInfo.getList();
        return list;
    }

    public static <T> Map returnMap(List<T> list, int pageIndex, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        List<T> list1 = new ArrayList<>();
        if (list != null && list.size() > 0) {
            list1 = ListUtils.convert(list, pageIndex, pageSize);
            map.put("data", list1);
            map.put("allCount", list.size());
        } else {
            map.put("data", null);
            map.put("allCount", 0);
        }
        return map;
    }


    public static String roomString(List<RoomInfoDTO> allDetails, int pageIndex, int pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        if (allDetails != null && allDetails.size() > 0) {
            List<RoomInfoDTO> roomInfoDTOS = ListUtils.convert(allDetails, pageIndex, pageSize);
            //转json
            map.put("allCount", allDetails.size());     //总数据条数
            map.put("data", roomInfoDTOS);         //基础数据
            return JSONObject.fromObject(map).toString();
        } else {
            map.put("data", null);         //基础数据
            map.put("allCount", 0);         //总数据条数
            return JSONObject.fromObject(map).toString();
        }
    }

    public static String chartString(List<ChartInfoDTO> allDetails, int pageIndex, int pageSize) {
        List<ChartInfoDTO> roomInfoDTOS = ListUtils.convert(allDetails, pageIndex, pageSize);
        //转json
        HashMap<String, Object> map = new HashMap<>();
        map.put("allCount", allDetails.size());     //总数据条数
        map.put("data", roomInfoDTOS);         //基础数据
        JSONObject jsonObject = JSONObject.fromObject(map);
        String string = jsonObject.toString();
        return string;
    }

    public static Map<String, Object> findAll(Roominfo roominfo, Chartinfo chartInfo,
                                              HirelistMapper hirelistMapper) {
        Map<String, Object> map = new HashMap<>();
        List<BasicFormat> listBasic = new ArrayList<>();
        if (roominfo != null) {
            listBasic.add(new BasicFormat("编号", roominfo.getNum()));
            listBasic.add(new BasicFormat("原编号", roominfo.getOriginalnum()));
//            listBasic.add(new BasicFormat("地址", roominfo.getAddress()));
//            listBasic.add(new BasicFormat("原地址", roominfo.getOriginaladdress()));
            listBasic.add(new BasicFormat("所在乡镇", roominfo.getRegion()));
            listBasic.add(new BasicFormat("所在社区", roominfo.getManageregion()));
            listBasic.add(new BasicFormat("所在街道", roominfo.getSegment()));
            listBasic.add(new BasicFormat("建筑面积", roominfo.getBuildarea()));
            listBasic.add(new BasicFormat("房屋结构", roominfo.getStructure()));
            listBasic.add(new BasicFormat("用途", roominfo.getUseful()));
            listBasic.add(new BasicFormat("装修情况", roominfo.getFitment()));
            listBasic.add(new BasicFormat("楼层", roominfo.getFloor()));
            listBasic.add(new BasicFormat("户型", roominfo.getRoomtype()));
            listBasic.add(new BasicFormat("是否纠纷", roominfo.getIscity()));
            listBasic.add(new BasicFormat("临街", roominfo.getIsstreet()));
            listBasic.add(new BasicFormat("房屋性质", roominfo.getRoomproperty()));
            listBasic.add(new BasicFormat("状态", roominfo.getState()));
            listBasic.add(new BasicFormat("房管员", roominfo.getManager()));
            listBasic.add(new BasicFormat("联系电话", roominfo.getManagerphone()));
            listBasic.add(new BasicFormat("资产分类", roominfo.getSecurityregion()));
            listBasic.add(new BasicFormat("完好等级", roominfo.getSecurityclassification()));
            listBasic.add(new BasicFormat("危房等级", roominfo.getDangerclassification()));
            listBasic.add(new BasicFormat("安全隐患等级", roominfo.getHiddendanger()));
            listBasic.add(new BasicFormat("安全负责人", roominfo.getResponsibleperson()));
            listBasic.add(new BasicFormat("纠纷原因", roominfo.getUtility()));
            listBasic.add(new BasicFormat("备注信息", roominfo.getSmemo()));
            listBasic.add(new BasicFormat("物业信息板块", roominfo.getTenementInfo()));
        } else {
            listBasic.add(new BasicFormat("编号", ""));
            listBasic.add(new BasicFormat("原编号", ""));
//            listBasic.add(new BasicFormat("地址", ""));
//            listBasic.add(new BasicFormat("原地址", ""));
            listBasic.add(new BasicFormat("所在乡镇", ""));
            listBasic.add(new BasicFormat("所在社区", ""));
            listBasic.add(new BasicFormat("所在街道", ""));
            listBasic.add(new BasicFormat("建筑面积", ""));
            listBasic.add(new BasicFormat("房屋结构", ""));
            listBasic.add(new BasicFormat("用途", ""));
            listBasic.add(new BasicFormat("装修情况", ""));
            listBasic.add(new BasicFormat("楼层", ""));
            listBasic.add(new BasicFormat("户型", ""));
            listBasic.add(new BasicFormat("是否纠纷", ""));
            listBasic.add(new BasicFormat("临街", ""));
            listBasic.add(new BasicFormat("房屋性质", ""));
            listBasic.add(new BasicFormat("状态", ""));
            listBasic.add(new BasicFormat("房管员", ""));
            listBasic.add(new BasicFormat("联系电话", ""));
            listBasic.add(new BasicFormat("资产分类", ""));
            listBasic.add(new BasicFormat("完好等级", ""));
            listBasic.add(new BasicFormat("危房等级", ""));
            listBasic.add(new BasicFormat("安全隐患等级", ""));
            listBasic.add(new BasicFormat("安全负责人", ""));
            listBasic.add(new BasicFormat("纠纷原因", ""));
            listBasic.add(new BasicFormat("备注信息", ""));
            listBasic.add(new BasicFormat("物业信息板块", ""));
        }

        map.put("basic", listBasic);

        List<BasicFormat> listManage = new ArrayList<>();
        if (chartInfo != null) {
            listManage.add(new BasicFormat("承租人", chartInfo.getCharter()));
            listManage.add(new BasicFormat("性别", chartInfo.getSex()));
            listManage.add(new BasicFormat("承租人性质", chartInfo.getCharterproperty()));
            listManage.add(new BasicFormat("信誉等级", chartInfo.getCreditrating()));
            listManage.add(new BasicFormat("证件类型", chartInfo.getCardtype()));
            listManage.add(new BasicFormat("证件号", chartInfo.getIdno()));
            listManage.add(new BasicFormat("法人代表", chartInfo.getCorporation()));
            listManage.add(new BasicFormat("联系电话", chartInfo.getPhone()));
            listManage.add(new BasicFormat("联系地址", chartInfo.getHomeaddress()));
            listManage.add(new BasicFormat("安置类型", chartInfo.getCharttype()));
            listManage.add(new BasicFormat("租赁性质", chartInfo.getChartproperty()));
            listManage.add(new BasicFormat("计租面积", chartInfo.getArea()));
            listManage.add(new BasicFormat("月租金", chartInfo.getHire()));
            listManage.add(new BasicFormat("租赁标准", chartInfo.getChartcriterion()));
            listManage.add(new BasicFormat("租赁率", chartInfo.getAddrate()));
            listManage.add(new BasicFormat("保证金", chartInfo.getAssureamount()));
            listManage.add(new BasicFormat("合同编号", chartInfo.getContractno()));
            listManage.add(new BasicFormat("签订日期", chartInfo.getConcludedate()));
            listManage.add(new BasicFormat("合同起始", chartInfo.getChartbegindate()));
            listManage.add(new BasicFormat("合同终止", chartInfo.getChartenddate()));
            listManage.add(new BasicFormat("经营项目", chartInfo.getFareitem()));
            listManage.add(new BasicFormat("是否低保", chartInfo.getLowprotect()));
            listManage.add(new BasicFormat("合同总额", chartInfo.getTotalhire()));

            List<Hirelist> list = hirelistMapper.findByChartGuid(chartInfo.getGuid());
            if (list.size() == 0) {
                listManage.add(new BasicFormat("已交租金", 0.0));
                listManage.add(new BasicFormat("未交租金", 0.0));
                listManage.add(new BasicFormat("租金交至", ""));
            } else {
                double hireSum = 0;
                for (Hirelist hirelist : list) {
                    Double hire = hirelist.getHire();
                    hireSum += hire;
                }
                listManage.add(new BasicFormat("已交租金", hireSum));
                listManage.add(new BasicFormat("未交租金", chartInfo.getTotalhire() - hireSum));
                listManage.add(new BasicFormat("租金交至", list.get(0).getHiredate()));
            }
            listManage.add(new BasicFormat("欠租原因", chartInfo.getOwehireresion()));
            listManage.add(new BasicFormat("经办人", chartInfo.getOperator()));
            listManage.add(new BasicFormat("房屋安置费", chartInfo.getPlacementFees()));
            listManage.add(new BasicFormat("天然气安装费", chartInfo.getGasInstallationFees()));
            listManage.add(new BasicFormat("暂停收租原因", chartInfo.getStophireinresion()));
            listManage.add(new BasicFormat("备注", chartInfo.getMemo()));
        } else {
            listManage.add(new BasicFormat("承租人", ""));
            listManage.add(new BasicFormat("性别", ""));
            listManage.add(new BasicFormat("承租人性质", ""));
            listManage.add(new BasicFormat("信誉等级", ""));
            listManage.add(new BasicFormat("证件类型", ""));
            listManage.add(new BasicFormat("证件号", ""));
            listManage.add(new BasicFormat("法人代表", ""));
            listManage.add(new BasicFormat("联系电话", ""));
            listManage.add(new BasicFormat("联系地址", ""));
            listManage.add(new BasicFormat("安置类型", ""));
            listManage.add(new BasicFormat("租赁性质", ""));
            listManage.add(new BasicFormat("计租面积", ""));
            listManage.add(new BasicFormat("月租金", ""));
            listManage.add(new BasicFormat("租赁标准", ""));
            listManage.add(new BasicFormat("租赁率", ""));
            listManage.add(new BasicFormat("保证金", ""));
            listManage.add(new BasicFormat("合同编号", ""));
            listManage.add(new BasicFormat("签订日期", ""));
            listManage.add(new BasicFormat("合同起始", ""));
            listManage.add(new BasicFormat("合同终止", ""));
            listManage.add(new BasicFormat("经营项目", ""));
            listManage.add(new BasicFormat("是否低保", ""));
            listManage.add(new BasicFormat("合同总额", ""));
            listManage.add(new BasicFormat("已交租金", 0.0));
            listManage.add(new BasicFormat("未交租金", 0.0));
            listManage.add(new BasicFormat("租金交至", ""));
            listManage.add(new BasicFormat("欠租原因", ""));
            listManage.add(new BasicFormat("经办人", ""));
            listManage.add(new BasicFormat("房屋安置费", 0.0));
            listManage.add(new BasicFormat("天然气安装费", 0.0));
            listManage.add(new BasicFormat("暂停收租原因", ""));
            listManage.add(new BasicFormat("备注", ""));
        }

        map.put("manage", listManage);

        List<BasicFormat> listEquities = new ArrayList<>();
        if (roominfo != null) {
            listEquities.add(new BasicFormat("房产证号", roominfo.getPropertyrightno()));
            listEquities.add(new BasicFormat("土地证号", roominfo.getGlebecardno()));
            listEquities.add(new BasicFormat("不动产证", roominfo.getRealestateno()));
            listEquities.add(new BasicFormat("产权面积", roominfo.getPropertyrightarea()));
            listEquities.add(new BasicFormat("土地证面积", roominfo.getLandarea()));
            listEquities.add(new BasicFormat("房屋来源", roominfo.getBefrom()));
            listEquities.add(new BasicFormat("产权单位", roominfo.getPropertyrightunit()));
            listEquities.add(new BasicFormat("实际产权单位", roominfo.getRealpropertyrightunit()));
            listEquities.add(new BasicFormat("产权来源文件", roominfo.getBefromfile()));
            listEquities.add(new BasicFormat("移交单位", roominfo.getTransferunit()));
            listEquities.add(new BasicFormat("建筑年份", roominfo.getBuildyear()));
            listEquities.add(new BasicFormat("设计用途", roominfo.getDesignuseful()));
            listEquities.add(new BasicFormat("规划用途", roominfo.getPlanuseful()));
            listEquities.add(new BasicFormat("地类用途", roominfo.getGlebetypeuseful()));
            listEquities.add(new BasicFormat("使用权类型", roominfo.getGlebeusetype()));
            listEquities.add(new BasicFormat("土地到期年限", roominfo.getGlebeenddate()));
            listEquities.add(new BasicFormat("房产证证载权属单位", roominfo.getPropertycardunit()));
            listEquities.add(new BasicFormat("土地证证载权属单位", roominfo.getGlebecardunit()));
            listEquities.add(new BasicFormat("未完善房产证说明", roominfo.getNoprnresion()));
            listEquities.add(new BasicFormat("未完善土地证说明", roominfo.getNogcresion()));
            listEquities.add(new BasicFormat("产权备注", roominfo.getPropertymemo()));
        } else {
            listEquities.add(new BasicFormat("房产证号", ""));
            listEquities.add(new BasicFormat("土地证号", ""));
            listEquities.add(new BasicFormat("不动产证", ""));
            listEquities.add(new BasicFormat("产权面积", ""));
            listEquities.add(new BasicFormat("土地证面积", ""));
            listEquities.add(new BasicFormat("房屋来源", ""));
            listEquities.add(new BasicFormat("产权单位", ""));
            listEquities.add(new BasicFormat("实际产权单位", ""));

            listEquities.add(new BasicFormat("产权来源文件", ""));
            listEquities.add(new BasicFormat("移交单位", ""));
            listEquities.add(new BasicFormat("建筑年份", ""));
            listEquities.add(new BasicFormat("设计用途", ""));
            listEquities.add(new BasicFormat("规划用途", ""));
            listEquities.add(new BasicFormat("地类用途", ""));
            listEquities.add(new BasicFormat("使用权类型", ""));
            listEquities.add(new BasicFormat("土地到期年限", ""));
            listEquities.add(new BasicFormat("房产证证载权属单位", ""));
            listEquities.add(new BasicFormat("土地证证载权属单位", ""));
            listEquities.add(new BasicFormat("未完善房产证说明", ""));
            listEquities.add(new BasicFormat("未完善土地证说明", ""));
            listEquities.add(new BasicFormat("产权备注", ""));
        }

        map.put("equities", listEquities);

        List<BasicFormat> listFinance = new ArrayList<>();
        if (roominfo != null) {
            listFinance.add(new BasicFormat("入账时间", roominfo.getIndate()));
            listFinance.add(new BasicFormat("历史来源价值", roominfo.getBefromamount()));
            listFinance.add(new BasicFormat("资产成本", roominfo.getOriginalamount()));
            listFinance.add(new BasicFormat("资产净值", roominfo.getNetworth()));
            listFinance.add(new BasicFormat("使用年限", roominfo.getUseyears()));
            listFinance.add(new BasicFormat("已提年限", roominfo.getDepreciationyear()));
            listFinance.add(new BasicFormat("累计折旧", roominfo.getAlldepreciation()));
            listFinance.add(new BasicFormat("评估机构", roominfo.getEvaluationunit()));
            listFinance.add(new BasicFormat("评估号", roominfo.getEvaluationno()));
            listFinance.add(new BasicFormat("公允价值", roominfo.getEvaluationprice()));
            listFinance.add(new BasicFormat("资产单价", roominfo.getEvaluationsingleprice()));
            listFinance.add(new BasicFormat("评估时间", roominfo.getEvaluationplace()));
            listFinance.add(new BasicFormat("市场租金", roominfo.getMarkethire()));
            listFinance.add(new BasicFormat("是否抵押", roominfo.getIspawn()));
            listFinance.add(new BasicFormat("抵押单位", roominfo.getPawnunit()));
            listFinance.add(new BasicFormat("代管资产原所属单位", roominfo.getOriginalunit()));
            listFinance.add(new BasicFormat("财务备注", roominfo.getFinancememo()));
        } else {
            listFinance.add(new BasicFormat("入账时间", ""));
            listFinance.add(new BasicFormat("历史来源价值", ""));
            listFinance.add(new BasicFormat("资产成本", ""));
            listFinance.add(new BasicFormat("资产净值", ""));
            listFinance.add(new BasicFormat("使用年限", ""));
            listFinance.add(new BasicFormat("已提年限", ""));
            listFinance.add(new BasicFormat("累计折旧", ""));
            listFinance.add(new BasicFormat("评估机构", ""));
            listFinance.add(new BasicFormat("评估号", ""));
            listFinance.add(new BasicFormat("公允价值", ""));
            listFinance.add(new BasicFormat("资产单价", ""));
            listFinance.add(new BasicFormat("评估时间", ""));
            listFinance.add(new BasicFormat("市场租金", ""));
            listFinance.add(new BasicFormat("是否抵押", ""));
            listFinance.add(new BasicFormat("抵押单位", ""));
            listFinance.add(new BasicFormat("代管资产原所属单位", ""));
            listFinance.add(new BasicFormat("财务备注", ""));
        }

        map.put("finance", listFinance);
        return map;

    }

    public static Map<String, Object> findManage(Chartinfo chartInfo, HirelistMapper hirelistMapper) {
        List<BasicFormat> listManage = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (chartInfo != null) {
            listManage.add(new BasicFormat("承租人", chartInfo.getCharter()));
            listManage.add(new BasicFormat("性别", chartInfo.getSex()));
            listManage.add(new BasicFormat("承租人性质", chartInfo.getCharterproperty()));
            listManage.add(new BasicFormat("信誉等级", chartInfo.getCreditrating()));
            listManage.add(new BasicFormat("证件类型", chartInfo.getCardtype()));
            listManage.add(new BasicFormat("证件号", chartInfo.getIdno()));
            listManage.add(new BasicFormat("法人代表", chartInfo.getCorporation()));
            listManage.add(new BasicFormat("联系电话", chartInfo.getPhone()));
            listManage.add(new BasicFormat("联系地址", chartInfo.getHomeaddress()));
            listManage.add(new BasicFormat("安置类型", chartInfo.getCharttype()));
            listManage.add(new BasicFormat("租赁性质", chartInfo.getChartproperty()));
            listManage.add(new BasicFormat("计租面积", chartInfo.getArea()));
            listManage.add(new BasicFormat("月租金", chartInfo.getHire()));
            listManage.add(new BasicFormat("租赁标准", chartInfo.getChartcriterion()));
            listManage.add(new BasicFormat("租赁率", chartInfo.getAddrate()));
            listManage.add(new BasicFormat("保证金", chartInfo.getAssureamount()));
            listManage.add(new BasicFormat("合同编号", chartInfo.getContractno()));
            listManage.add(new BasicFormat("签订日期", chartInfo.getConcludedate()));
            listManage.add(new BasicFormat("合同起始", chartInfo.getChartbegindate()));
            listManage.add(new BasicFormat("合同终止", chartInfo.getChartenddate()));
            listManage.add(new BasicFormat("经营项目", chartInfo.getFareitem()));
            listManage.add(new BasicFormat("是否低保", chartInfo.getLowprotect()));
            listManage.add(new BasicFormat("合同总额", chartInfo.getTotalhire()));

            List<Hirelist> list = hirelistMapper.findByChartGuid(chartInfo.getGuid());
            if (list.size() == 0) {
                listManage.add(new BasicFormat("已交租金", 0.0));
                listManage.add(new BasicFormat("未交租金", 0.0));
                listManage.add(new BasicFormat("租金交至", ""));
            } else {
                double hireSum = 0;
                for (Hirelist hirelist : list) {
                    Double hire = hirelist.getHire();
                    hireSum += hire;
                }
                listManage.add(new BasicFormat("已交租金", hireSum));
                listManage.add(new BasicFormat("未交租金", chartInfo.getTotalhire() - hireSum));
                listManage.add(new BasicFormat("租金交至", list.get(0).getHiredate()));
            }
            listManage.add(new BasicFormat("欠租原因", chartInfo.getOwehireresion()));
            listManage.add(new BasicFormat("经办人", chartInfo.getOperator()));
            listManage.add(new BasicFormat("房屋安置费", chartInfo.getPlacementFees()));
            listManage.add(new BasicFormat("天然气安装费", chartInfo.getGasInstallationFees()));
            listManage.add(new BasicFormat("暂停收租原因", chartInfo.getStophireinresion()));
            listManage.add(new BasicFormat("备注", chartInfo.getMemo()));
        } else {
            listManage.add(new BasicFormat("承租人", ""));
            listManage.add(new BasicFormat("性别", ""));
            listManage.add(new BasicFormat("承租人性质", ""));
            listManage.add(new BasicFormat("信誉等级", ""));
            listManage.add(new BasicFormat("证件类型", ""));
            listManage.add(new BasicFormat("证件号", ""));
            listManage.add(new BasicFormat("法人代表", ""));
            listManage.add(new BasicFormat("联系电话", ""));
            listManage.add(new BasicFormat("联系地址", ""));
            listManage.add(new BasicFormat("安置类型", ""));
            listManage.add(new BasicFormat("租赁性质", ""));
            listManage.add(new BasicFormat("计租面积", ""));
            listManage.add(new BasicFormat("月租金", ""));
            listManage.add(new BasicFormat("租赁标准", ""));
            listManage.add(new BasicFormat("租赁率", ""));
            listManage.add(new BasicFormat("保证金", ""));
            listManage.add(new BasicFormat("合同编号", ""));
            listManage.add(new BasicFormat("签订日期", ""));
            listManage.add(new BasicFormat("合同起始", ""));
            listManage.add(new BasicFormat("合同终止", ""));
            listManage.add(new BasicFormat("经营项目", ""));
            listManage.add(new BasicFormat("是否低保", ""));
            listManage.add(new BasicFormat("合同总额", ""));
            listManage.add(new BasicFormat("已交租金", 0.0));
            listManage.add(new BasicFormat("未交租金", 0.0));
            listManage.add(new BasicFormat("租金交至", ""));
            listManage.add(new BasicFormat("欠租原因", ""));
            listManage.add(new BasicFormat("经办人", ""));
            listManage.add(new BasicFormat("房屋安置费", 0.0));
            listManage.add(new BasicFormat("天然气安装费", 0.0));
            listManage.add(new BasicFormat("暂停收租原因", ""));
            listManage.add(new BasicFormat("备注", ""));
        }
        map.put("manage", listManage);
        return map;
    }
}
