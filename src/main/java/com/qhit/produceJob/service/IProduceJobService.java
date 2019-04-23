package com.qhit.produceJob.service;

import java.util.List;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceReport.pojo.ProduceReport;

/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IProduceJobService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    ProduceJob findById(Object id);

    List<ProduceJob> search(ProduceJob produceJob);

    boolean insert(ProduceReport produceReport, BaseFlow baseFlow);
}