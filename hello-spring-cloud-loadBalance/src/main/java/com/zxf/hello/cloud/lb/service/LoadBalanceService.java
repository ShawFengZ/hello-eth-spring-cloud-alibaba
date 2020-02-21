package com.zxf.hello.cloud.lb.service;

import com.zxf.hello.cloud.lb.entity.EthTask;
import com.zxf.hello.cloud.lb.entity.GethServ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface LoadBalanceService {

    public Map<LinkedList<EthTask>, ArrayList<GethServ>> loadBalance(List<EthTask> tasks, List<GethServ> gethSrvs, int disave);

}
