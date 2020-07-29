package com.voucher.manage2.dto.roomInfo;

import com.voucher.manage2.tkmapper.entity.Roominfo;
import lombok.Data;

@Data
public class RoomInfoDto extends Roominfo {

    private String imagePath;
    private String charter;
    private double totalHire;

}
