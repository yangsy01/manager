package com.voucher.manage2.service;


import java.util.Map;

/**
 * 概况类数据
 */
public interface AssetsConditionService {

        String findChartInfoCount(); //资产总数量
        String findChartInfoArea(); //资产总面积
        String findChartInfoUsers(); //合同总户数
        String findChartInfoEarnings(); //出租总收益


        String findRoomArea();     //  资产数量：住宅（营业,其他）面积占总面积比
        String findRoomProperty(); //  资产面积：住宅（营业,其他）户数占总户数比例
        String findDataDictionary();   //  资产分类：保障性住房，经营性住房，其他
        String findStructure();        //  资产结构（砖木，砖混，框架，钢结构，其他）


}
