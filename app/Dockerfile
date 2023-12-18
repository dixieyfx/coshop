# 使用基础镜像
FROM node:18.4.0 AS builder

# set working directory
WORKDIR /app

# 安装依赖
COPY package*.json ./

RUN npm ci --only=production

# 复制应用程序代码到容器中
COPY . /app
EXPOSE 80

# 定义应用程序启动命令
CMD ["npm", "dev"]
