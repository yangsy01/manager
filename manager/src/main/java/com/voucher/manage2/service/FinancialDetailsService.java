package com.voucher.manage2.service;

import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.dto.roomInfo.ChartInfoDto;
import com.voucher.manage2.dto.roomInfo.RoomInfoDto;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;

import java.util.List;

public interface FinancialDetailsService {
    List<RoomInfoDTO> emptyRoomDetails();

    List<ChartInfoDTO> overdueChartDetails();

    List<RoomInfoDTO> rentRoomDetails();

    List<RoomInfoDTO> businessRoomDetails();

}
