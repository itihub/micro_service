#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

cp ./src/main/resources/application-dev.properties ./target/application-dev.properties

docker build -t user-service:latest .