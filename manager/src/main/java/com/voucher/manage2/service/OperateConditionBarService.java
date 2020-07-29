package com.voucher.manage2.service;

import java.util.List;

public interface OperateConditionBarService {
    String chartAddBarC(String name,String column, List<String> list);//    资产处数新增
    String chartAddBarA(String name,String column, List<String> list);//    资产处数面积新增

    String chartCutBarC(String name,String column, List<String> list);//            资产处数减少
    String chartCutBarA(String name,String column, List<String> list);//            资产处数面积减少

    String noCertificateBar(String name,String column, List<String> list);//    未办证房产

    String pledgedBar(String name,String column, List<String> list);//            已抵押房产

    String chartAddConBar(String name,String column, List<String> list);//    资产增加情况

    String chartCutConBar(String name,String column, List<String> list);//            资产减少情况

    String certificateConBar(String name,String column, List<String> list);//    权证办理情况

    String cAreaAddBar(String name,String column, List<String> list);//            资产面积增加情况

    String cAreaCutBar(String name,String column, List<String> list);//    资产面积减少情况
}
