#!/usr/bin/env bash

# 构建带有thrift模块的Pyhton基础镜像
#docker build -t python-base:latest -f Dockerfile.base .
docker build -t reg.harbor.com/mircro-service/python-base:latest -f Dockerfile.base .

# 推送镜像到harbor仓库
docker push reg.harbor.com/mircro-service/python-base:latest
