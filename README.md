**项目说明** 
- micro_service是一个微服务的实践Demo，微服务之间的通讯协议使用了 REST API、RPC
- RPC框架使用了 由 Facebook 开发的远程服务调用框架 Apache Thrift 以及 Dubbo
- 数据库使用MySQL 可以替换其他主流数据库
<br> 
<br>

**具有如下特点** 
- 友好的代码结构及注释，便于阅读及二次开发
- 。。。。
<br> 

**项目结构** 
```
micro_service
├─db  项目SQL语句
│
├─messages-thrift-python-service 有Python开发的信息服务，通讯使用thrift
│  └─messages 
│    └─api 
│  └─thrift
│
│
├─config 配置信息
│ 
├─modules 功能模块
│  ├─app API接口模块(APP调用)
│  ├─job 定时任务模块
│  ├─oss 文件服务模块
│  └─sys 权限模块
│ 
├─RenrenApplication 项目启动类
│  
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源

```
<br> 