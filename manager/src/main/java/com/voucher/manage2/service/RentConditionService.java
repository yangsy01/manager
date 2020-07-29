package com.voucher.manage2.service;

import net.sf.json.JSONObject;

/**
 * 年度收取租金状况
 */
public interface RentConditionService {
    //年度应收租金
    public String receivable();

    //年度已收租金
    public String take();

    //年度未收租金
    public String noTake();

    //年度实收租金
    public String received();

    //年度收取历欠租金
    public String throughOwe();

    //年度预收租金
    public String precollected();

    //租金收取情况
    public String hireCon();

    //当月租金收入情况
    public String monthHireCon(JSONObject mapKV);


    String yingShouLQ();

    String yiShou();


}
