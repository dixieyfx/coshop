# 假设你已经在 server/coshop-gateway 目录中
FROM openjdk:8

WORKDIR /myServer

# 从当前构建上下文的 target 目录复制 .jar 文件到容器内的工作目录
COPY target/coshop-gateway-4.0.0-SNAPSHOT.jar coshop-gateway.jar

EXPOSE 9527
ENTRYPOINT ["java","-jar","coshop-gateway.jar"]
