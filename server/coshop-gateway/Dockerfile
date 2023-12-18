FROM openjdk:8
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./coshop-gateway-4.0.0-SNAPSHOT.jar ./coshop-gateway.jar
EXPOSE 9527
ENTRYPOINT ["java","-jar"]
CMD ["coshop-gateway.jar"]