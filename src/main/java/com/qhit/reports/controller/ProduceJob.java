package com.qhit.reports.controller;

import com.qhit.baseCompany.pojo.BaseCompany;
import com.qhit.baseCompany.service.IBaseCompanyService;
import com.qhit.baseDevice.service.IBaseDeviceService;
import com.qhit.baseDevtype.service.IBaseDevtypeService;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
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
@RequestMapping("/produceJob")
public class ProduceJob {
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
            List<Map> list = jobService.selectModel(year, baseFlows.get(i));
            for (int j = 0; j < list.size(); j++) {
                amount += (double)list.get(j).get("amount");
                list.get(j).put("amount",list.get(j).get("amount")+"吨");
            }
            amounts+=amount;
            map1.put("flow",baseFlows.get(i).getFlowname());
            map1.put("amount",amount+"吨");
            map1.put("children",list);
            m.add(map1);
        }
        System.out.println(m);

        map.put("comp",baseCompany.getCompname());
        map.put("amount",amounts+"吨");
        map.put("children",m);

        return  map;
    }



}
