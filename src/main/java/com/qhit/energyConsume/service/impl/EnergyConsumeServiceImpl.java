package com.qhit.energyConsume.service.impl;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.energyConsume.service.IEnergyConsumeService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import com.qhit.energyConsume.dao.IEnergyConsumeDao;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class EnergyConsumeServiceImpl  implements IEnergyConsumeService {

    @Resource 
    IEnergyConsumeDao dao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 

    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 

    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 

    @Override 
    public boolean delete(Object id) { 
        EnergyConsume energyConsume = findById(id); 
        return dao.delete(energyConsume); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public EnergyConsume findById(Object id) { 
        List<EnergyConsume> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<EnergyConsume> search(EnergyConsume energyConsume) { 
        return dao.search(energyConsume); 
    }
    @Override
    public List flowConsume(String month, String year,Integer compid) {
        List list = dao.flowConsume(month, year, String.valueOf(compid));
        return list;
    }

    @Override
    public List devTypeConsume(String month, String year,Integer compid) {
        List list = dao.devTypeConsume(month, year,String.valueOf(compid));
        return list;
    }

    @Override
    public List devConsume(String month, String year,Integer compid) {
        List list = dao.devConsume(month, year,String.valueOf(compid));
        return list;
    }

    @Override
    public List electricConsume(String month, String year,Integer compid) {
        List list = dao.electricConsume(month, year,String.valueOf(compid));
        return list;
    }

    @Override
    public List waterConsume(String month, String year,Integer compid) {
        List list = dao.waterConsume(month, year,String.valueOf(compid));
        return list;
    }

    @Override
    public List oilConsume(String month, String year,Integer compid) {
        List list = dao.oilConsume(month, year,String.valueOf(compid));
        return list;
    }

    @Override
    @Transactional
    public boolean insert(ProduceReport produceReport, BaseFlow baseFlow) {
        //定义random便于生产随机数
        Random random = new Random();
//        --------------------------------------
        //设置需要保留的几位小数
        DecimalFormat df = new DecimalFormat("#.##");
        //工作量
        double f = Double.valueOf(String.valueOf(produceReport.getCapacity()))/10;
        //插入数据
        //声明对象
        EnergyConsume energyConsume1 = new EnergyConsume();
        EnergyConsume energyConsume2 = new EnergyConsume();
        EnergyConsume energyConsume3 = new EnergyConsume();
//        --------------斗轮机
        energyConsume1.setDevid(baseFlow.getDljid());
        energyConsume1.setElectric(Double.valueOf(df.format((random.nextInt(201)+100)*f*4)));
        energyConsume1.setWater(Double.valueOf(df.format((random.nextInt(10)+1)*f*4)));
        energyConsume1.setOil(Double.valueOf(df.format((random.nextInt(31)+10)*f*4)));
        energyConsume1.setReportid(produceReport.getReportid());
//        --------------装船机
        energyConsume2.setDevid(baseFlow.getZcjid());
        energyConsume2.setElectric(Double.valueOf(df.format((random.nextInt(201)+100)*f*4)));
        energyConsume2.setWater(Double.valueOf(df.format((random.nextInt(10)+1)*f*4)));
        energyConsume2.setOil(Double.valueOf(df.format((random.nextInt(31)+10)*f*4)));
        energyConsume2.setReportid(produceReport.getReportid());

//        --------------皮带机
        energyConsume3.setDevid(baseFlow.getPdjid());
        energyConsume3.setElectric(Double.valueOf(df.format((random.nextInt(201)+100)*f*2)));
        energyConsume3.setWater(Double.valueOf(df.format((random.nextInt(10)+1)*f*2)));
        energyConsume3.setOil(Double.valueOf(df.format((random.nextInt(31)+10)*f*2)));
        energyConsume3.setReportid(produceReport.getReportid());
        dao.insert(energyConsume1);
        dao.insert(energyConsume2);
        dao.insert(energyConsume3);
        return true;
    }

}