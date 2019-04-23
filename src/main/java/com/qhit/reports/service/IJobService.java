package com.qhit.reports.service;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.produceReport.pojo.ProduceReport;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IJobService {

    List flowAmount(String month, String year);
    List devtypeAmount(String month, String year);
    List devAmount(String month, String year);





    List<Map> selectModel(String year,BaseFlow baseFlow);

    List<Map> selectConsume(String year, BaseFlow baseFlow);
}