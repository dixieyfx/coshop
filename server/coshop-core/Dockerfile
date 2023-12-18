FROM openjdk:8
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./coshop-core-4.0.0-SNAPSHOT.jar ./coshop-core.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar"]
CMD ["coshop-core.jar"]