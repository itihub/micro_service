#!/usr/bin/env bash

# 1. 构建Docker镜像
docker build -t message-service:latest .

docker push message-service:latest
