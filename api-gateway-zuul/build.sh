#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

cp ./src/main/resources/application-prod.properties ./target/application-prod.properties

docker build -t api-gateway-zuul:latest .