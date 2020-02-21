package com.zxf.hello.cloud.lb.utils;

import com.zxf.hello.cloud.lb.entity.GethServ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GethSrvRecovery {

    public void recoverSrvs(List<GethServ> recoverList) throws IOException {
        List<String> commands = new ArrayList<>();
        for (int i=0; i<recoverList.size(); i++) {
            GethServ gethServ = recoverList.get(i);
            commands.add("docker restart " + gethServ.getDockerHashCode());
        }
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        // 启动进程
        Process process = processBuilder.start();
        // 解析输出
        String result = convertStreamToStr(process.getInputStream());
        System.out.println(result);
    }

    private String convertStreamToStr(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}
