package com.voucher.manage2.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatementThreeService {

    public Map<String,Object> addChart(List<String> list);
    public Map<String,Object> cutChart(List<String> list);
    public Map<String,Object> propertyRight(List<Date> list);
    public Map<String,Object> impawn(List<String> list);

}
