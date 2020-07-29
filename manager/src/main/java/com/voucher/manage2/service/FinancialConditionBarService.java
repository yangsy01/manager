package com.voucher.manage2.service;

import java.util.List;

public interface FinancialConditionBarService {


    String emptyRoomBar(String name, String column, List<String> list);     //空置房屋
    String contractDueBar(String name,String column, List<String> list);   //到期合同
    String rentalHousingBar(String name,String column, List<String> list); //出租住宅
    String rentalOfficeBar(String name,String column, List<String> list);  //出租营业房

    String housingConBar(String name,String column, List<String> list);    //住宅房屋情况
    String officeConBar(String name,String column, List<String> list);     //营业房屋情况
    String rentReviseConBar(String name,String column, List<String> list); //租赁处数情况
    String rentAreaConBar(String name,String column, List<String> list);   //租赁面积情况

}
