package com.voucher.manage2.service;

public interface FinancialConditionService {
    String emptyRoom(); //空置房屋
    String contractDue();   //到期合同
    String rentalHousing(); //出租住宅
    String rentalOffice();  //出租营业房

    String housingCon();    //住宅房屋情况
    String officeCon();     //营业房屋情况
    String rentReviseCon(); //租赁处数情况
    String rentAreaCon();   //租赁面积情况

}
