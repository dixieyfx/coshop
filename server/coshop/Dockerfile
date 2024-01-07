# 基础镜像
FROM openjdk:8 as builder

# 安装 Maven
RUN apt-get update && apt-get install -y maven

# 设置工作目录
WORKDIR /myCoshop

# 首先构建最外层 coshop
COPY pom.xml pom.xml
COPY coshop-api coshop-api
COPY coshop-gateway coshop-gateway
COPY coshop-core coshop-core

# 构建 coshop-api
RUN mvn package -DskipTests

# RUN mvn package -DskipTests

# 以下是运行阶段
FROM openjdk:8

COPY --from=builder /myCoshop/coshop-gateway/target/*.jar /coshop-gateway.jar
COPY --from=builder /myCoshop/coshop-core/target/*.jar /coshop-core.jar


# 暴露所需端口（根据具体需求调整）
EXPOSE 8080 8081

# 运行命令（根据实际情况调整）
CMD ["java", "-jar", "coshop-gateway.jar"]
