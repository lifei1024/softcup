package com.qhit.reports.controller;

import com.qhit.baseCompany.pojo.BaseCompany;
import com.qhit.baseCompany.service.IBaseCompanyService;
import com.qhit.baseDevice.pojo.BaseDevice;
import com.qhit.baseDevice.service.IBaseDeviceService;
import com.qhit.baseDevtype.pojo.BaseDevtype;
import com.qhit.baseDevtype.service.IBaseDevtypeService;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.reports.pojo.JobBin;
import com.qhit.reports.service.IJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobAmount")
public class JobAmount {
    @Resource
    IJobService jobService;
    @Resource
    IBaseFlowService baseFlowService;
    @Resource
    IBaseDeviceService baseDeviceService;
    @Resource
    IBaseDevtypeService baseDevtypeService;
    @Resource
    IBaseCompanyService baseCompanyService;
    //流程名
    @RequestMapping("/flowAmount")
    public Object flowAmount(String year){
       Map map = new HashMap();
       Map[] ro = new Map[12];
        int j = 0;
        for (int i = 1; i < 13; i++) {
            List li = jobService.flowAmount(String.valueOf(i), year);
            if (li.size()!=0){
                Map map1 = new HashMap();
                JobBin o = (JobBin) li.get(0);
                String[] split = o.getFname().split(",");
                for (int k = 0; k < split.length; k++) {
                    String[] split1 = split[k].split(":");
                    map1.put(split1[0],split1[1]);
                }
                ro[j++] = map1;
            }
        }
        Map[] rows = new Map[j];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseFlow> all = baseFlowService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getFlowname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }

    @RequestMapping("/devTypeAmount")
    public Object devtypeAmount(String year){
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int j = 0;
        for (int i = 1; i < 13; i++) {
            List li = jobService.devtypeAmount(String.valueOf(i), year);
            if (li.size()!=0){
                Map map1 = new HashMap();
                JobBin o = (JobBin) li.get(0);
                String[] split = o.getFname().split(",");
                for (int k = 0; k < split.length; k++) {
                    String[] split1 = split[k].split(":");
                    map1.put(split1[0],split1[1]);
                }
                ro[j++] = map1;
            }
        }
        Map[] rows = new Map[j];
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
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }

    @RequestMapping("/devAmount")
    public Object devAmount(String year){
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int j = 0;
        for (int i = 1; i < 13; i++) {
            List li = jobService.devAmount(String.valueOf(i), year);
            if (li.size()!=0){
                Map map1 = new HashMap();
                JobBin o = (JobBin) li.get(0);
                String[] split = o.getFname().split(",");
                for (int k = 0; k < split.length; k++) {
                    String[] split1 = split[k].split(":");
                    map1.put(split1[0],split1[1]);
                }
                ro[j++] = map1;
            }
        }
        Map[] rows = new Map[j];
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
