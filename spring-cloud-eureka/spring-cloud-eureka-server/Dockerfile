FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD ./target/spring-cloud-eureka-server.jar app.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/ ./urandom", "Dspring.profiles.active=docker", "-jar", "/app.jar"]
EXPOSE 8759