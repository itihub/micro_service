#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -Pprod

cp ./src/main/resources/application-local.properties ./target/application-local.properties

docker build -t course-edge-service:latest .