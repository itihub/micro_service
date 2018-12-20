#!/usr/bin/env bash
thrift --gen py --out ../ messages.thrift

thrift --gen java --out ../../messages-thrift-service-api-java/src/main/java messages.thrift