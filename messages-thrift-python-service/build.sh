#!/usr/bin/env bash

#1. 构建Docker镜像
#docker build -t messages-service:latest .
docker build -t reg.harbor.com/mircro-service/messages-service:latest .

#2. 推送镜像到harbor仓库
docker push reg.harbor.com/mircro-service/messages-service:latest
