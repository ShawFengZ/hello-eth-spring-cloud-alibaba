package com.zxf.hello.cloud.lb.service.impl;

import com.zxf.hello.cloud.lb.entity.EthTask;
import com.zxf.hello.cloud.lb.entity.GethServ;
import com.zxf.hello.cloud.lb.service.LoadBalanceService;
import com.zxf.hello.cloud.lb.utils.GethSrvRecovery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class LoadBalanceServiceImpl implements LoadBalanceService {

    @Override
    public Map<LinkedList<EthTask>, ArrayList<GethServ>> loadBalance(List<EthTask> tasks, List<GethServ> gethSrvs, int disave) {
        Map<LinkedList<EthTask>, ArrayList<GethServ>> res = new HashMap<>();
        int lbh = 0;
        ArrayList<GethServ> gethSrvPool = new ArrayList<>();
        List<GethServ> gethSrvRecover = new ArrayList<>();
        LinkedList<EthTask> ethTaskList = new LinkedList<>();
        for (int i=0; i<gethSrvs.size(); i++) {
            GethServ gethServ = gethSrvs.get(i);
            double tmpDistance = disave - Math.sqrt(gethServ.getCpu()*gethServ.getCpu() +
                    gethServ.getMem()*gethServ.getMem());
            lbh += tmpDistance;
            if (tmpDistance < 0) {
                gethSrvPool.add(gethServ);
            } else {
                gethSrvRecover.add(gethServ);
            }
        }
        //启动服务容器回收
        if (lbh < 0) {
            GethSrvRecovery gethRecovery = new GethSrvRecovery();
            try {
                gethRecovery.recoverSrvs(gethSrvRecover);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<tasks.size(); i++) {
            EthTask ethTask = tasks.get(i);
            if (ethTask.getProperty() == 0) {
                ethTaskList.add(ethTask);
            } else {
                ethTaskList.addFirst(ethTask);
            }
        }
        res.put(ethTaskList, gethSrvPool);
        return res;
    }

}
