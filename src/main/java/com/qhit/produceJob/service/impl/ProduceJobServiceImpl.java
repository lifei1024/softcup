package com.qhit.produceJob.service.impl;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.produceJob.service.IProduceJobService;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.qhit.produceJob.dao.IProduceJobDao;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class ProduceJobServiceImpl  implements IProduceJobService {

    @Resource 
    IProduceJobDao dao;

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
        ProduceJob produceJob = findById(id); 
        return dao.delete(produceJob); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public ProduceJob findById(Object id) { 
        List<ProduceJob> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceJob> search(ProduceJob produceJob) { 
        return dao.search(produceJob); 
    }

    @Override
    @Transactional
    public boolean insert(ProduceReport produceReport, BaseFlow baseFlow) {
        SimpleDateFormat startjobtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat completetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double duration;
        try {
            long time = completetime.parse(produceReport.getCompletetime()).getTime()-startjobtime.parse(produceReport.getStartjobtime()).getTime();
            duration = (double)time/3600000;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
//        设置需要保留的几位小数
        DecimalFormat df = new DecimalFormat("#.##");
        ProduceJob produceJob1 = new ProduceJob();
        ProduceJob produceJob2 = new ProduceJob();
        ProduceJob produceJob3 = new ProduceJob();
        double f = Double.valueOf(String.valueOf(produceReport.getCapacity()))/10;
//       ----------------斗轮机
        produceJob1.setDevid(baseFlow.getDljid());
        produceJob1.setStarttime(produceReport.getStartjobtime());
        produceJob1.setCompletetime(produceReport.getCompletetime());
        produceJob1.setDuration(Double.valueOf(df.format(duration)));
        produceJob1.setAmount(f*4);
        produceJob1.setReportid(produceReport.getReportid());
//        ---------------装船机
        produceJob2.setDevid(baseFlow.getZcjid());
        produceJob2.setStarttime(produceReport.getStartjobtime());
        produceJob2.setCompletetime(produceReport.getCompletetime());
        produceJob2.setDuration(Double.valueOf(df.format(duration)));
        produceJob2.setAmount(f*4);
        produceJob2.setReportid(produceReport.getReportid());
//        ---------------皮带机
        produceJob3.setDevid(baseFlow.getPdjid());
        produceJob3.setStarttime(produceReport.getStartjobtime());
        produceJob3.setCompletetime(produceReport.getCompletetime());
        produceJob3.setDuration(Double.valueOf(df.format(duration)));
        produceJob3.setAmount(f*2);
        produceJob3.setReportid(produceReport.getReportid());

        dao.insert(produceJob1);
        dao.insert(produceJob2);
        dao.insert(produceJob3);

        return true;
    }

}