FROM eclipse-temurin:23-jdk

LABEL MAINTAINER="maziyyah"
LABEL description="This is VTTP5 SSF day 11 workshop"
LABEL name="day11-workshop"

ARG APP_DIR=/APP

WORKDIR ${APP_DIR}

COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY src src
COPY .mvn .mvn

RUN chmod a+x ./mvnw && ./mvnw clean package -Dmaven.test.skip=true

ENV SERVER_PORT=8085

EXPOSE ${SERVER_PORT}

CMD ./mvnw spring-boot:run
