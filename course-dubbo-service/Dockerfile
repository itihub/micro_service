# 设置基础镜像
FROM openjdk:8-jre
# 声明维护者
MAINTAINER jizhe@live.cn

WORKDIR /app
COPY ./target/course-dubbo-service-1.0-SNAPSHOT.jar /app/course-dubbo-service.jar
COPY ./target/application-dev.properties /app/application-dev.properties

ENTRYPOINT ["java", "-jar", "-Dspring.config.location=application-dev.properties", "/course-dubbo-service.jar"]