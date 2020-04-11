#!/bin/bash

docker run -d --net=host \
  mesosphere/marathon:v1.8.244 \
  --master zk://192.168.137.165:2181/mesos \
  --zk zk://192.168.137.201:2181/marathon