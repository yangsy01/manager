package com.voucher.manage2.service;

import java.util.List;

public interface RentConditionBarService {


    //年度应收租金
    public String receivableBar(String name,String column, List<String> list);

    //年度已收租金
    public String takeBar(String name,String column, List<String> list);

    //年度未收租金
    public String noTakeBar(String name,String column, List<String> list);

    //年度实收租金
    public String receivedBar(String name,String column, List<String> list);

    //年度收取历欠租金
    public String throughOweBar(String name,String column, List<String> list);

    //年度预收租金
    public String precollectedBar(String name,String column, List<String> list);


    //租金收取情况
    public String hireCon();

    //当月租金收入情况
    public String monthHireCon();
}
