FROM java:8
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar homework_system.jar
RUN bash -c "touch /homework_system.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","homework_system.jar"]