#!/usr/bin/env bash

#重新构建docker镜像脚本

# 1.Maven打包
mvn clean package -Dmaven.test.skip=true

# 2.拷贝Spring配文件
cp ./src/main/resources/application-prod.properties ./target/application-prod.properties

#3. 构建Docker镜像
docker build -t user-thrift-service:latest .
