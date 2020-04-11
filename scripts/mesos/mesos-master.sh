#！/bin/bash

docker run -d --net=host \
  --hostname=192.168.137.213 \
  -e MESOS_PORT=5050 \
  -e MESOS_ZK=zk://192.168.100.165:2181/mesos \
  -e MESOS_QUORUM=1 \
  -e MESOS_REGISTRY=in_memory \
  -e MESOS_LOG_DIR=/var/log/mesos \
  -e MESOS_WORK_DIR=/var/tmp/mesos \
  -v "$(pwd)/log/mesos:/var/log/mesos" \
  -v "$(pwd)/tmp/mesos:/var/tmp/mesos" \
  mesosphere/mesos-master:1.6.2 --no-hostname_lookup --ip=192.168.137.213

 # 参数解释
 # --hostname=192.168.137.1 声明主机名称，避免向zk注册时使用127.0.0.1地址注册
 # -e MESOS_QUORUM=1 根据Salve节点数量配置 计算公式:N/2+1