package com.zxf.hello.spring.cloud.eth.write.provider.common;

import okhttp3.OkHttpClient;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.TimeUnit;

/**
 * @author zxf
 * @date 2019/2/28 13:43
 */
public class HttpServiceEx extends HttpService {


    private static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS);
        //configureLogging(builder);
        return builder.build();
    }

}
