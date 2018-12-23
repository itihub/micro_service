package com.xxx.user.thrift;

import com.xxx.thrift.messages.MessagesService;
import com.xxx.thrift.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 服务供应商配置
 * @Author: Jimmy
 */
@Slf4j
@Component
public class ServiceProvider {

    /**服务ip*/
    @Value("${thrift.user.service.ip}")
    private String serviceIp;

    /**服务端口*/
    @Value("${thrift.user.service.port}")
    private Integer servicePort;

    /**服务超时时间*/
    @Value("${thrift.user.service.timeout}")
    private Integer timeout = 3000;

    /**服务ip*/
    @Value("${thrift.messages.service.ip}")
    private String messagesServiceIp;

    /**服务端口*/
    @Value("${thrift.messages.service.port}")
    private Integer messagesServicePort;

    /**服务超时时间*/
    @Value("${thrift.messages.service.timeout}")
    private Integer messagesTimeout = 3000;

    private enum ServiceType{
        USER,
        MESSAGE,
    }

    /**
     * 获取UserServiceThrift服务客户端
     * @return
     */
    public UserService.Client getUserService(){

        return getService(serviceIp, servicePort, timeout, ServiceType.USER);
    }

    public MessagesService.Client getMessageService(){

        return getService(messagesServiceIp, messagesServicePort, messagesTimeout, ServiceType.MESSAGE);
    }

    private <T> T getService(String ip, Integer port, Integer timeout, ServiceType type){


        TSocket socket = new TSocket(serviceIp, servicePort, timeout);
        TTransport tTransport = new TFastFramedTransport(socket);
        try {
            tTransport.open();
        } catch (TTransportException e) {
            log.error("【user Thrift 连接失败 】", e);
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(tTransport);
        TServiceClient client = null;
        switch (type){
            case USER:
                client = new UserService.Client(protocol);
                break;
            case MESSAGE:
                client = new MessagesService.Client(protocol);
                break;
        }
        return (T) client;
    }
}
