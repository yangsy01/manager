package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.service.AssetsDetailsService;
import com.voucher.manage2.tkmapper.mapper.ChartinfoMapper;
import com.voucher.manage2.tkmapper.mapper.FileselfbelongMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AssetsDetailsServiceImpl implements AssetsDetailsService {
    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private ChartinfoMapper chartinfoMapper;


    @Override
    public List<RoomInfoDTO> roomInfoDetails() {
        List<RoomInfoDTO> details = roominfoMapper.findDetails();
        return details;
    }

    @Override
    public List<ChartInfoDTO> chartInfoDetails() {
        List<ChartInfoDTO> details = chartinfoMapper.findDetails();
        return details;
    }
}
