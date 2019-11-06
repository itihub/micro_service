# 设置基础镜像
FROM openjdk:8-jre
# 声明维护者
MAINTAINER jizhe@live.cn

COPY ./target/api-gateway-zuul-1.0-SNAPSHOT-prod.jar /api-gateway-zuul.jar
COPY ./target/application-prod.properties /application-prod.properties

ENTRYPOINT ["java", "-jar", "-Dspring.config.location=application-prod.properties", "/api-gateway-zuul.jar"]