package com.zxf.hello.spring.cloud.ethereum.consumer.feign.controller;

import com.zxf.hello.spring.cloud.ethereum.consumer.feign.service.BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/26 13:02
 */
@RequestMapping(value = "/blockchainconsumer")
@RestController
public class BlockChainController {

    @Autowired
    private BlockChainService blockChainService;

    /**
     * 获取币值
     * */
    @RequestMapping(value = "/getbalance")
    public String getBalanceOf(String address) throws Exception {
        String balanceOf = blockChainService.getBalanceOf(address);
        return balanceOf;
    }

    /**
     * 获得总的金额
     * */
    @RequestMapping(value = "/totalsupply")
    public String totalSupply() throws Exception {
        String bigInteger = blockChainService.totalSupply();
        return bigInteger;
    }

    /**
     * 从某个账户上删除代币
     * */
    @RequestMapping(value = "/deletetokenfrom")
    public String adminDeleteTokenFrom(String address, BigInteger value)  {
        String adminDeleteTokenFrom = blockChainService.adminDeleteTokenFrom(address, value);
        return adminDeleteTokenFrom;
    }

    /**
     * 为某个账户添加代币
     * */
    @RequestMapping(value = "/addtokento")
    public String adminAddTokenTo(String address, BigInteger value)  {
        return blockChainService.adminAddTokenTo(address, value);
    }

    /**
     * 在某两个账户之间转移代币
     * */
    @RequestMapping(value = "/transfer")
    public String adminTransfer(String from, String to, BigInteger value)  {
        String transfer = blockChainService.adminTransfer(from, to, value);
        return transfer;
    }

    /**
     * 为某个用户设置代币的值
     * */
    @RequestMapping(value = "/setbalanceof")
    public String adminSetBalanceOf(String who, BigInteger value)  {
        String setBalanceOf = blockChainService.adminSetBalanceOf(who, value);
        return setBalanceOf;
    }

    /**
     * 发布项目
     * */
    @RequestMapping(value = "/publishproject")
    public String publishProject(String publisher, String publishTime, String projectName, String projectHash)  {
        String publishProject = blockChainService.publishProject(publisher, publishTime, projectName, projectHash);
        return publishProject;
    }

    /**
     * 购买项目
     * */
    @RequestMapping(value = "/buyproject")
    public String buyProject(String buyer, String buyTime, String projectName, String projectHash)  {
        String buyProject = blockChainService.buyProject(buyer, buyTime, projectName, projectHash);
        return buyProject;
    }

    /**
     * 发布需求
     * */
    @RequestMapping(value = "/publishdemand")
    public String publishDemand(String publisher, String publishTime, String demandName, String demandHash)  {
        String publishDemand = blockChainService.publishDemand(publisher, publishTime, demandName, demandHash);
        return publishDemand;
    }

    /**
     * 回答需求
     * */
    @RequestMapping(value = "/answerdemand")
    public String answerDemand(String answerer, String answerTime, String demandName, String answerHash)  {
        String answerDemand = blockChainService.answerDemand(answerer, answerTime, demandName, answerHash);
        return answerDemand;
    }

    /**
     * 创建账户
     * */
    @RequestMapping(value = "/adduser")
    public String addUser(String password) throws IOException {
        String user = blockChainService.addUser(password);
        return user;
    }
}
