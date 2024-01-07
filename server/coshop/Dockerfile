# 基础镜像
FROM openjdk:8 as builder

# 安装 Maven
RUN apt-get update && apt-get install -y maven

# 设置工作目录
WORKDIR /coshop

# 首先构建最外层 coshop
# 复制 coshop-api 项目文件
COPY coshop/pom.xml coshop/pom.xml
# 构建 coshop-api
RUN cd coshop && mvn install -DskipTests

# 首先构建 coshop-api
# 复制 coshop-api 项目文件
COPY coshop-api/pom.xml coshop-api/pom.xml
COPY coshop-api/src coshop-api/src
# 构建 coshop-api
RUN cd coshop-api && mvn install -DskipTests

# 接下来构建 coshop-gateway
# 复制 coshop-gateway 项目文件
COPY coshop-gateway/pom.xml coshop-gateway/pom.xml
COPY coshop-gateway/src coshop-gateway/src
# 构建 coshop-gateway
RUN cd coshop-gateway && mvn install -DskipTests

# 最后构建 coshop-core
# 复制 coshop-core 项目文件
COPY coshop-core/pom.xml coshop-core/pom.xml
COPY coshop-core/src coshop-core/src
# 构建 coshop-core
RUN cd coshop-core && mvn install -DskipTests

# 以下是运行阶段
FROM openjdk:8
WORKDIR /app

# 从构建阶段复制 coshop-gateway 的运行文件
COPY --from=builder /coshop/coshop-gateway/target/*.jar ./coshop-gateway.jar
# 从构建阶段复制 coshop-core 的运行文件
COPY --from=builder /coshop/coshop-core/target/*.jar ./coshop-core.jar

# 暴露所需端口（根据具体需求调整）
EXPOSE 8080 8081

# 运行命令（根据实际情况调整）
CMD ["java", "-jar", "coshop-gateway.jar"]
