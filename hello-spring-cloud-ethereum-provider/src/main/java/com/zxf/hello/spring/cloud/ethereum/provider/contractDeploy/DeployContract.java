package com.zxf.hello.spring.cloud.ethereum.provider.contractDeploy;

import com.zxf.hello.spring.cloud.ethereum.provider.generated.DevToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:08
 */
@Controller
public class DeployContract {
    //创建Web3j的连接
    Web3j web3j = Web3j.build(new HttpService("http:192.168.198.141:8545"));

    //部署的时候需要用到该账户的gas,无比保证该账户余额充足
    Credentials credentials;

    @RequestMapping(value = "/deploy")
    @ResponseBody
    public String deployDevToken() throws Exception {

        credentials = WalletUtils.loadCredentials(
                "123456",
                "D:/Sol/keystore/UTC--2019-04-08T06-49-39.830734661Z--53d19c95c04c76b5b32e29926ca9b16ed70e60f2"
        );
        DevToken devToken = DevToken.deploy(web3j, credentials, BigInteger.valueOf(200000), BigInteger.valueOf(2000000)).send();
        System.out.println(devToken.getContractAddress());
        return devToken.getContractAddress();
    }
}
