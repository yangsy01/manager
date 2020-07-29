package com.voucher.manage2.service;

public interface SecurityConditionService {
    String patrol();    //巡查次数
    String hidDanger();     //隐患次数
    String abarbeitung();       //整改次数
    String noAbarbeitung();     //未整改次数
    String dgRoom();        //危房处数

    String hidRate();       //隐患率
    String abaRate();       //整改率
    String dgRoomRate();    //危房率

    String having();


    String notDgRateBar();

    String HavingRateBar();

    String yinHuanRateBar();
}
