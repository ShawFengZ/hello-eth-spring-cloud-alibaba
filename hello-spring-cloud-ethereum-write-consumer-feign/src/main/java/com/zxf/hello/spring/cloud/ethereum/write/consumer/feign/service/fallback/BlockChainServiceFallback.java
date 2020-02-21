package com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service.fallback;

import com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service.BlockChainService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/26 12:23
 */
@Component
public class BlockChainServiceFallback implements BlockChainService {
    /**
     * 获得某用户的币值
     *
     * @param address
     */
    @Override
    public String getBalanceOf(String address) {
        return "getBalance fallback!";
    }

    /**
     * 获得总的金额
     */
    @Override
    public String totalSupply() {
        return "get total supply fallback!";
    }

    /**
     * 从某个账户上删除代币
     *
     * @param address
     * @param value
     */
    @Override
    public String adminDeleteTokenFrom(String address, BigInteger value) {
        return "delete token fallback!";
    }

    /**
     * 为某个账户添加代币
     *
     * @param address
     * @param value
     */
    @Override
    public String adminAddTokenTo(String address, BigInteger value) {
        return "add token fallback!";
    }

    /**
     * 在某两个账户之间转移代币
     *
     * @param from
     * @param to
     * @param value
     */
    @Override
    public String adminTransfer(String from, String to, BigInteger value) {
        return "transfer token fallback!";
    }

    /**
     * 为某个用户设置代币的值
     *
     * @param who
     * @param value
     */
    @Override
    public String adminSetBalanceOf(String who, BigInteger value) {
        return "set balance fallback!";
    }

    /**
     * 发布项目
     *
     * @param publisher
     * @param publishTime
     * @param projectName
     * @param projectHash
     */
    @Override
    public String publishProject(String publisher, String publishTime, String projectName, String projectHash) {
        return "publish project fallback!";
    }

    /**
     * 购买项目
     *
     * @param buyer
     * @param buyTime
     * @param projectName
     * @param projectHash
     */
    @Override
    public String buyProject(String buyer, String buyTime, String projectName, String projectHash) {
        return "buy project fallback!";
    }

    /**
     * 发布需求
     *
     * @param publisher
     * @param publishTime
     * @param demandName
     * @param demandHash
     */
    @Override
    public String publishDemand(String publisher, String publishTime, String demandName, String demandHash) {
        return "publish demand fallback!";
    }

    /**
     * 回答需求
     *
     * @param answerer
     * @param answerTime
     * @param demandName
     * @param answerHash
     */
    @Override
    public String answerDemand(String answerer, String answerTime, String demandName, String answerHash) {
        return "answer demand fallback!";
    }

    /**
     * 创建账户
     *
     * @param password
     */
    @Override
    public String addUser(String password) {
        return "add user fallback!";
    }

    /**
     * 补充方法
     */
    @Override
    public String getContractAddress() {
        return "get contract address fallback!";
    }
}
