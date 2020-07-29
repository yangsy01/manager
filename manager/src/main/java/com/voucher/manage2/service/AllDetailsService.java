package com.voucher.manage2.service;


import com.voucher.manage2.dto.details.TopMessage;
import com.voucher.manage2.dto.roomInfo.AddressAndHireDTO;
import com.voucher.manage2.tkmapper.entity.Fileselfbelong;

import java.util.List;
import java.util.Map;

public interface AllDetailsService {
    Map<String, Object> findAll(String roomGuid);

    Map<String, Object> findAllByChartGuid(String roomGuid);

    Map<String, Object> findRoomCon(String guid, int pageIndex, int pageSize);

    Map<String, Object> findRoomRepair(String guid, int pageIndex, int pageSize);

    Map<String, Object> findRoomCheck(String guid, int pageIndex, int pageSize);

    Map<String, Object> findSafeCheck(String guid, int pageIndex, int pageSize);

    Map<String, Object> findNowDanger(String guid, int pageIndex, int pageSize);

    Map<String, Object> findNonpayment(String guid, int pageIndex, int pageSize);

    Map<String, Object> findDeducted(String guid, int pageIndex, int pageSize);

    Map<String, Object> findPayment(String guid, int pageIndex, int pageSize);

    Map<String, Object> findMarginPay(String guid, int pageIndex, int pageSize);

    List<Fileselfbelong> findPIC(String guid);

    List<Fileselfbelong> findChartPIC(String guid);

    TopMessage findTopMessage(String guid);

    List<String> returnAddress(String guid);
}
