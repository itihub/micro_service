#!/bin/bash

docker run -d --net=host \
    -e PORTS=9090 \
    mesosphere/marathon-lb:v1.14.2 sse --marathon http://192.168.137.20:8080 --group external

#docker run -d  \
#    -p 9090:9090 \
#    -e PORTS=9090 \
#    mesosphere/marathon-lb:v1.14.2 sse --group external --marathon http://192.168.137.20:8080

# 参数解释
# --net=host 使用host网络模式
# sse 参数 获取状态通知
# --group external 集群名称
# --marathon http://192.168.137.20:8080 marathon节点配置