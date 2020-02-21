package com.zxf.hello.spring.cloud.eth.write.provider.controller;

import com.zxf.hello.spring.cloud.eth.write.provider.common.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zxf.hello.spring.cloud.eth.write.provider.service.AdminManageService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zxf
 * @date 2019/2/25 15:29
 */
@Controller
@ResponseBody
@RequestMapping(value = "/admin")
public class AdminManageController {

    @Autowired
    private AdminManageService adminManageService;

    private static String STATUS_MESSAGE_FAIL = "FAIL";

    /**
     * 获取全部账户
     * */
    @RequestMapping(value = "/listaccounts")
    public BaseResult personalListAccounts() throws IOException, ExecutionException, InterruptedException {
        List<String> personalListAccounts = adminManageService.personalListAccounts();
        String message = "";
        if (personalListAccounts != null) {
            for (String s: personalListAccounts) {
                message += s + " ";
            }
            return BaseResult.success(message);
        }
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    /**
     * 创建一个新账户
     * */
    @RequestMapping(value = "/newaccount/{password}")
    public BaseResult personalNewAccount(@PathVariable(value = "password") String password) throws IOException {
        String newAccount = adminManageService.personalNewAccount(password);
        if (newAccount != null)
            return BaseResult.success(newAccount);
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

    /**
     * 解锁一个账户
     * */
    @RequestMapping(value = "/unlockaccount/{address}/{password}")
    public BaseResult personalUnlockAccount(@PathVariable(value = "address") String address,
                                            @PathVariable(value = "password") String password) throws IOException, ExecutionException, InterruptedException {
        Boolean unlocked = adminManageService.personalUnlockAccount(address, password);
        if (unlocked != null) {
            return BaseResult.success(unlocked.toString());
        }
        return BaseResult.fail(STATUS_MESSAGE_FAIL);
    }

}
