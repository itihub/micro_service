#!/usr/bin/env bash

# 构建带有thrift模块的Pyhton基础镜像
docker build -t python-base:latest -f Dockerfile.base .
