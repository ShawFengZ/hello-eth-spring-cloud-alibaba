package com.zxf.hello.spring.cloud.eth.read.provider.service.impl;

import com.zxf.hello.spring.cloud.eth.read.provider.service.AdminManageService;
import org.springframework.stereotype.Service;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zxf
 * @date 2019/2/25 15:11
 */
@Service
public class AdminManageServiceImpl implements AdminManageService {

    Admin web3j = Admin.build(new HttpService("http:192.168.198.141:8545"));

    /**
     * 获取账号列表
     */
    @Override
    public List<String> personalListAccounts() throws IOException, ExecutionException, InterruptedException {
       // PersonalListAccounts listAccounts = web3j.personalListAccounts().send();
        CompletableFuture<PersonalListAccounts> personalListAccountsCompletableFuture = web3j.personalListAccounts().sendAsync();
        //web3j.shutdown();
        return personalListAccountsCompletableFuture.get().getAccountIds();
    }

    /**
     * 创建新账户
     *
     * @param password
     */
    @Override
    public String personalNewAccount(String password) throws IOException {
        CompletableFuture<NewAccountIdentifier> newAccountIdentifierCompletableFuture = web3j.personalNewAccount(password).sendAsync();
        if (newAccountIdentifierCompletableFuture != null)
            return newAccountIdentifierCompletableFuture.toString();
        return null;
    }

    /**
     * 解锁账户
     *
     * @param address
     * @param passphrase
     */
    @Override
    public Boolean personalUnlockAccount(String address, String passphrase) throws IOException, ExecutionException, InterruptedException {
        //PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(address, passphrase).sendAsync();
        CompletableFuture<PersonalUnlockAccount> personalUnlockAccountCompletableFuture = web3j.personalUnlockAccount(address, passphrase).sendAsync();
        web3j.shutdown();
        Boolean aBoolean = personalUnlockAccountCompletableFuture.get().accountUnlocked();
        return aBoolean;
    }

    /**
     * 解锁账户
     *
     * @param address
     * @param passphrase
     * @param duration
     */
    @Override
    public Boolean personalUnlockAccount(String address, String passphrase, BigInteger duration) throws IOException {
        PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(address, passphrase, duration).send();
        if (personalUnlockAccount != null)
            return personalUnlockAccount.accountUnlocked();
        return null;
    }

    /**
     * 发送交易
     *
     * @param transaction
     * @param password
     */
    @Override
    public String personalSendTransaction(Transaction transaction, String password) throws IOException {
        EthSendTransaction ethSendTransaction = web3j.personalSendTransaction(transaction, password).send();
        if (ethSendTransaction != null)
            return ethSendTransaction.getTransactionHash();
        return null;
    }
}
