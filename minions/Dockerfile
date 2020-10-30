FROM maven:3.6.3-adoptopenjdk-11 as BUILDMINION

COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp
RUN mvn -f /usr/src/myapp/pom.xml clean package -DskipTests

FROM openjdk:11-jdk-slim

COPY --from=BUILDMINION /usr/src/myapp/target/*.jar /maven/

CMD java $JAVA_OPTS -jar maven/*.jar