package com.voucher.manage2.service;

public interface OperateConditionService {
    String chartAdd();//    资产处数新增

    String chartCut();//            资产处数减少

    String noCertificate();//    未办证房产

    String pledged();//            已抵押房产

    String chartAddCon();//    资产增加情况

    String chartCutCon();//            资产减少情况

    String certificateCon();//    权证办理情况

    String cAreaAdd();//            资产面积增加情况

    String cAreaCut();//    资产面积减少情况


    String certConArea();   //权证办理情况（面积）
}
