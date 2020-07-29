package com.voucher.manage2.service;

import java.util.List;

public interface SecurityConditionBarService {
    String patrolBar(String name,String column, List<String> list);
    String hidDangerBar(String name,String column, List<String> list);
    String abarbeitungBar(String name,String column, List<String> list);
    String noAbarbeitungBar(String name,String column, List<String> list);
    String dgRoomBar(String name,String column, List<String> list);

    String hidRateBar(String name,String column, List<String> list);
    String abaRateBar(String name,String column, List<String> list);
    String dgRoomRateBar(String name,String column, List<String> list);
}
