package com.zxf.hello.spring.cloud.ethereum.provider.controller;

import com.zxf.hello.spring.cloud.ethereum.provider.common.BaseResult;
import com.zxf.hello.spring.cloud.ethereum.provider.service.EthConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * @author zxf
 * @date 2019/2/25 15:42
 */
@Controller
@RequestMapping(value = "/connect")
@ResponseBody
public class ConnectController {

    @Autowired
    private EthConnectService ethConnectService;

    private static String STATUS_MESSAGE_FAIL = "FAIL";

    /**
     * 获取账户的以太币值
     * */
    @RequestMapping(value = "/getbalance")
    public BaseResult getConnect() throws IOException {
        String address = "0x007ccffb7916f37f7aeef05e8096ecfbe55afc2f";
        BigInteger balance = ethConnectService.getBalance(address);
        if (balance != null)
            return BaseResult.success(balance.toString());
        else
            return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    /**
     * 获得主账号
     * */
    @RequestMapping(value = "/getethbase")
    public BaseResult getEthCoinbase() throws IOException {
        String ethCoinbase = ethConnectService.getEthCoinbase();
        if (ethCoinbase != null)
            return BaseResult.success(ethCoinbase);
        else
            return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getblocknumber")
    public BaseResult getBlockNumber() throws IOException {
        String blockNumber = ethConnectService.getBlockNumber();
        if (blockNumber != null)
            return BaseResult.success(blockNumber.toString());
        else
            return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getnetlistening")
    public BaseResult getNetListening() throws IOException {
        Boolean netListening = ethConnectService.getNetListening();
        if (netListening != null)
            return BaseResult.success(netListening.toString());
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getpeercount")
    public BaseResult getPeerCount() throws IOException {
        BigInteger peerCount = ethConnectService.getPeerCount();
        if (peerCount != null)
            return BaseResult.success(peerCount.toString());
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getethming")
    public BaseResult getEthMining() throws IOException {
        Boolean ethMining = ethConnectService.getEthMining();
        if (ethMining != null)
            return BaseResult.success(ethMining.toString());
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getethhashrate")
    public BaseResult getEthHashrate() throws IOException {
        BigInteger ethHashrate = ethConnectService.getEthHashrate();
        if (ethHashrate != null)
            return BaseResult.success(ethHashrate.toString());
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getethgasprice")
    public BaseResult getEthGasPrice() throws IOException {
        BigInteger ethGasPrice = ethConnectService.getEthGasPrice();
        if (ethGasPrice != null)
            return BaseResult.success(ethGasPrice.toString());
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    @RequestMapping(value = "/getethaccounts")
    public BaseResult getEthAccounts() throws IOException {
        List<String> ethAccounts = ethConnectService.getEthAccounts();
        String message = "";
        if (ethAccounts != null) {
            for (String s: ethAccounts) {
                message += s + " ";
            }
            return BaseResult.success(message);
        }
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }
}
