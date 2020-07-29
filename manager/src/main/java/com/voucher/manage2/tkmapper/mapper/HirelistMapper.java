package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.details.hire.Deducted;
import com.voucher.manage2.dto.details.hire.Nonpayment;
import com.voucher.manage2.dto.hireList.HireListDTO;
import com.voucher.manage2.tkmapper.entity.Hirelist;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HirelistMapper extends Mapper<Hirelist>, InsertListMapper<Hirelist> {

    @Select("select HireDate from HireList order by HireDate asc ")
    List<String> findHiredate();

    @Select("select HireDate,Hire,State from HireList order by HireDate asc")
    List<Hirelist> findDateAndHire();

    @Select("select OptDate,HireDate,Hire from HireList order by OptDate asc")
    List<Hirelist> findDate();

    @Select("SELECT HireDate,Hire FROM HireList WHERE State = '已交' AND ChartGUID = #{chartGuid} ORDER BY HireDate DESC;")
    List<Hirelist> findByChartGuid(String chartGuid);

    @Select("select sum(Hire) from HireList where OptDate like '%' + #{now} + '%' ")
    Double findShiShou(String now);

    @Select("SELECT  sum(Hire) FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate < #{yearFirst} ")
    Double findThroughOwe(@Param("now")String now, @Param("yearFirst")String yearFirst);

    @Select("SELECT  sum(Hire) FROM HireList WHERE  OptDate LIKE '%' + #{now} + '%' and HireDate  LIKE '%' + #{s} + '%' ")
    Double findYishouNowYear(@Param("now")String now, @Param("s")String s );

    @Select("SELECT  sum(Hire) FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate > #{yearLast} ")
    Double findReceiveAdvance(@Param("now")String now, @Param("yearLast")String yearLast );


    @Select("SELECT  sum(Hire) hireCount FROM HireList where HireDate like '%' + #{s} + '%' ")
    Double findYingShou(String s);

    @Select("SELECT  sum(Hire) hireCount FROM HireList WHERE State = '已交' and HireDate like '%' + #{s} + '%' ")
    Double findYiShou(String s);

    @Select("SELECT  sum(Hire) hireCount FROM HireList WHERE State = '未交' and HireDate like '%' + #{s} + '%' ")
    Double findWeiShou(String s);

    @Select("SELECT  HireDate,sum(Hire) hireCount FROM HireList WHERE HireDate LIKE '%' + #{nowYear} + '%' GROUP BY HireDate ")
    List<HireListDTO> findYingShouByYear(String nowYear);

    @Select("SELECT  HireDate,sum(Hire) hireCount FROM HireList WHERE HireDate LIKE '%' + #{nowYear} + '%' and State = '已交' GROUP BY HireDate ")
    List<HireListDTO> findYiShouByYear(String nowYear);

    @Select("SELECT  sum(Hire) FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate < #{s} ")
    Double findLiShou(@Param("now")String now, @Param("s")String s );


    @Select("SELECT  sum(Hire) FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate > #{s} ")
    Double findYuShou(@Param("now")String now, @Param("s")String s );

    @Select("SELECT  sum(Hire) FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate = #{s} ")
    Double findDangYue(@Param("now")String now, @Param("s")String s );




    @Select("select hireDate,hire,beginDate,endDate,chartCriterion,state from HireList where state = '未交' and ChartGUID = #{chartGuid} ")
    List<Nonpayment> findNonpayment(String chartGuid);

    @Select("select hireDate,hire,beginDate,endDate,chartCriterion,state,payfashion,instruction,operator,optdate from HireList where State ='已交' and ChartGUID = #{chartGuid} ")
    List<Deducted> findDeducted(String chartGuid);

    @Select("SELECT  sum(Hire) sumH,count(hire) countH FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate < #{s} ")
    Map<String,Object> findLiShouCountAndSum(@Param("now")String now, @Param("s")String s );

    @Select("SELECT  sum(Hire) sumH,count(hire) countH FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate > #{s} ")
    Map<String,Object> findYuShouCountAndSum(@Param("now")String now, @Param("s")String s );

    @Select("SELECT  sum(Hire) sumH,count(hire) countH FROM HireList  WHERE OptDate LIKE '%' + #{now} + '%' AND HireDate = #{s} ")
    Map<String,Object> findDangYueCountAndSum(@Param("now")String now, @Param("s")String s );

    @Select("SELECT  sum(Hire) hireCount FROM HireList where HireDate like '%'+ #{s} + '%' ")
    Double findYingShouNow(String s);

    @Select("SELECT  sum(Hire) hireCount FROM HireList WHERE State = '已交' and HireDate like '%'+ #{s} + '%' ")
    Double findYiShouNow(String s);

    @Select("SELECT  sum(Hire) FROM HireList WHERE  state = '未交' and HireDate < #{s} ")
    Double findYingShouLQ(String s );

    @Select("select sum(hire) from HireList where HireDate >= #{yearFirst} and hiredate < #{yearLast} ")
    Double findAllHire(@Param("yearFirst") String yearFirst,@Param("yearLast") String yearLast);
}