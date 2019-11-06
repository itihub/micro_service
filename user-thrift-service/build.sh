#!/usr/bin/env bash

#重新构建docker镜像脚本
mvn clean package -Dmaven.test.skip=true -Pprod

cp ./src/main/resources/application-dev.properties ./target/application-dev.properties

docker build -t user-thrift-service:latest .