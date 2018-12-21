**项目说明** 
- micro_service是一个微服务的实践Demo，微服务之间的通讯协议使用了 REST API、RPC
- RPC框架使用了 由 Facebook 开发的远程服务调用框架 Apache Thrift 以及 Dubbo
- 数据库使用MySQL 可以替换其他主流数据库
<br> 
<br>

***IntelliJ IDEA 插件安装***
- lombok
- BashSupport
- Thrift Support
- Python

**具有如下特点** 
- 友好的代码结构及注释，便于阅读及二次开发
- 多语言开发服务以及服务之间互相调用
<br> 

**项目结构** 
```
micro_service
├─db  项目SQL语句
│
├─messages-thrift-python-service 信息服务(Python开发，通讯使用Thrift)
│  └─messages 
│    └─api 
│  └─thrift
│
│─messages-thrift-service-api-java 信息服务JavaRPC接口
│
├─user-edge-server 用户服务模块(Rest API)
│  ├─
│  ├─
│  └─
│
│ 
├─user-thrift-service 用户服务模块(Java开发，通讯协议Thrift)
│  ├─mapper 持久层
│  ├─service 业务逻辑层
│  └─thrift thrift服务启动配置
│
│
├─user-thritf-service-api 用户服务JavaRPC接口
│ 
│  
├──pom.xml 
│  

```
<br> 