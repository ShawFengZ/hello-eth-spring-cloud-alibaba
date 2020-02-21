package com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service;

import com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service.fallback.BlockChainServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/26 12:23
 */
@Service
@FeignClient(value = "ethereum-provider", fallback = BlockChainServiceFallback.class)
public interface BlockChainService {

    /**
     * 获得某用户的币值
     * */
    @RequestMapping(value = "/blockchain/getbalance")
    public String getBalanceOf(String address);

    /**
     * 获得总的金额
     * */
    @RequestMapping(value = "/blockchain/totalsupply")
    public String totalSupply();

    /**
     * 从某个账户上删除代币
     * */
    @RequestMapping(value = "/blockchain/deletetokenfrom")
    public String adminDeleteTokenFrom(@RequestParam("address") String address, @RequestParam("value") BigInteger value);

    /**
     * 为某个账户添加代币
     * */
    @RequestMapping(value = "/blockchain/addtokento")
    public String adminAddTokenTo(@RequestParam("address") String address, @RequestParam("value") BigInteger value);

    /**
     * 在某两个账户之间转移代币
     * */
    @RequestMapping(value = "/blockchain/transfer")
    public String adminTransfer(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("value") BigInteger value);

    /**
     * 为某个用户设置代币的值
     * */
    @RequestMapping(value = "/blockchain/setbalanceof")
    public String adminSetBalanceOf(@RequestParam("who") String who, @RequestParam("value") BigInteger value);

    /**
     * 发布项目
     * */
    @RequestMapping(value = "/blockchain/publishproject")
    public String publishProject(@RequestParam(value = "publisher") String publisher, @RequestParam(value = "publichTime") String publishTime,
                                 @RequestParam(value = "projectName") String projectName, @RequestParam(value = "projectHash") String projectHash);

    /**
     * 购买项目
     * */
    @RequestMapping(value = "/blockchain/buyproject")
    public String buyProject(@RequestParam("buyer") String buyer, @RequestParam("buyTime") String buyTime,
                             @RequestParam("projectName") String projectName, @RequestParam(value = "projectHash") String projectHash);

    /**
     * 发布需求
     * */
    @RequestMapping(value = "/blockchain/publishdemand")
    public String publishDemand(@RequestParam("publisher") String publisher, @RequestParam("publishTime") String publishTime,
                                @RequestParam("demandName") String demandName, @RequestParam("demandHash") String demandHash);

    /**
     * 回答需求
     * */
    @RequestMapping(value = "/blockchain/answerdemand")
    public String answerDemand(@RequestParam("answerer") String answerer, @RequestParam("answerer") String answerTime,
                               @RequestParam("answerer") String demandName, @RequestParam("answerer") String answerHash);

    /**
     * 创建账户
     * */
    @RequestMapping(value = "/blockchain/adduser")
    public String addUser(String password);

    /**
     * 获取区块地址
     * */
    @RequestMapping(value = "/blockchain/getcontractaddress")
    public String getContractAddress();
}
