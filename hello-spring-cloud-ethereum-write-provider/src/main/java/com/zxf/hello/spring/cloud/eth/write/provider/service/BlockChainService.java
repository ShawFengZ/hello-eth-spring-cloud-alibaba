package com.zxf.hello.spring.cloud.eth.write.provider.service;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:15
 */
public interface BlockChainService {
    /**
     * 获取某用户的币值
     * */
    public BigInteger getBalanceOf(String address) throws Exception;

    /**
     * 获取总共
     * */
    public BigInteger totalSupply() throws Exception;

    /**
     * 删除某用户的代币
     * */
    public String adminDeleteTokenFrom(String from, BigInteger value) throws Exception;

    /**
     * 为某用户添加代币
     * */
    public String adminAddTokenTo(String to, BigInteger value) throws Exception;

    /**
     * 转移代币
     * */
    public String adminTransfer(String from, String to, BigInteger value) throws Exception;

    /**
     * 为某用户设置代币有多少
     * */
    public String adminSetBalanceOf(String who, BigInteger value) throws Exception;

    /**
     * 发布项目
     * */
    public String publishProject(String publisher, String publishTime, String projectName, String projectHash) throws Exception;

    /**
     * 购买项目
     * */
    public String buyProject(String buyer, String buyTime, String projectName, String projectHash) throws Exception;

    /**
     * 发布需求
     * */
    public String publishDemand(String publisher, String publishTime, String demandName, String demandHash) throws Exception;

    /**
     * 回答需求
     * */
    public String answerDemand(String answerer, String answerTime, String demandName, String answerHash) throws Exception;

    /**
     * 创建账户
     * */
    public String addUser(String password) throws IOException;


    /* ========================================== 补充方法 ============================================== */
    public String getContractAddress() throws Exception;
}
