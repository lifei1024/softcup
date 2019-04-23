package com.qhit.reports.dao;

import com.qhit.produceReport.pojo.ProduceReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/** 
* Created by GeneratorCode on 2019/04/10
*/

@Mapper  
public interface IJobDao {
    List flowAmount(String month, String year);
    List devtypeAmount(String month, String year);
    List devAmount(String month, String year);


    //4.16
    List<Map> selectModel(Map map);

    List<Map> selectConsume(Map map);
}