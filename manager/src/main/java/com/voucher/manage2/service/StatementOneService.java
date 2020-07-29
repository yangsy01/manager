package com.voucher.manage2.service;

import java.util.List;
import java.util.Map;

public interface StatementOneService {

    public Map<String,Object> findRoomCountAndArea(List<String> list);

    public Map<String,Object> findStructure(List<String> list);

    Map<String, Object> findNature(List<String> list2);
}
