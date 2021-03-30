FROM openjdk:11-jdk-slim

RUN mkdir -p /app/bin /app/log

COPY target/slot-machine-1.0.0.jar /app/bin/slot-machine.jar

RUN chgrp -R 0 /app && \
    chmod -R g+rwX /app

EXPOSE 8080 8081

ENV JAVA_OPTS="-server -Xms1g -Xmx1g -XX:MaxMetaspaceSize=256m -verbose:gc"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app/bin/slot-machine.jar" ]