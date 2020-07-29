package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.details.*;
import com.voucher.manage2.dto.details.hire.Deducted;
import com.voucher.manage2.dto.details.hire.MarginPay;
import com.voucher.manage2.dto.details.hire.Nonpayment;
import com.voucher.manage2.dto.details.hire.Payment;
import com.voucher.manage2.dto.roomInfo.AddressAndHireDTO;
import com.voucher.manage2.service.AllDetailsService;
import com.voucher.manage2.tkmapper.entity.*;
import com.voucher.manage2.tkmapper.mapper.*;
import com.voucher.manage2.utils.ListUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AllDetailsServiceImpl implements AllDetailsService {

    @Resource
    private ChartinfoMapper chartinfoMapper;
    @Resource
    private RoominfoMapper roominfoMapper;
    @Resource
    private HirelistMapper hirelistMapper;
    @Resource
    private AssetsCheckDateMapper assetsCheckDateMapper;
    @Resource
    private HiddenCheckMapper hiddenCheckMapper;
    @Resource
    private HiddenCheckDateMapper checkDateMapper;
    @Resource
    private RoomLogMapper roomLogMapper;
    @Resource
    private AssetsCheckMapper assetsCheckMapper;
    @Resource
    private HirepayMapper hirepayMapper;
    @Resource
    private FileselfbelongMapper fileselfbelongMapper;


    /**
     * 通过roomGuid查询所有
     *
     * @param roomGuid
     * @return
     */
    @Override
    public Map<String, Object> findAll(String roomGuid) {
        Roominfo roominfo = roominfoMapper.findByGuid(roomGuid);
        if (roominfo != null) {
            Chartinfo chartInfo = chartinfoMapper.findByGuid(roominfo.getChartguid());
            Map<String, Object> map = ListUtils.findAll(roominfo, chartInfo, hirelistMapper);
            return map;
        } else {
            Chartinfo chartInfo = chartinfoMapper.findByGuid("");
            Map<String, Object> map = ListUtils.findAll( roominfo, chartInfo, hirelistMapper);
            return map;
        }
    }

    /**
     * 通过chartGuid查询所有
     *
     * @param chartGuid
     * @return
     */
    @Override
    public Map<String, Object> findAllByChartGuid(String chartGuid) {
        Chartinfo chartinfo = chartinfoMapper.findByChartGuid(chartGuid);
        Map<String, Object> map = ListUtils.findManage(chartinfo, hirelistMapper);
        return map;

    }

    @Override
    public Map<String, Object> findRoomCon(String roomGuid, int pageIndex, int pageSize) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        List<RoomCon> listRoomCon = new ArrayList<>();
        List<RoomLog> roomLogs = roomLogMapper.findByRoomGuid(roomGuid);
        if (roomLogs != null && roomLogs.size() > 0) {
            for (RoomLog roomLog : roomLogs) {
                RoomCon roomCon = new RoomCon();
                roomCon.setAction(roomLog.getActiontype());
                Date actiondate = roomLog.getActiondate();
                String date = null;
                if (actiondate != null) {
                    date = slf.format(actiondate);
                }
                roomCon.setDate(date);
                roomCon.setScan(roomLog.getIsfile());
                roomCon.setLogs(roomLog.getInstruction());
                roomCon.setOperator(roomLog.getOperator());
                roomCon.setOperatorDate(date);
                listRoomCon.add(roomCon);
            }
        }
        Map map = ListUtils.returnMap(listRoomCon, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findRoomRepair(String roomGuid, int pageIndex, int pageSize) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        List<Repair> listRepair = new ArrayList<>();
        List<RoomLog> roomLogs = roomLogMapper.findRepairByRoomGuid(roomGuid);
        if (roomLogs != null && roomLogs.size() > 0) {
            for (RoomLog roomLog : roomLogs) {
                Repair repair = new Repair();
                Date date2 = roomLog.getActiondate();
                String repairDate = null;
                if (date2 != null) {
                    repairDate = slf.format(date2);
                }
                repair.setDate(repairDate);
                repair.setScan(roomLog.getIsfile());
                repair.setRepairCon(roomLog.getInstruction());
                repair.setOperator(roomLog.getOperator());
                repair.setOperatorDate(repairDate);
                listRepair.add(repair);
            }
        }
        Map map = ListUtils.returnMap(listRepair, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findRoomCheck(String roomGuid, int pageIndex, int pageSize) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        List<RoomCheck> listRoomCheck = new ArrayList<>();
        List<AssetsCheck> assetsChecks = assetsCheckMapper.findByRoomGuid(roomGuid);
        if (assetsChecks != null && assetsChecks.size() > 0) {
            for (AssetsCheck assetsCheck : assetsChecks) {
                RoomCheck roomCheck = new RoomCheck();
                roomCheck.setCheckCon(assetsCheck.getCheckName());
                roomCheck.setContent(assetsCheck.getCheckCircs());
                roomCheck.setMemo(assetsCheck.getRemark());
                roomCheck.setCheckName("");
                Date date = assetsCheck.getDate();
                String checkDate = null;
                if (date != null) {
                    checkDate = slf.format(date);
                }
                roomCheck.setCheckDate(checkDate);
                List<AssetsCheckDate> assetsCheckDates = assetsCheckDateMapper.findByCheckId(assetsCheck.getCheckId());
                if (assetsCheckDates != null && assetsCheckDates.size() > 0) {
                    roomCheck.setIsPic("有");
                } else {
                    roomCheck.setIsPic("无");
                }
                listRoomCheck.add(roomCheck);
            }
        }
        Map map = ListUtils.returnMap(listRoomCheck, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findSafeCheck(String roomGuid, int pageIndex, int pageSize) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        List<HiddenCheck> hiddenChecks = hiddenCheckMapper.findByRoomGuid(roomGuid);
        List<SafeCheck> listSafeCheck = new ArrayList<>();
        if (hiddenChecks != null && hiddenChecks.size() > 0) {
            for (HiddenCheck hiddenCheck : hiddenChecks) {
                SafeCheck safeCheck = new SafeCheck();
                safeCheck.setCheckResult(hiddenCheck.getCheckName());
                safeCheck.setContent(hiddenCheck.getCheckCircs());
                safeCheck.setMemo(hiddenCheck.getRemark());
                safeCheck.setCheckName("");
                Date date = hiddenCheck.getDate();
                String checkDate = null;
                if (date != null) {
                    checkDate = slf.format(date);
                }
                safeCheck.setCheckDate(checkDate);
                List<HiddenCheckDate> hiddenCheckDate = checkDateMapper.findByCheckId(hiddenCheck.getCheckId());
                if (hiddenCheckDate != null && hiddenCheckDate.size() > 0) {
                    safeCheck.setIsPic("有");
                } else {
                    safeCheck.setIsPic("无");
                }
                safeCheck.setState(hiddenCheck.getState());
                listSafeCheck.add(safeCheck);
            }
        }
        Map map = ListUtils.returnMap(listSafeCheck, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findNowDanger(String roomGuid, int pageIndex, int pageSize) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        List<NowDanger> listNowDanger = new ArrayList<>();
        List<HiddenCheck> hiddenCheckList = hiddenCheckMapper.findNowByRoomGuid(roomGuid);
        if (hiddenCheckList != null && hiddenCheckList.size() > 0) {
            for (HiddenCheck hiddenCheck : hiddenCheckList) {
                NowDanger nowDanger = new NowDanger();
                nowDanger.setDangerContent(hiddenCheck.getCheckCircs());
                nowDanger.setMemo(hiddenCheck.getRemark());
                Date date1 = hiddenCheck.getDate();
                String checkDate = null;
                if (date1 != null) {
                    checkDate = slf.format(date1);
                }
                nowDanger.setLookDate(checkDate);
                List<HiddenCheckDate> hiddenCheckDate1 = checkDateMapper.findByCheckId(hiddenCheck.getCheckId());
                if (hiddenCheckDate1 != null) {
                    nowDanger.setIsPic("有");
                } else {
                    nowDanger.setIsPic("无");
                }
                nowDanger.setState(hiddenCheck.getState());
                listNowDanger.add(nowDanger);
            }
        }
        Map map = ListUtils.returnMap(listNowDanger, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findNonpayment(String chartGuid, int pageIndex, int pageSize) {
        List<Nonpayment> nonpayments = hirelistMapper.findNonpayment(chartGuid);
        Map map = ListUtils.returnMap(nonpayments, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findDeducted(String chartGuid, int pageIndex, int pageSize) {
        List<Deducted> deducted = hirelistMapper.findDeducted(chartGuid);
        Map map = ListUtils.returnMap(deducted, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findPayment(String chartGuid, int pageIndex, int pageSize) {
        List<Payment> payment = hirepayMapper.findPayment(chartGuid);
        Map map = ListUtils.returnMap(payment, pageIndex, pageSize);
        return map;
    }

    @Override
    public Map<String, Object> findMarginPay(String chartGuid, int pageIndex, int pageSize) {
        List<MarginPay> marginPay = hirepayMapper.findMarginPay(chartGuid);
        Map map = ListUtils.returnMap(marginPay, pageIndex, pageSize);
        return map;
    }





    @Override
    public List<Fileselfbelong> findPIC(String roomGuid) {
        List<Fileselfbelong> list = fileselfbelongMapper.findPIC(roomGuid);
        return list;
    }

    @Override
    public List<Fileselfbelong> findChartPIC(String guid) {
        List<Fileselfbelong> list =  fileselfbelongMapper.findByChartGuid(guid);
        return list;
    }

    @Override
    public TopMessage findTopMessage(String roomGuid) {
        TopMessage topMessage = roominfoMapper.findTopMessage(roomGuid);
        if(topMessage == null){
            TopMessage topMessage1 = new TopMessage();
            topMessage1.setNum("");
            topMessage1.setAddress("");
            topMessage1.setOriginaladdress("");
            topMessage1.setBuildarea(0.0);
            topMessage1.setHire(0.0);
            topMessage1.setChartGuid("");
            return topMessage1;
        }
        return topMessage;
    }

    @Override
    public List<String> returnAddress(String chartGuid) {
        return roominfoMapper.findByChartGuid(chartGuid);
    }
}
