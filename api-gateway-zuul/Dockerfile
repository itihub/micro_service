# 设置基础镜像
FROM openjdk:8-jre
# 声明维护者
MAINTAINER jizhe@live.cn

COPY ./target/api-gateway-zuul-1.0-SNAPSHOT.jar /api-gateway-zuul.jar

ENV ACTIVE = "dev"
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=$ACTIVE", "/api-gateway-zuul.jar"]
