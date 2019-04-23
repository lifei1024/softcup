package com.qhit.energyConsume.controller; 

import com.qhit.baseCompany.pojo.BaseCompany;
import com.qhit.baseCompany.service.IBaseCompanyService;
import com.qhit.baseDevice.pojo.BaseDevice;
import com.qhit.baseDevice.service.IBaseDeviceService;
import com.qhit.baseDevtype.pojo.BaseDevtype;
import com.qhit.baseDevtype.service.IBaseDevtypeService;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.energyConsume.service.IEnergyConsumeService;
import com.qhit.produceReport.service.IProduceReportService;
import com.qhit.reports.service.IJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/10
*/ 

@RestController 
@RequestMapping("/energyConsume") 
public class EnergyConsumeController { 

    @Resource 
    IEnergyConsumeService energyConsumeService; 
    @Resource
    IBaseCompanyService baseCompanyService;
    @Resource
    IBaseFlowService baseFlowService;
    @Resource
    IJobService jobService;
    @Resource
    IBaseDevtypeService baseDevtypeService;
    @Resource
    IBaseDeviceService baseDeviceService;
    @RequestMapping("/insert") 
    public void insert(EnergyConsume energyConsume) { 
        energyConsumeService.insert(energyConsume); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer consumeid) { 
        energyConsumeService.delete(consumeid); 
    } 

    @RequestMapping("/update") 
    public void update(EnergyConsume energyConsume) { 
        energyConsumeService.update(energyConsume); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(EnergyConsume energyConsume) { 
        energyConsumeService.updateSelective(energyConsume); 
    } 

    @RequestMapping("/load") 
    public EnergyConsume load(Integer consumeid) { 
        EnergyConsume energyConsume = energyConsumeService.findById(consumeid); 
        return energyConsume; 
    } 

    @RequestMapping("/list") 
    public List<EnergyConsume> list()  { 
        List<EnergyConsume> list = energyConsumeService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<EnergyConsume> search(EnergyConsume energyConsume) { 
        List<EnergyConsume> list = energyConsumeService.search(energyConsume); 
        return list; 
    }

    @RequestMapping("/model")
    public Object model(String year, HttpSession session){
        Map map = new HashMap();
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Integer compid = baseUser.getCompid();
        BaseCompany baseCompany = baseCompanyService.findById(compid);
        List<BaseFlow> baseFlows = baseFlowService.findByCompid(compid);
        double amounts = 0;
        List<Map> m = new ArrayList<Map>();
        for (int i = 0; i < baseFlows.size(); i++) {
            Map map1 = new HashMap();
            double amount = 0;
            List<Map> list = jobService.selectConsume(year, baseFlows.get(i));
            for (int j = 0; j < list.size(); j++) {
                amount += (double)list.get(j).get("consume");
            }
            amounts+=amount;
            map1.put("flow",baseFlows.get(i).getFlowname());
            map1.put("consume",amount);
            map1.put("children",list);
            m.add(map1);
        }
        System.out.println(m);

        map.put("comp",baseCompany.getCompname());
        map.put("consume",amounts);
        map.put("children",m);

        return  map;
    }
    //流程能耗对比图-折标煤
    @RequestMapping("/flowConsume")
    public Object flowConsume (String year,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int c = 0;
        for (int i = 1; i < 13; i++) {
            List<EnergyConsume> list = energyConsumeService.flowConsume(String.valueOf(i), year,baseUser.getCompid());
            if (list!=null && list.size()!=0){
                Map map1 = new HashMap();
                map1.put("月份",i+"月");
                for (int j = 0; j < list.size(); j++) {
                    map1.put(list.get(j).getFlowname(),list.get(j).getFc());
                }
                ro[c++] = map1;
            }
        }
        Map[] rows = new Map[c];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseFlow> all = baseFlowService.findByCompid(baseUser.getCompid());
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getFlowname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }
    //设备类别能耗对比图-折标煤
    @RequestMapping("/devTypeConsume")
    public Object devTypeConsume (String year,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int c = 0;
        for (int i = 1; i < 13; i++) {
            List<EnergyConsume> list = energyConsumeService.devTypeConsume(String.valueOf(i), year,baseUser.getCompid());
            if (list!=null && list.size()!=0){
                Map map1 = new HashMap();
                map1.put("月份",i+"月");
                for (int j = 0; j < list.size(); j++) {
                    map1.put(list.get(j).getTypename(),list.get(j).getFc());
                }
                ro[c++] = map1;
            }
        }
        Map[] rows = new Map[c];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseDevtype> all = baseDevtypeService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getTypename();
        }
        map.put("column",columns);
        map.put("rows",rows);
        return map;
    }
    //设备能耗对比图-折标煤
    @RequestMapping("/devConsume")
    public Object devConsume (String year,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int c = 0;
        for (int i = 1; i < 13; i++) {
            List<EnergyConsume> list = energyConsumeService.devConsume(String.valueOf(i), year,baseUser.getCompid());
            if (list!=null && list.size()!=0){
                Map map1 = new HashMap();
                map1.put("月份",i+"月");
                for (int j = 0; j < list.size(); j++) {
                    map1.put(list.get(j).getDevname(),list.get(j).getFc());
                }
                ro[c++] = map1;
            }
        }
        Map[] rows = new Map[c];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseDevice> all = baseDeviceService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getDevname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }//设备单位作业量耗电量对比图
    @RequestMapping("/electricConsume")
    public Object electricConsume (String year,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int c = 0;
        for (int i = 1; i < 13; i++) {
            List<EnergyConsume> list = energyConsumeService.electricConsume(String.valueOf(i), year,baseUser.getCompid());
            if (list!=null && list.size()!=0){
                Map map1 = new HashMap();
                map1.put("月份",i+"月");
                for (int j = 0; j < list.size(); j++) {
                    map1.put(list.get(j).getDevname(),list.get(j).getFc());
                }
                ro[c++] = map1;
            }
        }
        Map[] rows = new Map[c];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseDevice> all = baseDeviceService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getDevname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }//设备单位作业量耗水量对比图
    @RequestMapping("/waterConsume")
    public Object waterConsume (String year,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int c = 0;
        for (int i = 1; i < 13; i++) {
            List<EnergyConsume> list = energyConsumeService.waterConsume(String.valueOf(i), year,baseUser.getCompid());
            if (list!=null && list.size()!=0){
                Map map1 = new HashMap();
                map1.put("月份",i+"月");
                for (int j = 0; j < list.size(); j++) {
                    map1.put(list.get(j).getDevname(),list.get(j).getFc());
                }
                ro[c++] = map1;
            }
        }
        Map[] rows = new Map[c];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseDevice> all = baseDeviceService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getDevname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }//设备单位作业量耗油量对比图
    @RequestMapping("/oilConsume")
    public Object oilConsume (String year,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int c = 0;
        for (int i = 1; i < 13; i++) {
            List<EnergyConsume> list = energyConsumeService.oilConsume(String.valueOf(i), year,baseUser.getCompid());
            if (list!=null && list.size()!=0){
                Map map1 = new HashMap();
                map1.put("月份",i+"月");
                for (int j = 0; j < list.size(); j++) {
                    map1.put(list.get(j).getDevname(),list.get(j).getFc());
                }
                ro[c++] = map1;
            }
        }
        Map[] rows = new Map[c];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseDevice> all = baseDeviceService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getDevname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }
} 
