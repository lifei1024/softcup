package com.qhit.produceReport.service;

import java.util.List;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.produceReport.pojo.ProduceReport;
/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IProduceReportService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    ProduceReport findById(Object id);

    List<ProduceReport> search(ProduceReport produceReport);

    void compoleteTask(ProduceReport produceReport);

    boolean  updateSelective(ProduceReport produceReport, BaseFlow baseFlow);

    List<ProduceReport> findByCompid(Integer compid);
}