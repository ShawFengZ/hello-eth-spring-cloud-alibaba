package com.zxf.hello.spring.cloud.ethereum.provider.service;

import org.web3j.protocol.core.methods.request.Transaction;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zxf
 * @date 2019/2/25 15:09
 */
public interface AdminManageService {

    /**
     * 获取账号列表
     * */
    public List<String> personalListAccounts() throws IOException, ExecutionException, InterruptedException;

    /**
     * 创建新账户
     * */
    public String personalNewAccount(String password) throws IOException;

    /**
     * 解锁账户
     * */
    public Boolean personalUnlockAccount(String address, String passphrase) throws IOException, ExecutionException, InterruptedException;

    /**
     * 解锁账户
     * */
    public Boolean personalUnlockAccount(String address, String passphrase, BigInteger duration) throws IOException;


    /**
     * 发送交易
     * */
    public String personalSendTransaction(Transaction transaction, String password) throws IOException;

}
