# 使用 OpenJDK 8 作为基础镜像
FROM openjdk:8

# 设置工作目录
WORKDIR /myServer

# 安装 Maven
RUN apt-get update && apt-get install -y maven

# 复制整个 coshop-gateway 项目到工作目录
# 这包括源代码、pom.xml 文件等
COPY . .

# 使用 Maven 构建应用
RUN mvn install -DskipTests

# # 假设 Maven 构建的输出 .jar 文件位于 target/ 目录下
# # 并且有一个明确的名字，如 coshop-gateway-4.0.0-SNAPSHOT.jar
# # 请确保.jar文件名与实际生成的文件名匹配
RUN cp target/coshop-gateway-4.0.0-SNAPSHOT.jar coshop-gateway.jar

# # 暴露应用需要的端口
EXPOSE 9527

# 运行构建好的 .jar 文件
ENTRYPOINT ["java","-jar","coshop-gateway.jar"]
