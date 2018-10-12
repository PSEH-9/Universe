FROM java:8
RUN mkdir -p /workdir
COPY target/universe-0.0.1-SNAPSHOT.jar /work
WORKDIR /work
EXPOSE 8080
ENTRYPOINT java -jar universe-0.0.1-SNAPSHOT.jar