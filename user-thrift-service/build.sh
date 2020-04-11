#!/usr/bin/env bash

#重新构建docker镜像脚本

# 1.Maven打包
mvn clean package -Dmaven.test.skip=true

# 2.拷贝Spring配文件
cp ./src/main/resources/application-prod.properties ./target/application-prod.properties

#3. 构建Docker镜像 PS:以下有远程仓库和本地构建命令
#docker build -t user-service:latest .
docker build -t reg.harbor.com/micro-service/user-service:latest .

#4. 推送镜像到harbor仓库
docker push reg.harbor.com/micro-service/user-service:latest
