#！/bin/bash

docker run -d --net=host --privileged \
  --hostname=192.168.137.1 \
  -e MESOS_PORT=5051 \
  -e MESOS_MASTER=zk://192.168.137.165:2181/mesos \
  -e MESOS_SWITCH_USER=0 \
  -e MESOS_CONTAINERIZERS=docker,mesos \
  -e MESOS_LOG_DIR=/var/log/mesos \
  -e MESOS_WORK_DIR=/var/tmp/mesos \
  -v "$(pwd)/log/mesos:/var/log/mesos" \
  -v "$(pwd)/tmp/mesos:/var/tmp/mesos" \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v /sys:/sys \
  -v /usr/local/bin/docker:/usr/local/bin/docker \
  mesosphere/mesos-slave:1.6.2 --no-systemd_enable_support --no-hostname_lookup --ip=192.168.137.100


  # 参数解释
  # --hostname=192.168.137.1 声明主机名称，避免向zk注册时使用127.0.0.1地址注册
  # -e MESOS_CONTAINERIZERS=docker,mesos 支持docker容器或mesos容器
  # -v /var/run/docker.sock:/var/run/docker.sock docker容器调用docker功能
  # -v /usr/local/bin/docker:/usr/local/bin/docker docker安装位置（which docker 查看docker路径）