package com.voucher.manage2.service;

import java.util.List;
import java.util.Map;

public interface StatementTwoService {

    public Map<String,Object> roomConAndArea(List<String> list);

    Map<String,Object> rentOut(List<String> list);
}
