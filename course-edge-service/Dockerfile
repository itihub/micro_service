# 设置基础镜像
FROM openjdk:8-jre
# 声明维护者
MAINTAINER jizhe@live.cn

COPY ./target/course-edge-service-1.0-SNAPSHOT-prod.jar /course-edge-service.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/course-edge-service.jar"]
