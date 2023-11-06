FROM registry.access.redhat.com/ubi8/openjdk-11

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'
ENV AB_JOLOKIA_OFF=true

COPY --chown=185 target/*jar-with-dependencies*.jar /deployments/

EXPOSE 2222
USER 185

ENV JAVA_APP_JAR="/deployments/fake-sftp-server-0.5.0-SNAPSHOT-jar-with-dependencies.jar"
