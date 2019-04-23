package com.qhit.energyConsume.service;

import java.util.List;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.produceReport.pojo.ProduceReport;

/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IEnergyConsumeService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    EnergyConsume findById(Object id);

    List<EnergyConsume> search(EnergyConsume energyConsume);
    List flowConsume(String month,String year,Integer compid);
    List devTypeConsume(String month,String year,Integer compid);
    List devConsume(String month,String year,Integer compid);
    List electricConsume(String month,String year,Integer compid);
    List waterConsume(String month,String year,Integer compid);
    List oilConsume(String month,String year,Integer compid);

    boolean insert(ProduceReport produceReport, BaseFlow baseFlow);
}