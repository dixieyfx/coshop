# 阶段 1: 构建
# 使用 Node.js 镜像构建 Vue 应用
FROM node:18 as build-stage

# 设置工作目录
WORKDIR /app

# 复制 package.json 和 package-lock.json
COPY package*.json ./

# 安装项目依赖
RUN npm install

# 复制项目文件和文件夹到工作目录
COPY . .

# 构建应用
RUN npm run build

# 阶段 2: 部署
# 使用 Nginx 镜像部署 Vue 应用
FROM nginx:stable-alpine as production-stage

# 从构建阶段复制构建的文件到 Nginx 服务的目录
COPY --from=build-stage /app/dist /usr/share/nginx/html

# 暴露 80 端口
EXPOSE 80

# 当容器启动时运行 Nginx
CMD ["nginx", "-g", "daemon off;"]
