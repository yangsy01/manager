package com.voucher.manage2.dto.roomInfo;

import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import lombok.Data;

@Data
public class ChartInfoDto extends Chartinfo {

    private String roomInfoGuid;
    private String imagePath;

}
