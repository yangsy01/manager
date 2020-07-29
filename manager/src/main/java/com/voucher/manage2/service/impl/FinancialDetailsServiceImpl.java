package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.service.FinancialDetailsService;
import com.voucher.manage2.tkmapper.mapper.ChartinfoMapper;
import com.voucher.manage2.tkmapper.mapper.RoominfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FinancialDetailsServiceImpl implements FinancialDetailsService {
    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private ChartinfoMapper chartinfoMapper;

    @Override
    public List<RoomInfoDTO> emptyRoomDetails() {
        List<RoomInfoDTO> list = roominfoMapper.findEmptyDetails();
        return list;
    }

    @Override
    public List<ChartInfoDTO> overdueChartDetails() {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        String format = slf.format(new Date());
        Date parse = null;
        try {
            parse = slf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<ChartInfoDTO> list = chartinfoMapper.findOverdueRoomDetails(parse);
        return list;
    }

    @Override
    public List<RoomInfoDTO> rentRoomDetails() {
        List<RoomInfoDTO> list = roominfoMapper.findRentRoomDetails();
        return list;
    }

    @Override
    public List<RoomInfoDTO> businessRoomDetails() {
        List<RoomInfoDTO> list = roominfoMapper.findBusinessRoomDetails();
        return list;
    }


}
