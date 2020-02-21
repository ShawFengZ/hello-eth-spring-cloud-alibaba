package com.zxf.hello.cloud.lb.entity;

public class GethServ {

    //服务得ip
    private String IP;
    //服务的端口号
    private String port;
    //容器的hashCode
    private String dockerHashCode;
    //服务目前的cpu占比状态
    private double cpu;
    //服务当前的内存占比状态
    private double mem;

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getMem() {
        return mem;
    }

    public void setMem(double mem) {
        this.mem = mem;
    }

    public String getDockerHashCode() {
        return dockerHashCode;
    }

    public void setDockerHashCode(String dockerHashCode) {
        this.dockerHashCode = dockerHashCode;
    }
}
