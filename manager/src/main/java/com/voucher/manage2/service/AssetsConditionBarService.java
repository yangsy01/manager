package com.voucher.manage2.service;

import net.sf.json.JSONObject;

import java.util.List;

/**
 * 概况类数据柱状图
 */
public interface AssetsConditionBarService {


    String findCountBar(String name, String column, List<String> list);
    String findAreaBar(String name,String column, List<String> list);
    String findChartBar(String name,String column, List<String> list);
    String findEarningsBar(String name,String column, List<String> list);

    String findRoomPropertyBar(String name,String column, List<String> list); //  资产面积：住宅（营业,其他）户数占总户数比例

    String findRoomAreaBar(String name,String column, List<String> list);     //  资产数量：住宅（营业,其他）面积占总面积比
    String findDataDictionaryBar();   //  资产分类：保障性住房，经营性住房，其他
    String findStructureBar(String name,String column, List<String> list);        //  资产结构（砖木，砖混，钢结构，其他）
}
