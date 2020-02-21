package com.zxf.hello.cloud.lb.service.impl;

import com.zxf.hello.cloud.lb.entity.GethServ;
import com.zxf.hello.cloud.lb.service.EthsInfoService;

import java.util.List;

public class EthsInfoServiceImpl implements EthsInfoService {

    private String nacosIp;
    //获取目前运行的容器的状态信息
    //从注册管理中心nacos获取
    @Override
    public List<GethServ> getGethSrv() {
        return null;
    }
}
