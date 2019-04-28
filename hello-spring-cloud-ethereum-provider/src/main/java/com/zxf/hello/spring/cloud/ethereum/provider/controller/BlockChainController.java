package com.zxf.hello.spring.cloud.ethereum.provider.controller;

import com.zxf.hello.spring.cloud.ethereum.provider.service.BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:39
 */
@Controller
@ResponseBody
@RequestMapping(value = "/blockchain")
public class BlockChainController {

    @Autowired
    private BlockChainService blockChainService;

    /**
     * 获得某用户的币值
     *
     * 测试不成功
     * */
    @RequestMapping(value = "/getbalance")
    public String getBalanceOf(String address) throws Exception {
        BigInteger balanceOf = blockChainService.getBalanceOf(address);
        return balanceOf.toString();
    }

    /**
     * 获得总的金额
     * */
    @RequestMapping(value = "/totalsupply")
    public String totalSupply() throws Exception {
        BigInteger bigInteger = blockChainService.totalSupply();
        return bigInteger.toString();
    }

    /**
     * 从某个账户上删除代币
     * */
    @RequestMapping(value = "/deletetokenfrom")
    public String adminDeleteTokenFrom(String address, BigInteger value) throws Exception {
        String adminDeleteTokenFrom = blockChainService.adminDeleteTokenFrom(address, value);
        return adminDeleteTokenFrom;
    }

    /**
     * 为某个账户添加代币
     * */
    @RequestMapping(value = "/addtokento")
    public String adminAddTokenTo(String address, BigInteger value) throws Exception {
        return blockChainService.adminAddTokenTo(address, value);
    }

    /**
     * 在某两个账户之间转移代币
     * */
    @RequestMapping(value = "/transfer")
    public String adminTransfer(String from, String to, BigInteger value) throws Exception {
        String transfer = blockChainService.adminTransfer(from, to, value);
        return transfer;
    }

    /**
     * 为某个用户设置代币的值
     * */
    @RequestMapping(value = "/setbalanceof")
    public String adminSetBalanceOf(String who, BigInteger value) throws Exception {
        String setBalanceOf = blockChainService.adminSetBalanceOf(who, value);
        return setBalanceOf;
    }

    /**
     * 发布项目
     * */
    @RequestMapping(value = "/publishproject")
    public String publishProject(String publisher, String publishTime, String projectName, String projectHash) throws Exception {
        String publishProject = blockChainService.publishProject(publisher, publishTime, projectName, projectHash);
        return publishProject;
    }

    /**
     * 购买项目
     * */
    @RequestMapping(value = "/buyproject")
    public String buyProject(String buyer, String buyTime, String projectName, String projectHash) throws Exception {
        String buyProject = blockChainService.buyProject(buyer, buyTime, projectName, projectHash);
        return buyProject;
    }

    /**
     * 发布需求
     * */
    @RequestMapping(value = "/publishdemand")
    public String publishDemand(String publisher, String publishTime, String demandName, String demandHash) throws Exception {
        String publishDemand = blockChainService.publishDemand(publisher, publishTime, demandName, demandHash);
        return publishDemand;
    }

    /**
     * 回答需求
     * */
    @RequestMapping(value = "/answerdemand")
    public String answerDemand(String answerer, String answerTime, String demandName, String answerHash) throws Exception {
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

    /* ============================== 合约测试方法 ================================= */
    /**
     * 补充方法
     * */
    @RequestMapping(value = "/getcontractaddress")
    public String getContractAddress() throws Exception {
        String contractAddress = blockChainService.getContractAddress();
        return contractAddress;
    }
}
