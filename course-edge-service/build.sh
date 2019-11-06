#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -Pprod

cp ./src/main/resources/application-prod.properties ./target/application-prod.properties

docker build -t course-edge-service:latest .