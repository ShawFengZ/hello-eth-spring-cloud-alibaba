package com.zxf.hello.cloud.lb.controller;

import com.zxf.hello.cloud.lb.entity.EthTask;
import com.zxf.hello.cloud.lb.entity.GethServ;
import com.zxf.hello.cloud.lb.service.LoadBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class LoadBalanceController {

    @Autowired
    private LoadBalanceService loadBalanceService;

    public Map<LinkedList<EthTask>, ArrayList<GethServ>> loadBalance(List<EthTask> tasks, List<GethServ> gethSrvs, int disave){
        Map<LinkedList<EthTask>, ArrayList<GethServ>> loadBalance = loadBalanceService.loadBalance(tasks, gethSrvs, disave);
        if (loadBalance.size() > 0) {
            return loadBalance;
        } else {
            System.out.println("loadBalance failed!");
            return null;
        }
    }
}
