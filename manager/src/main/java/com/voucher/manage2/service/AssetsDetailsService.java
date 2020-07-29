package com.voucher.manage2.service;

import com.github.pagehelper.PageInfo;
import com.voucher.manage2.base.BasePage;
import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.dto.roomInfo.ChartInfoDto;
import com.voucher.manage2.dto.roomInfo.RoomInfoDto;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;

import java.util.List;

public interface AssetsDetailsService {

    //资产详情
    List<RoomInfoDTO> roomInfoDetails();

    //合同详情
    List<ChartInfoDTO> chartInfoDetails();


}
