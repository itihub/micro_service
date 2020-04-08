# 设置基础镜像
FROM openjdk:8-jre
# 声明维护者
MAINTAINER jizhe@live.cn

WORKDIR /app
COPY ./target/course-dubbo-service-1.0-SNAPSHOT.jar /app/course-dubbo-service.jar
COPY ./target/application-prod.properties /app/application-prod.properties

ENTRYPOINT ["java", "-jar", "-Dspring.config.location=application-prod.properties", "/app/course-dubbo-service.jar"]
