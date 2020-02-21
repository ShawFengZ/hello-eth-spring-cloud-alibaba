package com.zxf.hello.spring.cloud.eth.write.provider.service.impl;

import com.zxf.hello.spring.cloud.eth.write.provider.generated.DevToken;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import com.zxf.hello.spring.cloud.eth.write.provider.service.BlockChainService;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:16
 */
@Service
public class BlockChainServiceImpl implements BlockChainService {

    private Admin web3;

    private Credentials credentials;

    private DevToken contract;

    private Configuration config = new PropertiesConfiguration("blockChain.properties");

    /**
     * 此方法获取合约
     * */
    public BlockChainServiceImpl() throws ConfigurationException {
        web3 = Admin.build(new HttpService(config.getString("web3j.url")));

        try {
            credentials = WalletUtils.loadCredentials(
                    config.getString("owner.password"),
                    config.getString("owner.keyfile"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }

        String address = credentials.getAddress();
        contract = DevToken.load(config.getString("contract.address"),
                web3,credentials,
                new BigInteger(config.getString("gas.price")),
                new BigInteger(config.getString("gas.limit")));
    }

    /**
     * 获取某用户的币值
     *
     * @param address
     */
    @Override
    public BigInteger getBalanceOf(String address) throws Exception {
        return contract.balanceOf(address).send();
    }

    /**
     * 获取总共
     */
    @Override
    public BigInteger totalSupply() throws Exception {
        return contract.totalSupply().send();
    }

    /**
     * 删除某用户的代币
     *
     * @param from
     * @param value
     */
    @Override
    public String adminDeleteTokenFrom(String from, BigInteger value) throws Exception {
        TransactionReceipt receipt = contract.adminDeleteTokenFrom(from, value).send();
        if (receipt != null)
            return receipt.getTransactionHash();
        return null;
    }

    /**
     * 为某用户添加代币
     *
     * @param to
     * @param value
     */
    @Override
    public String adminAddTokenTo(String to, BigInteger value) throws Exception {
        return contract.adminAddTokenTo(to, value).send().getTransactionHash();
    }

    /**
     * 转移代币
     *
     * @param from
     * @param to
     * @param value
     */
    @Override
    public String adminTransfer(String from, String to, BigInteger value) throws Exception {
        return contract.adminTransfer(from, to, value).send().getTransactionHash();
    }

    /**
     * 为某用户设置代币有多少
     *
     * @param who
     * @param value
     */
    @Override
    public String adminSetBalanceOf(String who, BigInteger value) throws Exception {
        return contract.adminSetBalanceOf(who, value).send().getTransactionHash();
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
    public String publishProject(String publisher, String publishTime, String projectName, String projectHash) throws Exception {
        TransactionReceipt receipt = contract.publishProject(publisher, publishTime, projectName, projectHash).send();
        if (receipt != null)
            return receipt.getTransactionHash();
        return null;
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
    public String buyProject(String buyer, String buyTime, String projectName, String projectHash) throws Exception {
        return contract.buyProject(buyer, buyTime, projectName, projectHash).send().getTransactionHash();
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
    public String publishDemand(String publisher, String publishTime, String demandName, String demandHash) throws Exception {
        return contract.publishDemand(publisher, publishTime, demandName, demandHash).send().getTransactionHash();
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
    public String answerDemand(String answerer, String answerTime, String demandName, String answerHash) throws Exception {
        return contract.answerDemand(answerer, answerTime, demandName, answerHash).send().getTransactionHash();
    }

    /**
     * 创建账户
     *
     * @param password
     */
    @Override
    public String addUser(String password) throws IOException {
        return web3.personalNewAccount(password).send().getAccountId();
    }

    /* ================================ 补充方法 获取合约地址======================================= */
    @Override
    public String getContractAddress() throws Exception {
        //1.
        /*TransactionReceipt transactionReceipt = contract.PEToken().send();
        //2.
        String name = contract.name().send();
        //3.
        String owner = contract.owner().send();
        //4.
        String symbol = contract.symbol().send();*/

        return contract.getContractAddress();
    }


}