FROM registry.access.redhat.com/ubi8/openjdk-11:1.11

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

COPY --chown=185 target/*jar-with-dependencies*.jar /deployments/

EXPOSE 2222
USER 1001

ENV JAVA_APP_JAR="/deployments/fake-sftp-server-0.3.0-SNAPSHOT-jar-with-dependencies.jar"
