package com.voucher.manage2.service;

import java.util.List;

public interface DataAnalysisService {
    String findCountBar(String name, String column, List<String> list);
    String findAreaBar(String name,String column, List<String> list);
    String findChartBar(String name,String column, List<String> list);
    String findEarningsBar(String name,String column, List<String> list);



    String patrolBar(String name, String column, List<String> list);        //巡查

    String hidDangerBar(String name,String column, List<String> list);
    String abarbeitungBar(String name,String column, List<String> list);
    String noAbarbeitungBar(String name,String column, List<String> list);

    String notDgRateBar(String name,String column, List<String> list);
    String HavingRateBar(String name,String column, List<String> list);
    String yinHuanRateBar(String name,String column, List<String> list);

}
