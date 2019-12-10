FROM azul/zulu-openjdk:8

VOLUME /tmp

ADD sidecar_postgres-0.0.1-SNAPSHOT.jar /opt/poc-api/sidecar-postgres-demo.jar
RUN bash -c 'touch /opt/poc-api/sidecar-postgres-demo.jar'

ENV JAVA_TOOL_OPTIONS "-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["java", "-jar", "/opt/poc-api/sidecar-postgres-demo.jar"]
