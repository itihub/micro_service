# 设置基础镜像
FROM openjdk:8-jre
# 声明维护者
MAINTAINER jizhe@live.cn

COPY ./target/user-edge-service-1.0-SNAPSHOT-prod.jar /user-edge-service.jar

ENTRYPOINT ["java", "-jar", "-Dspring.config.location=application-prod.properties", "/user-edge-service.jar"]