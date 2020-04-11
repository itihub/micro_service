
# micro_service poc  


##项目说明  
- micro_service是一个异构微服务的实践Demo，服务编排的POC。微服务之间的通讯协议使用了 REST API、RPC
- RPC框架使用了 由 Facebook 开发的远程服务调用框架 Apache Thrift 以及 Dubbo
- 数据库使用MySQL 可以替换其他主流数据库
 
###具有如下特点   
- 友好的代码结构及注释，便于阅读及二次开发
- 多语言开发服务以及服务之间互相调用

###项目结构  
```
micro_service
├─api-gateway-zuul                  API网关
├─course-dubbo-service              course dubbo provider
├─course-dubbo-service-api          course dubbo 服务接口
├─course-edge-service               course consumer
├─messages-thrift-python-service    messages 邮件通知 python开发
├─messages-thrift-service-api-java  messages 服务接口
├─user-edge-service                 user thrift consumer
├─user-edge-service-client          user 权限认证客户端
├─user-thrift-service               user thrift provider
└─user-thrift-service-api           user 服务接口
├─scripts                           项目脚本
├─docker-compose                    多容器部署
```  

## Development  
### 准备工作
+ 本地运行与开发需要以下组件：  
    + Java 1.8+
    + Python 3.X  
    + Mysql  
    + Redis  
    + thrift  
    + zookeeper（可选）  
+  IntelliJ IDEA 插件安装  
    + lombok  
    + BashSupport  
    + Thrift Support  
    + Python  

## 服务编排  
### 准备工作  
+ Docker Engine  
+ Harbor Docker镜像仓库   

