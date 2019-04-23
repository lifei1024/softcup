package com.qhit.produceReport.service.impl;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.energyConsume.service.IEnergyConsumeService;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceJob.service.IProduceJobService;
import com.qhit.produceReport.service.IProduceReportService;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.qhit.produceReport.dao.IProduceReportDao;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class ProduceReportServiceImpl  implements IProduceReportService {

    @Resource 
    IProduceReportDao dao;
    @Resource
    IBaseFlowService baseFlowService;
    @Resource
    IProduceJobService produceJobService;
    @Resource
    IEnergyConsumeService energyConsumeService;

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
    @Transactional
    public boolean updateSelective(ProduceReport produceReport,BaseFlow baseFlow) {
        return dao.updateSelective(produceReport);
    }

    @Override
    public List<ProduceReport> findByCompid(Integer compid) {
        return dao.findByCompid(compid);
    }

    @Override
    public boolean delete(Object id) { 
        ProduceReport produceReport = findById(id); 
        return dao.delete(produceReport); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public ProduceReport findById(Object id) { 
        List<ProduceReport> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceReport> search(ProduceReport produceReport) { 
        return dao.search(produceReport); 
    }

    @Transactional
    @Override
    public void compoleteTask(ProduceReport produceReport) {
        dao.updateSelective(produceReport);
        try {
        //查询设备id
            BaseFlow baseFlow = baseFlowService.findById(produceReport.getFlowid());
            //获取船队的装载量
            ProduceReport produceReport1 = findById(produceReport.getReportid());
            //获取工作时长
            double jobs = duration(produceReport.getCompletetime(), produceReport.getStartjobtime());
            //添加作业信息表
            ProduceJob produceJobDl =  produceJobadd(produceReport,produceReport1.getCapacity()*2/5,baseFlow.getDljid(),jobs);
            ProduceJob produceJobZc =  produceJobadd(produceReport,produceReport1.getCapacity()*2/5,baseFlow.getZcjid(),jobs);
            ProduceJob produceJobPd =  produceJobadd(produceReport,produceReport1.getCapacity()/5,baseFlow.getPdjid(),jobs);
            produceJobService.insert(produceJobDl);
            produceJobService.insert(produceJobZc);
            produceJobService.insert(produceJobPd);
            //添加能耗信息表数据
            EnergyConsume energyConsumeDl = energyConsumeAdd(baseFlow.getDljid(),produceReport,produceReport1.getCapacity()*2/5,jobs);
            EnergyConsume energyConsumeZc = energyConsumeAdd(baseFlow.getZcjid(),produceReport,produceReport1.getCapacity()*2/5,jobs);
            EnergyConsume energyConsumePd = energyConsumeAdd(baseFlow.getPdjid(),produceReport,produceReport1.getCapacity()/5,jobs);
            energyConsumeService.insert(energyConsumeDl);
            energyConsumeService.insert(energyConsumeZc);
            energyConsumeService.insert(energyConsumePd);
        } catch (Exception e) {

        }

    }
    //添加能耗信息表对象
    public EnergyConsume energyConsumeAdd(Integer devid, ProduceReport produceReport, Float capacity, double jobs) {
        EnergyConsume energyConsume = new EnergyConsume();
        //保留两位小数
        DecimalFormat df = new DecimalFormat("#.00");
        //添加设备id，报岗id
        energyConsume.setDevid(devid);
        energyConsume.setReportid(produceReport.getReportid());
        //计算能耗
        Random random = new Random();
        //电耗：一吨作业量对应100~300度电 随机数100~300
        int el = random.nextInt(200) + 100;
        energyConsume.setElectric(Double.valueOf(df.format(capacity*el)));
        //水耗：一吨作业量对应1~10吨电 随机数1~10
        int wa = random.nextInt(10)+1;
        energyConsume.setWater(Double.valueOf(df.format(capacity*wa)));
        //油耗：一吨作业量对应10~40L油 随机数10~40   随机数：均保留两位小数
        int oi = random.nextInt(30)+10;
        energyConsume.setOil(Double.valueOf(df.format(capacity*oi)));
        return energyConsume;
    }
    //添加生产信息表对象
    public ProduceJob produceJobadd(ProduceReport produceReport, Float capacity, Integer devid, double jobs) {
        ProduceJob produceJob = new ProduceJob();
        produceJob.setDevid(devid);
        produceJob.setStarttime(produceReport.getStartjobtime());
        produceJob.setCompletetime(produceReport.getCompletetime());
        produceJob.setReportid(produceReport.getReportid());
        produceJob.setAmount(Double.valueOf(capacity));
        produceJob.setDuration(jobs);
        return produceJob;
    }
    //计算时长t1>t2
    public double duration(String t1,String t2) throws Exception {
        //计算时长
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将结束时间转换成日期格式
        Date comp = df.parse(t1);
        //将开始时间转换成日期格式
        Date start = df.parse(t2);
        //计算时长
        long shi = comp.getTime() - start.getTime();
        double i = shi / 1000.0 / 3600;
        double is = Math.round(i * 100) / 100.0;
        return is;
    }


}