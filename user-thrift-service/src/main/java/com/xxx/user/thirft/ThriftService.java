package com.xxx.user.thirft;

import com.xxx.thrift.user.UserService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Description: Thrift 服务器配置
 * @Author: Jimmy
 */
@Configuration
public class ThriftService {

    @Value("${service.port}")
    private Integer port;

    @Autowired
    private UserService.Iface userService;

    /**
     * @PostConstruct  加载Servlet时运行 只会调用一次
     * @PreDestroy      卸载Servlet时运行 只会调用一次
     */
    @PostConstruct
    public void startThriftService(){
        TProcessor processor = new UserService.Processor<>(userService);
        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(port);
        } catch (TTransportException e) {
            TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
            args.processor(processor);
            //传输 非阻塞
            args.transportFactory(new TFastFramedTransport.Factory());
            //通讯协议 二进制
            args.protocolFactory(new TBinaryProtocol.Factory());
            //服务器类型 多线程服务器端使用非阻塞式 I/O
            TServer server = new TNonblockingServer(args);
            server.serve();
        }
    }

}
