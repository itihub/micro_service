
# Mesos 编排指南  

## 搭建Mesos环境  

### 物料准备  
1. 服务器与IP规划：  
   + node1 Mesos Master  Marathon Marathon-lb  
       - DIP(内网IP):192.168.137.100  
   + node2 Mesos Slave  
        - DIP(内网IP):192.168.137.101  
   + node3 Nginx Slave  
        - DIP(内网IP):192.168.137.102  
   + zookeeper  
2. 部署步骤  
    1. node1 节点部署Mesos Master [部署脚本](./mesos-master.sh)  
    2. node2 node3 部署Mesos Slave [部署脚本](./mesos-slave.sh)  
    3. node1 节点部署Marathon [部署脚本](./marathon.sh)  
    4. node1 节点部署Marathon-lb [部署脚本](./marathon-lb.sh)   
3. 访问地址  
    + Mesos URL : node1:5050  
    + Marathon URL : node1:8080  
    + Marathon-lb URL : node:9090

## Mesos 编排  
## Marathon lb 端口映射  
+ thrift.user.service=10001  
+ thrift.messages.service=10002    
+ user.edge.service=10003  
+ course.edge.service=10004  
+ api.gateway=10005  
