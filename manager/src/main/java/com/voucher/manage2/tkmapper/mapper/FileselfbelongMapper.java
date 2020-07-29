package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Fileselfbelong;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FileselfbelongMapper extends Mapper<Fileselfbelong>, InsertListMapper<Fileselfbelong> {
    @Select("select UpFileFullName from FileSelfBelong where  FileBelong = '房屋图片' ")
    List<Fileselfbelong> selectByRoomInfoGuid(String guid);

    @Select("select UpFileFullName from FileSelfBelong where  FileBelong = '房屋图片' and RoomGUID = #{guid} ")
    List<Fileselfbelong> findPIC(String guid);

    @Select("SELECT  f.UpFileFullName FROM (SELECT GUID from RoomInfo WHERE ChartGUID = #{chartGUID} ) room LEFT JOIN (SELECT UpFileFullName,RoomGUID FROM FileSelfBelong WHERE FileBelong = '房屋图片' ) f ON room.guid = f.roomGUID")
    List<Fileselfbelong> findByChartGuid(String chartGUID);
}